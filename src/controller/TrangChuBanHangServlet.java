package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DANHMUC;
import model.bean.SANPHAM;
import model.bo.DanhMucBO;
import model.bo.SanPhamBO;

/**
 * Servlet implementation class TrangChuBanHangServlet
 */
@WebServlet("/TrangChu")
public class TrangChuBanHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrangChuBanHangServlet() {
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
		SanPhamBO cn = new SanPhamBO();
		DanhMucBO dm = new DanhMucBO();
		String idDanhMuc = request.getParameter("idDanhMuc");
		ArrayList<SANPHAM> list;
		if (idDanhMuc == null)
			idDanhMuc = "";
		ArrayList<SANPHAM> topSanPhamRandom = cn.getTopSanPhamRandom(8);
		ArrayList<SANPHAM> topSanPhamBanChay = cn.getDanhSachBanChay(8);
		ArrayList<SANPHAM> topSanPhamMoiNhat = cn.getTopSanPhamMoi(4);
		ArrayList<DANHMUC> danhmuc = dm.getDanhSachDanhMuc("");
		request.setAttribute("danhmuc", danhmuc);
		request.setAttribute("topSanPhamRandom", topSanPhamRandom);
		request.setAttribute("topSanPhamBanChay", topSanPhamBanChay);
		request.setAttribute("topSanPhamMoiNhat", topSanPhamMoiNhat);
		RequestDispatcher pc = request.getRequestDispatcher("Home.jsp");
		pc.forward(request, response);
	}
}
