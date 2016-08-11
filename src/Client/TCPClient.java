package Client;

import java.io.*;
import java.net.*;

class TCPClient{
	static String toServer;
	static String fromServer;
	
	public static void main(String argv[]) throws Exception{
		
		Socket clientSocket;
		DataOutputStream outToServer;
		BufferedReader inFromServer;
		User U = new User();
		Game G = new Game();
		
		//		G.game();
		
		toServer = U.enCoder();
		clientSocket = new Socket("localhost", 6789);
		outToServer = new DataOutputStream(clientSocket.getOutputStream());
		inFromServer = new BufferedReader(new InputStreamReader   (clientSocket.getInputStream()));			
		toServer = U.enCoder();
		outToServer.writeBytes(toServer + '\n');
		fromServer = inFromServer.readLine();
		System.out.println(fromServer);
		clientSocket.close();
	}
	public String getAnswer(){
		return fromServer;
	}
}