
package br.com.ifba.aluno.view;

import br.com.ifba.aluno.controller.AlunoController;
import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.infrastructure.util.ValidadorUtil;
import br.com.ifba.plano.controller.PlanoController;
import br.com.ifba.plano.entity.Plano;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


/**
 *
 * @author Débora Alves
 */

@Component
@Lazy
public class TelaMatriculaAlunos extends javax.swing.JFrame {

    @Autowired
    private AlunoController alunoController;
    
    @Autowired
    private PlanoController planoController;
    
    private Aluno aluno;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaMatriculaAlunos.class.getName());

    public TelaMatriculaAlunos() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Fecha só a janela, não o app
    }

    @PostConstruct
    public void init() {
        carregarPlanos();
    }
    
    // Método para atualizar sempre que abrir a janela
    @Override
    public void setVisible(boolean b) {
        if(b) {
            carregarPlanos();
            limparCampos();
        }
        super.setVisible(b);
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
                        .addGap(82, 82, 82)
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
                .addContainerGap(288, Short.MAX_VALUE))
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
                .addContainerGap(288, Short.MAX_VALUE))
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
       // 1. CAPTURA DOS DADOS (Isso estava faltando ou fora de escopo)
    String nome = txtNomeAluno.getText();
    String cpf = txtCpf.getText();
    String telefone = txtTelefone.getText();
    String email = txtEmail.getText();

    // 2. VALIDAÇÕES
    if (ValidadorUtil.isNullOrEmpty(nome) || ValidadorUtil.isNullOrEmpty(cpf) || ValidadorUtil.isNullOrEmpty(email)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Nome, CPF e E-mail são campos obrigatórios!");
        return;
    }
    
    if (!ValidadorUtil.isAlphabetic(nome)) {
        javax.swing.JOptionPane.showMessageDialog(this, "O Nome deve conter apenas letras!");
        return;
    }
    
    // 3. TENTATIVA DE SALVAR
    try {
        // Valida se tem plano selecionado
        if (cbPlanos.getSelectedItem() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um Plano para o aluno!");
            return;
        }

        this.aluno = new br.com.ifba.aluno.entity.Aluno();
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
        
        // --- CORREÇÃO AQUI ---
        // O banco de dados exige esse campo preenchido. 
        // Como não tem campo na tela pra isso, vamos colocar um padrão:
        aluno.setRequisitos("Nenhum"); 
        
        // Gerar matrícula
        String geradorMatricula = String.valueOf(System.currentTimeMillis());
        aluno.setMatricula(geradorMatricula);

        // Associar Plano
        String nomePlanoSelecionado = cbPlanos.getSelectedItem().toString();
        br.com.ifba.plano.entity.Plano planoEncontrado = planoController.findByNome(nomePlanoSelecionado);
        
        if (planoEncontrado == null) {
             javax.swing.JOptionPane.showMessageDialog(this, "Erro: Plano não encontrado no banco.");
             return;
        }

        aluno.setPlano(planoEncontrado);

        // Salva
        alunoController.save(aluno);

        javax.swing.JOptionPane.showMessageDialog(this, "Aluno matriculado com sucesso! Matrícula: " + geradorMatricula);
        limparCampos();
        this.dispose();

    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
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

private void limparCampos() {
        txtNomeAluno.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        if(cbPlanos.getItemCount() > 0) cbPlanos.setSelectedIndex(0);
    }

    private void carregarPlanos() {
        try {
            cbPlanos.removeAllItems();
            java.util.List<Plano> planos = planoController.findAll();
            
            if (planos != null && !planos.isEmpty()) {
                for (Plano plano : planos) {
                    cbPlanos.addItem(plano.getNome());
                }
            } else {
                cbPlanos.addItem("Nenhum plano cadastrado");
            }
        } catch (Exception e) {
             // Caso a tabela de planos ainda não exista ou esteja vazia
             cbPlanos.addItem("Erro ao carregar planos");
        }
    }
}