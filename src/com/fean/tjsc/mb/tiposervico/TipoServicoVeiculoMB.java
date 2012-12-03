package com.fean.tjsc.mb.tiposervico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.abastecimento.AbastecimentoDAO;
import com.fean.tjsc.dao.tiposervico.TipoServicoVeiculo;
import com.fean.tjsc.dao.tiposervico.TipoServicoVeiculoDAO;
import com.fean.tjsc.dao.tiposervico.TipoServicoVeiculoId;
import com.fean.tjsc.dao.veiculo.Veiculo;




public class TipoServicoVeiculoMB {
	private static TipoServicoVeiculoMB tipoServicoVeiculoMB = new TipoServicoVeiculoMB();
	
	private TipoServicoVeiculoMB(){
		
	}
	
	public static TipoServicoVeiculoMB getInstance(){
		return tipoServicoVeiculoMB;
		
	}
	
	public String inserir(TipoServicoVeiculo tiposervicoveiculo) {
		
		String retorno = "ok";
		TipoServicoVeiculoDAO daoTiposervicoveiculo = TipoServicoVeiculoDAO.getInstance();
		try {
			daoTiposervicoveiculo.save(tiposervicoveiculo);
		} catch (Exception e) {
			retorno = "erro";
		}
		return retorno;
	}
	
	public String editar(TipoServicoVeiculo tiposervicoveiculo) {
		String retorno = "ok";
		TipoServicoVeiculoDAO daoTiposervicoveiculo = TipoServicoVeiculoDAO.getInstance();
		try {
			daoTiposervicoveiculo.update(tiposervicoveiculo);
		} catch (Exception e) {
			retorno = "erro";
		}
		
		return retorno;
	}
	

	public String apagar(TipoServicoVeiculo tiposervicoveiculo) {
		String retorno = "ok";
		TipoServicoVeiculoDAO daoTiposervicoveiculo = TipoServicoVeiculoDAO.getInstance();
		try {
			daoTiposervicoveiculo.delete(tiposervicoveiculo);
		} catch (Exception e) {
			retorno = "erro";
		}
		return retorno;
	}
	
	public TipoServicoVeiculo retornarTipoServicoVeiculo(TipoServicoVeiculoId id) {
		TipoServicoVeiculoDAO daoTiposervicoveiculo = TipoServicoVeiculoDAO.getInstance();
		return daoTiposervicoveiculo.findById(id);
		
	}

	public List<TipoServicoVeiculo> finbByAll() throws ClassNotFoundException, SQLException{
		TipoServicoVeiculoDAO daoTiposervicoveiculo = TipoServicoVeiculoDAO.getInstance();
		return daoTiposervicoveiculo.findAll();
	}
	
	
}









