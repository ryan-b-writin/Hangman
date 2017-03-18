
public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game("testing");
		Prompter prompter = new Prompter(game);
		boolean isHit = prompter.promptForGuess();
		if (isHit) {
			System.out.println("Hit!");
		} else {
			System.out.println("Miss!");
		}
	}
}
