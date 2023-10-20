package DAO;
import java.sql.*;
public class sqlConnect {
    private Connection con;
    private Statement S;
    private String dbName;
    private String userName;
    private String passWord;
            
    protected sqlConnect(){
        //sửa thông tin đăng nhập ở đây
        this.dbName="QLCH";
        this.userName="sa";
        this.passWord="123";
        connectTosql();
    }
    
    private void connectTosql(){
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            this.C=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;TrustServerCertificate=true;integratedSecurity=true;DatabaseName="+this.dbName+";user="+this.userName+";password="+this.passWord+";");
//            this.S=C.createStatement();
//        } catch (Exception e) {
//            System.out.println("loi ket noi co so du lieu(r24,CONN): "+e);
//        }
          try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "localhost";
            String DatabaseName="QLCH" ;
            String TenDangNhap = "sa"; 
            String MatKhau= "123";
            String url = "jdbc:sqlserver://" +dbUrl + ":1433;DatabaseName=" + DatabaseName + ";username="+TenDangNhap+";password="+MatKhau+";encrypt=true;trustServerCertificate=true;";
            con=DriverManager.getConnection(url);         
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    
    protected Statement getSta(){
        return this.S;
    }
    
    protected Connection getConnection() {
        return this.C;
    }
}
