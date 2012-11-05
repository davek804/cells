package Projects;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class FuBarButtons extends JPanel implements ActionListener {
  private JButton fuButton;
  private JButton barButton;
  private boolean fuPress = false;

  private FuBarButtonHandler handler;
  
  public FuBarButtons() {
	  setButtonHandler(handler);
    fuButton = new JButton("Fu");
    barButton = new JButton("Bar");
    fuButton.addActionListener(this);
    barButton.addActionListener(this);
    setLayout(new FlowLayout());
    add(fuButton);
    add(barButton);
   
  }
  
  public void actionPerformed(ActionEvent e) {
/*	  if (e.getSource() == fuButton) {
		  
		  fuPress = true;
		if (handler != null) {
			System.out.println("Button pressed captured by buttonclass.");
			  handler.fuActionPerformed(e);
		}
	  }
	  if(e.getSource() == barButton) {
		  if (handler != null) {
			  handler.barActionPerformed(e);
		  }
	  }*/
  }
  
  public boolean isFuPress() {
	return fuPress;
}

public void setFuPress(boolean fuPress) {
	fuPress = true;
}

public void setButtonHandler(FuBarButtonHandler handler) {
    this.handler = handler;
  }
}