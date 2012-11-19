package com.fean.tjsc.mb.veiculo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.abastecimento.AbastecimentoDAO;
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
	
	public Integer retornarIdVeiculo(String placa){
		Integer id = 0;
		Veiculo temp = new Veiculo();		
		VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
		temp = (Veiculo) veiculoDAO.findByPlaca(placa);
		id = temp.getIdveiculo();		
		return id;
	}
}









