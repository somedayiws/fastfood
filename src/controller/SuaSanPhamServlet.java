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

import model.bean.DANHMUC;
import model.bean.QUANTRI;
import model.bean.SANPHAM;
import model.bo.DanhMucBO;
import model.bo.SanPhamBO;

/**
 * Servlet implementation class SuaSanPhamServlet
 */
@WebServlet("/admin/SuaSanPhamServlet")
public class SuaSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaSanPhamServlet() {
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
			String id = request.getParameter("id");
			String iddanhmuc = request.getParameter("iddanhmuc");
			String tensanpham = request.getParameter("tensanpham");
			String mota = request.getParameter("mota");
			String giaban = request.getParameter("giaban");
			String hinhanh = request.getParameter("hinhanh");

			SanPhamBO sp = new SanPhamBO();
			SANPHAM spx = sp.getSanPham(id);
			DanhMucBO dm = new DanhMucBO();
			ArrayList<DANHMUC> danhmuc = dm.getDanhSachDanhMuc("");
			request.setAttribute("danhmuc", danhmuc);
			if (mota != null && tensanpham != null && giaban != null) {
				if (sp.KiemTraHopLe(tensanpham) && sp.KiemTraHopLe(mota)
						&& sp.KiemTraHopLe(giaban, "\\d+")) {
					if (sp.updateSanPham(id, iddanhmuc, tensanpham, mota,
							giaban, "0", hinhanh)) {
						response.sendRedirect("SanPham");
					} else {
						request.setAttribute("spx", spx);
						request.setAttribute("loi", "Lỗi cập nhật csdl");
						RequestDispatcher pc = request
								.getRequestDispatcher("SuaSanPham.jsp");
						pc.forward(request, response);
					}
				} else {
					request.setAttribute("spx", spx);
					request.setAttribute("loi", "Hãy nhập đầy đủ thông tin");
					RequestDispatcher pc = request
							.getRequestDispatcher("SuaSanPham.jsp");
					pc.forward(request, response);
				}
			} else {
				request.setAttribute("spx", spx);
				RequestDispatcher pc = request
						.getRequestDispatcher("SuaSanPham.jsp");
				pc.forward(request, response);
			}
		} else {
			response.sendRedirect("Login");
		}
	}

}
