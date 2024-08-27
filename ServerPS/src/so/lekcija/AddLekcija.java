/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.lekcija;

import domain.Lekcija;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class AddLekcija extends AbstractGenericOperation{
    private boolean dodat = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Lekcija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Lekcija!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        dodat = repository.add((Lekcija)param);
    }
    
    public boolean sacuvano(){
    
        return dodat;
    }
}
