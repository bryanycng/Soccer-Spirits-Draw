import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Player {
	static double prob3 = 0.73;
	static double prob4 = 0.22;
	static double prob5 = 0.0495;
	static double prob6 = 0.0005;
	static double totalWeight = 0.0d;
	
	String name;
	String element;
	int star;
	double probability;

	public static List<Player> players = new ArrayList<Player>();
	public static List<Double> playersProbability = new ArrayList<Double>();
	public static List<Double> listOfProb = new ArrayList<Double>();
	
	
	public Player(String n, String e, int s, double p ) {
		this.name = n;
		this.element = e;
		this.star = s;
		this.probability = p;
	}
	
	public static void addPlayer(Player p) {
		players.add(p);
	}	

	
	public static void getNamesForInput(int star, double prob, String element) throws IOException {
		for (String line : Files.readAllLines(Paths.get("characterList/"+ element), StandardCharsets.US_ASCII)) {
			if (line.length() == 1){
				star = Integer.parseInt(line);
				prob = listOfProb.get(star-3);
			}
			else {
			addPlayer(new Player(line, element, star, prob)); 
			}
		}	
		
	}
	public static void addAllPlayers() throws IOException{
		int star = 0;
		double prob = 0;
		
		listOfProb.add(prob3);
		listOfProb.add(prob4);
		listOfProb.add(prob5);
		listOfProb.add(prob6);
		
		getNamesForInput(star, prob,"ardor");
		getNamesForInput(star, prob,"dark");
		getNamesForInput(star, prob,"light");
		getNamesForInput(star, prob,"thunder");
		getNamesForInput(star, prob,"whirlwind");
	}
	
	public static void addAllPlayerProbabilities() {
		for (Player p : players ){		
			playersProbability.add(p.probability);
		}
		
		for (Double d : playersProbability) {
		    totalWeight += d;
		}
	}	
	
	public static Player drawPlayer() {
		int randomIndex = -1;
		double random = Math.random() * totalWeight;
		for (int i = 0; i < playersProbability.size(); ++i) {
		    random -= playersProbability.get(i);
		    if (random <= 0.0d) {
		        randomIndex = i;
		        break;
		    }
		}
		Player randomPlayer = players.get(randomIndex);
		String name = randomPlayer.name;
		String star = Integer.toString(randomPlayer.star);
		String value = name + " " + star;
		return randomPlayer;
	}
}

