/**
 * Proyecto: swing_c_p02_RomeroAguileraSamuel
 * Autor: Samuel Romero Aguilera
 * Curso: 2ºDAM
 * Fecha 26 nov 2026
 */
package swing_c_p02;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Descripcion de la clase PanelDatosCliente
 * 
 * @author Samuel Romero Aguilera
 */
public class PanelDatosCliente extends JPanel {
	
	private static final long serialVersionUID = 1L;
	JLabel labelNombre, labelApellidos, labelDni, labelTelefono;
	JTextField fieldNombre, fieldApellidos, fieldDni, fieldTelefono;
	GridBagConstraints gridBagConstraints;
	
	public PanelDatosCliente() {
		this.setLayout(new GridBagLayout());
		this.setBackground(VentanaPrincipal.COLOR_FONDO);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(VentanaPrincipal.COLOR_HEADER, 1),
				"Datos del cliente", TitledBorder.LEFT, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), VentanaPrincipal.COLOR_HEADER));
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		labelNombre = new JLabel("Nombre: ");
		labelApellidos = new JLabel("Apellidos: ");
		labelDni = new JLabel("Dni: ");
		labelTelefono = new JLabel("Telefono: ");
		
		fieldNombre = new JTextField(20);
		fieldApellidos = new JTextField(20);
		fieldDni = new JTextField(20);
		fieldTelefono = new JTextField(20);
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 8, 5, 8);
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		
		anadirFila(labelNombre, fieldNombre, 0);
		anadirFila(labelApellidos, fieldApellidos, 1);
		anadirFila(labelDni, fieldDni, 2);
		anadirFila(labelTelefono, fieldTelefono, 3);
	}
	
	private void anadirFila(JLabel etiqueta, JTextField texto, int fila) {
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = fila;
		gridBagConstraints.weightx = 0;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		this.add(etiqueta, gridBagConstraints);
		
		gridBagConstraints.gridx = 1;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(texto, gridBagConstraints);
	}
	
}
