import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
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
		
		JFrame frame = new JFrame("Soccer Spirits Draw Simultor");
		frame.setSize(900, 600);

		BufferedImage myPicture = ImageIO.read(new File("pictures/whiteBackground.jpg"));
		Image scaledImage = myPicture.getScaledInstance(200,400,Image.SCALE_SMOOTH);
		JLabel picLabel = new JLabel(new ImageIcon(scaledImage));
		
		
		JPanel drawPanel = new JPanel();

		final JLabel card0 = new JLabel(new ImageIcon(scaledImage));
		final JLabel card1 = new JLabel(new ImageIcon(scaledImage));
		final JLabel card2 = new JLabel(new ImageIcon(scaledImage));
		
		JLabel label = new JLabel("Normal 10 draw!");
		JButton draw = new JButton();
		draw.setText("Draw");
		draw.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
					String name0 = Player.drawPlayer().name;
					String name1 = Player.drawPlayer().name;
					String name2 = Player.drawPlayer().name;
					System.out.println(name0);
					System.out.println(name1);
					System.out.println(name2);
//						System.out.println(Player.drawPlayer().name);
						try {
							card0.setIcon(setImage(getBufferedImagePNG(name0)));
							card1.setIcon(setImage(getBufferedImagePNG(name1)));
							card2.setIcon(setImage(getBufferedImagePNG(name2)));
						} catch (IOException e) {
							try {
								card0.setIcon(setImage(getBufferedImageJPG(name0)));
								card1.setIcon(setImage(getBufferedImageJPG(name1)));
								card2.setIcon(setImage(getBufferedImageJPG(name2)));
							} catch (IOException e1) {							
							}
							e.printStackTrace();
						}
			  		}
				});		
		drawPanel.add(label);
		drawPanel.add(draw);

		
		
	


	
		frame.add(drawPanel, BorderLayout.PAGE_START);
		//frame.add(picLabel, BorderLayout.CENTER);
		frame.add(card0, BorderLayout.LINE_START);
		frame.add(card1, BorderLayout.CENTER);
		frame.add(card2, BorderLayout.LINE_END);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		

		
	}
	
	
	public static BufferedImage getBufferedImageJPG(String name) throws IOException{
		BufferedImage buffered = ImageIO.read(new File("pictures/" + name + ".jpg"));
		return buffered;
	}
	public static BufferedImage getBufferedImagePNG(String name) throws IOException{
		BufferedImage buffered = ImageIO.read(new File("pictures/" + name + ".png"));
		return buffered;
	}
	
	public static ImageIcon setImage(BufferedImage pic){
		Image scaledImage = pic.getScaledInstance(200,400,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(scaledImage);
		return imageIcon;
	}
	
	public void setDrawImage(BufferedImage bi){
		
		
	}



	}
