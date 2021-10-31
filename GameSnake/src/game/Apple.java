package game;
import java.awt.Color;
import java.awt.Graphics;

public class Apple {
	
	private int xCoor,yCoor, width, height;
	
	public Apple(int xCoor,int yCoor, int titleSize) {
		this.xCoor=xCoor;
		this.yCoor=yCoor;
		width=titleSize;
		height=titleSize;
		
	}
	public void tick() {
		
	}
	public void draw(Graphics g,Color color) {
		g.setColor(color);//Body color is Yellow
		g.fillRect(xCoor* width, yCoor*height, width, height);// same as bodypart to set the location of an Apple
	}
	public int getxCoor() {
		return xCoor;
	}
	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}
	public int getyCoor() {
		return yCoor;
	}
	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
}