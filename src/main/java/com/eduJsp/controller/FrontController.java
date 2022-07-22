package com.eduJsp.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG = "FrontController : ";
	
	private String charset = null;
	private HashMap<String, Controller> list = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
    	super();
    	UtilsLog.getInstance().info(TAG, "ctor()");
        // TODO Auto-generated constructor stub
    }

    /**
     * 서블렛 실행 될때 한번만 실행됨 
     */
    @Override
    public void init(ServletConfig sc) throws ServletException {
    	charset = sc.getInitParameter("charset");
    	list = new HashMap<String, Controller>();
    	
    	UtilsLog.getInstance().info(TAG, "init()");
    	
    	list.put("/board/insert.do", new AddressInsertController());
    	list.put("/board/list.do", new AddressListController());
    	
    	UtilsLog.getInstance().info(TAG, list.toString());
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding(charset);
    	String url =req.getRequestURI();
    	String contextPath =req.getContextPath();
    	String path =url.substring(contextPath.length());
    	
    	UtilsLog.getInstance().info(TAG, "service()");
    	UtilsLog.getInstance().info(TAG, "url: " + url);
    	UtilsLog.getInstance().info(TAG, "contextPath: " + contextPath);
    	UtilsLog.getInstance().info(TAG, "path: " + path);
    	
    	Controller subController =list.get(path);
    	subController.execute(req, resp);
    }
}
