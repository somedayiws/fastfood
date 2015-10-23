package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.bean.DONHANG;
import model.bean.SANPHAM;

public class DonHangDAO {

	DataBaseDAO db = new DataBaseDAO();

	public void deleteDonHang(String id) {
		// TODO Auto-generated method stub
		db.updateData("delete from CHITIETDONHANG where IdDonHang='" + id + "'");
		db.updateData("delete from DONHANG where IdDonHang='" + id + "'");
	}

	public DONHANG getDonHang(String id) {
		System.out.println("ID = " + id);
		DONHANG dh = new DONHANG();
		ResultSet rs = db
				.getResultSet("select DONHANG.IdDonHang, DONHANG.IdKhachHang, DONHANG.TenKhachHang, "
						+ "DONHANG.DiaChiNhanHang,DONHANG.IdChiNhanh,DONHANG.SoDienThoai, DONHANG.Email, "
						+ "DONHANG.TinhTrang, DONHANG.NgayLap, DONHANG.GhiChu, TONGTIEN.Tong   from DONHANG "
						+ "inner join (select sum((CHITIETDONHANG.SoLuong)*(SANPHAM.GiaBan)) as Tong , "
						+ "CHITIETDONHANG.IdDonHang from CHITIETDONHANG "
						+ "inner join SANPHAM on CHITIETDONHANG.IdSanPham = SANPHAM.IdSanPham "
						+ "group by CHITIETDONHANG.IdDonHang) TONGTIEN "
						+ "on DONHANG.IdDonHang = TONGTIEN.IdDonHang where DONHANG.IdDonHang='"
						+ id + "'");
		try {
			if (rs.next()) {
				dh = new DONHANG(rs.getString(1), rs.getInt(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getDate(9), rs.getString(10), rs.getInt(11));
				return dh;
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}

	public ArrayList<SANPHAM> getListSanPham(String id) {
		ArrayList<SANPHAM> lsp = new ArrayList<SANPHAM>();
		ResultSet rs = db
				.getResultSet("select CHITIETDONHANG.IdSanPham, TenSanPham, MoTa, GiaBan, CHITIETDONHANG.SoLuong, HinhAnh"
						+ " from CHITIETDONHANG, SANPHAM where IdDonHang='"
						+ id
						+ "' "
						+ "and CHITIETDONHANG.IdSanPham = SANPHAM.IdSanPham");
		try {
			while (rs.next()) {
				lsp.add(new SANPHAM(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getInt(4), rs.getInt(5), rs
						.getString(6)));
			}
			if (lsp.size() == 0)
				return null;
			return lsp;
		} catch (SQLException e) {
			return null;
		}
	}

	public String getTenKhach(String id) {
		ResultSet rs = db.getResultSet("select HoTen from KHACHHANG, TAIKHOAN "
				+ "where IdKhachHang='" + id
				+ "' and KHACHHANG.TenTaiKhoan = TAIKHOAN.TenTaiKhoan");
		String ten = "";
		try {
			if (rs.next())
				ten = rs.getString(1);
		} catch (SQLException e) {
			return "";
		}
		return ten;
	}

	public void deleteChiTietDonHang(String iddonhang, String idsanpham) {
		// TODO Auto-generated method stub
		db.updateData("delete from CHITIETDONHANG where IdDonHang='"
				+ iddonhang + "' and IdSanPham='" + idsanpham + "'");
	}

	public ArrayList<DONHANG> getDanhSachDonHang(String timkiem,
			String tinhTrang, String orderBy, int nRecord, int page) {
		String sql = "";
		ResultSet rs;
		sql = "select DONHANG.IdDonHang, DONHANG.IdKhachHang, DONHANG.TenKhachHang, "
				+ "DONHANG.DiaChiNhanHang,DONHANG.IdChiNhanh,DONHANG.SoDienThoai, DONHANG.Email, "
				+ "DONHANG.TinhTrang, DONHANG.NgayLap, DONHANG.GhiChu, TONGTIEN.Tong  from DONHANG "
				+ "inner join (select sum((CHITIETDONHANG.SoLuong)*(SANPHAM.GiaBan)) as Tong , "
				+ "CHITIETDONHANG.IdDonHang from CHITIETDONHANG "
				+ "inner join SANPHAM on CHITIETDONHANG.IdSanPham = SANPHAM.IdSanPham "
				+ "group by CHITIETDONHANG.IdDonHang) TONGTIEN "
				+ "on DONHANG.IdDonHang = TONGTIEN.IdDonHang ";

		sql += "where (DONHANG.IdDonHang like N'%" + timkiem
				+ "%' or DONHANG.TenKhachHang like N'%" + timkiem
				+ "%' or DiaChiNhanHang like N'%" + timkiem
				+ "%' or TinhTrang like N'%" + timkiem
				+ "%' or SoDienThoai like N'%" + timkiem + "%')";
		if (!tinhTrang.trim().equals(""))
			sql += " and DONHANG.TinhTrang=N'" + tinhTrang + "'";
		if (!orderBy.trim().equals(""))
			sql += " order by DONHANG." + orderBy;
		// System.out.println(sql);
		rs = db.getResultSet(sql);

		ArrayList<DONHANG> list = new ArrayList<DONHANG>();
		try {
			if (nRecord != -1) {
				db.paging(rs, nRecord, page, "DonHang");
				for (int i = 0; i < nRecord; i++) {
					rs.next();
					list.add(new DONHANG(rs.getString(1), rs.getInt(2), rs
							.getString(3), rs.getString(4), rs.getString(5), rs
							.getString(6), rs.getString(7), rs.getString(8), rs
							.getDate(9), rs.getString(10), rs.getInt(11)));
				}
			} else {
				while (rs.next()) {
					list.add(new DONHANG(rs.getString(1), rs.getInt(2), rs
							.getString(3), rs.getString(4), rs.getString(5), rs
							.getString(6), rs.getString(7), rs.getString(8), rs
							.getDate(9), rs.getString(10), rs.getInt(11)));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return list;
	}

	public int getSoLuongDonHang(String tinhTrang) {
		int soDonHang = 15;
		ResultSet rs = db
				.getResultSet("select count(*) as TongSo from DONHANG where TinhTrang = N'"
						+ tinhTrang + "'");
		try {
			while (rs.next()) {
				soDonHang = rs.getInt("TongSo");
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return soDonHang;
	}

	public void addDonHang(String tenkhach, String dienthoai, String email,
			String diachinhan, String chinhanh, String ghichu,
			ArrayList<SANPHAM> dsHang) {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// định
																			// dạng
																			// ngày
																			// giờ
		Date date = new Date(System.currentTimeMillis());// lấy ngày giờ hệ
															// thống
		String datestring = dateFormat.format(date);
		String iddonhang = getIdDonHang();
		db.updateData("insert into DONHANG(IdDonHang, DiaChiNhanHang, IdChiNhanh, SoDienThoai, Email, TinhTrang, NgayLap, GhiChu, TenKhachHang)"
				+ " values (N'"
				+ iddonhang
				+ "', N'"
				+ diachinhan
				+ "',N'"
				+ chinhanh
				+ "','"
				+ dienthoai
				+ "',N'"
				+ email
				+ "',N'Mới','"
				+ datestring + "',N'" + ghichu + "',N'" + tenkhach + "')");
		System.out
				.println("insert into DONHANG(IdDonHang, DiaChiNhanHang, IdChiNhanh, SoDienThoai, Email, TinhTrang, NgayLap, GhiChu, TenKhachHang)"
						+ " values (N'"
						+ iddonhang
						+ "', N'"
						+ diachinhan
						+ "',N'"
						+ chinhanh
						+ "','"
						+ dienthoai
						+ "',N'"
						+ email
						+ "',N'Mới','"
						+ datestring
						+ "',N'"
						+ ghichu
						+ "',N'" + tenkhach + "')");
		for (int i = 0; i < dsHang.size(); i++) {
			db.updateData("insert into CHITIETDONHANG values (N'" + iddonhang
					+ "', N'" + dsHang.get(i).getIdSanPham() + "', '"
					+ dsHang.get(i).getSoLuong() + "')");
		}

	}

	private String getIdDonHang() {
		ResultSet rs = db
				.getResultSet("select top 1 IdDonHang from DONHANG order by IdDonHang desc");
		String tk = "DH00000000";
		try {
			if (rs.next()) {
				tk = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		int so = Integer.parseInt(tk.substring(2)) + 1;
		tk = tk.substring(0, 10 - (so + "").length()) + so;
		System.out.println("Xem : " + tk);
		return tk;
	}

	public void addDonHang(String idKhachHang, String tenkhach,
			String dienthoai, String email, String diachinhan, String chinhanh,
			String ghichu, ArrayList<SANPHAM> dsHang) {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// định
																			// dạng
																			// ngày
																			// giờ
		Date date = new Date(System.currentTimeMillis());// lấy ngày giờ hệ
															// thống
		String datestring = dateFormat.format(date);
		String iddonhang = getIdDonHang();
		db.updateData("insert into DONHANG(IdDonHang, IdKhachHang, DiaChiNhanHang, IdChiNhanh, SoDienThoai, Email, TinhTrang, NgayLap, GhiChu, TenKhachHang)"
				+ " values (N'"
				+ iddonhang
				+ "','"
				+ idKhachHang
				+ "', N'"
				+ diachinhan
				+ "',N'"
				+ chinhanh
				+ "','"
				+ dienthoai
				+ "',N'"
				+ email
				+ "',N'Mới','"
				+ datestring
				+ "',N'"
				+ ghichu
				+ "',N'"
				+ tenkhach + "')");
		for (int i = 0; i < dsHang.size(); i++) {
			db.updateData("insert into CHITIETDONHANG values (N'" + iddonhang
					+ "', N'" + dsHang.get(i).getIdSanPham() + "', '"
					+ dsHang.get(i).getSoLuong() + "')");
		}
	}

	public boolean capNhatKetQuaDonHang(String idDonHang, String tinhTrang) {
		String sql = "update DONHANG set TinhTrang=N'" + tinhTrang
				+ "' where IdDonHang=N'" + idDonHang + "'";
		return db.updateData(sql);
	}

	public boolean chuyenChiNhanhDatHang(String idDonHang, String idChiNhanh) {
		String sql = "update DONHANG set IdChiNhanh='" + idChiNhanh
				+ "' where IdDonHang=N'" + idDonHang + "'";
		return db.updateData(sql);
	}

	public String getPageNav() {
		return db.getPageNav();
	}
}
