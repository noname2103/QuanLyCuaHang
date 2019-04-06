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
 * @author trung
 */
public class MonTheThao {
    public Connect cn= new Connect();     
        //Truy van tat ca du lieu trong Table LoaiSP 
        public ResultSet ShowMonTheThao() throws SQLException{    
           cn.connectSQL(); 
           String sql = "SELECT * FROM MONTHETHAO";         
           return cn.LoadData(sql); 
        } 
        //Truy van cac dong du lieu trong Table LoaiSP theo Maloai 
        public ResultSet ShowMon(String ml) throws SQLException{    
           String sql = "SELECT * FROM MONTHETHAO where MaMon='" + ml +"'";         
           return cn.LoadData(sql); 
        } 
        //Theo moi 1 dong du lieu vao table LoaiSP 
        public void InsertData(String tl) throws SQLException{    
           String sql = "INSERT INTO MONTHETHAO values(N'" + tl +"')";  
           cn.UpdateData(sql); 
        } 
        //Dieu chinh 1 dong du lieu vao table LoaiSP 
        public void EditData(String ml, String tl) throws SQLException{    
           String sql = "Update MONTHETHAO set TenMon=N'" + tl + 
"' where Maloai='" + ml +"'";         
           cn.UpdateData(sql); 
        } 
        //Xoa 1 dong du lieu vao table LoaiSP 
        public void DeleteData(String ml) throws SQLException{    
           String sql = "Delete from MONTHETHAO where MaMon='" + ml +"'";         
           cn.UpdateData(sql); 
        } 
        //Truy van lieu trong Table Sanpham theo Maloai 
        public ResultSet ShowSPTheoMon(String ml) {            
        String sql = "SELECT MaSP,TenSP,Dongia,TenMon  FROM Sanpham S, LoaiSP L  where L.MaMon=S.MaMon and L.MaMon='" + ml +"'";         
        return cn.LoadData(sql);
        
        
    } 
        public ResultSet ShowSanpham(String ml) throws SQLException{    
           String sql = "SELECT * FROM Sanpham where MaMon='" + ml +"'";         
           return cn.LoadData(sql); 
        } 
}
