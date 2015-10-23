package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.QUANTRI;
import model.bo.XuLyDangNhapAdminBO;

@WebServlet("/admin/XuLyDangNhapAdmin")
public class XuLyDangNhapAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XuLyDangNhapAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		String tenTaiKhoan = request.getParameter("tenTaiKhoan");
		String matKhau = request.getParameter("matKhau");
		HttpSession session = request.getSession();
		XuLyDangNhapAdminBO xuLyDangNhapAdminBO = new XuLyDangNhapAdminBO();

		if (xuLyDangNhapAdminBO.isTaiKhoanHopLe(tenTaiKhoan, matKhau)) {

			QUANTRI quanTri = new QUANTRI();
			quanTri = xuLyDangNhapAdminBO.getThongTinQuanTri(tenTaiKhoan);
			if (quanTri != null) {
				System.out.println("session OK");
				session.setAttribute("quanTri", quanTri);
			}
			response.sendRedirect("Home");
		} else {
			System.out.println("NOT OK");
			response.sendRedirect("Login");
		}

	}

}
