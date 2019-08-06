package com.chen.servlet.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.GoodsType;
import com.chen.pojo.Paging;
import com.chen.pojo.UserInfo;
import com.chen.service.GoodsTypeService;

public class GoodsTypeServlet extends HttpServlet {
	
	GoodsTypeService goodsTypeService = new GoodsTypeService();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2853139677060884865L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ArrayList<GoodsType> list = new ArrayList<GoodsType>();
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		request.getParameter("paging");
		if (userInfo != null)
		{
			request.setAttribute("single", "right");
			list = goodsTypeService.findAllWithUsername(userInfo.getUsername());
			paging(request, list);
			request.getRequestDispatcher("views/good/EditGoodsType.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		ArrayList<GoodsType> list = new ArrayList<GoodsType>();
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		if (userInfo!=null)
		{
			String delete = request.getParameter("deleteChick");
			String add = request.getParameter("addChick");
			if (delete != null)
			{
				request.setAttribute("single", "right");
				goodsTypeService.deleteOneChickType(userInfo.getUsername(), request.getParameter("deleteChick"));
				list = goodsTypeService.findAllWithUsername(userInfo.getUsername());
				paging(request, list);
				request.getRequestDispatcher("views/good/EditGoodsType.jsp").forward(request, response);
			}
			else if(add != null) {
				request.setAttribute("single", "right");
				GoodsType goodsType = new GoodsType();
				goodsType.setGoodsType(request.getParameter("addChick"));
				goodsType.setUsername(userInfo.getUsername());
				goodsType.setPrice(Double.parseDouble(request.getParameter("addPrice")));
				goodsTypeService.insertType(goodsType);
				list = goodsTypeService.findAllWithUsername(userInfo.getUsername());
				paging(request, list);
				request.getRequestDispatcher("views/good/EditGoodsType.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("views/index.jsp");
			}
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

	private void paging(HttpServletRequest request, List<GoodsType> list) {
		String str_page = request.getParameter("page");
		Paging paging = new Paging(str_page, list);
		request.setAttribute("allType", paging.getResultList());
		request.setAttribute("paging", paging);
	}

}
