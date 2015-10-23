package model.bean;

public class CHITIETDONHANG {
	String IdDonHang;
	String IdSanPham;
	int SoLuong;
	public CHITIETDONHANG(String idDonHang, String idSanPham, int soLuong) {
		super();
		IdDonHang = idDonHang;
		IdSanPham = idSanPham;
		SoLuong = soLuong;
	}
	public String getIdDonHang() {
		return IdDonHang;
	}
	public void setIdDonHang(String idDonHang) {
		IdDonHang = idDonHang;
	}
	public String getIdSanPham() {
		return IdSanPham;
	}
	public void setIdSanPham(String idSanPham) {
		IdSanPham = idSanPham;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
}
