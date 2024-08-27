/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.dialog.polaznik;

import controller.Communication;
import domain.Clanstvo;
import domain.Grupa;
import domain.Polaznik;
import form.PocetnaZaposleni;
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
public class PolaznikIzmena extends javax.swing.JDialog {

    Polaznik p;
    ArrayList<Polaznik> polaznici;
    /**
     * Creates new form PolaznikIzmena
     */
    public PolaznikIzmena(java.awt.Frame parent, boolean modal, Polaznik p, ArrayList<Polaznik> polaznici) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.p = p;
        this.polaznici = polaznici;
        postaviFormu();
        popuniGrupe();
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
        txtTelefon = new javax.swing.JTextField();
        txtDatumRodjenja = new javax.swing.JFormattedTextField();
        txtUsername = new javax.swing.JTextField();
        txtLozinka = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbM = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rbZ = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        btnIzmeni = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbGrupe = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("IZMENA POLAZNIKA");

        txtDatumRodjenja.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        jLabel2.setText("Ime:");

        jLabel3.setText("Prezime:");

        jLabel7.setText("Pol:");

        jLabel4.setText("Datum rodjenja:");

        rbM.setText("M");

        jLabel5.setText("Username:");

        rbZ.setText("Z");

        jLabel6.setText("Lozinka:");

        jLabel8.setText("Telefon:");

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        jLabel9.setText("Grupe:");

        cmbGrupe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel1)
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(cmbGrupe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOdustani)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzmeni)))
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtIme)
                        .addComponent(txtPrezime)
                        .addComponent(txtDatumRodjenja)
                        .addComponent(txtUsername)
                        .addComponent(txtLozinka)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rbM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbZ, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtTelefon))
                    .addContainerGap(44, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnOdustani))
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(rbM)
                        .addComponent(rbZ))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(143, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        try {
            // TODO add your handling code here:
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtDatumRodjenja.getText().isEmpty() || 
                    txtUsername.getText().isEmpty() || txtLozinka.getText().isEmpty() || txtTelefon.getText().isEmpty()){
            
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
                return;
            }
            String ime = txtIme.getText();
            String prezime = txtPrezime.getText();
            Date datumRodjenja = sdf.parse(txtDatumRodjenja.getText());
            String username = txtUsername.getText();
            String lozinka = txtLozinka.getText();
            String pol;
            if(rbM.isSelected()){
            
                pol = "M";
            }else{
            
                pol = "Z";
            }
            String telefon = txtTelefon.getText();
            p.setIme(ime);
            p.setPrezime(prezime);
            p.setDatumRodjenja(datumRodjenja);
            p.setUsername(username);
            p.setLozinka(lozinka);
            p.setPol(pol);
            p.setTelefon(telefon);
            
            for(int i=0; i<polaznici.size(); i++){
            
                if(polaznici.get(i).getPolaznikID()==p.getPolaznikID()){
                
                    polaznici.set(i, p);
                }
            }
            
            PocetnaZaposleni pz = (PocetnaZaposleni) getParent();
            PolaznikPretraga pp = new PolaznikPretraga(pz, false);
            pp.updatePolaznik(polaznici, p);
            pp.setVisible(true);
            this.dispose();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Datum nije odgovarajuceg formata.");
            Logger.getLogger(PolaznikIzmena.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PolaznikIzmena.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_btnIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JComboBox<Object> cmbGrupe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbM;
    private javax.swing.JRadioButton rbZ;
    private javax.swing.JFormattedTextField txtDatumRodjenja;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtLozinka;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void postaviFormu() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        txtIme.setText(p.getIme());
        txtPrezime.setText(p.getPrezime());
        txtDatumRodjenja.setText(sdf.format(p.getDatumRodjenja()));
        txtUsername.setText(p.getUsername());
        txtLozinka.setText(p.getLozinka());
        txtTelefon.setText(p.getTelefon());
        if(p.getPol().equals("M")){
        
            rbM.setSelected(true);
        }else{
        
            rbZ.setSelected(true);
        }
        popuniKombo();
    }

    private void popuniKombo() {
    }

    private void popuniGrupe() {
        try {
            ArrayList<Clanstvo> clanst = Communication.getInstance().getAllClanstvo();
            ArrayList<Grupa> gru = new ArrayList<>();
            for (Clanstvo clanstvo : clanst) {
                if(clanstvo.getPolaznik().getPolaznikID()==p.getPolaznikID()){
                
                    gru.add(clanstvo.getGrupa());
                }
            }
            
            cmbGrupe.removeAllItems();
            for (Grupa grupa : gru) {
                cmbGrupe.addItem(grupa);
            }
        } catch (IOException ex) {
            Logger.getLogger(PolaznikIzmena.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    void postaviFormuZaGledanje() {
        btnIzmeni.setEnabled(false);
        txtIme.setEditable(false);
        txtPrezime.setEditable(false);
        txtDatumRodjenja.setEditable(false);
        txtUsername.setEditable(false);
        txtLozinka.setEditable(false);
        rbM.setEnabled(false);
        rbZ.setEnabled(false);
        txtTelefon.setEditable(false);
        
    }
}