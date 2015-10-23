package model.bean;

import java.sql.Date;

public class DONHANG {
	String IdDonHang;
	int IdKhachHang;
	String TenKhachHang;
	String DiaChiNhanHang;
	String IdChiNhanh;
	String SoDienThoai;
	String Email;
	String TinhTrang;
	Date NgayLap;
	String GhiChu;
	int TongTien;

	public int getTongTien() {
		return TongTien;
	}

	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

	public DONHANG(String idDonHang, int idKhachHang, String tenKhachHang,
			String diaChiNhanHang, String idChiNhanh, String soDienThoai,
			String email, String tinhTrang, Date ngayLap, String ghiChu,
			int tongTien) {
		super();
		IdDonHang = idDonHang;
		IdKhachHang = idKhachHang;
		TenKhachHang = tenKhachHang;
		DiaChiNhanHang = diaChiNhanHang;
		IdChiNhanh = idChiNhanh;
		SoDienThoai = soDienThoai;
		Email = email;
		TinhTrang = tinhTrang;
		NgayLap = ngayLap;
		GhiChu = ghiChu;
		TongTien = tongTien;
	}

	public DONHANG() {
	}

	public String getIdDonHang() {
		return IdDonHang;
	}

	public void setIdDonHang(String idDonHang) {
		IdDonHang = idDonHang;
	}

	public int getIdKhachHang() {
		return IdKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		IdKhachHang = idKhachHang;
	}

	public String getTenKhachHang() {
		return TenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}

	public String getDiaChiNhanHang() {
		return DiaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		DiaChiNhanHang = diaChiNhanHang;
	}

	public String getIdChiNhanh() {
		return IdChiNhanh;
	}

	public void setIdChiNhanh(String idChiNhanh) {
		IdChiNhanh = idChiNhanh;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		TinhTrang = tinhTrang;
	}

	public Date getNgayLap() {
		return NgayLap;
	}

	public void setNgayLap(Date ngayLap) {
		NgayLap = ngayLap;
	}
}
