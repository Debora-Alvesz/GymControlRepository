
package br.com.ifba.recepcionista.view;

import br.com.ifba.infrastructure.util.ValidadorUtil;
import br.com.ifba.recepcionista.controller.RecepcionistaIController;
import br.com.ifba.recepcionista.entity.Recepcionista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Débora Alves
 */
@Component
public class TelaCadastroRecepcionista extends javax.swing.JFrame {
    
    @Autowired
    private RecepcionistaIController recepcionistaController; // Injeta a interface do controller

    private Recepcionista recepcionista; // O objeto que será persistido
    
    // Logger para registrar eventos e erros
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastroRecepcionista.class.getName());
    
    public TelaCadastroRecepcionista() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblCpf = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblNomeRecepcionista = new javax.swing.JLabel();
        txtNomeRecepcionista = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cadastrar novo Recepcionista");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        lblCpf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCpf.setForeground(new java.awt.Color(255, 255, 255));
        lblCpf.setText("CPF:");

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone:");

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(255, 255, 255));
        lblEndereco.setText("Endereço:");

        lblNomeRecepcionista.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomeRecepcionista.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeRecepcionista.setText("Nome");

        txtNomeRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeRecepcionistaActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                                    .addComponent(txtCpf)
                                    .addComponent(txtEmail)
                                    .addComponent(txtNomeRecepcionista)
                                    .addComponent(txtEndereco)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeRecepcionistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeRecepcionistaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        // 1. Captura os dados da tela
        String nome = txtNomeRecepcionista.getText();
        String cpf = txtCpf.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();


        // 2. Validação: Campos obrigatórios (usando ValidadorUtil)
        if (ValidadorUtil.isNullOrEmpty(nome) || ValidadorUtil.isNullOrEmpty(cpf) || 
            ValidadorUtil.isNullOrEmpty(email)) {
            
            javax.swing.JOptionPane.showMessageDialog(this, "Os campos são obrigatórios!");
            return;
        }

        // 3. Validações Específicas
        if (!ValidadorUtil.isAlphabetic(nome)) {
            javax.swing.JOptionPane.showMessageDialog(this, "O Nome deve conter apenas letras!");
            return;
        }
        
        if (!ValidadorUtil.hasMinLength(nome, 3)){
            javax.swing.JOptionPane.showMessageDialog(this, "O Nome deve ter no mínimo 3 caracteres!");
            return;
        }

        if (!ValidadorUtil.isNullOrEmpty(telefone) && !ValidadorUtil.isNumeric(telefone)) {
            
             javax.swing.JOptionPane.showMessageDialog(this, "Telefone inválido.");
        }

        if (!ValidadorUtil.isCpfValido(cpf)) {
            javax.swing.JOptionPane.showMessageDialog(this, "CPF Inválido!");
            return;
       }
        
        if (!ValidadorUtil.isValidEmail(email)) {
            javax.swing.JOptionPane.showMessageDialog(this, "E-mail Inválido!");
            txtEmail.requestFocus();
            return;
        }

        try {
            // 4. Instancia e preenche o objeto
            this.recepcionista = new Recepcionista();
            recepcionista.setNome(nome);
            recepcionista.setCpf(cpf);
            recepcionista.setTelefone(telefone);
            recepcionista.setEmail(email);

            // 5. Envia para o Controller
            recepcionistaController.save(recepcionista);

            // 6. Feedback e Limpeza
            javax.swing.JOptionPane.showMessageDialog(this, "Recepcionista cadastrada com sucesso!");
            limparCampos();

        } catch (Exception e) {
            // Captura erros de negócio (ex: Login já existe) ou banco
            logger.log(java.util.logging.Level.SEVERE, "Erro ao salvar", e);
            javax.swing.JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
  
    }//GEN-LAST:event_btnCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNomeRecepcionista;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeRecepcionista;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

// Método auxiliar para limpar a tela
    private void limparCampos() {
        txtNomeRecepcionista.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        // Focar no primeiro campo
        txtNomeRecepcionista.requestFocus();
    }
}
