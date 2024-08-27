/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class Lekcija implements GenericEntity{

    private int lekcijaID;
    private Kurs kurs;
    private String naziv;

    public Lekcija() {
    }

    public Lekcija(int lekcijaID, Kurs kurs, String naziv) {
        this.lekcijaID = lekcijaID;
        this.kurs = kurs;
        this.naziv = naziv;
    }

    public int getLekcijaID() {
        return lekcijaID;
    }

    public void setLekcijaID(int lekcijaID) {
        this.lekcijaID = lekcijaID;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
    @Override
    public String getTableName() {
        return "lekcija";
    }

    @Override
    public String getColumnNamesForInsert() {
        return " NazivLekcija, KursID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(naziv).append("'").append(",").append(kurs.getKursID());
                
                
        return sb.toString();
    }

    @Override
    public String getWhereCondition(Object object) {
        return "l.kursID = " + ((Lekcija)object).getKurs().getKursID();
    }

    @Override
    public void setId(int id) {
        setLekcijaID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT l.lekcijaID,l.nazivLekcija,l.kursID,k.kursID,k.naziv,k.ImePrezimePredavaca,k.vremeTrajanja, k.oblast FROM lekcija AS l INNER JOIN kurs AS k ON l.kursID = k.kursID";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "l.lekcijaID = " + ((Lekcija)object).getLekcijaID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Lekcija lek = (Lekcija)object;
        
        return "nazivLekcija="+"'"+lek.getNaziv()+"'";
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(lekcijaID).append(",")
                .append(kurs.getKursID());
                
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "LekcijaID, KursID";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Kurs k = new Kurs(rs.getInt("KursID"), rs.getString("Naziv"), rs.getString("ImePrezimePredavaca"), rs.getInt("VremeTrajanja"), rs.getString("Oblast"));
        Lekcija lek = new Lekcija(rs.getInt("LekcijaID"), k, rs.getString("NazivLekcija"));
        return lek;
    }
    
}
