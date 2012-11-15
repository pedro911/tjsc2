package com.fean.tjsc.visual.principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import TestesVisual.TelaPrincipal;

import com.fean.tjsc.mb.marca.MarcaMB;
import com.fean.tjsc.mb.usuario.UsuarioMB;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Controle de Servi\u00E7os v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSistemaDeControle = new JLabel("Sistema de Controle de Servi\u00E7os");
		lblSistemaDeControle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSistemaDeControle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblTjsc = new JLabel("Frota de Ve\u00EDculos TJSC");
		lblTjsc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTjsc.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSenha = new JLabel("Senha:");
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				UsuarioMB usuarioMB = UsuarioMB.getInstance();
				
				boolean resultado = usuarioMB.validarUsuarioLogin(txtUsuario.getText(), String.valueOf(txtSenha.getPassword()));
				
				JOptionPane.showMessageDialog(null, resultado);
				
				if (resultado == true){
					JOptionPane.showMessageDialog(null, "Logado");
					boolean adm = usuarioMB.verificaUsuarioAdministrador(txtUsuario.getText());
					JOptionPane.showMessageDialog(null, "é adm: " + adm);
					TelaPrincipal.adm = adm;
					TelaPrincipal.usuario = txtUsuario.getText();
					//aqui abrir tela principal
					TelaPrincipal p1 = new TelaPrincipal();
					setVisible(false);
					p1.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos, tente novamente!");
				}
			}
		});
		
		txtSenha = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSistemaDeControle, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOk, Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUsurio, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSenha))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtSenha)
										.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))))
						.addComponent(lblTjsc, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblSistemaDeControle, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTjsc, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsurio)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnOk)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
	}
}
