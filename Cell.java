package Projects;

public class Cell {
	public int x;
	public int y;
	public int cellEnergy;
	public int indexPos;
	public boolean life;
	public boolean eating;


	public Cell (int xPos, int yPos, int energy, boolean status, int ind) {
		x = xPos;
		y = yPos;
		cellEnergy = energy;
		life = status;
		indexPos = ind;
		eating = false;
	}
	public int getIndex() {
		return indexPos;
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
	public boolean isLife() {
		return life;
	}
	public void setLife(boolean life) {
		this.life = life;
	}
	public int getCellEnergy() {
		return cellEnergy;
	}
	public void setCellEnergy(int cellEnergy) {
		this.cellEnergy = cellEnergy;
	}
	public void behavior() {
		if (!eating) {
			if (cellEnergy > 0) {
				double xTest = Math.random();
				double yTest = Math.random();
				if (x <= 0) {
					x+=2;
				}
				else if (x >= 485) {
					x-=2;			
				}
				else {
					if (xTest > 0.5) {
						x +=2;
					}
					else {
						x-=2;
					}
				}
				if (y <= 0) {
					y+=2;
				}
				else if (y >= 485) {
					y-=2;
				}
				else {
					if (yTest > 0.5) {
						y +=2;
					}
					else {
						y-=2;
					}
				}
				cellEnergy--;
			}
		}
	}
	public void proximityTest(Food[] foodStore, int noDots) {
		for (int j = 0; j < noDots; j++) {
			if ((x+2 >= (foodStore[j].getX()))) {
				if (x <= (foodStore[j].getX() + 15)) {
					if (y+2 >= (foodStore[j].getY())) {
						if (y <= (foodStore[j].getY() + 15)) {
							eating = true;
							digest(foodStore[j]);
						}
					}
				}
			}
		}
	}
	private void digest(Food f) {
		if(f.getNutrition() >= 0) {
			cellEnergy += 50;
			f.setNutrition(f.getNutrition() - 50);
		}
		else {
			f.delete();
			eating = false;
		}
	}
	public boolean reproduce() {
		if (cellEnergy > 250) {
			return true;
		}
		else {} return false;
	}
	public void scavengerTest(Cell[] cellStore, Cell c, int cellPopulation) {
		int i = (int)(Math.random() * 1000);
		System.out.println(i);
		if (i <= 25) {
			Scavenger s = new Scavenger (cellStore, c, cellPopulation);			
		}
		
	}
}



