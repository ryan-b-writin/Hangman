import java.util.Scanner;

public class Prompter {
	private Game game;
	
	public Prompter(Game game){
		this.game = game;
		
	}
	
	public boolean promptForGuess() {
		Scanner scanner = new Scanner(System.in);
		boolean isHit = false;
		boolean isAcceptable = false;
		do {
			System.out.print("Enter a letter: ");
			String guessInput = scanner.nextLine();
			try {
				isHit = game.applyGuess(guessInput);
				isAcceptable = true;
			} catch (IllegalArgumentException iae) {
				System.out.printf("%s Try again. ", iae.getMessage());
			}
		} while (! isAcceptable);
		return isHit;
	}
	
	public void displayProgress() {
		System.out.printf("You have %d tries left. Solve: %s%n", game.getRemainingTries(), game.getCurrentProgress());
	}
	
	public void displayOutcome() {
		if (game.isWon()){
			System.out.printf("hooray!, the answer was: %s", game.answer);
		} else {
			System.out.printf("Sorry. The answer was: %s", game.answer );
		}
	}
}
