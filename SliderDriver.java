package Projects;

public class SliderDriver {
	
	public static void main (String args []) {
		SliderTab t = new SliderTab();
		DisplayFrame window = new DisplayFrame(250,600);
		window.addPanel(t);
		window.showFrame();
	}

}
