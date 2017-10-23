Sockets
===============

Communicating between two devices using Java __Sockets__.

__Server :__ Listens to requests from clients, process them and replies back.  
__Client :__ Takes input from user and send it server, recieves response and displays it.

### SERVER CODE
```java
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
```

### CLIENT CODE
```java
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
```

:+1:
