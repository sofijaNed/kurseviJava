/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.dialog.grupa;

import components.TableModelClanstvo;
import controller.Communication;
import domain.Clanstvo;
import domain.Grupa;
import domain.Kurs;
import domain.Polaznik;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GrupaKreiraj extends javax.swing.JDialog {

    ArrayList<Polaznik> polaznici;
    ArrayList<Clanstvo> pre;
    ArrayList<Clanstvo> novo = new ArrayList<>();
    
    /**
     * Creates new form GrupaKreiraj
     */
    public GrupaKreiraj(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tableClanstvo.setModel(new TableModelClanstvo());
        txtGrupaID.setEditable(false);
        btnIzmeni.setEnabled(false);
        btnSacuvaj.setEnabled(false);
        popuniKurseve();
        popuniPolaznike();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGrupaID = new javax.swing.JTextField();
        txtMaxBrojPolaznika = new javax.swing.JTextField();
        txtNazivGrupe = new javax.swing.JTextField();
        txtPocetak = new javax.swing.JFormattedTextField();
        txtZavrsniTest = new javax.swing.JFormattedTextField();
        cmbKurs = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cmbPolaznik = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClanstvo = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnKreiraj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma za kreiranje grupe");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("KREIRAJ GRUPU");

        jLabel2.setText("GrupaID:");

        jLabel3.setText("Max broj polaznika:");

        jLabel4.setText("Naziv grupe:");

        jLabel5.setText("Datum i vreme pocetka rada grupe:");

        jLabel6.setText("Datum i vreme zavrsnog testa:");

        jLabel7.setText("Kurs:");

        txtPocetak.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));

        txtZavrsniTest.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));

        cmbKurs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos clanova"));

        jLabel8.setText("Polaznik:");

        cmbPolaznik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Status:");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRIJAVA", "POCETAK", "POLOZIO/LA", "PAO/LA", "ZAVRSIO/LA" }));

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

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbPolaznik, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbStatus, 0, 270, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisi)
                .addGap(37, 37, 37)
                .addComponent(btnDodaj)
                .addGap(195, 195, 195))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbPolaznik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnKreiraj.setText("Kreiraj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("IZMENI");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGrupaID)
                                    .addComponent(txtMaxBrojPolaznika)
                                    .addComponent(txtNazivGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPocetak)
                                    .addComponent(txtZavrsniTest)
                                    .addComponent(cmbKurs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(124, 124, 124)
                            .addComponent(btnKreiraj)
                            .addGap(36, 36, 36)
                            .addComponent(btnOtkazi)
                            .addGap(33, 33, 33)
                            .addComponent(btnSacuvaj)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIzmeni))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtGrupaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(txtMaxBrojPolaznika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNazivGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtZavrsniTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbKurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreiraj)
                    .addComponent(btnOtkazi)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnIzmeni))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        try {
            // TODO add your handling code here:
            btnSacuvaj.setEnabled(true);
            Grupa grupa = new Grupa();
            grupa.setMaxBrojPolaznika(0);
            grupa.setNazivGrupe("");
            grupa.setDatumPocetkaRadaGrupe(new Date());
            grupa.setDatumZavrsnogTesta(new Date());
            Kurs ku = new Kurs();
            ku.setKursID(1);
            grupa.setKurs(ku);
            Grupa gr = Communication.getInstance().createGrupa(grupa);
            
            if(gr==null){
            
                JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira grupu");
            }else{
            
                txtGrupaID.setText(Integer.toString(gr.getGrupaID()));
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio grupu.");
            }
        } catch (IOException ex) {
            Logger.getLogger(GrupaKreiraj.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        // TODO add your handling code here:
        Polaznik pol = (Polaznik) cmbPolaznik.getSelectedItem();
        String status = (String) cmbStatus.getSelectedItem();
        Clanstvo cla = new Clanstvo(null, pol, status, 0);
        TableModelClanstvo tmc = (TableModelClanstvo) tableClanstvo.getModel();
        if(tmc.daLiVecImaTogClana(pol.getPolaznikID())){
        
            JOptionPane.showMessageDialog(this, "Taj polaznik je vec unet u listu. Morate uneti razlicite polaznike.");
            
        }else{
        tmc.dodaj(cla);
        }
        
        
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
        int selected = tableClanstvo.getSelectedRow();
        if(selected >= 0){
        
            TableModelClanstvo tmc = (TableModelClanstvo) tableClanstvo.getModel();
            tmc.obrisi(selected);
        }else{
        
            JOptionPane.showMessageDialog(this, "Niste izabrali nijedan red.");
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            // TODO add your handling code here:
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            int id = Integer.parseInt(txtGrupaID.getText());
            if(txtMaxBrojPolaznika.getText().isEmpty() || txtNazivGrupe.getText().isEmpty() || txtPocetak.getText().isEmpty() || 
                    txtZavrsniTest.getText().isEmpty()){
            
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena.");
                return;
            }
            int max = Integer.parseInt(txtMaxBrojPolaznika.getText());
            String naziv = txtNazivGrupe.getText();
            Date datumPocetak = sdf.parse(txtPocetak.getText());
            Date datumTest = sdf.parse(txtZavrsniTest.getText());
            if(datumPocetak.after(datumTest)){
            
                JOptionPane.showMessageDialog(this, "Datum pocetka rada grupe mora biti pre datuma i vremena zavrssnog testa.");
                return;
            }
            Kurs kurs = (Kurs) cmbKurs.getSelectedItem();
            TableModelClanstvo tmc = (TableModelClanstvo) tableClanstvo.getModel();
            ArrayList<Clanstvo> clanstva = tmc.vratiListu();
            
            Grupa gr = new Grupa(id, max, naziv, datumPocetak, datumTest, kurs);
            gr.setCl(clanstva);
            for (Clanstvo clanstvo : clanstva) {
                clanstvo.setGrupa(gr);
            }
            Object ob = Communication.getInstance().updateGrupa(gr);
            if((boolean)ob){
            
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio grupu.");
                btnSacuvaj.setEnabled(false);
//                Object o;
//                for(Clanstvo cl: clanstva){
//                
//                    cl.setGrupa(gr);
//                    o = Communication.getInstance().addClanstvo(cl);
//                    if(!(boolean)o){
//                    
//                        JOptionPane.showMessageDialog(this, "Sistem ne moze da sacuva clanstvo");
//                    }
//                }
            }else{
            
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti grupu.");
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Datum nije napisan kako treba.");
            Logger.getLogger(GrupaKreiraj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GrupaKreiraj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        try {
            // TODO add your handling code here:
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            int id = Integer.parseInt(txtGrupaID.getText());
            int max = Integer.parseInt(txtMaxBrojPolaznika.getText());
            String naziv = txtNazivGrupe.getText();
            Date datumPocetak = sdf.parse(txtPocetak.getText());
            Date datumTest = sdf.parse(txtZavrsniTest.getText());
            Kurs kurs = (Kurs) cmbKurs.getSelectedItem();
            
            TableModelClanstvo tmc = (TableModelClanstvo) tableClanstvo.getModel();
            ArrayList<Clanstvo> clanstva = tmc.vratiListu();
            
            Grupa gr = new Grupa(id, max, naziv, datumPocetak, datumTest, kurs);
//            if(pre != null){
//            for(Clanstvo c: pre){
//            
//                c.setGrupa(gr);
//                Object oo = Communication.getInstance().deleteClanstvo(c);
//                if(!(boolean)oo){
//                
//                    JOptionPane.showMessageDialog(this, "Nije moguce obrisati clanstvo.");
//                    return;
//                }
//            }
//            }
            gr.setCl(clanstva);
            for (Clanstvo clanstvo : clanstva) {
                clanstvo.setGrupa(gr);
            }
            Object ob = Communication.getInstance().updateGrupa(gr);
            if((boolean)ob){
            
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio grupu.");
//                Object o;
//                for(Clanstvo cl: clanstva){
//                
//                    cl.setGrupa(gr);
//                    o = Communication.getInstance().addClanstvo(cl);
//                    if(!(boolean)o){
//                    
//                        JOptionPane.showMessageDialog(this, "Sistem ne moze da sacuva clanstvo");
//                    }
//                }
            }else{
            
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti grupu.");
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(GrupaKreiraj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GrupaKreiraj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

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
            java.util.logging.Logger.getLogger(GrupaKreiraj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrupaKreiraj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrupaKreiraj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrupaKreiraj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GrupaKreiraj dialog = new GrupaKreiraj(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Object> cmbKurs;
    private javax.swing.JComboBox<Object> cmbPolaznik;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableClanstvo;
    private javax.swing.JTextField txtGrupaID;
    private javax.swing.JTextField txtMaxBrojPolaznika;
    private javax.swing.JTextField txtNazivGrupe;
    private javax.swing.JFormattedTextField txtPocetak;
    private javax.swing.JFormattedTextField txtZavrsniTest;
    // End of variables declaration//GEN-END:variables

    private void popuniKurseve() {
        try {
            ArrayList<Kurs> kursevi = Communication.getInstance().getAllKurs();
            cmbKurs.removeAllItems();
            for (Kurs kurs : kursevi) {
                cmbKurs.addItem(kurs);
            }
        } catch (IOException ex) {
            Logger.getLogger(GrupaKreiraj.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void popuniPolaznike() {
        try {
             polaznici = Communication.getInstance().getAllPolaznici();
            cmbPolaznik.removeAllItems();
            for (Polaznik polaznik : polaznici) {
                cmbPolaznik.addItem(polaznik);
            }
        } catch (IOException ex) {
            Logger.getLogger(GrupaKreiraj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void izmeniGrupu(Grupa gr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            
            
            btnKreiraj.setEnabled(false);
            btnSacuvaj.setEnabled(false);
            btnIzmeni.setEnabled(true);
            txtGrupaID.setEditable(false);
            txtGrupaID.setText(Integer.toString(gr.getGrupaID()));
            txtMaxBrojPolaznika.setText(Integer.toString(gr.getMaxBrojPolaznika()));
            txtNazivGrupe.setText(gr.getNazivGrupe());
            txtPocetak.setText(sdf.format(gr.getDatumPocetkaRadaGrupe()));
            txtZavrsniTest.setText(sdf.format(gr.getDatumZavrsnogTesta()));
            cmbKurs.getModel().setSelectedItem(gr.getKurs());
            ArrayList<Clanstvo> cl = Communication.getInstance().getAllClanstvo();
            ArrayList<Clanstvo> claaa = new ArrayList<>();
            for (Clanstvo clanstvo : cl) {
                if(clanstvo.getGrupa().getGrupaID()==gr.getGrupaID()){
                
                    claaa.add(clanstvo);
                }
            }
            TableModelClanstvo tmc = (TableModelClanstvo) tableClanstvo.getModel();
            tmc.dodajListu(claaa);
            gr.setCl(claaa);
            if(claaa.size() > 0){
            pre = claaa;
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(GrupaKreiraj.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}