package hangman.model;
public class BonusScore implements GameScore {
    private int score = 0;
    private int failure= 5;
    private int bonus=10;
    private int minScore= 0;
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        score = 0;
        if( correctCount < 0 || incorrectCount <0 ) {
            throw new GameScoreException(GameScoreException.NEGATIVE_NUMBERS);
        }
        score =( score+(correctCount*bonus) - (failure*incorrectCount) < minScore )? minScore :  score+(correctCount*bonus) - (failure*incorrectCount);
        return score; 
    }
}
