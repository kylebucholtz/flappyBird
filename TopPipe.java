
	import java.awt.Rectangle;
import java.io.File;

	import javax.swing.ImageIcon;
import javax.swing.JLabel;
	
public class TopPipe {
		//fields for a Frogger object
		private int x,y; //location of the object
		private int w,h; //width and height of the object
		private int vx, vy; //constant vel in x and y component
		private JLabel img; //holds image for object
		boolean counter = false;
		
		//constructor that takes in the Filename
		public TopPipe(String filename) {
			//setup file
			String src = new File("").getAbsolutePath()+"/src/";
			ImageIcon bottomPipe = new ImageIcon(src+filename);
			//connect the file to the img
			img = new JLabel(bottomPipe);
			
			//set location of frog
			// frog is 20 wide and 20 high
			w = 80; //width
			h = 906; //height
			
			x = 350;
			y =  (int)(Math.random()*(-300)-400);
			
			//locate image based on x,y,w,h
			img.setBounds(x, y, w, h);
			
		
		}
		
		public int getX(){
			return x; //getter for object's x field
			
		}
		
		public JLabel getImg(){
			return img; //getter for object's img
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
			//object object's image
			img.setBounds(x,y,w,h);
			
		}
		
		
		public void setH(int newH){
			h = newH; //assign this object's y with a new value passed in
			//object object's image
			img.setBounds(x,y,w,h);
			
		}
		public void setY(int newY){
			y = newY; //assign this object's y with a new value passed in
		}
		
		public void move(){
			x-=5; //move to the right
			
			//check if x passes right side of screen
			if(x<0){
				x=1200;
				y = (int)(Math.random()*(-300)-400);
				counter  = false;
			}
			img.setBounds(x, y , w, h);
		}

		public Rectangle getRect() {
			Rectangle tp = new Rectangle(x, y, w, h);
			return tp;
			// TODO Auto-generated method stub
			
			
		}
		
		
		
}


