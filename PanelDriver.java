package Projects;

public class PanelDriver {
	
	public static void main (String args []) {
		
		DisplayFrame window = new DisplayFrame(500, 400);
		Panel panel = new Panel();
		window.addPanel(panel);
		window.showFrame();
	}

}
