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
 * Servlet implementation class ThanhToanOnlineServlet
 */
@WebServlet("/ThanhToanOnlineServlet")
public class ThanhToanOnlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanOnlineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		GioHangBO giohang = new GioHangBO();
		if (id != null) {
			System.out.println("Id Product : " + id);
			@SuppressWarnings("unchecked")
			ArrayList<SANPHAM> listGioHang = (ArrayList<SANPHAM>) request.getSession().getAttribute("Giohang") ;
			if (giohang.KiemTraGioHang(listGioHang, id)) {
				// Nếu hàng đã tồn tại thì chỉnh lại số lượng.
				request.getSession().setAttribute("Giohang",
						giohang.CapNhatGioHang(listGioHang, id, "1"));
			} else {
				// Thêm hàng mới vào giỏ.
				request.getSession().setAttribute("Giohang",
						giohang.ThemGioHang(listGioHang, id, "1"));
			}
		}
		request.getRequestDispatcher("ThanhToanOnline.jsp").forward(request, response);
	}

}
