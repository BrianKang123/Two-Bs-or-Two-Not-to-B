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

public class Eobard extends rps{


  public Eobard(){
    super();
  }

  //get a RANDOM move
  public int play(){
    if(turns <= 3){
      return (int)(Math.random() * 3);
    }
    int value = (int)(Math.random() * (turns+1));
    if(value < rocksPlayed){
      return 0;
    }
    if(value < rocksPlayed + papersPlayed){
      return 1;
    }
    if(value < rocksPlayed + papersPlayed + scissorsPlayed ){
      return 2;
    }
    return 0;
  }


}
