import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class  Red{
		//fields for a Frogger object
		private int x,y; //location of the object
		private int w,h; //width and height of the object
		private int vx, vy; //constant vel in x and y component
		private JLabel img; //holds image for object
		
		
		//constructor that takes in the Filename
		public Red(String filename) {
			//setup file
			String src = new File("").getAbsolutePath()+"/src/";
			ImageIcon ClassicIcon = new ImageIcon(src+filename);
			//connect the file to the img
			img = new JLabel(ClassicIcon);
			
			//set location of frog
			// frog is 20 wide and 20 high
			w = 76; //width
			h = 56; //height
			
			x = 30;
			y = 360;
			
			//locate image based on x,y,w,h
			img.setBounds(x, y, w, h);
			
		
		}

		public void move(){
			x+=vx;
			y+=vy;
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
		
		public int getVx(){
			return vx;
		}
		
		public int getVy(){
			return vy;
		}
		
		public void setVx(int newVX){
			vx = newVX;
		}
		
		public void setVy(int newVY){
			vy = newVY;
		}
		
		public void setX(int newX){
			x = newX; //assign this object's y with a new value passed in
		}
		
		public void setY(int newY){
			y = newY; //assign this object's y with a new value passed in
			img.setBounds(x,y,w,h);
		}
		
		
		
}

