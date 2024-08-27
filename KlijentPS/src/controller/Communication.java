/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Clanstvo;
import domain.Grupa;
import domain.Kurs;
import domain.Lekcija;
import domain.Polaznik;
import domain.User;
import domain.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class Communication {
    Socket socket;
    Sender sender;
    Receiver receiver;
    Request request;
    Response response;
    private static Communication instance;
    
    private Communication() throws IOException{
        socket = new Socket("localhost",9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);   
    }
    
    public static Communication getInstance() throws IOException{
        if(instance==null){
            instance = new Communication();
        }
        
        return instance;
    }
    
    public Object logIn(String username,String password){
        try {
            User user = new User(username,password);
            request = new Request(Operation.LOGIN,user);
            sender.send(request);
            System.out.println("Poslao zahtev");
            response = (Response) receiver.receive();
            System.out.println("Primio zahtev");
            if(response.getException()==null){
                return response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

   

    public Object addPolaznik(Polaznik polaznik) {
        try {
            request = new Request(Operation.ADD, polaznik);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public ArrayList<Polaznik> getAllPolaznici() {
        try {
            request = new Request(Operation.GET,new Polaznik());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<Polaznik>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object updatePolaznik(Polaznik po) {
        try {
            request = new Request(Operation.UPDATE, po);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Kurs createKurs(Kurs kurs) {
        try {
            request = new Request(Operation.CREATE,kurs);
            sender.send(request);
            response = (Response)receiver.receive();
            return (Kurs) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object updateKurs(Kurs kur) {
        try {
            request = new Request(Operation.UPDATE, kur);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object addLekcija(Lekcija lekcija) {
        try {
            request = new Request(Operation.ADD, lekcija);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public ArrayList<Kurs> getAllKurs() {
        try {
            request = new Request(Operation.GET,new Kurs());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<Kurs>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<Lekcija> getAllLekcija() {
         try {
            request = new Request(Operation.GET,new Lekcija());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<Lekcija>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object updateGrupa(Grupa gr) {
         try {
            request = new Request(Operation.UPDATE, gr);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object addClanstvo(Clanstvo cl) {
        try {
            request = new Request(Operation.ADD, cl);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

   public Grupa createGrupa(Grupa gr){
   
       try {
            request = new Request(Operation.CREATE,gr);
            sender.send(request);
            response = (Response)receiver.receive();
            return (Grupa) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
   }

    public ArrayList<Grupa> getAllGrupe() {
         try {
            request = new Request(Operation.GET,new Grupa());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<Grupa>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<Clanstvo> getAllClanstvo() {
        try {
            request = new Request(Operation.GET,new Clanstvo());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<Clanstvo>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean deleteClanstvo(Clanstvo c) {
        try {
            request = new Request(Operation.DELETE, c);
            sender.send(request);
            response = (Response) receiver.receive();
            return (boolean)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object updateClanstvo(Clanstvo clanstvo) {
        try {
            request = new Request(Operation.UPDATE, clanstvo);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
