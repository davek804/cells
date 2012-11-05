package Projects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Graph extends JPanel implements MouseListener {
	int xSize;
	int ySize;
	ArrayList<Producer> list1;
	PlayPanel panel;
	double curX = 2.55;
	double curY = 2.94;
	
	public Graph(int x, int y, ArrayList<Producer> p, PlayPanel pan) {
		xSize = x; ySize =y;
		list1 = p;
		panel = pan;
		addMouseListener(this);
		setPreferredSize(new Dimension(xSize,ySize));
		setBackground(Color.black);
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int j = 0; j < list1.size(); j++) {
			g.setColor(Color.green);
			g.drawOval((int)(list1.get(j).getxAxis()), (int)(list1.get(j).getyAxis()/curY),1,1);
			if (curX!=2.55) {
				System.out.println("recorrect drawing");
			}
		}
	}
	public void resizePane(int x, MouseEvent e) {
		
		if (x == 0) {
			
		curX*=2;
		curY*=2;
		}
		if (x == 1) {
			int p = e.getX();
			int q = e.getY();
			curX/=2;
			curY/=2;
		}
	}
	public void mouseClicked(MouseEvent e) {
		int x;
		int y;
		x = e.getX();
		y = e.getY();
		System.out.println("Click @: " + x + " " + y);
		int clickX = e.getX();
		int clickY = e.getY();
		clickX*=2.55;
		clickY*=2.94;
		if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
			resizePane(1, e);
		}
		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			resizePane(0, e);
		}
		//System.out.println("These Coords on a 500x500 plane: " + clickX + " " + clickY);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("Click");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("Click");
		
	}
}
