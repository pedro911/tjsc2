package com.fean.tjsc.visual.servico;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter;

import com.fean.tjsc.dao.fornecedor.Fornecedor;
import com.fean.tjsc.dao.motorista.Motorista;
import com.fean.tjsc.dao.tiposervico.TipoServico;
import com.fean.tjsc.dao.veiculo.Veiculo;
import com.fean.tjsc.mb.fornecedor.FornecedorMB;
import com.fean.tjsc.mb.motorista.MotoristaMB;
import com.fean.tjsc.mb.tiposervico.TipoServicoMB;
import com.fean.tjsc.mb.veiculo.VeiculoMB;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaCadastroServicoEfetuado extends JPanel {
	private JTextField txtOrcamento;
	private JTextField txtNF;
	private JComboBox<String> comboBoxVeiculo = new JComboBox<String>();
	private JComboBox<String> comboBoxFornecedor = new JComboBox<String>();
	private JComboBox<String> comboBoxMotorista = new JComboBox<String>();
	private	JComboBox<String> comboBoxTipoServico = new JComboBox<String>();

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public TelaCadastroServicoEfetuado() throws ParseException {
		
		JLabel lblRegistroDeServio = new JLabel("Registro de Servi\u00E7o Efetuado no Ve\u00EDculo");
		lblRegistroDeServio.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblVeculo = new JLabel("Ve\u00EDculo:");
		
		JLabel lblMotorista = new JLabel("Motorista:");
		
		JLabel lblFornecedor = new JLabel("Fornecedor:");
		
		JLabel lblTipoDoServio = new JLabel("Tipo do Servi\u00E7o:");
		
		listarVeiculos();
		listarFornecedores();
		listarMotoristas();
		listarTiposServico();
						
		txtOrcamento = new JTextField();
		txtOrcamento.setColumns(10);
		
		txtNF = new JTextField();
		txtNF.setColumns(10);
		
		JLabel lblData = new JLabel("Data: 01/01/2012");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		
		MaskFormatter mascaraData = new MaskFormatter("##/##/####");
		
		JFormattedTextField txtData = new JFormattedTextField(mascaraData);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		
		JFormattedTextField txtValor = new JFormattedTextField();
		
		JLabel lblKm = new JLabel("Km:");
		lblKm.setHorizontalAlignment(SwingConstants.CENTER);
		
		JFormattedTextField txtKM = new JFormattedTextField();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
			}
		});
		
		JLabel lblNmeroDoOramento = new JLabel("N\u00FAmero do Or\u00E7amento:");
		lblNmeroDoOramento.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNmeroDaNota = new JLabel("N\u00FAmero da Nota Fiscal ou Ticket:");
		lblNmeroDaNota.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(comboBoxVeiculo, 0, 188, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(txtOrcamento, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(comboBoxMotorista, 0, 188, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(txtData, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFornecedor, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(lblNmeroDaNota, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
							.addGap(22))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBoxFornecedor, 0, 188, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(txtNF, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblVeculo, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(lblNmeroDoOramento, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(100)
							.addComponent(lblRegistroDeServio, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
					.addGap(99))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMotorista, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoDoServio, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblValor, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
							.addGap(80)
							.addComponent(lblKm, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(76))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 3, Short.MAX_VALUE)
							.addGap(122))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(comboBoxTipoServico, 0, 188, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(txtValor, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(txtKM, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(362, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSalvar)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRegistroDeServio)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVeculo)
						.addComponent(lblNmeroDoOramento))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOrcamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFornecedor)
						.addComponent(lblNmeroDaNota))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMotorista)
						.addComponent(lblData))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxMotorista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTipoDoServio)
							.addComponent(lblValor))
						.addComponent(lblKm))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxTipoServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtKM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblDescrio)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalvar)
					.addGap(77))
		);
		
		JTextArea txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);
		setLayout(groupLayout);

	}
	
	public void listarVeiculos(){
		VeiculoMB mbVeiculo = VeiculoMB.getInstance();		
		List<Veiculo> veiculos;
		try {
			veiculos = mbVeiculo.finbByAll();
			for (int i=0;i<veiculos.size();i++){
				comboBoxVeiculo.addItem(veiculos.get(i).getModelo().getNome() 
						+ " - Placa: " + veiculos.get(i).getPlaca());			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"erro - "+e);
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"erro - "+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listarFornecedores(){
		FornecedorMB mbFornecedor = FornecedorMB.getInstance();		
		List<Fornecedor> fornecedores;
		try {
			fornecedores = mbFornecedor.finbByAll();
			for (int i=0;i<fornecedores.size();i++){
				comboBoxFornecedor.addItem(fornecedores.get(i).getNome());			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"erro - "+e);
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"erro - "+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listarMotoristas(){
		MotoristaMB mbMotorista = MotoristaMB.getInstance();		
		List<Motorista> motoristas;
		try {
			motoristas = mbMotorista.finbByAll();
			for (int i=0;i<motoristas.size();i++){
				comboBoxMotorista.addItem(motoristas.get(i).getNome());			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"erro - "+e);
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"erro - "+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listarTiposServico(){
		TipoServicoMB mbTipoServico = TipoServicoMB.getInstance();		
		List<TipoServico> tiposServico;
		try {
			tiposServico = mbTipoServico.finbByAll();
			for (int i=0;i<tiposServico.size();i++){
				comboBoxTipoServico.addItem(tiposServico.get(i).getNome());			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"erro - "+e);
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"erro - "+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
