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

public class Brian extends rps{

  public Brian(){
    super();
    super.setName("Brian");
    }

  //get a RANDOM move
  public int play(int pMove){
    return (int)(Math.random() * 3);
  }

  public String getInfo(){
    return "Plays a random move every time.";
  }


}
