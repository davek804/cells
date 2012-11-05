package Projects;

public class Scavenger {
	Cell[] cellStore;
	Cell c;
	int cellPop;
	
	public Scavenger(Cell[] cell, Cell c, int cellPopulation) {
		cellStore = cell;
		this.c = c;
		cellPop = cellPopulation;
		test();
	}

	public void test() {
		for (int j = 0; j < cellPop; j++) {
			if (!cellStore[j].isLife()) {
				System.out.println("Cell " + j + " is out of nutrition");
			}
		}
 	}
	public void respawn() {
		System.out.println();
	}

}
