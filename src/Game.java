
public class Game {
	public static final int MAX_MISSES = 7;
	public String answer;
	private String hits;
	private String misses;
	
	public Game(String answer) {
		this.answer = answer.toLowerCase();
		this.hits ="";
		this.misses ="";
	}
	
	private char normalizeGuess(char letter){
		if (!Character.isLetter(letter)){
			throw new IllegalArgumentException("letters only!");
		}
		letter = Character.toLowerCase(letter);
		if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1)
		{
			throw new IllegalArgumentException(letter + " has already been guessed");
		}
		return letter;
	}
	
	public boolean applyGuess(String letters) {
		if(letters.length() == 0) {
			throw new IllegalArgumentException("No input found.");
		}
		return applyGuess(letters.charAt(0));
	}
	
	public boolean applyGuess(char guess){
		guess = normalizeGuess(guess);
		boolean isHit = answer.indexOf(guess) != -1;
		if (isHit){
			hits += guess;
		} else {
			misses += guess;
		}
		return isHit;
	}
	
	public int getRemainingTries() {
		return MAX_MISSES - misses.length();
	}
	
	public String getCurrentProgress(){
		String progress = "";
		for (char letter : answer.toCharArray()) {
			char display = '-';
			if (hits.indexOf(letter) != -1){
				display = letter;
			}
			progress += display;
		}
		return progress;
	}
	
	public boolean isWon() {
		return getCurrentProgress().indexOf('-') == -1;
	}
}
