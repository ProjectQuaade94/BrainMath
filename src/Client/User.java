package Client;

public class User{

	//TODO: remove the initialized data 

	private String userId = "0", ret="set", col="ba", message = "10", ask;
	TCPClient C;

	public User(TCPClient c) {
		this.C = c;

	}

	//	public void addUser(int userId, int userBalance, String userName, String userPassword, int userDifficulty, int userMode, int userSkip){
	//		userArray.add(new ur(userId, userBalance, userName, userPassword, userDifficulty, userMode, userSkip));
	//	}

	public void setUserId(int index, int ID) throws Exception{
		//		(userArray.get(index)).setUserId(userId);
		userId = Integer.toString(index);
		ret = "set";
		col = "mo";
		message = Integer.toString(ID);
		C.client(userId, ret, col, message);
	}

	public int getUserId(int index) throws NumberFormatException, Exception{
		//		return (userArray.get(index)).getUserId();
		userId = Integer.toString(index);
		ret = "get";
		col = "sk";
		message = "";
		return Integer.parseInt(C.client(userId, ret, col, message));
	}


	public String getUserName(int index) throws Exception{
		//		return (userArray.get(index)).getUserName();
		userId = Integer.toString(index);
		ret = "get";
		col = "sk";
		message = "";
		return C.client(userId, ret, col, message);
	}

	public void setUserName(int index, String userName) throws Exception {
		//		(userArray.get(index)).setUserName(userName);
		userId = Integer.toString(index);
		ret = "set";
		col = "na";
		message = userName;
		C.client(userId, ret, col, message);
	}

	public String getPassword(int index) throws Exception{		
		//		return (userArray.get(index)).getUserPassword();
		userId = Integer.toString(index);
		ret = "get";
		col = "sk";
		message = "";
		return C.client(userId, ret, col, message);
	}

	public void setPassword(int index, String pwd) throws Exception{
		//		(userArray.get(index)).setUserPassword(pwd);
		userId = Integer.toString(index);
		ret = "set";
		col = "pa";
		message = pwd;
		C.client(userId, ret, col, message);
	}

	public int getBalance(int index) throws NumberFormatException, Exception{
		//		return (userArray.get(index)).getUserBalance();
		userId = Integer.toString(index);
		ret = "get";
		col = "sk";
		message = "";
		return Integer.parseInt(C.client(userId, ret, col, message));
	}

	public void setBalance(int index, int balance) throws Exception{
		//		(userArray.get(index)).setUserBalance(balance);
		userId = Integer.toString(index);
		ret = "set";
		col = "ba";
		message = Integer.toString(balance);
		C.client(userId, ret, col, message);
	}

	public int getDifficulty(int index) throws NumberFormatException, Exception{
		//		return (userArray.get(index)).getUserDifficulty();
		userId = Integer.toString(index);
		ret = "get";
		col = "sk";
		message = "";
		return Integer.parseInt(C.client(userId, ret, col, message));
	}

	public void setDifficulty(int index, int difficulty) throws Exception{
		//		(userArray.get(index)).setUserDifficulty(difficulty);
		userId = Integer.toString(index);
		ret = "set";
		col = "di";
		message = Integer.toString(difficulty);
		C.client(userId, ret, col, message);
	}

	public int getMode(int index) throws NumberFormatException, Exception{
		//		return (userArray.get(index)).getUserMode();
		userId = Integer.toString(index);
		ret = "get";
		col = "sk";
		message = "";
		return Integer.parseInt(C.client(userId, ret, col, message));
	}

	public void setMode(int index, int mode) throws Exception{
		//		(userArray.get(index)).setUserMode(mode);
		userId = Integer.toString(index);
		ret = "set";
		col = "mo";
		message = Integer.toString(mode);
		C.client(userId, ret, col, message);
	}

	public int getSkip(int index) throws NumberFormatException, Exception{
		//		return (userArray.get(index)).getUserSkip();
		userId = Integer.toString(index);
		ret = "get";
		col = "sk";
		message = "";
		return Integer.parseInt(C.client(userId, ret, col, message));

	}

	public void setSkip(int index, int skip) throws Exception{
//		(userArray.get(index)).setUserSkip(skip);
		userId = Integer.toString(index);
		ret = "set";
		col = "sk";
		message = Integer.toString(skip);
		C.client(userId, ret, col, message);
	}

	//	public int getUserArrayLength(){
	//		return userArray.size();
	//	}


	//	public void removeUser(int index){
	//		userArray.remove(index);
	//	}

	//	private class ur {
	//
	//
	//		private int userId;
	//		private int userBalance;
	//		private String userName;
	//		private String userPassword;
	//		private int userDifficulty;
	//		private int userMode;
	//		private int userSkip;
	//
	//		private ur(int userId, int userBalance, String username, String userPassword, int userDifficulty, int userMode, int userSkip){
	//
	//			this.userPassword = userPassword;
	//			this.userName = username;
	//			this.userId = userId;
	//			this.userBalance = userBalance;
	//			this.userDifficulty = userDifficulty;
	//			this.userMode = userMode;
	//			this.userSkip = userSkip;
	//		}
	//
	//		private int getUserId() {
	//			return userId;
	//		}
	//
	//		private void setUserId(int oprId) {
	//			this.userId = oprId;
	//		}
	//
	//		private String getUserName() {
	//			return userName;
	//		}
	//
	//		private void setUserName(String oprNavn) {
	//			this.userName = oprNavn;
	//		}
	//
	//		private String getUserPassword() {
	//			return userPassword;
	//		}
	//
	//		private void setUserPassword(String pwd) {
	//			this.userPassword = pwd;
	//		}
	//
	//		private int getUserBalance(){
	//			return userBalance;
	//		}
	//		
	//		private void setUserBalance(int balance) {
	//			this.userBalance = balance;
	//		}
	//		
	//		private int getUserDifficulty(){
	//			return userDifficulty;
	//		}
	//		
	//		private void setUserDifficulty(int difficulty) {
	//			this.userDifficulty = difficulty;
	//		}
	//		
	//		private int getUserMode(){
	//			return userMode;
	//		}
	//		
	//		private void setUserMode(int mode) {
	//			this.userMode = mode;
	//		}
	//		
	//		private int getUserSkip(){
	//			return userSkip;
	//		}
	//		
	//		private void setUserSkip(int skip) {
	//			this.userSkip = skip;
	//		}
	//
	//	}
}
