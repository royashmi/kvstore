
public abstract class AbstractFactory {

    abstract CommandHandler getCommandHandler( Command command );
    abstract MessageCracker getMessageCracker( MessageCrackers.MessageCrackerType messageCrackerType );
}
