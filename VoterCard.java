package Projects;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class VoterCard extends JPanel{
	
	ProposalsPane proposalsPane;
	BudgetPane budgetPane;
	DetailsPane detailsPane;

	
	public VoterCard() {
		proposalsPane = new ProposalsPane(this);
		budgetPane = new BudgetPane();
		detailsPane = new DetailsPane("");
		
		
		//setBorder(new LineBorder(Color.black, 1));
		//add(proposalsPane);add(budgetPane);add(detailsPane);
		buildLayout(proposalsPane, budgetPane, detailsPane);
		
	}

	public void buildLayout(ProposalsPane p, BudgetPane b, DetailsPane d) {
		setLayout(new FlowLayout());
		add(p);add(b);add(d);
		JLabel sources = new JLabel("This budget information was sourced using the New York Times.");
		add(sources);
	}

}
