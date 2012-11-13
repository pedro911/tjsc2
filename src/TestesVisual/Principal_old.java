package TestesVisual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Principal_old extends JFrame {

	private JPanel contentPane;
	public static boolean adm;
	public static String usuario;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_old frame = new Principal_old();
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
	/**
	 * 
	 */
	/**
	 * 
	 */
	public Principal_old() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnIncio = new JMenu("In\u00EDcio");
		menuBar.add(mnIncio);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mnIncio.add(mntmAjuda);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnIncio.add(mntmSair);
		
		JMenu mnServios = new JMenu("Servi\u00E7os");
		menuBar.add(mnServios);
		
		JMenu mnNewMenu = new JMenu("Listar");
		mnServios.add(mnNewMenu);
		
		JMenuItem mntmPendentes = new JMenuItem("Todos os Pendentes");
		mnNewMenu.add(mntmPendentes);
		
		JMenuItem mntmPorVeculo = new JMenuItem("Por ve\u00EDculo");
		mnNewMenu.add(mntmPorVeculo);
		
		JMenuItem mntmPorComarca = new JMenuItem("Por comarca");
		mnNewMenu.add(mntmPorComarca);
		
		JMenu mnVeculos = new JMenu("Ve\u00EDculos");
		menuBar.add(mnVeculos);
		
		JMenu mnMotorista = new JMenu("Motorista");
		menuBar.add(mnMotorista);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurioLogado = new JLabel("Usu\u00E1rio logado:");
		lblUsurioLogado.setBounds(538, 413, 101, 14);
		contentPane.add(lblUsurioLogado);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setText(usuario);
		txtUsuario.setBounds(643, 410, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		setLocationRelativeTo(null);
	}
}
