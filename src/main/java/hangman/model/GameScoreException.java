package hangman.model;
public class GameScoreException extends Exception {
    public static final String NEGATIVE_NUMBERS = "Hay contadores negativos";
    public GameScoreException(String message ){
        super( message);
    }
}
