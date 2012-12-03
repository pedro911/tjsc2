package com.fean.tjsc.mb.tiposervico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.abastecimento.AbastecimentoDAO;
import com.fean.tjsc.dao.fornecedor.Fornecedor;
import com.fean.tjsc.dao.fornecedor.FornecedorDAO;
import com.fean.tjsc.dao.tiposervico.TipoServico;
import com.fean.tjsc.dao.tiposervico.TipoServicoDAO;
import com.fean.tjsc.dao.veiculo.Veiculo;




public class TipoServicoMB {
	private static TipoServicoMB abastecimentoMB = new TipoServicoMB();
	
	private TipoServicoMB(){
		
	}
	
	public static TipoServicoMB getInstance(){
		return abastecimentoMB;
		
	}
	
	public String inserir(TipoServico tiposervico) {
		
		String retorno = "ok";
		TipoServicoDAO tiposervicoDAO = TipoServicoDAO.getInstance();
		try {
			tiposervicoDAO.save(tiposervico);
		} catch (Exception e) {
			retorno = "erro";
		}
		return retorno;
	}
	
	public String editar(TipoServico tiposervico) {
		String retorno = "ok";
		TipoServicoDAO tiposervicoDAO = TipoServicoDAO.getInstance();
		try {
			tiposervicoDAO.update(tiposervico);
		} catch (Exception e) {
			retorno = "erro";
		}
		
		return retorno;
	}
	

	public String apagar(TipoServico tiposervico) {
		String retorno = "ok";
		TipoServicoDAO tiposervicoDAO = TipoServicoDAO.getInstance();
		try {
			tiposervicoDAO.delete(tiposervico);
		} catch (Exception e) {
			retorno = "erro";
		}
		return retorno;
	}
	
	public TipoServico retornarTipoServico(int id) {
		TipoServicoDAO tiposervicoDAO = TipoServicoDAO.getInstance();
		return tiposervicoDAO.findById(id);
		
	}

	public List<TipoServico> finbByAll() throws ClassNotFoundException, SQLException{
		TipoServicoDAO tiposervicoDAO = TipoServicoDAO.getInstance();
		return tiposervicoDAO.findAll();
	}
	/*
	public List<TipoServico> findByVeiculo(Veiculo veiculo) throws ClassNotFoundException, SQLException{
		TipoServicoDAO tiposervicoDAO = TipoServicoDAO.getInstance();
		return tiposervicoDAO.findByVeiculo(veiculo);
	}
	*/
	
}









