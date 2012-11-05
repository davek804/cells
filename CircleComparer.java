package Projects;

public class CircleComparer {

	int axAxis;
	int ayAxis;
	int aSize;
	int axCenter;
	int ayCenter;
	int bxAxis;
	int byAxis;
	int bSize;
	int bxCenter;
	int byCenter;
	int centerxDistance;
	int centeryDistance;
	int rDistance;

	public CircleComparer() {		
	}
	public boolean compare(int a, int b, int c, int x, int y, int z) {
		axAxis = a;
		ayAxis = b;
		aSize = c;
		bxAxis = x;
		byAxis = y;
		bSize = z;
		calcCenter();
		Distance();
		if(compareDistances()) {
			return true;
		}
		return false;
	}
	public void calcCenter() {
		axCenter = axAxis + (aSize/2);
		ayCenter = ayAxis + (aSize/2);
		bxCenter = bxAxis + (bSize/2);
		byCenter = byAxis + (bSize/2);
	}
	public void Distance() {
		centerxDistance = Math.abs(axCenter - bxCenter);
		centeryDistance = Math.abs(ayCenter - byCenter);
		rDistance = (aSize/2) + (bSize/2);
	}
	public boolean compareDistances() {
		if (centerxDistance < rDistance && centeryDistance < rDistance){
			return true;
		}
		return false;
	}
	public int centerxDistance() {
		return centerxDistance;
	}
	public int centeryDistance() {
		return centeryDistance;
	}
}
