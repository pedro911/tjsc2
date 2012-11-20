package com.fean.tjsc.mb.fornecedor;

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




public class FornecedorMB {
	private static FornecedorMB abastecimentoMB = new FornecedorMB();
	
	private FornecedorMB(){
		
	}
	
	public static FornecedorMB getInstance(){
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

	public List<Fornecedor> finbByAll() throws ClassNotFoundException, SQLException{
		FornecedorDAO fornecedorDAO = FornecedorDAO.getInstance();
		return fornecedorDAO.findAll();
	}
	
	public Integer retornarIdFornecedor(String nome){
		Integer id = 0;
		FornecedorDAO fornecedorDAO = FornecedorDAO.getInstance();
		List<Fornecedor> rs = fornecedorDAO.findByNome(nome);
		id = rs.get(0).getIdfornecedor();		
		return id;
	}
	
}

