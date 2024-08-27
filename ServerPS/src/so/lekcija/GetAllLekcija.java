/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.lekcija;


import domain.Lekcija;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetAllLekcija extends AbstractGenericOperation{
    private List<Lekcija> lekcije;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Lekcija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Lekcija!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        lekcije = repository.getAll((Lekcija)param);
    }
    
    public List<Lekcija> getLekcije(){
        return lekcije;
    }
}
