/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.dialog.grupa;

import components.TableModelClanstvo;
import controller.Communication;
import domain.Clanstvo;
import domain.Grupa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GrupaPrikazi extends javax.swing.JDialog {

    Grupa g;
    /**
     * Creates new form GrupaPrikazi
     */
    public GrupaPrikazi(java.awt.Frame parent, boolean modal, Grupa g) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tableClanstvo.setModel(new TableModelClanstvo());
        this.g = g;
        lblGrupa.setText(g.getNazivGrupe());
        lblKurs.setText(g.getKurs().getNaziv());
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

        jLabel1 = new javax.swing.JLabel();
        lblGrupa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblKurs = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClanstvo = new javax.swing.JTable();
        btnOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Grupa:");

        lblGrupa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGrupa.setText("jLabel2");

        jLabel2.setText("Kurs:");

        lblKurs.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKurs.setText("jLabel3");

        tableClanstvo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableClanstvo);

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOtkazi)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addComponent(lblGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(lblKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblGrupa)
                    .addComponent(jLabel2)
                    .addComponent(lblKurs))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOtkazi)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGrupa;
    private javax.swing.JLabel lblKurs;
    private javax.swing.JTable tableClanstvo;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        try {
            ArrayList<Clanstvo> clanstva = Communication.getInstance().getAllClanstvo();
            ArrayList<Clanstvo> poGrupi = new ArrayList<>();
            for (Clanstvo clanstvo : clanstva) {
                if(clanstvo.getGrupa().getGrupaID()==g.getGrupaID()){
                
                    poGrupi.add(clanstvo);
                }
            }
            TableModelClanstvo tmc = (TableModelClanstvo) tableClanstvo.getModel();
            tmc.dodajListu(poGrupi);
        } catch (IOException ex) {
            Logger.getLogger(GrupaPrikazi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}