/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kurs;

import domain.Kurs;
import domain.Polaznik;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetAllKurs extends AbstractGenericOperation{
    
     private List<Kurs> kursevi;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Kurs)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kurs!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        kursevi = repository.getAll((Kurs)param);
    }
    
    public List<Kurs> getKursevi(){
        return kursevi;
    }
    
}
