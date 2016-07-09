import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
	static int frameW = 1150;
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

	final JLabel card0 = new JLabel(whiteBackground);
	final JLabel card1 = new JLabel(whiteBackground);
	final JLabel card2 = new JLabel(whiteBackground);
	final JLabel card3 = new JLabel(whiteBackground);
	final JLabel card4 = new JLabel(whiteBackground);
	
	
	JLabel title = new JLabel("Normal 5 draw!");
	title.setFont(new Font("URW Chancery L", Font.PLAIN, 50));
	
	JButton draw = new JButton(setImageSize(getBufferedImagePNG("drawButton3"), 250,150));
	draw.setHorizontalTextPosition(JButton.CENTER);
	draw.setVerticalTextPosition(JButton.CENTER);
	draw.setBorder(null);
	draw.setBackground(null);


	draw.setText("Draw");
	draw.setFont(new Font("URW Chancery L", Font.PLAIN, 50));
	draw.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent evt) {
			  
			  	card0.setBorder(null);
			  	card1.setBorder(null);
			  	card2.setBorder(null);
			  	card3.setBorder(null);
			  	card4.setBorder(null);
			  	
			  	Player player0 = Player.drawPlayer();
			  	Player player1 = Player.drawPlayer();
			  	Player player2 = Player.drawPlayer();
			  	Player player3 = Player.drawPlayer();
			  	Player player4 = Player.drawPlayer();
			  
			  	setCardBorder(player0, card0);
			  	setCardBorder(player1, card1);
			  	setCardBorder(player2, card2);
			  	setCardBorder(player3, card3);
			  	setCardBorder(player4, card4);
			  	
				System.out.println(player0.name);
				System.out.println(player1.name);
				System.out.println(player2.name);
				System.out.println(player3.name);
				System.out.println(player4.name);
				
//					System.out.println(Player.drawPlayer().name);
					try {
						card0.setIcon(setCardSize(getBufferedImagePNG(player0.name)));
						card1.setIcon(setCardSize(getBufferedImagePNG(player1.name)));
						card2.setIcon(setCardSize(getBufferedImagePNG(player2.name)));
						card3.setIcon(setCardSize(getBufferedImagePNG(player3.name)));
						card4.setIcon(setCardSize(getBufferedImagePNG(player4.name)));
					} catch (IOException e) {
						e.printStackTrace();
					}
		  		}
			});		
	
	titlePanel.setBackground(null);
	title.setForeground(Color.WHITE);
	titlePanel.add(Box.createVerticalStrut(80)); 
	titlePanel.add(title);

	drawPanel.setBackground(null);
	draw.setForeground(Color.WHITE);
	drawPanel.add(Box.createVerticalStrut(80));
	drawPanel.add(draw);
	
	cardPanel0.setBackground(null);
	cardPanel1.setBackground(null);
	cardPanel2.setBackground(null);
	
	cardPanel0.add(Box.createVerticalStrut(450)); 
	cardPanel1.add(Box.createVerticalStrut(450)); 
	cardPanel2.add(Box.createVerticalStrut(450)); 
	cardPanel0.add(Box.createHorizontalStrut(15)); 
	cardPanel0.add(card0);
	cardPanel0.add(Box.createHorizontalStrut(15)); 
	cardPanel0.add(card1);
	cardPanel1.add(card2);
	cardPanel2.add(card3);
	cardPanel2.add(Box.createHorizontalStrut(15)); 
	cardPanel2.add(card4);
	cardPanel2.add(Box.createHorizontalStrut(15)); 

	frame.add(titlePanel, BorderLayout.PAGE_START);
	frame.add(drawPanel, BorderLayout.PAGE_END);
	
	frame.add(cardPanel0, BorderLayout.LINE_START);
	frame.add(cardPanel1, BorderLayout.CENTER);
	frame.add(cardPanel2, BorderLayout.LINE_END);
	
	frame.getContentPane().setBackground(Color.blue);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.setResizable(false);	
	
}

public static BufferedImage getBufferedImagePNG(String name) throws IOException{
	String noSpace = name.replaceAll(" ",  "");
	BufferedImage buffered = ImageIO.read(new File("pictures/" + noSpace + ".png"));
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
	card.setBorder(BorderFactory.createLineBorder(Color.CYAN, 10));
	}
}

}
