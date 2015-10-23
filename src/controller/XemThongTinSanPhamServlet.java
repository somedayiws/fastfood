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
 * Servlet implementation class XemThongTinSanPhamServlet
 */
@WebServlet("/XemThongTinSanPhamServlet")
public class XemThongTinSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XemThongTinSanPhamServlet() {
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
		String id = request.getParameter("id");
		SanPhamBO sp = new SanPhamBO();
		DanhMucBO dm = new DanhMucBO();
		String idDanhMuc = request.getParameter("idDanhMuc");
		ArrayList<SANPHAM> list;
		if (idDanhMuc == null)
			idDanhMuc = "";
		list = sp.getDanhSachSanPham("", idDanhMuc, -1, -1);
		SANPHAM sanpham = sp.getSanPham(id);
		ArrayList<DANHMUC> danhmuc = dm.getDanhSachDanhMuc("");
		request.setAttribute("danhmuc", danhmuc);
		ArrayList<SANPHAM> arrLienQuan = sp.getDanhSachSanPham("", sanpham
				.getDanhMuc().getIdDanhMuc(), -1, -1);
		request.setAttribute("sanpham", sanpham);
		request.setAttribute("list", list);
		request.setAttribute("arrLienQuan", arrLienQuan);
		request.getRequestDispatcher("XemThongTinSanPham.jsp").forward(request,
				response);
	}

}
