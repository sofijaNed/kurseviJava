/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Clanstvo;
import domain.Grupa;
import domain.Kurs;
import domain.Lekcija;
import domain.Polaznik;
import domain.User;
import domain.Zaposleni;
import operation.AbstractGenericOperation;
import so.clanstvo.AddClanstvo;
import so.clanstvo.DeleteClanstvo;
import so.clanstvo.GetAllClanstvo;
import so.clanstvo.UpdateClanstvo;
import so.grupa.CreateGrupa;
import so.grupa.GetAllGrupe;
import so.grupa.GetOneGrupa;
import so.grupa.UpdateGrupa;
import so.kurs.CreateKurs;
import so.kurs.GetAllKurs;
import so.kurs.GetOneKurs;
import so.kurs.UpdateKurs;
import so.lekcija.AddLekcija;
import so.lekcija.GetAllLekcija;
import so.login.Login;
import so.polaznik.AddPolaznik;
import so.polaznik.GetAllPolaznik;
import so.polaznik.GetOnePolaznik;
import so.polaznik.UpdatePolaznik;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class Controller {
    private static Controller instance;
    private AbstractGenericOperation operation;

    public Controller() {
    }

    public static Controller getInstance() {
        if(instance==null){
        
            instance = new Controller();
        }
        return instance;
    }
     public boolean add(Object argument) throws Exception {
        if(argument instanceof Polaznik) return addPolaznik(argument);
        if(argument instanceof Lekcija) return addLekcija(argument);
        if(argument instanceof Clanstvo) return addClanstvo(argument);
        
        
        return false;
    }
     
     public Object getAll(Object argument) throws Exception {
        if(argument instanceof Polaznik) return getAllPolaznici(argument);
        if(argument instanceof Kurs) return getAllKurs(argument);
        if(argument instanceof Lekcija) return getAllLekcija(argument);
        if(argument instanceof Grupa) return getAllGrupe(argument);
        if(argument instanceof Clanstvo) return getAllClanstvo(argument);
        
        return null;
        
    }
     
     public boolean update(Object argument) throws Exception {
        if(argument instanceof Polaznik) return updatePolaznik(argument);
        if(argument instanceof Kurs) return updateKurs(argument);
        if(argument instanceof Grupa) return updateGrupa(argument);
        if(argument instanceof Clanstvo) return updateClanstvo(argument);
        
        return false;
    }
     
      public Object create(Object argument) throws Exception {
        if(argument instanceof Kurs) return createKurs(argument);
        if(argument instanceof Grupa) return createGrupa(argument);
        
        return null;
    }
      
      public Object getOne(Object argument) throws Exception {
        if(argument instanceof Polaznik) return getOnePolaznik(argument);
        if(argument instanceof Kurs) return getOneKurs(argument);
        if(argument instanceof Grupa) return GetOneGrupa(argument);
        
        return null;
    }
      
      public boolean delete(Object argument) throws Exception {
        if(argument instanceof Clanstvo) return deleteClanstvo(argument);
        
        return false;
    }
    
    public Object login(User user) throws Exception{
        operation = new Login();
        operation.execute(user);
        return ((Login)operation).getLogin();
    }

   

    private boolean addPolaznik(Object argument) throws Exception {
        operation = new AddPolaznik();
        operation.execute(argument);
        return ((AddPolaznik)operation).sacuvano();
    }

    

    private Object getAllPolaznici(Object argument) throws Exception {
        operation = new GetAllPolaznik();
        operation.execute(argument);
        return ((GetAllPolaznik)operation).getPolazniks();
    }

    

    private boolean updatePolaznik(Object argument) throws Exception {
        operation = new UpdatePolaznik();
        operation.execute(argument);
        return ((UpdatePolaznik)operation).uspesno();
    }

   

    private Object createKurs(Object argument) throws Exception {
        operation = new CreateKurs();
        operation.execute(argument);
        return ((CreateKurs)operation).getCreatedKurs();
    }

    private boolean updateKurs(Object argument) throws Exception {
        operation = new UpdateKurs();
        operation.execute(argument);
        return ((UpdateKurs)operation).uspesno();
    }

    private boolean addLekcija(Object argument) throws Exception {
         operation = new AddLekcija();
         operation.execute(argument);
         return ((AddLekcija)operation).sacuvano();
    }

    private Object getAllKurs(Object argument) throws Exception {
        operation = new GetAllKurs();
        operation.execute(argument);
        return ((GetAllKurs)operation).getKursevi();
    }

    private Object getAllLekcija(Object argument) throws Exception {
        operation = new GetAllLekcija();
        operation.execute(argument);
        return ((GetAllLekcija)operation).getLekcije();
    }

    private Object createGrupa(Object argument) throws Exception {
        operation = new CreateGrupa();
        operation.execute(argument);
        return ((CreateGrupa)operation).getCreatedGrupa();
    }

    private boolean updateGrupa(Object argument) throws Exception {
        operation = new UpdateGrupa();
        operation.execute(argument);
        return ((UpdateGrupa)operation).uspesno();
    }

    private boolean addClanstvo(Object argument) throws Exception {
         operation = new AddClanstvo();
         operation.execute(argument);
         return ((AddClanstvo)operation).sacuvano();
    }

    private Object getAllGrupe(Object argument) throws Exception {
        operation = new GetAllGrupe();
        operation.execute(argument);
        return ((GetAllGrupe)operation).getGrupe();
    }

    private Object getAllClanstvo(Object argument) throws Exception {
        operation = new GetAllClanstvo();
        operation.execute(argument);
        return ((GetAllClanstvo)operation).getClanstva();
    }

    

    private boolean deleteClanstvo(Object argument) throws Exception {
        operation = new DeleteClanstvo();
        operation.execute(argument);
        return ((DeleteClanstvo)operation).obrisano();
    }

    private boolean updateClanstvo(Object argument) throws Exception {
        operation = new UpdateClanstvo();
        operation.execute(argument);
        return ((UpdateClanstvo)operation).uspesno();
    }

    private Object getOnePolaznik(Object argument) throws Exception {
        operation = new GetOnePolaznik();
        operation.execute(argument);
        return ((GetOnePolaznik)operation).getPolaznik();
    }

    private Object getOneKurs(Object argument) throws Exception {
        operation = new GetOneKurs();
        operation.execute(argument);
        return ((GetOneKurs)operation).getKurs();
    }

    private Object GetOneGrupa(Object argument) throws Exception {
        operation = new GetOneGrupa();
        operation.execute(argument);
        return ((GetOneGrupa)operation).getGrupa();
    }
    
          
}
