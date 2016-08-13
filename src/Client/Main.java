package Client;

public class Main {


	public static void main(String[] args) throws NumberFormatException, Exception {
		
		TCPClient C = new TCPClient();
		DTO U = new DTO(C);
		Game G = new Game(U);
		MainGUI GUI = new MainGUI(G);
		GUI.mainGUI();		
	}
}
