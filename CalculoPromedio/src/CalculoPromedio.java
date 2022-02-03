import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CalculoPromedio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textNota2;
	private JTextField textNota3;
	private JTextField textNota1;
	private JTextField textNombre;
	private JButton btnBoton;
	private JLabel lblPromedio;
	private JLabel lblResultado;
	private ArrayList<Alumno> listaAlumnos;
	private JTextArea textListado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoPromedio frame = new CalculoPromedio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculoPromedio() {
		listaAlumnos = new ArrayList<Alumno>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CALCULAR PROMEDIO");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 17, 442, 37);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(32, 64, 62, 20);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(98, 67, 328, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setBounds(41, 107, 53, 20);
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNota1);
		
		textNota1 = new JTextField();
		textNota1.setBounds(98, 110, 56, 19);
		textNota1.setColumns(10);
		contentPane.add(textNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setBounds(164, 107, 53, 20);
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNota2);
		
		textNota2 = new JTextField();
		textNota2.setBounds(221, 110, 56, 19);
		contentPane.add(textNota2);
		textNota2.setColumns(10);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setBounds(288, 107, 53, 20);
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNota3);
		
		textNota3 = new JTextField();
		textNota3.setBounds(345, 110, 56, 19);
		contentPane.add(textNota3);
		textNota3.setColumns(10);
		
		 JButton btnBoton = new JButton("Calcular e Insertar");
		btnBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				calcular();
			
				
				
				
				
				
				
			}
		});
		btnBoton.setBounds(50, 155, 130, 21);
		contentPane.add(btnBoton);
		
		JLabel lblPro = new JLabel("Promedio:");
		lblPro.setBounds(39, 207, 82, 22);
		lblPro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPro);
		
		lblPromedio = new JLabel("");
		lblPromedio.setBounds(131, 209, 85, 20);
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPromedio);
		
		JLabel lblRes = new JLabel("Resultado:");
		lblRes.setBounds(37, 233, 86, 22);
		lblRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblRes);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(131, 233, 299, 22);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblResultado);
		
		JButton btnMostrar = new JButton("Mostrar datos");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			mostrarLista();	
				
			}
		});
		btnMostrar.setBounds(266, 155, 135, 21);
		contentPane.add(btnMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 265, 394, 117);
		contentPane.add(scrollPane);
		
		textListado = new JTextArea();
		scrollPane.setViewportView(textListado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
		
	public void mostrarLista () {
		textListado.setText(null);
		if(listaAlumnos.isEmpty() ) {
			textListado.setText("No hay datos");
		} else {
			for (Alumno alumno : listaAlumnos) {
				textListado.setText(textListado.getText()+alumno+"\n");
			}
		}
			
		
		
	}
		
	
	public void calcular() {
		String nombre=textNombre.getText();
		double n1=Double.parseDouble(textNota1.getText());
		double n2=Double.parseDouble(textNota2.getText());
		double n3=Double.parseDouble(textNota3.getText());
		
		Alumno al = new Alumno(nombre,n1,n2,n3);
		listaAlumnos.add(al);
		
		
		lblPromedio.setText(String.format("%.2f",al.getNotaMedia()));
		
		if (al.getNotaMedia()>=5) {
			lblResultado.setText(nombre+ " Ha aprobado la asignatura");
		} else {
			lblResultado.setText(nombre+ " Toca recuperar");
		}
	
	}
}
