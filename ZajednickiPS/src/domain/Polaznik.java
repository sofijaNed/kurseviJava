/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class Polaznik implements GenericEntity{

    private int polaznikID;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String username;
    private String lozinka;
    private String pol;
    private String telefon;

    public Polaznik() {
    }

    public Polaznik(int polaznikID, String ime, String prezime, Date datumRodjenja,  String username, String lozinka, String pol, String telefon) {
        this.polaznikID = polaznikID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.username = username;
        this.lozinka = lozinka;
        this.pol = pol;
        this.telefon = telefon;
    }

    public int getPolaznikID() {
        return polaznikID;
    }

    public void setPolaznikID(int polaznikID) {
        this.polaznikID = polaznikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    

   
    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    @Override
    public String getTableName() {
        return "polaznik";
    }

    @Override
    public String getColumnNamesForInsert() {
        return " Ime, Prezime, DatumRodjenja, Username, Lozinka, Pol, Telefon";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(ime).append("'").append(",")
                .append("'").append(prezime).append("'").append(",")
                .append("'").append((new java.sql.Date(datumRodjenja.getTime())).toString()).append("'").append(",")
                .append("'").append(username).append("'").append(",")
                .append("'").append(lozinka).append("'").append(",")
                .append("'").append(pol).append("'").append(",")
                .append("'").append(telefon).append("'");
                
        return sb.toString();
    }

    @Override
    public String getWhereCondition(Object object) {
        return " PolaznikID = " + ((Polaznik)object).getPolaznikID();
    }

    @Override
    public void setId(int id) {
        setPolaznikID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT PolaznikID, Ime, Prezime , DatumRodjenja, Username, Lozinka, Pol, Telefon FROM polaznik";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return " PolaznikID = " + ((Polaznik)object).getPolaznikID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Polaznik p = (Polaznik)object;
        return "Ime =" + "'" + p.getIme() + "'" + ", Prezime =" + "'" + p.getPrezime() + "'" + ", DatumRodjenja= " + "'" + (new java.sql.Date(p.getDatumRodjenja().getTime())).toString() + "'" 
                + ", Username = '" + p.getUsername() + "', Lozinka = '" + p.getLozinka() + "'" + ", Pol = '" + p.getPol() + "'" 
                + ", Telefon = '" + p.getTelefon() + "'";
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(polaznikID).append(",")
                .append("'").append(datumRodjenja.toString()).append("'");
                
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "PolaznikID, DatumRodjenja";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        
        
        Polaznik p = new Polaznik(rs.getInt("PolaznikID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getDate("DatumRodjenja"), rs.getString("Username"), rs.getString("Lozinka"), 
        rs.getString("Pol"), rs.getString("Telefon"));
        return p;
    }
    
}
