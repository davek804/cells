package Projects;

public class Producer {

	public int xAxis;
	public int yAxis;
	public int xSize;
	public int ySize;
	public int nuts;
	public boolean life;
	public Life lifeClass;
	CircleComparer c = new CircleComparer();
	public int z = 0;

	public Producer(Life life1) {
		lifeClass = life1;
		xAxis = (int)(Math.random() * 485);
		yAxis = (int)(Math.random() * 485);
		xSize = (int)((Math.random() * 2) + 3);
		ySize = xSize;
		nuts = (int)(Math.random() * 500);
		life = true;
	}
	public Producer(int x, int y, int a, int b, Life life1) {
		xAxis = x;
		yAxis = y;
		xSize = a;
		ySize = b;
		nuts = 500;
		lifeClass = life1;
		life = true;
	}
	public void behavior() {
		if(isIminentDeath()){
			defensiveMeasures();
		}		
		else{
			if(reproduce()) {
			}
			else{
				grow();
			}
		}
		push();
		nuts += 5;
	}
	private void defensiveMeasures() {
		xAxis += 5;
		yAxis += 5;
		//System.out.println("new x: " + xAxis + " new y: " + yAxis);
	}
	private void grow() {
		if (nuts > 1000 && xSize < 6) {
			nuts -= 500;
			xSize += 1;
			ySize += 1;

		}
	}
	private void push() {
	//	if (z < 10) {
		for(int j = 0; j < lifeClass.prodStore.size(); j++) {
			if(c.compare(xAxis, yAxis, xSize, lifeClass.prodStore.get(j).getxAxis(), lifeClass.prodStore.get(j).getyAxis(), lifeClass.prodStore.get(j).getxSize()) && lifeClass.prodStore.get(j) != this ) {
				//lifeClass.prodStore.get(j).setxAxis(lifeClass.prodStore.get(j).getxAxis()+((int)Math.random()+2));
				//lifeClass.prodStore.get(j).setyAxis(lifeClass.prodStore.get(j).getyAxis()+((int)Math.random()+2));
				xAxis = getxDetails();
				yAxis = getyDetails();
				//z++;
				push();
				//}				
			}
		}
		
	}
	public boolean reproduce() {
		if (nuts > 3000) {
			int a = xSize/2;
			int b = ySize/2;
			Producer p = new Producer(getxDetails(), getyDetails(), a, b, lifeClass);
			p.populate(p);
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
			newx +=xSize/2;
			if(newx > 500) {
				newx = 500;
			}
		}
		else{
			newx -= xSize/2;
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
			newy += xSize/2;
			if(newy > 500) {
				newy = 500;
			}
		}
		else{
			newy -= xSize/2;
			if( newy < 0) {
				newy = 0;
			}
		}
		return newy;
	}
	public boolean isIminentDeath() {	
		for(int j = 0; j < lifeClass.herbStore.size(); j++) {
			if(c.compare(xAxis, yAxis, xSize, lifeClass.herbStore.get(j).getxAxis(), lifeClass.herbStore.get(j).getyAxis(), lifeClass.herbStore.get(j).getxSize())) {
				//System.out.println("px: " + xAxis + " hx: " + lifeClass.herbStore.get(j).getxAxis() + "    py: " + yAxis + " hy: " + lifeClass.herbStore.get(j).getyAxis());
				return true;
			}
		}
		return false;
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
	public void populate(Producer p) {
		lifeClass.prodStore.add(p);
	}
	public void print(){
		System.out.println("Producer: " + " @ " +  xAxis + "|" + yAxis);
		System.out.println(lifeClass.prodStore);
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
}
