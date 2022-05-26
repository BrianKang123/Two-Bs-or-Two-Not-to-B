/*
Two-Bs-or-Two-Not-to-B (Brian Wang, Brian Kang, Ethan Lam)
Final Project Iteration 0

Notes:
First version of the game will run completely randomly.

Moves:
0. Rock
1. Paper
2. Scissors
*/

import java.util.ArrayList;
public class rps{
  private final String[] key = {"Rock", "Paper", "Scissors"};
  private ArrayList<String> moves;
  private int aScore;
  private int pScore;

  public rps(){
    aScore = 0;
    pScore = 0;
    moves = new ArrayList<String>();
  }


  public int play(){
    return (int)(Math.random() * 3);
  }

  public boolean turn(int pMove){
    int aMove = play();
    System.out.println("AI plays " + key[aMove]);
    if(pMove - aMove == 1 || pMove - aMove == -2){
      System.out.println("Player wins");
      pScore += 1;
      return true;
    }
    else if(aMove - pMove == 1 || aMove - pMove == -2){
      System.out.println("AI wins");
      aScore += 1;
      return false;
    }
    else{
      System.out.println("Tie");
      return false;
    }
  }

  public String getMove(int move){
    return key[move];
  }

  
}
