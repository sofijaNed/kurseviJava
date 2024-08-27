/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.grupa;

import domain.Grupa;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetAllGrupe extends AbstractGenericOperation{
    private List<Grupa> grupe;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Grupa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Grupa!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        grupe = repository.getAll((Grupa)param);
    }
    
    public List<Grupa> getGrupe(){
        return grupe;
    }
    
}
