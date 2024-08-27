/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.polaznik;

import domain.Polaznik;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetOnePolaznik extends AbstractGenericOperation{
    private Polaznik polaznik;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Polaznik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Polaznik!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        polaznik = (Polaznik) repository.getOne((Polaznik)param);
    }
    
    public Polaznik getPolaznik(){
        return polaznik;
    }
}
