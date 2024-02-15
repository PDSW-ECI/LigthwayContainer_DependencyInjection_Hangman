public interface GameScore {
    /**
     * Calcula el puntaje del juego según las reglas específicas de cada implementación.
     *
     * @param correctCount   El número de letras correctas.
     * @param incorrectCount El número de letras incorrectas.
     * @return El puntaje calculado según las reglas del juego.
     * @pre correctCount >= 0 && incorrectCount >= 0
     */
    int calculateScore(int correctCount, int incorrectCount) throws IllegalArgumentException;
}