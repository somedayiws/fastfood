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
 * Servlet implementation class XemDanhSachDonHangServlet
 */
@WebServlet("/admin/DonHang")
public class XemDanhSachDonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XemDanhSachDonHangServlet() {
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
			int page = 1;
			int nRecord = 12;
			// Get init parameter
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				page = 1;
				e.printStackTrace();
			}
			System.out.println("nRecord= " + nRecord + " page= " + page);

			String txttimkiem = request.getParameter("txttimkiem");
			if (txttimkiem == null)
				txttimkiem = "";
			DonHangBO donHangBO = new DonHangBO();
			ArrayList<DONHANG> list = donHangBO.getDanhSachDonHang(txttimkiem,
					"", "", nRecord, page);

			String pageNav = donHangBO.getPageNav();
			request.setAttribute("pageNav", pageNav);

			request.setAttribute("list", list);
			RequestDispatcher pc = request
					.getRequestDispatcher("XemDanhSachDonHang.jsp");
			pc.forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}

}
