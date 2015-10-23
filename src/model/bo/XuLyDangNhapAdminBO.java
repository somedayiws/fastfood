package model.bo;

import model.bean.QUANTRI;
import model.dao.XuLyDangNhapAdminDAO;

public class XuLyDangNhapAdminBO {

	XuLyDangNhapAdminDAO xuLyDangNhapAdminDAO = new XuLyDangNhapAdminDAO();
	
	public boolean isTaiKhoanHopLe(String userName, String password) {
		if ("".equals(userName) || "".equals(password)) {
			return false;
		} else {
			return xuLyDangNhapAdminDAO.isTaiKhoanHopLe(userName, password);
		}
	}

	public QUANTRI getThongTinQuanTri(String userName) {
		// TODO Auto-generated method stub
		return xuLyDangNhapAdminDAO.getThongTinQuanTri(userName);
	}
}
