package Projects;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSlider;


public class SliderTab extends JPanel {
	
	public int slideMax = 100;
	public JSlider[] s;
	
	public SliderTab() {
		for (int j = 0; j < 4; j++) {
			s[j] = new JSlider (0,slideMax/4);
			add(s[j]);
		}
		
	}

}
