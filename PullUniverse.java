//a universe with a particle that is selected and deselected
public class PullUniverse extends Universe{
	private Thing selectedP;
	
	public void selectParticle(Thing p){
		if(parts.contains(p)){
			selectedP = p;
			if(p != null)
			parts.remove((Thing)p);
		}else
			throw new RuntimeException("There is no such particle!");
	}
	public void deselectParticle(){
		if(selectedP != null){
			selectedP = new Thing(selectedP.getMass(), selectedP.getPos(), new Vector());
			parts.add(selectedP);
			selectedP = null;
		}
	}
	public Thing getSelected(){
		return selectedP;
	}
	protected void applyGravity() {
		super.applyGravity();
		for(int i = 0; i < parts.size(); i++){
			if(selectedP != null){
				Vector F = getGravForce(parts.get(i), selectedP);
				parts.get(i).applyForce(F);
			}
		}
	}
}