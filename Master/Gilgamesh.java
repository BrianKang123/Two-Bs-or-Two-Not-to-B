/*
Two-Bs-or-Two-Not-to-B (Brian Wang, Brian Kang, Ethan Lam)
Final Project Iteration 2

Notes:
Start skeleton of AI structure.

Moves:
0. Rock
1. Paper
2. Scissors

Defeat Gilgamesh
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Gilgamesh extends rps{


  public Gilgamesh(){
      super();
      super.setName("Gilgamesh");
    }

  //get a "smart" move
  public int play(int pMove){
    //List of weights
    //Overall weight factors for final decision
    //THESE WILL LIKELY BE MANUALLY CHANGED!!!!
    //What if we adjusted these on past plays?
    double oneWeight = .2;
    double twoWeight = .2;
    double threeWeight = .2;
    double fourWeight = .2;
    double fiveWeight = .2;
    //THESE WILL BE ADJUSTED BY THE MACHINE!!!!

    double oneRWeight = 1.0/3.0;
    double onePWeight = 1.0/3.0;
    double oneSWeight = 1.0/3.0;

    //Most probable move from two move history
    double twoRWeight = 1.0/3.0;
    double twoPWeight = 1.0/3.0;
    double twoSWeight = 1.0/3.0;

    //Most probable move from three move history
    double threeRWeight = 1.0/3.0;
    double threePWeight = 1.0/3.0;
    double threeSWeight = 1.0/3.0;

    //Most probable move from four move history
    double fourRWeight = 1.0/3.0;
    double fourPWeight = 1.0/3.0;
    double fourSWeight = 1.0/3.0;

    //Most probable move from five move history
    double fiveRWeight = 1.0/3.0;
    double fivePWeight = 1.0/3.0;
    double fiveSWeight = 1.0/3.0;

    //Weights will dynamically change depending on move history
    //Do we need to bother with move patterns past 5?



    //stringify move history, easier to search
    String moveHist = "";
    for(int ele : moves){
      moveHist += Integer.toString(ele);
    }

    //1 move batch history
    if(moves.size() > 1){
      //Counters for weight calc
      double rCount = 0;
      double pCount = 0;
      double sCount = 0;
      double count = 0;

      //current past moves
      String valSet = moveHist.substring(moveHist.length() - 1, moveHist.length());

      //all moves except most recent moves
      String searchSet = moveHist.substring(0, moveHist.length() - 1);

      //search for all occurrences of the past move pattern
      while(searchSet.indexOf(valSet) != -1 && searchSet.indexOf(valSet) < searchSet.length() - 2){
        String nextMove = searchSet.substring(searchSet.indexOf(valSet) + 1, searchSet.indexOf(valSet) + 2);
        //only eliminate the first string but not the entire match incase self recurring
        searchSet = searchSet.substring(searchSet.indexOf(valSet) + 1);
        /*
        System.out.println("\n\nString Info - Block 1: ");
        System.out.println("valSet: " + valSet);
        System.out.println("searchSet: " + searchSet);
        System.out.println("nextMove: " + nextMove);
        */
        //count rock paper or scissors
        if(nextMove.equals("0")){
          rCount += 1;
        }
        else if(nextMove.equals("1")){
          pCount += 1;
        }
        else if(nextMove.equals("2")){
          sCount += 1;
        }
        //total move count
        count = rCount + pCount + sCount;

        oneRWeight = rCount * 1.0 / count;
        onePWeight = pCount * 1.0 / count;
        oneSWeight = sCount * 1.0 / count;


      }
      /*
      System.out.println("\n\nAssorted Info - Block 1: ");
      System.out.println("rCount: " + rCount);
      System.out.println("pCount: " + pCount);
      System.out.println("sCount: " + sCount);
      System.out.println("count: " + count);
      */

    }

    //2 move batch history
    if(moves.size() > 2){
      //Counters for weight calc
      double rCount = 0;
      double pCount = 0;
      double sCount = 0;
      double count = 0;

      //current past moves
      String valSet = moveHist.substring(moveHist.length() - 2, moveHist.length());

      //all moves except most recent moves
      String searchSet = moveHist.substring(0, moveHist.length() - 2);

      //search for all occurrences of the past move pattern
      while(searchSet.indexOf(valSet) != -1 && searchSet.indexOf(valSet) < searchSet.length() - 3){
        String nextMove = searchSet.substring(searchSet.indexOf(valSet) + 2, searchSet.indexOf(valSet) + 3);
        //only eliminate the first string but not the entire match incase self recurring
        searchSet = searchSet.substring(searchSet.indexOf(valSet) + 1);
        /*
        System.out.println("\n\nString Info - Block 2: ");
        System.out.println("valSet: " + valSet);
        System.out.println("searchSet: " + searchSet);
        System.out.println("nextMove: " + nextMove);
        */
        //count rock paper or scissors
        if(nextMove.equals("0")){
          rCount += 1;
        }
        else if(nextMove.equals("1")){
          pCount += 1;
        }
        else if(nextMove.equals("2")){
          sCount += 1;
        }
        //total move count
        count = rCount + pCount + sCount;

        twoRWeight = rCount * 1.0 / count;
        twoPWeight = pCount * 1.0 / count;
        twoSWeight = sCount * 1.0 / count;

      }
      /*
      System.out.println("\n\nAssorted Info - Block 2: ");
      System.out.println("rCount: " + rCount);
      System.out.println("pCount: " + pCount);
      System.out.println("sCount: " + sCount);
      System.out.println("count: " + count);
      */

    }

    //3 move batch history
    if(moves.size() > 3){
      //Counters for weight calc
      double rCount = 0;
      double pCount = 0;
      double sCount = 0;
      double count = 0;

      //current past moves
      String valSet = moveHist.substring(moveHist.length() - 3, moveHist.length());

      //all moves except most recent moves
      String searchSet = moveHist.substring(0, moveHist.length() - 3);

      //search for all occurrences of the past move pattern
      while(searchSet.indexOf(valSet) != -1 && searchSet.indexOf(valSet) < searchSet.length() - 4){
        String nextMove = searchSet.substring(searchSet.indexOf(valSet) + 3, searchSet.indexOf(valSet) + 4);
        //only eliminate the first string but not the entire match incase self recurring
        searchSet = searchSet.substring(searchSet.indexOf(valSet) + 1);
        /*
        System.out.println("\n\nString Info - Block 3: ");
        System.out.println("valSet: " + valSet);
        System.out.println("searchSet: " + searchSet);
        System.out.println("nextMove: " + nextMove);
        */
        //count rock paper or scissors
        if(nextMove.equals("0")){
          rCount += 1;
        }
        else if(nextMove.equals("1")){
          pCount += 1;
        }
        else if(nextMove.equals("2")){
          sCount += 1;
        }
        //total move count
        count = rCount + pCount + sCount;

        threeRWeight = rCount * 1.0 / count;
        threePWeight = pCount * 1.0 / count;
        threeSWeight = sCount * 1.0 / count;

      }
      /*
      System.out.println("\n\nAssorted Info - Block 3: ");
      System.out.println("rCount: " + rCount);
      System.out.println("pCount: " + pCount);
      System.out.println("sCount: " + sCount);
      System.out.println("count: " + count);
      */
    }

    //4 move batch history
    if(moves.size() > 4){
      //Counters for weight calc
      double rCount = 0;
      double pCount = 0;
      double sCount = 0;
      double count = 0;

      //current past movessize
      String valSet = moveHist.substring(moveHist.length() - 4, moveHist.length());

      //all moves except most recent moves
      String searchSet = moveHist.substring(0, moveHist.length() - 4);

      //search for all occurrences of the past move pattern
      while(searchSet.indexOf(valSet) != -1 && searchSet.indexOf(valSet) < searchSet.length() - 5){
        String nextMove = searchSet.substring(searchSet.indexOf(valSet) + 4, searchSet.indexOf(valSet) + 5);
        //only eliminate the first string but not the entire match incase self recurring
        searchSet = searchSet.substring(searchSet.indexOf(valSet) + 1);
        /*
        System.out.println("\n\nString Info - Block 4: ");
        System.out.println("valSet: " + valSet);
        System.out.println("searchSet: " + searchSet);
        System.out.println("nextMove: " + nextMove);
        */
        //count rock paper or scissors
        if(nextMove.equals("0")){
          rCount += 1;
        }
        else if(nextMove.equals("1")){
          pCount += 1;
        }
        else if(nextMove.equals("2")){
          sCount += 1;
        }
        //total move count
        count = rCount + pCount + sCount;

        fourRWeight = rCount * 1.0 / count;
        fourPWeight = pCount * 1.0 / count;
        fourSWeight = sCount * 1.0 / count;

      }
      /*
      System.out.println("\n\nAssorted Info - Block 4: ");
      System.out.println("rCount: " + rCount);
      System.out.println("pCount: " + pCount);
      System.out.println("sCount: " + sCount);
      System.out.println("count: " + count);
      */
    }

    //5 move batch history
    if(moves.size() > 5){
      //Counters for weight calc
      double rCount = 0;
      double pCount = 0;
      double sCount = 0;
      double count = 0;

      //current past moves
      String valSet = moveHist.substring(moveHist.length() - 5, moveHist.length());

      //all moves except most recent moves
      String searchSet = moveHist.substring(0, moveHist.length() - 5);

      //search for all occurrences of the past move pattern
      while(searchSet.indexOf(valSet) != -1 && searchSet.indexOf(valSet) < searchSet.length() - 6){
        String nextMove = searchSet.substring(searchSet.indexOf(valSet) + 5, searchSet.indexOf(valSet) + 6);
        //only eliminate the first string but not the entire match incase self recurring
        searchSet = searchSet.substring(searchSet.indexOf(valSet) + 1);
        /*
        System.out.println("\n\nString Info - Block 5: ");
        System.out.println("valSet: " + valSet);
        System.out.println("searchSet: " + searchSet);
        System.out.println("nextMove: " + nextMove);
        */
        //count rock paper or scissors
        if(nextMove.equals("0")){
          rCount += 1;
        }
        else if(nextMove.equals("1")){
          pCount += 1;
        }
        else if(nextMove.equals("2")){
          sCount += 1;
        }
        //total move count
        count = rCount + pCount + sCount;

        fiveRWeight = rCount * 1.0 / count;
        fivePWeight = pCount * 1.0 / count;
        fiveSWeight = sCount * 1.0 / count;

      }
      /*
      System.out.println("\n\nAssorted Info - Block 5: ");
      System.out.println("rCount: " + rCount);
      System.out.println("pCount: " + pCount);
      System.out.println("sCount: " + sCount);
      System.out.println("count: " + count);
      */
    }


    //Actual chance for each of the three moves
    double rChance = oneWeight * oneRWeight
                   + twoWeight * twoRWeight
                   + threeWeight * threeRWeight
                   + fourWeight * fourRWeight
                   + fiveWeight * fiveRWeight;
    double pChance = oneWeight * onePWeight
                   + twoWeight * twoPWeight
                   + threeWeight * threePWeight
                   + fourWeight * fourPWeight
                   + fiveWeight * fivePWeight;
    double sChance = oneWeight * oneSWeight
                   + twoWeight * twoSWeight
                   + threeWeight * threeSWeight
                   + fourWeight * fourSWeight
                   + fiveWeight * fiveSWeight;

    //The actual threshhold between 0 and 1 for this move to be picked
    double rThresh = rChance;
    double pThresh = rChance + pChance;
    //sThresh maybe redundant?
    double sThresh = rChance + pChance + sChance;
    //<!> CHECK IF ADD TO 1!!<!>
    //debugging
/*
    System.out.println("\n\nThresholds: ");
    System.out.println("rThresh: " + rThresh);
    System.out.println("pThresh: " + pThresh);
    System.out.println("sThresh: " + sThresh);

    System.out.println("\n\nWeights: ");
    System.out.println("rWeight: " + oneRWeight + " " + twoRWeight + " " + threeRWeight + " " + fourRWeight + " " + fiveRWeight);
    System.out.println("pWeight: " + onePWeight + " " + twoPWeight + " " + threePWeight + " " + fourPWeight + " " + fivePWeight);
    System.out.println("sWeight: " + oneSWeight + " " + twoSWeight + " " + threeSWeight + " " + fourSWeight + " " + fiveSWeight);
    System.out.println("Move #: " + moves.size());
/*
    System.out.println("\n\nAssorted Info: ");
    System.out.println("rCount: " + rCount);
    System.out.println("pCount: " + pCount);
    System.out.println("sCount: " + sCount);
    System.out.println("count: " + count);
*/
/*
    double total = rThresh + pThresh + sThresh;
    System.out.println("\n\nTotal: " + total);
    System.out.println("moveHist: " + moveHist);
*/

    //The move returned
    double rando = Math.random();
    if(rando < rThresh){
      return 1;
    }
    else if(rando < pThresh){
      return 2;
    }
    else{
      return 0;
    }
  }

  public String getInfo(){
    return "Smart, plays a move based on your past move patterns.";
  }


}
