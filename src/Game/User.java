package Game;

import java.util.ArrayList;


public class User{

	private ArrayList<ur> userArray = new ArrayList<ur>();

	public User(){
		this.addUser(0, 0, "Quaade94", "password", 1, 1, 5);
	}

	public void addUser(int userId, int userBalance, String username, String userPassword, int userDifficulty, int userMode, int userSkip){
		userArray.add(new ur(userId, userBalance, username, userPassword, userDifficulty, userMode, userSkip));
	}

	public void setUserId(int index, int userId){
		(userArray.get(index)).setUserId(userId);
	}

	public int getUserId(int index){
		return (userArray.get(index)).getUserId();
	}

	public void setUserName(int index, String userName) {
		(userArray.get(index)).setUserName(userName);
	}
	
	public String getUserName(int index){
		return (userArray.get(index)).getUserName();
	}

	public String getPassword(int index){		
		return (userArray.get(index)).getUserPassword();
	}

	public void setPassword(int index, String pwd){
		(userArray.get(index)).setUserPassword(pwd);;
	}

	public int getBalance(int index){
		return (userArray.get(index)).getUserBalance();
	}

	public void setBalance(int index, int balance){
		(userArray.get(index)).setUserBalance(balance);
	}
	
	public int getDifficulty(int index){
		return (userArray.get(index)).getUserDifficulty();
	}

	public void setDifficulty(int index, int difficulty){
		(userArray.get(index)).setUserDifficulty(difficulty);
	}
	public int getMode(int index){
		return (userArray.get(index)).getUserMode();
	}

	public void setMode(int index, int mode){
		(userArray.get(index)).setUserMode(mode);
	}
	
	public int getSkip(int index){
		return (userArray.get(index)).getUserSkip();
	}

	public void setSkip(int index, int skip){
		(userArray.get(index)).setUserSkip(skip);
	}

	public int getUserArrayLength(){
		return userArray.size();
	}
	
	public void removeUser(int index){
		userArray.remove(index);
	}

	private class ur {


		private int userId;
		private int userBalance;
		private String userName;
		private String userPassword;
		private int userDifficulty;
		private int userMode;
		private int userSkip;

		private ur(int userId, int userBalance, String username, String userPassword, int userDifficulty, int userMode, int userSkip){

			this.userPassword = userPassword;
			this.userName = username;
			this.userId = userId;
			this.userBalance = userBalance;
			this.userDifficulty = userDifficulty;
			this.userMode = userMode;
			this.userSkip = userSkip;
		}

		private int getUserId() {
			return userId;
		}

		private void setUserId(int oprId) {
			this.userId = oprId;
		}

		private String getUserName() {
			return userName;
		}

		private void setUserName(String oprNavn) {
			this.userName = oprNavn;
		}

		private String getUserPassword() {
			return userPassword;
		}

		private void setUserPassword(String pwd) {
			this.userPassword = pwd;
		}

		private int getUserBalance(){
			return userBalance;
		}
		
		private void setUserBalance(int balance) {
			this.userBalance = balance;
		}
		
		private int getUserDifficulty(){
			return userDifficulty;
		}
		
		private void setUserDifficulty(int difficulty) {
			this.userDifficulty = difficulty;
		}
		
		private int getUserMode(){
			return userMode;
		}
		
		private void setUserMode(int mode) {
			this.userMode = mode;
		}
		
		private int getUserSkip(){
			return userSkip;
		}
		
		private void setUserSkip(int skip) {
			this.userSkip = skip;
		}

	}
}
