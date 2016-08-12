package Client;

public class User{

	private String userId, ret, col, message;
	TCPClient C;

	public User(TCPClient c) {
		this.C = c;

	}

		public int createUser(String userName, String userPassword)throws Exception{
			userId = "0";
			ret = "cre";
			col = "xx";
			message = userName + " " + userPassword;
			return Integer.parseInt(C.client(userId, ret, col, message));
		}
	
	public int findUserId(String userName) throws NumberFormatException, Exception{
		userId = Integer.toString(0);
		ret = "fin";
		col = "xx";
		message = userName.toLowerCase();
		String answer = C.client(userId, ret, col, message);
		if(answer.equals("failed")){
			return -1;
		}
		return Integer.parseInt(answer);
	}
	
	public int getUserId(int index) throws NumberFormatException, Exception{
		//		return (userArray.get(index)).getUserId();
		userId = Integer.toString(index);
		ret = "get";
		col = "id";
		message = "";
		return Integer.parseInt(C.client(userId, ret, col, message));
	}

	public void setUserId(int index, int ID) throws Exception{
		//		(userArray.get(index)).setUserId(userId);
		userId = Integer.toString(index);
		ret = "set";
		col = "id";
		message = Integer.toString(ID);
		C.client(userId, ret, col, message);
	}

	public String getUserName(int index) throws Exception{
		//		return (userArray.get(index)).getUserName();
		userId = Integer.toString(index);
		ret = "get";
		col = "na";
		message = "";
		String userName = C.client(userId, ret, col, message);
		return userName.substring(0, 1).toUpperCase() + userName.substring(1,userName.length());
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
		col = "pa";
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
		col = "ba";
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
		col = "di";
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
		col = "mo";
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
	
	public void closeConnection() throws Exception{
		userId = Integer.toString(0);
		ret = "clo";
		col = "xx";
		message = "";
		C.client(userId, ret, col, message);
	}

}
