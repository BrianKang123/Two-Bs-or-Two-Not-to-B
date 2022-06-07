/*
Two-Bs-or-Two-Not-to-B (Brian Wang, Brian Kang, Ethan Lam)
Final Project Iteration 2

Notes:
Start skeleton of AI structure.

Moves:
0. Rock
1. Paper
2. Scissors

Defeat Enkidu
*/

import java.util.ArrayList;
import java.util.Scanner;

public class rps{
  protected final String[] key = {"Rock", "Paper", "Scissors"};
  protected ArrayList<Integer> moves;
  protected int gScore;
  protected int pScore;
  protected int tie;
  protected int turns;
  protected boolean gameEnded;
  protected int rocksPlayed;
  protected int papersPlayed;
  protected int scissorsPlayed;

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
      String pMoveList = input.nextLine();
      //quit
      if(pMoveList.equals("quit")){
        System.out.println("Game terminated");
        return false;
      }
      while(pMoveList.length() > 0){
        String pMove = pMoveList.substring(pMoveList.length() - 1);



        if(pMoveList.equals("Rock") || pMoveList.equals("rock")){
          turn(0);
          pMoveList = pMoveList.substring(0, pMoveList.length() - 3);
        }
        else if(pMoveList.equals("Paper") || pMoveList.equals("paper")){
          turn(1);
          pMoveList = pMoveList.substring(0, pMoveList.length() - 4);
        }
        else if(pMoveList.equals("Scissors") || pMoveList.equals("scissors")){
          turn(2);
          pMoveList = pMoveList.substring(0, pMoveList.length() - 7);
        }
        else if(pMoveList.equals("Scissor") || pMoveList.equals("scissor")){
          turn(2);
          pMoveList = pMoveList.substring(0, pMoveList.length() - 6);
        }
        else if(Integer.parseInt(pMove) == 0 || Integer.parseInt(pMove) == 1 || Integer.parseInt(pMove) == 2){
          turn(Integer.parseInt(pMove));
        }
        else{
          System.out.println("Enter a valid move!\n\n");;
        }
        pMoveList = pMoveList.substring(0, pMoveList.length() - 1);
      }

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
    moves.add(pMove);
    System.out.println("Player plays " + key[pMove]);
    System.out.println("Enkidu plays " + key[gMove]);


    turns += 1;

    //If player wins
    if(pMove - gMove == 1 || pMove - gMove == -2){
      System.out.println("Player wins\n\n");
      pScore += 1;
      return true;
    }

    //If Enkidu wins
    else if(gMove - pMove == 1 || gMove - pMove == -2){
      System.out.println("Enkidu wins\n\n");
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

  public String getInfo(){
    return "placeholder";
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
