package co.unicundinamarca.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel implements MouseMotionListener {
	
	private ArrayList<Point> posiciones = new ArrayList<Point>();
	private Point posicion_actual = new Point();
	private Color color = Color.BLACK;
	
	public PanelDibujo() {
		super();
		this.setBorder(BorderFactory.createTitledBorder("Panel: area_dibujo"));
		this.setBackground(Color.WHITE);
		this.addMouseMotionListener(this);
	}
	
	public void setColor(Color color) {
		this.color = color;
		super.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		posiciones.add(e.getPoint());
		posicion_actual = e.getPoint();
		super.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		posicion_actual = e.getPoint();
		super.repaint();
	}
	
	public void paint(Graphics g) { //Sobreescribimos el m�todo paint heredado de la clase JPanel:
		
		//El m�todo paint se ejecuta cada vez que el JPanel debe ser redibujado y llega como
		//par�metro un objeto de la clase Graphics.
		
		super.paint(g);
		
		g.setColor(this.color);
		g.drawString("x: "+posicion_actual.x+" y: "+posicion_actual.y, 10, 50);
		//drawString: El m�todo que permite graficar texto sobre el JPanel
		
		for (int i=0; i<posiciones.size()-1; i++)
			g.drawLine(posiciones.get(i).x, posiciones.get(i).y, posiciones.get(i+1).x, posiciones.get(i+1).y);
		    // Dibuja una l�nea desde el punto (x1,y1) al punto (x2,y2).	

	}
}
