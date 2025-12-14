import java.util.ArrayList;


public class Universe {
	
	protected ArrayList<Thing> parts;
	
	public Universe(){
		parts = new ArrayList<Thing>();
		parts.add(new Thing(100, new Vector(150,150), new Vector(-1*Math.sqrt(5/1.5), Math.sqrt(5/1.5))));
		parts.add(new Thing(500, new Vector(300,300), new Vector()));
		parts.add(new Thing(100, new Vector(400, 400), new Vector(-1*Math.sqrt(5/2), Math.sqrt(5/2))));
		
		
	}
	public Universe(ArrayList<Thing> things){
		parts = things;
	}
	public ArrayList<Thing> getParticles(){
		return parts;
	}
	public void addParticle(Thing p){
		if(!parts.contains(p))
			parts.add(p);
		else
			throw new RuntimeException("That particle already exists!");
	}
	public Thing removeParticle(Thing p){
		if(parts.contains(p)){
			parts.remove(p);
			return p;
		}else
			throw new RuntimeException("There is no such particle!");
	}
	//Universe.next() refreshes the particles 
	public void next(double t){     // t is the size of time interval passed
		applyGravity();
		for(Thing part: parts){
			part.refresh(t);
		}
	}
	protected void applyGravity() {
		for(int i = 0; i < parts.size(); i++){
			for(int j = i+1; j < parts.size(); j++){
				Vector F = getGravForce(parts.get(i), parts.get(j));
				parts.get(j).applyForces(parts.get(i).applyForce(F));
			}
		}
	}
	public Thing contains(int x, int y){
		for(int i = 0; i < parts.size(); i++){
			if(parts.get(i).contains(x, y))
				return parts.get(i);
		}
		return null;
	}
	//force of p2 on p1
	public Vector getGravForce(Thing p1, Thing p2){
		Vector F = new Vector(), temp;
		temp = new Vector(p2.getPos().getX()-p1.getPos().getX(), p2.getPos().getY()-p1.getPos().getY());
		F.setX(p1.getMass()*p2.getMass()/(temp.getMag()*temp.getMag())*Math.cos(temp.getDirect()));
		F.setY(p2.getMass()*p1.getMass()/(temp.getMag()*temp.getMag())*Math.sin(temp.getDirect()));
		return F;
	}
}
