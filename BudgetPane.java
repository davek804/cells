package Projects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BudgetPane extends JPanel {
	JLabel title;
	int x = 2011;
	List items = new List(10);
	//JBudgetTree budgetTree = new JBudgetTree();
	
	public BudgetPane() {
		setBorder(new TitledBorder("Budget - Fiscal Year 2011"));
		setPreferredSize(new Dimension(480,250));
		title = new JLabel("Budget - FY " + Integer.toString(x));
		add(title);
		add(Box.createHorizontalStrut(230));
		buildFY();
	}
	public void buildFY() {
		int p = 10;
		for (int j = 0; j < p; j++) {
			items.add("string" + j);
		}
		add(items);
	}
}
