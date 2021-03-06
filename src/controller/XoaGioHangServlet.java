package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.SANPHAM;
import model.bo.GioHangBO;

/**
 * Servlet implementation class XoaGioHangServlet
 */
@WebServlet("/XoaGioHangServlet")
public class XoaGioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoaGioHangServlet() {
		super();
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

		String id = request.getParameter("id");
		ArrayList<SANPHAM> listGioHang = (ArrayList<SANPHAM>) request
				.getSession().getAttribute("Giohang");
		if (id != null) {
			GioHangBO giohang = new GioHangBO();
			if (listGioHang != null)
				request.getSession().setAttribute("Giohang",
						giohang.XoaItemGioHang(listGioHang, id));
		} else {
			request.getSession().setAttribute("Giohang", null);
		}
		response.sendRedirect("ThanhToanOnlineServlet");

	}

}
