package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.KHACHHANG;
import model.bean.TAIKHOAN;

public class KhachHangDAO {

	DataBaseDAO db = new DataBaseDAO();

	public ArrayList<KHACHHANG> getDanhSachKhachHang(String timkiem) {
		// TODO Auto-generated method stub
		ResultSet rs = db
				.getResultSet("select IdKhachHang, DiemTichLuy, TAIKHOAN.TenTaiKhoan, MatKhau, HoTen, DiaChi, DienThoai, Email"
						+ " from KHACHHANG join TAIKHOAN on KHACHHANG.TenTaiKhoan=TAIKHOAN.TenTaiKhoan where DiaChi like N'%"
						+ timkiem
						+ "%' or HoTen like N'%"
						+ timkiem
						+ "%' or DienThoai like N'%"
						+ timkiem
						+ "%' order by DiemTichLuy desc");
		System.out.println("select IdKhachHang, DiemTichLuy, TAIKHOAN.TenTaiKhoan, MatKhau, HoTen, DiaChi, DienThoai, Email"
						+ " from KHACHHANG join TAIKHOAN on KHACHHANG.TenTaiKhoan=TAIKHOAN.TenTaiKhoan where DiaChi like N'%"
						+ timkiem
						+ "%' or HoTen like N'%"
						+ timkiem
						+ "%' or DienThoai like N'%"
						+ timkiem
						+ "%' order by DiemTichLuy desc");
		ArrayList<KHACHHANG> list = new ArrayList<KHACHHANG>();
		try {
			while (rs.next()) {
				list.add(new KHACHHANG(rs.getInt(1), rs.getInt(2),
						new TAIKHOAN(rs.getString(3), rs.getString(4), rs
								.getString(5), rs.getString(6),
								rs.getString(7), rs.getString(8))));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return list;
	}

	private String getTaiKhoan(String id) {
		ResultSet rs = db
				.getResultSet("select TenTaiKhoan from KHACHHANG where IdKhachHang = N'"
						+ id + "'");
		String tk = "";
		try {
			if (rs.next()) {
				tk = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return tk;
	}

	private String getIdQuanTri(String id) {
		ResultSet rs = db
				.getResultSet("select IdQuanTri from QUANTRI where TenTaiKhoan = N'"
						+ id + "'");
		String idQuanTri = "";
		try {
			if (rs.next()) {
				idQuanTri = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return idQuanTri;
	}

	public void deleteKhachHang(String id) {
		// TODO Auto-generated method stub
		String tenTaiKhoan = getTaiKhoan(id);
		String idQuantri = getIdQuanTri(tenTaiKhoan);
		db.updateData("delete from KHACHHANG where IdKhachHang=" + id + "");
		db.updateData("delete from QUANTRI where IdQuanTri=N'" + idQuantri
				+ "'");
		db.updateData("delete from TAIKHOAN where TenTaiKhoan='" + tenTaiKhoan
				+ "'");
	}

	public boolean isValidAccount(String userName, String password) {
		// TODO Auto-generated method stub
		ResultSet rs = db
				.getResultSet("select * from TAIKHOAN inner join KHACHHANG on KHACHHANG.TenTaiKhoan = TAIKHOAN.TenTaiKhoan "
						+ "where KHACHHANG.TenTaiKhoan=N'"
						+ userName
						+ "' and MatKhau=N'" + password + "'");
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
			return false;
		}
		return false;
	}

	public KHACHHANG getKhachHang(String userName) {
		// TODO Auto-generated method stub
		ResultSet rs = db
				.getResultSet("select IdKhachHang, DiemTichLuy, TAIKHOAN.TenTaiKhoan, MatKhau, HoTen, DiaChi, DienThoai, Email"
						+ " from KHACHHANG join TAIKHOAN on KHACHHANG.TenTaiKhoan=TAIKHOAN.TenTaiKhoan"
						+ " where TAIKHOAN.TenTaiKhoan = N'" + userName + "'");
		try {
			if (rs.next()) {
				return new KHACHHANG(rs.getInt(1), rs.getInt(2), new TAIKHOAN(
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public boolean isExistAccount(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		ResultSet rs = db
				.getResultSet("select IdKhachHang, DiemTichLuy, TAIKHOAN.TenTaiKhoan, MatKhau, HoTen, DiaChi, DienThoai, Email"
						+ " from KHACHHANG join TAIKHOAN on KHACHHANG.TenTaiKhoan=TAIKHOAN.TenTaiKhoan"
						+ " where TAIKHOAN.TenTaiKhoan = N'"
						+ tenTaiKhoan
						+ "'");
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return false;
	}

	public boolean addKhachHang(String tenTaiKhoan, String matKhau,
			String hoTen, String diaChi, String dienThoai, String email) {
		// TODO Auto-generated method stub
		if (isExistAccount(tenTaiKhoan))
			return false;
		return db.updateData("insert into TAIKHOAN values(N'" + tenTaiKhoan
				+ "',N'" + matKhau + "',N'" + hoTen + "',N'" + diaChi + "',N'"
				+ dienThoai + "',N'" + email + "')")
				&& db.updateData("insert into KHACHHANG values (N'"
						+ tenTaiKhoan + "','0')");
	}

}
