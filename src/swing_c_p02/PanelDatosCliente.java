/**
 * Proyecto: swing_c_p02_RomeroAguileraSamuel
 * Autor: Samuel Romero Aguilera
 * Curso: 2ºDAM
 * Fecha 26 nov 2026
 */
package swing_c_p02;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	
	private static final Color COLOR_VALIDO = new Color(0, 140, 0);
	private static final Color COLOR_ERROR = new Color(200, 0, 0);
	
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
		
		labelNombre.setDisplayedMnemonic('N');
		labelNombre.setLabelFor(fieldNombre);
		fieldNombre.setToolTipText("Nombre del cliente (Alt+N)");

		labelApellidos.setDisplayedMnemonic('A');
		labelApellidos.setLabelFor(fieldApellidos);
		fieldApellidos.setToolTipText("Apellidos del cliente (Alt+A)");

		labelDni.setDisplayedMnemonic('D');
		labelDni.setLabelFor(fieldDni);
		fieldDni.setToolTipText("8 dígitos y una letra, por ejemplo 12345678A (Alt+D)");

		labelTelefono.setDisplayedMnemonic('T');
		labelTelefono.setLabelFor(fieldTelefono);
		fieldTelefono.setToolTipText("9 dígitos, por ejemplo 612345678 (Alt+T)");
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 8, 5, 8);
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		
		anadirFila(labelNombre, fieldNombre, 0);
		anadirFila(labelApellidos, fieldApellidos, 1);
		anadirFila(labelDni, fieldDni, 2);
		anadirFila(labelTelefono, fieldTelefono, 3);
		
		validarAlPerderFoco(fieldNombre, ".+");
		validarAlPerderFoco(fieldApellidos, ".+");
		validarAlPerderFoco(fieldDni, "\\d{8}[A-Za-z]");
		validarAlPerderFoco(fieldTelefono, "\\d{9}");
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

	private void validarAlPerderFoco(JTextField campo, String expresion) {
		campo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (e.isTemporary()) {
					return;
				}
				boolean valido = campo.getText().trim().matches(expresion);
				marcarCampo(campo, valido);
			}
		});
	}
	
	private void marcarCampo(JTextField campo, boolean valido) {
		Color color = valido ? COLOR_VALIDO : COLOR_ERROR;
		campo.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(color, 2),
				BorderFactory.createEmptyBorder(2, 4, 2, 4)));
	}
}
