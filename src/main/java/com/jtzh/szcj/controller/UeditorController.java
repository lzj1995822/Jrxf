package com.jtzh.szcj.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jtzh.szcj.common.PublicMsg;
import com.jtzh.szcj.common.Ueditor;

@Controller
public class UeditorController {
	@RequestMapping(value="/ueditor")
    @ResponseBody
    public Object ueditor(HttpServletRequest request,MultipartFile upfile) {
	    String action = request.getParameter("action");
	    if(action.equals("imgUpload")){

            Ueditor ueditor = new Ueditor();
            String suffix = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf(".") + 1);
            String name  = upfile.getOriginalFilename();
            String fileName = String.valueOf(name.substring(0,name.lastIndexOf(".")))+name.substring(name.lastIndexOf("."));
            String path = "D:/test" ;
            File dest = new File(path + "/" + fileName);
            if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                upfile.transferTo(dest); //保存文件
                ueditor.setState("SUCCESS");
                ueditor.setTitle(fileName);
                ueditor.setUrl("http://www.jrxf.gov.cn/file/"+fileName);
                return ueditor;
            } catch (IllegalStateException e) {
                e.printStackTrace();
                ueditor.setState("ERROR");
                return ueditor;
            } catch (IOException e) {
                e.printStackTrace();
                ueditor.setState("ERROR");
                return ueditor;
            }
        }
        return PublicMsg.UEDITOR_CONFIG;
    }

    @RequestMapping(value="/imgUpload")
    @ResponseBody
    public Ueditor imgUpload(MultipartFile upfile) {
    	Ueditor ueditor = new Ueditor();
    	String suffix = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf(".") + 1);
    	String name  = upfile.getOriginalFilename();
    	String fileName = String.valueOf(name.substring(0,name.lastIndexOf(".")))+name.substring(name.lastIndexOf("."));
        String path = "D:/test" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
        	upfile.transferTo(dest); //保存文件
            ueditor.setState("SUCCESS");
            ueditor.setTitle(fileName);
            ueditor.setUrl("http://www.jrxf.gov.cn/file/"+fileName);
            return ueditor;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            ueditor.setState("ERROR");
        	return ueditor;
        } catch (IOException e) {
            e.printStackTrace();
            ueditor.setState("ERROR");
        	return ueditor;
        }
       
    }

}
