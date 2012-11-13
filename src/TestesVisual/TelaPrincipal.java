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

import com.fean.tjsc.visual.servico.TelaListaServicosPendentes;
import com.fean.tjsc.visual.usuario.TelaListaUsuario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	public static boolean adm;
	public static String usuario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Controle de Servi\u00E7os dos Ve\u00EDculos do TJSC v2.0");
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
		
		JMenu mnUsuarios = new JMenu("Usu\u00E1rios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				trocaTela(new TelaListaServicosPendentes());
			}
		});
		mnUsuarios.add(mntmListar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnUsuarios.add(mntmCadastrar);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mnUsuarios.add(mntmEditar);
		
		JMenuItem mntmRemover = new JMenuItem("Remover");
		mnUsuarios.add(mntmRemover);
		//contentPane = new JPanel();
		
		trocaTela(new TelaListaUsuario());
		//contentPane = new TelaListaServicosPendentes();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setMaximumSize(getContentPane().getMaximumSize());
		//setContentPane(contentPane);
		//contentPane.setLayout(null);
		setLocationRelativeTo(null);
	}
	
	public void trocaTela(JPanel panel){
		contentPane = panel;
		setContentPane(panel);		
	}
}