package Server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class ConnectionMySQL {

	private String url = "jdbc:mysql://localhost:3306";
	private String user = "root";
	private String password = "Password123!";
	private String answer = "", column, userId;
	private int dataInput;
	ResultSet res;
	Statement stt;

	public void connectMySQL(){

		try{

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Success");
			stt = conn.createStatement();
			stt.execute("USE BrainMath");
			//			stt.execute("INSERT INTO user(userId, UserBalance, userName, userPassword, userDifficulty, userMode, userSkip) VALUES" + "('0', '0', 'Quaade94', 'password', '1', '1', '5')");

		} catch (Exception e){
			System.err.println(e);		
		}
	}
	
	public String findUser(String userName) {
		System.out.println("looking for " + userName + " in DB");
		try {
			res = stt.executeQuery("SELECT * FROM user WHERE userName = '" + userName + "'" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(res.next()){
				answer = res.getString("userId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Returning answer from DB: " + answer);
		if(answer.equals("")){
			return "failed";
		}
		
		return answer;
	}
	public String creatUser(String username, String password) {
		try {
			res = stt.executeQuery("SELECT COUNT(*) FROM user" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(res.next()){
				answer = res.getString(userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stt.execute("INSERT INTO user('userId', 'userBalance', 'userName', 'userPassword', 'userDifficulty', 'userMode', 'userSkip') VALUES("+Integer.parseInt(answer)+", "+0+", '"+username+"', '"+password+"', "+1+", "+1+", "+10+")");
			System.out.println("DB: Successfully created user " + username);
		} catch (SQLException e) {
			System.out.println("DB: Failed to create user: " + username);
			e.printStackTrace();
		}
		return answer;
	}
	
	
	public String getData(int ID, String col) {
		try {
			res = stt.executeQuery("SELECT * FROM user WHERE userId = '" + ID + "'" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(col.equals("id")){
			column = "userId";
		}if(col.equals("ba")){
			column = "userBalance";
		}else if(col.equals("na")){
			column = "userName";
		}else if(col.equals("pa")){
			column = "userPassword";
		}else if(col.equals("di")){
			column = "userDifficulty";
		}else if(col.equals("mo")){
			column = "userMode";
		}else if(col.equals("sk")){
			column = "userSkip";
		}else{
			System.out.println("column text error (ConnectionMySQL)");
		}

		try {
			while(res.next()){
				answer = res.getString(column);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Returning answer from DB: " + answer);
		return answer;
	}

	public String setData(int ID, String col, String data) {
		if(col.equals("id")){
			column = "userId";
			dataInput = Integer.parseInt(data);
		}else if(col.equals("ba")){
			column = "userBalance";
			dataInput = Integer.parseInt(data);
		}else if(col.equals("na")){
			column = "userName";
		}else if(col.equals("pa")){
			column = "userPassword";
		}else if(col.equals("di")){
			column = "userDifficulty";
			dataInput = Integer.parseInt(data);
		}else if(col.equals("mo")){
			column = "userMode";
			dataInput = Integer.parseInt(data);
		}else if(col.equals("sk")){
			column = "userSkip";
			dataInput = Integer.parseInt(data);
		}else{
			System.out.println("column text error (ConnectionMySQL)");
		}
		if(column.equals("userName") || column.equals("userPassword")){
			try {
				stt.execute("UPDATE user SET " + column + " = " + data + " WHERE userId=" + ID);
				System.out.println("DB: Successfully updated " + column + " with " + dataInput + " for userId: " + ID);
			} catch (SQLException e) {
				System.out.println("DB: Failed to update " + column + " with " + dataInput + " for userId: " + ID);
				e.printStackTrace();
			}
		}else{
			try {
				stt.execute("UPDATE user SET " + column + " = " + dataInput + " WHERE userId=" + ID);
				System.out.println("DB: Successfully updated " + column + " with " + dataInput + " for userId: " + ID);
			} catch (SQLException e) {
				System.out.println("DB: Failed to update " + column + " with " + dataInput + " for userId: " + ID);
				e.printStackTrace();
			}
		}
		System.out.println("userId: " + ID + " col: " + col + " data: " + data);
		return "Success";
	}


}

