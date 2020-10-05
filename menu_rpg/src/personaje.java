import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class personaje {
	
	Tienda productos = new Tienda();
	
	public int monedas_actuales = 300;
	
	public int defensa = 10;
	public int ataque = 10;
	public int velocidad_movimiento = 10;
	public int mana = 10;
	public int velocidad_ataque = 10;
	
	public JScrollPane invenpane;
	
	public DefaultListModel<String> model_inv;
	public JList<String> inventario;
	
	
	public JScrollPane equippane;
	
	public DefaultListModel<String> model_equip;
	public JList<String> equipados;
	
	public personaje() {
		
		model_inv = new DefaultListModel<String>();
	
		inventario = new JList<String>(model_inv);
		inventario.setBackground(Color.black);
		inventario.setForeground(Color.white);
	
		invenpane = new JScrollPane(inventario);
		invenpane.setBounds(5, 5, 176, 115);
		
		
		model_equip = new DefaultListModel<String>();
		
		
		equipados = new JList<String>(model_equip);
		equipados.setBackground(Color.black);
		equipados.setForeground(Color.white);
		

		equippane = new JScrollPane(equipados);
		equippane.setBounds(180, 5, 176, 115);
		
		
	}
}
