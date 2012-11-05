package Projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class DetailsPane extends JPanel {
	String currentItemName = "";
	VoteBox vb;
	JLabel title = new JLabel();

	public DetailsPane(String cin) {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		VoteBox voteBox = new VoteBox();
		setPreferredSize(new Dimension(970,250));
		setBorder(new TitledBorder("Details"));
		add(voteBox, BorderLayout.EAST);
	}

	public void updateDetails(Proposal p) {
		currentItemName = p.getTitle();
		setBorder(new TitledBorder("Detailed Information for Proposal: " + "\"" + currentItemName + "\""));
		JPanel details = new JPanel(new BorderLayout());
		//JEditorPane content = new JEditorPane();
		JTextPane content = new JTextPane();
		content.setText(p.getDescription());
		//content.setEditable(false);
		details.add(content, BorderLayout.CENTER);
		JPanel titledPane = new JPanel(new BorderLayout());
		//titledPane.setBorder(new TitledBorder("Detailed Information for Proposal: " + "\"" + currentItemName + "\""));
		titledPane.add(details, BorderLayout.CENTER);add(titledPane);
		
		updateUI();
	}


}
