package com.fean.tjsc.visual.usuario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fean.tjsc.dao.marca.Marca;
import com.fean.tjsc.dao.usuario.Usuario;
import com.fean.tjsc.mb.marca.MarcaMB;
import com.fean.tjsc.mb.usuario.UsuarioMB;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

public class TelaListaUsuarios extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaUsuarios frame = new TelaListaUsuarios();
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
	public TelaListaUsuarios() {
		setBounds(100, 100, 615, 382);
		
		JLabel lblListaDeUsurios = new JLabel("Lista de usu\u00E1rios cadastrados no sistema");
		lblListaDeUsurios.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(lblListaDeUsurios)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListaDeUsurios)
					.addGap(14)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Matricula", "E-mail", "Administrador"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
			
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		((DefaultTableModel)table.getModel()).setRowCount(0);
		UsuarioMB usuarioMB = UsuarioMB.getInstance();
		
		try {
			List<Usuario> listaUsuarios = usuarioMB.finbByAll();
			for (int i=0;i<listaUsuarios.size();i++){
				String adm = "";
				if (listaUsuarios.get(i).getAdministrador() == true){
					adm = "SIM";
				}
				else{
					adm = "NÃO";
				}
					
				((DefaultTableModel)table.getModel()).addRow(new String[] {
						listaUsuarios.get(i).getIdusuario()+"",
						listaUsuarios.get(i).getNome(),
						listaUsuarios.get(i).getMatricula(),
						listaUsuarios.get(i).getEmail(),
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

	}
}
