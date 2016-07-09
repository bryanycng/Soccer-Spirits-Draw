import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Frame {
	
	static int frameH = 500;
	static int frameW = 1150;
	static int cardH = 300;
	static int cardW = 200;
	
	public Frame() throws IOException {
		
	JFrame frame = new JFrame("Soccer Spirits Draw Simultor");
	frame.setSize(frameW, frameH);

	ImageIcon whiteBackground = setImage(getBufferedImagePNG("whiteBackground"));
	
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
	
	JLabel label = new JLabel("Normal 5 draw!");
	JButton draw = new JButton();
	draw.setText("Draw");
	draw.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent evt) {
				String name0 = Player.drawPlayer().name;
				String name1 = Player.drawPlayer().name;
				String name2 = Player.drawPlayer().name;
				String name3 = Player.drawPlayer().name;
				String name4 = Player.drawPlayer().name;
				System.out.println(name0);
				System.out.println(name1);
				System.out.println(name2);
//					System.out.println(Player.drawPlayer().name);
					try {
						card0.setIcon(setImage(getBufferedImagePNG(name0)));
						card1.setIcon(setImage(getBufferedImagePNG(name1)));
						card2.setIcon(setImage(getBufferedImagePNG(name2)));
						card3.setIcon(setImage(getBufferedImagePNG(name3)));
						card4.setIcon(setImage(getBufferedImagePNG(name4)));
					} catch (IOException e) {
						e.printStackTrace();
					}
		  		}
			});		
	
	titlePanel.add(Box.createVerticalStrut(80)); 
	titlePanel.add(label);
	drawPanel.add(Box.createVerticalStrut(80));
	drawPanel.add(draw);
	
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
	
	frame.getContentPane().setBackground(Color.BLUE);
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

public static ImageIcon setImage(BufferedImage pic){
	Image scaledImage = pic.getScaledInstance(cardW,cardH,Image.SCALE_SMOOTH);
	ImageIcon imageIcon = new ImageIcon(scaledImage);
	return imageIcon;
}

}
