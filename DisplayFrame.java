package Projects;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
/**
 *  A class that puts a graphics window on your display
*/


public  class DisplayFrame extends JFrame implements  ActionListener {
	int xSize;
	int ySize;
    JMenuBar bar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenuItem exit = new JMenuItem("Exit");
    JMenuItem reset = new JMenuItem("Reset");

    
 /**
   * Content pane that will hold the added Jpanel
   */
    public PlayPanel p;
  private Container c;
  /**
   * DisplayWindow constructor - no parameters
   */
  public DisplayFrame(int x, int y){
    super("Cell Activity Simulator Beta");
    c = this.getContentPane();
    xSize = x;ySize = y;
    setPreferredSize(new Dimension(xSize,ySize));
    exit.addActionListener(this);
    reset.addActionListener(this);
    file.add(reset);file.add(exit);
    bar.add(file);add(bar);
    setJMenuBar(bar);
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    setLayout(layout);
    //setResizable(false);
  }
   /**
 * Adds panel to content pane
 * @parameter the panel to be added
 */
  
  public void sendUI(PlayPanel main) {
	  p = main;
  }
  
  public void addPanel(JPanel p){
    c.add(p);
  }
  /**
 * consolidates the frame, makes it visible,
 * causes program termination when window is closed manually
 */
  public void showFrame(){
	this.setLocation(350,50);
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
@Override
public void actionPerformed(ActionEvent arg0) {
	if (arg0.getSource() == exit) {
		System.exit(0);
	}
	if (arg0.getSource() == reset) {
		p.clean();
	}
		
	//Need to send a message to MainScreen to reset or CLEAN() the screen.
}


}