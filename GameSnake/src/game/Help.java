package game;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class Help {
	public static void main1() {
		JFrame frame1 =new JFrame();
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(510,140,715,475);
		frame1.setLayout(null);
		ImageIcon image1 =new ImageIcon("D:\\java program only\\snakeimage.png");
		frame1.setIconImage(image1.getImage());
		
		ImageIcon image =new ImageIcon("D:\\java program only\\snakegame.png");
		
		JLabel label =new JLabel(image);
		label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		
		Container c =frame1.getContentPane();
		c.setLayout(null);
		
			JButton label1 =new JButton("MOVE UP");
		label1.setBounds(150,40,130,30);
		label1.setBackground(Color.black);
		label1.setForeground(Color.WHITE);
		
		JButton label2 =new JButton("MOVE DOWN");
		label2.setBounds(150,100,130,30);
		label2.setBackground(Color.black);
		label2.setForeground(Color.WHITE);
		
		JButton label3 =new JButton("MOVE LEFT");
		label3.setBounds(150,160,130,30);
		label3.setBackground(Color.black);
		label3.setForeground(Color.WHITE);
		
		JButton label4 =new JButton("MOVE RIGHT");
		label4.setBounds(150,220,130,30);
		label4.setBackground(Color.black);
		label4.setForeground(Color.WHITE);
		
		
		JButton button1 =new JButton("↑");
		button1.setBounds(470,40,100,30);
		button1.setBackground(Color.black);
		button1.setForeground(Color.WHITE);
		
		JButton button2 =new JButton("↓");
		button2.setBounds(470,100,100,30);
		button2.setBackground(Color.black);
		button2.setForeground(Color.WHITE);
		
		JButton button3 =new JButton("←");
		button3.setBounds(470,160,100,30);
		button3.setBackground(Color.black);
		button3.setForeground(Color.WHITE);
		
		JButton button4 =new JButton("→");
		button4.setBounds(470,220,100,30);
		button4.setBackground(Color.black);
		button4.setForeground(Color.WHITE);
		
		JButton button5 =new JButton("BACK");
		button5.setBounds(330,280,100,50);
		button5.setBackground(Color.black);
		button5.setForeground(Color.WHITE);
		button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame1.setVisible(false);
                
            }
        });
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		c.add(button5);
		c.add(label1);
		c.add(label2);
		c.add(label3);
		c.add(label4);
		c.add(button1);
		c.add(button2);
		
		c.add(button3);
		c.add(button4);
		c.add(label);
		frame1.repaint();

}}
