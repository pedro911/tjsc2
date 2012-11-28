package com.fean.tjsc.mb.motorista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.abastecimento.AbastecimentoDAO;
import com.fean.tjsc.dao.motorista.Motorista;
import com.fean.tjsc.dao.motorista.MotoristaDAO;
import com.fean.tjsc.dao.tiposervico.TipoServico;
import com.fean.tjsc.dao.tiposervico.TipoServicoDAO;




public class MotoristaMB {
	private static MotoristaMB abastecimentoMB = new MotoristaMB();
	
	private MotoristaMB(){
		
	}
	
	public static MotoristaMB getInstance(){
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

	public List<Motorista> finbByAll() throws ClassNotFoundException, SQLException{
		MotoristaDAO motoristaDAO = MotoristaDAO.getInstance();
		return motoristaDAO.findAll();
	}
	
}

