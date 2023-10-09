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
        this.dbName="DatabaseName=QLCH;";
        this.userName="user=DESKTOP-B4S6KHS\\Wazapy;";
        this.passWord="password='';";
        connectTosql();
    }
    
    private void connectTosql(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.C=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;TrustServerCertificate=true;integratedSecurity=true;"+this.dbName+this.userName+this.passWord);
            this.S=C.createStatement();
        } catch (Exception e) {
            System.out.println("loi ket noi co so du lieu(r24,CONN): "+e);
        }
    }
    
    protected Statement getSta(){
        return this.S;
    }
}
