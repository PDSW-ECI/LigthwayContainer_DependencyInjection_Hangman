/***************************************************************
* file: GameModel.java
* author:   Christopher Santos
*           Omar Rodriguez
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.0
* date last modified: 10/11/2016
*
* purpose: Este es el componente modelo para la pantalla del juego.
*
****************************************************************/ 
package hangman.model;

import hangman.model.dictionary.HangmanDictionary;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class GameModel {
    private int incorrectCount;
    private int correctCount;
    private LocalDateTime dateTime;
    private int gameScore;
    private int[] lettersUsed;
    
    
    private HangmanDictionary dictionary;
    private GameScore puntuation;
    
    private Scanner scan;
    private String randomWord;
    private char[] randomWordCharArray;
    
    //Crea una nueva instancia de GameModel
    //@param dictionary: el diccionario utilizado para seleccionar palabras
    //@param puntuation: el puntaje del juego utilizado para calcular el puntaje
    public GameModel(HangmanDictionary dictionary,GameScore puntuation){
        //this.dictionary = new EnglishDictionaryDataSource();
        this.dictionary=dictionary;
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 100;
        this.puntuation = puntuation; 
    }
    
    //Reinicia este modelo de juego para un nuevo juego
    public void reset(){
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 100;
    }

    //Establece la fecha/hora del juego a la fecha/hora del sistema
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }
    
    //Verifica si la conjetura del usuario está en la cadena. Devuelve una lista de posiciones si se encuentra el carácter en la cadena.
    //@param guess: la suposición del usuario
    //@return: una lista de posiciones si se encuentra el carácter en la cadena
    public ArrayList<Integer> makeGuess(String guess){
        char guessChar = guess.charAt(0);
        ArrayList<Integer> positions = new ArrayList<>();
        for(int i = 0; i < randomWordCharArray.length; i++){
            if(randomWordCharArray[i] == guessChar){
                positions.add(i);
            }
        }
        if(positions.size() == 0){
            incorrectCount++;
            gameScore -= 10;
        } else {
            correctCount += positions.size();
        }
        return positions;
        
    }
    
    //Devuelve la fecha/hora actual mostrada
    //@return: la fecha/hora actual formateada como una cadena
    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-uuuu hh:mm:ss a");
        return dtf.format(dateTime);
    }


    //Establece el valor de la puntuación a puntos
    //@param score: el puntaje del juego
    public void setScore(int score) {
        this.gameScore = score;
    }
    
    //Devuelve el valor actual de la puntuación
    //@return: el puntaje del juego
    //@throws HangmanException: si ocurre un error al calcular el puntaje
    public int getScore() {
        int score = 0;
         try{
             score = puntuation.calculateScore(correctCount, incorrectCount);
             System.out.println(score);
            }catch(HangmanException e){
             
            }
            return score;
    }

    //Selecciona una palabra aleatoria del diccionario
    //@return: una palabra aleatoria del diccionario
    private String selectRandomWord() {
        Random rand = new Random();
        List<String> words = dictionary.getAvailableWords();
        return words.get(rand.nextInt(words.size()));
    }

    //Devuelve el número de conjeturas incorrectas realizadas hasta el momento
    //@return: el número de conjeturas incorrectas realizadas hasta el momento
    public int getIncorrectCount() {
        return incorrectCount;
    }

    //Devuelve el número de conjeturas correctas realizadas hasta el momento
    //@return: el número de conjeturas correctas realizadas hasta el momento
    public int getCorrectCount() {
        return correctCount;
    }

    
    //Devuelve la puntuación actual
    //@return: la puntuación actual
    public int getGameScore() {
        return gameScore;
    }


    //Establece la puntuación actual del juego
    //@param gameScore: la puntuación del juego
    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }
    
    //Devuelve la longitud de la palabra actual
    //@return: la longitud de la palabra actual
    public int getWordLength(){
        return randomWord.length();
    }

    //Devuelve el conjunto de caracteres disponibles en el diccionario
    //@return: el conjunto de caracteres disponibles en el diccionario
    public List<Character> getCharacterSet() {
        return new ArrayList<>(dictionary.getCharacterSet());
    }
}
