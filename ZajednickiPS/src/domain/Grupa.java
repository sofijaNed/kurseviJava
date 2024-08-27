/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class Grupa implements GenericEntity{

    private int grupaID;
    private int maxBrojPolaznika;
    private String nazivGrupe;
    private Date datumPocetkaRadaGrupe;
    private Date datumZavrsnogTesta;
    private Kurs kurs;
    private ArrayList<Clanstvo> cl;

    public Grupa() {
    }

    public Grupa(int grupaID, int maxBrojPolaznika, String nazivGrupe, Date datumPocetkaRadaGrupe, Date datumZavrsnogTesta, Kurs kurs) {
        this.grupaID = grupaID;
        this.maxBrojPolaznika = maxBrojPolaznika;
        this.nazivGrupe = nazivGrupe;
        this.datumPocetkaRadaGrupe = datumPocetkaRadaGrupe;
        this.datumZavrsnogTesta = datumZavrsnogTesta;
        this.kurs = kurs;
    }

    public int getGrupaID() {
        return grupaID;
    }

    public void setGrupaID(int grupaID) {
        this.grupaID = grupaID;
    }

    public int getMaxBrojPolaznika() {
        return maxBrojPolaznika;
    }

    public void setMaxBrojPolaznika(int maxBrojPolaznika) {
        this.maxBrojPolaznika = maxBrojPolaznika;
    }

    public String getNazivGrupe() {
        return nazivGrupe;
    }

    public void setNazivGrupe(String nazivGrupe) {
        this.nazivGrupe = nazivGrupe;
    }

    public Date getDatumPocetkaRadaGrupe() {
        return datumPocetkaRadaGrupe;
    }

    public void setDatumPocetkaRadaGrupe(Date datumPocetkaRadaGrupe) {
        this.datumPocetkaRadaGrupe = datumPocetkaRadaGrupe;
    }

    public Date getDatumZavrsnogTesta() {
        return datumZavrsnogTesta;
    }

    public void setDatumZavrsnogTesta(Date datumZavrsnogTesta) {
        this.datumZavrsnogTesta = datumZavrsnogTesta;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public ArrayList<Clanstvo> getCl() {
        return cl;
    }

    public void setCl(ArrayList<Clanstvo> cl) {
        this.cl = cl;
    }

    @Override
    public String toString() {
        return nazivGrupe;
    }
    
    
    
    @Override
    public String getTableName() {
        return "grupa";
    }

    @Override
    public String getColumnNamesForInsert() {
        return " MaxBrojPolaznika, NazivGrupe, DatumPocetkaRadaGrupe, DatumZavrsnogTesta, KursID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(maxBrojPolaznika).append(",")
                .append("'").append(nazivGrupe).append("'").append(",")
                .append("'").append((new java.sql.Date(datumPocetkaRadaGrupe.getTime())).toString()).append("'").append(",")
                .append("'").append((new java.sql.Date(datumZavrsnogTesta.getTime())).toString()).append("'").append(",")
                .append(kurs.getKursID());
                
        return sb.toString();
    }

    @Override
    public String getWhereCondition(Object object) {
        return "g.grupaID = " + ((Grupa)object).getGrupaID();
    }

    @Override
    public void setId(int id) {
        setGrupaID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT g.grupaID,g.MaxBrojPolaznika,g.NazivGrupe,g.DatumPocetkaRadaGrupe, g.datumZavrsnogTesta, g.kursID, "
                + "k.kursID, k.naziv,k.ImePrezimePredavaca,k.vremeTrajanja, k.oblast FROM grupa AS g INNER JOIN kurs AS k ON g.kursID = k.kursID";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return " GrupaID = " + ((Grupa)object).getGrupaID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Grupa g = (Grupa)object;
        return "MaxBrojPolaznika="+g.getMaxBrojPolaznika()+", NazivGrupe="+"'"+g.getNazivGrupe()+"'"+", datumPocetkaRadaGrupe=" + "'" + (new java.sql.Date(datumPocetkaRadaGrupe.getTime())).toString()+ "'" +", datumZavrsnogTesta=" + "'" +  (new java.sql.Date(datumZavrsnogTesta.getTime())).toString()+ "'" + ", KursID=" + g.getKurs().getKursID();
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(grupaID).append(",")
                .append("'").append((new java.sql.Date(datumPocetkaRadaGrupe.getTime())).toString()).append("'").append(",")
                .append("'").append((new java.sql.Date(datumZavrsnogTesta.getTime())).toString()).append("'").append(",")
                .append(kurs.getKursID());
                
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "GrupaID, DatumPocetkaRadaGrupe, DatumZavrsnogTesta, KursID";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Kurs k = new Kurs(rs.getInt("KursID"), rs.getString("Naziv"), rs.getString("ImePrezimePredavaca"), rs.getInt("VremeTrajanja"), rs.getString("Oblast"));
        Grupa g = new Grupa(rs.getInt("GrupaID"), rs.getInt("MaxBrojPolaznika"), rs.getString("NazivGrupe"),
                rs.getDate("DatumPocetkaRadaGrupe"), rs.getDate("DatumZavrsnogTesta"), k);
        return g;
    }
    
}
