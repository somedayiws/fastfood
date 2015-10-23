package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.SANPHAM;
import model.bo.GioHangBO;

/**
 * Servlet implementation class GioHangOnlineServlet
 */
@WebServlet("/GioHangOnlineServlet")
public class GioHangOnlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GioHangOnlineServlet() {
		super();
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
		String id = request.getParameter("id");
		String soluong = request.getParameter("soluong");
		ArrayList<SANPHAM> listGioHang = (ArrayList<SANPHAM>) request.getSession().getAttribute("Giohang");
		GioHangBO giohang = new GioHangBO();
		if (id != null && soluong != null) {
			if (giohang.KiemTraGioHang(listGioHang, id)) {
				// Nếu hàng đã tồn tại thì chỉnh lại số lượng.
				request.getSession().setAttribute("Giohang",
						giohang.CapNhatGioHang(listGioHang, id, soluong));
			} else {
				// Thêm hàng mới vào giỏ.
				request.getSession().setAttribute("Giohang",
						giohang.ThemGioHang(listGioHang, id, soluong));
			}
		}
		RequestDispatcher pc = request.getRequestDispatcher("GioHangOnline.jsp");
		pc.forward(request, response);
	}
}
