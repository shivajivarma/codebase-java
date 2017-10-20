package com.shivajivarma.codebase.network.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        try {
            final int PORT = 6677;//SET NEW CONSTANT VARIABLE: PORT
            ServerSocket server = new ServerSocket(PORT); //SET PORT NUMBER
            System.out.println("Waiting for clients...");//AT THE START PRINT THIS

            while (true)//WHILE THE PROGRAM IS RUNNING
            {
                Socket s = server.accept();//ACCEPT SOCKETS(CLIENTS) TRYING TO CONNECT

                System.out.println("Client connected from " + s.getLocalAddress().getHostName());    //	TELL THEM THAT THE CLIENT CONNECTED

                ServerListener chat = new ServerListener(s);//CREATE A NEW ServerListener OBJECT
                Thread t = new Thread(chat);//MAKE A NEW THREAD
                t.start();//START THE THREAD
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");//IF AN ERROR OCCURRED THEN PRINT IT
            e.printStackTrace();
        }
    }

}


class ServerListener implements Runnable {

    private Socket socket;//SOCKET INSTANCE VARIABLE

    public ServerListener(Socket s) {
        socket = s;//INSTANTIATE THE SOCKET
    }

    @Override
    public void run() //(IMPLEMENTED FROM THE RUNNABLE INTERFACE)
    {
        try //HAVE TO HAVE THIS FOR THE in AND out VARIABLES
        {
            Scanner in = new Scanner(socket.getInputStream());//GET THE SOCKETS INPUT STREAM (THE STREAM THAT YOU WILL GET WHAT THEY TYPE FROM)
            PrintWriter out = new PrintWriter(socket.getOutputStream());//GET THE SOCKETS OUTPUT STREAM (THE STREAM YOU WILL SEND INFORMATION TO THEM FROM)

            while (true)//WHILE THE PROGRAM IS RUNNING
            {
                if (in.hasNext()) {
                    String input = in.nextLine();//IF THERE IS INPUT THEN MAKE A NEW VARIABLE input AND READ WHAT THEY TYPED
                    System.out.println("Client Said: " + input);//PRINT IT OUT TO THE SCREEN
                    out.println("Server Reply: Converted to Uppercase - > '" + input.toUpperCase() + "'");//RESEND IT TO THE CLIENT
                    out.flush();//FLUSH THE STREAM
                }
            }
        } catch (Exception e) {
            e.printStackTrace();//MOST LIKELY THERE WONT BE AN ERROR BUT ITS GOOD TO CATCH
        }
    }

}


