import java.util.ArrayList;
import java.util.Scanner;

public class Sol extends rps{


  public Sol(){
    super();
  }

  //get a RANDOM move
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
    return "Just wins.";
  }



}
