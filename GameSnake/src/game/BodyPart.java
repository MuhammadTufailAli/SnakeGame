package game;
import java.awt.Color;
import java.awt.Graphics;
//Step 6: Before doing anything we made BodyPart,ArrayList,xCoor,yCoor,size variable in Gamepanel
//step 8:
public class BodyPart {
	private int xCoor,yCoor, width, height;// we defined variables to store values 
	//Constructor
	public BodyPart(int xCoor,int yCoor, int titleSize) {//we sent 3 values from Game panel which will store in these variables
		this.xCoor=xCoor;//this mean BodyPart xCoor which mean distance from x-axis we used this because variable we defined when the value comes from Gamepanel names are same so we use this   
		this.yCoor=yCoor;//this mean BodyPart yCoor which mean distance from y-axis 
		width=titleSize;
		height=titleSize;
		
	}
	public void tick() {
		
	}
	public void draw(Graphics g,Color color) {
		g.setColor(color);//Body color is Yellow
		g.fillRect(xCoor*width, yCoor*height, width, height);//xCoor*width mean it is that much distant from x-axis same for yCoor*height,width=10 mean the color will cover 1 box because we made 50 column and rows of size 10 	
	}
	public int getxCoor() { //getter
		return xCoor;
	}
	public void setxCoor(int xCoor) { //setter
		this.xCoor = xCoor;
	}
	public int getyCoor() {
		return yCoor;
	}
	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
	

}
