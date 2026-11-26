/**
 * Proyecto: swing_c_p02_RomeroAguileraSamuel
 * Autor: Samuel Romero Aguilera
 * Curso: 2ºDAM
 * Fecha: 25 nov 2026
 */
package swing_c_p02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * Descripcion de la clase VentanaPrincipal:
 * En esta clase añadiremos la barra de menu y los botones 
 * 
 * @author Samuel Romero Aguilera
 */
public class VentanaPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public static final Color COLOR_HEADER = new Color(26, 58, 92);
	public static final Color COLOR_LETRA = new Color(200, 160, 0);
	public static final Color COLOR_ROJO_BOTON= new Color(150, 50, 33);
	public static final Color COLOR_FONDO  = new Color(222, 211, 202);
	
	JMenuBar barraSuperior;
	JMenu menuArchivo, menuRegistro, menuAyuda;
	JMenuItem itemAbrir, itemGuardar, itemSalir, itemAltaReservas, itemBajaReservas, itemAcercaDe;
	
	JPanel panelBotones;
	JButton botonAltaReservas, botonBajaReservas;
		
	public VentanaPrincipal() {
		super("Gestión Hotel Sol Y Luna");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource("/recursos/icono.png")).getImage());
		this.getContentPane().add(new PanelCabecera(), BorderLayout.NORTH);
		iniciarComponentes();
		this.pack();
		this.setMinimumSize(getSize());
	}
	
	private void iniciarComponentes() {
		crearMenu();
		crearBotones();
	}
	
	private void crearMenu() {
		
		barraSuperior = new JMenuBar();
		
		menuArchivo = new JMenu("Archivo");
		menuRegistro = new JMenu("Registro");
		menuAyuda = new JMenu("Ayuda");

		itemAbrir = new JMenuItem("Abrir");
		itemGuardar = new JMenuItem("Guardar");
		itemSalir = new JMenuItem("Salir");
		
		itemAltaReservas = new JMenuItem("Alta Reservas");
		itemBajaReservas = new JMenuItem("Baja Reservas");
		
		itemAcercaDe = new JMenuItem("Acerca de...");
		
		itemAltaReservas.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/recursos/nuevo.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
		itemBajaReservas.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/recursos/eliminar.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
		
		menuArchivo.setMnemonic(KeyEvent.VK_A);
		menuRegistro.setMnemonic(KeyEvent.VK_S);
		menuAyuda.setMnemonic(KeyEvent.VK_Y);
		
		itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		
		itemAltaReservas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		itemBajaReservas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		
		itemAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		
		itemAbrir.addActionListener(e -> abrirArchivo());
		itemGuardar.addActionListener(e -> guardarArchivo());
		itemSalir.addActionListener(e -> this.dispose());
		
		itemAltaReservas.addActionListener(e -> abrirDialogoAlta());
		itemBajaReservas.addActionListener(e -> bajaNoImplementada());
		
		itemAcercaDe.addActionListener(e -> dialogoAcercaDe());
		
		barraSuperior.add(menuArchivo);
		barraSuperior.add(menuRegistro);
		barraSuperior.add(menuAyuda);
		
		menuArchivo.add(itemAbrir);
		menuArchivo.add(itemGuardar);
		menuArchivo.addSeparator();
		menuArchivo.add(itemSalir);
		
		menuRegistro.add(itemAltaReservas);
		menuRegistro.add(itemBajaReservas);
		
		menuAyuda.add(itemAcercaDe);
		
		this.setJMenuBar(barraSuperior);
	}
	
	private void abrirArchivo() {
		JFileChooser selector = new JFileChooser();
		selector.setDialogTitle("Abrir archivo");
		int resultado = selector.showOpenDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivo = selector.getSelectedFile();
			System.out.println("Archivo seleccionado: " + archivo.getAbsolutePath());
		}
	}
	
	private void guardarArchivo() {
		JFileChooser selector = new JFileChooser();
		selector.setDialogTitle("Guardar archivo");
        selector.setSelectedFile(new File("reservas.txt"));
        int resultado = selector.showSaveDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivo = selector.getSelectedFile();
			System.out.println("Guardar como: " + archivo.getAbsolutePath());
		}
	}
	
	private void abrirDialogoAlta() {
		AltaReservas dialogoAlta = new AltaReservas(this, true);
		dialogoAlta.setVisible(true);
	}
	
	private void bajaNoImplementada() {
	    JOptionPane.showMessageDialog(this, "Funcionalidad no implementada todavía");
	}
	
	private void dialogoAcercaDe() {
		JOptionPane.showMessageDialog(this,
				"Hecho por: Samuel Romero Aguilera\n"
				+ "Proyecto: Gestion de Reservas de hotel\n"
				+ "Curso: 2ºDAM\n"
				+ "Módulo: Desarrollo de interfaces"
		);
	}
	
	private void crearBotones() {
		botonAltaReservas = new JButton("Alta Reservas");
		botonBajaReservas = new JButton("Baja Reservas");
		
		botonAltaReservas.setForeground(Color.WHITE);
		botonBajaReservas.setForeground(Color.WHITE);
		botonAltaReservas.setBackground(COLOR_HEADER);
		botonBajaReservas.setBackground(COLOR_ROJO_BOTON);
		botonAltaReservas.setPreferredSize(new Dimension(200, 60));
		botonBajaReservas.setPreferredSize(new Dimension(200, 60));
		botonAltaReservas.setBorderPainted(false);
		botonBajaReservas.setBorderPainted(false);
		
		botonAltaReservas.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/recursos/nuevo.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		botonAltaReservas.setIconTextGap(8);
		botonBajaReservas.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/recursos/eliminar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		botonBajaReservas.setIconTextGap(8);
		
		botonAltaReservas.setMnemonic(KeyEvent.VK_N);
		botonBajaReservas.setMnemonic(KeyEvent.VK_D);
		botonAltaReservas.setToolTipText("Abrir el formulario de alta de reservas (Ctrl+N)");
		botonBajaReservas.setToolTipText("Abrir el formulario de alta de reservas (Ctrl+D)");
		
		botonAltaReservas.addActionListener(e -> abrirDialogoAlta());
		botonBajaReservas.addActionListener(e -> bajaNoImplementada());
		
		panelBotones = new JPanel();
	    panelBotones.setBackground(COLOR_FONDO);
		panelBotones.add(botonAltaReservas);
		panelBotones.add(botonBajaReservas);
		
		this.getContentPane().setBackground(COLOR_FONDO);
	    this.getContentPane().add(panelBotones);
		
		this.getRootPane().setDefaultButton(botonAltaReservas);
	}
	
}
