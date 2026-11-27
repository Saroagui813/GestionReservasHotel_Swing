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
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Panel con los datos de la reserva.
 *
 * @author Samuel Romero Aguilera
 */
public class PanelDatosReserva extends JPanel {

	private static final long serialVersionUID = 1L;

	JComboBox<String> comboTipoHabitacion;
	JCheckBox checkNinos;
	JPanel panelExtraNinosJPanel;
	JSpinner spinnerEntrada, spinnerSalida, spinnerHabitaciones, spinnerEdad;
	JTextField fieldNoches, fieldExtraNinos;
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

		spinnerEntrada = new JSpinner(new SpinnerDateModel(hoy, null, null, Calendar.DAY_OF_MONTH));
		spinnerEntrada.setEditor(new JSpinner.DateEditor(spinnerEntrada, "dd/MM/yyyy"));

		spinnerSalida = new JSpinner(new SpinnerDateModel(manana, null, null, Calendar.DAY_OF_MONTH));
		spinnerSalida.setEditor(new JSpinner.DateEditor(spinnerSalida, "dd/MM/yyyy"));

		fieldNoches = new JTextField("1", 5);
		fieldNoches.setEditable(false);

		spinnerHabitaciones = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));

		comboTipoHabitacion.setToolTipText("Tipo de habitación (Alt+H)");
		spinnerEntrada.setToolTipText("Fecha de entrada, no anterior a hoy (Alt+E)");
		spinnerSalida.setToolTipText("Fecha de salida, posterior a la entrada (Alt+S)");
		fieldNoches.setToolTipText("Se calcula automáticamente con las fechas");
		spinnerHabitaciones.setToolTipText("Número de habitaciones, de 1 a 50 (Alt+R)");

		checkNinos = new JCheckBox("¿Niños?");
		checkNinos.setMnemonic(KeyEvent.VK_O);
		checkNinos.setBackground(VentanaPrincipal.COLOR_FONDO);
		checkNinos.setToolTipText("Marcar si hay niños en la reserva (Alt+O)");
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 8, 5, 8);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		anadirFila("Tipo de habitación:", 'H', comboTipoHabitacion, 0);
		anadirFila("Fecha de entrada:", 'E', spinnerEntrada, 1);
		anadirFila("Fecha de salida:", 'S', spinnerSalida, 2);
		anadirFila("Nº de noches:", ' ', fieldNoches, 3);
		anadirFila("Nº de habitaciones:", 'R', spinnerHabitaciones, 4);
		
		GestorFechas gestorFechas = new GestorFechas();
		spinnerEntrada.addChangeListener(gestorFechas);
		spinnerSalida.addChangeListener(gestorFechas);
		
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
	
	private LocalDate obtenerFecha(JSpinner spinner) {
		Date fecha = (Date) spinner.getValue();
		return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	private void calcularNoches() {
		LocalDate entrada = obtenerFecha(spinnerEntrada);
		LocalDate salida = obtenerFecha(spinnerSalida);

		if (entrada.isBefore(LocalDate.now()) || !salida.isAfter(entrada)) {
			fieldNoches.setText("");
		} else {
			fieldNoches.setText(String.valueOf(ChronoUnit.DAYS.between(entrada, salida)));
		}
	}
	
	private class GestorFechas implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			calcularNoches();
		}
	}
}