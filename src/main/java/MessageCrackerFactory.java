
public class MessageCrackerFactory extends AbstractFactory {

    @Override
    CommandHandler getCommandHandler(Command command) {
        return null;
    }

    @Override
    MessageCracker getMessageCracker( MessageCrackers.MessageCrackerType messageCrackerType) {

        if( messageCrackerType!=null && messageCrackerType.equals(MessageCrackers.MessageCrackerType.STRING))
            return new MessageCrackers.StringMessageCracker();

        return null;
    }


}
