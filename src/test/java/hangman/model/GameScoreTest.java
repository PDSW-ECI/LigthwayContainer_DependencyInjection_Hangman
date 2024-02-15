ackage hangman.model;
 
import org.junit.Test;
import hangman.model.*;
import org.junit.Assert;
 
/**
* @author Manuel Suarez - Yeltzyn Sierra
* @version 1.0 15/02/2024
*
* *******************************************************************************
* OriginalScore
* failure = 10;
* Number Equivalence class Result
* 1) correctCount < 0 Incorrect/ Throws NEGATIVE_NUMBERS Exception
* 2) incorrectCount < 0 Incorrect/ Throws NEGATIVE_NUMBERS Exception
* 3) correctCount>= 0 ^ incorrectCount=0 Correct/ 100
* 4) correctCount>= 0 ^ 0<incorrectCount<=10 Correct/ score - (incorrectCount*failure)
* 5) correctCount>= 0 ^ incorrectCount>10 Correct/ 0
* *******************************************************************************
* BonusScore
* failure = 5;
* bonus = 10;
* Number Equivalence class Result
* 1) correctCount < 0 Incorrect/ Throws NEGATIVE_NUMBERS Exception
* 2) incorrectCount < 0 Incorrect/ Throws NEGATIVE_NUMBERS Exception
* 3) incorrectCount >=0 ^ correctCount>=0 Correct/ 0
* ^ 2*incorrectCount>= correctCount
* 4) incorrectCount >=0 ^ correctCount>=0 Correct/ score +(correctCount*bonus - incorrectCount*failure )
* ^ incorrectCount< correctCount
*
* *******************************************************************************
* PowerBonusScore
* failure = 8;
* bonus = 5^correctCount;
* Number Equivalence class Result
* 1) correctCount < 0 Incorrect/ Throws NEGATIVE_NUMBERS Exception
* 2) incorrectCount < 0 Incorrect/ Throws NEGATIVE_NUMBERS Exception
* 3) incorrectCount = 0 ^ correctCount>=4 Correct/ 500
* 4) incorrectCount >= 0 ^ correctCount=0 Correct/ 0
* 5) incorrectCount > 0 ^ correctCoun>0 Correct/ score +(sum(5^correctCount) - incorrectCount*failure )
*/
public class GameScoreTest {
 
    private GameScore original = new OriginalScore();
    private GameScore bonus = new BonusScore();
    private GameScore power = new PowerScore();
 
    //*********************************************OriginalScore***********************************************
 
    @Test
    public void shouldTrowAnExceptionFromOriginal() {
        try {
            original.calculateScore(-1, -1);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
 
    // Limit test with incorrectCount = 0
    @Test
    public void shouldBe100OnOriginal() throws GameScoreException {
        int score = original.calculateScore(100, 0);
        Assert.assertEquals(score, 100);
    }
 
    // Limit test with correctCount = 10
    @Test
    public void shouldBe50OnOriginal() throws GameScoreException {
        int score = original.calculateScore(0, 5);
        Assert.assertEquals(score, 50);
    }
 
    // Limit test with incorrectCount = 10
    @Test
    public void shouldBe0OnOriginal() throws GameScoreException {
        int score = original.calculateScore(0, 10);
        Assert.assertEquals(score, 0);
    }
 
    // Limit test with incorrectCount = 10
    @Test
    public void shouldBeMinimumOriginal1() throws GameScoreException {
        int score = original.calculateScore(26, 11);
        Assert.assertEquals(score, 0);
    }
 
    @Test
    public void shouldBeMinimumOriginal2() throws GameScoreException {
        int score = original.calculateScore(34, 40);
        Assert.assertEquals(score, 0);
    }
 
    //*********************************************BonusScore***********************************************
 
    @Test
    public void shouldTrowAnExceptionFromBonus() {
        try {
            bonus.calculateScore(-1, -1);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
 
    @Test
    public void shouldBeMinimumBonus1() throws GameScoreException {
        int score = bonus.calculateScore(10, 20);
        Assert.assertEquals(score, 0);
    }
 
    // Limit test with incorrectCount = 0 ^ correctCount = 0
    @Test
    public void shouldBeMinimumBonus2() throws GameScoreException {
        int score = bonus.calculateScore(0, 0);
        Assert.assertEquals(score, 0);
    }
 
    @Test
    public void shouldBe100OnBonus() throws GameScoreException {
        int score = bonus.calculateScore(20, 20);
        Assert.assertEquals(score, 100);
    }
 
    //*****************************************PowerScore***************************************************
 
    @Test
    public void shouldTrowAnExceptionFromPower() {
        try {
            power.calculateScore(-1, -1);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
 
    // Limit test with incorrectCount = 0 ^ correctCount = 4
    @Test
    public void shouldBeMaxScorePower() throws GameScoreException {
        int score = power.calculateScore(4, 0);
        Assert.assertTrue(score == 500);
    }
 
    @Test
    public void shouldBeMinimumScorePower() throws GameScoreException {
        int score = power.calculateScore(0, 15);
        Assert.assertEquals(score, 0);
    }
 
    @Test
    public void shouldBeNormalScorePower() throws GameScoreException {
        int score = power.calculateScore(4, 63);
        Assert.assertEquals(score, 276);
    }
}