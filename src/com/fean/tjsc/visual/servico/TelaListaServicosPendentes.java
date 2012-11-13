package com.fean.tjsc.visual.servico;

import java.awt.Color;
import java.awt.Component;

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

public class TelaListaServicosPendentes extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaListaServicosPendentes() {
		
		JLabel lblServiosPendentes = new JLabel("Servi\u00E7os Pendentes");
		lblServiosPendentes.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		
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
				{"teste1", "troca oleo", "01/11/2012"},
				{"teste2", "troca oleo", "14/11/2012"},
				{"teste3", "troca pastilha freio", "25/11/2012"},
			},
			new String[] {
				"Ve\u00EDculo", "Servi\u00E7o a fazer", "Data programada"
			}
		));
		
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {  
            public Component getTableCellRendererComponent(JTable table, Object value,  
                    boolean isSelected, boolean hasFocus, int row, int column) {  
                super.getTableCellRendererComponent(table, value, isSelected,  
                        hasFocus, row, column);  
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
                return this;  
            }  
        });
		
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}
