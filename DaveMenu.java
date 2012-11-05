package Projects;

import javax.swing.*;

public class DaveMenu extends JComponent {
	
	public DaveMenu() {
		JMenuBar bar = new JMenuBar();
		
		JMenuItem file = new JMenuItem("File");
		bar.add(file);
		this.add(bar);
	}

}
