package Server;

import java.io.*;
import java.net.*;

import Client.User;


class TCPServer{
	public static void main(String[] args) throws Exception{

		String fromClient;
		String toClient;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		ConnectionMySQL CM = new ConnectionMySQL();
		Data D = new Data(CM);
		CM.connectMySQL();

		int i=0;
		while(true){

			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			fromClient = inFromClient.readLine();
			System.out.println("SERVER RECIEVED ID("+i+"): " + fromClient);
			D.doData(fromClient);
			toClient = D.answer();
			if(toClient.equals("close")){
				break;
			}else{
				outToClient.writeBytes(toClient + '\n');
				System.out.println("SERVER SENT ID("+i+"): " + toClient);
				i++;
			}
		}
	}
}