package Projects;

import javax.swing.*;

public class Panel extends JPanel {
	public JButton yes = new JButton("Yes");
	public JButton no = new JButton("No");
	public Handle handler;

	public Panel() {
		add(yes);add(no);
	}
}
