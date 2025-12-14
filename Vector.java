
public class Vector {
	
	private double x, y;
	
	public Vector(){
		this(0, 0);
	}

	public Vector(double xComp, double yComp){
            x = xComp;
            y = yComp;
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getMag(){
		return Math.sqrt(x*x + y*y);
	}

	public double getDirect(){
		return Math.atan2(y, x); //always north of east in degrees (radians now)
	}

	public static Vector addVector(Vector v1, Vector v2){
		return new Vector(v1.x + v2.x, v1.y + v2.y);
	}

	public Vector scale(double scaler){
		return new Vector(x*scaler, y*scaler);
	}

	public Vector clone(){
		return new Vector(this.x, this.y);
	}

	public String toString(){
		return x+"i + "+y+"j; ("+getMag()+", "+getDirect()+")";
	}

}
