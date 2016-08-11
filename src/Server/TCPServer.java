package Server;

import java.io.*;
import java.net.*;

import Game.User;


class TCPServer{
	public static void main(String argv[]) throws Exception{
		
		
		
		String clientSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		ConnectionMySQL CM = new ConnectionMySQL();
		Data D = new Data(CM);
		
		CM.connectMySQL();
		
		while(true){
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("Received: " + clientSentence);
			D.doData(clientSentence);
			if(D.returnData()){
				outToClient.writeBytes(D.answer());
			}
		}
	}
}