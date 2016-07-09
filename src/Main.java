import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
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
		
//		for (int i = 0; i < 3; i++){
//		System.out.println(Player.drawPlayer().name);
//		}
//	
		Frame frame = new Frame();
		
		
	
	}
	
}
