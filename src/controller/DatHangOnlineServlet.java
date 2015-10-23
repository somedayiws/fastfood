package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.CHINHANH;
import model.bean.KHACHHANG;
import model.bean.SANPHAM;
import model.bo.ChiNhanhBO;
import model.bo.DonHangBO;

/**
 * Servlet implementation class DatHangOnlineServlet
 */
@WebServlet("/DatHangOnlineServlet")
public class DatHangOnlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatHangOnlineServlet() {
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
		String hoten = request.getParameter("hoten");
		String dienthoai = request.getParameter("dienthoai");
		String email = request.getParameter("email");
		String diachi = request.getParameter("diachi");
		String idChiNhanh = request.getParameter("idChiNhanh");
		String thongdiep = request.getParameter("thongdiep");
		ChiNhanhBO chinhanh = new ChiNhanhBO();
		if (hoten == null || dienthoai == null || email == null) {
			ArrayList<CHINHANH> list = chinhanh.getDanhSachChiNhanh("");
			request.setAttribute("list", list);
			request.setAttribute("error", "Invalid information! Check again!");
			RequestDispatcher pc = request
					.getRequestDispatcher("DatHangOnline.jsp");
			pc.forward(request, response);
		}else{
			DonHangBO donhang = new DonHangBO();
			ArrayList<SANPHAM> dsHang = (ArrayList<SANPHAM>)request.getSession().getAttribute("Giohang");
			if(dsHang != null && dsHang.size()>0){
				KHACHHANG khacHang = (KHACHHANG)request.getSession().getAttribute("khachHang");
				if(khacHang==null)
					donhang.addDonHang(hoten, dienthoai, email, diachi, idChiNhanh, thongdiep, dsHang);
				else
					donhang.addDonHang(khacHang.getIdKhachHang()+"", hoten, dienthoai, email, diachi, idChiNhanh, thongdiep, dsHang);
			}
			deleteSession(request, "Giohang");
			response.sendRedirect("TrangChu");
		}
	}
	private void deleteSession(HttpServletRequest request, String nameSession){
		request.getSession().setAttribute(nameSession, null);
	}
}
