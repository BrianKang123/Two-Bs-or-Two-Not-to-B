/*
Two-Bs-or-Two-Not-to-B (Brian Wang, Brian Kang, Ethan Lam)
Final Project Iteration 5

Notes:
Enkidu AI but to lose.

Moves:
0. Rock
1. Paper
2. Scissors

*/

import java.util.ArrayList;
import java.util.Scanner;

public class rps{
  private final String[] key = {"Rock", "Paper", "Scissors"};
  private ArrayList<Integer> moves;
  private int gScore;
  private int pScore;
  private int tie;
  private int turns;
  private boolean gameEnded;

  Scanner input = new Scanner(System.in);

  public rps(){
    gScore = 0;
    pScore = 0;
    moves = new ArrayList<Integer>();
    turns = 0;
    gameEnded = false;
  }

  //get a "smart" move
  public int play(){
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

    //one/two/three/four/fiveWeight balancing
    //explain?
    double weightSum = Math.abs(Math.abs(oneRWeight - onePWeight) - oneSWeight)
                     + Math.abs(Math.abs(twoRWeight - twoPWeight) - twoSWeight)
                     + Math.abs(Math.abs(threeRWeight - threePWeight) - threeSWeight)
                     + Math.abs(Math.abs(fourRWeight - fourPWeight) - fourSWeight)
                     + Math.abs(Math.abs(fiveRWeight - fivePWeight) - fiveSWeight);
    oneWeight = Math.abs(Math.abs(oneRWeight - onePWeight) - oneSWeight)/weightSum;
    twoWeight = Math.abs(Math.abs(twoRWeight - twoPWeight) - twoSWeight)/weightSum;
    threeWeight = Math.abs(Math.abs(threeRWeight - threePWeight) - threeSWeight)/weightSum;
    fourWeight = Math.abs(Math.abs(fourRWeight - fourPWeight) - fourSWeight)/weightSum;
    fiveWeight = Math.abs(Math.abs(fiveRWeight - fivePWeight) - fiveSWeight)/weightSum;

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
    System.out.println("\n\nOverall weights: ");
    System.out.println("weightSum: " + weightSum);
    System.out.println("oneWeight: " + oneWeight);
    System.out.println("twoWeight: " + twoWeight);
    System.out.println("threeWeight: " + threeWeight);
    System.out.println("fourWeight: " + fourWeight);
    System.out.println("fiveWeight: " + fiveWeight + "\n");
    */
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
      return 2;
    }
    else if(rando < pThresh){
      return 0;
    }
    else{
      return 1;
    }
  }

  //play turns with scanner
  public boolean game(){
    while(!gameEnded){
      System.out.println("Rock, Paper, or Scissors?\n");
      String pMoveList = input.nextLine();
      //quit
      if(pMoveList.equals("quit")){
        System.out.println("Game terminated");
        return false;
      }
      while(pMoveList.length() > 0){
        String pMove = pMoveList.substring(pMoveList.length() - 1);



        if(pMoveList.equals("Rock") || pMoveList.equals("rock")){
          turn(0);
          pMoveList = pMoveList.substring(0, pMoveList.length() - 3);
        }
        else if(pMoveList.equals("Paper") || pMoveList.equals("paper")){
          turn(1);
          pMoveList = pMoveList.substring(0, pMoveList.length() - 4);
        }
        else if(pMoveList.equals("Scissors") || pMoveList.equals("scissors")){
          turn(2);
          pMoveList = pMoveList.substring(0, pMoveList.length() - 7);
        }
        else if(pMoveList.equals("Scissor") || pMoveList.equals("scissor")){
          turn(2);
          pMoveList = pMoveList.substring(0, pMoveList.length() - 6);
        }
        else if(Integer.parseInt(pMove) == 0 || Integer.parseInt(pMove) == 1 || Integer.parseInt(pMove) == 2){
          turn(Integer.parseInt(pMove));
        }
        else{
          System.out.println("Enter a valid move!\n\n");;
        }
        pMoveList = pMoveList.substring(0, pMoveList.length() - 1);
      }

    }
    return true;
  }

  //play a turn
  public boolean turn(int pMove){

    //validate move
    if(pMove > 2 || pMove < 0){
      System.out.println("Enter a valid move!\n\n");
      return false;
    }



    //rng number
    int gMove = play();
    moves.add(pMove);
    System.out.println("Player plays " + key[pMove]);
    System.out.println("Sal plays " + key[gMove]);


    turns += 1;

    //If player wins
    if(pMove - gMove == 1 || pMove - gMove == -2){
      System.out.println("Player wins\n\n");
      pScore += 1;
      return true;
    }

    //If Enkidu wins
    else if(gMove - pMove == 1 || gMove - pMove == -2){
      System.out.println("Sal wins\n\n");
      gScore += 1;
      return false;
    }

    //If tie
    else{
      System.out.println("Tie\n\n");
      tie += 1;
      return false;
    }
  }

  public String getMove(int move){
    return key[move];
  }


  //Accessors

  public ArrayList getMoveHistory(){
    return moves;
  }

  public int getGScore(){
    return gScore;
  }

  public int getPScore(){
    return pScore;
  }

  public int getTie(){
    return tie;
  }

  public int getTurn(){
    return turns;
  }

  public static void main(String[] args) {
    rps game = new rps();
    int turn = 0;
    while(true){
      if(args.length > turn){
        System.out.println("0: Rock\n1: Paper\n2: Scissors");
        System.out.println("Player plays " + args[turn]);
        game.turn(Integer.parseInt(args[turn]));
        turn += 1;
      }
    }
  }
}
