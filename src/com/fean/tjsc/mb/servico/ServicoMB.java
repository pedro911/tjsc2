package com.fean.tjsc.mb.servico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.abastecimento.AbastecimentoDAO;
import com.fean.tjsc.dao.servico.Servico;
import com.fean.tjsc.dao.servico.ServicoDAO;
import com.fean.tjsc.dao.tiposervico.TipoServico;
import com.fean.tjsc.dao.veiculo.Veiculo;




public class ServicoMB {
	private static ServicoMB servicoMB = new ServicoMB();
	
	private ServicoMB(){
		
	}
	
	public static ServicoMB getInstance(){
		return servicoMB;
		
	}
	
	public String inserir(Servico servico) {
		
		String retorno = "ok";
		ServicoDAO daoServico = ServicoDAO.getInstance();
		try {
			daoServico.save(servico);
		} catch (Exception e) {
			retorno = "erro";
		}
		return retorno;
	}
	
	public String editar(Servico servico) {
		String retorno = "ok";
		ServicoDAO daoServico = ServicoDAO.getInstance();
		try {
			daoServico.update(servico);
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

	public List<Servico> finbByAll() throws ClassNotFoundException, SQLException{
		ServicoDAO servicoDAO = ServicoDAO.getInstance();
		return servicoDAO.findAll();
	}
	
	public Servico finbById(int id) throws ClassNotFoundException, SQLException{
		ServicoDAO servicoDAO = ServicoDAO.getInstance();
		return servicoDAO.findById(id);
	}
	public Servico findUltimoServico(Veiculo veiculo, TipoServico tiposervico) throws ClassNotFoundException, SQLException{
		ServicoDAO servicoDAO = ServicoDAO.getInstance();
		return servicoDAO.findUltimoServico(veiculo,tiposervico);
	}
	
	public String validarServico(Servico servico){
		
		String retorno = "ok";
		
		
		
		return retorno;
		
	}
	
}

