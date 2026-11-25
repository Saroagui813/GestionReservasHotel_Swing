/**
 * Proyecto: swing_c_p02_RomeroAguileraSamuel
 * Autor: Samuel Romero Aguilera
 * Curso: 2ºDAM
 * Fecha 25 nov 2026
 */
package swing_c_p02;

import javax.swing.SwingUtilities;

/**
 * Descripcion de la clase Main
 * 
 * @author Samuel Romero Aguilera
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.setLocationRelativeTo(null);
			ventanaPrincipal.setVisible(true);
		});
	}

}
