package com.pyk.controller;


import com.pyk.model.PageBean;
import com.pyk.model.User;
import com.pyk.service.UserService;
import com.pyk.util.Tool;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 彭义凯 on 2019/11/30.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/getLogin")
    public String getLogin(){
        return "login";
    }


    @RequestMapping("/login")
    public String login( User user ,HttpSession session, RedirectAttributes attributes){
        System.out.println(user);
        User u = userService.login(user);
        if(u != null){
            u.setPassword(null);
            session.setAttribute("user",u);
            return "redirect:/getBackNews";
        }else{
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/getLogin";
        }

    }

    @RequestMapping("/getAddUser")
    public String getAddUser(){
        return "back_addUser";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String getAddUser(@RequestParam(value = "avatar") MultipartFile file , HttpServletRequest request,
                             @RequestParam(value = "username") String username,@RequestParam(value = "password") String password,
                             @RequestParam(value ="nickname") String nickname ,@RequestParam(value = "email") String email,
                             @RequestParam(value = "phone") String phone,RedirectAttributes attributes){
        if(file.isEmpty()){
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename(); //文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "D:/JAVAdexuexi/image/"; //上传的路径
        fileName = UUID.randomUUID() + suffixName; //新文件名
        File dest = new File(filePath + fileName) ;
        if( !dest.getParentFile().exists() ){
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        }catch (IOException e){
            e.printStackTrace();
        }
        String filename = "/JAVAdexuexi/image/" + fileName;
        User user = new User(nickname,password,email,filename,new Date(),username);
        user.setPhone(phone);
        System.out.println(user);
        String msg = "添加失败";
        int addCount = userService.addUser(user);
        if(addCount>0){
            msg = "添加成功";
        }
        attributes.addFlashAttribute("message",msg);
        return "redirect:/showUser";
    }

    @RequestMapping("/showUser")
    public String getShowUser(HttpServletRequest request, Model model){
        int pageCode = Tool.getPageCode(request);
        int pageSize = 4;
        List<User> users = userService.findUserAllByPage(pageCode-1,pageSize);
        System.out.println("users为"+users);
        PageBean<User> pages = new PageBean<>();
        pages.setBeanList(users);
        pages.setPageCode(pageCode);
        pages.setPageSize(pageSize);
        pages.setTotalCount(userService.findTotalCount());
        System.out.println("page为："+pages);
        model.addAttribute("page",pages);
        return "back_ShowUser";
    }

    @RequestMapping("/getEditUser/{id}")
    public String getEditUser(@PathVariable(value = "id") Long id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "back_editUser";
    }

    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable(value = "id") Long id, @RequestParam(value = "fileAvatar") MultipartFile file,RedirectAttributes attributes,User user){
        User user1 = userService.getUserByName(user.getUsername());
        if(file.isEmpty()){
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename(); //文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "D:/JAVAdexuexi/image/"; //上传的路径
        fileName = UUID.randomUUID() + suffixName; //新文件名
        File dest = new File(filePath + fileName) ;
        if( !dest.getParentFile().exists() ){
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        }catch (IOException e){
            e.printStackTrace();
        }
        String filename = "/JAVAdexuexi/image/" + fileName;
        user.setAvatar(filename);
        user.setUpdateTime(new Date());
        System.out.println(user);
        int editCount = 0;
        if(user1 == null){
            editCount = userService.editUser(user);
            if(editCount>0) {
                attributes.addFlashAttribute("message", "更新成功");
            }else {
                attributes.addFlashAttribute("message", "更新失败");
            }
        }else{
            attributes.addFlashAttribute("message","用户名已重复，请重新输入");
        }
        return "redirect:/showUser";
    }

    @RequestMapping("/getDelUser/{id}")
    public String delUser(@PathVariable(value = "id")Long id,RedirectAttributes attributes){
        int delCount = userService.deleteUser(id);
        if(delCount>0){
            attributes.addFlashAttribute("message","删除成功");
        }else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/showUser";
    }

    @RequestMapping("/getEditPwd")
    public String getEditPwd(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "back_editPwd";
    }

    @ResponseBody
    @RequestMapping("/sendCode")
    public String sendCode(@RequestBody User user1) throws IOException {
        System.out.println("11111");
        System.out.println(user1);
        String msg = "0";
        User user =userService.getUserById(user1.getId());
        if(user.getPhone()!=null){
            if(user.getPhone().equals(user1.getPhone())){
                msg = "1";
                HttpClient client = new HttpClient();
                PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
                post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");
                NameValuePair[] data = {new NameValuePair("Uid","庞宇强12"),
                        new NameValuePair("Key","d41d8cd98f00b204e980"),
                        new NameValuePair("smsMob",user1.getPhone()),
                        new NameValuePair("smsText","【庞宇强的新闻网站】您好，验证码：596237")};
                post.setRequestBody(data);
                client.executeMethod(post);

                Header[] headers = post.getResponseHeaders();
                int statusCode = post.getStatusCode();
                System.out.println("statusCode:"+statusCode);
                for(Header h : headers)
                {
                    System.out.println(h.toString());
                }
                String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
                System.out.println(result); //打印返回消息状态

                post.releaseConnection();
            }
        }
        return msg;
    }

    @RequestMapping("/editPwd/{id}")
    public String editPwd(@PathVariable("id")Long id,@RequestParam(value = "code")String code,@RequestParam(value = "password") String password,
                          RedirectAttributes attributes ){
        int updateCount = 0;
        if(code.equals("596237")){
             updateCount = userService.updatePwdById(password,id);
        }
        if(updateCount>0){
            attributes.addFlashAttribute("message","您的密码修改成功");
        }else {
            attributes.addFlashAttribute("message","您的密码修改失败");
        }
        return "redirect:/getBackNews";
    }

}
