import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
	
	//properties of this class - the panel that shows up
	int screen_width 	= 1200;
	int screen_height 	= 900;
	int max_vals = 200;
	int size = 30;
	int g = 0;
	String bg = "bg.png";
	JLabel background;
	String bgEnd = "FBGameOver.jpg";
	JLabel endBackground;
	JLabel label_start = new JLabel("Start");
	JLabel label_lose = new JLabel("Game Over!");
	JLabel label_end = new JLabel("");
	JLabel label_space = new JLabel("Press Space to Jump");
	JLabel label_pick = new JLabel("Pick Your Bird to Start");
	
	Font tinyfont = new Font ("Courier New", 1, 50);
	Font font = new Font ("Courier New", 1, 100);
	Font endFont = new Font ("Courier New", 1, 200);

	boolean classicBool = false;
	boolean blueBool = false;
	boolean greenBool = false;
	boolean redBool = false;
	boolean rainbowBool = false;
	boolean started = false;
	boolean active = false;
	boolean dead = false;
	boolean scoreBool = false;
	boolean startScreen = true;
	
	Classic classic = new Classic("flappyBirdClassic.png");
	Blue blue = new Blue("flappyBirdBlue.png");
	Green green = new Green("flappyBirdGreen.png");
	Rainbow rainbow = new Rainbow("flappyBirdRainbow.png");
	Red red = new Red("flappyBirdRed.png");
	
	JLabel label_score = new JLabel("");
	int score = 0;
	
	
	One one = new One("#1.png");
	Two two = new Two("#2.png");
	Three three = new Three("#3.png");
	Four four = new Four("#4.png");
	Five five = new Five("#5.png");
	
	
	BottomPipe[] bp = new BottomPipe[4];
	TopPipe[] tp = new TopPipe[4];

	//1) Declare an array of Square objects here
	
	//2) declare an array of Circle objects here
	
	//3) Declare the game character here
	

	//only do drawing for paint
	public void paint(Graphics g) {
		super.paintComponent(g);

		g.setFont(font);

		
	
		
		
	}//end of paint method - put code above for anything dealing with drawing -
	
	
	

	
	/* do not draw here */
	public void update() {
		//use booleans to determine which collision is happening
		for(int i=0; i<tp.length; i++){
			if(classic.getX()>=tp[i].getX()&& classic.getY()>tp[i].getY()&&!tp[i].counter && startScreen == false){
				//collision
				label_score.setText(Integer.toString(score+=1));
				tp[i].counter=true;//
			
			}
		}
		
		if(started == true){
			for(int i=0; i <tp.length; i++){
				started = false;
				active = true;
				tp[i].setX(777+(i*200+i*90));
				bp[i].setX(777+(i*200+i*90));
				label_space.setVisible(false);
				label_pick.setVisible(false);
				
		}
		}
		for(int i=0; i <tp.length; i++){
			if(dead==false){
				tp[i].move();
			}
		}
		
		for(int i=0; i<bp.length; i++){
			 if(dead==false){
				 bp[i].setX(bp[i].getX()-5);
			 if(bp[i].getX()<0){
					 bp[i].setX(1200);
						bp[i].setY(tp[i].getY()+1100);
			 }
			 }
			 } 	
				//img.setBounds(x, y , w, h);
			if(classicBool==true){
				classic.setY(450);
				blue.setY(450);
				green.setY(450);
				red.setY(450);
				rainbow.setY(450);
				classicBool=false;
			}
			if(blueBool==true){
				classic.setY(450);
				blue.setY(450);
				green.setY(450);
				red.setY(450);
				rainbow.setY(450);
				blueBool=false;
			}
			if(greenBool==true){
				classic.setY(450);
				blue.setY(450);
				green.setY(450);
				red.setY(450);
				rainbow.setY(450);
				greenBool=false;
			}
			if(redBool==true){
				classic.setY(450);
				blue.setY(450);
				green.setY(450);
				red.setY(450);
				rainbow.setY(450);
				redBool=false;
			}if(rainbowBool==true){
				classic.setY(450);
				blue.setY(450);
				green.setY(450);
				red.setY(450);
				rainbow.setY(450);
				rainbowBool=false;
			}
			
			
			
			 if(active==true&&dead==false){
				 classic.setAY(1.3);
				 classic.setVy(classic.getVy()+classic.getAY() );
				 classic.move();
				 
				 blue.setAY(1.3);
				 blue.setVy(blue.getVy()+blue.getAY() );
				 blue.move();
				 
				 green.setAY(1.3);
				 green.setVy(green.getVy()+green.getAY() );
				 green.move();
				 
				 red.setAY(1.3);
				 red.setVy(red.getVy()+red.getAY() );
				 red.move();
				 
				 rainbow.setAY(1.3);
				 rainbow.setVy(rainbow.getVy()+rainbow.getAY() );
				 rainbow.move();
			 } 
				 
				for(int i=0; i<tp.length; i++){
					if(tp[i].getRect().intersects(classic.getRect()) && active == true){
						//collision
						dead = true;
						active = false;
					}
						
						//lifeCount--;
						
					}
					for(int i=0; i<bp.length; i++){
						if(bp[i].getRect().intersects(classic.getRect()) && active){
								//collision
							dead = true;
							active = false;
							
							}
					}
					for(int i=0; i<bp.length; i++){
						if(classic.getY() >= 900 && active){
								//collision
							dead = true;
							active = false;
							
							}
					}
					
					if(dead == true){
						background.setVisible(false);
						label_score.setForeground(Color.BLACK);
						label_score.setBounds(575, 200, 400, 200);
						label_score.setFont(endFont);
						label_end.setVisible(true);
						label_end.setForeground(Color.BLACK);
						label_end.setBounds(325, 425, 800, 400);
						label_end.setFont(tinyfont);
						endBackground.setVisible(true);
						//label_instruct.setVisible(true);
					}
			 
				
					
				
		//loop through each object in Squares
		//call their collision detection

	//do something that like so if it goes past left edge return it w random y

		
		//loop through each object in Circles
		//call their collision detection
		
		
	}//end of update method - put code above for any updates on variable
		
	
	//==================code above ===========================
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}
	
	public static void main(String[] arg) {
		Driver d = new Driver();
	}
	public Driver(){
		
		JFrame f = new JFrame();
		f.setFont(font);

		f.setTitle("Flappy Bird");
		f.setSize(screen_width, screen_height);
		f.getContentPane().setBackground(Color.black);
		String src = new File("").getAbsolutePath()+"/src/"; //path to image setup
		ImageIcon backg = new ImageIcon(src+bg);    //setups icon image
		background = new JLabel(backg);
		background.setBounds(0,0, 1200,900); //set location and size of icon
		
		
		ImageIcon endBackg = new ImageIcon(src+bgEnd);    //setups icon image
		endBackground = new JLabel(endBackg);
		endBackground.setBounds(0,0, 1200,900); //set location and size of icon

	//set up start
		
		label_start.setBounds(450, 100, 600, 600);
		label_start.setForeground(Color.BLACK);
		//update text
		label_start.setFont(font);
		f.add(label_start).setVisible(true);
//		
		
		label_space.setFont(tinyfont);
		label_space.setBounds(325, 425, 800, 400);
		label_space.setForeground(Color.BLACK);
		f.add(label_space).setVisible(true);
		
		label_pick.setFont(tinyfont);
		label_pick.setBounds(275, 325, 800, 400);
		label_pick.setForeground(Color.BLACK);
		f.add(label_pick).setVisible(true);
		
		
		
//		label_lose.setBounds(350, 200, 600, 600);
//		label_lose.setForeground(Color.WHITE);
//		//update text
//		label_lose.setFont(font);
//		f.add(label_lose).setVisible(false);
		
		
		f.add(classic.getImg());
		f.add(blue.getImg());
		f.add(green.getImg());
		f.add(rainbow.getImg());
		f.add(red.getImg());

		f.add(one.getImg());
		f.add(two.getImg());
		f.add(three.getImg());
		f.add(four.getImg());
		f.add(five.getImg());
		
		
		
		label_score.setFont(font); // if you want bigger font
		label_score.setBounds(575, 50, 200, 100);
		label_score.setForeground(Color.black);
		
		label_end.setBounds(575, 500, 200, 200);
		label_end.setForeground(Color.WHITE);
		label_end.setFont(font);
		label_end.setText("Press Enter to Restart");
		f.add(label_end).setVisible(false);
		// update text
		
		
		label_score.setText(Integer.toString(score));
		f.add(label_score);

		
		f.add(endBackground);
		endBackground.setVisible(false);
		
		
		for(int i = 0; i<tp.length; i++){
	tp[i] = new TopPipe("flappyPipeTop.jpg");
		tp[i].setX(i*200+i*90);
			f.add(tp[i].getImg());//paints top pipe
		}
		
		for(int i = 0; i<bp.length; i++){
			bp[i] = new BottomPipe("flappyPipeBottom.jpg");
				bp[i].setX(i*200+i*90);
				bp[i].setY(tp[i].getY()+1100);
					f.add(bp[i].getImg());//paints bottom pipe
				}
		
		
		
		
		f.add(background);
		
		f.setResizable(false);
		f.setLayout(null);
		f.addKeyListener(this);
		f.addMouseMotionListener(this);
		

		
		
		
		
		//end creating objects
		t = new Timer(17,this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==49||e.getKeyCode()==97&&dead==false){//first flappy
			label_start.setVisible(false);
			blue.getImg().setVisible(false);
			green.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(false);
			classic.getImg().setVisible(true);
			startScreen = false;
			if(active==false&&dead==false){
				classicBool=true;
				started = true;
			}
			one.getImg().setVisible(false);
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
			
		}
		if(e.getKeyCode()==50||e.getKeyCode()==98&&dead==false){//secondflappy
			label_start.setVisible(false);
			classic.getImg().setVisible(false);
			green.getImg().setVisible(false);   
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(false);
			blue.getImg().setVisible(true);
			startScreen = false;
			if(active==false&&dead==false){
			blueBool=true;
			started = true;
			}
			one.getImg().setVisible(false);
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
		
		}
		if(e.getKeyCode()==51||e.getKeyCode()==99&&dead==false){//third flappy
			label_start.setVisible(false);
			classic.getImg().setVisible(false);
			blue.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(false);
			green.getImg().setVisible(true);
			startScreen = false;
			if(active==false&&dead==false){
			greenBool=true;
			started = true;
			}
			one.getImg().setVisible(false);
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
		
		}
		if(e.getKeyCode()==52||e.getKeyCode()==100&&dead==false){//fourth flappy
			label_start.setVisible(false);
			classic.getImg().setVisible(false);
			blue.getImg().setVisible(false);
			green.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(true);
			startScreen = false;
			if(active==false&&dead ==false){
			redBool=true;
			started = true;
			}
			one.getImg().setVisible(false);
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
			
		}
		if(e.getKeyCode()==53||e.getKeyCode()==101&&dead==false){//fifth flappy
			label_start.setVisible(false);
			classic.getImg().setVisible(false);
			blue.getImg().setVisible(false);
			green.getImg().setVisible(false);
			red.getImg().setVisible(false);
			rainbow.getImg().setVisible(true);
			startScreen = false;
			if(active==false&&dead==false){
			rainbowBool=true;
			started = true;
			}
			one.getImg().setVisible(false);
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
			
		}
		
	
		update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==32&&active == true){ //spacebar
			classic.setVy(-14);
			blue.setVy(-14);
			red.setVy(-14);
			green.setVy(-14);
			rainbow.setVy(-14);
			
		}
		if(e.getKeyCode()==10&&dead==true){
			classic.setY(90);
			blue.setY(180);
			green.setY(270);
			red.setY(360);
			rainbow.setY(450);
			classic.getImg().setVisible(true);
			blue.getImg().setVisible(true);
			red.getImg().setVisible(true);
			green.getImg().setVisible(true);
			rainbow.getImg().setVisible(true);
			label_start.setVisible(true);
			background.setVisible(true);
			dead=false;
			active=false;
			//label_lose.setVisible(false);
			one.getImg().setVisible(true);
			two.getImg().setVisible(true);
			three.getImg().setVisible(true);
			four.getImg().setVisible(true);
			five.getImg().setVisible(true);
			startScreen = true;
			label_score.setForeground(Color.BLACK);
			score=0;
			classic.setVy(0);
			blue.setVy(0);
			green.setVy(0);
			red.setVy(0);
			rainbow.setVy(0);
			label_score.setText(Integer.toString(score));
			label_score.setBounds(575, 50, 200, 100);
			label_score.setFont(font);
			label_end.setVisible(false);
			label_space.setVisible(true);
			label_pick.setVisible(true);
			endBackground.setVisible(false);
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println(e.getX());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
 
	public void reset(){
	
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}


