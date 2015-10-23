package model.bo;

import java.util.ArrayList;

import model.bean.KHACHHANG;
import model.dao.KhachHangDAO;

public class KhachHangBO {

	KhachHangDAO kh = new KhachHangDAO();

	public ArrayList<KHACHHANG> getDanhSachKhachHang(String timkiem) {
		return kh.getDanhSachKhachHang(timkiem.trim());
	}

	public boolean KiemTraHopLe(String x, String regex) {
		if (x == null)
			return false;
		return x.trim().matches(regex);
	}

	public boolean KiemTraHopLe(String x) {
		// TODO Auto-generated method stub
		if (x == null)
			return false;
		if (x.trim().equals(""))
			return false;
		return true;
	}

	public void deleteKhachHang(String id) {
		// TODO Auto-generated method stub
		kh.deleteKhachHang(id);
	}

	public boolean isValidAccount(String userName, String password) {
		// TODO Auto-generated method stub
		return kh.isValidAccount(userName, password);
	}

	public KHACHHANG getKhachHang(String userName) {
		// TODO Auto-generated method stub
		return kh.getKhachHang(userName);
	}

	public boolean isExistAccount(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		return kh.isExistAccount(tenTaiKhoan);
	}

	public boolean addKhachHang(String tenTaiKhoan, String matKhau,
			String hoTen, String diaChi, String dienThoai, String email) {
		// TODO Auto-generated method stub
		return kh.addKhachHang(tenTaiKhoan, matKhau, hoTen, diaChi, dienThoai,
				email);
	}
}
