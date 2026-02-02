
package br.com.ifba.recepcionista.view;

import br.com.ifba.recepcionista.controller.RecepcionistaIController;
import br.com.ifba.recepcionista.entity.Recepcionista;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author Débora Alves
 */
@Component
public class TelaListagemRecepcionista extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaListagemRecepcionista.class.getName());

    @Autowired
    private RecepcionistaIController recepcionistaController;

    // Usamos @Lazy para evitar erro de ciclo (TelaListagem chama Cadastro, Cadastro chama Listagem)
    @Autowired
    @Lazy
    private TelaCadastroRecepcionista telaCadastroRecepcionista;

    private DefaultTableModel modeloTabela;
    
    public TelaListagemRecepcionista() {
        initComponents();
        // Configura o modelo da tabela para podermos adicionar linhas
        modeloTabela = (DefaultTableModel) tblRecepcionistas.getModel();
        tblRecepcionistas.setEnabled(true); // Permite clicar na linha para selecionar
    }
    // IMPORTANTE: Toda vez que a tela ficar visível, recarrega os dados do banco
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            atualizarTabela();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecepcionistas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        jLabel1.setText("Recepcionistas");

        btnCadastrar.setText("Novo recepcionista");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar por nome");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tblRecepcionistas.setBackground(new java.awt.Color(102, 153, 255));
        tblRecepcionistas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblRecepcionistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nome", "CPF", "Email", "Telefone"
            }
        ));
        tblRecepcionistas.setEnabled(false);
        tblRecepcionistas.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(tblRecepcionistas);

        jScrollPane3.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(241, 241, 241)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        // Configura o comportamento para quando a tela de cadastro fechar
    telaCadastroRecepcionista.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent e) {
            // Este método será chamado assim que você der .dispose() na outra tela
            atualizarTabela(); 
            
            // Opcional: Remove o listener para não acumular na próxima vez que abrir
            telaCadastroRecepcionista.removeWindowListener(this);
        }
    });

    telaCadastroRecepcionista.setLocationRelativeTo(null);
    telaCadastroRecepcionista.setVisible(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

       // 1. Verifica se tem alguma linha selecionada
        int linhaSelecionada = tblRecepcionistas.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma recepcionista na tabela para excluir.");
            return;
        }

        // 2. Pega o ID da primeira coluna (coluna 0)
        Long id = (Long) modeloTabela.getValueAt(linhaSelecionada, 0);

        // 3. Pergunta se tem certeza
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a recepcionista ID: " + id + "?");
        
        if (resposta == JOptionPane.YES_OPTION) {
           try {
                // 1. Cria um objeto vazio
                Recepcionista recepcionista = new Recepcionista();
                
                // 2. Coloca o ID que pegamos da tabela dentro desse objeto
                recepcionista.setId(id); 

                // 3. Agora a variável 'recepcionista' EXISTE e pode ser enviada
                recepcionistaController.delete(recepcionista); 
                
                JOptionPane.showMessageDialog(this, "Excluído com sucesso!");
                atualizarTabela(); 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // 1. Abre uma caixinha para digitar o nome
        String nomeDigitado = JOptionPane.showInputDialog(this, "Digite o Nome para buscar:");

        if (nomeDigitado != null && !nomeDigitado.trim().isEmpty()) {
            try {
                // 2. Busca via Controller (você precisa ter o findByName ou findByNome no controller)
                List<Recepcionista> lista = recepcionistaController.findByName(nomeDigitado);

                // 3. Limpa a tabela e mostra apenas os resultados
                modeloTabela.setNumRows(0);
                
                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nenhuma recepcionista encontrada com esse nome.");
                } else {
                    for (Recepcionista r : lista) {
                        modeloTabela.addRow(new Object[]{
                            r.getId(),
                            r.getNome(),
                            r.getCpf(),
                            r.getEmail(),
                            r.getTelefone()
                        });
                    }
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao buscar: " + ex.getMessage());
            }
        } else if (nomeDigitado != null) {
            // Se o usuário clicou OK sem digitar nada, voltamos a listar todos
            atualizarTabela();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
      // 1. Verifica seleção
        int linhaSelecionada = tblRecepcionistas.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma recepcionista na tabela para editar.");
            return;
        }

        // 2. Pega dados atuais da tabela
        Long id = (Long) modeloTabela.getValueAt(linhaSelecionada, 0);
        String nomeAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 1);
        String cpfAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 2);
        String emailAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 3);
        String telefoneAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 4);

        try {
            // 3. Pede novos dados
            String novoNome = JOptionPane.showInputDialog(this, "Nome:", nomeAtual);
            if (novoNome == null) return; 

            String novoEmail = JOptionPane.showInputDialog(this, "Email:", emailAtual);
            if (novoEmail == null) return;

            String novoTelefone = JOptionPane.showInputDialog(this, "Telefone:", telefoneAtual);
            if (novoTelefone == null) return;

            // 4. Cria o objeto para atualização
            Recepcionista recepcionistaParaEditar = new Recepcionista();
            recepcionistaParaEditar.setId(id);
            recepcionistaParaEditar.setCpf(cpfAtual);
            recepcionistaParaEditar.setNome(novoNome);
            recepcionistaParaEditar.setEmail(novoEmail);
            recepcionistaParaEditar.setTelefone(novoTelefone);
            
            recepcionistaController.update(recepcionistaParaEditar);

            // 5. Sucesso
            JOptionPane.showMessageDialog(this, "Recepcionista atualizada com sucesso!");
            atualizarTabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao editar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblRecepcionistas;
    // End of variables declaration//GEN-END:variables
// --- LÓGICA DE CARREGAMENTO DA TABELA ---
    public void atualizarTabela() {
        // Limpa a tabela antes de carregar
        modeloTabela.setNumRows(0);
        
        try {
            // Busca a lista no banco via controller
            List<Recepcionista> lista = recepcionistaController.findAll();
            
            // Adiciona cada recepcionista como uma linha na tabela
            for (Recepcionista r : lista) {
                modeloTabela.addRow(new Object[]{
                    r.getId(),
                    r.getNome(),
                    r.getCpf(),
                    r.getEmail(),
                    r.getTelefone()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar recepcionistas: " + e.getMessage());
        }
    }
}
