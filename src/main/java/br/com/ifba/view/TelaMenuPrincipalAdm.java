
package br.com.ifba.view;

import br.com.ifba.aluno.controller.AlunoIController;
import br.com.ifba.aluno.view.TelaListagemAlunos;
import br.com.ifba.instrutor.view.AdicionarInstrutorView;
import br.com.ifba.instrutor.view.ListarInstrutorView;
import br.com.ifba.pagamento.view.TelaRelatorioFinanceiro;
import br.com.ifba.recepcionista.controller.RecepcionistaIController;
import br.com.ifba.recepcionista.view.TelaCadastroRecepcionista;
import br.com.ifba.recepcionista.view.TelaListagemRecepcionista;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.ifba.aluno.view.TelaListagemAlunos;
import br.com.ifba.plano.view.TelaCadastroPlanos;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author João Victor
 */
@Component
@Slf4j
public class TelaMenuPrincipalAdm extends javax.swing.JFrame {
   // --- INJEÇÃO DAS TELAS ---
    // Usamos @Lazy para que a tela só seja criada na memória quando o botão for clicado.
    
    @Autowired
    @Lazy
    private TelaListagemRecepcionista telaListagemRecepcionista;

    @Autowired
    @Lazy
    private TelaCadastroRecepcionista telaCadastroRecepcionista;
    
    @Autowired
    @Lazy
    private TelaListagemAlunos telaListagemAlunos;

    @Autowired
    @Lazy
    private AdicionarInstrutorView adicionarInstrutorView;

    @Autowired
    @Lazy
    private ListarInstrutorView listarInstrutorView;

    @Autowired
    @Lazy
    private TelaRelatorioFinanceiro telaRelatorioFinanceiro;
    
    @Autowired
    @Lazy
    private TelaCadastroPlanos telaCadastroPlanos;
    
    // Injeção da tela de Login para o botão Sair (opcional, mas recomendado)
    // @Autowired @Lazy private TelaDeLogin telaDeLogin; 

    public TelaMenuPrincipalAdm() {
        initComponents();
        // Centraliza a janela ao abrir
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAlunos = new javax.swing.JButton();
        btnCadRecep = new javax.swing.JButton();
        btnListRecep = new javax.swing.JButton();
        btnCadInst = new javax.swing.JButton();
        btnListInst = new javax.swing.JButton();
        btnFinanceiro = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        cadastrarPlanos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MENU ADMINISTRADOR");

        btnAlunos.setText("ALUNOS");
        btnAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunosActionPerformed(evt);
            }
        });

        btnCadRecep.setText("CADASTRAR RECEPCIONISTA");
        btnCadRecep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadRecepActionPerformed(evt);
            }
        });

        btnListRecep.setText("LISTAR RECEPCIONISTAS");
        btnListRecep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListRecepActionPerformed(evt);
            }
        });

        btnCadInst.setText("CADASTRAR INSTRUTORES");
        btnCadInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadInstActionPerformed(evt);
            }
        });

        btnListInst.setText("LISTAR INSTRUTORES");
        btnListInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListInstActionPerformed(evt);
            }
        });

        btnFinanceiro.setText("FINANCEIRO");
        btnFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinanceiroActionPerformed(evt);
            }
        });

        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        cadastrarPlanos.setText("Planos");
        cadastrarPlanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPlanosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAlunos)
                                    .addComponent(btnListRecep)
                                    .addComponent(btnCadInst)
                                    .addComponent(btnListInst)
                                    .addComponent(btnFinanceiro))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadRecep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cadastrarPlanos)
                                .addGap(39, 39, 39)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSair))
                .addGap(18, 18, 18)
                .addComponent(btnAlunos)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCadRecep))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(cadastrarPlanos)))
                .addGap(18, 18, 18)
                .addComponent(btnListRecep)
                .addGap(18, 18, 18)
                .addComponent(btnCadInst)
                .addGap(18, 18, 18)
                .addComponent(btnListInst)
                .addGap(18, 18, 18)
                .addComponent(btnFinanceiro)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlunosActionPerformed
// CORRIGIDO: Usa a instância injetada
        this.telaListagemAlunos.setVisible(true);    }//GEN-LAST:event_btnAlunosActionPerformed

    private void btnCadRecepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadRecepActionPerformed
// CORRIGIDO: Usa a instância que o Spring criou
        this.telaCadastroRecepcionista.setVisible(true);    }//GEN-LAST:event_btnCadRecepActionPerformed

    private void btnListRecepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListRecepActionPerformed
// CORRIGIDO: O "new" foi removido. Agora o Controller dentro dela NÃO será null.
        this.telaListagemRecepcionista.setVisible(true);
        // Opcional: Forçar atualização da tabela ao abrir
        this.telaListagemRecepcionista.atualizarTabela();    }//GEN-LAST:event_btnListRecepActionPerformed

    private void btnCadInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadInstActionPerformed
// CORRIGIDO
         this.adicionarInstrutorView.setVisible(true);    }//GEN-LAST:event_btnCadInstActionPerformed

    private void btnListInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListInstActionPerformed
// CORRIGIDO
        this.listarInstrutorView.setVisible(true);    }//GEN-LAST:event_btnListInstActionPerformed

    private void btnFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanceiroActionPerformed
       // CORRIGIDO
        this.telaRelatorioFinanceiro.setVisible(true);
    }//GEN-LAST:event_btnFinanceiroActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
this.dispose(); 
        new TelaDeLogin().setVisible(true);    }//GEN-LAST:event_btnSairActionPerformed

    private void cadastrarPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPlanosActionPerformed
// Chama a tela injetada pelo Spring
        this.telaCadastroPlanos.setVisible(true);
    }//GEN-LAST:event_cadastrarPlanosActionPerformed

    public static void main(String args[]) {
        /* IMPORTANTE: 
           Ao rodar por aqui (Shift+F6), o Spring NÃO é iniciado, então as telas injetadas serão NULL.
           Para testar com tudo funcionando, você deve rodar a classe principal da aplicação (App.java ou Application.java)
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipalAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuPrincipalAdm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlunos;
    private javax.swing.JButton btnCadInst;
    private javax.swing.JButton btnCadRecep;
    private javax.swing.JButton btnFinanceiro;
    private javax.swing.JButton btnListInst;
    private javax.swing.JButton btnListRecep;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton cadastrarPlanos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
