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
public class DeleteClanstvo extends AbstractGenericOperation{

    private boolean uspesno = false;
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
         uspesno = repository.delete((Clanstvo)param);
    }
    
    public boolean obrisano(){
        return uspesno;
    }
}
