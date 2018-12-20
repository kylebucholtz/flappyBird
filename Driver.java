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

public class Driver extends JPanel implements ActionListener, KeyListener
		 {

	// properties of this class - the panel that shows up
		int screen_width = 1200; // width of the screen
		int screen_height = 900; // height of the screen

		String bg = "bg.png"; // set up for background
		JLabel background;
		String bgEnd = "FBGameOver.jpg"; // setup for ending background
		JLabel endBackground;

		JLabel label_start = new JLabel("Start");// setup for starting
		JLabel label_end = new JLabel("");// setup for ending

		JLabel label_space = new JLabel("Press Space to Jump"); // start info setups
		JLabel label_pick = new JLabel("Pick Your Bird to Start");

		Font tinyfont = new Font("Courier New", 1, 50);// small font
		Font font = new Font("Courier New", 1, 100);// medium font
		Font endFont = new Font("Courier New", 1, 200);// large font

		boolean classicBool = false; //boolean for the classic bird
		boolean blueBool = false; //boolean for the blue bird
		boolean greenBool = false;// boolean for the green bird
		boolean redBool = false; //boolean for the red bird
		boolean rainbowBool = false; //boolean for the rainbow bird
		boolean started = false;//boolean for when the game starts
		boolean active = false;//boolean for after active starts and runs throughout the game
		boolean dead = false;//boolean for when you die
		boolean scoreBool = false;//boolean to show the score
		boolean startScreen = true;//boolean to show the start screen

		Classic classic = new Classic("flappyBirdClassic.png"); //classic flappy bird
		Blue blue = new Blue("flappyBirdBlue.png"); //blue flappy bird
		Green green = new Green("flappyBirdGreen.png"); //green flappy bird
		Rainbow rainbow = new Rainbow("flappyBirdRainbow.png");//rainbow flappy bird
		Red red = new Red("flappyBirdRed.png");//red flappy bird

		JLabel label_score = new JLabel("Press Enter to Restart");//JLabel for the score
		int score = 0;//starts the score at 0

		One one = new One("#1.png");//image of 1 to choose bird
		Two two = new Two("#2.png");//image of 2 to choose bird
		Three three = new Three("#3.png");//image of 3 to choose bird
		Four four = new Four("#4.png");//image of 4 to choose bird
		Five five = new Five("#5.png");//image of 5 to choose bird

		BottomPipe[] bp = new BottomPipe[4];//initializing the array of 4 for the bottom pipe
		TopPipe[] tp = new TopPipe[4];//initializing the array of 4 for the top pipe

		// only do drawing for paint
		public void paint(Graphics g) {//paint method
			super.paintComponent(g);



		}// end of paint method - put code above for anything dealing with drawing -

		/* do not draw here */
		public void update() {//update method
			// use booleans to determine which collision is happening
			for (int i = 0; i < tp.length; i++) {//if the bird passes through the pipe it adds a point to the score
				if (classic.getX() >= tp[i].getX() && classic.getY() > tp[i].getY()
						&& !tp[i].counter && startScreen == false) {
					// collision
					label_score.setText(Integer.toString(score += 1));
					tp[i].counter = true;
				}
			}

			if (started == true) {//if the game has started
				for (int i = 0; i < tp.length; i++) {
				started = false;//turns off starter
				active = true;//turns on active
				tp[i].setX(777 + (i * 200 + i * 90));//paints top pipe
				bp[i].setX(777 + (i * 200 + i * 90));//paints bottom pipe
				label_space.setVisible(false);//hides starting images
				label_pick.setVisible(false);
				score = 0;//ensures score starts at zero
				label_score.setText(Integer.toString(score));

			}
		}
		for (int i = 0; i < tp.length; i++) {
			if (dead == false) {
				tp[i].move();//moves top pipe
			}
		}

		for (int i = 0; i < bp.length; i++) {
			if (dead == false) {
				bp[i].setX(bp[i].getX() - 5);//moves bottom pipe in reference to bottom 
				if (bp[i].getX() < 0) {
					bp[i].setX(1200);
					bp[i].setY(tp[i].getY() + 1100);
				}
			}
		}
		
		if (classicBool == true) {//sets all birds to same position
			classic.setY(450);
			blue.setY(450);
			green.setY(450);
			red.setY(450);
			rainbow.setY(450);
			classicBool = false;//turns off classicBool so that it only runs once
		}
		if (blueBool == true) {//sets all birds to same position if you chose to play as blue
			classic.setY(450);
			blue.setY(450);
			green.setY(450);
			red.setY(450);
			rainbow.setY(450);
			blueBool = false;//turns off blue bool
		}
		if (greenBool == true) {//sets all birds to same position if you chose to play as green
			classic.setY(450);
			blue.setY(450);
			green.setY(450);
			red.setY(450);
			rainbow.setY(450);
			greenBool = false;
		}
		if (redBool == true) {//sets all birds to same position if you chose to play as red
			classic.setY(450);
			blue.setY(450);
			green.setY(450);
			red.setY(450);
			rainbow.setY(450);
			redBool = false;
		}
		if (rainbowBool == true) {//sets all birds to same position if you chose to play as rainbow
			classic.setY(450);
			blue.setY(450);
			green.setY(450);
			red.setY(450);
			rainbow.setY(450);
			rainbowBool = false;
		}

		if (active == true && dead == false) {
			classic.setAY(1.3);//yellow gravity
			classic.setVy(classic.getVy() + classic.getAY());
			classic.move();

			blue.setAY(1.3);//blue gravity
			blue.setVy(blue.getVy() + blue.getAY());
			blue.move();

			green.setAY(1.3);//green gravity
			green.setVy(green.getVy() + green.getAY());
			green.move();

			red.setAY(1.3);//red gravity
			red.setVy(red.getVy() + red.getAY());
			red.move();

			rainbow.setAY(1.3);//rainbow gravity
			rainbow.setVy(rainbow.getVy() + rainbow.getAY());
			rainbow.move();
		}

		for (int i = 0; i < tp.length; i++) {//top pipe collision
			if (tp[i].getRect().intersects(classic.getRect()) && active == true) {
				// collision
				dead = true;
				active = false;
			}


		}
		for (int i = 0; i < bp.length; i++) {
			if (bp[i].getRect().intersects(classic.getRect()) && active) {//bottom pipe collision
				// collision
				dead = true;
				active = false;

			}
		}
		for (int i = 0; i < bp.length; i++) {//floor collision
			if (classic.getY() >= 900 && active) {
				// collision
				dead = true;
				active = false;

			}
		}

		if (dead == true) {//after collision
			background.setVisible(false);//hides background
			label_score.setBounds(575, 150, 400, 200);//moves Score
			label_score.setFont(endFont);//increases size of score
			label_end.setVisible(true);//shows end instructions
			endBackground.setVisible(true);//game over screen
			// label_instruct.setVisible(true);
		}
	}// end of update method - put code above for any updates on variable

	// ==================code above ===========================

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	public Driver() {

		JFrame f = new JFrame();
		f.setFont(font);

		f.setTitle("Flappy Bird");
		f.setSize(screen_width, screen_height);
		f.getContentPane().setBackground(Color.black);
		String src = new File("").getAbsolutePath() + "/src/"; // path to image
																// setup
		ImageIcon backg = new ImageIcon(src + bg); // setups icon image
		background = new JLabel(backg);
		background.setBounds(0, 0, 1200, 900); // set location and size of icon

		ImageIcon endBackg = new ImageIcon(src + bgEnd); // sets up ending background image
		endBackground = new JLabel(endBackg);
		endBackground.setBounds(0, 0, 1200, 900); // set location and size of
													// ending background

		label_start.setBounds(450, 100, 600, 600);//sets bounds for start
		label_start.setForeground(Color.BLACK);//sets start color to black
		label_start.setFont(font);//changes font for start
		f.add(label_start);//Shows Start

		label_space.setFont(tinyfont);//sets smaller font 
		label_space.setBounds(325, 425, 800, 400);//resets bounds
		label_space.setForeground(Color.BLACK);//sets color to black
		f.add(label_space);//adds space instructions

		label_pick.setFont(tinyfont);//sets pick instructions font 
		label_pick.setBounds(275, 325, 800, 400);//sets bounds for pick instructions
		label_pick.setForeground(Color.BLACK);//sets pick instructions to black
		f.add(label_pick);//adds picking instructions

		f.add(one.getImg());//adds #s by birds
		f.add(two.getImg());
		f.add(three.getImg());
		f.add(four.getImg());
		f.add(five.getImg());

		label_score.setFont(font); // sets score to a bigger font
		label_score.setBounds(575, 50, 200, 100);//sets bounds for score
		label_score.setForeground(Color.black);//makes score  black
		label_score.setText(Integer.toString(score));//sets up score
		f.add(label_score);//adds score
		
		
		
		label_end.setBounds(295, 475, 800, 400);//sets bounds for ending
		label_end.setForeground(Color.BLACK);//makes ending black
		label_end.setFont(tinyfont);//makes end font tiny
		f.add(label_end).setVisible(false);//adds end, but hides it
	
		f.add(endBackground).setVisible(false);//adds end background but hides it

		f.add(classic.getImg());//adds birds
		f.add(blue.getImg());
		f.add(green.getImg());
		f.add(rainbow.getImg());
		f.add(red.getImg());

		for (int i = 0; i < tp.length; i++) {// paints top pipe
			tp[i] = new TopPipe("flappyPipeTop.jpg");
			tp[i].setX(i * 200 + i * 90);
			f.add(tp[i].getImg());
		}

		for (int i = 0; i < bp.length; i++) {// paints bottom pipe
			bp[i] = new BottomPipe("flappyPipeBottom.jpg");
			bp[i].setX(i * 200 + i * 90);
			bp[i].setY(tp[i].getY() + 1100);
			f.add(bp[i].getImg());
		}

		f.add(background);//adds backgorund

		f.setResizable(false);
		f.setLayout(null);
		f.addKeyListener(this);
		
		// end creating objects
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 49 || e.getKeyCode() == 97 && dead == false) {// first
																			// flappy
			label_start.setVisible(false);//turns off start screes
			
			blue.getImg().setVisible(false);//hides all birds except classic
			green.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(false);
			classic.getImg().setVisible(true);
			
			startScreen = false;//turns off starting bool
			
			if (active == false && dead == false) {//if not running 
													//activate beggining booleans
				classicBool = true;
				started = true;
			}
			
			one.getImg().setVisible(false);//hide numbers
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);

		}
		if (e.getKeyCode() == 50 || e.getKeyCode() == 98 && dead == false) {// secondflappy
			label_start.setVisible(false);//turns off start screens
			
			classic.getImg().setVisible(false);//hides all birds except blue
			green.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(false);
			blue.getImg().setVisible(true);
			
			startScreen = false;//turns off starting bool
			
			if (active == false && dead == false) {//if not running 
													//activate beggining booleans
				blueBool = true;
				started = true;
			}
			one.getImg().setVisible(false);//hide numbers
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);

		}
		if (e.getKeyCode() == 51 || e.getKeyCode() == 99 && dead == false) {// third
																			// flappy
			label_start.setVisible(false);//turns off start screens
			
			classic.getImg().setVisible(false);//hides all birds except green
			blue.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			red.getImg().setVisible(false);
			green.getImg().setVisible(true);
			
			startScreen = false;//turns off starting bool
			
			if (active == false && dead == false) {//if not running 
													//activate beggining booleans
				greenBool = true;
				started = true;
			}
			one.getImg().setVisible(false);//hide numbers
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);
		}
		if (e.getKeyCode() == 52 || e.getKeyCode() == 100 && dead == false) {// fourth
																				// flappy
			label_start.setVisible(false);//turns off start screens
			
			classic.getImg().setVisible(false);//hides all birds except red
			blue.getImg().setVisible(false);
			rainbow.getImg().setVisible(false);
			green.getImg().setVisible(false);
			red.getImg().setVisible(true);
			
			startScreen = false;//turns off starting bool
			
			if (active == false && dead == false) {//if not running 
													//activate beggining booleans
				redBool = true;
				started = true;
			}
			one.getImg().setVisible(false);//hide numbers
			two.getImg().setVisible(false);
			three.getImg().setVisible(false);
			four.getImg().setVisible(false);
			five.getImg().setVisible(false);

		}
		if (e.getKeyCode() == 53 || e.getKeyCode() == 101 && dead == false) {// fifth
																				// flappy
			label_start.setVisible(false);//hides start screen
			
			rainbow.getImg().setVisible(true);//only rainbow showing
			classic.getImg().setVisible(false);
			blue.getImg().setVisible(false);
			green.getImg().setVisible(false);
			red.getImg().setVisible(false);
			
			startScreen = false;//turns off start screen bool
			
			if (active == false && dead == false) {//turns on starting bools
				rainbowBool = true;
				started = true;
			}
			
			one.getImg().setVisible(false);//hides #s
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
		if (e.getKeyCode() == 32 && active == true) { // spacebar
			classic.setVy(-14);//temp changes vy of the birds to move them up 
			blue.setVy(-14);
			red.setVy(-14);
			green.setVy(-14);
			rainbow.setVy(-14);

		}
		if (e.getKeyCode() == 10 && dead == true) {
			classic.setY(90);//resetting birds' ys
			blue.setY(180);
			green.setY(270);
			red.setY(360);
			rainbow.setY(450);
			
			classic.setVy(0);//resetting birds' velocities
			blue.setVy(0);
			green.setVy(0);
			red.setVy(0);
			rainbow.setVy(0);
			
			classic.getImg().setVisible(true);//showing all birds again
			blue.getImg().setVisible(true);
			red.getImg().setVisible(true);
			green.getImg().setVisible(true);
			rainbow.getImg().setVisible(true);
			
			dead = false;//resetting booleans
			startScreen = true;
			
			one.getImg().setVisible(true);//turning numbers back on
			two.getImg().setVisible(true);
			three.getImg().setVisible(true);
			four.getImg().setVisible(true);
			five.getImg().setVisible(true);
			
			score = 0;//Resetting score
			label_score.setText(Integer.toString(score));
			label_score.setBounds(575, 50, 200, 100);
			label_score.setFont(font);
			
			label_end.setVisible(false);//hiding end images
			endBackground.setVisible(false);
			
			label_space.setVisible(true);//showing starting images
			label_pick.setVisible(true);
			label_start.setVisible(true);
			background.setVisible(true);
			
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
