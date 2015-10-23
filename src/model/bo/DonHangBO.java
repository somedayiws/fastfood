package model.bo;

import java.util.ArrayList;

import model.bean.DONHANG;
import model.bean.SANPHAM;
import model.dao.DonHangDAO;

public class DonHangBO {

	DonHangDAO dh = new DonHangDAO();

	public ArrayList<DONHANG> getDanhSachDonHang(String timkiem,
			String tinhTrang, String orderBy, int nRecord, int page) {
		return dh.getDanhSachDonHang(timkiem.trim(), tinhTrang, orderBy,
				nRecord, page);
	}

	public String getPageNav() {
		return dh.getPageNav();
	}

	public boolean KiemTraHopLe(String x, String regex) {
		if (x == null)
			return false;
		return x.trim().matches(regex);
	}

	public boolean KiemTraHopLe(String x) {
		if (x == null)
			return false;
		if (x.trim().equals(""))
			return false;
		return true;
	}

	public void deleteDonHang(String id) {
		// TODO Auto-generated method stub
		dh.deleteDonHang(id);
	}

	public DONHANG getDonHang(String id) {
		return dh.getDonHang(id);
	}

	public ArrayList<SANPHAM> getListSanPham(String id) {
		return dh.getListSanPham(id);
	}

	public String getTenKhach(String id) {
		// TODO Auto-generated method stub
		return dh.getTenKhach(id);
	}

	public void deleteChiTietDonHang(String iddonhang, String idsanpham) {
		dh.deleteChiTietDonHang(iddonhang, idsanpham);
	}

	public int getSoLuongDonHang(String tinhTrang) {
		return dh.getSoLuongDonHang(tinhTrang);
	}

	public void addDonHang(String tenkhach, String dienthoai, String email,
			String diachinhan, String chinhanh, String ghichu,
			ArrayList<SANPHAM> dsHang) {
		// TODO Auto-generated method stub
		dh.addDonHang(tenkhach, dienthoai, email, diachinhan, chinhanh, ghichu,
				dsHang);
	}

	public void addDonHang(String idKhachHang, String tenkhach,
			String dienthoai, String email, String diachinhan, String chinhanh,
			String ghichu, ArrayList<SANPHAM> dsHang) {
		dh.addDonHang(idKhachHang, tenkhach, dienthoai, email, diachinhan,
				chinhanh, ghichu, dsHang);
	}

	public boolean capNhatKetQuaDonHang(String idDonHang, String tinhTrang) {
		return dh.capNhatKetQuaDonHang(idDonHang, tinhTrang);
	}

	public boolean chuyenChiNhanhDatHang(String idDonHang, String idChiNhanh) {
		return dh.chuyenChiNhanhDatHang(idDonHang, idChiNhanh);
	}
}
