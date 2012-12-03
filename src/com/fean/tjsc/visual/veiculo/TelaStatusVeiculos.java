package com.fean.tjsc.visual.veiculo;

import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import com.fean.tjsc.dao.servico.Servico;
import com.fean.tjsc.dao.servico.ServicoDAO;
import com.fean.tjsc.dao.tiposervico.TipoServico;
import com.fean.tjsc.dao.tiposervico.TipoServicoModelo;
import com.fean.tjsc.dao.tiposervico.TipoServicoModeloDAO;
import com.fean.tjsc.dao.tiposervico.TipoServicoModeloId;
import com.fean.tjsc.dao.tiposervico.TipoServicoVeiculo;
import com.fean.tjsc.dao.veiculo.Veiculo;
import com.fean.tjsc.mb.servico.ServicoMB;
import com.fean.tjsc.mb.tiposervico.TipoServicoMB;
import com.fean.tjsc.mb.tiposervico.TipoServicoModeloMB;
import com.fean.tjsc.mb.veiculo.VeiculoMB;
import com.fean.tjsc.visual.principal.TelaPrincipal;
import com.fean.tjsc.visual.servico.TelaListaServicosPorVeiculo;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class TelaStatusVeiculos extends JPanel {
	private static JTable table;
	private final Action action = new SwingAction();

	/**
	 * Create the panel.
	 */
	public TelaStatusVeiculos() {

		JLabel lblServiosPendentes = new JLabel("Servi\u00E7os Pendentes");
		lblServiosPendentes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblServiosPendentes.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnEditar = new JButton("Editar");
		btnEditar.setAction(action);

		JButton btnInserir = new JButton("Inserir");

		JButton btnMaisDetalhes = new JButton("Mais detalhes");
		btnMaisDetalhes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				abrirTelaListaServicosPorVeiculo();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(178)
												.addComponent(lblServiosPendentes, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
												.addGap(168))
												.addGroup(groupLayout.createSequentialGroup()
														.addContainerGap(290, Short.MAX_VALUE)
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
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
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
				"Id", "Ve\u00EDculo", "Odometro", "Km Pr\u00F3ximo Servi\u00E7o", "Data Pr\u00F3ximo Servi\u00E7o", "Tipo Servi\u00E7o", "Situa\u00E7\u00E3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		atualizaTabela2();

		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {  
			public Component getTableCellRendererComponent(JTable table, Object value,  
					boolean isSelected, boolean hasFocus, int row, int column) {  
				super.getTableCellRendererComponent(table, value, isSelected,  
						hasFocus, row, column);  
				/* para definir cores para a linha da tabela de acordo com a situacao do servico
				if (status =="vermelho") {  
					setBackground(Color.RED);
					setForeground(Color.WHITE);
				} 
				else if (status =="amarelo") {  
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
		//tentar organizar a tabela: vermelhos primeiro, amarelos em baixo, verde nem aparece...
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
		VeiculoMB veiculoMB = VeiculoMB.getInstance();

		try {			
			List<Veiculo> veiculoTestado = veiculoMB.statusTodosVeiculos();

			for (int i=0;i<veiculoTestado.size();i++){
				if(veiculoTestado.get(i).getSituacao() != "verde"){			
					((DefaultTableModel)table.getModel()).addRow(new String[] {
							veiculoTestado.get(i).getIdveiculo()+"",
							veiculoTestado.get(i).getPlaca(),
							veiculoTestado.get(i).getOdometro()+"",										
							veiculoTestado.get(i).getSituacao()
					});
				}
			}			

			table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {  
				public Component getTableCellRendererComponent(JTable table, Object value,  
						boolean isSelected, boolean hasFocus, int row, int column) {  
					super.getTableCellRendererComponent(table, value, isSelected,  
							hasFocus, row, column);  
					/* para definir cores para a linha da tabela de acordo com a situacao do servico
						if (veiculoTestado.getSituacao() =="vermelho") {  
							setBackground(Color.RED);
							setForeground(Color.WHITE);
						} 
						else if (veiculoTestado.getSituacao() =="amarelo") {  
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

	public static void atualizaTabela2() {
		((DefaultTableModel)table.getModel()).setRowCount(0);
		VeiculoMB veiculoMB = VeiculoMB.getInstance();
		ServicoMB servicoMB = ServicoMB.getInstance();
		TipoServicoModeloMB tipoServicoModeloMB = TipoServicoModeloMB.getInstance();

		//Servico s1 = new Servico();
		/* Ordem para por na tabela:
		 * id veiculo
		 * placa
		 * odometro veiculo
		 * serviço a fazer
		 * km próximo servico (a fazer)
		 * data próximo serviço (a fazer)
		 * situação (verde, amarelo, vemelho)
		 */

		try {
			List<Veiculo> veiculoTestado = veiculoMB.statusTodosVeiculos();			

			for (int i1=0;i1<veiculoTestado.size();i1++){
				
				if(veiculoTestado.get(i1).getSituacao() != "verde"){
					
					List<TipoServicoModelo> tiposServicosModeloVeiculo = (List<TipoServicoModelo>) tipoServicoModeloMB.findTipoServicoByModelo(veiculoTestado.get(i1));

					for (int i=0;i<tiposServicosModeloVeiculo.size();i++){

						((DefaultTableModel)table.getModel()).addRow(new String[] {
								veiculoTestado.get(i1).getIdveiculo()+"",
								veiculoTestado.get(i1).getPlaca(),								
								veiculoTestado.get(i1).getOdometro()+"",
								tiposServicosModeloVeiculo.get(i).getKm()+"", // km do proximo servico
								tiposServicosModeloVeiculo.get(i).getDataProximoServico()+"", // data proximo servico
								tiposServicosModeloVeiculo.get(i).getTipoServico().getNome(), // servico a fazer
								veiculoTestado.get(i1).getSituacao()
						});
					}
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

	public void abrirTelaListaServicosPorVeiculo(){
		TelaPrincipal parent = (TelaPrincipal)getParent().getParent().getParent().getParent();
		parent.getContentPane().removeAll();		
		VeiculoMB veiculoMB = VeiculoMB.getInstance();
		TelaListaServicosPorVeiculo.veiculo = veiculoMB.retornarVeiculo(Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0)));
		TelaListaServicosPorVeiculo tela = new TelaListaServicosPorVeiculo();
		parent.getContentPane().add(tela);
		parent.getContentPane().validate();   
		parent.getContentPane().repaint();
	}

}
