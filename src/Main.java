import javax.sound.midi.Soundbank;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String url= "jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String Password="Shukla@2020";

        String query= "delete from employees where id=104;";
        String query1="Select * from employees;";

        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, username, Password);
            Statement stmt= conn.createStatement();
            int affected_rows = stmt.executeUpdate(query);
            ResultSet rst= stmt.executeQuery(query1);


            if (affected_rows>0){
                System.out.println("Insertion Successful "+ affected_rows +" row(s) affected");
            }
            else{
                System.out.println("insertion unsuccessful!");
            }

            while (rst.next()){
                int id = rst.getInt("id");
                String name= rst.getString("name");
                String job=rst.getString("job");
                Double salary=rst.getDouble("salary");

                System.out.println();
                System.out.println("-----------------------");

                System.out.println("Id: "+ id);
                System.out.println("name: "+ name);
                System.out.println("job: "+ job);
                System.out.println("salary: "+salary);
            }


            rst.close();
            stmt.close();
            conn.close();

            System.out.println();
            System.out.println("Connection Closed");

        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());

        }
    }
}