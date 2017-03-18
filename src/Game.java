
public class Game {
	public static final int MAX_MISSES = 7;
	private String answer;
	private String hits;
	private String misses;
	
	public Game(String answer) {
		this.answer = answer;
		this.hits ="";
		this.misses ="";
	}
	
	public boolean applyGuess(char guess){
		if (misses.indexOf(guess) != -1 || hits.indexOf(guess) != -1)
		{
			throw new IllegalArgumentException(guess + " has already been guessed");
		}
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
}
