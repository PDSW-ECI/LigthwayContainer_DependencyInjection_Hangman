public class OriginalScore implements GameScore {
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws IllegalArgumentException {
        if (correctCount < 0 || incorrectCount < 0) {
            throw new IllegalArgumentException("Los contadores de letras correctas e incorrectas no pueden ser negativos");
        }
        int score = 100 - (incorrectCount * 10);
        return Math.max(score, 0);
    }
}