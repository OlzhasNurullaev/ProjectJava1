package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DatabaseHandler extends Configs {
    static Connection connection = null;
    String url = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, dbUser, dbPass);
        return connection;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO `projectjava`.`users` (`firstname`, `lastname`, `username`, `password`, `email`, `gender`) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getEmail());
            prSt.setString(6, user.getGender());


            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void Answers(UserAns ans){
        String insertans="INSERT INTO `projectjava`.`answer` (`answer`) VALUES(?);";
        try{
            PreparedStatement prst1=getDbConnection().prepareStatement(insertans);
            prst1.setString(1,ans.getAnswer());
            prst1.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM `" + dbName + "`.`" + Const.USER_TABLE + "` WHERE (`" + Const.USER_USERNAME + "` = ?) AND (`" + Const.USER_PASSWORD + "` = ?);";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public void signUpUser(String text, String text1, String text2, String text3, String text4, String male, String text5) {
    }
    public void Answer(String text){}

    public ResultSet getAnswer(UserAns userAns) {
        ResultSet resSet = null;

        String select = "SELECT * FROM `" + dbName + "`.`" + ConstTest.USER_TABLE + "` WHERE (`" + ConstTest.USER_ANSWER + "` = ?);";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, userAns.getAnswer());
            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public Object getOperationType() {
        return null;
    }
}