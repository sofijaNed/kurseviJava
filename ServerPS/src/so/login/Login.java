/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.login;

import domain.Polaznik;
import domain.User;
import domain.Zaposleni;
import java.util.List;
import javax.swing.JOptionPane;
import operation.AbstractGenericOperation;
import so.polaznik.GetAllPolaznik;
import so.zaposleni.GetAllZaposleni;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class Login extends AbstractGenericOperation{

    private Object login;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof User)) {
            throw new Exception("Prosledjeni objekat nije instanca klase User!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        User user = (User)param;
        
            
            AbstractGenericOperation ago = new GetAllPolaznik();
            ago.execute(new Polaznik());
            List<Polaznik> polaznici = ((GetAllPolaznik)ago).getPolazniks();

            if(!polaznici.isEmpty()){
            for(Polaznik polaznik:polaznici){
                

                if(polaznik.getUsername().equals(user.getUsername()) && polaznik.getLozinka().equals(user.getLozinka())){
                    login = polaznik;
                    break;
                }
                else{
                    login = null;
                }
            }
            }
            
            if(login==null){
            
            AbstractGenericOperation ago1 = new GetAllZaposleni();
            ago1.execute(new Zaposleni());
            List<Zaposleni> zap = ((GetAllZaposleni)ago1).getZaposleni();
            for(Zaposleni za: zap){
            
                System.out.println(za);
            }
            if(!zap.isEmpty()){

            for(Zaposleni zaposl:zap){
                

                if(zaposl.getUsername().equals(user.getUsername()) && zaposl.getLoznika().equals(user.getLozinka())){
                    login = zaposl;
                    break;
                }
                else{
                    login = null;
                }
            }
            }
            }
              
    }
    
    public Object getLogin(){
        return login;
    }
    
}
