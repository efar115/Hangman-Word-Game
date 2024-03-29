import java.util.*; // used in reading the users input 
import java.io.BufferedReader; // Reads text from a character-input stream, buffering characters so as to
                               // provide for the efficient reading of characters, arrays, and lines.
import java.io.File; // used on reading a file 
import java.io.FileReader; // reading a file 
import java.io.IOException; 
import java.util.Random; // used in generating a random 
/**
 * The class GamePlay enables user to play a guess game
 * first it gives the user a menu of four top soccer clubs to choose from for the game 
 * then opens a file that corresponds with the uesr's choice,
 * then it generates a random player name from the 20 names in the file
 * then the user will try to guess the name
 * at last regardless he/she wins the program will ask the if they would to play agian 
 * until they decide to quit.
 * 
 * @author Gebrekidane, Efrem
 * @version 07/25/2018
 */
public class GamePlay
{   // begining of class
   // main method 
   public static void main(String[ ] args) throws IOException
   {
    String[] result = new String[20]; // Storing all 20 Strings from a file making it easy to genreate a random String
    Random rand = new Random(); // Random class to help generate a random String from the four files
   
    Scanner in = new Scanner(System.in);    // Scanner class that enable us to read users input from the keybaord 
    String realMadrid = "";          // declaring a variable to hold the String randomly generated from file Real Madrid
    String manchesterUnited = ""; // declaring a variable to hold the String randomly generated from file Manchester United
    String barcelona  = "";       // declaring a variable to hold the String randomly generated from file Barcelona
    String bayernMunich = "";   // declaring a variable to hold the String randomly generated from file Bayern Munich
    int choice; // decaring an integer to hold the users menu choice
    char guess; // declaring Character guess to hold the gussed character
    char goAgain = 'y'; // declaring varlable go again to hold the user input on whether to play agian or not 
   
   
    // this while loop enables the user to keep playing as long as they want
    // as long as they enter 'y' Or 'Y' when asked if they want to keep playing
    while(goAgain == 'y' || goAgain == 'Y')
      {
       // displaying the menu for the game
       System.out.println("Below is a list of four top soccer teams in Europe ");
       System.out.println("You are going to guess a name of random player from the team you choose");
       System.out.println("1. Manchester United ");
       System.out.println("2. Barcelona ");
       System.out.println("3. Bayern Munich ");
       System.out.println("4. Real Madrid ");
       System.out.println("Now choose a team: ");
       choice = in.nextInt();       // reading the users choice from the keybaord
       
       // if the user enter a number less than 1 or greate than 4 error messeage is displyed 
       // and gives the user another chance to enter a number between 1 and 4
       while (choice <1 || choice > 4)
       {
           System.out.println("*** INVALID INPUT ***" );
           System.out.println("Please enter a number between 1 and 4");
           System.out.println("Below is a list of four top soccer teams in Europe ");
           System.out.println("You are going to guess a name of random player from the team you choose");
           System.out.println("1. Manchester United ");
           System.out.println("2. Barcelona ");
           System.out.println("3. Bayern Munich ");
           System.out.println("4. Real Madrid ");
           System.out.println("Now choose a team: ");
           choice = in.nextInt(); // reading the users choice from the keybaord
           
        }
        
        // a swich statments depending the users choice we can also use if else statemest instead 
        switch ( choice)
        {
            case 1: 
                    boolean [ ] used3 = new boolean[255];   // to store the guessed characters
                    try {
                        File file4 = new File("Manchester United.txt");   // reading the fill Manchester United
                        FileReader fileReader4 = new FileReader("Manchester United.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader4);
                        StringBuffer stringBuffer = new StringBuffer();
                        String line;   // declarina a variable to hold line 
                        int i = 0;     // declaring integer i which is used in generateing a random String from a fill
                        
                        while ((line = bufferedReader.readLine()) != null) { // looping to read every String in the file
                            
                             result[i] = line;
                             i++;
                        }
                        int randomIndex = rand.nextInt(result.length);  // generating a random index for random String
                        manchesterUnited = result[randomIndex];       // random string is denerated here and stored in the
                                                                // variable manchesterUnited
                        fileReader4.close();   // close file reading 
                       
                    } catch (IOException e) {
                        e.printStackTrace();
                        }
                    GameWord myPhrase1 = new GameWord(manchesterUnited);    // creating GameWord object
                    
                    System.out.println("\n" + myPhrase1.toString( )); // displaying the word to be guessed in a (___) form 
                                                                      // showing how many characteres are in the string
                   // a loop that exits when the user wins or looses
                    while(!myPhrase1.checkWin( ) && ! myPhrase1.getGameOver( ))
                    {
                      do{
                        System.out.print("\nEnter your character: "); // asking the user to enter a character (his/her guess)
                        // reading input of the user
                        guess = in.next( ).charAt(0);
                        if(used3[guess]) System.out.println("That letter already guessed."); // if the user enter a character he/she
                                                                                             // displays this message and it is not 
                                                                                             // count as a wrong try
                     }while (used3[guess]);
                      used3[guess] = true; // checking if the character entered is in the string 
                      myPhrase1.find(guess); // finding the charcter in the string
                      System.out.println("\n" + myPhrase1.toString( )); // the program displays the character guessed 
                                                                        // and show how many are left
                    }
                   // when the user guesses the whole phrase right the program displays this message 
                    if(myPhrase1.checkWin( ))
                    {
                      System.out.println("You got it!");
                    }
                  // telling the user that the game is over    
                    System.out.println("Game Over");  
                    System.out.println("Game Over"); 
            break; 
            
            case 2:
                    boolean [ ] used2 = new boolean[255];   // to store the guessed characters
                    try {
                        File file4 = new File("Barcelona.txt");   // reading the fill barcelona
                        FileReader fileReader4 = new FileReader("Barcelona.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader4);
                        StringBuffer stringBuffer = new StringBuffer();
                        String line;   // declarina a variable to hold line 
                        int i = 0;     // declaring integer i which is used in generateing a random String from a fill
                        
                        while ((line = bufferedReader.readLine()) != null) { // looping to read every String in the file
                            
                             result[i] = line;
                             i++;
                        }
                        int randomIndex = rand.nextInt(result.length);  // generating a random index for random String
                        barcelona = result[randomIndex];       // random string is denerated here and stored in the
                                                                // variable barcelona
                        fileReader4.close();   // close file reading 
                       
                    } catch (IOException e) {
                        e.printStackTrace();
                        }
                    GameWord myPhrase2 = new GameWord(barcelona);    // creating GameWord object
                    
                    System.out.println("\n" + myPhrase2.toString( )); // displaying the word to be guessed in a (___) form 
                                                                      // showing how many characteres are in the string
                   // a loop that exits when the user wins or looses
                    while(!myPhrase2.checkWin( ) && ! myPhrase2.getGameOver( ))
                    {
                      do{
                        System.out.print("\nEnter your character: "); // asking the user to enter a character (his/her guess)
                        // reading input of the user
                        guess = in.next( ).charAt(0);
                        if(used2[guess]) System.out.println("That letter already guessed."); // if the user enter a character he/she
                                                                                             // displays this message and it is not 
                                                                                             // count as a wrong try
                     }while (used2[guess]);
                      used2[guess] = true; // checking if the character entered is in the string 
                      myPhrase2.find(guess); // finding the charcter in the string
                      System.out.println("\n" + myPhrase2.toString( )); // the program displays the character guessed 
                                                                        // and show how many are left
                    }
                   // when the user guesses the whole phrase right the program displays this message 
                    if(myPhrase2.checkWin( ))
                    {
                      System.out.println("You got it!");
                    }
                  // telling the user that the game is over    
                    System.out.println("Game Over");  
                    System.out.println("Game Over");
            break; 
            case 3:
                    boolean [ ] used5 = new boolean[255];   // to store the guessed characters
                    try {
                        File file4 = new File("Bayern Munich.txt");   // reading the fill Bayern Munich
                        FileReader fileReader4 = new FileReader("Bayern Munich.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader4);
                        StringBuffer stringBuffer = new StringBuffer();
                        String line;   // declarina a variable to hold line 
                        int i = 0;     // declaring integer i which is used in generateing a random String from a fill
                        
                        while ((line = bufferedReader.readLine()) != null) { // looping to read every String in the file
                            
                             result[i] = line;
                             i++;
                        }
                        int randomIndex = rand.nextInt(result.length);  // generating a random index for random String
                        bayernMunich = result[randomIndex];       // random string is denerated here and stored in the
                                                                // variable bayernMunich
                        fileReader4.close();   // close file reading 
                       
                    } catch (IOException e) {
                        e.printStackTrace();
                        }
                    GameWord myPhrase5 = new GameWord(bayernMunich);    // creating GameWord object
                    
                    System.out.println("\n" + myPhrase5.toString( )); // displaying the word to be guessed in a (___) form 
                                                                      // showing how many characteres are in the string
                   // a loop that exits when the user wins or looses
                    while(!myPhrase5.checkWin( ) && ! myPhrase5.getGameOver( ))
                    {
                      do{
                        System.out.print("\nEnter your character: "); // asking the user to enter a character (his/her guess)
                        // reading input of the user
                        guess = in.next( ).charAt(0);
                        if(used5[guess]) System.out.println("That letter already guessed."); // if the user enter a character he/she
                                                                                             // displays this message and it is not 
                                                                                             // count as a wrong try
                     }while (used5[guess]);
                      used5[guess] = true; // checking if the character entered is in the string 
                      myPhrase5.find(guess); // finding the charcter in the string
                      System.out.println("\n" + myPhrase5.toString( )); // the program displays the character guessed 
                                                                        // and show how many are left
                    }
                   // when the user guesses the whole phrase right the program displays this message 
                    if(myPhrase5.checkWin( ))
                    {
                      System.out.println("You got it!");
                    }
                  // telling the user that the game is over    
                    System.out.println("Game Over");  
                    System.out.println("Game Over"); 
            break; 
            case 4:
                    boolean [ ] used4 = new boolean[255];   // to store the guessed characters
                    try {
                        File file4 = new File("Real Madrid.txt");   // reading the fill Real Madrid
                        FileReader fileReader4 = new FileReader("Real Madrid.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader4);
                        StringBuffer stringBuffer = new StringBuffer();
                        String line;   // declarina a variable to hold line 
                        int i = 0;     // declaring integer i which is used in generateing a random String from a fill
                        
                        while ((line = bufferedReader.readLine()) != null) { // looping to read every String in the file
                            
                             result[i] = line;
                             i++;
                        }
                        int randomIndex = rand.nextInt(result.length);  // generating a random index for random String
                        realMadrid = result[randomIndex];       // random string is denerated here and stored in the
                                                                // variable realMadrid
                        fileReader4.close();   // close file reading 
                       
                    } catch (IOException e) {
                        e.printStackTrace();
                        }
                    GameWord myPhrase4 = new GameWord(realMadrid);    // creating GameWord object
                    
                    System.out.println("\n" + myPhrase4.toString( )); // displaying the word to be guessed in a (___) form 
                                                                      // showing how many characteres are in the string
                   // a loop that exits when the user wins or looses
                    while(!myPhrase4.checkWin( ) && ! myPhrase4.getGameOver( ))
                    {
                      do{
                        System.out.print("\nEnter your character: "); // asking the user to enter a character (his/her guess)
                        // reading input of the user
                        guess = in.next( ).charAt(0);
                        if(used4[guess]) System.out.println("That letter already guessed."); // if the user enter a character he/she
                                                                                             // displays this message and it is not 
                                                                                             // count as a wrong try
                     }while (used4[guess]);
                      used4[guess] = true; // checking if the character entered is in the string 
                      myPhrase4.find(guess); // finding the charcter in the string
                      System.out.println("\n" + myPhrase4.toString( )); // the program displays the character guessed 
                                                                        // and show how many are left
                    }
                   // when the user guesses the whole phrase right the program displays this message 
                    if(myPhrase4.checkWin( ))
                    {
                      System.out.println("You got it!");
                    }
                  // telling the user that the game is over    
                    System.out.println("Game Over");  
                    System.out.println("Game Over"); 
                    
            break; 
        }
     // ask the user if he or she wants to keep playing 
    System.out.println("Entey y to play again or any other key to exit: "); 
    goAgain = in.next( ).charAt(0); // getting the user input
     }
        
    } // end of main method 
    
    
} // end of class GamePlay
