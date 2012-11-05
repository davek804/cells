package Projects;

public class Decomposer {

	public int xAxis;
	public int yAxis;
	public int xSize;
	public int ySize;
	public int nuts;
	public boolean life;
	public Life lifeClass;
	CircleComparer c = new CircleComparer();
	public boolean eating = false;

	public Decomposer(Life lifeClass) {
		this.lifeClass = lifeClass;
		xAxis = (int)(Math.random() * 485);
		yAxis = (int)(Math.random() * 485);
		xSize = 2;
		ySize = xSize;
		nuts = 1;
		life = true;
	}
	public Decomposer(int x, int y, int a, int b, Life life1) {
		xAxis = x;
		yAxis = y;
		xSize = a;
		ySize = b;
		nuts = 1;
		lifeClass = life1;
		life = true;
	}
	public void behavior() {
		if(reproduce()) {
		}
		else{
			if(!eating) {
				movement();
				eatTest();
			}
			else {
				eatTest();
			}
		}
	}

	private void movement() {
		double xTest = Math.random();
		double yTest = Math.random();
		if (xAxis <= 0) {
			xAxis+=1;
		}
		else if (xAxis >= 500) {
			xAxis-=1;			
		}
		else {
			if (xTest > 0.5) {
				xAxis +=1;
			}
			else {
				xAxis-=1;
			}
		}
		if (yAxis <= 0) {
			yAxis+=1;
		}
		else if (yAxis >= 500) {
			yAxis-=1;
		}
		else {
			if (yTest > 0.5) {
				yAxis +=1;
			}
			else {
				yAxis-=1;
			}
		}
	
	}
	private void eatTest() {
		for(int j = 0; j < lifeClass.herbStore.size(); j++) {	
			if(c.compare(xAxis, yAxis, xSize, lifeClass.herbStore.get(j).getxAxis(), lifeClass.herbStore.get(j).getyAxis(), lifeClass.herbStore.get(j).getxSize())) {
				if(lifeClass.herbStore.get(j).isLife() == false) {
					//eating = true;
					eat(lifeClass.herbStore.get(j), j);
				}
			}
		}
		for(int j = 0; j < lifeClass.predStore.size(); j++) {	
			if(c.compare(xAxis, yAxis, xSize, lifeClass.predStore.get(j).getxAxis(), lifeClass.predStore.get(j).getyAxis(), lifeClass.predStore.get(j).getxSize())) {
				if(lifeClass.predStore.get(j).isLife() == false) {
					//eating = true;
					eat(lifeClass.predStore.get(j), j);
				}
			}
		}

	}
	private void eat(Predator p, int j) {
/*		if(lifeClass.predStore.get(j).getNuts() > 0) {
			nuts += 5;
			lifeClass.predStore.get(j).setNuts((lifeClass.predStore.get(j).getNuts() - 5));
		}
		else{
			lifeClass.predStore.remove(j);
			eating = false;
		}*/
		nuts += lifeClass.predStore.get(j).getNuts();
		lifeClass.predStore.remove(j);
	}
	private void eat(Herbivore p, int j) {
/*		if(lifeClass.herbStore.get(j).getNuts() > 0) {
			nuts += 5;
			lifeClass.herbStore.get(j).setNuts((lifeClass.herbStore.get(j).getNuts() - 5));
			System.out.print(lifeClass.herbStore.get(j).getNuts());
		}
		else{
			lifeClass.herbStore.remove(j);
			eating = false;
		}*/
		nuts += lifeClass.herbStore.get(j).getNuts();
		lifeClass.herbStore.remove(j);
	}
	private boolean reproduce() {
		if (nuts > 20) {
			Decomposer d = new Decomposer(xAxis, yAxis, xSize, ySize, lifeClass);
			d.populate(d);
			nuts -= 5;
			return true;
		}
		return false;
	}
	public void populate(Decomposer d) {
		lifeClass.decoStore.add(d);
		//	print();
	}
	public void print(){
		System.out.println("x: " + xAxis + " " + "y: " + yAxis);
	}
	public int getxAxis() {
		return xAxis;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public int getxSize() {
		return xSize;
	}
	public void setxSize(int xSize) {
		this.xSize = xSize;
	}
	public int getySize() {
		return ySize;
	}
	public void setySize(int ySize) {
		this.ySize = ySize;
	}
	public int getNuts() {
		return nuts;
	}
	public void setNuts(int nuts) {
		this.nuts = nuts;
	}
	public boolean isLife() {
		return life;
	}
	public void setLife(boolean life) {
		this.life = life;
	}
}
