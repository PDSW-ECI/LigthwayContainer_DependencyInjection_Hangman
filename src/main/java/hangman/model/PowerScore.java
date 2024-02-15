public class PowerBonusScore implements GameScore {
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws IllegalArgumentException {
        if (correctCount < 0 || incorrectCount < 0) {
            throw new IllegalArgumentException("Los contadores de letras correctas e incorrectas no pueden ser negativos");
        }
        int score = correctCount * 5 - (incorrectCount * 8);
        score = Math.max(score, 0);
        return Math.min(score, 500); // Máximo puntaje permitido es 500
    }
}