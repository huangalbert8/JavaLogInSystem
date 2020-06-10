import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(!in.equals("q")) {
            System.out.println("Insert or View: ");
            String option = in.next();
            try {
                String host = "jdbc:mysql://localhost:3306/LogIn?" + "autoReconnect=true&useSSL=false";
                String uname = "root";
                String upass = "burt";
                Connection con = DriverManager.getConnection(host, uname, upass);
                Statement stat = con.createStatement();
                if (option.equals("v")) {
                    String sql = "select * from UserEmails";
                    ResultSet rs = stat.executeQuery(sql);
                    while (rs.next()) {
                       // int id_col = rs.getInt("ID");
                        String email = rs.getString("Email");
                        String password = rs.getString("Password");
                        String username = rs.getString("Username");
                        String p = email + " " + password + " " + username;
                        System.out.println(p);
                    }
                } else if (option.equals("i")) {
                    System.out.println("Enter Email: ");
                    String email = in.next();
                    System.out.println("Password: ");
                    String password = in.next();
                    System.out.println("Username: ");
                    String username = in.next();
                    PreparedStatement sql = con.prepareStatement("INSERT INTO UserEmails (Email, Password, Username) VALUES ('"+email+"', '" + password + "', '" +username + "')");
                    sql.executeUpdate();

                } else
                    System.exit(0);
            } catch (SQLException ex) {
                System.out.println("Email is already in use.");
            }
        }
    }
}
