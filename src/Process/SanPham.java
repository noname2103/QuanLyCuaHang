/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Process;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class SanPham {
         public Connect cn= new Connect();     
        //Truy van tat ca du lieu trong Table LoaiSP 
        public ResultSet ShowLoaiSP() throws SQLException{    
           cn.connectSQL(); 
           String sql = "SELECT * FROM SANPHAM";         
           return cn.LoadData(sql); 
        } 
        //Truy van cac dong du lieu trong Table LoaiSP theo Maloai 
        public ResultSet ShowLoaiSP(String ml) throws SQLException{    
           String sql = "SELECT * FROM SANPHAM where MaSP='" + ml +"'";         
           return cn.LoadData(sql); 
        } 
        //Theo moi 1 dong du lieu vao table LoaiSP 
        public void InsertData(String tensp, int maloai, int mamon, String mota, int dongia, int soluong) throws SQLException{    
           String sql = "INSERT INTO SANPHAM (TenSP, MaLoaiSP, MaMon, MoTa, DonGia, SoLuong) VALUES ('" +tensp+"', '" +maloai+"', '" +mamon + "', '"+mota+"', '"+dongia+"', '"+soluong+"')";  
           cn.UpdateData(sql); 
        } 
        //Dieu chinh 1 dong du lieu vao table LoaiSP 
        public void EditData(String ml, String tl) throws SQLException{    
           String sql = "Update LoaiSP set Tenloai=N'" + tl + "' where Maloai='" + ml +"'";         
           cn.UpdateData(sql); 
        } 
        //Xoa 1 dong du lieu vao table LoaiSP 
        public void DeleteData(String ml) throws SQLException{    
           String sql = "Delete from SANPHAM where MaSP ='" + ml +"'";         
           cn.UpdateData(sql); 
        } 
        //Truy van lieu trong Table Sanpham theo Maloai 
        public ResultSet ShowSPTheoloai(String ml) {            
        String sql = "SELECT MaSP,TenSP,Dongia,Tenloai  FROM Sanpham S, LoaiSP L  where L.Maloai=S.Maloai and L.Maloai='" + ml +"'";         
        return cn.LoadData(sql);
        
        
    } 
        public ResultSet ShowSanpham(String ml) throws SQLException{    
           String sql = "SELECT * FROM Sanpham where Maloai='" + ml +"'";         
           return cn.LoadData(sql); 
        } 
}
