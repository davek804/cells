package Projects;

public class Predator {

	public int xAxis;
	public int yAxis;
	public int xSize;
	public int ySize;
	public int nuts;
	public boolean life;
	public Life lifeClass;
	CircleComparer c = new CircleComparer();

	public Predator(Life lifeClass) {
		this.lifeClass = lifeClass;
		xAxis = (int)(Math.random() * 485);
		yAxis = (int)(Math.random() * 485);
		xSize = (int)((Math.random() * 2) + 5);
		ySize = xSize;
		nuts = 1000;
		life = true;
	}
	public Predator(int x, int y, int a, int b, Life life1) {
		xAxis = x;
		yAxis = y;
		xSize = a;
		ySize = b;
		nuts = 1000;
		lifeClass = life1;
		life = true;
	}
	public void behavior() {
		if(life == true) {
			if(nuts > 25) {
				if(reproduce()) {
				}
				else{
					grow();
					movement();
				}
			}
			else {
				die();
			}
		}
	}
	private void die() {
		life = false;		
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
		for(int j = 0; j < lifeClass.herbStore.size(); j++) {	
			if(c.compare(xAxis, yAxis, xSize, lifeClass.herbStore.get(j).getxAxis(), lifeClass.herbStore.get(j).getyAxis(), lifeClass.herbStore.get(j).getxSize())) {
				if(lifeClass.herbStore.get(j).isLife());
				eat(lifeClass.herbStore.get(j), j);
			}
		}
		nuts -= 1;
	}
	private void eat(Herbivore h, int j) {
		nuts += (h.getNuts());
		lifeClass.herbStore.remove(j);

	}
	private void grow() {
		if (nuts > 1000 && xSize < 10) {
			xSize += 1;
			ySize += 1;
			nuts -= 200;
		}
	}
	private boolean reproduce() {
		if (nuts > 2000) {
			int a = xSize/2;
			int b = ySize/2;
			Predator p = new Predator(xAxis, yAxis, a, b, lifeClass);
			p.populate(p);
			xSize = xSize/2;
			ySize = ySize/2;
			nuts = 1000;
			return true;
		}
		return false;
	}
	public void populate(Predator p) {
		lifeClass.predStore.add(p);
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
	public int getxSize() {
		return xSize;
	}
}
