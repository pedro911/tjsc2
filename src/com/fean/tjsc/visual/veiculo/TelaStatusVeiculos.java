package com.fean.tjsc.visual.veiculo;

import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import com.fean.tjsc.dao.servico.Servico;
import com.fean.tjsc.dao.veiculo.Veiculo;
import com.fean.tjsc.mb.servico.ServicoMB;
import com.fean.tjsc.mb.veiculo.VeiculoMB;
import com.fean.tjsc.visual.principal.TelaPrincipal;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaStatusVeiculos extends JPanel {
	private static JTable table;
	private final Action action = new SwingAction();

	/**
	 * Create the panel.
	 */
	public TelaStatusVeiculos() {

		JLabel lblServiosPendentes = new JLabel("Servi\u00E7os Pendentes");
		lblServiosPendentes.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnEditar = new JButton("Editar");
		btnEditar.setAction(action);

		JButton btnInserir = new JButton("Inserir");

		JButton btnMaisDetalhes = new JButton("Mais detalhes");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(178)
										.addComponent(lblServiosPendentes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(168))
										.addGroup(groupLayout.createSequentialGroup()
												.addContainerGap()
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
												.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
														.addContainerGap(215, Short.MAX_VALUE)
														.addComponent(btnMaisDetalhes)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnInserir)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnEditar)))
														.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(5)
						.addComponent(lblServiosPendentes)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEditar)
								.addComponent(btnInserir)
								.addComponent(btnMaisDetalhes))
								.addContainerGap())
				);


		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Ve\u00EDculo", "Placa", "Servi\u00E7o a fazer", "Data programada", "Id"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(87);

		atualizaTabela();

		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {  
			public Component getTableCellRendererComponent(JTable table, Object value,  
					boolean isSelected, boolean hasFocus, int row, int column) {  
				super.getTableCellRendererComponent(table, value, isSelected,  
						hasFocus, row, column);  
				/* para definir cores para a linha da tabela de acordo com a situacao do servico
				if (row == 0) {  
					setBackground(Color.RED);
					setForeground(Color.WHITE);
				} 
				else if (row == 1) {  
					setBackground(Color.YELLOW);
					setForeground(Color.BLACK);
				} 
				else {  
					setBackground(null);
					setForeground(null);
				}
				 */  
				return this;  
			}  
		});
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}

	public static void atualizaTabela(){
		((DefaultTableModel)table.getModel()).setRowCount(0);
		VeiculoMB veiculoMB = VeiculoMB.getInstance();
		ServicoMB servicoMB = ServicoMB.getInstance();
		Servico s1 = new Servico();
		try {
			List<Veiculo> listaVeiculos = veiculoMB.finbByAll();
			for (int i=0;i<listaVeiculos.size();i++){
				String status = veiculoMB.statusVeiculo(listaVeiculos.get(i));
				//s1 = servicoMB.findMaxServico(listaVeiculos.get(i));
				//JOptionPane.showMessageDialog(null, s1.getIdservico());
				((DefaultTableModel)table.getModel()).addRow(new String[] {
						listaVeiculos.get(i).getModelo().getNome(),
						listaVeiculos.get(i).getPlaca(),
						//s1.getVeiculo().getIdveiculo()+"",
						//s1.getTipoServico().getNome(),
						status
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
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Editar");
			putValue(SHORT_DESCRIPTION, "Abre tela para editar o serviço selecionado");
		}
		public void actionPerformed(ActionEvent e) {			

			

		}
	}	

}
