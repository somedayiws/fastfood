package model.bo;

import java.util.ArrayList;

import model.bean.CHINHANH;
import model.dao.ChiNhanhDAO;

public class ChiNhanhBO {

	ChiNhanhDAO cn = new ChiNhanhDAO();

	public ArrayList<CHINHANH> getDanhSachChiNhanh(String timkiem) {
		// TODO Auto-generated method stub
		return cn.getDanhSachChiNhanh(timkiem.trim());
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

	public CHINHANH getChiNhanh(String id) {
		// TODO Auto-generated method stub
		if (KiemTraHopLe(id, "[\\s\\w]*"))
			return cn.getChiNhanh(id);
		else
			return cn.getChiNhanh("");
	}

	public boolean addChiNhanh(String id, String chinhanh, String diachi) {
		// TODO Auto-generated method stub
		return cn.addChiNhanh(id, chinhanh, diachi);
	}

	public boolean updateChiNhanh(String id, String chinhanh, String diachi) {
		// TODO Auto-generated method stub
		return cn.updateChiNhanh(id, chinhanh, diachi);
	}

	public boolean deleteChiNhanh(String id) {
		// TODO Auto-generated method stub
		return cn.deleteChiNhanh(id);
	}
	
	public String getIdChiNhanh(String ichinhanh) {
		// TODO Auto-generated method stub
		return cn.getIdChiNhanh(ichinhanh);
	}
}
