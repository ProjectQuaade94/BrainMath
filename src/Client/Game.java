package Client;

import java.util.Scanner;

public class Game {

	private int q, tq = 10, coins = 0,ans1,ans2,ans,input,mode,difficulty,nrAmount,userId=-1,skip, currentBalance;
	private String sign, userName, userPassword;
	private String strMode[] = {"'+' (Addition)","'-' (Subtraction)","'*' (Multiplication)","'/' (Division)"};
	private String strDifficulty[] = {"Very Easy","Easy","Medium","Hard","Challenge Mode"};
	private Scanner sc = new Scanner(System.in);
	DTO U;

	public Game(DTO u) {
		this.U = u;
	}

	public void game() throws NumberFormatException, Exception {

		//Login
		//		startUp();
		while(true){
			menu();

			//Game Loop
			while(true){

				//stops the game at X questions
				q++;
				question();
				if(q>=tq){
					break;			}
			}
			currentBalance = U.getBalance(userId);
			U.setBalance(userId, (currentBalance + coins));
			pr("##################################################");
			pr("Level Complete!");
			if(difficulty == 5){
				pr("Level Score: "+ coins + "/" + q*25);

			}else{
				pr("Level Score: "+ coins + "/" + q*5);
			}
			pr("Skips spent: " + (U.getSkip(userId)-skip) + "     Skips left: " + skip);
			U.setSkip(userId, skip);
			pr("");
			pr("+" + coins + " Coins earned by " + U.getUserName(userId));
			coins = 0;
			pr(U.getUserName(userId) + "'s total Coins: " + U.getBalance(userId));
			pr("");
			pr("Press 0 to continue...!");
			q = 0;
			input = input();
			if(input==0){
			}
		}
	}

	public int createUser(String username, String password1, String password2) throws NumberFormatException, Exception {
		int ans = 0;
			pr("CREATE USER");
			pr("Create Username:");
			userName = username;
			if(userName.length() >= 4){
			if(U.findUserId(userName) == -1){
					pr("Create Password:");
					userPassword = password1;
					pr("Type it again:");
					if(userPassword.length() >= 5){
					if(userPassword.equals(password2)){
						userId = U.createUser(userName, userPassword.toLowerCase());
						pr("User created!");
						userName = U.getUserName(userId);
						userPassword = U.getPassword(userId);
						difficulty = U.getDifficulty(userId);
						mode = U.getMode(userId);
						skip = U.getSkip(userId);
						currentBalance = U.getBalance(userId);
						ans = 0;
					}else{
						ans = 2;
						pr("The passwords did not match!");
					}
					}else{
						//password too short
						ans = 4;
					}
			}else{
				ans = 1;
				pr("That username already exists");			
			}
			}else{
				ans = 3;
			}
			return ans;
	}

	public int login(String username, String password) throws NumberFormatException, Exception {
		int ans = 0;
		pr("LOGIN");
		pr("Username: ");
		
		if(username.length()>=1){
		userId = U.findUserId(username);
		}else{
			ans = 4;
		}
		if(userId == -1){
			ans = 1;
		}else{
			pr("Password: ");
			if(password.length() >= 1){
			if(password.equals(U.getPassword(userId))){
				userName = U.getUserName(userId);
				userPassword = U.getPassword(userId);
				difficulty = U.getDifficulty(userId);
				mode = U.getMode(userId);
				skip = U.getSkip(userId);
				currentBalance = U.getBalance(userId);
				ans = 0;
			}else{
				ans = 2;
				pr("Wrong Password");
			}
			}else{
				ans = 3;
			}
		}
		return ans;
	}

	private void askMode() throws Exception {
		while(true){
			pr("Select Mode:");
			pr("1: + (Addition)");
			pr("2: - (Subtraction)");
			pr("3: * (Multiplication)");
			pr("4: / (Division)");
			input = -1;
			input = input();

			if(input == 1){
				mode = 1;
				pr("Selected: " + strMode[mode-1]);
				break;
			}else if (input == 2){
				mode = 2;
				pr("Selected: " + strMode[mode-1]);
				break;
			}else if (input == 3){
				mode = 3;
				pr("Selected: " + strMode[mode-1]);
				break;
			}else if (input == 4){
				mode = 4;
				pr("Selected: " + strMode[mode-1]);
				break;
			}
		}
		U.setMode(userId, mode);
	}
	private void askDifficulty() throws Exception {
		while(true){
			pr("Select Difficulty:");
			pr("1: Very Easy");
			pr("2: Easy");
			pr("3: Medium");
			pr("4: Hard");
			pr("5: Challenge Mode (X5 coins)");

			input = -1;
			input = input();
			if(input == 1){
				difficulty = 1;
				pr("Selected: " + strDifficulty[difficulty-1]);
				break;
			}else if (input == 2){
				difficulty = 2;
				pr("Selected: " + strDifficulty[difficulty-1]);
				break;
			}else if (input == 3){
				difficulty = 3;
				pr("Selected: " + strDifficulty[difficulty-1]);
				break;
			}else if (input == 4){
				difficulty = 4;
				pr("Selected: " + strDifficulty[difficulty-1]);
				break;
			}else if (input == 5){
				difficulty = 5;
				pr("Selected: " + strDifficulty[difficulty-1]);
				break;
			}
		}
		U.setDifficulty(userId, difficulty);
	}


	public void menu() throws NumberFormatException, Exception {
		while(true){
			while(true){

				pr("");
				pr("User: " + U.getUserName(userId) + "      Coins: " + U.getBalance(userId) + "      Skips: " + U.getSkip(userId));
				mode = U.getMode(userId);
				difficulty = U.getDifficulty(userId);
				pr("Mode: " + strMode[mode-1] + "      Difficulty: " + strDifficulty[difficulty-1]);
				pr("");
				pr("Press 1 to begin");
				pr("Press 2 to change mode");
				pr("Press 3 to change difficulty");
				pr("Press 4 to go to the store");
				pr("Press 5 for about/help");
				pr("Press 6 to quit");
				pr("");
				input = -1;
				input = input();

				if(input==1){
					break;

				}else if(input==2){
					askMode();
					break;
				}else if(input == 3){
					askDifficulty();
					break;
				}else if(input == 4){
					store();
					break;
				}else if(input==5){
					while(true){
						pr("ABOUT:");
						pr("");
						pr("This game was created by Lars Quaade with the idea of improving math skills and speed for people at any level of expertise");
						pr("");
						pr("HELP:");
						pr("");
						pr("Upon pressing '1' to start the game, you will be given a math question. You will need to type the answer and then hit 'enter'. for each correct answer you will recieve 5 coins and for each wrong answer, you will loose 1 coin. The coins can be spent in the store. Skips allow you to skip a question without recieving a reward. Good Luck :-)");
						pr("");
						pr("Press '0' to go back");
						pr("");

						input = -1;
						input = input();
						if(input==0){
							break;
						}
					}
				}else if(input==6){
					U.closeConnection();
					Thread.sleep(1000);
					System.exit(0);
				}else{
				}
			}
			if(input == 1){
				break;
			}
		}		
	}

	private void store() throws NumberFormatException, Exception {
		pr("Skips cost 50 coins");
		pr("Press 1 to buy skips");
		pr("Press 0 to go back");
		while(true){
			input = -1;
			input = input();		
			if(input == 1){
				pr("How many skips do you wish to buy?");
				input = -1;
				input = input();
				currentBalance = U.getBalance(userId);
				if(currentBalance>=50*input){
					U.setBalance(userId, (currentBalance-50*input));
					int currentSkips = U.getSkip(userId);
					U.setSkip(userId, (currentSkips+input));
					pr("You payed: " + 50*input + " coins, and recieved: " + input + " skips");
					pr(U.getUserName(userId) + "'s Coins: " + U.getBalance(userId));
				}else{
					pr("You do not have sufficient funds to buy that");
				}
			}else if(input == 0){
				break;
			}
		}

	}

	private int input() {
		try{
			input = sc.nextInt();
		}catch(Exception e){
			pr("Wrong input, try again");
			pr(sc.next() + " was not valid input.");
		}		
		return input;
	}

	private void pr(String message) {


		if(message.length()<60){
			System.out.println(message);
		}else{
			for(int i=0; i<message.length(); i=i+60){
				try{
					System.out.println(message.substring(i,i+60)+"-");
				}catch(StringIndexOutOfBoundsException SI){
					System.out.println(message.substring(i,message.length()));
				}
			}
		}
	}

	private void question() {
		//creates the number of numbers based on chosen difficulty
		if(difficulty == 1){
			//very easy
			nrAmount = 10;
		}else if(difficulty == 2){
			//easy
			nrAmount = 100;
		}else if(difficulty == 3){
			//medium
			nrAmount = 200;
		}else if(difficulty == 4){
			//hard
			nrAmount = 300;
		}else if(difficulty == 5){
			//challenge mode
			mode = (int)((Math.random()*4)+1);
			nrAmount = 500;
		}

		//creates the random numbers
		if(mode == 4){
			nrAmount/=10;
			if(difficulty == 1){
				nrAmount+=5;
			}
		}
		ans1 = (int)((Math.random()*nrAmount)+1);
		ans2 = (int)((Math.random()*nrAmount)+1);

		//creates questions based on the mode
		if(mode==1){
			ans = ans1 + ans2;
			sign = "+";
		}else if (mode == 2){
			ans = ans1 - ans2;
			sign = "-";
		}else if (mode == 3){
			ans = ans1 * ans2;
			sign = "*";
		}else if (mode == 4){

			ans = ans1;
			ans1 = ans1*ans2;
			sign = "/";
		}
		pr("--------------------------------------------------------");
		pr("*** Coins: " + coins + " *** "+ "Skips: " + skip +" (Type 00) *** Question: " + q + "/" + tq);
		pr("--------------------------------------------------------");
		pr(ans1 + " "+ sign + " " + ans2 + " = ?");

		while(true){
			input = -1;
			input = input();
			if(input == ans){
				if (difficulty != 5){
					pr("Correct! +5 coins");
					coins+=5;
				}else{
					pr("Correct! +25 coins");
					coins+=25;
				}
				break;				
			}else if(input == 00){
				if(skip>0){
					skip--;
					break;
				}else{
					pr("You do not have any skips! Buy more in the store!");
				}
			}else{
				pr("Wrong answer! -1 coin");
				coins-=1;
			}
		}
	}
}
