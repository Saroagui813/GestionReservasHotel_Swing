/**
 * Proyecto: swing_c_p02_RomeroAguileraSamuel
 * Autor: Samuel Romero Aguilera
 * Curso: 2ºDAM
 * Fecha 26 nov 2026
 */
package swing_c_p02;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;

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
		
		JPanel panelCentro = new JPanel(new GridLayout(1, 2, 10, 0));
		panelCentro.setOpaque(false);
		panelCentro.add(new PanelDatosCliente());
		panelCentro.add(new PanelDatosReserva());
		this.getContentPane().add(panelCentro, BorderLayout.CENTER);

		this.setTitle("Alta Reservas");
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocation(0, 0);
		this.setLocationRelativeTo(ventanaPrincipal);
	}
}

