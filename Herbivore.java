package Projects;

public class Herbivore {

	public int xAxis;
	public int yAxis;
	public int xSize;
	public int ySize;
	public int nuts;
	public boolean life;
	public Life lifeClass;
	CircleComparer c = new CircleComparer();

	public Herbivore(Life lifeClass) {
		this.lifeClass = lifeClass;
		xAxis = (int)(Math.random() * 485);
		yAxis = (int)(Math.random() * 485);
		nuts = (int)(Math.random() * 1000);
		xSize = (int)((Math.random() * 2) + 4);
		ySize = xSize;
		life = true;
	}
	public Herbivore(int x, int y, int a, int b, Life life1) {
		xAxis = x;
		yAxis = y;
		xSize = a;
		ySize = b;
		nuts = 500;
		lifeClass = life1;
		life = true;
	}
	public void behavior() {
		if(life == true) {
			if(nuts > 25) {
				if(isIminentDeath()){
					defensiveMeasures();
				}		
				else{
					if(reproduce()) {
					}
					else{
						grow();
						movement();

					}
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
		for(int j = 0; j < lifeClass.prodStore.size(); j++) {	
			if(c.compare(xAxis, yAxis, xSize, lifeClass.prodStore.get(j).getxAxis(), lifeClass.prodStore.get(j).getyAxis(), lifeClass.prodStore.get(j).getxSize())) {
				eat(lifeClass.prodStore.get(j), j);
			}
		}
		nuts -= 1;
	}
	private void eat(Producer p, int j) {
		nuts += (p.getNuts());
		lifeClass.prodStore.remove(j);
	}
	private void grow() {
		if (nuts > 500 && xSize < 10) {
			xSize += 1;
			ySize += 1;
			nuts -= 200;
		}
	}
	private boolean reproduce() {
		if (nuts > 3000) {
			int a = xSize/2;
			int b = ySize/2;
			Herbivore h = new Herbivore(getxDetails(), getyDetails(), a, b, lifeClass);
			h.populate(h);
			xSize = xSize/2;
			ySize = ySize/2;
			nuts = 1000;
			return true;
		}
		return false;
	}
	private int getxDetails() {
		int newx = xAxis;
		double a = Math.random();

		if(a > 0.5) {
			newx +=xSize-1;
			if(newx > 500) {
				newx = 500;
			}
		}
		else{
			newx -= xSize-1;
			if( newx < 0) {
				newx = 0;
			}
		}

		return newx;
	}
	
	private int getyDetails() {
		int newy = yAxis;
		double b = Math.random();
		if(b > 0.5) {
			newy += xSize-1;
			if(newy > 500) {
				newy = 500;
			}
		}
		else{
			newy -= xSize-1;
			if( newy < 0) {
				newy = 0;
			}
		}
		return newy;
	}
	private void defensiveMeasures() {
		//possibly set a boolean to make the herbivore continue to run away from the predator
		xAxis += 5;
		yAxis += 5;
	}
	private boolean isIminentDeath() {
		for(int j = 0; j < lifeClass.predStore.size(); j++) {
			if(c.compare(xAxis, yAxis, xSize, lifeClass.predStore.get(j).getxAxis(), lifeClass.predStore.get(j).getyAxis(), lifeClass.predStore.get(j).getxSize())) {
				//System.out.println("px: " + xAxis + " hx: " + lifeClass.predStore.get(j).getxAxis() + "    py: " + yAxis + " hy: " + lifeClass.predStore.get(j).getyAxis());
				return true;
			}
		}
		return false;
	}
	public boolean isLife() {
		return life;
	}
	public void setLife(boolean life) {
		this.life = life;
	}
	public void populate(Herbivore h) {
		lifeClass.herbStore.add(h);
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
}
