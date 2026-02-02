
package br.com.ifba.plano.view;

import br.com.ifba.plano.controller.PlanoIController;
import br.com.ifba.plano.entity.Plano;
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
public class TelaListagemPlanos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaListagemPlanos.class.getName());

    @Autowired
    private PlanoIController planoController;

    // Usamos @Lazy para evitar erro de ciclo (TelaListagem chama Cadastro, Cadastro chama Listagem)
    @Autowired
    @Lazy
    private TelaCadastroPlanos telaCadastroPlanos;
   
    private DefaultTableModel modeloTabela;
    
    public TelaListagemPlanos() {
        initComponents();
        // Pega o modelo da tabela para manipular as linhas
        modeloTabela = (DefaultTableModel) tblPlanos.getModel();
        tblPlanos.setEnabled(true); // Permite selecionar a linha
    }
    // Recarrega a tabela sempre que a tela abrir
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

        lblPlanos = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlanos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPlanos.setBackground(new java.awt.Color(255, 255, 255));
        lblPlanos.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        lblPlanos.setText("Planos");

        btnCadastrar.setText("Novo plano");
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

        tblPlanos.setBackground(new java.awt.Color(102, 153, 255));
        tblPlanos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblPlanos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nome plano", "Duração", "Valor mensal", "Valor matricula", "Status", "Benefícios"
            }
        ));
        tblPlanos.setEnabled(false);
        tblPlanos.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(tblPlanos);

        jScrollPane3.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(lblPlanos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(532, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(lblPlanos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(502, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(80, 80, 80)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // 1. Adiciona um Listener na tela de cadastro
        // Isso diz: "Quando a janela telaCadastro fechar (CLOSED), execute o código abaixo"
        telaCadastroPlanos.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                // Aqui chamamos o método que recarrega os dados do banco
                atualizarTabela(); 
            }
        });

        // 2. Abre a tela de cadastro
        telaCadastroPlanos.setVisible(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        // 1. Verifica seleção
        int linhaSelecionada = tblPlanos.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um plano na tabela para excluir.");
            return;
        }

        // 2. Pega o ID (coluna 0)
        Long id = (Long) modeloTabela.getValueAt(linhaSelecionada, 0);

        // 3. Confirmação
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o plano ID: " + id + "?");
        
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                Plano plano = new Plano();
                plano.setId(id);

                planoController.delete(plano);
                
                JOptionPane.showMessageDialog(this, "Plano excluído com sucesso!");
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage());
            }
        }
    
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
     try {
            // 1. Pergunta o nome (pode ser parte dele)
            String nomeBusca = JOptionPane.showInputDialog(this, "Digite o nome para buscar:");

            // Se cancelar ou deixar vazio, volta ao normal (ordenado por valor)
            if (nomeBusca == null || nomeBusca.trim().isEmpty()) {
                atualizarTabela(); 
                return;
            }

            // 2. Chama o método novo que passa por todas as camadas
            List<Plano> listaFiltrada = planoController.findByNomeContainingIgnoreCase(nomeBusca);
            
            DefaultTableModel modelo = (DefaultTableModel) tblPlanos.getModel();
            modelo.setNumRows(0); // Limpa tabela

            if (listaFiltrada.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum plano encontrado com: " + nomeBusca);
                atualizarTabela(); //recarrega tudo se não achar
            } else {
                for (Plano p : listaFiltrada) {
                    modelo.addRow(new Object[]{
                        p.getId(),
                        p.getNome(),
                        p.getDuracao(),
                        p.getValor(),
                        p.getValorMatricula(),
                        p.isStatus() ? "Ativo" : "Inativo",
                        p.getBeneficios()
                    });
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        // 1. Verifica se tem linha selecionada
        int linhaSelecionada = tblPlanos.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um plano para editar.");
            return;
        }

        // 2. Recupera dados atuais da tabela (para preencher as janelinhas de edição)
        
        Long id = (Long) modeloTabela.getValueAt(linhaSelecionada, 0);
        String nomeAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 1);
        
        // Usamos String.valueOf para garantir que pegamos o texto, mesmo que seja número na tabela
        String duracaoAtual = String.valueOf(modeloTabela.getValueAt(linhaSelecionada, 2));
        String valorMensalAtual = String.valueOf(modeloTabela.getValueAt(linhaSelecionada, 3));
        String valorMatriculaAtual = String.valueOf(modeloTabela.getValueAt(linhaSelecionada, 4));
        
        // Pega o benefício atual da coluna 6 ---
        String beneficiosAtual = "";
        Object objBeneficio = modeloTabela.getValueAt(linhaSelecionada, 6);
        if (objBeneficio != null) {
            beneficiosAtual = objBeneficio.toString();
        }

        try {
            // 3. Pergunta os novos dados um por um )
            
            String novoNome = JOptionPane.showInputDialog(this, "Nome do Plano:", nomeAtual);
            if (novoNome == null) return; // Se cancelar, para a edição

            String novaDuracaoStr = JOptionPane.showInputDialog(this, "Duração (meses):", duracaoAtual);
            if (novaDuracaoStr == null) return;
            
            String novoValorMensalStr = JOptionPane.showInputDialog(this, "Valor Mensal:", valorMensalAtual);
            if (novoValorMensalStr == null) return;
            
            String novoValorMatriculaStr = JOptionPane.showInputDialog(this, "Valor Matrícula:", valorMatriculaAtual);
            if (novoValorMatriculaStr == null) return;
            
            String novosBeneficios = JOptionPane.showInputDialog(this, "Benefícios:", beneficiosAtual);
            // Se cancelar aqui, assumimos que não quer editar, então retornamos.
            if (novosBeneficios == null) return; 
       
            // 4. Tratamento para evitar erro de NULL no banco (Constraint Violation)
            if (novosBeneficios.trim().isEmpty()) {
                novosBeneficios = "-"; // Define um valor padrão se deixar em branco
            }

            // 5. Cria o objeto e preenche com os dados novos
            Plano planoParaEditar = new Plano();
            planoParaEditar.setId(id);
            planoParaEditar.setNome(novoNome);
            
            // Conversões de String para Números (trocando vírgula por ponto para evitar erro)
            planoParaEditar.setDuracao(Integer.parseInt(novaDuracaoStr));
            planoParaEditar.setValor(Double.parseDouble(novoValorMensalStr.replace(",", "."))); 
            planoParaEditar.setValorMatricula(Float.parseFloat(novoValorMatriculaStr.replace(",", ".")));
            
            // Seta o benefício tratado
            planoParaEditar.setBeneficios(novosBeneficios);
            
            // 6. Mantém o STATUS que estava na tabela (Coluna 5)
            // Se estiver escrito "Ativo", salva true. Se não, false.
            String statusTexto = (String) modeloTabela.getValueAt(linhaSelecionada, 5);
            planoParaEditar.setStatus(statusTexto != null && statusTexto.equalsIgnoreCase("Ativo"));

            // 7. Envia para o Controller atualizar no Banco
            planoController.update(planoParaEditar);

            JOptionPane.showMessageDialog(this, "Plano atualizado com sucesso!");
            
            // 8. Atualiza a tabela visualmente
            atualizarTabela();

        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, "Erro: Digite apenas números válidos para Duração e Valores.");
        } catch (Exception e) {
            e.printStackTrace(); // Ajuda a ver erros detalhados no console
            JOptionPane.showMessageDialog(this, "Erro ao editar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPlanos;
    private javax.swing.JTable tblPlanos;
    // End of variables declaration//GEN-END:variables
public void atualizarTabela() {
    if (modeloTabela == null) return;
    modeloTabela.setNumRows(0); // Limpa tabela

    try {
        // --- MUDANÇA AQUI: Chama o método que já traz ordenado do banco ---
        List<Plano> lista = planoController.findAllByOrderByValorAsc();
        // -----------------------------------------------------------------

        for (Plano p : lista) {
            modeloTabela.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getDuracao(),
                p.getValor(),
                p.getValorMatricula(),
                p.isStatus() ? "Ativo" : "Inativo",
                p.getBeneficios() // Não esqueça o benefício!
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar planos: " + e.getMessage());
        e.printStackTrace();
    }
}
}
