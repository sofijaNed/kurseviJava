/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kurs;

import domain.Kurs;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class CreateKurs extends AbstractGenericOperation{

    private Kurs kurs;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Kurs)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kurs!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        kurs = (Kurs) repository.create((Kurs)param);
    }
    
    public Kurs getCreatedKurs(){
        return kurs;
    }
    
}
