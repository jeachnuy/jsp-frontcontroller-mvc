package com.eduJsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpUtil
 */
@WebServlet("/HttpUtil")
public class HttpUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG = "HttpUtil : ";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpUtil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		UtilsLog.getInstance().info(TAG, "forward()");
		try {
			RequestDispatcher dispatcher =request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("forward() err : " + e);
		}
	}

}
