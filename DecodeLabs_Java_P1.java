import java.util.*;
public class DecodeLabs_Java_P1{
  public static void main(String[] args){
    
    Scanner sc=new Scanner(System.in);
    Random random=new Random();
    boolean playAgain=true;
    int totalScore=0;
    System.out.println("Welcome to Number Guessing Game!");
    while(playAgain){
      int target =random.nextInt(100)+1;
      int attempts=0;
      int maxAttempts=7;

      System.out.println("\n Guess a number between 1 and 100");

      System.out.println("you have" + maxAttempts +"attempts.");

      boolean win=false;
      while(attempts<maxAttempts){
        System.out.print("Enter your guess");

        try{
          int guess=sc.nextInt();
          attempts++;

          if(guess==target){
            System.out.println("Correct! You guessed in" + attempts + " attempts.");
            totalScore += (maxAttempts - attempts +1)*10;
            win=true;
            break;
          }else if(guess>target){
            System.out.println("Too High!");
          }else{
            System.out.println("Too Low");
          }
        }
        catch(Exception e){
          System.out.println("Invalid input! Enter a number.");
          sc.nextLine();
        }
      }
      if(!win){
        System.out.println("You lost! The number was: " + target);
      }
      System.out.println("Current Score: " + totalScore);

      System.out.println("Current Score: " +  totalScore);
      System.out.print("Play Again? (Y/N): ");
      sc.nextLine();
      String choice=sc.nextLine();
      if(!choice.equalsIgnoreCase("Y")){
        playAgain = false;
      }

    }
    System.out.println("\n Thanks for playing!");
    sc.close();

  }
}