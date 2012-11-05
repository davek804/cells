package Projects;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Life {
	PlayPanel panel;
	public int prodSeed;
	public int herbSeed;
	public int predSeed;
	public int decoSeed;
	public ArrayList<Producer> prodStore = new ArrayList<Producer>();
	public ArrayList<Herbivore> herbStore = new ArrayList<Herbivore>();
	public ArrayList<Predator> predStore = new ArrayList<Predator>();
	public ArrayList<Decomposer> decoStore = new ArrayList<Decomposer>();
	//public OutputStream output = new OutputStream("log.txt");
	

	public Life() {
	}
	public void setPanel(PlayPanel p) {
		panel = p;
	}
	public void producers() {
		for(int j = 0; j < prodSeed; j++) {
			Producer p = new Producer(panel.life);
			p.populate(p);
		}
		panel.producerPaint = true;
	}
	public void herbivores() {
		for(int j = 0; j < herbSeed; j++) {
			Herbivore h = new Herbivore(panel.life);
			h.populate(h);
		}
		panel.herbivorePaint = true;
	}
	public void predators() {
		for(int j = 0; j < predSeed; j++) {
			Predator p = new Predator(panel.life);
			p.populate(p);
		}
		panel.predatorPaint = true;
	}
	public void decomposers() {
		for(int j = 0; j < decoSeed; j++) {
			Decomposer d = new Decomposer(panel.life);
			d.populate(d);
		}
		panel.decomposerPaint = true;
	}
	public void beginAction() {
		for (int j = 0; j < prodStore.size(); j++) {
			prodStore.get(j).behavior();panel.repaint();		
		}
		for (int j = 0; j < herbStore.size(); j++) {
			herbStore.get(j).behavior();panel.repaint();
		}
		for (int j = 0; j < predStore.size(); j++) {
			predStore.get(j).behavior();panel.repaint();
		}
		for (int j = 0; j < decoStore.size(); j++) {
			decoStore.get(j).behavior();panel.repaint();
		}
		//Use booleans between these for loops to not repaint an extra amount of action
			
	}

	public Life getObject() {
		return panel.life;
	}
	public void writeAction() {

	}
	
	//Moved the work of checking circles over to RightTab (checkXY())
	/*public void check(int x, int y) {
		CircleComparer c = new CircleComparer();
		for(int j = 0; j < herbStore.size(); j++) {
			if(c.compare(x,y,1,herbStore.get(j).getxAxis(), herbStore.get(j).getyAxis(), herbStore.get(j).getxSize())) {
				System.out.println(herbStore.get(j).toString());
				
				panel.rightTab.enableBox1(j, herbStore.get(j));
			}
		}
		for(int j = 0; j < predStore.size(); j++) {
			if(c.compare(x,y,1,predStore.get(j).getxAxis(), predStore.get(j).getyAxis(), predStore.get(j).getxSize())) {
				System.out.println(predStore.get(j).toString());
				
				panel.rightTab.enableBox1(j, predStore.get(j));
			}
		}
	}*/
}
