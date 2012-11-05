package Projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProposalsPane extends JPanel implements ActionListener, ListSelectionListener {
	JButton newProp;
	JButton details;
	VoterCard voterCard;
	JPanel titlePane;
	JPanel listPane = new JPanel();
	public ArrayList<Proposal> propList = new ArrayList<Proposal>();
	JList list;

	public ProposalsPane(VoterCard vc) {
		voterCard = vc;
		setPreferredSize(new Dimension(480,250));
		setBorder(new TitledBorder("Current Proposals"));
		buildInterface();

	}

	public void buildInterface() {

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		/*		title = new JLabel("Current Proposals");
		c.fill = GridBagConstraints.CENTER;
		c.weightx = 0;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		add(title,c);*/

		newProp = new JButton("New Proposal");
		newProp.addActionListener(this);
		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.FIRST_LINE_END;
		d.weightx = 0;
		d.gridwidth = 1;
		//d.gridx = 2;
		d.gridy = 0;
		add(newProp, d);


		listPane.setLayout(new BorderLayout());
		GridBagConstraints e = new GridBagConstraints();
		e.fill = GridBagConstraints.HORIZONTAL;
		e.weightx = 1;
		e.ipady = 170;
		e.gridx = 0;
		e.gridy = 2;
		e.gridwidth = 2;
		e.insets = new Insets(7,1,0,2);
		e.anchor = GridBagConstraints.PAGE_END;
		listPane.setBorder(new LineBorder(Color.black, 1));
		add(listPane,e);
		populateList();
		list = new JList(propList.toArray());
		list.addListSelectionListener(this);
		JScrollPane scrollPane = new JScrollPane(list);
		listPane.add(scrollPane, BorderLayout.CENTER);

	}
	public void populateList() {
		propList = new ArrayList<Proposal>();
		Scanner scan =  null;
		try {
			scan = new Scanner(new FileReader("H:\\Eclipse\\Workspace\\Projects\\Projects\\titles.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scan.hasNext()) {
			Proposal p = new Proposal(this);
			String s = scan.nextLine();
			
			if (s.equals("TITLE")) {
				String q = scan.nextLine();
				p.setTitle(q);
				//System.out.println(q);
			}
			/*if (s.equals("DESCRIPTION")) {
				System.out.println(scan.nextLine());
			}*/
			propList.add(p);
			}
		scan.close();
		try {
			scan = new Scanner(new FileReader("H:\\Eclipse\\Workspace\\Projects\\Projects\\descriptions.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int j = 0;
		while (scan.hasNext()) {
			String s = scan.nextLine();
		
			if (s.equals("DESCRIPTION")) {
				String x = scan.nextLine();
				if (j <= propList.size()-1) {
				propList.get(j).setDescription(x);
				}
			}
			j++;
		}
		//ListModel model = list.getModel();
		//model.
		list = new JList(propList.toArray());
		System.out.println();
		validate();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newProp) {
			//tree.add("next");
			PropEditor propEditor = new PropEditor(this);
			propEditor.setVisible(true);

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (! e.getValueIsAdjusting()){
			int n = list.getSelectedIndex();
			voterCard.detailsPane.updateDetails(propList.get(n));
		};

	}

}
