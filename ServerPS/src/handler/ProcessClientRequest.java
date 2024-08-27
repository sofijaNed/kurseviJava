/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handler;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domain.User;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class ProcessClientRequest extends Thread{
    
    Socket socket;
    Sender sender;
    Receiver receiver;
    Request request = null;
    Response response = null;
    
    public ProcessClientRequest(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while(true){
        
            try {
                request = (Request) receiver.receive();
                response = new Response();
                switch (request.getOperation()) {
                    case LOGIN:
                        User user = (User) request.getArgument();
                        System.out.println("Primio zahtev");
                        
                        response.setResult(Controller.getInstance().login(user));
                        System.out.println("User je: " + response.getResult());
                        break;
                        case ADD:
                        response.setResult(Controller.getInstance().add(request.getArgument()));
                        break;
                        case GET:
                        response.setResult(Controller.getInstance().getAll(request.getArgument()));
                        break;
                        case UPDATE:
                        response.setResult(Controller.getInstance().update(request.getArgument()));
                        break;
                        case CREATE:
                        response.setResult(Controller.getInstance().create(request.getArgument()));
                        break;
                        case DELETE:
                        response.setResult(Controller.getInstance().delete(request.getArgument()));
                        break;
                        case GET_ONE:
                        response.setResult(Controller.getInstance().getOne(request.getArgument()));
                        break;
                   default:
                        throw new AssertionError();
                }
                sender.send(response);
            } catch (Exception ex) {
                System.out.println("Nema odgovora.");
                Logger.getLogger(ProcessClientRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
     public Socket getSocket() {
        return socket;
    }
    
}
