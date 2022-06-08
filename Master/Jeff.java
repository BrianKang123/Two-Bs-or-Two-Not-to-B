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

public class Jeff extends rps{

  public Jeff(){
    super();
    super.setName("Jeff");
    }

    //get a "RANDOM" move
    public int play(int pMove){
      int aMove = -1;
      if(pMove == 0){
        aMove = 2;
      }
      else if(pMove == 1){
        aMove = 0;
      }
      else if(pMove == 2){
        aMove = 1;
      }
      return aMove;
    }

  public String getInfo(){
    return "Plays a random move every time.";
  }


}
