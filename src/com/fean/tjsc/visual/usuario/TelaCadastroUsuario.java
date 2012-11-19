package com.fean.tjsc.visual.usuario;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;


import com.fean.tjsc.dao.usuario.Usuario;
import com.fean.tjsc.mb.usuario.UsuarioMB;
import com.fean.tjsc.visual.principal.TelaPrincipal;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaCadastroUsuario extends JPanel {
	private JFormattedTextField txtEmail;
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JPasswordField passwordField;
	
	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuario() {

		JLabel lblCadastroDeUsurio = new JLabel("Cadastro de Usu\u00E1rio");
		lblCadastroDeUsurio.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblMatrcula = new JLabel("E-mail:");
		lblMatrcula.setHorizontalAlignment(SwingConstants.RIGHT);

		txtEmail = new JFormattedTextField();
		txtEmail.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);

		JLabel lblSenha = new JLabel("Matr\u00EDcula:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);

		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);

		JLabel lblSenha_1 = new JLabel("Senha:");
		lblSenha_1.setHorizontalAlignment(SwingConstants.RIGHT);

		final JRadioButton rdbtnAdministrador = new JRadioButton("Administrador do sistema");

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				UsuarioMB usuarioMB = UsuarioMB.getInstance();
				
				Usuario user = new Usuario();				

				user.setNome(txtNome.getText());
				user.setEmail(txtEmail.getText());
				user.setMatricula(txtMatricula.getText());
				user.setSenha(String.valueOf(passwordField.getPassword()));
				user.setAdministrador(rdbtnAdministrador.isSelected());

				String resultado = usuarioMB.validarUsuario(user);

				if (resultado == "ok"){
					usuarioMB.inserir(user);
					JOptionPane.showMessageDialog(null, "Cadastro Efetuado!");
					txtNome.setText("");
					txtEmail.setText("");
					txtMatricula.setText("");
					passwordField.setText("");					
					rdbtnAdministrador.setSelected(false);					
					voltarTelaListagem();					
				}
				else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + resultado);
				}					

			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtNome.setText("");
				txtEmail.setText("");
				txtMatricula.setText("");
				passwordField.setText("");				
				rdbtnAdministrador.setSelected(false);
			}
		});

		passwordField = new JPasswordField();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(176)
					.addComponent(lblCadastroDeUsurio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(176))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(278, Short.MAX_VALUE)
					.addComponent(btnLimpar)
					.addGap(18)
					.addComponent(btnCadastrar)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSenha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblMatrcula, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblSenha_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
						.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addComponent(txtMatricula, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
							.addGap(39)
							.addComponent(rdbtnAdministrador)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblCadastroDeUsurio, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMatrcula)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnAdministrador))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha_1))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnLimpar))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	public void voltarTelaListagem(){
		TelaPrincipal parent = (TelaPrincipal)getParent().getParent().getParent().getParent();
		parent.getContentPane().removeAll();
		parent.getContentPane().add(new TelaListaUsuario());
		parent.getContentPane().validate();   
		parent.getContentPane().repaint();
	}
}
