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
 * Servlet implementation class TrangClientSanPhamServlet
 */
@WebServlet("/SanPham")
public class TrangClientSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrangClientSanPhamServlet() {
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
		SanPhamBO cn = new SanPhamBO();
		DanhMucBO dm = new DanhMucBO();
		String idDanhMuc = request.getParameter("idDanhMuc");
		String txtSearch = request.getParameter("txtSearch");
		if (txtSearch == null)
			txtSearch = "";
		ArrayList<SANPHAM> list;
		String tenDanhMuc = "";
		if (idDanhMuc == null)
			idDanhMuc = "";
		else
			tenDanhMuc = (dm.getDanhMuc(idDanhMuc)).getDanhMuc();
		if (txtSearch == null)
			txtSearch = "";

		// nRecord = -1 thì sẽ load tất cả record trong cơ sở dữ liệu
		list = cn.getDanhSachSanPham(txtSearch, idDanhMuc, -1, -1);
		ArrayList<DANHMUC> danhmuc = dm.getDanhSachDanhMuc("");
		ArrayList<SANPHAM> listbanchay = cn.getDanhSachBanChay(10);
		request.setAttribute("list", list);
		request.setAttribute("listbanchay", listbanchay);
		request.setAttribute("danhmuc", danhmuc);
		request.setAttribute("tenDanhMuc", tenDanhMuc);
		RequestDispatcher pc = request.getRequestDispatcher("TrangSanPham.jsp");
		pc.forward(request, response);
	}
}
