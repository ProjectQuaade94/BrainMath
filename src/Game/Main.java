package Game;

public class Main {

	private static Game G = new Game();

	public static void main(String[] args) {
		while(true){
			G.game();
			try{
				Thread.sleep(15000);
			}catch(Exception e){

			}
		}
	}
}
