import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.FlowLayout;
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
		
		for (int i = 0; i < 10; i++){
		System.out.println(Player.drawPlayer());
		}
//	
		JFrame frame = new JFrame("Soccer Spirits Draw Simultor");
		final JPanel openingPanel = new JPanel();
		openingPanel.setSize(900, 600);
		openingPanel.setLayout(new FlowLayout());

		JLabel label = new JLabel("Normal 10 draw!");

		JButton draw = new JButton();
		draw.setText("Draw");
		draw.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  for (int i = 0; i < 10; i++){
						System.out.println(Player.drawPlayer());
						}
			  }
			});
		
		
		BufferedImage myPicture = ImageIO.read(new File("pictures/background.jpg"));
		Image scaledImage = myPicture.getScaledInstance(panel.getWidth(),panel.getHeight(),Image.SCALE_SMOOTH);
		JLabel picLabel = new JLabel(new ImageIcon(scaledImage));
		openingPanel.add(picLabel);
		openingPanel.add(label);
		openingPanel.add(draw);
		frame.add(openingPanel);
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}



	}
