package Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

	private int qs = 0, points = 0,ans1,ans2,ans,input,mode,difficulty,nrAmount;
	private String strMode;
	private long time1,time2,times;
	private Scanner sc = new Scanner(System.in);

	public void game() {

		startupScreen();
		askDifficulty();
		if(difficulty != 5){
			askMode();
		}
		//Game Loop
		while(true){

			//stops the game at X questions
			qs++;
			question();
			if(qs>=10){
				break;			}
		}
		pr("Overall Score: "+ points + "/" + qs*5);
		pr("Average time spent per question: " + times/qs + " Seconds");
		pr("");
		pr("Game will restart in 15 seconds!");
		qs = 0;
	}

	private void askMode() {
		pr("Select Mode:");
		pr("1: +");
		pr("2: -");
		pr("3: *");
		pr("4: /");
		input = sc.nextInt();
		if(input == 1){
			mode = 1;
			pr("Selected: '+'");
		}else if (input == 2){
			mode = 2;
			pr("Selected: '-'");
		}else if (input == 3){
			mode = 3;
			pr("Selected: '*'");
		}else if (input == 4){
			mode = 4;
			pr("Selected: '/'");
		}

	}
	private void askDifficulty() {
		pr("Select Difficulty:");
		pr("1: Very Easy");
		pr("2: Easy");
		pr("3: Medium");
		pr("4: Hard");
		pr("5: Challenge Mode (X5 points)");
		input = sc.nextInt();
		if(input == 1){
			difficulty = 1;
			pr("Selected: 'Very Easy'");
		}else if (input == 2){
			difficulty = 2;
			pr("Selected: 'Easy'");
		}else if (input == 3){
			difficulty = 3;
			pr("Selected: 'Medium'");
		}else if (input == 4){
			difficulty = 4;
			pr("Selected: 'Hard'");
		}else if (input == 5){
			difficulty = 5;
			pr("Selected: 'Challenge Mode'");
		}
	}


	private void startupScreen() {
		while(true){

			pr("Welcome to the math game");
			pr("Press 1 to begin");
			pr("Press 2 for about");
			pr("Press 3 for help");
			pr("");
			try{
				input = sc.nextInt();
			}catch(InputMismatchException IM){
				pr("Game can't handle anything but numbers, closing game..");
				System.exit(0);
			}
			if(input==1){
				break;
			}else if(input==2){
				pr("This game was created by Lars Quaade with the idea of improving math skills and speed for people at any level of expertise");
				pr("");
				pr("Press '4' to go back");
				pr("");
				input = sc.nextInt();
				if(input==4){
				}
			}else if(input==3){
				pr("Upon pressing '1' to start the game, you will be given a math question and the timer will begin. You will need to type the answer and then hit 'enter'. for each correct answer you will recieve 5 points and for each wrong answer, you will loose 1 point. Good Luck :-)");
				pr("");
				pr("Press '4' to go back");
				pr("");
				input = sc.nextInt();
				if(input==4){
				}
			}else{
				pr("Wrong Input, try again");
			}
		}		
	}

	private void pr(String message) {


		if(message.length()<50){
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
			nrAmount = 250;
		}else if(difficulty == 4){
			//hard
			nrAmount = 500;
		}else if(difficulty == 5){
			//challenge mode
			mode = (int)((Math.random()*4)+1);
			nrAmount = 1000;
		}

		//creates the random numbers
		ans1 = (int)((Math.random()*nrAmount)+1);
		ans2 = (int)((Math.random()*nrAmount)+1);

		//creates questions based on the mode
		if(mode==1){
			ans = ans1 + ans2;
			strMode = "+";
		}else if (mode == 2){
			ans = ans1 - ans2;
			strMode = "-";
		}else if (mode == 3){
			ans = ans1 * ans2;
			strMode = "*";
		}else if (mode == 4){
			ans1 = ans1*2;
			ans2 = ans2*2;
			ans = ans1 / ans2;
			strMode = "/ (floor of)";
		}

		pr("*** Score: " + points + " *** "+ "Time: " + (time2-time1)/1000 + " Seconds ***");
		pr("---------------------------------");
		pr(ans1 + " "+ strMode + " " + ans2 + " = ?");
		pr("");

		time1 = System.currentTimeMillis();
		while(true){
			input = sc.nextInt();
			if(input == ans){
				if (difficulty != 5){
					pr("Correct! +5 points");
					points+=5;
				}else if (difficulty == 5){
					pr("Correct! +25 points");
					points+=25;
				}
				break;				
			}else{
				pr("Wrong answer! -1 point");
				points-=1;
			}
		}
		time2 = System.currentTimeMillis();
		times+=(time2-time1)/1000;
	}
}
