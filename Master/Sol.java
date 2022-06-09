/*
Two-Bs-or-Two-Not-to-B (Brian Wang, Brian Kang, Ethan Lam)
Final Project Iteration 0

Notes:
Second version of the game will run completely randomly. And actually work.

Moves:
0. Rock
1. Paper
2. Scissors

Defeat Gilgamesh
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Sol extends rps{

  public Sol(){
    super();
    super.setName("Sol");
    }

    //get a "RANDOM" move
    public int play(int pMove){
      int aMove = -1;
      if(pMove == 0){
        aMove = 1;
      }
      else if(pMove == 1){
        aMove = 2;
      }
      else if(pMove == 2){
        aMove = 0;
      }
      return aMove;
    }

  public String getInfo(){
    return "Plays a \"random\" move every time.";
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
