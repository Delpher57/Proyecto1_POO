import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class cangrejo {
	public JList<String> tienda;
	public JScrollPane tiendpane;
	public DefaultListModel<String> model_tiend;
	Tienda productos = new Tienda();
	
	
	
	public cangrejo() {
		
		model_tiend = new DefaultListModel<String>();
		
		//tienda
		tienda = new JList<String>(model_tiend);
		tienda.setBackground(Color.black);
		tienda.setForeground(Color.white);
		
		
		
		
		
		tiendpane = new JScrollPane(tienda);
		tiendpane.setBounds(4, 4, 520, 224);
		
		
		
		int i=0;
		while (i<productos.arregloArtefactos.length) {
		model_tiend.addElement(productos.arregloArtefactos[i].getNombreArtefacto());
		i=i+1;
		}
	}
}
