import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Array;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Frame {
	
	static int frameH = 800;
	static int frameW = 1200;
	static int cardH = 300;
	static int cardW = 200;
	
	public Frame() throws IOException {
		
	JFrame frame = new JFrame("Soccer Spirits Draw Simultor");
	frame.setSize(frameW, frameH);

	ImageIcon whiteBackground = setCardSize(getBufferedImagePNG("whiteBackground"));
	
	JPanel titlePanel = new JPanel();
	JPanel drawPanel = new JPanel();
	JPanel cardPanel0 = new JPanel();	//contains cards 0 and 1
	JPanel cardPanel1 = new JPanel();	//contains card 2
	JPanel cardPanel2 = new JPanel();	//contains card 3 and 4

	final JLabel[] cards = new JLabel[5];
	for (int i =  0; i < 5; i++) {
	       cards[i] = new JLabel(whiteBackground);
	}

	JLabel title = new JLabel("Normal 5 draw!");
	title.setFont(new Font("URW Chancery L", Font.PLAIN, 50));
	
	JButton draw = new JButton(setImageSize(getBufferedImagePNG("goButton"), 150,150));
	draw.setHorizontalTextPosition(JButton.CENTER);
	draw.setVerticalTextPosition(JButton.CENTER);
	draw.setBorder(null);
	draw.setBackground(Color.decode("000033"));

	final Player[] players = new Player[5];
	
	draw.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent evt) {
			  	for (JLabel card: cards){
			  	card.setBorder(null);
			  	}
				for (int i =  0; i < 5; i++) {
				       players[i] =  Player.drawPlayer();
				}
				for (int i =  0; i < 5; i++) {
				  	setCardBorder(players[i], cards[i]);
				  	System.out.println(players[i].name);
			  	}

					try {
						for (int i =  0; i < 5; i++) {
							cards[i].setIcon(setCardSize(getBufferedImagePNG(players[i].name)));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		  		}
			});		
	
	titlePanel.setBackground(null);
	title.setForeground(Color.WHITE);
	titlePanel.add(Box.createVerticalStrut(80)); 
	titlePanel.add(title);

	drawPanel.setBackground(Color.decode("#000033"));
	drawPanel.add(Box.createVerticalStrut(80));
	drawPanel.add(draw);
	
	cardPanel0.setBackground(null);
	cardPanel1.setBackground(null);
	cardPanel2.setBackground(null);
	
	cardPanel0.add(Box.createVerticalStrut(450)); 
	cardPanel1.add(Box.createVerticalStrut(450)); 
	cardPanel2.add(Box.createVerticalStrut(450)); 
	cardPanel0.add(Box.createHorizontalStrut(15)); 
	cardPanel0.add(cards[0]);
	cardPanel0.add(Box.createHorizontalStrut(15)); 
	cardPanel0.add(cards[1]);
	cardPanel1.add(cards[2]);
	cardPanel2.add(cards[3]);
	cardPanel2.add(Box.createHorizontalStrut(15)); 
	cardPanel2.add(cards[4]);
	cardPanel2.add(Box.createHorizontalStrut(15)); 

	frame.getContentPane().setBackground(Color.decode("#000033"));
	frame.add(titlePanel, BorderLayout.PAGE_START);
	frame.add(drawPanel, BorderLayout.PAGE_END);
	
	frame.add(cardPanel0, BorderLayout.LINE_START);
	frame.add(cardPanel1, BorderLayout.CENTER);
	frame.add(cardPanel2, BorderLayout.LINE_END);
	
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.setResizable(false);	
	
}

public static BufferedImage getBufferedImagePNG(String name) throws IOException{
	String path = new File("").getAbsolutePath();
	String noSpace = name.replaceAll(" ",  "");
	BufferedImage buffered = ImageIO.read(new File(path + "/resources/pictures/" + noSpace + ".png"));
	return buffered;
}

//sets size of card
public static ImageIcon setCardSize(BufferedImage pic){
	Image scaledImage = pic.getScaledInstance(cardW,cardH,Image.SCALE_SMOOTH);
	ImageIcon imageIcon = new ImageIcon(scaledImage);
	return imageIcon;
}

//adjustable size with parameter
public static ImageIcon setImageSize(BufferedImage pic, int width, int height){
	Image scaledImage = pic.getScaledInstance(width,height,Image.SCALE_SMOOTH);
	ImageIcon imageIcon = new ImageIcon(scaledImage);
	return imageIcon;
}

public void setCardBorder(Player p, JLabel card) {
	if (p.star == 5){
	card.setBorder(BorderFactory.createLineBorder(Color.decode("#0033cc"), 10));
	}
	if (p.star == 6){
	card.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 10));
	}
}

}
