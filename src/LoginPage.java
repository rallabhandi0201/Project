import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class LoginPage {
    private String validateLogin(String uname,String pass) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/root","root","Sairam@0201");
            Statement st = con.createStatement();
            String query = "SELECT u_name FROM users where u_name = "+ uname + " and pass = "+pass+";";
            ResultSet rs = st.executeQuery(query);
            return rs.getString(1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Select the option");
            int choice = Integer.parseInt(br.readLine());
            System.out.println("1. Login\n2. Sign Up\n3. Register");
            switch (choice){
                case 1:{
                    System.out.print("Username : ");
                    String uname = br.readLine();
                    System.out.print("Password : ");
                    String pass = br.readLine();
                    if(new LoginPage().validateLogin(uname,pass).equals("")){
                        System.out.println("Wrong Username or Password");
                    }
                    else{
                        System.out.println("Welcome "+new LoginPage().validateLogin(uname,pass));
                    }
                }
            }
        }
    }
}
