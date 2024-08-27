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
public class AddClanstvo extends AbstractGenericOperation{
    private boolean dodat = false;
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        dodat = repository.add((Clanstvo)param);
    }
    
    public boolean sacuvano(){
    
        return dodat;
    }
}
