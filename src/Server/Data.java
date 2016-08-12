package Server;

public class Data {

	private String data, col, ret, ID, username, password;
	private int userId = -1;
	ConnectionMySQL cM;

	public Data(ConnectionMySQL cM){
		this.cM = cM;
	}

	public void doData(String clientSentence){

		deCode(clientSentence);
		if(ret.equals("get")){
			data = cM.getData(userId, col);
		}else if(ret.equals("set")){
			data = cM.setData(userId,col,clientSentence.substring(15, clientSentence.length()));				
		}else if(ret.equals("clo")){
			data ="close";
		}else if(ret.equals("fin")){
			data = cM.findUser(clientSentence.substring(15, clientSentence.length()));
		}else if(ret.equals("cre")){
			deCodeUP(clientSentence.substring(15,clientSentence.length()));
			data = cM.creatUser(username,password);
		}
	}

	private void deCodeUP(String input) {
		int k = 0;
		for(int i=0; i<input.length();i++){
			if(input.substring(i,i+1).equals(" ")){
				k=i;
				break;
			}
		}
		username = input.substring(0,k);
		password = input.substring(k+1, input.length());
		System.out.println("DeCodeUP User: " + username + " Password: " + password);
	}

	private void deCode(String cS) {

		//the ID
		ID = cS.substring(0, 10);
		int k=-1;
		for(int i=10; i>=0; i--){
			if(ID.substring(i-1, i).equals(" ")){

			}else{
				k = i;
				break;
			}
		}
		System.out.println("The userId that was decoded is:" + ID.substring(0,k)+ ":");

		try{
			userId = Integer.parseInt(ID.substring(0,k));
		}catch(Exception E){
			System.out.println(E.getMessage());
		}

		//get or set
		ret = cS.substring(10, 13);

		//the col
		col=cS.substring(13,15);
	}

	public String answer(){
		return data;
	}

}
