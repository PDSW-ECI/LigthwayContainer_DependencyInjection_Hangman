package hangman.model
public class BonusScore implements GameScore {
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws IllegalArgumentException {
        if (correctCount < 0 || incorrectCount < 0) {
            throw new IllegalArgumentException("Los contadores de letras correctas e incorrectas no pueden ser negativos");
        }
        int score = correctCount * 10 - (incorrectCount * 5);
        return Math.max(score, 0);
    }
}
