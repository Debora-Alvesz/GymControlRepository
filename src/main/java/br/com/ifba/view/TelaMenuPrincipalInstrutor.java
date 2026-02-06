/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.view;

import br.com.ifba.aluno.view.TelaListagemAlunos;
import br.com.ifba.avaliacaofisica.view.TelaAvaliacaoFisicaListar;
import br.com.ifba.exercicio.view.TelaExercicios;
import br.com.ifba.modalidade.controller.ModalidadeIController;
import br.com.ifba.modalidade.view.ModalidadeCadastroView;
import br.com.ifba.modalidade.view.ModalidadeView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author João Victor
 */
@Component
@Lazy // Evita travamento na inicialização
@Slf4j
public class TelaMenuPrincipalInstrutor extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaMenuPrincipalInstrutor.class.getName());

    public TelaMenuPrincipalInstrutor() {
        initComponents();
         // Importante: Não matar o app ao fechar esta janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRecInst = new javax.swing.JLabel();
        btnAlunos = new javax.swing.JButton();
        btnExercicios = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAvaliacaoFisica = new javax.swing.JButton();
        btnListarModalidade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRecInst.setText("MENU DE INSTRUTORES");

        btnAlunos.setText("ALUNOS");
        btnAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunosActionPerformed(evt);
            }
        });

        btnExercicios.setText("EXERCICIOS");
        btnExercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExerciciosActionPerformed(evt);
            }
        });

        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnAvaliacaoFisica.setText("AVALIAÇÃO FISICA");
        btnAvaliacaoFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaliacaoFisicaActionPerformed(evt);
            }
        });

        btnListarModalidade.setText("LISTAR MODALIDADES");
        btnListarModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarModalidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(lblRecInst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlunos)
                            .addComponent(btnExercicios)
                            .addComponent(btnAvaliacaoFisica)
                            .addComponent(btnListarModalidade))
                        .addGap(0, 220, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblRecInst))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSair)))
                .addGap(18, 18, 18)
                .addComponent(btnAlunos)
                .addGap(18, 18, 18)
                .addComponent(btnExercicios)
                .addGap(18, 18, 18)
                .addComponent(btnAvaliacaoFisica)
                .addGap(18, 18, 18)
                .addComponent(btnListarModalidade)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

    // Volta para o Login
        ContextProvider.getBean(TelaDeLogin.class).setVisible(true);
        // Fecha este menu
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlunosActionPerformed
    ContextProvider.getBean(TelaListagemAlunos.class).setVisible(true);
    }//GEN-LAST:event_btnAlunosActionPerformed

    private void btnExerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExerciciosActionPerformed
    ContextProvider.getBean(TelaExercicios.class).setVisible(true);
    }//GEN-LAST:event_btnExerciciosActionPerformed

    private void btnAvaliacaoFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliacaoFisicaActionPerformed
    ContextProvider.getBean(TelaAvaliacaoFisicaListar.class).setVisible(true);
    }//GEN-LAST:event_btnAvaliacaoFisicaActionPerformed

    private void btnListarModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarModalidadeActionPerformed

       
  ContextProvider.getBean(ModalidadeView.class).setVisible(true);
    }//GEN-LAST:event_btnListarModalidadeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlunos;
    private javax.swing.JButton btnAvaliacaoFisica;
    private javax.swing.JButton btnExercicios;
    private javax.swing.JButton btnListarModalidade;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblRecInst;
    // End of variables declaration//GEN-END:variables
}
