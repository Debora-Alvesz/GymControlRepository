
package br.com.ifba.exercicio.view;

import br.com.ifba.view.ContextProvider;
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
public class TelaExercicios extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaExercicios.class.getName());
    
    @org.springframework.beans.factory.annotation.Autowired
    private br.com.ifba.exercicio.controller.ExercicioController exercicioController;
    
    @Autowired
    @Lazy
     private TelaExercicioCadastro telaExercicioCadastro;

    private javax.swing.table.DefaultTableModel modeloTabela;
    
    public TelaExercicios() {
        initComponents();
        modeloTabela = (javax.swing.table.DefaultTableModel) tblExercicios.getModel();
        tblExercicios.setEnabled(true); // Permite selecionar a linha
         // Importante: Não matar o app ao fechar esta janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        
    }
    // Este método será executado pelo Spring logo após a injeção de dependências
    @PostConstruct
    public void init() {
        atualizarTabela();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnNovoExercicio = new javax.swing.JButton();
        btnExcluirExercicio = new javax.swing.JButton();
        btnBuscarExercicio = new javax.swing.JButton();
        btnEditarExercicio = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExercicios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Exercicios");

        btnNovoExercicio.setText("Novo Exercicio");
        btnNovoExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoExercicioActionPerformed(evt);
            }
        });

        btnExcluirExercicio.setText("Excluir");
        btnExcluirExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirExercicioActionPerformed(evt);
            }
        });

        btnBuscarExercicio.setText("Buscar por ID");
        btnBuscarExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarExercicioActionPerformed(evt);
            }
        });

        btnEditarExercicio.setText("Editar");
        btnEditarExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarExercicioActionPerformed(evt);
            }
        });

        tblExercicios.setBackground(new java.awt.Color(102, 153, 255));
        tblExercicios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblExercicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nome", "Grupo Muscular", "Equipamento", "Descrição"
            }
        ));
        tblExercicios.setEnabled(false);
        tblExercicios.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(tblExercicios);

        jScrollPane3.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnNovoExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnEditarExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovoExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditarExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoExercicioActionPerformed

        
        // Esconde a tela principal
        this.setVisible(false);
        
        TelaExercicioCadastro tela =
        ContextProvider.getBean(TelaExercicioCadastro.class);

        // Prepara a tela de cadastro (limpa campos)
        telaExercicioCadastro.prepararParaNovo();

        // Abre a tela de cadastro
        telaExercicioCadastro.setVisible(true);

    }//GEN-LAST:event_btnNovoExercicioActionPerformed

    private void btnExcluirExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirExercicioActionPerformed

        //Verifica se tem alguma linha selecionada
    int linhaSelecionada = tblExercicios.getSelectedRow();
    
    if (linhaSelecionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um exercício na tabela para excluir.");
        return;
    }

    //Pega o ID da primeira coluna (coluna 0)
    Long id = (Long) modeloTabela.getValueAt(linhaSelecionada, 0);

    //Pergunta se tem certeza
    int resposta = javax.swing.JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o exercício ID: " + id + "?");
    
    if (resposta == javax.swing.JOptionPane.YES_OPTION) {
        try {
            exercicioController.delete(id); // Chama o controller
            javax.swing.JOptionPane.showMessageDialog(this, "Excluído com sucesso!");
            atualizarTabela(); // Atualiza a lista automaticamente
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage());
        }
    }

    }//GEN-LAST:event_btnExcluirExercicioActionPerformed

    private void btnBuscarExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarExercicioActionPerformed
      // 1. Abre uma caixinha para o usuário digitar o ID
    String idDigitado = javax.swing.JOptionPane.showInputDialog(this, "Digite o ID do Exercício:");

    if (idDigitado != null && !idDigitado.trim().isEmpty()) {
        try {
            Long id = Long.parseLong(idDigitado);
            
            // 2. Busca o exercício via Controller
            br.com.ifba.exercicio.entity.Exercicio e = exercicioController.findById(id);

            if (e != null) {
                // 3. Limpa a tabela e mostra apenas o resultado encontrado
                modeloTabela.setNumRows(0);
                modeloTabela.addRow(new Object[]{
                    e.getId(),
                    e.getNome(),
                    e.getGrupoMuscular(),
                    e.getTipoEquipamento(),
                    e.getDescricao()
                });
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Exercício não encontrado!");
            }
            
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, digite um número de ID válido.");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao buscar: " + ex.getMessage());
        }
    } else if (idDigitado != null) {
        // Se o usuário clicou OK sem digitar nada, voltamos a listar todos
        atualizarTabela();
    }

    }//GEN-LAST:event_btnBuscarExercicioActionPerformed

    private void btnEditarExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarExercicioActionPerformed
// 1. Verifica se tem alguém selecionado
    int linhaSelecionada = tblExercicios.getSelectedRow();
    
    if (linhaSelecionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um exercício na tabela para editar.");
        return;
    }

    // 2. Pega o ID e os dados atuais da tabela
    Long id = (Long) modeloTabela.getValueAt(linhaSelecionada, 0);
    String nomeAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 1);
    String grupoAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 2);
    String equipamentoAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 3);
    String descricaoAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 4);

    try {
        // 3. Abre caixinhas pedindo as novas informações (já sugere o nome atual)
        String novoNome = javax.swing.JOptionPane.showInputDialog(this, "Nome do Exercício:", nomeAtual);
        if (novoNome == null) return; // Se cancelar, para aqui

        String novoGrupo = javax.swing.JOptionPane.showInputDialog(this, "Grupo Muscular:", grupoAtual);
        if (novoGrupo == null) return;

        String novoEquipamento = javax.swing.JOptionPane.showInputDialog(this, "Tipo de Equipamento:", equipamentoAtual);
        if (novoEquipamento == null) return;

        String novaDescricao = javax.swing.JOptionPane.showInputDialog(this, "Descrição:", descricaoAtual);
        if (novaDescricao == null) return;

        // 4. Busca o objeto original, atualiza e salva
        br.com.ifba.exercicio.entity.Exercicio exercicio = exercicioController.findById(id);
        
        exercicio.setNome(novoNome);
        exercicio.setGrupoMuscular(novoGrupo);
        exercicio.setTipoEquipamento(novoEquipamento);
        exercicio.setDescricao(novaDescricao);

        exercicioController.update(exercicio); // Ou .save(exercicio), o Spring entende que é edição pelo ID

        // 5. Sucesso e atualização da tela
        javax.swing.JOptionPane.showMessageDialog(this, "Exercício atualizado com sucesso!");
        atualizarTabela();

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao editar: " + e.getMessage());
     }
    }//GEN-LAST:event_btnEditarExercicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarExercicio;
    private javax.swing.JButton btnEditarExercicio;
    private javax.swing.JButton btnExcluirExercicio;
    private javax.swing.JButton btnNovoExercicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblExercicios;
    // End of variables declaration//GEN-END:variables

    // Este método permite que outras classes acessem a tabela
public javax.swing.JTable getTabela() {
    return tblExercicios;
}

    public void atualizarTabela() {
    // Limpa a tabela antes de carregar
    modeloTabela.setNumRows(0);
    
   try {
        // Busca a lista no banco via controller
        java.util.List<br.com.ifba.exercicio.entity.Exercicio> lista = exercicioController.findAll();
        
        // Adiciona cada exercício como uma linha na tabela
        for (br.com.ifba.exercicio.entity.Exercicio e : lista) {
            modeloTabela.addRow(new Object[]{
                e.getId(),
                e.getNome(),
                e.getGrupoMuscular(),
                e.getTipoEquipamento(),
                e.getDescricao()
            });
        }
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar exercícios: " + e.getMessage());
    }
 }
}
