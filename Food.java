package Projects;

public class Food {
	public int x;
	public int y;
	public int nutrition;
		
	public Food(int xPos, int yPos, int nutVal) {
		x = xPos;
		y = yPos;
		nutrition = nutVal;		
		}	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getNutrition() {
		return nutrition;
	}
	public void setNutrition(int nutrition) {
		this.nutrition = nutrition;
	}
	public void delete() {
		x = 900;
		y = 900;
		nutrition = 0;
	}
}
