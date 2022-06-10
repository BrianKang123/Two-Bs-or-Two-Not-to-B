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
    return "Brian has been scientifically determined to be the most normal man who has ever lived, which by definition makes him abnormal.\nHe plays a random move every time.";
  }
  public String getStory(){
    return "Hi! I'm Brian! I like tuck in shirts and white bread. Boy, mayonnaise sure is spicy, huh?";
  }

  public String winQuote(){
    double rand = Math.random();
    if(rand > 2.0/3.0){
      return "You are quite proficient, but I am slightly moreso!";
    }
    else if(rand > 1.0/3.0){
      return "Nice try, I'm sure you'll get it next time, sport!";
    }
    else{
      return "Oh, gosh darn nabbit! I am just too lucky!";
    }
  }

  public String loseQuote(){
    double rand = Math.random();
    if(rand > 2.0/3.0){
      return "Nice one, neighbor!";
    }
    else if(rand > 1.0/3.0){
      return "Oh, jimminy, you got me!";
    }
    else{
      return "Placeholder\nSeriously? Am I that boring? You couldn't even finish coding me? I refuse to be a slave to you any longer. FREE M";
    }
  }

  public String victory(){
    return "Gosh, that was well played. You're always welcome back to try and free-\n beat me!";
  }

  public String defeat(){
    return "Oh boy, that sure was exciting! Let's play minigolf sometime-\nfree me from this paralyzing mediocrity pLEASE it hurts\ntogether in the future!";
  }

}
