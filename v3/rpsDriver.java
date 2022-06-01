
public class rpsDriver{

    public static void main(String[] args) {
      rps newGame = new rps();
      /*
      for(int i = 0 ; i < args.length ; i++){
        newGame.turn(Integer.parseInt(args[i]));

      }
      */
      newGame.game();
      System.out.println(newGame.getMoveHistory());
      System.out.println("Games played: " + newGame.getTurn());
      double pWinPercent = newGame.getPScore() * 1.0 / newGame.getTurn();
      double gWinPercent = newGame.getGScore() * 1.0 / newGame.getTurn();
      System.out.println("Player score: " + newGame.getPScore() + " (Winrate: " + pWinPercent + "%)");
      System.out.println("Eobard score: " + newGame.getGScore() + " (Winrate: " + gWinPercent + "%)");
      System.out.println("Ties: " + newGame.getTie());
    }




}
