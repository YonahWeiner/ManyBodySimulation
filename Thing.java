// after dusting this program off after 13 years, it doesn't compule because this class is abstract. I will make it not abstract.
 public class Thing {

	protected double m;
	protected Vector r; //position
	protected Vector v; //velocity
	protected Vector a; //acceleration;

	
	public Thing(double mass, Vector position, Vector velocity) {
		m = mass;
		r = position;
		v = velocity;
		a = new Vector();
	}
	public double getMass() {
		return m;
	}

	public Vector getPos() {
		return r;
	}

	public Vector getVelocity(){
		return v;
	}

	public void setPos(Vector newR){
		r = newR;
	}

	public boolean contains(int x, int y){
		double dx = r.getX() - x;;
		double dy =  r.getY() - y;;
		return Math.sqrt(dx*dx + dy*dy) <= Gui.P_SIZE/2;
	}
	public Thing refresh(double t){
		Vector ds = Vector.addVector(v.scale(t),a.scale(t*t*.5));
		r = Vector.addVector(r, ds);
		v = Vector.addVector(v, a.scale(t));
		a = new Vector();
		return this;
	}
	public Vector[] applyForces(Vector[] F){
		Vector netF = new Vector();				//get net force on particle
		for(int i = 0; i < F.length; i++){
			if(F[i] == null) break;
			netF = Vector.addVector(netF, F[i]);
		}
		
		a = Vector.addVector(a, netF.scale(1/m));				//set acceleration
		
		for(int i = 0; i < F.length; i++){		//return reaction forces
			if(F[i] == null) break;
			F[i] = F[i].scale(-1.0);
		}
		return F;
	}
	public Vector[] applyForce(Vector f){
		Vector[] F = {f};
		return applyForces(F);
	}
	public Thing clone(){
		return new Thing(m, r.clone(), v.clone());
	}
	public String toString(){
		return "m = "+m+"\ns = "+r;
	}

}
