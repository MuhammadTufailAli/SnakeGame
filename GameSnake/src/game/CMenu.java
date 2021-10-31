package game;
import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CMenu {

	
	static int buttonX  =130;
	static int buttonY = 6;
	static Random r;
	
	static Color[] backGround = {
			Color.BLACK,
			Color.white,
			Color.ORANGE,
			Color.PINK,
			Color.GREEN,
			Color.DARK_GRAY,
			Color.magenta,
			Color.BLUE,
			
			
			
	};
	public static Color bColor =backGround[0];
	
	static Color[] snakeColors = {
			Color.RED,
			Color.ORANGE,
			Color.PINK,
			Color.GREEN,
			Color.DARK_GRAY,
			Color.magenta,
			Color.BLUE,
			Color.CYAN
			
	};
	
	
	public static Color sCLr = snakeColors[0];
	static Color[] appleColours = {
			Color.RED,
			Color.ORANGE,
			Color.PINK,
			Color.GREEN,
			Color.DARK_GRAY,
			Color.magenta,
			Color.BLUE,
			Color.CYAN
	};
	
	
	public static Color aCLr = appleColours[1];
	
	public static void main() {
		JFrame frame1 =new JFrame();
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(510,140,715,475);
		frame1.setLayout(null);
		ImageIcon image1 =new ImageIcon("D:\\java program only\\snakeimage.png");
		frame1.setIconImage(image1.getImage());
		
		
		JLabel snakeColor =new JLabel("SNAKE COLOR");
		snakeColor.setBounds(6, 6, 120, 60);
		snakeColor.setFont(new Font("Arial", Font.BOLD, 16));
		snakeColor.setForeground(Color.BLACK);
		
		Container c =frame1.getContentPane();
		c.setLayout(null);
		
//		c.add(label);
		c.add(snakeColor);
		
		//Create Snake Color Button
		for (int i = 0; i < snakeColors.length; i++) {
			JButton b =new JButton();
			b.setBounds(buttonX,buttonY,60,60);
			b.setBackground(snakeColors[i]);
			
			c.add(b);
			b.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	sCLr = b.getBackground();
	                
	            }
	        });
			
			buttonX += 70;
			
		}
		
		
		JLabel appleColor =new JLabel("APPLE COLOR");
		appleColor.setBounds(6, 130, 120, 60);
		appleColor.setFont(new Font("Arial", Font.BOLD, 16));
		appleColor.setForeground(Color.BLACK);
		
		
//		c.add(label);
		c.add(appleColor);
		
		buttonY = 130;
		buttonX = 130;
		
		//Create Snake Color Button
		for (int i = 0; i < appleColours.length; i++) {
			JButton b =new JButton();
			b.setBounds(buttonX,buttonY,60,60);
			b.setBackground(appleColours[i]);
			
			c.add(b);
			b.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	aCLr = b.getBackground();
	                
	            }
	        });
			
			buttonX += 70;
			
		}
		
		JLabel backColor =new JLabel("BACK COLOR");
		backColor.setBounds(6, 254, 120, 60);
		backColor.setFont(new Font("Arial", Font.BOLD, 16));
		backColor.setForeground(Color.BLACK);
		c.add(backColor);	
		
		buttonX  =130;
		buttonY  =254;
		
		for (int i = 0; i < backGround.length; i++) {
			JButton b =new JButton();
			b.setBounds(buttonX,buttonY,60,60);
			b.setBackground(backGround[i]);
			
			c.add(b);
			b.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	bColor = b.getBackground();
	                
	            }
	        });
			
			buttonX += 70;
			
		}
		
		
		JButton button5 =new JButton("BACK");
		button5.setBounds(330,360,100,50);
		button5.setBackground(Color.black);
		button5.setForeground(Color.WHITE);
		c.add(button5);
		button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame1.setVisible(false);
            	//Reset button coordinates
                buttonY = 6;
                buttonX = 130;
            }
        });


	}

}
