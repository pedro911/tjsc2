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
import com.fean.tjsc.dao.servico.Servico;
import com.fean.tjsc.dao.tiposervico.TipoServico;
import com.fean.tjsc.dao.veiculo.Veiculo;
import com.fean.tjsc.mb.fornecedor.FornecedorMB;
import com.fean.tjsc.mb.motorista.MotoristaMB;
import com.fean.tjsc.mb.servico.ServicoMB;
import com.fean.tjsc.mb.tiposervico.TipoServicoMB;
import com.fean.tjsc.mb.veiculo.VeiculoMB;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaCadastroServicoEfetuado2 extends JPanel {
	private JTextField txtOrcamento;
	private JTextField txtNF;
	private JComboBox<String> comboBoxVeiculo = new JComboBox<String>();
	private JComboBox<String> comboBoxFornecedor = new JComboBox<String>();
	private JComboBox<String> comboBoxMotorista = new JComboBox<String>();
	private	JComboBox<String> comboBoxTipoServico = new JComboBox<String>();
	private JTextArea txtDescricao;
	private JFormattedTextField txtKM;
	private JFormattedTextField txtValor;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public TelaCadastroServicoEfetuado2() throws ParseException {
		
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
		
		txtDescricao = new JTextArea();
		txtKM = new JFormattedTextField();
		txtValor = new JFormattedTextField();
		
		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		
		MaskFormatter mascaraData = new MaskFormatter("##/##/####");
		
		JFormattedTextField txtData = new JFormattedTextField(mascaraData);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblKm = new JLabel("Km:");
		lblKm.setHorizontalAlignment(SwingConstants.CENTER);
				
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String retorno = "";
				// veiculo
				//fornecedor
				//motorista
				//tipo servico
				Servico serv = new Servico();
				Veiculo veic = new Veiculo();
				TipoServico tiposerv = new TipoServico();
				Motorista mot = new Motorista();
				Fornecedor forn = new Fornecedor();
				
				ServicoMB mbServico = ServicoMB.getInstance();
				VeiculoMB mbVeiculo = VeiculoMB.getInstance();
				MotoristaMB mbMotorista = MotoristaMB.getInstance();
				TipoServicoMB mbTipoServico = TipoServicoMB.getInstance();
				FornecedorMB mbFornecedor = FornecedorMB.getInstance();
				
				veic.setIdveiculo(mbVeiculo.retornarIdVeiculo((String) comboBoxVeiculo.getSelectedItem()));
				serv.setVeiculo(veic);
				
				forn.setIdfornecedor(mbFornecedor.retornarIdFornecedor((String) comboBoxFornecedor.getSelectedItem()));
				serv.setFornecedor(forn);
				
				mot.setIdmotorista(mbMotorista.retornarIdMotorista((String) comboBoxMotorista.getSelectedItem()));
				serv.setMotorista(mot);
				
				tiposerv.setIdtipoServico(mbTipoServico.retornarIdTipoServico((String) comboBoxTipoServico.getSelectedItem()));
				serv.setTipoServico(tiposerv);
				
				// ver como fazer as mascaras para inserir a data...
				//serv.setData2(txtData.getText());
				
				serv.setNroOrcamento(txtOrcamento.getText());
				serv.setNfTicket(Integer.parseInt(txtNF.getText()));
				serv.setDescricao(txtDescricao.getText());
				serv.setKm(Integer.parseInt(txtKM.getText()));				
				serv.setValor(Double.parseDouble(txtValor.getText()));
				
				retorno = mbServico.validarServico(serv);
				
				if (retorno == "ok"){
					mbServico.inserir(serv);
					JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso");
				}
				else{
					JOptionPane.showMessageDialog(null, retorno);
				}			
				
			}
		});
		
		JLabel lblNmeroDoOramento = new JLabel("N\u00FAmero do Or\u00E7amento:");
		lblNmeroDoOramento.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNmeroDaNota = new JLabel("N\u00FAmero da Nota Fiscal ou Ticket:");
		lblNmeroDaNota.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
				
		scrollPane.setViewportView(txtDescricao);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addComponent(lblRegistroDeServio, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
					.addGap(37))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblFornecedor, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(lblValor, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblKm, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(comboBoxFornecedor, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(txtData, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtKM, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblMotorista, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(129)
					.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxMotorista, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoDoServio, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxTipoServico, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
					.addGap(14))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(611)
					.addComponent(btnSalvar)
					.addGap(14))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxVeiculo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVeculo, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNmeroDoOramento, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(92)
							.addComponent(lblNmeroDaNota, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtOrcamento, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
							.addGap(36)
							.addComponent(txtNF, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblRegistroDeServio)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVeculo)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNmeroDoOramento)
							.addComponent(lblNmeroDaNota)))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOrcamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFornecedor)
						.addComponent(lblData)
						.addComponent(lblValor)
						.addComponent(lblKm))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtKM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMotorista)
						.addComponent(lblDescrio))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBoxMotorista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblTipoDoServio)
							.addGap(11)
							.addComponent(comboBoxTipoServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(btnSalvar))
		);
		setLayout(groupLayout);

	}
	
	public void listarVeiculos(){
		VeiculoMB mbVeiculo = VeiculoMB.getInstance();		
		List<Veiculo> veiculos;
		try {
			veiculos = mbVeiculo.finbByAll();
			for (int i=0;i<veiculos.size();i++){
				comboBoxVeiculo.addItem(veiculos.get(i).getPlaca());			
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
