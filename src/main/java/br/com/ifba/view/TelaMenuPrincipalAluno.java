/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.view;

import br.com.ifba.avaliacaofisica.view.TelaAvaliacaoFisicaListar;
import br.com.ifba.exercicio.view.TelaExercicios;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author João Victor
 */
@Component
@Lazy // Adicionado para evitar travamentos na inicialização
@Slf4j
public class TelaMenuPrincipalAluno extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaMenuPrincipalAluno.class.getName());

    public TelaMenuPrincipalAluno() {
        initComponents();
         // Importante: Não matar o app ao fechar esta janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMenu = new javax.swing.JLabel();
        btnExercicio = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAvaliacaoFisica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMenu.setText("MENU DE ALUNO");

        btnExercicio.setText("EXERCICIOS");
        btnExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExercicioActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(lblMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExercicio)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAvaliacaoFisica)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSair)))
                .addGap(18, 18, 18)
                .addComponent(btnExercicio)
                .addGap(18, 18, 18)
                .addComponent(btnAvaliacaoFisica)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExercicioActionPerformed
// Abre a tela de exercícios gerenciada pelo Spring
        ContextProvider.getBean(TelaExercicios.class).setVisible(true);    }//GEN-LAST:event_btnExercicioActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
    // Volta para o Login
        ContextProvider.getBean(TelaDeLogin.class).setVisible(true);
        // Fecha o menu do aluno
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAvaliacaoFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliacaoFisicaActionPerformed
    // Abre a tela de avaliação física gerenciada pelo Spring
        ContextProvider.getBean(TelaAvaliacaoFisicaListar.class).setVisible(true);
    }//GEN-LAST:event_btnAvaliacaoFisicaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvaliacaoFisica;
    private javax.swing.JButton btnExercicio;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblMenu;
    // End of variables declaration//GEN-END:variables
}
