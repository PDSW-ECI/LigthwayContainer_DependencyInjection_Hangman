package hangman.model; 
import java.lang.Math;
public class PowerScore implements GameScore {
    private int score ;
    private int failure= 8;
    private int bonus= 5;
    private int minScore= 0;
    private int maxScore =500;
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        score = 0;
        if( correctCount < 0 || incorrectCount <0 ) {
            throw new GameScoreException(GameScoreException.NEGATIVE_NUMBERS);
        }
 
        for( int i=1 ; i <=correctCount; i++){
            score+= (Math.pow(bonus,i));
        }
 
        score =( score - (failure*incorrectCount) < minScore )? minScore :  score - (failure*incorrectCount);
        score =( score > maxScore )? maxScore :  score ;
        return score;
    }
}
