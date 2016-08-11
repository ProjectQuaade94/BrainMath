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
	private String password = "";
	private String answer, column;
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
			System.err.println(e);		}
	}
	public String getData(int userId, String col) {
		try {
			res = stt.executeQuery("SELECT * FROM user WHERE userId = '" + userId + "'" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(col.equals("ba")){
			column = "userBalance";
		}
		
		try {
			while(res.next()){
				answer = res.getString(column);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("answer pulled from DB: " + answer);
		return answer;
	}

	public void setData(int userId, String col, String data) {
		System.out.println("userId: " + userId + " col: " + col + " data: " + data);		
	}
}

