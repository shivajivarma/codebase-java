package com.shivajivarma.codebase.network.sockets;

import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;


public class Client {

    private final static int PORT = 6677;//SET A CONSTANT VARIABLE PORT
    private final static String HOST = "localhost";//SET A CONSTANT VARIABLE HOST

    public static void main(String[] args) throws IOException
    {
        try
        {

            Socket s = new Socket(HOST, PORT);//CONNECT TO THE SERVER

            System.out.println("You connected to " + HOST);//IF CONNECTED THEN PRINT IT OUT

            ClientListener client = new ClientListener(s);//START NEW ClientListener OBJECT

            Thread t = new Thread(client);//INITIATE NEW THREAD
            t.start();//START THREAD

        }
        catch (Exception noServer)//IF DIDN'T CONNECT PRINT THAT THEY DIDN'T
        {
            System.out.println("The server might not be up at this time.");
            System.out.println("Please try again later.");
        }
    }
}



class ClientListener implements Runnable {

    private Socket socket;//MAKE SOCKET INSTANCE VARIABLE

    public ClientListener(Socket s)
    {
        socket = s;//INSTANTIATE THE INSTANCE VARIABLE
    }

    @Override
    public void run()//INHERIT THE RUN METHOD FROM THE Runnable INTERFACE
    {
        try
        {
            Scanner chat = new Scanner(System.in);//GET THE INPUT FROM THE CMD
            Scanner in = new Scanner(socket.getInputStream());//GET THE CLIENTS INPUT STREAM (USED TO READ DATA SENT FROM THE SERVER)
            PrintWriter out = new PrintWriter(socket.getOutputStream());//GET THE CLIENTS OUTPUT STREAM (USED TO SEND DATA TO THE SERVER)

            while (true)//WHILE THE PROGRAM IS RUNNING
            {
                String input = chat.nextLine();	//SET NEW VARIABLE input TO THE VALUE OF WHAT THE CLIENT TYPED IN
                out.println(input);//SEND IT TO THE SERVER
                out.flush();//FLUSH THE STREAM

                if(in.hasNext())//IF THE SERVER SENT US SOMETHING
                    System.out.println(in.nextLine());//PRINT IT OUT
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();//MOST LIKELY WONT BE AN ERROR, GOOD PRACTICE TO CATCH THOUGH
        }
    }

}