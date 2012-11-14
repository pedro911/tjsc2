package com.fean.tjsc.visual.usuario;

import java.sql.SQLException;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.usuario.Usuario;
import com.fean.tjsc.mb.abastecimento.AbastecimentoMB;
import com.fean.tjsc.mb.usuario.UsuarioMB;

public class TelaListaUsuario extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaListaUsuario() {
		
		JLabel lblListaDeUsurios = new JLabel("Lista de Usu\u00E1rios");
		lblListaDeUsurios.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnInserir = new JButton("Inserir");
		
		JButton btnRemover = new JButton("Remover");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(185)
							.addComponent(lblListaDeUsurios, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(174))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(215, Short.MAX_VALUE)
					.addComponent(btnRemover)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListaDeUsurios)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnInserir)
						.addComponent(btnRemover))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "E-mail", "Matr\u00EDcula", "Adm"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
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
						listaUsuarios.get(i).getNome(),
						listaUsuarios.get(i).getEmail(),
						listaUsuarios.get(i).getMatricula(),
						adm
				});
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
		
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}
