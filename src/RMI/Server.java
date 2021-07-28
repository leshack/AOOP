package RMI;


import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import jdk.internal.dynalink.linker.LinkerServices.Implementation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Server extends Implementation {
     public Server() {} 
   public static void main(String args[]) { 
      try { 
         // Instantiating the implementation class 
         Implementation obj = new Implementation(); 
    
         // Exporting the object of implementation class  
         // (here we are exporting the remote object to the stub) 
        NewInterface stub = (NewInterface) UnicastRemoteObject.exportObject((Remote) obj, 0);  
         
         // Binding the remote object (stub) in the registry 
         Registry registry = LocateRegistry.getRegistry(); 
         
         registry.bind("Hello", stub);  
         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
