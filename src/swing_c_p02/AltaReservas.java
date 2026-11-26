/**
 * Proyecto: swing_c_p02_RomeroAguileraSamuel
 * Autor: Samuel Romero Aguilera
 * Curso: 2ºDAM
 * Fecha 26 nov 2026
 */
package swing_c_p02;

import java.awt.BorderLayout;

import javax.swing.JDialog;

/**
 * Descripcion de la clase DialogoAlta
 * 
 * @author Samuel Romero Aguilera
 */
public class AltaReservas extends JDialog {
	 
	private static final long serialVersionUID = 1L;

	public AltaReservas(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal, modal);
		this.setTitle("Alta De Reservas");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(VentanaPrincipal.COLOR_FONDO);
		this.getContentPane().add(new PanelCabecera(), BorderLayout.NORTH);
		this.getContentPane().add(new PanelDatosCliente(), BorderLayout.CENTER);
		this.setSize(600, 400);
		this.setLocationRelativeTo(ventanaPrincipal);
	}
}

