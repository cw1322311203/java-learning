package com.cw.myservlet;

import com.cw.httpserver.HttpRequest;
import com.cw.httpserver.HttpResponse;
import com.cw.parse.WebServlet;

@WebServlet(urlPatterns = "/servlet/lostpasswordservlet")
public class LostPasswordServlet implements HttpServlet {

    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
        //处理
        System.out.println("LostPasswordServlet处理了忘记密码请求");


        //响应
        httpResponse.setContentTpye("text/html;charset=UTF-8");
        httpResponse.write("重置密码成功");


    }
}
