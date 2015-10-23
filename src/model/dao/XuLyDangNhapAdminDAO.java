package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.CHINHANH;
import model.bean.QUANTRI;
import model.bean.TAIKHOAN;

public class XuLyDangNhapAdminDAO {
	DataBaseDAO db = new DataBaseDAO();

	public boolean isTaiKhoanHopLe(String tenTaiKhoan, String matKhau) {
		ResultSet rs = db
				.getResultSet("Select COUNT(*) from QUANTRI inner join TAIKHOAN "
						+ "on QUANTRI.TenTaiKhoan = TAIKHOAN.TenTaiKhoan "
						+ "where QUANTRI.TenTaiKhoan = '"
						+ tenTaiKhoan
						+ "' and TAIKHOAN.MatKhau='" + matKhau + "'");
		try {
			while (rs.next()) {
				if (rs.getInt(1) != 0)
					return true;
				else
					return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public QUANTRI getThongTinQuanTri(String tenTaiKhoan) {
		ResultSet rs = db
				.getResultSet("select TAIKHOAN.TenTaiKhoan,MatKhau,HoTen,TAIKHOAN.DiaChi,DienThoai,Email,"
						+ "QUANTRI.IdQuanTri,QuyenQuanTri,CHINHANH.TenChiNhanh,CHINHANH.IdChiNhanh,"
						+ "CHINHANH.DiaChi as [DiaChiCN] from QUANTRI "
						+ "inner join TAIKHOAN on TAIKHOAN.TenTaiKhoan = QUANTRI.TenTaiKhoan "
						+ "inner join CHINHANH on QUANTRI.IdChiNhanh = CHINHANH.IdChiNhanh"
						+ " where QUANTRI.TenTaiKhoan = '"+tenTaiKhoan+"'");
		try {
			if (rs.next()) {
				QUANTRI quanTri = new QUANTRI();
				TAIKHOAN taiKhoan = new TAIKHOAN();
				CHINHANH chiNhanh = new CHINHANH();

				taiKhoan.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
				taiKhoan.setHoTen(rs.getString("HoTen"));
				taiKhoan.setDiaChi(rs.getString("DiaChi"));
				taiKhoan.setEmail(rs.getString("Email"));
				taiKhoan.setDienThoai(rs.getString("DienThoai"));

				chiNhanh.setIdChiNhanh(rs.getString("IdChiNhanh"));
				chiNhanh.setTenChiNhanh(rs.getString("TenChiNhanh"));
				chiNhanh.setDiaChi(rs.getString("DiaChiCN"));

				quanTri.setIdQuanTri(rs.getString("IdQuanTri"));
				quanTri.setQuyenQuanTri(rs.getString("QuyenQuanTri"));
				quanTri.setChiNhanh(chiNhanh);
				quanTri.setTaiKhoan(taiKhoan);
				return quanTri;
			} else
				return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
