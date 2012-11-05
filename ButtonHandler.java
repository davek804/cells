package Projects;

import java.awt.event.ActionEvent;

public class ButtonHandler {
	public boolean lifeButton = false;

	public void lifeTriggerActionPerformed(ActionEvent e) {
		System.out.println("Life button pushed");
		lifeButton = true;
	}

	public boolean getLifeButton() {
		return lifeButton;
	}

	private void setLifeButton(boolean lifeButton) {
		this.lifeButton = lifeButton;
	}

	public void barActionPerformed(ActionEvent e) {
		System.out.println("bar button pushed");
	}


}

