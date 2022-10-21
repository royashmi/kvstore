import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket clientSocket;

    private static final MessageCrackerFactory messageCrackerFactory  = (MessageCrackerFactory) FactoryProducer.getFactory(KVConstants.MessageCrackerFactory);

    // This is hard-coded now - should be taken from config or during client's init dialog
    private static final MessageCracker messageCracker = messageCrackerFactory.getMessageCracker(MessageCrackers.MessageCrackerType.STRING);

    private static final CommandHandlerFactory commandHandlerFactory = (CommandHandlerFactory)FactoryProducer.getFactory(KVConstants.CommandHandlerFactory);

    ClientHandler(Socket clientSocket )
    {
        this.clientSocket=clientSocket;
    }

    public void run(){

        try{

            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                Command command = messageCracker.getCommand( inputLine );
                String response = commandHandlerFactory.getCommandHandler(command).handleCommand(command);
                out.println(response);

                if( command.getCommandType().equals(CommandTypes.CommandType.BYE))
                {
                    clientSocket.close();
                    break;
                }
            }
        } catch(IOException e)
        {
            System.out.println("IOException caught - "+e);
            e.printStackTrace();
        }
    }
}
