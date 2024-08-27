/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kurs;

import domain.Kurs;
import domain.Lekcija;
import java.util.ArrayList;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class UpdateKurs extends AbstractGenericOperation{

    
   private boolean updatovano = false;
   private boolean flag = true;
   private boolean flag2 = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Kurs)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kurs!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.update((Kurs)param);
        ArrayList<Lekcija> lekcije = ((Kurs)param).getLekcije();
        if(lekcije != null){
        
            for (Lekcija lekcija : lekcije) {
                flag = repository.add(lekcija);
                if(!flag){
                
                    flag2 = true;
                }
            }
        }
        if(flag2){
        
            updatovano = false;
        }else{
        
            updatovano = true;
        }
    }
    
    public boolean uspesno(){
    
        return updatovano;
    }
    
}
