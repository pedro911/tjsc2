package com.fean.tjsc.mb.veiculo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.abastecimento.AbastecimentoDAO;
import com.fean.tjsc.dao.servico.Servico;
import com.fean.tjsc.dao.servico.ServicoDAO;
import com.fean.tjsc.dao.tiposervico.TipoServico;
import com.fean.tjsc.dao.tiposervico.TipoServicoDAO;
import com.fean.tjsc.dao.tiposervico.TipoServicoModelo;
import com.fean.tjsc.dao.tiposervico.TipoServicoModeloDAO;
import com.fean.tjsc.dao.tiposervico.TipoServicoModeloId;
import com.fean.tjsc.dao.usuario.Usuario;
import com.fean.tjsc.dao.usuario.UsuarioDAO;
import com.fean.tjsc.dao.veiculo.Veiculo;
import com.fean.tjsc.dao.veiculo.VeiculoDAO;




public class VeiculoMB {
	private static VeiculoMB abastecimentoMB = new VeiculoMB();

	private VeiculoMB(){

	}

	public static VeiculoMB getInstance(){
		return abastecimentoMB;

	}

	public String inserir(Abastecimento abastecimento) {

		String retorno = "ok";
		AbastecimentoDAO daoAbastecimento = AbastecimentoDAO.getInstance();
		try {
			daoAbastecimento.save(abastecimento);
		} catch (Exception e) {
			retorno = "erro";
		}
		return retorno;
	}

	public String editar(Abastecimento abastecimento) {
		String retorno = "ok";
		AbastecimentoDAO daoAbastecimento = AbastecimentoDAO.getInstance();
		try {
			daoAbastecimento.update(abastecimento);
		} catch (Exception e) {
			retorno = "erro";
		}

		return retorno;
	}


	public String apagar(Abastecimento abastecimento) {
		String retorno = "ok";
		AbastecimentoDAO daoAbastecimento = AbastecimentoDAO.getInstance();
		try {
			daoAbastecimento.delete(abastecimento);
		} catch (Exception e) {
			retorno = "erro";
		}
		return retorno;
	}

	public Abastecimento retornarAbastecimento(int id) {
		AbastecimentoDAO daoAbastecimento = AbastecimentoDAO.getInstance();
		return daoAbastecimento.findById(id);

	}

	public List<Veiculo> finbByAll() throws ClassNotFoundException, SQLException{
		VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
		return veiculoDAO.findAll();
	}
	/*

	public String statusVeiculo (Veiculo veiculo){
		String retorno = "";
		ServicoDAO servicoDAO = ServicoDAO.getInstance();
		AbastecimentoDAO abastecimentoDAO = AbastecimentoDAO.getInstance();
		//TipoServicoDAO tipoServicoDAO = TipoServicoDAO.getInstance();
		TipoServicoModeloDAO tipoServicoModeloDAO = TipoServicoModeloDAO.getInstance();
		//long dataHoje = new java.util.Date().getTime();				
		List<Servico> listaServicos = servicoDAO.findAll();
		
		for (int i=0;i<listaServicos.size();i++){
			// se o veiculo possui servico efetuado entra aqui			
			
			
			int posicaoUltimoServico = listaServicosVeiculo.lastIndexOf(veiculo);
			TipoServicoModeloId tsm = new TipoServicoModeloId();
			tsm.setModeloIdmodelo(veiculo.getModelo().getIdmodelo());
			tsm.setTipoServicoIdtipoServico(listaServicosVeiculo.get(posicaoUltimoServico).getTipoServico().getIdtipoServico());
			int kmUltimoServico = listaServicosVeiculo.get(posicaoUltimoServico).getKm();
			TipoServicoModelo temp = tipoServicoModeloDAO.findById(tsm);
			int kmProximoServico = temp.getKm();
			double percentualAviso = 0.8;
			java.util.Date dataHoje = new java.util.Date(System.currentTimeMillis());
			SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");   
			System.out.print(formatarDate.format(dataHoje));  

			if ( (veiculo.getOdometro() > ( kmUltimoServico + (kmProximoServico * percentualAviso/100))) ){
				// testar para ver se é amarelo ou vermelho
				if ( veiculo.getOdometro() < ( kmProximoServico + kmUltimoServico) ){
					retorno = "amarelo";						
				}
				else {
					retorno = "vermelho";
				}
			}
			else {
				retorno = "verde";
			}
			
			// se nao possui nenhum servico, compara com: km do ultimo abastecimento + km tipo do servico para ver se passou
			Abastecimento abastecimentoMin = new Abastecimento();
			abastecimentoMin = abastecimentoDAO.findMinAbastecimento(veiculo);
			java.util.Date dataAmarelo = new java.util.Date();
			java.util.Date dataVermelho = new java.util.Date();
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			
			if ( veiculo.getOdometro() > ( abastecimentoMin.getKmOdometro() + (kmProximoServico * percentualAviso))
					|| dataHoje.after(abastecimentoMin.getData2()) ) {
				if (veiculo.getOdometro() < ( abastecimentoMin.getKmOdometro() + kmProximoServico)
					|| dataHoje.after(abastecimentoMin.getData2())){
					retorno = "amarelo";
				}
				else {
					retorno = "vermelho";
				}				
			}
			else {
				retorno = "verde";
			}
			
		}
		return retorno;
	}
	*/
	
	public String statusVeiculo (Veiculo veiculo){
		String retorno = "";
		TipoServicoModeloDAO tiposervicomodeloDAO = TipoServicoModeloDAO.getInstance();
		ServicoDAO servicoDAO = ServicoDAO.getInstance();
		//AbastecimentoDAO abastecimentoDAO = AbastecimentoDAO.getInstance();
		/*		
		TipoServicoModeloId tsm = new TipoServicoModeloId();
		tsm.setModeloIdmodelo(veiculo.getModelo().getIdmodelo());
		JOptionPane.showMessageDialog(null, tsm.getModeloIdmodelo());	
		*/			
		List<TipoServicoModelo> tiposServicosModeloVeiculo = (List<TipoServicoModelo>) tiposervicomodeloDAO.findTipoServicoByModelo(veiculo.getModelo());
		
		for (int i=0;i<tiposServicosModeloVeiculo.size();i++){
			JOptionPane.showMessageDialog(null,					
					"ID veículo: " + veiculo.getIdveiculo() + " " +
					"\nid tipo serviço: " + tiposServicosModeloVeiculo.get(i).getTipoServico().getIdtipoServico() + " " +
					"\nnome tipo servico: " + tiposServicosModeloVeiculo.get(i).getTipoServico().getNome());
		}
		
		for (int i=0;i<tiposServicosModeloVeiculo.size();i++){
			// para cada tipo de servico busca o ultimo servico feito
			// terminar o teste para cada servico quando != null
			
			Servico ultimoServico = servicoDAO.findUltimoServico(veiculo, tiposServicosModeloVeiculo.get(i).getTipoServico());
			retorno = "shit!";
			// se nao encontrar nenhum, vai comparar o ultimo abastecimento + km proximo servico com a km inicial cadastrada
			if (ultimoServico == null){
				//Abastecimento ultimoAbastecimento = abastecimentoDAO.findUltimoAbastecimento(veiculo);
				JOptionPane.showMessageDialog(null, "km cadastro: " + veiculo.getKmCadastro() +
						"\nodometro veiculo: " + veiculo.getOdometro() +
						"\ntipo servico:" + tiposServicosModeloVeiculo.get(i).getKm());
				if( veiculo.getOdometro() > ( veiculo.getKmCadastro()  + (tiposServicosModeloVeiculo.get(i).getKm()*0.8) ) ){
					if( veiculo.getOdometro() < (veiculo.getKmCadastro() + tiposServicosModeloVeiculo.get(i).getKm() ) ){
						retorno = "amarelo";
					}
					else{
						retorno = "vermelho";
					}
				}
				else{
					retorno = "verde";
				}
			}
		}
		
		return retorno;
	}

}









