package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.CHINHANH;
import model.bean.DANHMUC;
import model.bean.QUANTRI;
import model.bean.SANPHAM;
import model.bean.TAIKHOAN;

public class QuanTriDAO {

	DataBaseDAO db = new DataBaseDAO();

	public ArrayList<QUANTRI> getDanhSachQuanTri(String timkiem) {
		// TODO Auto-generated method stub
		return null;
	}

	public QUANTRI getQuanTri(String id) {
		// TODO Auto-generated method stub

		ResultSet rs = db
				.getResultSet("select IdQuanTri,QuyenQuanTri,TAIKHOAN.TenTaiKhoan,MatKhau,HoTen,TAIKHOAN.DiaChi,DienThoai,Email,CHINHANH.IdChiNhanh,TenChiNhanh,CHINHANH.DiaChi"
						+ " from QUANTRI join TAIKHOAN on QUANTRI.TenTaiKhoan=TAIKHOAN.TenTaiKhoan"
						+ " join CHINHANH on QUANTRI.IdChiNhanh=CHINHANH.IdChiNhanh where IdQuanTri=N'"
						+ id + "'");
		QUANTRI quantri = new QUANTRI();
		try {
			if (rs.next()) {
				quantri.setIdQuanTri(rs.getString(1));
				quantri.setQuyenQuanTri(rs.getString(2));
				quantri.setTaiKhoan(new TAIKHOAN(rs.getString(3), rs
						.getString(4), rs.getString(5), rs.getString(6), rs
						.getString(7), rs.getString(8)));
				quantri.setChiNhanh(new CHINHANH(rs.getString(9), rs
						.getString(10), rs.getString(11)));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return quantri;
	}

	public boolean updateQuanTri(String idQuanTri, String chinhanh,
			String tenTaiKhoan, String matKhau, String hoTen, String diaChi,
			String dienThoai, String email) {
		// TODO Auto-generated method stub
		return db.updateData("update TAIKHOAN set MatKhau=N'" + matKhau
				+ "',HoTen=N'" + hoTen + "',DiaChi=N'" + diaChi
				+ "',DienThoai=N'" + dienThoai + "',Email='" + email
				+ "' where TenTaiKhoan=N'" + tenTaiKhoan + "'")
				&& db.updateData("update QUANTRI set IdChiNhanh=N'" + chinhanh
						+ "' where IdQuanTri=N'" + idQuanTri + "'");
	}

	public ArrayList<QUANTRI> getDanhSachQuanTri(String giatri, String nameCot) {
		// TODO Auto-generated method stub

		return null;
	}

	public String getIdQuanTri() {
		// TODO Auto-generated method stub
		ResultSet rs = db
				.getResultSet("select top 1 IdQuanTri from QUANTRI order by IdQuanTri desc");
		String id = "";
		int so = 0;
		try {
			if (rs.next()) {
				so = Integer.parseInt(rs.getString(1).substring(2)) + 1;
				id = "QT000".substring(0, 5 - ("" + so).length()) + so;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return id;
	}

	public boolean addQuanTRi(String idQuanTri, String chinhanh,
			String tenTaiKhoan, String matKhau, String hoTen, String diaChi,
			String dienThoai, String email) {
		String sql = "insert into TAIKHOAN values(N'" + tenTaiKhoan + "', N'"
				+ matKhau + "', N'" + hoTen + "', N'" + diaChi + "', N'"
				+ dienThoai + "', N'" + email + "')";
		String sql2 = "insert into QUANTRI values(N'" + idQuanTri + "', N'"
				+ tenTaiKhoan + "', N'Quản lý', N'" + chinhanh + "')";
		System.out.println(sql);
		System.out.println(sql2);
		return db.updateData("insert into TAIKHOAN values(N'" + tenTaiKhoan
				+ "', N'" + matKhau + "', N'" + hoTen + "', N'" + diaChi
				+ "', N'" + dienThoai + "', N'" + email + "')")
				&& db.updateData("insert into QUANTRI values(N'" + idQuanTri
						+ "', N'" + tenTaiKhoan + "', N'Quản lý', N'"
						+ chinhanh + "')") && db.updateData("insert into KHACHHANG values (N'"
								+ tenTaiKhoan + "','0')");
	}

}
