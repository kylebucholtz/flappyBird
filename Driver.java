import java.applet.Applet;
import java.awt.Color;
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
	JLabel label_start = new JLabel("Start");
	Font font = new Font ("Courier New", 1, 100);

	boolean classicBool = false;
	boolean blueBool = false;
	boolean greenBool = false;
	boolean redBool = false;
	boolean rainbowBool = false;
	boolean started = false;

	
	Classic classic = new Classic("flappyBirdClassic.png");
	Blue blue = new Blue("flappyBirdBlue.png");
	Green green = new Green("flappyBirdGreen.png");
	Rainbow rainbow = new Rainbow("flappyBirdRainbow.png");
	Red red = new Red("flappyBirdRed.png");
	
	
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
		for(int i=0; i <tp.length; i++){
			tp[i].move();
		}
		for(int i=0; i<bp.length; i++){
			 bp[i].setX(bp[i].getX()-5);
			 if(bp[i].getX()<0){
					 bp[i].setX(1200);
						bp[i].setY(tp[i].getY()+1100);
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
	
			if(started == true){//when start button is clicked
				 classic.setAY(1);
				 classic.setVy(classic.getVy()+classic.getAY());
				 classic.move();
			 }
			
		}

		
		//loop through each object in Squares
		//call their collision detection

	//do something that like so if it goes past left edge return it w random y

		
		//loop through each object in Circles
		//call their collision detection
		
		
	//end of update method - put code above for any updates on variable
		
	
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
		

	//set up start
		
		label_start.setBounds(450, 100, 600, 600);
		label_start.setForeground(Color.BLACK);
		//update text
		label_start.setFont(font);
		f.add(label_start).setVisible(true);
//		
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
		if(e.getKeyCode()==49||e.getKeyCode()==97){//first flappy
			label_start.setVisible(false);
			blue.getImg().setVisible(false);
			green.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(false);
			classic.getImg().setVisible(true);
			classicBool=true;
			one.getImg().setVisible(false);
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
			started = true;
		}
		if(e.getKeyCode()==50||e.getKeyCode()==98){//secondflappy
			label_start.setVisible(false);
			classic.getImg().setVisible(false);
			green.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(false);
			blue.getImg().setVisible(true);
			blueBool=true;
			one.getImg().setVisible(false);
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
		}
		if(e.getKeyCode()==51||e.getKeyCode()==99){//third flappy
			label_start.setVisible(false);
			classic.getImg().setVisible(false);
			blue.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(false);
			green.getImg().setVisible(true);
			greenBool=true;
			one.getImg().setVisible(false);
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
		}
		if(e.getKeyCode()==52||e.getKeyCode()==100){//fourth flappy
			label_start.setVisible(false);
			classic.getImg().setVisible(false);
			blue.getImg().setVisible(false);
			green.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(true);
			redBool=true;
			one.getImg().setVisible(false);
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
		}
		if(e.getKeyCode()==53||e.getKeyCode()==101){//fifth flappy
			label_start.setVisible(false);
			classic.getImg().setVisible(false);
			blue.getImg().setVisible(false);
			green.getImg().setVisible(false);
			red.getImg().setVisible(false);
			rainbow.getImg().setVisible(true);
			rainbowBool=true;
			one.getImg().setVisible(false);
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
		}
		if(e.getKeyCode()==38){ //38 is up

		}
	
		update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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

