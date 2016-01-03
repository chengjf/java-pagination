package com.chengjf.page.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chengjf.page.model.Student;
import com.chengjf.page.service.Page;
import com.chengjf.page.service.StudentService;

public class PageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1202166036630413112L;

	private StudentService service = new StudentService();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
		System.out.println("get");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int pageNumber = 0;
		try {
			pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("pageNumber is " + pageNumber);
		
		Page<Student> page = service.getStudentPage(pageNumber);

		req.setAttribute("result", page);
		req.setAttribute("title", "Page测试");

		req.getRequestDispatcher("page.jsp").forward(req, resp);

	}

}
