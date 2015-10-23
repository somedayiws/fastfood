package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.QUANTRI;
import model.bo.SanPhamBO;

/**
 * Servlet implementation class XoaSanPhamServlet
 */
@WebServlet("/admin/XoaSanPhamServlet")
public class XoaSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoaSanPhamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		QUANTRI quanTri = (QUANTRI) session.getAttribute("quanTri");
		if (quanTri != null) {
			String id = request.getParameter("id");
			SanPhamBO cn = new SanPhamBO();
			cn.deleteSanPham(id);
			response.sendRedirect("SanPham");
		} else {
			response.sendRedirect("Login");
		}
	}

}
