package hangman.model;
public class OriginalScore implements GameScore{
    private int score ;
    private int failure=10;
    private int minScore=0;
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        score = 100;
        if( correctCount < 0 || incorrectCount <0 ){
            throw new GameScoreException( GameScoreException.NEGATIVE_NUMBERS);
        }
        score =( score - (failure*incorrectCount) < minScore )? minScore :  score - (failure*incorrectCount);
        return score;
    }
}
