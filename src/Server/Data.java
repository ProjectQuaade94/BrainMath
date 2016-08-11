package Server;

public class Data {
	
	private String data, col, ret, ID;
	private int userId = -1;
	ConnectionMySQL cM;
	
	public Data(ConnectionMySQL cM){
		this.cM = cM;
	}

	public void doData(String clientSentence){
		
		deCode(clientSentence);
		if(returnData()){
			data = cM.getData(userId, col);
		}else{
			cM.setData(userId,col,clientSentence.substring(15, clientSentence.length()));				
		}
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
		System.out.println("The id found is:" + ID.substring(0,k)+ ":");
		
		try{
		userId = Integer.parseInt(ID.substring(0,k));
		}catch(Exception E){
			System.out.println(E.getMessage());
		}
		
		//get or set
		ret = cS.substring(10, 13);
		System.out.println("ret is: " + ret);
		
		//the col
		col=cS.substring(13,15);
		System.out.println("col is: " + col);
	}
	
	public boolean returnData(){
		if(ret.equals("get")){
			System.out.println("get = true");
			return true;
		}else{
			System.out.println("get = false");
			return false;			
		}
	}
	
	public String answer(){
		return data;
	}
	
}
