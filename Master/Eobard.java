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
    super.setName("Eobard");
  }

  //get a WEIGHTED move
  public int play(int pMove){
    if(turns <= 3){
      return (int)(Math.random() * 3);
    }
    int value = (int)(Math.random() * (turns+1));
    //System.out.println("value: " + value);
    //System.out.println("Rocks: " + rocksPlayed);
    //System.out.println("Paper: " + papersPlayed);
    //System.out.println("Scissors: " + scissorsPlayed);
    if(value < rocksPlayed){
      return 1;
    }
    else if(value < rocksPlayed + papersPlayed){
      return 2;
    }
    else if(value < rocksPlayed + papersPlayed + scissorsPlayed ){
      return 0;
    }
    return 0;
  }

  public String getInfo(){
    return "Keeps track of your most played move and will play the advantageous move more often. \nEobard is a wanted tax fugitive in 64 countries. All IRS officers have an order to kill him on sight. He wishes to take over Florida, because they have no income tax.";
  }

  public String getStory(){
    return "Every year, THOUSANDS of dollars are STOLEN from me to build ROADS and ORPHANAGES!\nTHE IRS WILL NOT SEE A SINGLE CENT FROM ME!\nTHE LORD IS MY SHEPHERD; I SHALL NOT WANT. HE MAKETH ME TO LIE DOWN IN GREEN PASTURES: HE LEADETH ME BESIDE THE STILL WATERS-";
  }

  public String winQuote(){
    double rand = Math.random();
    if(rand > 2.0/3.0){
      return "I call down upon the great and terrible tax evading power of\n...JEFF BEZOS!";
    }
    else if(rand > 1.0/3.0){
      return "If I win, can I claim you as a dependent for tax purposes?";
    }
    else{
      return "TAXATION IS THEFT! I think that's how that quote goes.";
    }
  }

  public String loseQuote(){
    double rand = Math.random();
    if(rand > 2.0/3.0){
      return "Did the government send you here to stop me from microwaving hamster?\nJust MORE PROOF of government OPPRESSION!";
    }
    else if(rand > 1.0/3.0){
      return "They call this the 'Land of the Free,' so why do they keep trying to stop me from eating the cotton candy in the walls?";
    }
    else{
      return "";
    }
  }

  public String victory(){
    return "Finally, now that I have won, I finally have control over Florida!\n...This place is terrible.\n\nThis was a mistake.";
  }

  public String defeat(){
    return "My father never loved me, but when he died by my hands, he asked me with his last dying breath: 'Son, why did you do it?'\nTears dropped down my face, and I couldn't respond. But I knew.\nI knew what he did to my brother. Mom alawys told me the wrong son had died. But-[edited out for the sake of brevity.]\n\nAnyway, so that's why I'm racist.";
  }

}
