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

	public String inserir(Usuario user) {

		String retorno = "ok";
		UsuarioDAO daoUsuario = UsuarioDAO.getInstance();
		try {
			daoUsuario.save(user);
		} catch (Exception e) {
			retorno = "erro";
		}
		return retorno;
	}

	public String editar(Usuario user) {
		String retorno = "ok";
		UsuarioDAO daoUsuario = UsuarioDAO.getInstance();
		try {
			daoUsuario.update(user);
		} catch (Exception e) {
			retorno = "erro";
		}

		return retorno;
	}


	public String apagar(Usuario user) {
		String retorno = "ok";
		UsuarioDAO daoUsuario = UsuarioDAO.getInstance();
		try {
			daoUsuario.delete(user);
		} catch (Exception e) {
			retorno = "erro";
		}

		return retorno;
	}

	public String validarUsuario(Usuario user){
		String retorno = "";

		//para fazer validação de campos

		if (user.getNome().isEmpty()){
			retorno += "Nome do usuário em branco\n";			
		}

		else if (user.getEmail().isEmpty()){
			retorno += "E-mail em branco\n";
		}
		
		else if (user.getMatricula().isEmpty()){
			retorno += "Digite uma matrícula\n";
		}
		
		else if (user.getSenha().isEmpty()){
			retorno += "Digite uma senha\n";
		}

		else if ((user.getEmail().contains("@")) &&
				(user.getEmail().contains(".")) &&
				(!user.getEmail().contains(" "))) {

			String usuario = new String(user.getEmail().substring(0,user.getEmail().lastIndexOf('@')));

			String dominio = new String(user.getEmail().substring(user.getEmail().lastIndexOf('@') + 1, user.getEmail().length()));

			if ((usuario.length() >=1) && (!usuario.contains("@")) 
					&& (dominio.contains(".")) && (!dominio.contains("@")) 
					&& (dominio.indexOf(".") >=1) 
					&& (dominio.lastIndexOf(".") < dominio.length() - 1)) {
				retorno = "ok";
			} 
			else {
				retorno += "E-mail Inválido\n";
			}
		} 
		else {
			retorno += "E-mail Inválido\n";				
		}
		
		return retorno;
	}
	/*

if (txtNome.getText().isEmpty() && txtEmail.getText().isEmpty() &&
		(passwordField.getPassword().length == 0 || passwordField_1.getPassword().length == 0)){
	txtNome.setBackground(Color.YELLOW);
	txtNome.setText("Digite um nome");
	txtEmail.setBackground(Color.YELLOW);
	txtEmail.setText("Digite um e-mail");
	JOptionPane.showMessageDialog(null, "Digite uma senha");
}
else if (txtEmail.getText().isEmpty()){
	txtEmail.setBackground(Color.YELLOW);
	txtEmail.setText("Digite um e-mail válido para o usuário");					
}
else if ( Arrays.equals (passwordField.getPassword(),passwordField_1.getPassword()) == false) {
	passwordField.setBackground(Color.YELLOW);
	passwordField_1.setBackground(Color.YELLOW);
	JOptionPane.showMessageDialog(null, "As senhas digitadas são diferentes, tente novamente");
}


return retorno;
}
	 */
	public boolean validarUsuarioLogin(String usuario, String senha) {

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
	
	public String pegarSenha(Integer id){
		String senha = "";		
		Usuario user = new Usuario();
		user.setIdusuario(id);		
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		user = usuarioDAO.findById(id);		
		senha = user.getSenha();		
		return senha;
	}

	public List<Usuario> finbByAll() throws ClassNotFoundException, SQLException{
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();				
		return usuarioDAO.findAll();
	}
	
	public List<Usuario> finbByName(String nome) throws ClassNotFoundException, SQLException{
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();				
		return usuarioDAO.findByNome(nome);
	}
	
	public Usuario findById(String nome){
		Usuario user = new Usuario();
		
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		List<Usuario> rs = usuarioDAO.findByNome(nome);
		user.setIdusuario(rs.get(0).getIdusuario());
		user = usuarioDAO.findById(user.getIdusuario());
		
		return user;
	}

}
