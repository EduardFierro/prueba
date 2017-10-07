package co.unicundinamarca.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pintura extends JFrame{
	
	private PanelDibujo area_dibujo;  //objeto de la Clase PanelDibujo
	private JPanel herramientas; //JPanel 
	private JTextField tx_color;  //Caja de texto
	private JButton bt_cambiar_color; // Botton
	
	public Pintura() {
		this("Titulo de mi jframe");
	}
	
	public Pintura(String titulo) {  //Constructor 
		super(titulo);
		
		this.iniciar(); //Configuramos nuestro Jframe
		this.configurarComponentes(); //Añadimos componente
		this.asignarEventos();

		this.pack(); 
		//el método pack() de la ventana hará que coja el tamaño necesario 
		//para que se vea todo lo que tiene dentro.
		this.setVisible(true);
	}
	
	private void iniciar() {
		Dimension dims = new Dimension(800, 600);
		this.setSize(dims);
		this.setPreferredSize(dims);
		this.setLayout(new BorderLayout());//Pendiente
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void configurarComponentes() {
		herramientas = new JPanel(new FlowLayout(FlowLayout.LEFT));//Pänel 1 de las herramientas
		//Nos coloca los componente en fila, los que estan dentro del Jpanel
		
		tx_color = new JTextField(10);
		tx_color.setText("#fff");
		herramientas.add(tx_color);
		
		bt_cambiar_color = new JButton("Cambiar color");
		herramientas.add(bt_cambiar_color);
		
		area_dibujo = new PanelDibujo();//Panel del dibujo, creado en mi clase PanelDibujo
		this.add(area_dibujo, BorderLayout.CENTER); //agregando panel de dibujo
		this.add(herramientas, BorderLayout.NORTH);//agregando panel herramientas
	}
	
	private void asignarEventos() {
		

		
		bt_cambiar_color.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent a) {
				area_dibujo.setColor(Pintura.this.obtenerColor(tx_color.getText()));
			}
		});
		
		
		tx_color.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent k) {
			}

			@Override
			public void keyReleased(KeyEvent k) {
				herramientas.setBackground(Pintura.this.obtenerColor(tx_color.getText()));
			}

			@Override
			public void keyTyped(KeyEvent k) {
			}
			
		});
	}
	
	private Color obtenerColor(String color)
	{
		Color nuevo = null;
		try {
			nuevo = Color.decode(color);
		} catch (NumberFormatException ne) {
			nuevo = Color.LIGHT_GRAY;
		}						
		
		return nuevo;
	}
	
	
	 
	
	
}
