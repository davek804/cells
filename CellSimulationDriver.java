package Projects;

public class CellSimulationDriver {
	
	public static void main (String args []) {
		DisplayFrame window = new DisplayFrame(950,575);   //**The JFrame that houses interface and workspace.
		PlayPanel allAction = new PlayPanel(500,500);    //**The work/displayspace JPanel.
		InterfaceTab leftTab = new InterfaceTab(200,500, allAction);  //**The left interface JPanel.
		RightTab rightTab = new RightTab(175,500, allAction);
		allAction.sendTab(leftTab);
		allAction.sendTab(rightTab);
		window.sendUI(allAction);
		window.addPanel(leftTab);
		window.addPanel(allAction);
		window.addPanel(rightTab);
		window.showFrame();
		//window.setResizable(false);
		}
}
