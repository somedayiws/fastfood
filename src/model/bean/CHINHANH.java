package model.bean;

public class CHINHANH {
	private String IdChiNhanh;
	private String TenChiNhanh;
	private String DiaChi;

	public CHINHANH() {

	}

	public CHINHANH(String idChiNhanh, String tenChiNhanh, String diaChi) {
		super();
		IdChiNhanh = idChiNhanh;
		TenChiNhanh = tenChiNhanh;
		DiaChi = diaChi;
	}

	public String getIdChiNhanh() {
		return IdChiNhanh;
	}

	public void setIdChiNhanh(String idChiNhanh) {
		IdChiNhanh = idChiNhanh;
	}

	public String getTenChiNhanh() {
		return TenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		TenChiNhanh = tenChiNhanh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

}
