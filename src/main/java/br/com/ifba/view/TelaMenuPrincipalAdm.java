/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
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
import br.com.ifba.plano.view.TelaListagemPlanos;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author João Victor
 */
@Component
@Lazy // Adicionado para não carregar a tela antes da hora
@Slf4j
public class TelaMenuPrincipalAdm extends javax.swing.JFrame {
    
    // Removi os Controllers daqui. 
    // Motivo: No padrão Spring, a tela "filha" que injeta o controller dela.
    // Você não precisa mais passar eles por parâmetro.

    /**
     * Creates new form TelaMenuPrincipal
     */
    public TelaMenuPrincipalAdm() {
        initComponents();
        // Construtor limpo, sem lógica pesada
         // Importante: Não matar o app ao fechar esta janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        btnListarPlanos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MENU ADMINISTRADOR");

        btnAlunos.setText("LISTAR ALUNOS ");
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

        btnListarPlanos.setText("LISTAR PLANOS");
        btnListarPlanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPlanosActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnListRecep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addComponent(btnListarPlanos)
                                .addGap(81, 81, 81))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAlunos)
                                    .addComponent(btnCadInst)
                                    .addComponent(btnListInst)
                                    .addComponent(btnFinanceiro)
                                    .addComponent(btnCadRecep))
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                .addGap(18, 18, 18)
                .addComponent(btnCadRecep)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListRecep)
                    .addComponent(btnListarPlanos))
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
    ContextProvider.getBean(TelaListagemAlunos.class).setVisible(true);
    }//GEN-LAST:event_btnAlunosActionPerformed

    private void btnCadRecepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadRecepActionPerformed
    ContextProvider.getBean(TelaCadastroRecepcionista.class).setVisible(true);
    }//GEN-LAST:event_btnCadRecepActionPerformed

    private void btnListRecepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListRecepActionPerformed
    ContextProvider.getBean(TelaListagemRecepcionista.class).setVisible(true);
    }//GEN-LAST:event_btnListRecepActionPerformed

    private void btnCadInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadInstActionPerformed
    ContextProvider.getBean(AdicionarInstrutorView.class).setVisible(true);
    }//GEN-LAST:event_btnCadInstActionPerformed

    private void btnListInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListInstActionPerformed
    ContextProvider.getBean(ListarInstrutorView.class).setVisible(true);
    }//GEN-LAST:event_btnListInstActionPerformed

    private void btnFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanceiroActionPerformed
    ContextProvider.getBean(TelaRelatorioFinanceiro.class).setVisible(true);
    }//GEN-LAST:event_btnFinanceiroActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
       // Abre a tela de Login
        ContextProvider.getBean(TelaDeLogin.class).setVisible(true);   
        // Fecha o menu atual
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnListarPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPlanosActionPerformed
    ContextProvider.getBean(TelaListagemPlanos.class).setVisible(true);
    }//GEN-LAST:event_btnListarPlanosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlunos;
    private javax.swing.JButton btnCadInst;
    private javax.swing.JButton btnCadRecep;
    private javax.swing.JButton btnFinanceiro;
    private javax.swing.JButton btnListInst;
    private javax.swing.JButton btnListRecep;
    private javax.swing.JButton btnListarPlanos;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
