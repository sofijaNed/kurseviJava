/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Kurs;
import domain.Lekcija;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class TableModelKurs extends AbstractTableModel{

    ArrayList<Kurs> kursevi;
    String[] kolone = {"Naziv", "Ime i prezime predavaca", "Vreme trajanja", "Oblast"};
    
    public TableModelKurs(){
    
        kursevi = new ArrayList<>();
    }
    @Override
    public int getRowCount() {
        return kursevi.size();
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
        Kurs lek = kursevi.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                
                return lek.getNaziv();
            case 1:
                return lek.getImePrezimePredavaca();
            case 2:
                return lek.getVremeTrajanja();
            case 3:
                return lek.getOblast();
            default:
                throw new AssertionError();
        }
    }
    
    public void dodajKurs(Kurs lek){
    
        
        kursevi.add(lek);
        fireTableDataChanged();
    }
    
    public void dodajKurseve(ArrayList<Kurs> k){
    
        kursevi = k;
        fireTableDataChanged();
    }
    
    public ArrayList<Kurs> vratiListu(){
    
        return kursevi;
    }
    public Kurs vratiKurs(int selected){
    
        return kursevi.get(selected);
    }
    
}
