package br.com.azuosoft.balancacheckout.view;

import br.com.azuosoft.balancacheckout.controller.ScaleController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class FormScale extends javax.swing.JFrame {

    private ScaleController scaleController;
    private DateFormat dateFormat;

    public FormScale() {
        initComponents();
        initialize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lbPort = new javax.swing.JLabel();
        jcPort = new javax.swing.JComboBox<>();
        lbModel = new javax.swing.JLabel();
        jcModel = new javax.swing.JComboBox<>();
        lbResult = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtReturn = new javax.swing.JTextArea();
        btReadWeight = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teste de balança de checkout");
        getContentPane().setLayout(new java.awt.GridLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Balança", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbPort.setText("Porta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lbPort, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = -500;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel1.add(jcPort, gridBagConstraints);

        lbModel.setText("Modelo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanel1.add(lbModel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = -500;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 0);
        jPanel1.add(jcModel, gridBagConstraints);

        lbResult.setText("Resultado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel1.add(lbResult, gridBagConstraints);

        jtReturn.setColumns(20);
        jtReturn.setLineWrap(true);
        jtReturn.setRows(5);
        jtReturn.setWrapStyleWord(true);
        jtReturn.setFocusable(false);
        jScrollPane1.setViewportView(jtReturn);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        btReadWeight.setText("Ler peso");
        btReadWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReadWeightActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 0, 0);
        jPanel1.add(btReadWeight, gridBagConstraints);

        getContentPane().add(jPanel1);

        setSize(new java.awt.Dimension(444, 330));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btReadWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReadWeightActionPerformed
        readWeight();
    }//GEN-LAST:event_btReadWeightActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormScale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FormScale().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReadWeight;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcModel;
    private javax.swing.JComboBox<String> jcPort;
    private javax.swing.JTextArea jtReturn;
    private javax.swing.JLabel lbModel;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbResult;
    // End of variables declaration//GEN-END:variables

    private void initialize() {
        try {
            scaleController = new ScaleController();
            dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");

            scaleController.getPorts().forEach(p -> jcPort.addItem(p));
            scaleController.getScaleModels().forEach(m -> jcModel.addItem(m.toString()));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Problemas ao inicializar componentes", "Erro", JOptionPane.ERROR_MESSAGE);
            log(ex.toString());
        }
    }

    private void readWeight() {
        try {
            scaleController.setPort(jcPort.getSelectedItem().toString());
            scaleController.setScaleModelType(jcModel.getSelectedItem().toString());

            String returnWeight = String.format("Peso obtido: %s", scaleController.readWeigth());
            log(returnWeight);

        } catch (Exception ex) {
            log(ex.toString());
        }
    }

    private void log(String message) {
        String oldValue = jtReturn.getText().isEmpty() ? "" : String.format("%s\n", jtReturn.getText());
        jtReturn.setText(String.format("%s%s | %s", oldValue, dateFormat.format(new Date()), message));
    }
}
