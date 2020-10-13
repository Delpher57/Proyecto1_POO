
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;


public class GUI {
	
	// definiendo lo necesario
	musica music = new musica();
	personaje stats = new personaje();
	cangrejo vendedor = new cangrejo();
	Tienda productos = new Tienda();
	
	
	
	
	private JButton bot_comprar; //botones
	private JButton bot_vender;
	private JButton bot_equip;
	private JButton bot_desequip;
	
	private JLabel monedas; //monedas del jugador
	private JLabel descripcion;
	private JLabel estadisticas;
	private JLabel informacion;
	private JLabel error1;
	private JLabel error2;
	
	private JLabel cuad1; //los labels de imagenes
	private JLabel cuad2;
	private JLabel cuad3;
	private JLabel cuad4;
	
	private JPanel pan1; //los paneles que van sobre cada imagen
	private JPanel pan2;
	private JPanel pan3;
	private JPanel pan4;
	
	
	private JFrame frame; //ventana y panel principal
	private JPanel panel;

	
	
	public GUI() {
		
		frame = new JFrame(); //definir la ventana

		music.playSound(); // poner la musica
		

		
		// aqui cargo todas las imagenes que conforman el fondo
		ImageIcon tab1 = new ImageIcon(this.getClass().getResource("recursos/tab1.png"));
		ImageIcon tab2 = new ImageIcon(this.getClass().getResource("recursos/tab2.png"));
		ImageIcon tab3 = new ImageIcon(this.getClass().getResource("recursos/tab3.png"));
		ImageIcon icon = new ImageIcon(this.getClass().getResource("recursos/perco.gif"));
		ImageIcon comprar = new ImageIcon(this.getClass().getResource("recursos/comprar.png"));
		ImageIcon vender = new ImageIcon(this.getClass().getResource("recursos/vender.png"));
		ImageIcon yatiene = new ImageIcon(this.getClass().getResource("recursos/yatiene.png"));
		ImageIcon noalcanza = new ImageIcon(this.getClass().getResource("recursos/no alcanza.png"));
		ImageIcon equipar = new ImageIcon(this.getClass().getResource("recursos/equipar.png"));
		ImageIcon desequipar = new ImageIcon(this.getClass().getResource("recursos/desequipar.png"));
		
		bot_equip = new JButton(equipar);
		bot_equip.setBackground(Color.white);
		bot_equip.setBounds(16, 120, 105, 45);
		
		bot_desequip = new JButton(desequipar);
		bot_desequip.setBackground(Color.white);
		bot_desequip.setBounds(240, 120, 105, 45);
		
		//boton de comprar
		bot_comprar = new JButton(comprar);
		bot_comprar.setBackground(Color.white);
		bot_comprar.setBounds(16, 170, 105, 45);
		
		//boton de vender
		bot_vender = new JButton(vender);
		bot_vender.setBackground(Color.white);
		bot_vender.setBounds(240, 170, 105, 45);
		
		
		//preparando los labels de texto
		monedas = new JLabel("$" + stats.monedas_actuales);
		monedas.setBounds(157,170,105,45);
		monedas.setForeground(Color.white);
		monedas.setFont(new Font("Sans", Font.BOLD, 20));
		
		//preparo la plantilla para los stats de cada objeto
		descripcion = new JLabel("<html>Nombre: <br/>Tipo: <br/>Precio: <br/>Stats: </html>");
		descripcion.setBounds(10,10,350,65);
		descripcion.setForeground(Color.white);
		
		
		informacion = new JLabel("Inventario                                         Equipados");
		informacion.setBounds(10,80,350,100);
		informacion.setForeground(Color.white);
		
		//preparo la plantilla para los stats de cada objeto
		estadisticas = new JLabel("");
		cambiar_stats();
		estadisticas.setBounds(5,150,350,100);
		estadisticas.setForeground(Color.white);
		

		

		
		// esto detecta los click en la lista (tienda) para mostrar los stats
		
		vendedor.tienda.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	vendedor.tienda = (JList)evt.getSource();
		    	
		        if (evt.getClickCount() == 1) {
		        	
		        	if (productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getCategoria().equals("Ataque")) {
		        		estadisticas.setText("<html>Defensa: " + stats.defensa +
			    				"<br/>Ataque: "+ stats.ataque + "<font color='00FFFF'> + " + productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getAumentoStat() + "<font color='white'>" +
			    				"<br/>Velocidad de movimiento: "+ stats.velocidad_movimiento +
			    				"<br/>Velocidad de ataque: "+ stats.velocidad_ataque + "<font color='00FFFF'> + " + productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getAumentoStat()/10 + "<font color='white'>" +
			    				"<br/>Mana: "+ stats.mana +
			    				"</html>");
				  		}
			  		
			  		else if (productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getCategoria().equals("Defensa")) {
			  			estadisticas.setText("<html>Defensa: " + stats.defensa + "<font color='00FFFF'> + " + productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getAumentoStat() + "<font color='white'>" +
			    				"<br/>Ataque: "+ stats.ataque +
			    				"<br/>Velocidad de movimiento: "+ stats.velocidad_movimiento +
			    				"<br/>Velocidad de ataque: "+ stats.velocidad_ataque +
			    				"<br/>Mana: "+ stats.mana + "<font color='00FFFF'> + " + productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getAumentoStat()/10 + "<font color='white'>" +
			    				"</html>");
				  		}
			  		else if (productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getCategoria().equals("Velocidad")) {
			  			estadisticas.setText("<html>Defensa: " + stats.defensa +
			    				"<br/>Ataque: "+ stats.ataque +
			    				"<br/>Velocidad de movimiento: "+ stats.velocidad_movimiento + "<font color='00FFFF'> + " + productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getAumentoStat() + "<font color='white'>" +
			    				"<br/>Velocidad de ataque: "+ stats.velocidad_ataque +
			    				"<br/>Mana: "+ stats.mana +
			    				"</html>");
				  		
				  		}
			  		
			  		else {
			  			System.out.println("no se leyo nada");}
		        	
		        	
			  			
		        	descripcion.setText("<html>Nombre: " + productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getNombreArtefacto() + 
		        			"<br/>Tipo: " + productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getCategoria() + 
		        			"<br/>Precio: " + productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getPrecio()
		        			+ "<br/>Stats: +" + productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getAumentoStat() +"</html>" );
		        	
		        	music.cling();
     
		        } 
		    }});
		
		
		
		
		
		
		// esto detecta los click en el inventario para mostrar los stats
		
				stats.inventario.addMouseListener(new MouseAdapter() {
				    public void mouseClicked(MouseEvent evt) {
				    	vendedor.tienda = (JList)evt.getSource();
				        if (evt.getClickCount() == 1) {
				        	
				        	int n = 0;
				        	while (n < productos.numeroArtefactos) {
					  			
					  			
					  			
					  			
						  		if (productos.arregloArtefactos[n].getNombreArtefacto().toString().equals(stats.inventario.getSelectedValue().toString())) {
						  			
						  			break;
						  			}
					  		n++;
					  		}
				        	
				        	if (stats.model_equip.contains(stats.inventario.getSelectedValue())) {
				        		cambiar_stats();
				        	}else {
				        	
				        	if (productos.arregloArtefactos[n].getCategoria().equals("Ataque")) {
				        		estadisticas.setText("<html>Defensa: " + stats.defensa +
					    				"<br/>Ataque: "+ stats.ataque + "<font color='00FFFF'> + " + productos.arregloArtefactos[n].getAumentoStat() + "<font color='white'>" +
					    				"<br/>Velocidad de movimiento: "+ stats.velocidad_movimiento +
					    				"<br/>Velocidad de ataque: "+ stats.velocidad_ataque + "<font color='00FFFF'> + " + productos.arregloArtefactos[n].getAumentoStat()/10 + "<font color='white'>" +
					    				"<br/>Mana: "+ stats.mana +
					    				"</html>");
						  		}
					  		
					  		else if (productos.arregloArtefactos[n].getCategoria().equals("Defensa")) {
					  			estadisticas.setText("<html>Defensa: " + stats.defensa + "<font color='00FFFF'> + " + productos.arregloArtefactos[n].getAumentoStat() + "<font color='white'>" +
					    				"<br/>Ataque: "+ stats.ataque +
					    				"<br/>Velocidad de movimiento: "+ stats.velocidad_movimiento +
					    				"<br/>Velocidad de ataque: "+ stats.velocidad_ataque +
					    				"<br/>Mana: "+ stats.mana + "<font color='00FFFF'> + " + productos.arregloArtefactos[n].getAumentoStat()/10 + "<font color='white'>" +
					    				"</html>");
						  		}
					  		else if (productos.arregloArtefactos[n].getCategoria().equals("Velocidad")) {
					  			estadisticas.setText("<html>Defensa: " + stats.defensa +
					    				"<br/>Ataque: "+ stats.ataque +
					    				"<br/>Velocidad de movimiento: "+ stats.velocidad_movimiento + "<font color='00FFFF'> + " + productos.arregloArtefactos[n].getAumentoStat() + "<font color='white'>" +
					    				"<br/>Velocidad de ataque: "+ stats.velocidad_ataque +
					    				"<br/>Mana: "+ stats.mana +
					    				"</html>");
						  		
						  		}
					  		
					  		else {
					  			System.out.println("no se leyo nada");
					  		}}
				        	
				        	
				        	
				        	
				        	
				        	descripcion.setText("<html>Nombre: " + productos.arregloArtefactos[n].getNombreArtefacto() + 
				        			"<br/>Tipo: " + productos.arregloArtefactos[n].getCategoria() + 
				        			"<br/>Precio: " + productos.arregloArtefactos[n].getPrecio()
				        			+ "<br/>Stats: +" + productos.arregloArtefactos[n].getAumentoStat() +"</html>" );
				        	
				        	music.cling();
		     
				        } 
				    }});
				
		
		
		
		//funcionamiento de boton comprar
		bot_comprar.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	    
		    try {
		        
		        if (stats.model_inv.contains(vendedor.tienda.getSelectedValue())) {
		        	//detectando si se tiene el item para mandar el mensaje
		        	
		        	music.error();
		        	error1.setBounds(10, 10, 155, 105);
		        	error2.setBounds(10, 10, 600, 600);
		        	
		        	
		        }
		        else if (stats.monedas_actuales < productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getPrecio())
		        {
		        	//detectando si se tiene la plata necesaria
		        	
		        	music.error();
		        	error2.setBounds(10, 10, 155, 105);
		        	error1.setBounds(10, 10, 600, 600);
		        	
		        	
		        }
		        else {
		        	stats.model_inv.addElement((String) vendedor.tienda.getSelectedValue()); //añadimos el item al inventario
		        	stats.monedas_actuales = stats.monedas_actuales - productos.arregloArtefactos[vendedor.tienda.getSelectedIndex()].getPrecio(); //restamos el precio
		        	monedas.setText("$" + stats.monedas_actuales);
		        	error1.setBounds(10, 10, 600, 600); // eliminamos el mensaje de error
		        	error2.setBounds(10, 10, 600, 600);
		        	music.comprado();
		        }
		    
	      }catch(Exception ex) {
			        System.out.println("error al comprar " + ex);
			    }
		      }
		    });
		
		
		
		
		//funcionamiento de boton vender
		bot_vender.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    
		    	
		    try {
		    	error1.setBounds(10, 10, 600, 600);  
		    	error2.setBounds(10, 10, 600, 600);
		    	int n=0;
		    	
		    	
		    	//para sacar el indice del item seleccionado y calcular su precio
		  		while (n< productos.numeroArtefactos) {
		  			
		  			
		  			
		  			
			  		if (productos.arregloArtefactos[n].getNombreArtefacto().toString().equals(stats.inventario.getSelectedValue().toString())) {
			  			
			  			break;
			  			}
		  		n++;
		  		}
		  		if (stats.model_equip.contains(stats.inventario.getSelectedValue().toString())) {
		  			if (productos.arregloArtefactos[n].getCategoria().equals("Ataque")) {
				  		stats.ataque -= productos.arregloArtefactos[n].getAumentoStat();
				  		stats.velocidad_ataque -= productos.arregloArtefactos[n].getAumentoStat()/10;
				  		System.out.println(stats.ataque + " ataque");
				  		}
			  		
			  		else if (productos.arregloArtefactos[n].getCategoria().equals("Defensa")) {
				  		stats.defensa -=  productos.arregloArtefactos[n].getAumentoStat();
				  		stats.mana -=  productos.arregloArtefactos[n].getAumentoStat()/10;
				  		System.out.println(stats.defensa + " defensa");
				  		}
			  		else if (productos.arregloArtefactos[n].getCategoria().equals("Velocidad")) {
				  		stats.velocidad_movimiento -=  productos.arregloArtefactos[n].getAumentoStat();
				  		
				  		}
			  		
			  		else {
			  			System.out.println("no se leyo nada");
			  		}
		  			stats.model_equip.removeElement(stats.inventario.getSelectedValue().toString());
		  		}
		  		
		  		cambiar_stats();
		  		stats.monedas_actuales = stats.monedas_actuales + productos.arregloArtefactos[n].getPrecio();

		  		monedas.setText("$" + stats.monedas_actuales);
		    	
		        stats.model_inv.removeElement(stats.inventario.getSelectedValue());
		        
		        music.comprado();
		      
		      }catch(Exception ex) {
			        System.out.println("error al vender " + ex);
			    } }
		    });
		
		
		//funcionamiento de boton equipar
				bot_equip.addActionListener(new ActionListener() {
				      public void actionPerformed(ActionEvent e) {
				    	    
				    try {
				    	
				    	if (stats.model_equip.contains(stats.inventario.getSelectedValue())) {
				        	//detectando si se tiene el item para mandar el mensaje
				        	
				        	music.error();

				        	
				        	
				        }else {
				    	int n=0;
				    	
				    	
				    	//para sacar el indice del item seleccionado y calcular su precio
				  		while (n < productos.numeroArtefactos) {
				  			
				  			
				  			
				  			
					  		if (productos.arregloArtefactos[n].getNombreArtefacto().toString().equals(stats.inventario.getSelectedValue().toString())) {
					  			
					  			break;
					  			}
				  		n++;
				  		}
				  		
				  		System.out.println(n);
				  		if (productos.arregloArtefactos[n].getCategoria().equals("Ataque")) {
					  		stats.ataque += productos.arregloArtefactos[n].getAumentoStat();
					  		stats.velocidad_ataque += productos.arregloArtefactos[n].getAumentoStat()/10;
					  		System.out.println(stats.ataque + " ataque");
					  		}
				  		
				  		else if (productos.arregloArtefactos[n].getCategoria().equals("Defensa")) {
					  		stats.defensa +=  productos.arregloArtefactos[n].getAumentoStat();
					  		stats.mana +=  productos.arregloArtefactos[n].getAumentoStat()/10;
					  		System.out.println(stats.defensa + " defensa");
					  		}
				  		else if (productos.arregloArtefactos[n].getCategoria().equals("Velocidad")) {
					  		stats.velocidad_movimiento +=  productos.arregloArtefactos[n].getAumentoStat();
					  		
					  		}
				  		
				  		else {
				  			System.out.println("no se leyo nada");
				  		}
				  		
				  		
				        stats.model_equip.addElement((String) stats.inventario.getSelectedValue());
				        cambiar_stats();
				        music.comprado();
				    
				        }}catch(Exception ex) {
					        System.out.println("error al equipar " + ex);
					    }
				      }
				    });
				
		
		//funcionamiento de boton desequipar
		bot_desequip.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    
		    	
		    try {
		    	
		    	int n=0;
		    	
		    	
		    	//para sacar el indice del item seleccionado y calcular su precio
		  		while (n< productos.numeroArtefactos) {
		  			
		  			
		  			
		  			
			  		if (productos.arregloArtefactos[n].getNombreArtefacto().toString().equals(stats.equipados.getSelectedValue().toString())) {
			  			
			  			break;
			  			}
		  		n++;
		  		}
		  		
		  		
		  		if (productos.arregloArtefactos[n].getCategoria().equals("Ataque")) {
			  		stats.ataque -= productos.arregloArtefactos[n].getAumentoStat();
			  		stats.velocidad_ataque -= productos.arregloArtefactos[n].getAumentoStat()/10;
			  		System.out.println(stats.ataque + " ataque");
			  		}
		  		
		  		else if (productos.arregloArtefactos[n].getCategoria().equals("Defensa")) {
			  		stats.defensa -=  productos.arregloArtefactos[n].getAumentoStat();
			  		stats.mana -=  productos.arregloArtefactos[n].getAumentoStat()/10;
			  		System.out.println(stats.defensa + " defensa");
			  		}
		  		else if (productos.arregloArtefactos[n].getCategoria().equals("Velocidad")) {
			  		stats.velocidad_movimiento -=  productos.arregloArtefactos[n].getAumentoStat();
			  		
			  		}
		  		
		  		else {
		  			System.out.println("no se leyo nada");
		  		}
		  		
		    	
		  		
		  		
		  		
		        stats.model_equip.removeElement(stats.equipados.getSelectedValue());
		        cambiar_stats();
		        music.comprado();
		      
		      }catch(Exception ex) {
			        System.out.println("error al desequipar " + ex);
			    } }
		    });		
				
				
		
		// aca le asigno una imagen a cada label (los 4 cuadros del menu)
		cuad1 = new JLabel(tab1);
		cuad2 = new JLabel(icon);
		cuad3 = new JLabel(tab2);
		cuad4 = new JLabel(tab3);
		
		//le añado la imagen al mensaje de ya tener items
		error1 = new JLabel(yatiene);
		error1.setBounds(10, 10, 600, 600);
		
		error2 = new JLabel(noalcanza);
		error2.setBounds(10, 10, 600, 600);
		
		
		// aca acomodo cada cuadro y le pongo su tamaño
		cuad1.setBounds(8, 8, 360, 256);
		cuad2.setBounds(376, 8, 528, 256);
		cuad3.setBounds(8, 272, 360, 232);
		cuad4.setBounds(376, 272, 528, 232);
		
		
		
		
		
		//preparo los 4 paneles del menú
		pan1 = new JPanel();
		pan1.setLayout(null);
		pan2 = new JPanel();
		pan2.setLayout(null);
		pan3 = new JPanel();
		pan3.setLayout(null);
		pan4 = new JPanel();
		pan4.setLayout(null);

		// hago los 4 paneles transparentes para no interferir con el fondo
		pan1.setOpaque(false);
		pan2.setOpaque(false);
		pan3.setOpaque(false);
		pan4.setOpaque(false);
		
		// aca acomodo los 4 paneles junto con su tamaño
		pan1.setBounds(8, 8, 360, 256);
		pan2.setBounds(376, 8, 528, 256);
		pan3.setBounds(8, 272, 360, 232);
		pan4.setBounds(376, 272, 528, 232);
		
		
		//añadir al panel 1
		pan1.add(stats.invenpane);
		pan1.add(stats.equippane);
		pan1.add(estadisticas);
		pan1.add(informacion);
		
		//añadir al panel 2
		pan2.add(error1);
		pan2.add(error2);
		
		//añadir al panel 3
		pan3.add(bot_vender);
		pan3.add(bot_comprar);
		pan3.add(bot_equip);
		pan3.add(bot_desequip);
		pan3.add(monedas);
		pan3.add(descripcion);
		
		//añadir al panel 4
		pan4.add(vendedor.tiendpane);
		
		
		
		
		// preparo el panel principal
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel.setLayout(null);
		panel.setBackground(Color.black);
		
		// añado 4 paneles al panel principal
		panel.add(pan1);
		panel.add(pan2);
		panel.add(pan3);
		panel.add(pan4);
		
		
		// añado los labels(imagenes) al panel principal
		panel.add(cuad1);
		panel.add(cuad2);
		panel.add(cuad3);
		panel.add(cuad4);
		


		// acomodo lo de la ventana
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Krabstore");
		frame.setSize(930, 550);
		frame.setVisible(true);
	}
	public void cambiar_stats() {
		estadisticas.setText("<html>Defensa: " + stats.defensa +
				"<br/>Ataque: "+ stats.ataque +
				"<br/>Velocidad de movimiento: "+ stats.velocidad_movimiento +
				"<br/>Velocidad de ataque: "+ stats.velocidad_ataque +
				"<br/>Mana: "+ stats.mana +
				"</html>");
	}
	
	public static void main(String[] args) {
		new GUI();

	}
}
