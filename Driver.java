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

	
	
	Classic classic = new Classic("flappyBirdClassic.png");
	Blue blue = new Blue("flappyBirdBlue.png");
	Green green = new Green("flappyBirdGreen.png");
	Rainbow rainbow = new Rainbow("flappyBirdRainbow.png");
	Red red = new Red("flappyBirdRed.png");
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
				//img.setBounds(x, y , w, h);

			
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


