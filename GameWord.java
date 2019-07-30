
/**
 * This class has methods that enables a user to play a word game
 * by checking if he/she guessed any of the characters in the phrase. 
 * 
 * Its purpose is to illustrate object references as both*  parameters 
 * and return values in methods.
 * 
 * @author Gebrekidane, Efrem
 * @version 07/25/2018
 */
public class GameWord
{
   private String phrase; 
   private StringBuilder inProgress;
   private int numberWrongGuesses;
   private StringBuilder state;
   private boolean gameOver;
   
   /**
      *  The default constructor sets all Strings to null.
      */
   public GameWord( )
   {
       inProgress = new StringBuilder( );
       phrase = new String( );
       numberWrongGuesses = 0;
       state = new StringBuilder( );
       gameOver = false;
    }
    
    /**
       *  This constructor allows new String to be guesed.
       *  It then let the user guess the new String.
       *  @param String phrase, boolean game Over for the GameWord object
       */
    public GameWord(String phraseToGuess)
    {
        phrase = new String(phraseToGuess);
        state = new StringBuilder( );
        inProgress = new StringBuilder( );
        for(int k = 0; k < phrase.length( ); k++) 
        {
            inProgress.append( "_ "); // progres of the user to guess the phrase right
        }
        numberWrongGuesses = 0; // the number of wrong gesses is zero
        gameOver = false;   // game not over yet
    }
   /**
       *  This method changes the phrase without changing the filed variable 
       *  phrase 
       *  @param  String phrase, boolean game Over for the GameWord object
       */     
    public void setPhrase(String phraseToGuess)
    {
        phrase = new String(phraseToGuess); // create a new String
        state = new StringBuilder( );
        inProgress = new StringBuilder( );
        for(int k = 0; k < phrase.length( ); k++) // checking the progress of the game 
        {
            inProgress.append( "_ ");
        }
        numberWrongGuesses = 0;
        state = new StringBuilder( );
        gameOver = false; // the game still continues  
    }
   /**
       *  This method @return a boolean 
       */  
    public boolean getGameOver( )
    {
        return gameOver;        // returns game over when the user make seven wrongs
    }
    
   /**
       *  This method locates the positin of the guessed character in the String 
       *  and also counting the number of wrong answers
       */ 
    public void find(char symbol)
    {
        int count = 0;
        int pos = 0;
        pos = phrase.indexOf(symbol); // index of the charcter
        while(pos != -1)
        { 
          count++;
          inProgress.setCharAt(pos*2,symbol);  // progress of the game including the once the user guessed 
                                               // right and the once left yet to be guessed right
          pos = phrase.indexOf(symbol, pos + 1); // position of a character 
        }
        if(count == 0)
        {
            numberWrongGuesses++; // counting the number of wrong guesses
            updateState( );     // updating the visuilation of the hangman by clling the function updateState( ); 
        }
        
        
        
    }
  
    /**
       *  This method checks if the user has won or not 
       *  @return a boolean match which is true or false of the user guess progress.
       */ 
  public boolean checkWin( )
   {
      boolean match = true; // returns true if it's there
       for(int k = 0, m = 0; k < phrase.length( ) && match; k++, m += 2)
      {
          if(phrase.charAt(k) != inProgress.charAt(m)) // cheking the user input if it is in the string
          {
              match = false; // returns false if it's not there 
         
          }
      }
      return match;
    }
   
  /**
       *  This method updeats the hangman visual every time the user does not guess right
       *  @param boolean game Over for the GameWord object
       */ 
   
   private void updateState( )
   { 
      
      // giving the user 7 wrong gueses if he/she guess wrong 7 times they loose    
       switch(numberWrongGuesses)
       {
           case 1: state.append("\n\t\t\t\t\t 0");  // 1st time the user guess wrong
                   break;
           case 2: state.append( "\n\t\t\t\t       /");  // 2nd time the user guess wrong
                   break;
           case 3: state.append(" |");                  // 3rd time the user guess wrong
                   break;
           case 4: state.append( " \\");                // 4th time the user guess wrong
                   break;
           case 5: state.append("\n\t\t\t\t         |");   // 5th time the user guess wrong
                   break;
           case 6: state.append("\n\t\t\t\t        /");     // 6th time the user guess wrong
                   break;
           case 7: state.append(" \\\n\n\t\t\t\t      OH NO!!\n");  // 7th time the user guess wrong
                   gameOver = true;
                   
        
      }
      
  }
  
  /**
     *  The toString method returns a textual representation of the current object.
     *  @return a String representing the state of the GameWord object.
   */
  
  public String toString(  )
  {
      return new String("\n***************************************\n" 
            + inProgress + "\n" + state.toString( ));
  }
}