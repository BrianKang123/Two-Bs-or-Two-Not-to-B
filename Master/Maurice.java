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
    return "Maurice is a clone of Eobard, but even MORE RACIST. He keeps track of your most played move and plays that move more often.";
  }

  public String getStory(){
    return "It is I, the CEO of RACISM! I- I'm about to get RACIST! aaaaaaaAAAAAAAAHHHHHHHHHHHH!";
  }

  public String winQuote(){
    double rand = Math.random();
    if(rand > 2.0/3.0){
      return "I'm gonna RACE ALL OVER YOU!";
    }
    else if(rand > 1.0/3.0){
      return "It's RACIN' TIME!";
    }
    else{
      return "Take this: RACIST BEAM!";
    }
  }

  public String loseQuote(){
    double rand = Math.random();
    if(rand > 2.0/3.0){
      return "How- how could my racism lose?";
    }
    else if(rand > 1.0/3.0){
      return "No no no! I can feel the RACISM LEAVING ME!";
    }
    else{
      return "Why isn't this working? Must I be MORE RACIST?";
    }
  }

  public String victory(){
    return "I've done it. I've reached ULTRA RACIST.";
  }

  public String defeat(){
    return "Well... done. All my life, I just wanted to watch the race cars. But no matter how racist I became, I never saw them.\nIt seems like... you were just more racist than me. Carry on my legacy now... This is the last of my RACISM! TAKE IT FROM ME!\nYou are now the NEW CEO of racism...";
  }
}
