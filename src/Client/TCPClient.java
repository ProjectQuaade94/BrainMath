package Client;

import java.io.*;
import java.net.*;

class TCPClient{
	String toServer;
	String fromServer;
	
	public String client(String userId, String ret, String col, String message) throws Exception{
		
		for(int i = 0; i<10; i++){
			if(userId.length()<10){
				userId+= " ";
			}
		}
		toServer = userId + ret + col + message;

		Socket clientSocket;
		DataOutputStream outToServer;
		BufferedReader inFromServer;
		clientSocket = new Socket("82.211.208.220", 6789);
		outToServer = new DataOutputStream(clientSocket.getOutputStream());
		inFromServer = new BufferedReader(new InputStreamReader   (clientSocket.getInputStream()));			
		outToServer.writeBytes(toServer + '\n');
		fromServer = inFromServer.readLine();
		clientSocket.close();
		return fromServer;
	}
}