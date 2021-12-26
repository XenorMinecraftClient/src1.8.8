package xenor.websockets;

import java.io.IOException;
import co.gongzh.procbridge.Client;

import java.net.ServerSocket;

public class SocketClient {

  /*  public static final Client client = new Client("localhost", 1337);
    //5.182.204.144

    public static void main(String[] args) {

        while(true) {
            //client.getHost()
        }
    } 

    public static Object sendRequest(String... args) {
        return client.request("echo", String.join(" ", args));
    }
    
    public static boolean isUser(String username) {
    	String[] arguments = client.request("isUser", username).toString().split(":");
        if(arguments[0].equals("true")) {
            //System.out.println("returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("there was an error for " + username);
        	return false;
        }
    }

    public static double randomNumber(double max, double min) {
        return (Math.random() * (max - min)) + min;
    } */
}