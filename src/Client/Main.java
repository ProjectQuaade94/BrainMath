package Client;

public class Main {


	public static void main(String[] args) throws NumberFormatException, Exception {

		TCPClient C = new TCPClient();
		User U = new User(C);
		Game G = new Game(U);
		G.game();			
	}
}
