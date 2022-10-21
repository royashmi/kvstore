import java.util.HashMap;
import java.util.Map;

public class FactoryProducer {

    private static Map<String,AbstractFactory> factoryMap = new HashMap<String, AbstractFactory>();

    public static AbstractFactory getFactory( String factory )
    {
        if(factory != null)
        {
            if( factory.equals(KVConstants.CommandHandlerFactory ))
                return getCommandHandlerFactory();
            else  if( factory.equals(KVConstants.MessageCrackerFactory ))
                return getMessageCrackerFactory();
        }
        return null;
    }

    public static AbstractFactory getCommandHandlerFactory()
    {
        if( factoryMap.containsKey(KVConstants.CommandHandlerFactory ))
            return factoryMap.get(factoryMap.get(KVConstants.CommandHandlerFactory));
        else
        {
            AbstractFactory commandHandlerFactory = new CommandHandlerFactory();
            factoryMap.put(KVConstants.CommandHandlerFactory,commandHandlerFactory);
            return commandHandlerFactory;
        }
    }

    public static AbstractFactory getMessageCrackerFactory()
    {
        if( factoryMap.containsKey(KVConstants.MessageCrackerFactory ))
            return factoryMap.get(factoryMap.get(KVConstants.MessageCrackerFactory));
        else
        {
            AbstractFactory messageCrackerFactory = new MessageCrackerFactory();
            factoryMap.put(KVConstants.MessageCrackerFactory,messageCrackerFactory);
            return messageCrackerFactory;
        }
    }
}
