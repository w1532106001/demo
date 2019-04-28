package com.whc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class IndexController {

      @GetMapping("")
      public String zf(){
            return "index";
      }

      @PostMapping("uploadFile1")
      @ResponseBody
      public String uploadByStandardServletMultipartResolver(MultipartFile uploadFile){
            System.out.println(1 / 0);
            String name = uploadFile.getOriginalFilename();
            File file = new File("F:\\",name);
            try {
                  uploadFile.transferTo(file);
                  return file.getPath();
            } catch (IOException e) {
                  e.printStackTrace();
            }
                  return "上传失败";
      }

      @PostMapping("uploadFileList")
      @ResponseBody
      public String uploadListByStandardServletMultipartResolver(MultipartFile[] uploadFileList){
            StringBuilder path = new StringBuilder();
            for (MultipartFile multipartFile : uploadFileList) {
                  String name = multipartFile.getOriginalFilename();
                  File file = new File("F:\\",name);
                  try {
                        multipartFile.transferTo(file);
                        path.append(file.getPath()+",</br>");

                  } catch (IOException e) {
                        e.printStackTrace();
                        return "上传失败";
                  }
            }
            return path.toString();
      }

}
