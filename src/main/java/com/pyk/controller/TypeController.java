package com.pyk.controller;


import com.pyk.model.PageBean;
import com.pyk.model.Type;
import com.pyk.service.TypeService;
import com.pyk.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 彭义凯 on 2019/12/1.
 */
@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/types")
    public String types(HttpServletRequest request, Model model){
        int pageCode = Tool.getPageCode(request);
        int pageSize = 4;
        List<Type> types = typeService.listPage(pageCode-1,pageSize);
        PageBean<Type> pages = new PageBean<>();
        pages.setBeanList(types);
        pages.setPageCode(pageCode);
        pages.setPageSize(pageSize);
        int pageTotal = typeService.findTotalCount();
        pages.setTotalCount(pageTotal);
        model.addAttribute("page",pages);
        return "blags_types";
    }

    @RequestMapping("/getBlagsTypesInput")
    public String getBlagsTypesInput(Model model){
        model.addAttribute("type",new Type());
        return "blags-types-input";
    }

    @RequestMapping("/typesInput")
    public String typesInput(Type type, RedirectAttributes attributes){
        Type t = typeService.getTypeByName(type.getName());
        int addCount = 0;
        if(t == null){
            addCount = typeService.saveType(type);
        }
        if(addCount>0) {
            attributes.addFlashAttribute("message", "新增成功");
        }else {
            attributes.addFlashAttribute("message", "新增失败");
        }
        return "redirect:/types";
    }
    @RequestMapping("/delTypes/{id}")
    public String delTypes(@PathVariable("id") Long id,RedirectAttributes attributes){
        int delCount = typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/types";
    }

    @RequestMapping("/getEditTypes/{id}")
    public String getEditTypes(@PathVariable Long id ,Model model){
        model.addAttribute("type",typeService.getType(id));
        return "blags-types-input";
    }

    @RequestMapping("/typesInput/{id}")
    public String editTypes(Type type, RedirectAttributes attributes,@PathVariable Long id){
        Type t = typeService.getTypeByName(type.getName());
        int editCount = 0;
        if(t == null){
           editCount = typeService.updateType(type);
        }
        if(editCount>0) {
            attributes.addFlashAttribute("message", "更新成功");
        }else {
            attributes.addFlashAttribute("message", "更新失败");
        }
        return "redirect:/types";
    }

}
