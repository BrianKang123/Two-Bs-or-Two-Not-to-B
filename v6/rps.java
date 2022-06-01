import java.util.ArrayList;
import java.util.Scanner;

public class eobard{
  private final String[] key = {"Rock", "Paper", "Scissors"};
  private ArrayList<Integer> moves;
  private int gScore;
  private int pScore;
  private int tie;
  private int turns;
  private boolean gameEnded;
  private int rocksPlayed;
  private int papersPlayed;
  private int scissorsPlayed;

  Scanner input = new Scanner(System.in);

  public rps(){
    gScore = 0;
    pScore = 0;
    moves = new ArrayList<Integer>();
    turns = 0;
    gameEnded = false;
  }

  //get a RANDOM move
  public int play(){
    return (int)(Math.random() * 3);
  }

  //play turns with scanner
  public boolean game(){
    while(!gameEnded){
      System.out.println("Rock, Paper, or Scissors?\n");
      String pMove = input.nextLine();
      if(pMove.equals("quit")){
        System.out.println("Game terminated");
        return false;
      }

      if(pMove.equals("Rock") || pMove.equals("rock") || pMove.equals("0")){
        turn(0);
      }
      else if(pMove.equals("Paper") || pMove.equals("paper") || pMove.equals("1")){
        turn(1);
      }
      else if(pMove.equals("Scissors") || pMove.equals("scissors") || pMove.equals("Scissor") || pMove.equals("scissor") || pMove.equals("2")){
        turn(2);
      }
      else{
        turn(Integer.parseInt(pMove) );
      }
      //FAIL CASE

    }
    return true;
  }

  //play a turn
  public boolean turn(int pMove){

    //validate move
    if(pMove > 2 || pMove < 0){
      System.out.println("Enter a valid move!\n\n");
      return false;
    }

    //rng number
    int gMove = play();
    System.out.println("Player plays " + key[pMove]);
    System.out.println("Gilgamesh plays " + key[gMove]);

    moves.add(pMove);
    turns += 1;

    //If player wins
    if(pMove - gMove == 1 || pMove - gMove == -2){
      System.out.println("Player wins\n\n");
      pScore += 1;
      return true;
    }

    //If Gilgamesh wins
    else if(gMove - pMove == 1 || gMove - pMove == -2){
      System.out.println("Gilgamesh wins\n\n");
      gScore += 1;
      return false;
    }

    //If tie
    else{
      System.out.println("Tie\n\n");
      tie += 1;
      return false;
    }
  }

  public String getMove(int move){
    return key[move];
  }


  //Accessors

  public ArrayList getMoveHistory(){
    return moves;
  }

  public int getGScore(){
    return gScore;
  }

  public int getPScore(){
    return pScore;
  }

  public int getTie(){
    return tie;
  }

  public int getTurn(){
    return turns;
  }

  public static void main(String[] args) {
    rps game = new rps();
    int turn = 0;
    while(true){
      if(args.length > turn){
        System.out.println("0: Rock\n1: Paper\n2: Scissors");
        System.out.println("Player plays " + args[turn]);
        game.turn(Integer.parseInt(args[turn]));
        turn += 1;
      }
    }
  }
}
