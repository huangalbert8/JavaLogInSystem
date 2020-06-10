import java.sql.*;

public class LogIn {
    private String email;
    private String password;
    private String username;

    public LogIn() {

    }

    public static boolean signUp(String email, String password) {
        try {
            String host = "jdbc:mysql://localhost:3306/LogIn?" + "autoReconnect=true&useSSL=false";
            String uname = "root";
            String upass = "burt";
            Connection con = DriverManager.getConnection(host, uname, upass);
            PreparedStatement sql = con.prepareStatement("INSERT INTO UserEmails (Email, Password) VALUES ('"+email+"', '" + password + "')");
            sql.executeUpdate();
            return true;

        }catch (SQLException ex){
            System.out.println(ex.getErrorCode());
            return false;
        }

        }

     public static boolean logIn(String email, String password) {
        try {
            String host = "jdbc:mysql://localhost:3306/LogIn?" + "autoReconnect=true&useSSL=false";
            String uname = "root";
            String upass = "burt";
            Connection con = DriverManager.getConnection(host, uname, upass);
            Statement stat = con.createStatement();
            String sql = "SELECT * FROM LogIn.UserEmails where Email = '"+email+"';";
            ResultSet rs = stat.executeQuery(sql);
            String pass = "";
            while(rs.next()){
            pass = rs.getString("Password");}

                if(pass.equals(password)){
                    return true;
                }
                else
                return false;
        }catch (SQLException ex){
            System.out.println(ex.getErrorCode());
            return false;
        }

    }
    }
