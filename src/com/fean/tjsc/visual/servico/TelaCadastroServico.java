/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fean.tjsc.visual.servico;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;

/**
 *
 * @author victor.viana
 */
public class TelaCadastroServico extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaServico
     */
    public TelaCadastroServico() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtKm = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtOrcamento = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();

        setResizable(true);
        setTitle("Cadastro de Servi\u00E7o");
        setPreferredSize(new java.awt.Dimension(730, 394));
        getContentPane().setLayout(null);

        jPanel1.setPreferredSize(new Dimension(632, 552));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Ve�culo");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Motorista");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Fonercedor");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Tipo de Servi�o");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout gl_jPanel2 = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(gl_jPanel2);
        gl_jPanel2.setHorizontalGroup(
            gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel2.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gl_jPanel2.createSequentialGroup()
                        .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        gl_jPanel2.setVerticalGroup(
            gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel2.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/save(2).png"))); // NOI18N
        jButton1.setText("salvar");

        jLabel10.setText("Descri��o do Servi�o");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/exit.png"))); // NOI18N
        jButton2.setText("sair");

        jLabel5.setText("Data ");

        jLabel6.setText("Valor");

        jLabel7.setText("N.Or�amento");

        jLabel8.setText("NF - Ticket");
        jLabel8.setToolTipText("Nota fiscal  Ticket");
        txtKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4_NF_TicketActionPerformed(evt);
            }
        });

        jLabel9.setText("Km");

        javax.swing.GroupLayout gl_jPanel1 = new javax.swing.GroupLayout(jPanel1);
        gl_jPanel1.setHorizontalGroup(
        	gl_jPanel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(32)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGap(142)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel7)
        								.addComponent(jLabel9)
        								.addComponent(jLabel8)
        								.addComponent(jLabel6)
        								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
        							.addGap(41)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        								.addComponent(txtNF, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txtData, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txtKm, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txtOrcamento, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGap(47)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel10)
        								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)))))))
        );
        gl_jPanel1.setVerticalGroup(
        	gl_jPanel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        								.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel5))
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        								.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel6))
        							.addGap(12)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        								.addComponent(txtNF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel8))
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        								.addComponent(txtKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel9))
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        								.addComponent(txtOrcamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel7))))
        					.addGap(39)
        					.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton2)
        				.addComponent(jButton1))
        			.addGap(35))
        );
        gl_jPanel1.linkSize(SwingConstants.VERTICAL, new Component[] {jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});
        gl_jPanel1.linkSize(SwingConstants.VERTICAL, new Component[] {txtNF, txtKm, txtOrcamento, txtValor, txtData});
        gl_jPanel1.linkSize(SwingConstants.VERTICAL, new Component[] {jButton1, jButton2});
        gl_jPanel1.linkSize(SwingConstants.HORIZONTAL, new Component[] {jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});
        gl_jPanel1.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtNF, txtKm, txtOrcamento, txtValor, txtData});
        gl_jPanel1.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButton1, jButton2});
        jPanel1.setLayout(gl_jPanel1);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 676, 396);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-692)/2, (screenSize.height-410)/2, 691, 415);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4_NF_TicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4_NF_TicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4_NF_TicketActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtNF;
    private javax.swing.JTextField txtKm;
    private javax.swing.JTextField txtOrcamento;
    // End of variables declaration//GEN-END:variables
}
