package game;
import java.awt.*;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Gamepanel extends JPanel implements Runnable , KeyListener {
	
	
	 
	
	public static final int WIDTH=500, HEIGHT=500;
	private Thread thread;
	private boolean running;
	
	private boolean right=true, left= false, up=false, down =false;
	//Step6:
	private BodyPart b;//make an object name b
	private ArrayList<BodyPart> snake;//we write Bodypart in constructor it mean now we can add any data type in it .Name of ArrayList is snake and there is no () so it mean length = 0
	private int xCoor=10, yCoor=10, size=35 , counter=size;//step7 go to tick()
	
	private Apple apple;
	private ArrayList<Apple> apples;
	
	private Random r;//for random location of an apple
	

	private int ticks = 0; //track time
	//Step 1:
	public Gamepanel()
	{
		setFocusable(true);//used to give focous to a component if required
		setPreferredSize(new Dimension(WIDTH,HEIGHT));//we used pack in main so we will use set prefferedsize to adjust the size of panel 
		//Step 2: After setting the size of panel i go to paint to set panel background 
		addKeyListener(this);
		
		snake =new ArrayList<BodyPart>();
		
		apples =new ArrayList<Apple>();
		
		r =new Random();
		
		start();
		
	}
	
	public void start()
	{
		running=true;// I made a boolean running variable under class 
		//this works as reference to the current object
		thread =new Thread(this);//when we implement runnable then we have to give name in constructor but we already defined a thread object so we will use this
		thread.start();//Step 4: Now it goes to run method because we started the thread
		
		
	}
	public void stop() 
	{
		JButton buttonA=new JButton("GAME OVER");
		buttonA.setBounds(170, 70, 150, 50);
		buttonA.setBackground(Color.black);
		buttonA.setForeground(Color.WHITE);
		this.add(buttonA);
		this.repaint();
		
		JButton buttonD=new JButton("SCORE:"+(snake.size()-counter));
		buttonD.setBounds(170, 170, 150, 50);
		buttonD.setBackground(Color.black);
		buttonD.setForeground(Color.WHITE);
		this.add(buttonD);
		this.repaint();
		
		JButton buttonB=new JButton("TRY AGAIN");
		buttonB.setBounds(170, 270, 150, 50);
		buttonB.setBackground(Color.black);
		buttonB.setForeground(Color.WHITE);
		this.add(buttonB);
		this.repaint();
		buttonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Main nw =new Main();
            	nw.main();
                
            }
        });
		
		JButton buttonC=new JButton("EXIT");
		buttonC.setBounds(170, 370, 150, 50);
		buttonC.setBackground(Color.black);
		buttonC.setForeground(Color.WHITE);
		this.add(buttonC);
		this.repaint();
		buttonC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
                
            }
        });
		
		
		running =false;
		try {
			thread.join();//it will let this thread to complete than go on next line, thread.start() does stop to terminate the start operation and move on to next line
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	public void tick() {//Step 5: first we will make Snake Body by making BodyPart class
		//Step 7:
		//this will only be called once
		if(snake.size()==0) {//Firstly snake.size()==0 
			b=new BodyPart(xCoor,yCoor,10);//b is a bodypart which is returned from BodyPart and we put it in ArrayList Constructor (BodyPart)
			
			//Step 8:
			snake.add(b); // Add body part to snake
			
		}
		
		//start counting seconds
		ticks++;
		//this determines the speed;
		if(ticks>380000) {
			if(right) xCoor++;//if we click right so x is increased by 1 and when it goes to BodyPart there x=xCoor*width and now xCoorr=2 and width=10 so x=20 so snake move 1 point toward right
			
			if(left) xCoor--;
			if(up) yCoor--;
			if(down) yCoor++;
			
			ticks=0;// Reset tick after one complete cycle
			
			b=new BodyPart(xCoor,yCoor,10);
			snake.add(b);
			
			if(snake.size()>size) {//when snake move to right so the arraylist size increase that original size of snake so we remove the 0 index of snake to the size of snake same but move it in x direction
				snake.remove(0);
			}
		}
		if(apples.size()==0) {
			int xCoor =r.nextInt(49);//we use 49 because ther are 50 boxes on x-axis and we start from 0 so we use 49
			int yCoor =r.nextInt(49);
			apple=new Apple(xCoor, yCoor, 10);//we send random x,y aned size of apple to apple class
			apples.add(apple);
		}
		
		for(int i =0 ;i<apples.size();i++) {
			if(xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()){// mean snake eat apple so that apple will be removed
				
				size++;
				apples.remove(i);
				i++;
			}
			
		}
		//collision with body
		for(int i = 0; i<snake.size(); i++) {
			if(xCoor== snake.get(i).getxCoor() && yCoor ==snake.get(i).getyCoor()) {
				if(i!= snake.size()-1) {
					System.out.println("Game over");
					stop();
				}
			}
			
		}
		//Emerge from border
		if(xCoor < 0) {
			xCoor = 49;
		}
		if(xCoor > 49) {
			xCoor = 0;
		}
		if(yCoor < 0) {
			yCoor = 49;
		}
		if(yCoor > 49) {
			yCoor = 0;
		}
		
		
	}
	public void paint(Graphics g) 
	{
		g.clearRect(0,0,WIDTH,HEIGHT);//This is done to remove any past color from panel if present
		
		
		g.setColor(CMenu.bColor);//We made the color of panel black to hide Line
		
		g.fillRect(0, 0, WIDTH,HEIGHT);
		//I divide panel into 50 rows and 50 columns
		
		for(int i=0; i<WIDTH/10;i++) 
		{
			g.drawLine(i*10, 0, i*10, HEIGHT);//Line goes from (x1,y1) to (x2,y2) g.drawLine(x1,y1,x2,y2) this is for column
		}
		
		for(int i=0; i<HEIGHT/10;i++) 
		{
			g.drawLine(0, i*10, WIDTH,i*10);//This is for Rows
		}
		//Step3: After this to go to start and stop  
		for(int i=0; i<snake.size();i++) {//to draw snake on panel we are drawing snake so we use snake.get().draw() the size of it =5 at start because we defined size =5 at above
			//This will retuurn a bodypart
		
			snake.get(i).draw(g,CMenu.sCLr);//The draw method gets called
		}
		for(int i=0; i<apples.size();i++) {//to draw apple on panel
			
			apples.get(i).draw(g,CMenu.aCLr);
		}
	}

	
	public void run() {
		while(running) {
			tick();
			repaint();//again go at paint
			
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();//return the key code mean the ascii value of the key pressed
		if(key==KeyEvent.VK_RIGHT && !left) {// if user pressed right and snake was not going in left direction so it will turn towards right
			right=true;
			up=false;
			down=false;
		}
		if(key==KeyEvent.VK_LEFT && !right) {
			left=true;
			up=false;
			down=false;
		}
		if(key==KeyEvent.VK_UP && !down) {
			up=true;
			left=false;
			right=false;
		}
		if(key==KeyEvent.VK_DOWN && !up) {
			down=true;
			left=false;
			right=false;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
