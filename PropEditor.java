package Projects;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class PropEditor extends JFrame implements ActionListener {
	JButton submit = new JButton("Submit");
	JLabel title = new JLabel("Title: ");
	JLabel textInput = new JLabel("Main Criteria: ");
	JTextArea titleInput = new JTextArea(1,20);
	ProposalsPane pPane;
	
	public PropEditor(ProposalsPane p) {
		pPane = p;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(p);
		setSize(new Dimension(300,250));
		JPanel container = new JPanel();
		JLabel title = new JLabel("Title: ");
		container.add(title);
		container.add(titleInput);

		JLabel textInput = new JLabel("Main Criteria: ");
		container.add(textInput);
		JTextArea textField = new JTextArea(1,16);
		container.add(textField);
		submit.addActionListener(this);
		container.add(submit);
		add(container);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			//System.out.println("submit pressed");
			//System.out.println(titleInput.getText());
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("H:\\Eclipse\\Workspace\\Projects\\Projects\\titles.txt", true));
				writer.newLine();
				writer.write("TITLE");
				writer.newLine();
				writer.write(titleInput.getText());
				writer.close();
				pPane.populateList();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			this.dispose();
		}
		pPane.updateUI();
	}

}
