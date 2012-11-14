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
	private JPasswordField passwordField_1;
	private JLabel lblEmailInvlido = new JLabel("");

	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuario() {

		JLabel lblCadastroDeUsurio = new JLabel("Cadastro de Usu\u00E1rio");
		lblCadastroDeUsurio.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNome = new JLabel("Nome:");

		JLabel lblMatrcula = new JLabel("E-mail:");

		txtEmail = new JFormattedTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if ((txtEmail.getText().contains("@")) &&
						(txtEmail.getText().contains(".")) &&
						(!txtEmail.getText().contains(" "))) {

					String usuario = new String(txtEmail.getText().substring(0,txtEmail.getText().lastIndexOf('@')));

					String dominio = new String(txtEmail.getText().substring(txtEmail.getText().lastIndexOf('@') + 1, txtEmail.getText().length()));

					if ((usuario.length() >=1) && (!usuario.contains("@")) 
							&& (dominio.contains(".")) && (!dominio.contains("@")) 
							&& (dominio.indexOf(".") >=1) 
							&& (dominio.lastIndexOf(".") < dominio.length() - 1)) {
						lblEmailInvlido.setText("");
					} 
					else {
						lblEmailInvlido.setText("E-mail Inválido");
						lblEmailInvlido.setForeground(Color.RED);
						txtEmail.requestFocus();
					}
				} 
				else {
					lblEmailInvlido.setText("E-mail Inválido");
					txtEmail.requestFocus();
					lblEmailInvlido.setForeground(Color.RED);
				}
			}
		});
		txtEmail.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);

		JLabel lblSenha = new JLabel("Matr\u00EDcula:");

		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);

		JLabel lblSenha_1 = new JLabel("Senha:");

		final JRadioButton rdbtnAdministrador = new JRadioButton("Administrador do sistema");

		JLabel lblConfirmeASenha = new JLabel("Confirme a senha:");

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				UsuarioMB usuarioMB = UsuarioMB.getInstance();
				Usuario user = new Usuario();

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

				else {
					user.setNome(txtNome.getText());
					user.setEmail(txtEmail.getText());
					user.setMatricula(txtMatricula.getText());
					user.setSenha(String.valueOf(passwordField.getPassword()));
					user.setAdministrador(rdbtnAdministrador.isEnabled());

					String resultado = usuarioMB.inserir(user);

					if (resultado == "ok"){
						JOptionPane.showMessageDialog(null, "Cadastro Efetuado!");
						txtNome.setText("");
						txtEmail.setText("");
						txtMatricula.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
						rdbtnAdministrador.setSelected(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar, tente novamente.");
					}					
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
				passwordField_1.setText("");
				rdbtnAdministrador.setSelected(false);
			}
		});

		passwordField = new JPasswordField();

		passwordField_1 = new JPasswordField();	

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(176)
						.addComponent(lblCadastroDeUsurio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(176))
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNome)
								.addGap(26)
								.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
								.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblSenha)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtMatricula, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
										.addGap(60)
										.addComponent(rdbtnAdministrador)
										.addContainerGap())
										.addGroup(groupLayout.createSequentialGroup()
												.addContainerGap()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
																.addComponent(btnLimpar)
																.addGap(18)
																.addComponent(btnCadastrar))
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblSenha_1)
																		.addGap(23)
																		.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(lblConfirmeASenha)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
																		.addContainerGap())
																		.addGroup(groupLayout.createSequentialGroup()
																				.addContainerGap()
																				.addComponent(lblMatrcula)
																				.addGap(25)
																				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																						.addComponent(lblEmailInvlido)
																						.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
																						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblCadastroDeUsurio, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addGap(23)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(31)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblMatrcula)
										.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblEmailInvlido)
										.addGap(13)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblSenha)
												.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(rdbtnAdministrador))
												.addGap(31)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblSenha_1)
														.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblConfirmeASenha))
														.addGap(28)
														.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
																.addComponent(btnCadastrar)
																.addComponent(btnLimpar))
																.addContainerGap(56, Short.MAX_VALUE))
				);
		setLayout(groupLayout);

	}	
}
