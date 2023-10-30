package DAO;
import java.sql.*;
public class sqlConnect {
    private Connection C;
    private Statement S;
    private String dbName;
    private String userName;
    private String passWord;
            
    protected sqlConnect(){
        //sửa thông tin đăng nhập ở đây
        this.dbName="QLCH1";
        this.userName="sa";
        this.passWord="123456";
        connectTosql();
    }
    
    private void connectTosql(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.C=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;TrustServerCertificate=true;integratedSecurity=true;DatabaseName="+this.dbName+";user="+this.userName+";password="+this.passWord+";");
            this.S=C.createStatement();
        } catch (Exception e) {
            System.out.println("loi ket noi co so du lieu(r24,CONN): "+e);
        }
          
    }
    
    protected Statement getSta(){
        return this.S;
    }
    
    protected Connection getConnection() {
        return this.C;
    }
}
