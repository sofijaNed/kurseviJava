/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clanstvo;

import domain.Clanstvo;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class UpdateClanstvo extends AbstractGenericOperation{
    private boolean updatovano = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Clanstvo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clanstvo!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        updatovano = repository.update((Clanstvo)param);
    }
    
    public boolean uspesno(){
    
        return updatovano;
    }
}
