/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Grupa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class TableModelGrupe extends AbstractTableModel{

    ArrayList<Grupa> grupe;
    String[] kolone = {"Naziv grupe", "Maksimalan broj polaznika", "Datum pocetka rada grupe", "Datum i vreme zavrsnog testa", "Kurs"};
    public TableModelGrupe(){
    
        grupe = new ArrayList<>();
    }
    @Override
    public int getRowCount() {
        return grupe.size();
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
        Grupa gr = grupe.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        
        switch (columnIndex) {
            case 0:
                
                return gr.getNazivGrupe();
            case 1:
                return gr.getMaxBrojPolaznika();
            case 2:
                return sdf.format(gr.getDatumPocetkaRadaGrupe());
            case 3:
                return sdf.format(gr.getDatumZavrsnogTesta());
            case 4:
                return gr.getKurs().getNaziv();
            default:
                throw new AssertionError();
        }
    }
    
    public void dodajGrupe(ArrayList<Grupa> gru){
    
        grupe = gru;
        fireTableDataChanged();
    }
    
    public Grupa vratiGrupu(int slected){
    
        return grupe.get(slected);
    }
    public ArrayList<Grupa> vratiListu(){
    
        return grupe;
    }
    
}
