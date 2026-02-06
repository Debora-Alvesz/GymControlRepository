/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.view;

import br.com.ifba.aluno.view.TelaListagemAlunos;
import br.com.ifba.aluno.view.TelaMatriculaAlunos;
import br.com.ifba.instrutor.view.ListarInstrutorView;
import br.com.ifba.manutencao.view.TelaManutencao;
import br.com.ifba.modalidade.view.ModalidadeView;
import br.com.ifba.plano.view.TelaListagemPlanos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author João Victor
 */
@Component
@Lazy
@Slf4j
public class TelaMenuPrincipalRecepcionista extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaMenuPrincipalRecepcionista.class.getName());

    public TelaMenuPrincipalRecepcionista() {
        initComponents();
         // Importante: Não matar o app ao fechar esta janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnMatricularAlunos = new javax.swing.JButton();
        btnInstrutores = new javax.swing.JButton();
        btnListarAlunos = new javax.swing.JButton();
        btnModalidades = new javax.swing.JButton();
        btnManutencoes = new javax.swing.JButton();
        btnListarPlanos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MENU RECEPCIONISTA");

        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnMatricularAlunos.setText("MATRICULAR ALUNOS");
        btnMatricularAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularAlunosActionPerformed(evt);
            }
        });

        btnInstrutores.setText("INSTRUTORES");
        btnInstrutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstrutoresActionPerformed(evt);
            }
        });

        btnListarAlunos.setText("LISTAR ALUNOS");
        btnListarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAlunosActionPerformed(evt);
            }
        });

        btnModalidades.setText("MODALIDADES");
        btnModalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModalidadesActionPerformed(evt);
            }
        });

        btnManutencoes.setText("MANUTENÇÕES");
        btnManutencoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManutencoesActionPerformed(evt);
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
                .addGap(135, 135, 135)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMatricularAlunos)
                    .addComponent(btnInstrutores)
                    .addComponent(btnListarAlunos)
                    .addComponent(btnModalidades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManutencoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnListarPlanos)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSair)))
                .addGap(26, 26, 26)
                .addComponent(btnMatricularAlunos)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnListarAlunos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnListarPlanos)))
                .addGap(18, 18, 18)
                .addComponent(btnInstrutores)
                .addGap(18, 18, 18)
                .addComponent(btnModalidades)
                .addGap(18, 18, 18)
                .addComponent(btnManutencoes)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
// Volta para o Login
        ContextProvider.getBean(TelaDeLogin.class).setVisible(true);
        // Fecha este menu
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnMatricularAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularAlunosActionPerformed
        ContextProvider.getBean(TelaMatriculaAlunos.class).setVisible(true);

    }//GEN-LAST:event_btnMatricularAlunosActionPerformed

    private void btnListarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAlunosActionPerformed
    ContextProvider.getBean(TelaListagemAlunos.class).setVisible(true);
    }//GEN-LAST:event_btnListarAlunosActionPerformed

    private void btnInstrutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstrutoresActionPerformed
    ContextProvider.getBean(ListarInstrutorView.class).setVisible(true);
    }//GEN-LAST:event_btnInstrutoresActionPerformed

    private void btnModalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModalidadesActionPerformed
    ContextProvider.getBean(ModalidadeView.class).setVisible(true);
    }//GEN-LAST:event_btnModalidadesActionPerformed

    private void btnManutencoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManutencoesActionPerformed
    ContextProvider.getBean(TelaManutencao.class).setVisible(true);
    }//GEN-LAST:event_btnManutencoesActionPerformed

    private void btnListarPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPlanosActionPerformed
    ContextProvider.getBean(TelaListagemPlanos.class).setVisible(true);
    }//GEN-LAST:event_btnListarPlanosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInstrutores;
    private javax.swing.JButton btnListarAlunos;
    private javax.swing.JButton btnListarPlanos;
    private javax.swing.JButton btnManutencoes;
    private javax.swing.JButton btnMatricularAlunos;
    private javax.swing.JButton btnModalidades;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
