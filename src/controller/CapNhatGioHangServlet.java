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
 * Servlet implementation class CapNhatGioHangServlet
 */
@WebServlet("/CapNhatGioHangServlet")
public class CapNhatGioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatGioHangServlet() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String soluong = request.getParameter("soluong");
		ArrayList<SANPHAM> listGioHang = (ArrayList<SANPHAM>) request.getSession().getAttribute("Giohang");
		GioHangBO giohang = new GioHangBO();
		if(listGioHang != null)
			request.getSession().setAttribute("Giohang", giohang.CapNhatGioHang(listGioHang, id, soluong));
		response.sendRedirect("ThanhToanOnlineServlet");
	}

}
