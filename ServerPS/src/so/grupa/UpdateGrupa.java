/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.grupa;

import domain.Clanstvo;
import domain.Grupa;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class UpdateGrupa extends AbstractGenericOperation{
    private boolean updatovano = true;
    private boolean flag = false;
    private boolean flag2 = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Grupa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Grupa!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        List<Clanstvo> clanstvo = repository.getAll(new Clanstvo());
        for (Clanstvo clanstvo1 : clanstvo) {
            if(clanstvo1.getGrupa().getGrupaID()==((Grupa)param).getGrupaID()){
            
                 repository.delete(clanstvo1);
               
            }
        }
        
         repository.update((Grupa)param);
        List<Clanstvo> ubacivanje = ((Grupa)param).getCl();
        if(ubacivanje != null){
        
            for (Clanstvo clanstvo1 : ubacivanje) {
                flag = repository.add(clanstvo1);
                if(!flag){
                
                    updatovano = false;
                }
            }
        }
        
    }
    
    public boolean uspesno(){
    
        return updatovano;
    }
}
