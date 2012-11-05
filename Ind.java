package Projects;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Ind extends JPanel{
	boolean occupied = false;

	public Ind(int x, int y, int h, RightTab tab, int index, Herbivore herbivore) {
		setOc(1);
		JLabel label = new JLabel("Herbivore " + index);
		add(label);
		JLabel nutrition = new JLabel("Current Nutrition: " + Integer.toString(herbivore.getNuts()));
		JLabel size = new JLabel("Current Size: " + Integer.toString(herbivore.getxSize())
				+ " * " + Integer.toString(herbivore.getySize()));
		setPreferredSize(new Dimension(x-10,(y/5)));
		setBorder(new LineBorder(Color.BLACK));
		add(label);
		add(nutrition);
		add(size);
		setVisible(true);
		tab.addBoxes(this);
		
	}
	
	public void setOc(int x) {
		if (x == 0) {
			occupied = false;
		}
		if (x == 1) {
			occupied = true;
		}
	}

	public boolean isOc() {
		return occupied;
	}
}
