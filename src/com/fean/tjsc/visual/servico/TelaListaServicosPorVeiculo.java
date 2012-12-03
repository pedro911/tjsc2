package com.fean.tjsc.visual.servico;

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

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class TelaListaServicosPorVeiculo extends JPanel {
	private static JTable table;
	private final Action action = new SwingAction();
	private JTextField txtPlaca;
	private JTextField txtOdometro;
	private JTextField txtSituacao;
	public static Veiculo veiculo = new Veiculo();

	/**
	 * Create the panel.
	 */
	public TelaListaServicosPorVeiculo() {

		JLabel lblServiosPendentes = new JLabel("Servi\u00E7os Pendentes do Ve\u00EDculo");
		lblServiosPendentes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblServiosPendentes.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnEditar = new JButton("Editar");
		btnEditar.setAction(action);

		JButton btnInserir = new JButton("Imprimir Relat\u00F3rio");
		
		JLabel lblVeculo = new JLabel("Ve\u00EDculo:");
		
		txtPlaca = new JTextField();
		txtPlaca.setEditable(false);
		txtPlaca.setColumns(10);
		txtPlaca.setText(veiculo.getPlaca());
		JLabel lblOdometro = new JLabel("Odometro:");
		
		txtOdometro = new JTextField();
		txtOdometro.setEditable(false);
		txtOdometro.setColumns(10);
		txtOdometro.setText(veiculo.getOdometro()+"");
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		
		txtSituacao = new JTextField();
		txtSituacao.setEditable(false);
		txtSituacao.setColumns(10);
		txtSituacao.setText(veiculo.getSituacao());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblVeculo)
							.addGap(18)
							.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblOdometro, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtOdometro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblSituao, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(339, Short.MAX_VALUE)
							.addComponent(btnInserir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(163)
							.addComponent(lblServiosPendentes, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
							.addGap(153)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblServiosPendentes)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVeculo)
						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOdometro)
						.addComponent(txtOdometro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSituao)
						.addComponent(txtSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnInserir))
					.addContainerGap())
		);


		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Servi\u00E7o a fazer", "Km pr\u00F3ximo servi\u00E7o", "Data pr\u00F3ximo servi\u00E7o"
			}
		));

		atualizaTabela();

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

		List<TipoServicoModelo> tiposServicosModeloVeiculo = (List<TipoServicoModelo>) tipoServicoModeloMB.findTipoServicoByModelo(veiculo);	
		
		for (int i=0;i<tiposServicosModeloVeiculo.size();i++){
			
			((DefaultTableModel)table.getModel()).addRow(new String[] {
					veiculo.getIdveiculo()+"",
					tiposServicosModeloVeiculo.get(i).getTipoServico().getNome(), // servico a fazer
					tiposServicosModeloVeiculo.get(i).getKm()+"", // km do proximo servico
					tiposServicosModeloVeiculo.get(i).getDataProximoServico()+"", // data proximo servico					
			});
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
