
public class rpsDriver{

    public static void main(String[] args) {
      rps newGame = new rps();

      newGame.game();
      System.out.println(newGame.getMoveHistory());
      System.out.println("Games played: " + newGame.getTurn());
      double pWinPercent = newGame.getPScore() * 1.0 / newGame.getTurn();
      double gWinPercent = newGame.getGScore() * 1.0 / newGame.getTurn();
      System.out.println("Player score: " + newGame.getPScore() + " (Winrate: " + (int)(100 * pWinPercent) + "%)");
      System.out.println("Enkidu score: " + newGame.getGScore() + " (Winrate: " + (int)(100 * gWinPercent) + "%)");
      System.out.println("Ties: " + newGame.getTie());
    }




}