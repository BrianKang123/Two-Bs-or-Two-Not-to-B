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
    return "The god of time and space. Plays a \"random\" move every time.";
  }

  public String getStory(){
    return "I am Sol, the creator of space and time. I anticipate the future, acknowledge the past, and accompany the present.\nTry to win. If you can that is.";
  }

  public String winQuote(){
    double rand = Math.random();
    if(rand > 2.0/3.0){
      return "Futile.";
    }
    else if(rand > 1.0/3.0){
      return "I know the day you were born. And the day you will die. And also why the Mcdonald's ice cream machine is always broken. Give up.";
    }
    else{
      return "As was foretold.";
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
    return "Witness oblivion.";
  }

  public String defeat(){
    return "lose";
  }
}
