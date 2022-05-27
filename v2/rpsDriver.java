
public class rpsDriver{

    public static void main(String[] args) {
      rps newGame = new rps();

      newGame.game();
      System.out.println(newGame.getMoveHistory());
      System.out.println("Games played: " + newGame.getTurn());
      System.out.println("Player score: " + newGame.getPScore());
      System.out.println("Gilgamesh score: " + newGame.getGScore());
      System.out.println("Ties: " + newGame.getTie());
    }




}
