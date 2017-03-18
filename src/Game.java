
public class Game {
	private String answer;
	private String hits;
	private String misses;
	
	public Game(String answer) {
		this.answer = answer;
		this.hits ="";
		this.misses ="";
	}
	
	public boolean applyGuess(char guess){
		boolean isHit = answer.indexOf(guess) != -1;
		if (isHit){
			hits += guess;
		} else {
			misses += guess;
		}
		return isHit;
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
