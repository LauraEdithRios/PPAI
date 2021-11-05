package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Entidades.Escuela;
import Entidades.Exposicion;
import Entidades.Sede;
import Gestores.GestorRegVisita;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.TextField;
import java.awt.Label;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class PantallaReservaVisita extends JFrame {

	private JPanel contentPane;
	private JTable tblEscuela;
	private JTextField txtCantVisitantes;
	private JTable tblExposicion;
	private JComboBox cmbSede;
	private JComboBox cmbTipoVisita;
	private JTextField txtBuscarEscuela;
	private TableRowSorter filtroEscuela;
	private TableRowSorter filtroExposicion;
	private JTextField txtBuscarExposiciones;
	private JTable tblGuias;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				PantallaReservaVisita frame = new PantallaReservaVisita();
				frame.setVisible(true);
			}
		});
	}

	public PantallaReservaVisita() {
		setTitle("Registar Visita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 161, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 32, 58, 0, 34, 47, 48, 41, 87, 0, 0, 31, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblEscuela = new JLabel("Seleccionar Escuela:");
		GridBagConstraints gbc_lblEscuela = new GridBagConstraints();
		gbc_lblEscuela.anchor = GridBagConstraints.WEST;
		gbc_lblEscuela.insets = new Insets(0, 0, 5, 5);
		gbc_lblEscuela.gridx = 1;
		gbc_lblEscuela.gridy = 0;
		contentPane.add(lblEscuela, gbc_lblEscuela);

		JScrollPane scrollPane = new JScrollPane();

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		tblEscuela = new JTable();
		tblEscuela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// funcionalidad q manda al gestor la escuela seleccionada
				int filaSeleccionada = tblEscuela.getSelectedRow();
				GestorRegVisita.tomarSeleccionEscuela(tblEscuela.getValueAt(filaSeleccionada, 0));
			}
		});
		tblEscuela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "Nombre"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblEscuela.getColumnModel().getColumn(0).setPreferredWidth(0);
		tblEscuela.getColumnModel().getColumn(0).setMinWidth(0);
		tblEscuela.getColumnModel().getColumn(0).setMaxWidth(0);
		scrollPane.setViewportView(tblEscuela);

		// funcionalidad para mostrar las escuelas en la tablaEscuelas.
		DefaultTableModel modelo = (DefaultTableModel) tblEscuela.getModel();

		for (Escuela a : GestorRegVisita.buscarEscuela()) {
			Object vector[] = new Object[2];
			vector[0] = a;
			vector[1] = a.getNombre();

			modelo.addRow(vector);

		}
		
		txtBuscarEscuela = new JTextField();
		txtBuscarEscuela.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				filtrarTablaEscuela(txtBuscarEscuela.getText());
			}
		});
		GridBagConstraints gbc_txtBuscarEscuela = new GridBagConstraints();
		gbc_txtBuscarEscuela.gridwidth = 2;
		gbc_txtBuscarEscuela.insets = new Insets(0, 0, 5, 5);
		gbc_txtBuscarEscuela.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBuscarEscuela.gridx = 1;
		gbc_txtBuscarEscuela.gridy = 2;
		contentPane.add(txtBuscarEscuela, gbc_txtBuscarEscuela);
		txtBuscarEscuela.setColumns(10);

		JLabel lblCantVisitantes = new JLabel("Ingresar Cant. de Visitantes:");
		GridBagConstraints gbc_lblCantVisitantes = new GridBagConstraints();
		gbc_lblCantVisitantes.anchor = GridBagConstraints.WEST;
		gbc_lblCantVisitantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantVisitantes.gridx = 1;
		gbc_lblCantVisitantes.gridy = 3;
		contentPane.add(lblCantVisitantes, gbc_lblCantVisitantes);

		txtCantVisitantes = new JTextField();
		
		GridBagConstraints gbc_txtCantVisitantes = new GridBagConstraints();
		gbc_txtCantVisitantes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCantVisitantes.insets = new Insets(0, 0, 5, 5);
		gbc_txtCantVisitantes.gridx = 2;
		gbc_txtCantVisitantes.gridy = 3;
		contentPane.add(txtCantVisitantes, gbc_txtCantVisitantes);
		txtCantVisitantes.setColumns(10);

		JLabel lblSede = new JLabel("Seleccionar Sede:");
		GridBagConstraints gbc_lblSede = new GridBagConstraints();
		gbc_lblSede.anchor = GridBagConstraints.WEST;
		gbc_lblSede.insets = new Insets(0, 0, 5, 5);
		gbc_lblSede.gridx = 1;
		gbc_lblSede.gridy = 4;
		contentPane.add(lblSede, gbc_lblSede);

		cmbTipoVisita = new JComboBox();
		cmbTipoVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//funcionalidad para cargar la TABBLA de EXPOSICIONESSSS QUE SON VIGENTES
				if(cmbTipoVisita.getSelectedIndex() > -1) {
					String x = cmbTipoVisita.getSelectedItem().toString();
					if ( x.equals("Por Exposición") ) {

						GestorRegVisita.tomarSeleccionTipoVisita(cmbTipoVisita.getSelectedItem());
						DefaultTableModel modelo1 = (DefaultTableModel) tblExposicion.getModel();
						GestorRegVisita.buscarExposicionesVigentes();
						for (Exposicion a : GestorRegVisita.getExposicionesVIGENTES()) {
							Object vector[] = new Object[5];
							vector[0] = a;
							vector[1] = a.getNombre();
							vector[2] = a.getPublicoDestino();
							vector[3] = "Inicio: " + a.getHoraApertura() + "-" + "Fin: " + a.getHoraCierre();
							vector[4] = false;
							modelo1.addRow(vector); }
						
					}
				}
				
			}
		});

		cmbSede = new JComboBox();
		GridBagConstraints gbc_cmbSede = new GridBagConstraints();
		gbc_cmbSede.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSede.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSede.gridx = 2;
		gbc_cmbSede.gridy = 4;
		contentPane.add(cmbSede, gbc_cmbSede);

		cargarCombo(cmbSede, GestorRegVisita.buscarSede());// funcionalidad que carga el comboSede

		cmbSede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionClickComboSede();

			}
		});
		
		contentPane.add(cmbSede, gbc_cmbSede);

		GridBagConstraints gbc_cmbTipoVisita = new GridBagConstraints();
		gbc_cmbTipoVisita.insets = new Insets(0, 0, 5, 5);
		gbc_cmbTipoVisita.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoVisita.gridx = 2;
		gbc_cmbTipoVisita.gridy = 5;
		contentPane.add(cmbTipoVisita, gbc_cmbTipoVisita);

		JLabel lblNewLabel = new JLabel("Seleccionar Tipo Visita:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Selecionar Exposicion:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 7;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		tblExposicion = new JTable();
		
		tblExposicion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "Exposicion", "Publico", "Horario", "Seleccionar"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblExposicion.getColumnModel().getColumn(0).setPreferredWidth(0);
		tblExposicion.getColumnModel().getColumn(0).setMinWidth(0);
		tblExposicion.getColumnModel().getColumn(0).setMaxWidth(0);
		scrollPane_1.setViewportView(tblExposicion);
		
		txtBuscarExposiciones = new JTextField();
		txtBuscarExposiciones.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				filtrarTablaExposicion(txtBuscarExposiciones.getText());
			}
		});
		GridBagConstraints gbc_txtBuscarExposiciones = new GridBagConstraints();
		gbc_txtBuscarExposiciones.gridwidth = 2;
		gbc_txtBuscarExposiciones.insets = new Insets(0, 0, 5, 5);
		gbc_txtBuscarExposiciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBuscarExposiciones.gridx = 1;
		gbc_txtBuscarExposiciones.gridy = 8;
		contentPane.add(txtBuscarExposiciones, gbc_txtBuscarExposiciones);
		txtBuscarExposiciones.setColumns(10);
		
		JButton btnGuardarSeleccion = new JButton("Guardar Selecci\u00F3n");
		btnGuardarSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obtetenerExposicionesSelccionadas();
				GestorRegVisita.calcularDuracionEstimada();
			}
		});
		GridBagConstraints gbc_btnGuardarSeleccion = new GridBagConstraints();
		gbc_btnGuardarSeleccion.gridwidth = 2;
		gbc_btnGuardarSeleccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarSeleccion.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarSeleccion.gridx = 1;
		gbc_btnGuardarSeleccion.gridy = 9;
		contentPane.add(btnGuardarSeleccion, gbc_btnGuardarSeleccion);
		
		JLabel lblNewLabel_2 = new JLabel("Ingresar Fecha Reserva: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 10;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JDateChooser dcFechaReserva = new JDateChooser();
		GridBagConstraints gbc_dcFechaReserva = new GridBagConstraints();
		gbc_dcFechaReserva.insets = new Insets(0, 0, 5, 5);
		gbc_dcFechaReserva.fill = GridBagConstraints.BOTH;
		gbc_dcFechaReserva.gridx = 2;
		gbc_dcFechaReserva.gridy = 10;
		contentPane.add(dcFechaReserva, gbc_dcFechaReserva);
		
		Label label = new Label("Ingresar Hora Reserva:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 11;
		contentPane.add(label, gbc_label);
		
		TextField txtHoraReserva = new TextField();
		GridBagConstraints gbc_txtHoraReserva = new GridBagConstraints();
		gbc_txtHoraReserva.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoraReserva.insets = new Insets(0, 0, 5, 5);
		gbc_txtHoraReserva.gridx = 2;
		gbc_txtHoraReserva.gridy = 11;
		contentPane.add(txtHoraReserva, gbc_txtHoraReserva);
		accionClickComboSede();
		filtroEscuela = new TableRowSorter(tblEscuela.getModel());
		tblEscuela.setRowSorter(filtroEscuela);
		filtroExposicion = new TableRowSorter(tblExposicion.getModel());
		tblExposicion.setRowSorter(filtroExposicion);
		
		JButton btnObtenerGuias = new JButton("Obtener Guias Disponibles");
		btnObtenerGuias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//funcionalidad q obtiene lo que ingreso en el campo de fecha y hora de reserva
			
				
				GestorRegVisita.tomarFechaReserva();//hacerloooo
				GestorRegVisita.tomarHoraReserva();
				
				
				
				
				
			}
		});
		GridBagConstraints gbc_btnObtenerGuias = new GridBagConstraints();
		gbc_btnObtenerGuias.anchor = GridBagConstraints.WEST;
		gbc_btnObtenerGuias.insets = new Insets(0, 0, 5, 5);
		gbc_btnObtenerGuias.gridx = 1;
		gbc_btnObtenerGuias.gridy = 12;
		contentPane.add(btnObtenerGuias, gbc_btnObtenerGuias);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1_1 = new GridBagConstraints();
		gbc_scrollPane_1_1.gridwidth = 2;
		gbc_scrollPane_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1_1.gridx = 1;
		gbc_scrollPane_1_1.gridy = 13;
		contentPane.add(scrollPane_1_1, gbc_scrollPane_1_1);
		
		tblGuias = new JTable();
		tblGuias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "Nombre", "Seleccionar"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblGuias.getColumnModel().getColumn(0).setPreferredWidth(0);
		tblGuias.getColumnModel().getColumn(0).setMinWidth(0);
		tblGuias.getColumnModel().getColumn(0).setMaxWidth(0);
		scrollPane_1_1.setViewportView(tblGuias);
	}

	// funcionalidad que carga los combos
	private static void cargarCombo(JComboBox combo, ArrayList datos) {
		combo.removeAllItems();
		for (Object objeto : datos) {
			combo.addItem(objeto);
		}
		
	}
	private void accionClickComboSede(){
		if (cmbSede.getSelectedIndex() > -1) {//funcionalidad que carga el comboTipoVisita
			GestorRegVisita.tomarSeleccionSede(cmbSede.getSelectedItem());
			Sede sedeSeleccionada = (Sede) cmbSede.getSelectedItem();
			cargarCombo(cmbTipoVisita, sedeSeleccionada.conocerTipoVisita());
		}
	}
	private void filtrarTablaEscuela(String filtro){
			filtroEscuela.setRowFilter(RowFilter.regexFilter("(?i)"+ filtro, 1));
	}
	private void filtrarTablaExposicion(String filtro){
		filtroExposicion.setRowFilter(RowFilter.regexFilter("(?i)"+ filtro, 1));
	}
	
	//funcionalidad de la TABLA DE EXPOSICION donde obtengo las expociones que q me selecciono
	private void obtetenerExposicionesSelccionadas() {
		GestorRegVisita.getExposicionesVIGENTES().clear();
			for(int i = 0 ;  i < tblExposicion.getRowCount() ; i++) {
				if((Boolean)tblExposicion.getModel().getValueAt(i, 4)) {
					GestorRegVisita.getExposicionesVIGENTES().add((Exposicion)tblExposicion.getModel().getValueAt(i, 0));
					JOptionPane.showMessageDialog(null,"Guardado exitoso");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"No selecciono ninguna exposicion");
				}
			}
	}
}
