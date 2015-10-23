package model.bo;

import java.util.ArrayList;

import model.bean.QUANTRI;
import model.dao.QuanTriDAO;

public class QuanTriBO {
	
	QuanTriDAO quantri = new QuanTriDAO();
	
	public ArrayList<QUANTRI> getDanhSachQuanTri(String timkiem) {
		// TODO Auto-generated method stub
		if(KiemTraHopLe(timkiem))
			return quantri.getDanhSachQuanTri(timkiem);
		else
			return quantri.getDanhSachQuanTri("");
	}

	public boolean KiemTraHopLe(String x, String regex){
		if(x == null) return false;
		return x.trim().matches(regex);
	}

	public boolean KiemTraHopLe(String x) {
		// TODO Auto-generated method stub
		if(x == null) return false;
		if(x.trim().equals("")) return false;
		return true;
	}
	
	public QUANTRI getQuanTri(String id) {
		// TODO Auto-generated method stub
		if(KiemTraHopLe(id, "[\\s\\w]*"))
			return quantri.getQuanTri(id);
		else
			return quantri.getQuanTri("");
	}

	public boolean updateQuanTri(String idQuanTri, String chinhanh,
			String tenTaiKhoan, String matKhau, String hoTen, String diaChi,
			String dienThoai, String email) {
		// TODO Auto-generated method stub
		return quantri.updateQuanTri(idQuanTri, chinhanh,tenTaiKhoan, matKhau, hoTen, diaChi, dienThoai, email);
	}

	public ArrayList<QUANTRI> getDanhSachQuanTri(String giatri, String nameCot) {
		// TODO Auto-generated method stub
		return quantri.getDanhSachQuanTri(giatri, nameCot);
	}

	public boolean addQuanTRi(String idQuanTri, String chinhanh,
			String tenTaiKhoan, String matKhau, String hoTen, String diaChi,
			String dienThoai, String email) {
		// TODO Auto-generated method stub
		return quantri.addQuanTRi(idQuanTri, chinhanh,tenTaiKhoan, matKhau, hoTen, diaChi, dienThoai, email);
	}

	public String getIdQuanTri() {
		// TODO Auto-generated method stub
		return quantri.getIdQuanTri();
	}
}
