import java.util.ArrayList;


public class Test {
	
	public static void main(String[] args){
		
		Vector v = new Vector();
		Vector u = new Vector(100, 100);
		
		System.out.println("v = "+v);
		System.out.println("u = "+u);
		
		System.out.println("v + u = "+Vector.addVector(v, u));
		
		v.setX(50); v.setY(-20);
		System.out.println("\nv = "+v);
		System.out.println("v + u = "+Vector.addVector(v, u));
		
		System.out.println("2u = "+u.scale(2));
		
		Thing p = new Thing(1, new Vector(), new Vector());
		System.out.println("\np: \n"+p);
		
		System.out.println("\np after 1t: \n"+p.refresh(1));
		
		ArrayList<Vector> vect = new ArrayList<Vector>();
		vect.add(new Vector());
		vect.get(0).setX(3);
		System.out.println(vect.get(0));
		
		Thing p1 = new Thing(10, new Vector(), new Vector());
		Thing p2 = p1;
		System.out.println(p1.equals(p2));
		p1.setPos(new Vector(1, 3));
		System.out.println(!p1.equals(p2));
		
	}

}