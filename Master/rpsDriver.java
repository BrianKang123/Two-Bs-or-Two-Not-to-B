
public class rpsDriver{

    public static void main(String[] args) {
//implement selection, botName
      String botName = "Brian";
      rps newGame = new Brian();
      if(args.length < 1){
        System.out.println("No bot entered, default played");
      }
      else if(args[0].equals("Brian") || args[0].equals("brian")){
        newGame = new Brian();
        botName = "Brian";
      }
      else if(args[0].equals("Enkidu") || args[0].equals("enkidu")){
        newGame = new Enkidu();
        botName = "Enkidu";
      }
      else if(args[0].equals("Eobard") || args[0].equals("eobard")){
        newGame = new Eobard();
        botName = "Eobard";
      }
      else if(args[0].equals("Gilgamesh") || args[0].equals("gilgamesh")){
        newGame = new Gilgamesh();
        botName = "Gilgamesh";
      }
      else if(args[0].equals("Sal") || args[0].equals("sal")){
        newGame = new Sal();
        botName = "Sal";
      }
      else if(args[0].equals("Sol") || args[0].equals("sol")){
        newGame = new Sol();
        botName = "Sol";
      }
      else{
        System.out.println("Invalid bot entered, default played");
      }
      System.out.println("You will be playing: " + botName + ",\n");
      System.out.println(newGame.getInfo() + "\n\n");

      newGame.game();
      System.out.println(newGame.getMoveHistory());
      System.out.println("Games played: " + newGame.getTurn());
      double pWinPercent = newGame.getPScore() * 1.0 / (newGame.getPScore() + newGame.getGScore());
      double gWinPercent = newGame.getGScore() * 1.0 / (newGame.getPScore() + newGame.getGScore());
      System.out.println("Player score: " + newGame.getPScore() + " (Winrate: " + (int)(100 * pWinPercent) + "%)");
      System.out.println(botName + " score: " + newGame.getGScore() + " (Winrate: " + (int)(100 * gWinPercent) + "%)");
      System.out.println("Ties: " + newGame.getTie());
    }




}
