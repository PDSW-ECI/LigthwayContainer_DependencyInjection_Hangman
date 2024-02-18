package hangman.setup.guice;

import hangman.model.French;
import hangman.model.GameScore;
import hangman.model.Language;
import hangman.model.PowerScore;
import hangman.model.Spanish;
import hangman.model.dictionary.HangmanDictionary;
import hangman.model.dictionary.FrenchDictionaryDataSource;
import hangman.view.HangmanNoviolentoPanel;
import hangman.view.HangmanPanel;

public class HangmanFactoryServices extends com.google.inject.AbstractModule {
    @Override
    protected void configure() {
        /* Guice dependency injection */
        // bind(Interface.class).to(Concrete.class);
        bind(Language.class).to(Spanish.class);
        bind(HangmanDictionary.class).to(FrenchDictionaryDataSource.class);
        bind(HangmanPanel.class).to(HangmanNoviolentoPanel.class);
        //bind(GameScore.class).to(BonusScore.class);
        bind(GameScore.class).to(PowerScore.class);
    }

}
