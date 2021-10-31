package game;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Start {
	
	
	
	
	public static void main(String[]Args) {
		JFrame frame =new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(510,140,715,475);
		frame.setLayout(null);
		ImageIcon image1 =new ImageIcon("D:\\java program only\\snakeimage.png");
		frame.setIconImage(image1.getImage());
		
		ImageIcon image =new ImageIcon("D:\\java program only\\snakegame.png");
		
		JLabel label =new JLabel(image);
		label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		
		Container c =frame.getContentPane();
		c.setLayout(null);
		
		JButton button1 =new JButton("PLAY");
		button1.setBounds(290, 70, 100, 50);
		button1.setBackground(Color.black);
		button1.setForeground(Color.WHITE);
		c.add(button1);
		
		JButton button2 =new JButton("HELP");
		button2.setBounds(290, 170, 100, 50);
		button2.setBackground(Color.black);
		button2.setForeground(Color.WHITE);
		c.add(button2);
		
		JButton button3 =new JButton("COLORS");
		button3.setBounds(290, 270, 100, 50);
		button3.setBackground(Color.black);
		button3.setForeground(Color.WHITE);
		c.add(button3);
		
		c.add(label);
		button1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Main nw =new Main();
	            	nw.main();
	                
	            }
	        });
		frame.repaint();
		button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Help hp =new Help();
            	hp.main1();
                
            }
        });
		button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CMenu cm =new CMenu();
            	cm.main();
                
            }
        });
		frame.repaint();
	}

}
