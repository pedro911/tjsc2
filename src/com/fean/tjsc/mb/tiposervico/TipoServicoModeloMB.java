package com.fean.tjsc.mb.tiposervico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.abastecimento.AbastecimentoDAO;
import com.fean.tjsc.dao.modelo.Modelo;
import com.fean.tjsc.dao.servico.Servico;
import com.fean.tjsc.dao.servico.ServicoDAO;
import com.fean.tjsc.dao.tiposervico.TipoServicoModelo;
import com.fean.tjsc.dao.tiposervico.TipoServicoModeloDAO;
import com.fean.tjsc.dao.tiposervico.TipoServicoModeloId;
import com.fean.tjsc.dao.veiculo.Veiculo;




public class TipoServicoModeloMB {
	private static TipoServicoModeloMB tipoServicoModeloMB = new TipoServicoModeloMB();

	private TipoServicoModeloMB(){

	}

	public static TipoServicoModeloMB getInstance(){
		return tipoServicoModeloMB;

	}

	public String inserir(TipoServicoModelo tiposervicomodelo) {

		String retorno = "ok";
		TipoServicoModeloDAO daoTiposervicomodelo = TipoServicoModeloDAO.getInstance();
		try {
			daoTiposervicomodelo.save(tiposervicomodelo);
		} catch (Exception e) {
			retorno = "erro";
		}
		return retorno;
	}

	public String editar(TipoServicoModelo tiposervicomodelo) {
		String retorno = "ok";
		TipoServicoModeloDAO daoTiposervicomodelo = TipoServicoModeloDAO.getInstance();
		try {
			daoTiposervicomodelo.update(tiposervicomodelo);
		} catch (Exception e) {
			retorno = "erro";
		}

		return retorno;
	}


	public String apagar(TipoServicoModelo tiposervicomodelo) {
		String retorno = "ok";
		TipoServicoModeloDAO daoTiposervicomodelo = TipoServicoModeloDAO.getInstance();
		try {
			daoTiposervicomodelo.delete(tiposervicomodelo);
		} catch (Exception e) {
			retorno = "erro";
		}
		return retorno;
	}

	public TipoServicoModelo retornarTipoServicoModelo(TipoServicoModeloId id) {
		TipoServicoModeloDAO daoTiposervicomodelo = TipoServicoModeloDAO.getInstance();
		return daoTiposervicomodelo.findById(id);

	}

	public List<TipoServicoModelo> finbByAll() throws ClassNotFoundException, SQLException{
		TipoServicoModeloDAO daoTiposervicomodelo = TipoServicoModeloDAO.getInstance();
		return daoTiposervicomodelo.findAll();
	}

	public List<TipoServicoModelo> findTipoServicoByModelo (Veiculo veiculo){
		TipoServicoModeloDAO daoTiposervicomodelo = TipoServicoModeloDAO.getInstance();
		ServicoDAO servicoDAO = ServicoDAO.getInstance();
		List<TipoServicoModelo> tsmResultado = daoTiposervicomodelo.findTipoServicoByModelo(veiculo.getModelo());
		List<TipoServicoModelo> tsm = daoTiposervicomodelo.findTipoServicoByModelo(veiculo.getModelo());		
		tsmResultado.clear();
		/*
		for (int i1=0;i1<tsmResultado.size();i1++){	
			tsmResultado.get(i1).setKm(0);
		}*/

		//Calendar hoje = Calendar.getInstance();
		//String retorno = "";
		//tsm = (List<TipoServicoModelo>) tiposervicomodeloDAO.findTipoServicoByModelo(veiculo.getModelo());

		for (int i=0;i<tsm.size();i++){
			TipoServicoModelo tsmTemp = new TipoServicoModelo();
			// para cada tipo de servico busca o ultimo servico feito
			// terminar o teste para cada servico quando != null			

			Servico ultimoServico = servicoDAO.findUltimoServico(veiculo, tsm.get(i).getTipoServico());
			tsmTemp.setTipoServico(tsm.get(i).getTipoServico());

			if ( ultimoServico != null ){

				Calendar dataUltimoServico = Calendar.getInstance();   
				dataUltimoServico.setTime(ultimoServico.getData2());
				dataUltimoServico.add(Calendar.MONTH, (tsm.get(i).getTempo()));  // adicionar 6 meses
				/*

					if ( (veiculo.getOdometro() > (ultimoServico.getKm() + (tsm.get(i).getKm()*0.8)))  
							|| ( hoje.after(dataUltimoServicoPercent) ) ) {					
						if ( ( (veiculo.getOdometro() > ( ultimoServico.getKm() + (tsm.get(i).getKm()*0.8)) 
								&& veiculo.getOdometro() < ( ultimoServico.getKm() + (tsm.get(i).getKm())) ) ) 
								|| ( hoje.after(dataUltimoServicoPercent) && hoje.before(dataUltimoServico) ) ){
							if( hoje.after(dataUltimoServico)){
								retorno = "vermelho";
							}						
							else{
								retorno = "amarelo";
							}
						}
						else{
							retorno = "vermelho";
						}
					}
					else{
						retorno = "verde";
					}
				 */
				//setar temporariamente os parametros do proximo serviço pro usuario ver			

				tsmTemp.setKm(ultimoServico.getKm() + tsm.get(i).getKm());
				tsmTemp.setDataProximoServico(dataUltimoServico.getTime());
				tsmResultado.add(i, tsmTemp);

			}
			else{
				Calendar dataCadastro = Calendar.getInstance();   
				dataCadastro.setTime(veiculo.getDataCadastro());
				dataCadastro.add(Calendar.MONTH, (tsm.get(i).getTempo()));  // adicionar 6 meses
				/*

					if ( (veiculo.getOdometro() > (veiculo.getKmCadastro() + (tsm.get(i).getKm()*0.8)))  
							|| ( hoje.after(dataCadastroPercent) ) ) {					
						if ( ( (veiculo.getOdometro() < ( veiculo.getKmCadastro() + (tsm.get(i).getKm())) 
								&& veiculo.getOdometro() < ( veiculo.getKmCadastro() + (tsm.get(i).getKm())) ) ) 
								|| ( hoje.after(dataCadastroPercent) && hoje.before(dataCadastro) ) ){
							if( hoje.after(dataCadastro) ){
								retorno = "vermelho";
							}
							else{
								retorno = "amarelo";
							}						
						}
						else{
							retorno = "vermelho";
						}
					}
					else{
						retorno = "verde";
					}
				 */
				tsmTemp.setKm(veiculo.getKmCadastro() + tsm.get(i).getKm());
				tsmTemp.setDataProximoServico(dataCadastro.getTime());
				tsmResultado.add(i, tsmTemp);			
			}				
		}

		return tsmResultado;
	}

}









