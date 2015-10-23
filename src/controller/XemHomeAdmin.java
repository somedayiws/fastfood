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
import model.bo.DonHangBO;

/**
 * Servlet implementation class ShowHomePageServlet
 */
@WebServlet("/admin/Home")
public class XemHomeAdmin extends HttpServlet {
	private static final String tinhTrangMoi = "Mới";
	private static final String tinhTrangDangChuyen = "Vận chuyển";
	private static final String tinhTrangThanhCong = "Thành công";
	private static final String tinhTrangHuy = "Hủy";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XemHomeAdmin() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		QUANTRI quanTri = (QUANTRI) session.getAttribute("quanTri");
		if (quanTri != null) {
			DonHangBO donHangBO = new DonHangBO();
			// nRecord = -1 thì sẽ load tất cả các đơn hàng ra.
			ArrayList<DONHANG> arrDonHangMoi = donHangBO.getDanhSachDonHang("",
					tinhTrangMoi, "", -1, 1);
			ArrayList<DONHANG> arrDonHangDangChuyen = donHangBO
					.getDanhSachDonHang("", tinhTrangDangChuyen, "", -1, 1);
			if (arrDonHangMoi != null && arrDonHangDangChuyen != null) {
				request.setAttribute("arrDonHangMoi", arrDonHangMoi);
				request.setAttribute("arrDonHangDangChuyen",
						arrDonHangDangChuyen);
			}
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("Home.jsp");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}

}
