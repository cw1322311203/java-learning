package com.cw.myservlet;

import com.cw.httpserver.HttpRequest;
import com.cw.httpserver.HttpResponse;
import com.cw.parse.WebServlet;

/**
 * 处理登录请求
 */
@WebServlet(urlPatterns = "/servlet/loginservlet")
public class LoginServlet implements HttpServlet{
    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
       //处理
        System.out.println("LoginServlet处理了登录请求");


       //响应
        httpResponse.setContentTpye("text/html;charset=UTF-8");
        httpResponse.write("登录成功");
    }
}
