import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Blue {
		//fields for a Frogger object
		private int x,y; //location of the object
		private int w,h; //width and height of the object
		private double vy; // vel in y component
		private double AY; //accel in y
		private JLabel img; //holds image for object
		
		//constructor that takes in the Filename
		public Blue(String filename) {
			//setup file
			String src = new File("").getAbsolutePath()+"/src/";
			ImageIcon ClassicIcon = new ImageIcon(src+filename);
			//connect the file to the img
			img = new JLabel(ClassicIcon);

			w = 76; //width
			h = 56; //height
			vy= 0;//y velocity
			x = 30;//starting x
			y = 180;//starting y
			
			//locate image based on x,y,w,h
			img.setBounds(x, y, w, h);
			
		
		}

		public void move(){//move method
			
			y+=vy;//y increments by vy
			img.setBounds(x, y, w, h);
		}
		
		public int getX(){
			return x; //getter for object's x field
			
		}
		
		public JLabel getImg(){
			return img; //getter for object's img
		}
		
		public void setImg(JLabel newImg){
			img = newImg;
		}
		//add the rest of your getters

		public int getY(){
			return y;
		}
		
		public int getW(){
			return x;
		}
		
		public int getH(){
			return h;
		}
		
		public double getVy(){
			return vy;
		}
		
		public double getAY(){
			return AY;
		}
		
		public void setVy(double newVY){
			vy = newVY;
		}
	
		public void setAY(double d){
			AY = d;
		}
		public void setX(int newX){
			x = newX; //assign this object's y with a new value passed in
		}
		
		public void setY(int newY){
			y = newY; //assign this object's y with a new value passed in
			img.setBounds(x,y,w,h);
		}}