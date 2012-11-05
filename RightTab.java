package Projects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class RightTab extends JPanel {
	
	public int x;
	public int y;
	public PlayPanel panel;
	public Ind[] box = new Ind[4];
	public boolean box1toggle = false;
	int herbCounter = 0;

	public RightTab(int xSize, int ySize, PlayPanel carryOver) {
		x = xSize;
		y = ySize;
		panel = carryOver;
		setPreferredSize(new Dimension(x,y));
		setBorder(new LineBorder(Color.BLUE, 1));
		buildInterface();
	}

	private void buildInterface() {
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		/*for (int j = 0; j < box.length; j++) {
			box[j] = new Ind(x,y);
			box[j].setVisible(true);
			add(box[j]);
			
		}*/

	}
	
	public void checkXY(MouseEvent e, Life l) {
		CircleComparer c = new CircleComparer();
		int x = e.getX();
		int y = e.getY();
		if (herbCounter < box.length) {
		for(int j = 0; j < l.herbStore.size(); j++) {
			if(c.compare(x,y,5,l.herbStore.get(j).getxAxis(), l.herbStore.get(j).getyAxis(), l.herbStore.get(j).getxSize())) {
				System.out.println(l.herbStore.get(j).toString());
				panel.rightTab.enableBox(herbCounter, l.herbStore.get(j), j);
				herbCounter++;
			}
		}
		}
		for(int j = 0; j < l.predStore.size(); j++) {
			if(c.compare(x,y,1,l.predStore.get(j).getxAxis(), l.predStore.get(j).getyAxis(), l.predStore.get(j).getxSize())) {
				System.out.println(l.predStore.get(j).toString());
				
				panel.rightTab.enableBox1(j, l.predStore.get(j));
			}
		}
		
	}

	public void enableBox(int herbCounter, Herbivore herbivore, int index) {
		box[herbCounter] = new Ind(x, y, herbCounter, this, index, herbivore);
		box[herbCounter].setVisible(true);
		
	}
	
	public void enableBox1(int h, Predator predatore) {
		
		for (int j = 0; j < 3; j++) {
			if (box[j].isVisible()) {
				if (j < 3){j++;}
		}
		
			JLabel label = new JLabel("Predator " + h);
			box[j].add(label);
			box[j].setVisible(true);

		box[j].setPreferredSize(new Dimension(x-10,(y/4)));
		box[j].add(label);
		box[j].setVisible(true);
		}
	}

	public void removeBoxes() {
		for(int j = 0; j < box.length; j ++) {
			box[j].setVisible(false);
		}
		herbCounter = 0;
	}
	
	public void addBoxes(Ind x) {
		add(x);
		repaint();
	}
}
