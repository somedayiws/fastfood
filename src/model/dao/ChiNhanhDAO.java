package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.CHINHANH;

public class ChiNhanhDAO {

	DataBaseDAO db = new DataBaseDAO();
	
	public ArrayList<CHINHANH> getDanhSachChiNhanh(String timkiem) {
		// TODO Auto-generated method stub
		System.out.println("select * from CHINHANH where IdChiNhanh like N'%"
				+ timkiem+"%' or TenChiNhanh like N'%"+timkiem+"%' or DiaChi like N'%"+timkiem+"%'");
		ResultSet rs = db.getResultSet("select * from CHINHANH where IdChiNhanh like N'%"
				+ timkiem+"%' or TenChiNhanh like N'%"+timkiem+"%' or DiaChi like N'%"+timkiem+"%'");
		ArrayList<CHINHANH> list = new ArrayList<CHINHANH>();
		try {
			while(rs.next()){
				list.add(new CHINHANH(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return list;
	}

	public CHINHANH getChiNhanh(String id) {
		// TODO Auto-generated method stub
		ResultSet rs = db.getResultSet("select * from CHINHANH where IdChiNhanh=N'" + id + "'");
		try {
			if(rs.next()){
				return new CHINHANH(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		return null;
	}

	public boolean addChiNhanh(String id, String chinhanh, String diachi) {
		// TODO Auto-generated method stub
		return db.updateData("insert into CHINHANH values (N'"+id+"',N'"+chinhanh+"',N'"+diachi+"')");
	}

	public boolean updateChiNhanh(String id, String chinhanh, String diachi) {
		// TODO Auto-generated method stub
		return db.updateData("update CHINHANH set TenChiNhanh=N'"+chinhanh+"', DiaChi=N'"+diachi+"' where IdChiNhanh=N'"+id+"'");
	}

	public boolean deleteChiNhanh(String id) {
		// TODO Auto-generated method stub
		return db.updateData("delete from CHINHANH where IdChiNhanh=N'"+id+"'");
	}
	public String getIdChiNhanh(String ichinhanh) {
		// TODO Auto-generated method stub
		ResultSet rs = db.getResultSet("select IdChiNhanh from CHINHANH where DiaChi=N'" + ichinhanh + "'");
		try {
			if(rs.next()){
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		return null;
	}
}
