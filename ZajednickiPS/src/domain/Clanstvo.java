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
public class Clanstvo implements GenericEntity{

    private Grupa grupa;
    private Polaznik polaznik;
    private String status;
    private int ocena;

    public Clanstvo() {
    }

    public Clanstvo(Grupa grupa, Polaznik polaznik, String status, int ocena) {
        this.grupa = grupa;
        this.polaznik = polaznik;
        this.status = status;
        this.ocena = ocena;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
    
    
    
    @Override
    public String getTableName() {
        return "clanstvo";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "GrupaID, PolaznikID, Status, Ocena";
    }

    @Override
    public String getInsertValues() {
         StringBuilder sb = new StringBuilder();
         sb.append(grupa.getGrupaID()).append(",")
                .append(polaznik.getPolaznikID()).append(",")
                .append("'").append(status).append("'").append(",")
                .append(ocena);
        return sb.toString();
    }

    @Override
    public String getWhereCondition(Object object) {
        return " GrupaID = " + ((Clanstvo)object).getGrupa().getGrupaID();
    }

    @Override
    public void setId(int id) {
        getGrupa().setGrupaID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT c.grupaID, c.polaznikID, c.status, c.ocena, p.polaznikID,p.Ime,p.Prezime,p.DatumRodjenja,p.username, p.lozinka, p.pol, p.telefon, "
                + "g.grupaID,g.MaxBrojPolaznika,g.NazivGrupe,g.DatumPocetkaRadaGrupe, g.datumZavrsnogTesta, g.kursID, "
                + "k.kursID, k.naziv,k.ImePrezimePredavaca,k.vremeTrajanja, k.oblast FROM clanstvo c JOIN polaznik p ON (c.polaznikID = p.polaznikID) JOIN grupa g ON (c.grupaID = g.grupaID) "
                + " JOIN kurs k ON (g.kursID = k.kursID)";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "  GrupaID = " + ((Clanstvo)object).getGrupa().getGrupaID() + " AND PolaznikID = " + ((Clanstvo)object).getPolaznik().getPolaznikID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Clanstvo cl = (Clanstvo)object;
        return " Ocena = " + cl.getOcena();
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
         sb.append(grupa.getGrupaID()).append(",")
                .append(polaznik.getPolaznikID()).append(",");
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "GrupaID, PolaznikID";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Polaznik p = new Polaznik(rs.getInt("PolaznikID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getDate("DatumRodjenja"), rs.getString("Username"), rs.getString("Lozinka"), 
        rs.getString("Pol"), rs.getString("Telefon"));
        Kurs k = new Kurs(rs.getInt("KursID"), rs.getString("Naziv"), rs.getString("ImePrezimePredavaca"), rs.getInt("VremeTrajanja"), rs.getString("Oblast"));
        Grupa g = new Grupa(rs.getInt("GrupaID"), rs.getInt("MaxBrojPolaznika"), rs.getString("Naziv"),
                rs.getDate("DatumPocetkaRadaGrupe"), rs.getDate("DatumZavrsnogTesta"), k);
        Clanstvo c = new Clanstvo(g, p, rs.getString("Status"), rs.getInt("Ocena"));
        return c;
    }
    
}
