package model.bo;

import java.util.ArrayList;

import model.bean.SANPHAM;

public class GioHangBO {
	
	public boolean KiemTraGioHang(ArrayList<SANPHAM> listGioHang, String id) {
		// kiểm tra hàng tồn tại không
		if(listGioHang == null) return false;
		for(int i=0; i<listGioHang.size(); i++){
			if(id.equals(listGioHang.get(i).getIdSanPham())){
				return true;
			}
		}
		return false;
	}

	public ArrayList<SANPHAM> CapNhatGioHang(ArrayList<SANPHAM> listGioHang, String id,
			String soluong) {
		// Cập nhật số lượng sản phẩm trong giỏ hàng, nếu về 0 thì xóa đi sản phẩm đó.
		ArrayList<SANPHAM> list = listGioHang;
		for(int i=0; i<list.size(); i++){
			if(id.equals(list.get(i).getIdSanPham())){
				list.get(i).setSoLuong(list.get(i).getSoLuong() + Integer.parseInt(soluong));
				if(list.get(i).getSoLuong()<1) list.remove(i);
				break;
			}
		}
		return list;
	}

	public ArrayList<SANPHAM> ThemGioHang(ArrayList<SANPHAM> listGioHang, String id,
			String soluong) {
		// Thêm một sản phẩm mới vào giỏ.
		ArrayList<SANPHAM> list = listGioHang;
		if(list==null) list = new ArrayList<SANPHAM>();
		SanPhamBO sanpham = new SanPhamBO();
		SANPHAM sp = sanpham.getSanPham(id);
		sp.setSoLuong(1);
		list.add(sp);
		return list;
	}

	public ArrayList<SANPHAM> XoaItemGioHang(ArrayList<SANPHAM> listGioHang, String id) {
		// TODO Auto-generated method stub
		ArrayList<SANPHAM> list = listGioHang;
		for(int i=0; i<list.size(); i++){
			if(id.equals(list.get(i).getIdSanPham())){
				list.remove(i);
				break;
			}
		}
		return list;
	}

}
