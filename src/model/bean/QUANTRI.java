package model.bean;

public class QUANTRI {
	private String IdQuanTri;
	private String QuyenQuanTri;
	private TAIKHOAN TaiKhoan;
	private CHINHANH chiNhanh;

	public TAIKHOAN getTaiKhoan() {
		return TaiKhoan;
	}

	public void setTaiKhoan(TAIKHOAN taiKhoan) {
		TaiKhoan = taiKhoan;
	}

	public String getIdQuanTri() {
		return IdQuanTri;
	}

	public void setIdQuanTri(String idQuanTri) {
		IdQuanTri = idQuanTri;
	}

	public String getQuyenQuanTri() {
		return QuyenQuanTri;
	}

	public void setQuyenQuanTri(String quyenQuanTri) {
		QuyenQuanTri = quyenQuanTri;
	}

	public CHINHANH getChiNhanh() {
		return chiNhanh;
	}

	public void setChiNhanh(CHINHANH chiNhanh) {
		this.chiNhanh = chiNhanh;
	}

}
