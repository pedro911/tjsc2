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
	

	public String apagar(Servico servico) {
		String retorno = "ok";
		ServicoDAO daoServico = ServicoDAO.getInstance();
		try {
			daoServico.delete(servico);
		} catch (Exception e) {
			retorno = "erro";
		}
		
		return retorno;
	}
	
	public Servico retornarServico(int id) {
		ServicoDAO daoServico = ServicoDAO.getInstance();
		return daoServico.findById(id);
		
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
	
	public List<Servico> contaServicos (Veiculo veiculo, TipoServico tiposervico) {
		ServicoDAO servicoDAO = ServicoDAO.getInstance();
		return servicoDAO.contaServicos(veiculo, tiposervico);
	}
	
	public String validarServico(Servico servico){
		String retorno = "ok";
		
		if (servico.getNroOrcamento() == ""){
			retorno = "Digite o n�mero do or�amento.";
		}
		if (servico.getNfTicket().equals(null) || servico.getNfTicket() <= 0 ){
			retorno = "Digite o n�mero da Nota Fiscal do servi�o.";
		}
		if (servico.getData2() == null){
			retorno = "Digite a data do servi�o";
		}
		if(servico.getValor().equals(null) || servico.getValor() <= 0){
			retorno = "Digite o valor do servi�o";
		}
		if (servico.getKm().equals(null) || servico.getKm() <= 0){
			retorno = "Digite a km quando o servi�o foi efetuado";
		}		
		
		return retorno;
		
	}
	
}

