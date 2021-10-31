package game;
import javax.swing.*;

public class Main {
	public static void main() {
		JFrame frame=new JFrame();
		Gamepanel gamepanel = new Gamepanel(); // Construct new game panel
		ImageIcon image1 =new ImageIcon("D:\\java program only\\snakeimage.png");
		frame.setIconImage(image1.getImage());
		
		frame.add(gamepanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.pack();//Frame will set according to panel
		frame.setVisible(true);
		
		frame.setLocationRelativeTo(null);//now it will be in center
		
		frame.repaint();


	}

}
