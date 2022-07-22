package com.eduJsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddressListController implements Controller {
	private static final String TAG = "AddressListController : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	UtilsLog.getInstance().info(TAG, "execute()");
		HttpUtil.forward(request, response, "/WEB-INF/view/addressList.jsp");
	}

}
