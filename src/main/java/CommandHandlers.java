
public class CommandHandlers {

    public static class GetCommandHandler implements CommandHandler
    {

        @Override
        public String handleCommand(Command command) {
            return MemStore.get(command.getKey());
        }
    }

    public static class PutCommandHandler implements CommandHandler
    {

        @Override
        public String handleCommand(Command command) {
            return MemStore.put(command.getKey(),command.getValue());
        }
    }

    public static class DelCommandHandler implements CommandHandler
    {

        @Override
        public String handleCommand(Command command) {
            return MemStore.del(command.getKey());
        }
    }

    public static class ByeCommandHandler implements CommandHandler
    {

        @Override
        public String handleCommand(Command command) {
            return "BYE";
        }
    }

    public static class UnknownCommandHandler implements CommandHandler
    {

        @Override
        public String handleCommand(Command command) {
            return "Unknown Command";
        }
    }
}
