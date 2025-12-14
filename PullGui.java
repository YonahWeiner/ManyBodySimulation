import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PullGui extends Gui{
	
	private int x, y;
	
	public PullGui(PullUniverse u){
		super(u);
		
		MouseMotionAdapter mouse = new GListener();
		addMouseMotionListener(mouse);
		
		MouseAdapter mouseclick =  new CListener();
		addMouseListener(mouseclick);
	}
	private class GListener extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e){
			if(((PullUniverse)uni).getSelected() == null) return;
			int dx = e.getX()-x;
			int dy = e.getY()-y;
			((PullUniverse)uni).getSelected().setPos(new Vector(((PullUniverse)uni).getSelected().getPos().getX()+dx, ((PullUniverse)uni).getSelected().getPos().getY()+dy));
			x = e.getX();
			y = e.getY();
			repaint();
		}
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(((PullUniverse)uni).getSelected() != null){
			g.fillOval((int)((PullUniverse)uni).getSelected().getPos().getX() - P_SIZE/2, (int)((PullUniverse)uni).getSelected().getPos().getY()- P_SIZE/2, P_SIZE, P_SIZE);
		}
	}
	private class CListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			Thing p = uni.contains(e.getX(), e.getY());
			if(p == null) return;
			((PullUniverse)uni).selectParticle(p);
			x = e.getX();
			y = e.getY();
		}
		public void mouseReleased(MouseEvent e){
			((PullUniverse)uni).deselectParticle();
		}
	}
}