/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Clanstvo;
import domain.Polaznik;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class TableModelClanstvo extends AbstractTableModel{

    ArrayList<Clanstvo> cl;
    String[] kolone = {"Polaznik", "Status"};
    public TableModelClanstvo(){
    
        cl = new ArrayList<>();
    }
    @Override
    public int getRowCount() {
        return cl.size();
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
        Clanstvo c = cl.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return c.getPolaznik().getIme() + " " +  c.getPolaznik().getPrezime();
            case 1:
                return c.getStatus();
            default:
                throw new AssertionError();
        }
    }
    public boolean daLiVecImaTogClana(int polaznikID){
    
        for (Clanstvo clanstvo : cl) {
            if(clanstvo.getPolaznik().getPolaznikID()==polaznikID){
            
                return true;
            }
        }
        return false;
    }
    public void dodaj(Clanstvo c){
    
        
        cl.add(c);
        fireTableDataChanged();
    }
    
    public void obrisi(int selected){
    
        cl.remove(selected);
        fireTableDataChanged();
    }
    
    public ArrayList<Clanstvo> vratiListu(){
    
        return cl;
    }
    
    public void dodajListu(ArrayList<Clanstvo> cla){
    
        cl = cla;
        fireTableDataChanged();
    }
    
}
