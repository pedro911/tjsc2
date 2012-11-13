package com.fean.tjsc.mb.marca;

import java.sql.SQLException;
import java.util.List;

import com.fean.tjsc.dao.marca.Marca;
import com.fean.tjsc.dao.marca.MarcaDAO;



public class MarcaMB {
	
	private static MarcaMB marcaMB = new MarcaMB();
	
	private MarcaMB(){
		
	}
	
	public static MarcaMB getInstance(){
		return marcaMB;
		
	}
	/* not done yet
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
	*/

	public List<Marca> finbByAll() throws ClassNotFoundException, SQLException{
		MarcaDAO marcaDAO = MarcaDAO.getInstance();
		return marcaDAO.findAll();
	}

}
