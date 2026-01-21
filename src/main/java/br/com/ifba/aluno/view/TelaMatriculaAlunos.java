
package br.com.ifba.aluno.view;

import br.com.ifba.aluno.controller.AlunoController;
import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.infrastructure.util.ValidadorUtil;
import br.com.ifba.plano.controller.PlanoController;
import br.com.ifba.plano.entity.Plano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 * @author Débora Alves
 */

@Component // Permite que o Spring gerencie esta tela

public class TelaMatriculaAlunos extends javax.swing.JFrame {
    
    @Autowired
    private AlunoController alunoController; // Injeta o controller

    @Autowired
    private Aluno aluno; // O Spring cria e gerencia o objeto Aluno 
    
    @Autowired
    private PlanoController planoController; // Injeta o controller de planos
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaMatriculaAlunos.class.getName());

    public TelaMatriculaAlunos() {
        initComponents();
        carregarPlanos();  // Carrega os dados do banco no ComboBox
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblCpf = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblPlano = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNomeAluno = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        cbPlanos = new javax.swing.JComboBox<>();
        btnMatricular = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Matricular novo Aluno");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        lblCpf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCpf.setForeground(new java.awt.Color(255, 255, 255));
        lblCpf.setText("CPF:");

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone:");

        lblPlano.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPlano.setForeground(new java.awt.Color(255, 255, 255));
        lblPlano.setText("Plano:");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome");

        txtNomeAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAlunoActionPerformed(evt);
            }
        });

        cbPlanos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mensal", "Anual", "Semestral" }));

        btnMatricular.setText("Matricular");
        btnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularActionPerformed(evt);
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
                        .addGap(70, 70, 70)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefone)
                                    .addComponent(txtCpf)
                                    .addComponent(txtEmail)
                                    .addComponent(txtNomeAluno)
                                    .addComponent(cbPlanos, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlano, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPlanos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
        
        // 1. Captura os dados da tela (incluindo o novo campo de e-mail)
        String nome = txtNomeAluno.getText();
        String cpf = txtCpf.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();
    
        //Validação: Campos obrigatórios (usando isNullOrEmpty)
        if (ValidadorUtil.isNullOrEmpty(nome) || ValidadorUtil.isNullOrEmpty(cpf) || ValidadorUtil.isNullOrEmpty(email)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nome, CPF e E-mail são campos obrigatórios!");
            return;
        }
        // 3. Validação: Nome deve ter apenas letras (isAlphabetic) e tamanho mínimo
        if (!ValidadorUtil.isAlphabetic(nome)) {
            javax.swing.JOptionPane.showMessageDialog(this, "O Nome deve conter apenas letras!");
            return;
        }
        if (!ValidadorUtil.hasMinLength(nome, 3)){
            javax.swing.JOptionPane.showMessageDialog(this, "O Nome deve ter no mínimo 3 caracteres!");
            return;
        }
        // 5. Validação: Telefone deve conter apenas números (isNumeric)
        if (!ValidadorUtil.isNullOrEmpty(telefone) && !ValidadorUtil.isNumeric(telefone)) {
            javax.swing.JOptionPane.showMessageDialog(this, "O Telefone deve conter apenas números!");
            return;
        }

        // Valida o CPF usando classe ValidadorUtil 
        if (!ValidadorUtil.isCpfValido(txtCpf.getText())) {
            javax.swing.JOptionPane.showMessageDialog(this, "CPF Inválido!");
            return; // Interrompe se o CPF estiver errado
        }
            //Validação de E-mail na tela
        if (!ValidadorUtil.isValidEmail(email)) {
            javax.swing.JOptionPane.showMessageDialog(this, "E-mail Inválido! Verifique o formato (ex: nome@email.com).");
            txtEmail.requestFocus(); // Foca no campo de e-mail para o usuário corrigir
            return;
        }

        try {
            // Cria uma nova instância de Aluno (uma ficha em branco)
            //  entidades de dados precisam ser instanciadas para não sobrescrever o anterior.
            this.aluno = new Aluno();
            aluno.setName(txtNomeAluno.getText());
            aluno.setCpf(txtCpf.getText());
            aluno.setTelefone(txtTelefone.getText());
            aluno.setEmail(email);

            // aqui futuramente pega o plano selecionado no ComboBox quando tiver planos cadastrados lá
          
            // Envia o objeto preenchido para o Controller
            alunoController.save(aluno);

            // Feedback de sucesso para o usuário
            javax.swing.JOptionPane.showMessageDialog(this, "Aluno matriculado com sucesso!");
            limparCampos(); // Método para limpar os campos da tela

        } catch (Exception e) {
            // Mostra o erro caso a matrícula ou CPF já existam no banco
            javax.swing.JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnMatricularActionPerformed

    private void txtNomeAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAlunoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMatricular;
    private javax.swing.JComboBox<String> cbPlanos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPlano;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNomeAluno;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    // Método auxiliar para limpar a tela
private void limparCampos() {
    txtNomeAluno.setText("");
    txtCpf.setText("");
    txtTelefone.setText("");
    txtEmail.setText("");
    cbPlanos.setSelectedIndex(0);
    }

private void carregarPlanos() {
    try {
        // Busca a lista de planos através do controller
        java.util.List<Plano> planos = planoController.findAll();

        // Limpa o ComboBox para não duplicar itens
        cbPlanos.removeAllItems();

        // Verifica se a lista não está vazia
        if (planos != null && !planos.isEmpty()) {
            // Percorre a lista de planos vinda do banco
            for (Plano plano : planos) {
                // Adiciona o nome do plano no ComboBox da tela
                cbPlanos.addItem(plano.getNome());
            }
        } else {
            // Se não tiver planos, coloca um aviso opcional
            cbPlanos.addItem("Nenhum plano cadastrado");
        }
    } catch (Exception e) {
        // Se der erro (ex: banco desligado), loga o erro mas não trava a tela
        logger.log(java.util.logging.Level.SEVERE, "Erro ao carregar planos", e);
     }
    }
}