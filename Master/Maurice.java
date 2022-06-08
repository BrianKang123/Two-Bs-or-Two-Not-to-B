/*
Two-Bs-or-Two-Not-to-B (Brian Wang, Brian Kang, Ethan Lam)
Final Project Iteration 0

Notes:
Second version of the game will run completely randomly. And actually work.

Moves:
0. Rock
1. Paper
2. Scissors

Defeat Eobard
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Maurice extends rps{


  public Maurice(){
    super();
    super.setName("Maurice");
  }

  //get a WEIGHTED move
  public int play(int pMove){
    if(turns <= 3){
      return (int)(Math.random() * 3);
    }
    int value = (int)(Math.random() * (turns+1));
    System.out.println("value: " + value);
    System.out.println("Rocks: " + rocksPlayed);
    System.out.println("Paper: " + papersPlayed);
    System.out.println("Scissors: " + scissorsPlayed);
    if(value < rocksPlayed){
      return 0;
    }
    else if(value < rocksPlayed + papersPlayed){
      return 1;
    }
    else if(value < rocksPlayed + papersPlayed + scissorsPlayed ){
      return 2;
    }
    return 0;
  }

  public String getInfo(){
    return "Plays a move depending on your past moves played.";
  }

  public String getStory(){
    return "Placeholder";
  }

  public String winQuote(){
    double rand = Math.random();
    if(rand > 2/3){
      return "Placeholder";
    }
    else if(rand > 1/3){
      return "Placeholder";
    }
    else{
      return "Placeholder";
    }
  }

  public String loseQuote(){
    double rand = Math.random();
    if(rand > 2/3){
      return "Placeholder";
    }
    else if(rand > 1/3){
      return "Placeholder";
    }
    else{
      return "Placeholder";
    }
  }

  public String victory(){
    return "win";
  }

  public String defeat(){
    return "lose";
  }
}
