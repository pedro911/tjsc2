package com.fean.tjsc.mb.usuario;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.abastecimento.AbastecimentoDAO;
import com.fean.tjsc.dao.usuario.Usuario;
import com.fean.tjsc.dao.usuario.UsuarioDAO;


public class UsuarioMB {

	private static UsuarioMB usuarioMB = new UsuarioMB();

	private UsuarioMB(){

	}

	public static UsuarioMB getInstance(){
		return usuarioMB;

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

	public boolean validarUsuario(String usuario, String senha) {

		boolean resultado = false;		
		Usuario user = new Usuario();
		user.setNome(usuario);
		user.setSenha(senha);
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		List<Usuario> rs = usuarioDAO.findByNome(usuario);

		if (rs.isEmpty()){
			resultado = false;
		}
		else{
			if(rs.get(0).getNome().equals(usuario) && rs.get(0).getSenha().equals(senha)){			
				resultado = true;				
			}
			else {
				resultado = false;
			}			
		}
		return resultado;		
	}
	
	public boolean verificaUsuarioAdministrador(String usuario){
				
		Usuario user = new Usuario();
		user.setNome(usuario);		
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		List<Usuario> rs = usuarioDAO.findByNome(usuario);
		
		boolean resultado = rs.get(0).getAdministrador();			
		
		return resultado;
	}

	public List<Usuario> finbByAll() throws ClassNotFoundException, SQLException{
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();				
		return usuarioDAO.findAll();
	}

}
