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
public class UpdatePolaznik extends AbstractGenericOperation{

    private boolean updatovano = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Polaznik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Polaznik!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        updatovano = repository.update((Polaznik)param);
    }
    
    public boolean uspesno(){
    
        return updatovano;
    }
    
}