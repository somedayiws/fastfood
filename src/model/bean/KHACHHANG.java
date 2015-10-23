package model.bean;

public class KHACHHANG {
	int IdKhachHang;
	int DiemTichLuy;
	TAIKHOAN TaiKhoan;
	public KHACHHANG(int idKhachHang, int diemTichLuy,
			TAIKHOAN taiKhoan) {
		super();
		IdKhachHang = idKhachHang;
		DiemTichLuy = diemTichLuy;
		TaiKhoan = taiKhoan;
	}
	public int getIdKhachHang() {
		return IdKhachHang;
	}
	public void setIdKhachHang(int idKhachHang) {
		IdKhachHang = idKhachHang;
	}
	public int getDiemTichLuy() {
		return DiemTichLuy;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		DiemTichLuy = diemTichLuy;
	}
	public TAIKHOAN getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(TAIKHOAN taiKhoan) {
		TaiKhoan = taiKhoan;
	}
}
