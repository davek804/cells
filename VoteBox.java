package Projects;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VoteBox extends JPanel {
	JButton yes = new JButton("Yes");
	JButton no = new JButton("No");
	JPanel cont1 = new JPanel();
	JPanel cont2 = new JPanel();
	JPanel cont3 = new JPanel();
	JLabel label1 = new JLabel("Your Vote: ");
	JLabel label2 = new JLabel("Total Votes: ");
	JLabel label3 = new JLabel("Votes Needed: ");
	
	public VoteBox() {
		setBorder(new TitledBorder("Votes on this Proposal"));
		int x = 225;
		int y = 125;
		setPreferredSize(new Dimension(x,y));

		cont1.add(label1);cont1.add(yes);cont1.add(no);
		cont2.add(label2);
		cont3.add(label3);
		cont1.setPreferredSize(new Dimension(x-10,40));
		cont2.setPreferredSize(new Dimension(x-10,30));
		cont3.setPreferredSize(new Dimension(x-10,30));
		add(cont1);;add(cont2);add(cont3);
		
	}

}
