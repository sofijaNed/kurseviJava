/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Polaznik;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class TableModelPolaznici extends AbstractTableModel{

     List<Polaznik> polaznici;
     String[] kolone = {"Ime", "Prezime", "Datum rodjenja", "Username", "Lozinka", "Pol", "Telefon"};
    
    public TableModelPolaznici(){
        polaznici = new ArrayList<>();
    }
    @Override
    public int getRowCount() {
        return polaznici.size();
    }

    
    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
     @Override
    public String getColumnName(int column) {
       
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Polaznik polaznik = polaznici.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch(columnIndex){
            case 0:
                return polaznik.getIme();
            case 1:
                return polaznik.getPrezime();
            case 2:
                return sdf.format(polaznik.getDatumRodjenja());
            case 3:
                return polaznik.getUsername();
            case 4:
                return polaznik.getLozinka();
            case 5:
                return polaznik.getPol();
            case 6:
                return polaznik.getTelefon();
            default:
                return "n/a";
        }
        
        
    }

    
   
    
    public List<Polaznik> vratiListu(){
        return polaznici;
    }
    
   public void dodajPolaznike(ArrayList<Polaznik> pola){
   
       polaznici = pola;
       fireTableDataChanged();
   }
   
   public Polaznik vratiPolaznika(int selected){
   
       return polaznici.get(selected);
   }

    public void updateRow(Polaznik p, int selectedRow) {
        
        polaznici.set(selectedRow, p);
        fireTableDataChanged();
    }
    
}
