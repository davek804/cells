package Projects;

import java.awt.*;
//Graphics is using awt.
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class PlayPanel extends JPanel implements ActionListener, MouseListener, Runnable {

	private int XSize;
	private int YSize;
	protected String curEntry = "";
	protected JButton onoff;
	public InterfaceTab leftTab;
	private static final int RATE = 40;
	public Timer timer = new Timer(1000/RATE, this);
	public boolean consumerSeed = false;
	public Life life = new Life();
	public boolean producerPaint = false;
	public boolean herbivorePaint = false;
	public boolean predatorPaint = false;
	public boolean decomposerPaint = false;
	public int j = 0;
	public RightTab rightTab;


	public PlayPanel(int xVal, int yVal) {
		XSize = xVal;
		YSize = yVal;
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(XSize, YSize));
		setBackground(new Color(0,0,0));
		setBorder(new LineBorder(Color.BLACK));
		timer.setInitialDelay(200);
		setLnF();
		addMouseListener(this);
	}
	private void setLnF() {
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} 
		catch (UnsupportedLookAndFeelException e) {}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
	}
//Used to be known as populate(). Starts the on screen drawing. Is activated in InterfaceTab's triggerGo listener.
		public void populate() {
		leftTab.triggerGo.setEnabled(true);
		life.setPanel(this);
		life.producers();
		life.herbivores();
		life.predators();
		life.decomposers();
		//repaint();
	}
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			life.beginAction();
			leftTab.activeProdLabel.setText("Producers: " + Integer.toString(life.prodStore.size()));
			leftTab.activeHerbLabel.setText("Herbivores: " + Integer.toString(life.herbStore.size()));
			leftTab.activePredLabel.setText("Predators: " + Integer.toString(life.predStore.size()));
			leftTab.activeDecoLabel.setText("Decomposers: " + Integer.toString(life.decoStore.size()));
			leftTab.g1.repaint();
		}
	}
	protected void clean() {
		life.prodStore.clear();
		life.herbStore.clear();
		life.predStore.clear();
		life.decoStore.clear();
		repaint();
		leftTab.labelContainer.setVisible(false);
		//leftTab.repaint();
		leftTab.triggerGo.setEnabled(false);
		
		timer.stop();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(producerPaint == true) {
			//int j = 0;
			
			while(j < life.prodStore.size()) {
				g.setColor(new Color(19,145,14));
				g.fillOval(life.prodStore.get(j).getxAxis(), life.prodStore.get(j).getyAxis(), life.prodStore.get(j).getxSize(), life.prodStore.get(j).getySize());
				j++;
			}
			j=0;
		}
		if(herbivorePaint == true) {
			//int j = 0;
			
			while(j < life.herbStore.size()) {
				g.setColor(new Color(228,226,158));
				g.fillOval(life.herbStore.get(j).getxAxis(), life.herbStore.get(j).getyAxis(), life.herbStore.get(j).getxSize(), life.herbStore.get(j).getySize());
				j++;
			}
			j=0;
		}
		if(predatorPaint == true) {
			//int j = 0;
			
			while(j < life.predStore.size()) {
				g.setColor(new Color(207,87,87));
				g.fillOval(life.predStore.get(j).getxAxis(), life.predStore.get(j).getyAxis(), life.predStore.get(j).getxSize(), life.predStore.get(j).getySize());
				j++;
			}
			j=0;
		}
		if(decomposerPaint == true) {
			//int j = 0;
			
			while(j < life.decoStore.size()) {
				g.setColor(Color.white);
				g.fillOval(life.decoStore.get(j).getxAxis(), life.decoStore.get(j).getyAxis(), life.decoStore.get(j).getxSize(), life.decoStore.get(j).getySize());
				j++;
			}
			j=0;
		}
	}
	public void sendTab(InterfaceTab leftTab2) {
		leftTab = leftTab2;	
	}
	public void sendTab(RightTab rightTabs) {
		rightTab = rightTabs;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println(e.getX() + " " + e.getY());
		rightTab.checkXY(e, life);
		
		//life.check(e.getX(), e.getY());
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			System.out.println("right click");
			rightTab.removeBoxes();
		}
		if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
			System.out.println("Left click");
			}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {

		
	}
	@Override
	public void run() {
		populate();
		repaint();
		
		
	}
}

