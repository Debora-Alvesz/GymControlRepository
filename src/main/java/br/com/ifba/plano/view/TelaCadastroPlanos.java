
package br.com.ifba.plano.view;

import br.com.ifba.infrastructure.util.ValidadorUtil;
import br.com.ifba.plano.controller.PlanoIController;
import br.com.ifba.plano.entity.Plano;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.ifba.view.ContextProvider; 
import br.com.ifba.plano.controller.PlanoIController;

/**
 *
 * @author Débora Alves
 */
@Component
public class TelaCadastroPlanos extends javax.swing.JDialog {
    
   @Autowired
    private PlanoIController planoController; // Injeção direta pelo Spring

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastroPlanos.class.getName());

    // Construtor sem argumentos para o Spring
    public TelaCadastroPlanos() {
        // Define null como parent e true para modal (bloqueia a janela de trás)
        super((java.awt.Frame) null, true); 
        initComponents();
        setLocationRelativeTo(null); // Centraliza na tela
    }

    // Método publico para limpar campos ao abrir a tela novamente
    public void limparCampos() {
        txtNomePlano.setText("");
        txtDuracao.setText("");
        txtValorMensal.setText("");
        txtValorMatricula.setText("");
        txtBeneficios.setText("");
        txtNomePlano.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblDuração = new javax.swing.JLabel();
        lblValorMensal = new javax.swing.JLabel();
        lblBeneficios = new javax.swing.JLabel();
        lblNomePlano = new javax.swing.JLabel();
        txtNomePlano = new javax.swing.JTextField();
        txtDuracao = new javax.swing.JTextField();
        txtValorMensal = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        lblValorMatricula = new javax.swing.JLabel();
        txtValorMatricula = new javax.swing.JTextField();
        txtBeneficios = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cadastrar novo Plano");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        lblDuração.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDuração.setForeground(new java.awt.Color(255, 255, 255));
        lblDuração.setText("Duração:");

        lblValorMensal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblValorMensal.setForeground(new java.awt.Color(255, 255, 255));
        lblValorMensal.setText("Valor Mensal:");

        lblBeneficios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBeneficios.setForeground(new java.awt.Color(255, 255, 255));
        lblBeneficios.setText("Benefícios:");

        lblNomePlano.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomePlano.setForeground(new java.awt.Color(255, 255, 255));
        lblNomePlano.setText("Nome do plano:");

        txtNomePlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePlanoActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblValorMatricula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblValorMatricula.setForeground(new java.awt.Color(255, 255, 255));
        lblValorMatricula.setText("Valor da Matrícula:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNomePlano, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValorMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDuração)
                            .addComponent(lblValorMatricula)
                            .addComponent(lblBeneficios))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValorMensal, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                            .addComponent(txtDuracao)
                            .addComponent(txtValorMatricula)
                            .addComponent(txtNomePlano)
                            .addComponent(txtBeneficios)))
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
                    .addComponent(lblNomePlano, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomePlano, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuração, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(197, Short.MAX_VALUE))
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

    private void txtNomePlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePlanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePlanoActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
    br.com.ifba.plano.entity.Plano novoObjetoPlano = new br.com.ifba.plano.entity.Plano();
        
        // 1. Captura os dados
        String nome = txtNomePlano.getText();
        String duracaoStr = txtDuracao.getText();
        String valorMensalStr = txtValorMensal.getText();
        String valorMatriculaStr = txtValorMatricula.getText();
        String beneficios = txtBeneficios.getText();

        // 2. Validação básica
        if (ValidadorUtil.isNullOrEmpty(nome) || 
            ValidadorUtil.isNullOrEmpty(duracaoStr) || 
            ValidadorUtil.isNullOrEmpty(valorMensalStr)) {
            
            javax.swing.JOptionPane.showMessageDialog(this, "Os campos Nome, Duração e Valor Mensal são obrigatórios!");
            return;
        }

        try {
            // 3. Conversão de tipos
            int duracao = Integer.parseInt(duracaoStr);
            double valorMensal = Double.parseDouble(valorMensalStr.replace(",", "."));
            float valorMatricula = 0;
            
            if (!ValidadorUtil.isNullOrEmpty(valorMatriculaStr)) {
                valorMatricula = Float.parseFloat(valorMatriculaStr.replace(",", "."));
            }

            // 4. Preenche objeto
            novoObjetoPlano.setNome(nome);
            novoObjetoPlano.setDuracao(duracao);
            novoObjetoPlano.setValor(valorMensal);
            novoObjetoPlano.setValorMatricula(valorMatricula);
            novoObjetoPlano.setBeneficios(beneficios);
            
            // Campos automáticos
            novoObjetoPlano.setStatus(true);
            novoObjetoPlano.setDataCriacao(LocalDate.now());
            novoObjetoPlano.setId(null);
            
            // 5. Salva usando o Controller injetado
            this.planoController.save(novoObjetoPlano);
            
            javax.swing.JOptionPane.showMessageDialog(this, "Plano cadastrado com sucesso!");
            
            // 6. Limpa e fecha
            limparCampos();
            this.dispose(); 

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Erro nos números! Verifique Duração e Valores.\nUse apenas números.", 
                "Erro de Formato", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Erro ao salvar plano", e);
            javax.swing.JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
   
    }//GEN-LAST:event_btnCadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBeneficios;
    private javax.swing.JLabel lblDuração;
    private javax.swing.JLabel lblNomePlano;
    private javax.swing.JLabel lblValorMatricula;
    private javax.swing.JLabel lblValorMensal;
    private javax.swing.JTextField txtBeneficios;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtNomePlano;
    private javax.swing.JTextField txtValorMatricula;
    private javax.swing.JTextField txtValorMensal;
    // End of variables declaration//GEN-END:variables
}