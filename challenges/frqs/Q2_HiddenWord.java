package frqs;

public class Q2_HiddenWord {
    private String answer;

    public Q2_HiddenWord(String ans) {
        answer = ans;
    }

    public String getHint(String guess) {
        String hint = "";
        for (int i=0; i < guess.length(); i++) {
            if (guess.substring(i, i+1).equals(answer.substring(i, i+1))) {
                hint += guess.substring(i, i+1);
            } else if (answer.contains(guess.substring(i, i+1))) {
                hint += "+";
            } else {
                hint += "*";
            }
        }
        return hint;
    }

    public static void main(String[] args) {
        Q2_HiddenWord puzzle = new Q2_HiddenWord("HARPS");

        System.out.println("Guess: AAAAA --> Hint: " + puzzle.getHint("AAAAA"));
        System.out.println("Guess: HELLO --> Hint: " + puzzle.getHint("HELLO"));
        System.out.println("Guess: HEART --> Hint: " + puzzle.getHint("HEART"));
        System.out.println("Guess: HARPS --> Hint: " + puzzle.getHint("HARPS"));
    }
}
