package model.bean;

import java.sql.Date;

public class TAIKHOAN {
	private String TenTaiKhoan;
	private String MatKhau;
	private String HoTen;
	private String DiaChi;
	private String DienThoai;
	private String Email;
	
	public TAIKHOAN() {
		super();
	}

	public TAIKHOAN(String tenTaiKhoan, String matKhau, String hoTen,
			String diaChi, String dienThoai, String email) {
		super();
		TenTaiKhoan = tenTaiKhoan;
		MatKhau = matKhau;
		HoTen = hoTen;
		DiaChi = diaChi;
		DienThoai = dienThoai;
		Email = email;
	}

	public String getTenTaiKhoan() {
		return TenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		TenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getDienThoai() {
		return DienThoai;
	}

	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
