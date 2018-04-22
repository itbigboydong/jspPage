package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentPage;
import service.StudentService;

//@WebServlet("/BlogSplitServlet")
public class StudentSplitServlet extends HttpServlet {
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response) 
			                                    throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html; charset=utf-8");
	  String pagenostr=request.getParameter("pageno");
	  //首次访问servletpagenostr为null，给一个初始值，即默认访问第一页
	  int pageno=1;
	  if(pagenostr!=null){
			pageno = Integer.parseInt(pagenostr);
			};
	  StudentService service=new StudentService();
	  StudentPage blogPage=service.findPageRecord(pageno);
	  request.setAttribute("blogPage", blogPage);
	  request.getRequestDispatcher("/WEB-INF/blogPage.jsp").forward(request, response);
	 }
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);
	 }
	}