import java.net.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KVServer {

    private static final ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
        
            System.err.println("Usage: KVServer <port number>");
            System.exit(1);
        }
        
        int portNumber = Integer.parseInt(args[0]);
         
        ServerSocket serverSocket= new ServerSocket(Integer.parseInt(args[0]));
        Socket clientSocket;

        while (true){

            try {

                clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                threadPool.submit(clientHandler);

            }
            catch (IOException e)
            {
                System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }
}
           
