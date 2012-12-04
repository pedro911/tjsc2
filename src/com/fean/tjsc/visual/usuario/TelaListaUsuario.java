package com.fean.tjsc.visual.usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;


import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.usuario.Usuario;
import com.fean.tjsc.mb.abastecimento.AbastecimentoMB;
import com.fean.tjsc.mb.usuario.UsuarioMB;
import com.fean.tjsc.visual.principal.TelaPrincipal;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class TelaListaUsuario extends JPanel {
	private static JTable table;
	private JTextField txtBusca;
	static List listaUsuarios = new ArrayList();

	/**
	 * Create the panel.
	 */
	public TelaListaUsuario() {

		JLabel lblListaDeUsurios = new JLabel("Lista de Usu\u00E1rios");
		lblListaDeUsurios.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirTelaEditarUsuario();
			}
		});

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirTelaCadastroUsuario();				
			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				UsuarioMB usuarioMB = UsuarioMB.getInstance();
				Usuario user = new Usuario();

				for(int i=0; i <= table.getSelectedRow(); i++){					
					user.setIdusuario(Integer.parseInt((String) table.getValueAt(i, 4)));		        	
				}			    

				try {
					int op = JOptionPane.showConfirmDialog(null,"Deseja realmente apagar o usuário selecionado ?");
					if (op==JOptionPane.YES_OPTION ) {
						usuarioMB.apagar(user);
						atualizaTabela();
						JOptionPane.showMessageDialog(null,"Usuário apagado!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"erro - "+e);
					// TODO: handle exception
				}

			}
		});

		JLabel lblBuscaPeloNome = new JLabel("Busca pelo nome:");

		txtBusca = new JTextField();
		txtBusca.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				((DefaultTableModel)table.getModel()).setRowCount(0);
				UsuarioMB usuarioMB = UsuarioMB.getInstance();

				try {
					List<Usuario> listaUsuarios = usuarioMB.finbByName(txtBusca.getText());

					if (usuarioMB.finbByName(txtBusca.getText()).isEmpty()){
						JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
					}
					else{
						for (int i1=0;i1<listaUsuarios.size();i1++){
							String adm = "";
							if (listaUsuarios.get(i1).getAdministrador() == true){
								adm = "Sim";	
							}
							else{
								adm = "Não";
							}
							((DefaultTableModel)table.getModel()).addRow(new String[] {
									listaUsuarios.get(i1).getNome(),
									listaUsuarios.get(i1).getEmail(),
									listaUsuarios.get(i1).getMatricula(),
									adm,
									listaUsuarios.get(i1).getIdusuario()+""
							});
						}
					}

				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null,"erro - "+e);
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"erro - "+e);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		JButton btnImprimirLista = new JButton("Imprimir Lista");
		btnImprimirLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				listaUsuarios.clear();
				for (int i=0;i<table.getRowCount();i++){
					Usuario temp = new Usuario();
					temp.setNome(table.getValueAt(i, 1).toString());
					temp.setEmail(table.getValueAt(i, 2).toString());
					temp.setMatricula(table.getValueAt(i, 3).toString());
					if (table.getValueAt(i, 4).toString() == "Sim"){
						temp.setAdministrador(true);	
					}
					else{
						temp.setAdministrador(false);
					}
					listaUsuarios.add(temp);					
				}	
				
				JasperReport report;
				
				try {
					report = JasperCompileManager.compileReport("relatorios/usuarios.jrxml");					
					JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaUsuarios));
					JasperViewer jrviewer = new JasperViewer (print,false);
					jrviewer.show();					
					// exportacao do relatorio para outro formato, no caso PDF
					//JasperExportManager.exportReportToPdfFile(print, "relatorios/Relatorio.pdf");
					System.out.println("Relatório gerado.");
					//JOptionPane.showMessageDialog(null,"Relatório gerado.");
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnImprimirLista)
							.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
							.addComponent(btnRemover)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInserir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBuscaPeloNome)
							.addGap(18)
							.addComponent(txtBusca, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnOk)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(185)
					.addComponent(lblListaDeUsurios, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(184))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblListaDeUsurios)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBuscaPeloNome)
						.addComponent(btnOk))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnInserir)
						.addComponent(btnRemover)
						.addComponent(btnImprimirLista))
					.addContainerGap())
		);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "E-mail", "Matr\u00EDcula", "Adm"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		
		atualizaTabela();
				
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		
		TableRowSorter<TableModel> sorter  = new TableRowSorter<TableModel>();	
		Comparator<String> comparator = new Comparator<String>() {
			public int compare(String s1, String s2) {
				String[] strings1 = s1.split("\\s");
				String[] strings2 = s2.split("\\s");
				return strings1[strings1.length - 1]
						.compareTo(strings2[strings2.length - 1]);
			}
		};
		table.setRowSorter(sorter);
		table.setAutoCreateRowSorter(true);

	}

	public static void atualizaTabela(){
		((DefaultTableModel)table.getModel()).setRowCount(0);		
				
		UsuarioMB usuarioMB = UsuarioMB.getInstance();

		try {
			List<Usuario> listaUsuarios = usuarioMB.finbByAll();
			for (int i=0;i<listaUsuarios.size();i++){
				String adm = "";
				if (listaUsuarios.get(i).getAdministrador() == true){
					adm = "Sim";	
				}
				else{
					adm = "Não";
				}
				((DefaultTableModel)table.getModel()).addRow(new String[] {
						listaUsuarios.get(i).getIdusuario()+"",
						listaUsuarios.get(i).getNome(),
						listaUsuarios.get(i).getEmail(),
						listaUsuarios.get(i).getMatricula(),
						adm						
				});
			}
			table.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
			table.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
			table.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
			table.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );  

			table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {  
				public Component getTableCellRendererComponent(JTable table, Object value,  
						boolean isSelected, boolean hasFocus, int row, int column) {  
					super.getTableCellRendererComponent(table, value, isSelected,  
							hasFocus, row, column);  				
					return this;  
				}  
			});
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"erro - "+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"erro - "+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void abrirTelaCadastroUsuario(){
		TelaPrincipal parent = (TelaPrincipal)getParent().getParent().getParent().getParent();
		parent.getContentPane().removeAll();
		parent.getContentPane().add(new TelaCadastroUsuario());
		parent.getContentPane().validate();   
		parent.getContentPane().repaint();
	}

	public void abrirTelaEditarUsuario(){
		TelaPrincipal parent = (TelaPrincipal)getParent().getParent().getParent().getParent();
		parent.getContentPane().removeAll();		
		TelaEditarUsuario telaEditar = new TelaEditarUsuario();		
		UsuarioMB usuarioMB = UsuarioMB.getInstance();		
		for(int i=0; i <= table.getSelectedRow(); i++){
			telaEditar.txtNome.setText((String) table.getValueAt(i, 0));
			telaEditar.txtEmail.setText((String) table.getValueAt(i, 1));
			telaEditar.txtMatricula.setText((String) table.getValueAt(i, 2));					
			telaEditar.txtId.setText((String) table.getValueAt(i, 4));
			//pegar a senha do usuario e carregar na tela de edição
			telaEditar.passwordField.setText(usuarioMB.pegarSenha(Integer.parseInt((String) table.getValueAt(i, 4))));			
			if (table.getValueAt(i, 3) == "Sim"){
				telaEditar.rdbtnAdministrador.setSelected(true);
			}
			else{
				telaEditar.rdbtnAdministrador.setSelected(false);
			}
		}		
		parent.getContentPane().add(telaEditar);
		parent.getContentPane().validate();   
		parent.getContentPane().repaint();
	}
}
