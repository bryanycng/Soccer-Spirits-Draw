import java.io.IOException;
import java.util.*;

public class Main {
	public static List<Player> poolOfPlayers;

	public static void main(String[] args) throws IOException {
		
		Player.addAllPlayers();
		Player.addAllPlayerProbabilities();
		poolOfPlayers = Player.players;
		
		new Frame();
	
	}
	
}
