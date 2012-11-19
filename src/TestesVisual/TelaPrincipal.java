package TestesVisual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import com.fean.tjsc.visual.servico.TelaCadastroServicoEfetuado;
import com.fean.tjsc.visual.servico.TelaCadastroServicoEfetuado2;
import com.fean.tjsc.visual.servico.TelaListaServicosPendentes;
import com.fean.tjsc.visual.usuario.TelaCadastroUsuario;
import com.fean.tjsc.visual.usuario.TelaListaUsuario;
import com.fean.tjsc.visual.veiculo.TelaCadastroVeiculo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.CardLayout;
import java.text.ParseException;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	public static boolean adm = true;
	public static String usuario;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	
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
		
		JMenuItem mntmTelaInicial = new JMenuItem("Tela Inicial");
		mntmTelaInicial.setAction(action_1);
		mnIncio.add(mntmTelaInicial);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mnIncio.add(mntmAjuda);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnIncio.add(mntmSair);
		
		JMenu mnServios = new JMenu("Servi\u00E7os");
		menuBar.add(mnServios);
		
		JMenuItem mntmRegistrarServioEfetuado = new JMenuItem("Registrar Servi\u00E7o Efetuado");
		mntmRegistrarServioEfetuado.setAction(action_6);
		mnServios.add(mntmRegistrarServioEfetuado);
		
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
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.setAction(action_3);
		mnVeculos.add(mntmListar_1);
		
		JMenu mnMotorista = new JMenu("Motorista");
		menuBar.add(mnMotorista);
		
		JMenu mnUsuarios = new JMenu("Usu\u00E1rios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.setAction(action);
		mnUsuarios.add(mntmListar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.setAction(action_2);
		mnUsuarios.add(mntmCadastrar);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mntmEditar.setAction(action_4);
		mnUsuarios.add(mntmEditar);
		
		JMenuItem mntmRemover = new JMenuItem("Remover");
		mntmRemover.setAction(action_5);
		mnUsuarios.add(mntmRemover);
		contentPane = new JPanel();
		
		trocaTela(new TelaListaServicosPendentes());
		//contentPane = new TelaListaServicosPendentes();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setMaximumSize(getContentPane().getMaximumSize());
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());
		setLocationRelativeTo(null);
	}
	
	public void trocaTela(JPanel panel){
		getContentPane().removeAll();
		contentPane.add(panel);
		revalidate();		
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Listar");
			putValue(SHORT_DESCRIPTION, "Listar usuarios");
		}
		public void actionPerformed(ActionEvent e) {
			if(adm == true){
				trocaTela(new TelaListaUsuario());
			}
			else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar este menu");
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Tela Inicial");
			putValue(SHORT_DESCRIPTION, "Lista serviços pendentes");
		}
		public void actionPerformed(ActionEvent e) {
			trocaTela(new TelaListaServicosPendentes());
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Cadastrar");
			putValue(SHORT_DESCRIPTION, "Cadastrar usuário");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(adm == true){
				trocaTela(new TelaCadastroUsuario());
			}
			else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar este menu");
			}
			
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Cadastar");
			putValue(SHORT_DESCRIPTION, "Cadastrar veiculos");
		}
		public void actionPerformed(ActionEvent e) {
			trocaTela(new TelaCadastroVeiculo());
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Editar");
			putValue(SHORT_DESCRIPTION, "Editar Usuários");
		}
		public void actionPerformed(ActionEvent e) {
			if(adm == true){
				trocaTela(new TelaListaUsuario());
				JOptionPane.showMessageDialog(null, "Selecione um usário abaixo e clique em editar");				
			}
			else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar este menu");
			}
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Remover");
			putValue(SHORT_DESCRIPTION, "Abre lista de usuários para selecionar e remover");
		}
		public void actionPerformed(ActionEvent e) {
			if(adm == true){
				trocaTela(new TelaListaUsuario());
				JOptionPane.showMessageDialog(null, "Selecione um usuário abaixo e clique em remover");				
			}
			else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar este menu");
			}
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Registrar Serviço Efetuado");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(adm == true){
				try {
					trocaTela(new TelaCadastroServicoEfetuado2());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar este menu");
			}
		}
	}
}
