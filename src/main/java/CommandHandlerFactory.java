
public class CommandHandlerFactory extends AbstractFactory {

    @Override
    CommandHandler getCommandHandler(Command command) {

        if( command != null )
        {
            if( command.getCommandType().equals(CommandTypes.CommandType.GET))
                return new CommandHandlers.GetCommandHandler();
            else if( command.getCommandType().equals(CommandTypes.CommandType.PUT))
                return new CommandHandlers.PutCommandHandler();
            else if( command.getCommandType().equals(CommandTypes.CommandType.DEL))
                return new CommandHandlers.DelCommandHandler();
            else if( command.getCommandType().equals(CommandTypes.CommandType.BYE))
                return new CommandHandlers.ByeCommandHandler();
            else
                return new CommandHandlers.UnknownCommandHandler();
        }

        return null;
    }

    @Override
    MessageCracker getMessageCracker(MessageCrackers.MessageCrackerType messageCrackerType) {
        return null;
    }
}
