import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class EpicGui extends Gui{

	protected Thing centeredP;
	
	public EpicGui(Universe u){
		super(u);
		
		MouseMotionAdapter mouse = new GListener();
		addMouseMotionListener(mouse);
		
		MouseAdapter mouseclick =  new CListener();
		addMouseListener(mouseclick);
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println(centeredP);
		uni.next(T_INTERVAL);
		//System.out.println(centeredP);
		if(centeredP != null){
			setShift();
			shift();
		}
		repaint();
	}
	private class GListener extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e){
		}
		
	}
	private class CListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getClickCount() == 2){
				centeredP = uni.contains(e.getX(), e.getY());
				if(centeredP != null){
					setShift();
					shift();
					repaint();
				}
			}

		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e){
		}
	}
	
	private void setShift(){
			shiftX = getWidth()/2.0 - centeredP.getPos().getX();
			shiftY = getHeight()/2.0 - centeredP.getPos().getY();
	}
	private void shift(){
		for(Thing part : uni.getParticles()){
				double x = part.getPos().getX();
				double y = part.getPos().getY();
				part.getPos().setX(x + shiftX);
				part.getPos().setY(y + shiftY);
		}
	}
	
}