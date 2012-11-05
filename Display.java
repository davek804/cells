package Projects;

import java.awt.*;
import javax.swing.*;

public class Display  extends JFrame {
	
	private Container c;
	private int x;
	private int y;
	
	public Display() {
		super("Generic App Window");
		c = this.getContentPane();	
		setPreferredSize(new Dimension(800,600));
		showFrame();
		
	}
	
	public Display(int x, int y) {
		super("2nd");
		this.x = y;
		this.y = y;
		setPreferredSize(new Dimension(x,y));
		addLabel();
		DaveMenu menu = new DaveMenu();
		add(menu);
		showFrame();
	}
	
	public void showFrame(){
		this.setLocation(350,50);
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }
	
	public void addLabel() {
		JLabel label = new JLabel("hello");
		add(label);
	}

	
	public static void main(String args []) {

		Display d2 = new Display(500,300);
		d2 = new Display();
		
	}

}
