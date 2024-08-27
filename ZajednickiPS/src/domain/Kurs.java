/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class Kurs implements GenericEntity{

    private int kursID;
    private String naziv;
    private String imePrezimePredavaca;
    private int VremeTrajanja;
    private String oblast;
    private ArrayList<Lekcija> lekcije;

    public Kurs() {
    }

    public Kurs(int kursID, String naziv, String imePrezimePredavaca, int VremeTrajanja, String oblast) {
        this.kursID = kursID;
        this.naziv = naziv;
        this.imePrezimePredavaca = imePrezimePredavaca;
        this.VremeTrajanja = VremeTrajanja;
        this.oblast = oblast;
        
    }

    public int getKursID() {
        return kursID;
    }

    public void setKursID(int kursID) {
        this.kursID = kursID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getImePrezimePredavaca() {
        return imePrezimePredavaca;
    }

    public void setImePrezimePredavaca(String imePrezimePredavaca) {
        this.imePrezimePredavaca = imePrezimePredavaca;
    }

    public int getVremeTrajanja() {
        return VremeTrajanja;
    }

    public void setVremeTrajanja(int VremeTrajanja) {
        this.VremeTrajanja = VremeTrajanja;
    }

    public String getOblast() {
        return oblast;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }

    public ArrayList<Lekcija> getLekcije() {
        return lekcije;
    }

    public void setLekcije(ArrayList<Lekcija> lekcije) {
        this.lekcije = lekcije;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
    
    @Override
    public String getTableName() {
        return "kurs";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "KursID, Naziv, ImePrezimePredavaca, VremeTrajanja, Oblast";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(kursID).append(",")
                .append("'").append(naziv).append("',")
                .append("'").append(imePrezimePredavaca).append("',")
                .append(VremeTrajanja).append(",")
                .append("'").append(oblast).append("'");
        return sb.toString();
    }

    @Override
    public String getWhereCondition(Object object) {
        return " KursID = " + ((Kurs)object).getKursID();
    }

    @Override
    public void setId(int id) {
        setKursID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT KursID, Naziv, ImePrezimePredavaca, VremeTrajanja, Oblast FROM kurs";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return " KursID = " + ((Kurs)object).getKursID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Kurs kurs = (Kurs)object;
        
        
        return "Naziv="+"'"+kurs.getNaziv()+"'"+", ImePrezimePredavaca="+"'"+kurs.getImePrezimePredavaca()+"'"+", VremeTrajanja=" + kurs.getVremeTrajanja() + ", Oblast=" +"'" + kurs.getOblast() + "'";
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(kursID);
                
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "KursID";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Kurs k = new Kurs(rs.getInt("KursID"), rs.getString("Naziv"), rs.getString("ImePrezimePredavaca"), rs.getInt("VremeTrajanja"), rs.getString("Oblast"));
        return k;
    }
    
}
