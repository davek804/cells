package Projects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class InterfaceTab extends JPanel implements ActionListener {
	JPanel chooserContainer = new JPanel();
	JLabel herbLabel = new JLabel("Herbivores");
	JLabel prodLabel = new JLabel("Producers");
	JLabel predLabel = new JLabel("Predators");
	JLabel decoLabel = new JLabel("Decomposers");
	JTextField herbArea = new JTextField("100");
	JTextField prodArea = new JTextField("500");
	JTextField predArea = new JTextField("50");
	JTextField decoArea = new JTextField("100");
	JButton triggerGo = new JButton("Go");
	JButton triggerSeed = new JButton("Seed");
	JButton reset = new JButton("Reset");
	JPanel textcontainer = new JPanel();
	JLabel foodLabel;
	JPanel labelContainer = new JPanel();
	JLabel activeProdLabel = new JLabel();
	JLabel activeHerbLabel = new JLabel();
	JLabel activePredLabel = new JLabel();
	JLabel activeDecoLabel = new JLabel();
	public boolean lifeToggle = false;
	public JButton carryEvent;
	public PlayPanel panel;
	public Graph g1;

	public InterfaceTab(int xSize, int ySize, PlayPanel p) {
		panel = p;
		triggerGo.addActionListener(this);
		triggerGo.setEnabled(false);
	    triggerSeed.addActionListener(this);
	    reset.addActionListener(this);
		setPreferredSize(new Dimension(xSize,ySize));
		setBorder(new TitledBorder("Sim Params:"));
		BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(layout);
		setVisible(true);
		buildInterface();	
	}

	private void buildInterface() {
			FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
			setLayout(layout);
			JPanel sliderPane = new JPanel();
			sliderPane.setPreferredSize(new Dimension(190,100));
			GridLayout layout2 = new GridLayout(4,2);
			sliderPane.setLayout(layout2);
			sliderPane.add(prodLabel);
			sliderPane.add(prodArea);
			sliderPane.add(herbLabel);
			sliderPane.add(herbArea);
			sliderPane.add(predLabel);
			sliderPane.add(predArea);
			sliderPane.add(decoLabel);
			sliderPane.add(decoArea);
			add(sliderPane);
			add(reset);add(triggerGo);add(triggerSeed);
			
			//add(Box.createRigidArea(new Dimension(50,10)));
			//labelContainer.setBorder(new LineBorder(Color.BLACK));
			//labelContainer.setPreferredSize(new Dimension(196,200));
			GridLayout gridLayout = new GridLayout(4,1);
			labelContainer.setLayout(gridLayout);
			labelContainer.add(activeProdLabel);labelContainer.add(activeHerbLabel);
			labelContainer.add(activePredLabel);labelContainer.add(activeDecoLabel);
			labelContainer.setVisible(false);
			g1 = new Graph(196,170, panel.life.prodStore, panel);
			add(g1);
			add(labelContainer);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == triggerSeed) {
			panel.life.prodSeed = Integer.parseInt(prodArea.getText());
			panel.life.herbSeed = Integer.parseInt(herbArea.getText());
			panel.life.predSeed = Integer.parseInt(predArea.getText());
			panel.life.decoSeed = Integer.parseInt(decoArea.getText());
				panel.run();
			}
		if (e.getSource() == triggerGo) {
			labelContainer.setVisible(true);
			//validate();	
			panel.timer.start();		
		}
		if (e.getSource() ==  reset) {
			panel.clean();
			
		}
		}
}	
	


