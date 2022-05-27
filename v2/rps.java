/*
Two-Bs-or-Two-Not-to-B (Brian Wang, Brian Kang, Ethan Lam)
Final Project Iteration 2

Notes:
Start skeleton of AI structure.

Moves:
0. Rock
1. Paper
2. Scissors

Defeat Gilgamesh
*/

import java.util.ArrayList;
import java.util.Scanner;

public class rps{
  private final String[] key = {"Rock", "Paper", "Scissors"};
  private ArrayList<Integer> moves;
  private int gScore;
  private int pScore;
  private int tie;
  private int turns;
  private boolean gameEnded;

  Scanner input = new Scanner(System.in);

  public rps(){
    gScore = 0;
    pScore = 0;
    moves = new ArrayList<Integer>();
    turns = 0;
    gameEnded = false;
  }

  //get a "smart" move
  public int play(){
    //List of weights
    //Overall weight factors for final decision
    //THESE WILL LIKELY BE MANUALLY CHANGED!!!!
    double twoWeight = 1/4;
    double threeWeight = 1/4;
    double fourWeight = 1/4;
    double fiveWeight = 1/4;

    //THESE WILL BE ADJUSTED BY THE MACHINE!!!!
    //Most probable move from two move history
    double twoRWeight = 1/3;
    double twoPWeight = 1/3;
    double twoSWeight = 1/3;

    //Most probable move from three move history
    double threeRWeight = 1/3;
    double threePWeight = 1/3;
    double threeSWeight = 1/3;

    //Most probable move from four move history
    double fourRWeight = 1/3;
    double fourPWeight = 1/3;
    double fourSWeight = 1/3;

    //Most probable move from five move history
    double fiveRWeight = 1/3;
    double fivePWeight = 1/3;
    double fiveSWeight = 1/3;

    //Weights will dynamically change depending on move history
    //Do we need to bother with move patterns past 5?

    //stringify move history, easier to search
    String moveHist = "";
    for(int ele : moves){
      moveHist += ele.toString();
    }

    //2 move batch history
    if(moves.size() > 2){
      int rCount = 0;
      int pCount = 0;
      int sCount = 0;
      int count = 0;

      //past moves
      String pastMoves = moveHist.subString(moveHist.length() - 1)
    }

    //3 move batch history
    if(moves.size() > 3){
      int rCount = 0;
      int pCount = 0;
      int sCount = 0;
      int count = 0;

      //past moves
      String pastMoves = moveHist.subString(moveHist.length() - 2)
    }

    //4 move batch history
    if(moves.size() > 4){
      int rCount = 0;
      int pCount = 0;
      int sCount = 0;
      int count = 0;

      //past moves
      String pastMoves = moveHist.subString(moveHist.length() - 3)
    }

    //5 move batch history
    if(moves.size() > 5){
      int rCount = 0;
      int pCount = 0;
      int sCount = 0;
      int count = 0;

      //past moves
      String pastMoves = moveHist.subString(moveHist.length() - 4)
    }

    //Actual chance for each of the three moves
    double rChance = twoWeight * twoRWeight
                   + threeWeight * threeRWeight
                   + fourWeight * fourRWeight
                   + fiveWeight * fiveRWeight;
    double pChance = twoWeight * twoPWeight
                   + threeWeight * threePWeight
                   + fourWeight * fourPWeight
                   + fiveWeight * fivePWeight;
    double sChance = twoWeight * twoSWeight
                   + threeWeight * threeSWeight
                   + fourWeight * fourSWeight
                   + fiveWeight * fiveSWeight;

    //The actual threshhold between 0 and 1 for this move to be picked
    double rThresh = rChance;
    double pThresh = rChance + pChance;
    //sThresh maybe redundant?
    double sThresh = 1 - pThresh;
    //<!> CHECK IF ADD TO 1!!<!>
    //debugging
    System.out.println("rThresh: " + rThresh);
    System.out.println("pThresh: " + pThresh);
    System.out.println("sThresh: " + sThresh);
    double total = rThresh + pThresh + sThresh;
    System.out.println("Total: " + total);

    //The move returned
    int rando = Math.Random();
    if(rando > rThresh){
      return 0;
    }
    else if(rando > pThresh){
      return 1;
    }
    else{
      return 2;
    }
  }

  //play turns with scanner
  public boolean game(){
    while(!gameEnded){
      System.out.println("Rock, Paper, or Scissors?\n");
      String pMove = input.nextLine();
      //quit
      if(pMove.equals("quit")){
        System.out.println("Game terminated");
        return false;
      }

      if(pMove.equals("Rock") || pMove.equals("rock")){
        turn(0);
      }
      else if(pMove.equals("Paper") || pMove.equals("paper")){
        turn(1);
      }
      else if(pMove.equals("Scissors") || pMove.equals("scissors") || pMove.equals("Scissor") || pMove.equals("scissor")){
        turn(2);
      }
      else if (pMove){
        turn(Integer.parseInt(pMove));
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
