/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.dialog.polaznik;

import com.mysql.cj.xdevapi.Table;
import components.TableModelPolaznici;
import controller.Communication;
import domain.Polaznik;
import form.PocetnaZaposleni;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class PolaznikPretraga extends javax.swing.JDialog {

    ArrayList<Polaznik> polaznici;
    /**
     * Creates new form PolaznikPretraga
     */
    public PolaznikPretraga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tablePolaznici.setModel(new TableModelPolaznici());
        popuniTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        rbM = new javax.swing.JRadioButton();
        rbZ = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePolaznici = new javax.swing.JTable();
        btnUcitaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnVrati = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnDetaljno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma za pretragu polaznika");

        jLabel1.setText("Pretrazi polaznike po polu");

        buttonGroup1.add(rbM);
        rbM.setText("M");

        buttonGroup1.add(rbZ);
        rbZ.setText("Z");

        tablePolaznici.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablePolaznici);

        btnUcitaj.setText("Pretrazi po vrednosti");
        btnUcitaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUcitajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni polaznika");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnVrati.setText("Vrati sve polaznike");
        btnVrati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("PRETRAŽI POLAZNIKE");

        btnDetaljno.setText("Detaljno prikazi");
        btnDetaljno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnVrati, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(btnUcitaj, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(btnDetaljno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(rbM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbZ, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rbM)
                    .addComponent(rbZ))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUcitaj)
                    .addComponent(btnIzmeni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVrati)
                    .addComponent(btnDetaljno))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVratiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiActionPerformed
        // TODO add your handling code here:
        popuniTabelu();
    }//GEN-LAST:event_btnVratiActionPerformed

    private void btnUcitajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUcitajActionPerformed
        // TODO add your handling code here:
        String pol = null;
        if(rbM.isSelected()){
        
            pol = "M";
        }else{
        
            pol = "Z";
        }
        
        ArrayList<Polaznik> polazniciPoPolu = vratiPolaznikePoPolu(pol);
        if(polazniciPoPolu.isEmpty()){
        
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe polaznike po zadatoj vrednosti.");
            return;
        }
        TableModelPolaznici tmp = (TableModelPolaznici) tablePolaznici.getModel();
        tmp.dodajPolaznike(polazniciPoPolu);
        JOptionPane.showMessageDialog(this, "Sistem je našao polaznike po zadatoj vrednosti.");
    }//GEN-LAST:event_btnUcitajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
        int selected = tablePolaznici.getSelectedRow();
        if(selected >= 0){
        
            TableModelPolaznici tmp = (TableModelPolaznici) tablePolaznici.getModel();
            Polaznik polaznik1 = tmp.vratiPolaznika(selected);
            PocetnaZaposleni pz = (PocetnaZaposleni) getParent();
            JOptionPane.showMessageDialog(this, "Sistem je učitao polaznika.");
            new PolaznikIzmena(pz, false, polaznik1, polaznici).setVisible(true);
            this.dispose();
        }else{
        
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita polaznika. Niste izabrali nikog.");
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnDetaljnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljnoActionPerformed
        // TODO add your handling code here:
        int selected = tablePolaznici.getSelectedRow();
        if(selected >= 0){
        
            TableModelPolaznici tmp = (TableModelPolaznici) tablePolaznici.getModel();
            Polaznik polaznik1 = tmp.vratiPolaznika(selected);
            PocetnaZaposleni pz = (PocetnaZaposleni) getParent();
            JOptionPane.showMessageDialog(this, "Sistem je učitao polaznika.");
            PolaznikIzmena pi = new PolaznikIzmena(pz, false, polaznik1, polaznici);
            pi.setVisible(true);
            pi.postaviFormuZaGledanje();
            this.dispose();
        }else{
        
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita polaznika. Niste izabrali nikog.");
        }
    }//GEN-LAST:event_btnDetaljnoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PolaznikPretraga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PolaznikPretraga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PolaznikPretraga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PolaznikPretraga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PolaznikPretraga dialog = new PolaznikPretraga(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetaljno;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnUcitaj;
    private javax.swing.JButton btnVrati;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbM;
    private javax.swing.JRadioButton rbZ;
    private javax.swing.JTable tablePolaznici;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        try {
             polaznici = Communication.getInstance().getAllPolaznici();
             TableModelPolaznici tmp = (TableModelPolaznici) tablePolaznici.getModel();
             tmp.dodajPolaznike(polaznici);
            
        } catch (IOException ex) {
            Logger.getLogger(PolaznikPretraga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<Polaznik> vratiPolaznikePoPolu(String pol) {
        ArrayList<Polaznik> poPolu = new ArrayList<>();
        for (Polaznik polaznik : polaznici) {
            if(polaznik.getPol().equals(pol)){
            
                poPolu.add(polaznik);
            }
        }
        return poPolu;
    }

    void updatePolaznik(ArrayList<Polaznik> pola, Polaznik po) throws IOException {
        TableModelPolaznici tmp = (TableModelPolaznici) tablePolaznici.getModel();
        polaznici = pola;
        tmp.dodajPolaznike(polaznici);
        
        //polaznici.set(selectedRow, po);
        //tmp.dodajPolaznike(polaznici);
        Object uspesno = Communication.getInstance().updatePolaznik(po);
        if((boolean)uspesno){
        
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio polaznika.");
        }else{
        
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti polaznika.");
        }
        
    }
}
