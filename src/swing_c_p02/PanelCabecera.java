/**
 * Proyecto: swing_c_p02_RomeroAguileraSamuel
 * Autor: Samuel Romero Aguilera
 * Curso: 2ºDAM
 * Fecha 26 nov 2026
 */
package swing_c_p02;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Descripcion de la clase PanelCabecera:
 * Conttiene el nombre del hotel y se le pone un color de fondo
 * 
 * @author Samuel Romero Aguilera
 */
public class PanelCabecera extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel labelNombreHotel = new JLabel("Hotel Sol Y Luna");

	public PanelCabecera() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
		this.setBackground(VentanaPrincipal.COLOR_HEADER);
		labelNombreHotel.setFont(new Font("Georgia", Font.BOLD, 28));
		labelNombreHotel.setForeground(VentanaPrincipal.COLOR_LETRA);
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(VentanaPrincipal.COLOR_LETRA, 2)));
		labelNombreHotel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/recursos/icono.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		labelNombreHotel.setIconTextGap(12);
		this.add(labelNombreHotel);
	}
}
