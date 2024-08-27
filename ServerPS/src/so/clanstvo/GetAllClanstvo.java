/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clanstvo;

import domain.Clanstvo;
import domain.Grupa;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetAllClanstvo extends AbstractGenericOperation{
     private List<Clanstvo> clanstva;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        clanstva = repository.getAll((Clanstvo)param);
    }
    
    public List<Clanstvo> getClanstva(){
        return clanstva;
    }
}
