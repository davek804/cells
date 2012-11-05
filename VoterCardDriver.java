package Projects;

public class VoterCardDriver {
	
	public static void main (String args []) {
		VoterWindow window = new VoterWindow(1000,600);
		VoterCard card = new VoterCard();
		window.addPanel(card);
		window.showFrame();

	}

}
