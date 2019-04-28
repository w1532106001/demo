package com.whc.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestControllerAdvice
public class ExcptionConfigAdvice {

//    @ExceptionHandler(value = Exception.class)
//    public JSONObject returnErrorJSONObject(Exception e){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code","100");
//        jsonObject.put("msg",e.getMessage());
//        return jsonObject;
//    }
//
//    @ExceptionHandler(value = Exception.class)
//    public void returnView(Exception e, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write(e.getMessage());
//        printWriter.flush();
//        printWriter.close();
//    }
//
    @ExceptionHandler(value = Exception.class)
    public ModelAndView returnModelAndView(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("code",100);
        modelAndView.addObject("msg",e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
