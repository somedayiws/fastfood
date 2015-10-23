package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.CHINHANH;
import model.bean.DONHANG;
import model.bean.QUANTRI;
import model.bean.SANPHAM;
import model.bo.ChiNhanhBO;
import model.bo.DonHangBO;

/**
 * Servlet implementation class XemThongTinDonHangServlet
 */
@WebServlet("/admin/XemThongTinDonHang")
public class XemThongTinDonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XemThongTinDonHangServlet() {
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
		HttpSession session = request.getSession();
		QUANTRI quanTri = (QUANTRI) session.getAttribute("quanTri");
		if (quanTri != null) {
			DonHangBO donHangBO = new DonHangBO();
			ChiNhanhBO chiNhanhBO = new ChiNhanhBO();
			String id = request.getParameter("id");
			if (id != null) {
				DONHANG donhang = donHangBO.getDonHang(id);
				ArrayList<SANPHAM> list = donHangBO.getListSanPham(id);
				if (list != null) {
					ArrayList<CHINHANH> arrChiNhanh = chiNhanhBO
							.getDanhSachChiNhanh("");
					request.setAttribute("donhang", donhang);
					request.setAttribute("list", list);
					request.setAttribute("arrChiNhanh", arrChiNhanh);
					RequestDispatcher pc = request
							.getRequestDispatcher("XemThongTinDonHang.jsp");
					pc.forward(request, response);
				} else {
					response.sendRedirect("Home");
				}
			} else {
				response.sendRedirect("Home");
			}
		} else {
			response.sendRedirect("Login");
		}
	}

}
