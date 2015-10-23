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

import model.bean.DONHANG;
import model.bean.QUANTRI;
import model.bean.SANPHAM;
import model.bo.DonHangBO;

/**
 * Servlet implementation class XoaChiTietDonHangServlet
 */
@WebServlet("/admin/XoaChiTietDonHangServlet")
public class XoaChiTietDonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoaChiTietDonHangServlet() {
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
			DonHangBO dh = new DonHangBO();
			String idsanpham = request.getParameter("idsp");
			String iddonhang = request.getParameter("iddh");
			dh.deleteChiTietDonHang(iddonhang, idsanpham);

			ArrayList<SANPHAM> list = dh.getListSanPham(iddonhang);
			if (list == null) {
				// Nếu xóa hết danh sách sản phẩm thì xóa luôn đơn hàng
				dh.deleteDonHang(iddonhang);
			}
			RequestDispatcher pc = request
					.getRequestDispatcher("XemThongTinDonHang?id=" + iddonhang);
			pc.forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}
}
