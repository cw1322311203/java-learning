package com.cw.myservlet;

import com.cw.httpserver.HttpRequest;
import com.cw.httpserver.HttpResponse;

/**
 * 规范servlet类的
 */
public interface HttpServlet {

    //定义业务处理的方法
    public abstract void service(HttpRequest httpRequest, HttpResponse httpResponse);
}
