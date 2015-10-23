package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DonHangBO;

/**
 * Servlet implementation class SuaDanhMucServlet
 */
@WebServlet("/admin/CapNhatKetQuaDonHangServlet")
public class CapNhatKetQuaDonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapNhatKetQuaDonHangServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String idDonHang = request.getParameter("idDonHang");
		String tinhTrang = request.getParameter("tinhTrang");
		DonHangBO donHangBO = new DonHangBO();
		donHangBO.capNhatKetQuaDonHang(idDonHang,tinhTrang);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("Home");
		requestDispatcher.forward(request, response);
	}

}
