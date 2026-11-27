/**
 * Proyecto: GestionReservasHotel_Swing
 * Autor: Samuel Romero Aguilera
 * Curso: 2ºDAM
 * Fecha 27 nov 2026
 */
package swing_c_p02;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

/**
 * Panel con los datos de la reserva.
 *
 * @author Samuel Romero Aguilera
 */
public class PanelDatosReserva extends JPanel {

	private static final long serialVersionUID = 1L;

	JComboBox<String> comboTipoHabitacion;
	JSpinner spinnerEntrada, spinnerSalida, spinnerHabitaciones;
	JTextField fieldNoches;
	GridBagConstraints gridBagConstraints;

	public PanelDatosReserva() {
		this.setLayout(new GridBagLayout());
		this.setBackground(VentanaPrincipal.COLOR_FONDO);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(VentanaPrincipal.COLOR_HEADER, 1),
				"Datos de la reserva", TitledBorder.LEFT, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), VentanaPrincipal.COLOR_HEADER));
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		Date hoy = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date manana = Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

		comboTipoHabitacion = new JComboBox<>(new String[] { "Simple", "Doble", "Suite" });

		spinnerEntrada = new JSpinner(new SpinnerDateModel(hoy, hoy, null, Calendar.DAY_OF_MONTH));
		spinnerEntrada.setEditor(new JSpinner.DateEditor(spinnerEntrada, "dd/MM/yyyy"));

		spinnerSalida = new JSpinner(new SpinnerDateModel(manana, manana, null, Calendar.DAY_OF_MONTH));
		spinnerSalida.setEditor(new JSpinner.DateEditor(spinnerSalida, "dd/MM/yyyy"));

		fieldNoches = new JTextField("1", 5);
		fieldNoches.setEditable(false);

		spinnerHabitaciones = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));

		comboTipoHabitacion.setToolTipText("Tipo de habitación (Alt+H)");
		spinnerEntrada.setToolTipText("Fecha de entrada, no anterior a hoy (Alt+E)");
		spinnerSalida.setToolTipText("Fecha de salida, posterior a la entrada (Alt+S)");
		fieldNoches.setToolTipText("Se calcula automáticamente con las fechas");
		spinnerHabitaciones.setToolTipText("Número de habitaciones, de 1 a 50 (Alt+R)");

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 8, 5, 8);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		anadirFila("Tipo de habitación:", 'H', comboTipoHabitacion, 0);
		anadirFila("Fecha de entrada:", 'E', spinnerEntrada, 1);
		anadirFila("Fecha de salida:", 'S', spinnerSalida, 2);
		anadirFila("Nº de noches:", ' ', fieldNoches, 3);
		anadirFila("Nº de habitaciones:", 'R', spinnerHabitaciones, 4);
	}


	private void anadirFila(String texto, char mnemonico, JComponent componente, int fila) {
		JLabel etiqueta = new JLabel(texto);
		if (mnemonico != ' ') {
			etiqueta.setDisplayedMnemonic(mnemonico);
			etiqueta.setLabelFor(componente);
		}

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = fila;
		gridBagConstraints.weightx = 0;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		this.add(etiqueta, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(componente, gridBagConstraints);
	}
}