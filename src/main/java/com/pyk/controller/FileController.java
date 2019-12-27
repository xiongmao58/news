package com.pyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by 彭义凯 on 2019/12/5.
 */
@Controller
public class FileController {


  /*  @RequestMapping("/getEditUser")
    public String getEditUser(){
        return "back_UserEdit";
    }*/
   @RequestMapping("/getFile")
    public String file(){
        return "back_UserEdit";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam(value = "fileName") MultipartFile file, Model model){
        System.out.println(file);
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
        model.addAttribute("filename",filename);
        return "back_UserEdit";
    }



}
