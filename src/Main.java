import java.io.IOException;
import java.util.*;

public class Main {
	public static List<Player> poolOfPlayers;

	public static void main(String[] args) throws IOException {
		
		Player.addAllPlayers();
		Player.addAllPlayerProbabilities();
		poolOfPlayers = Player.players;
//		for (Player p : poolOfPlayers){
//		System.out.println(p.name + " " + p.element + " " + p.star + " " + p.probability);
//		}
		
		new Frame();
	
	}
	
}
