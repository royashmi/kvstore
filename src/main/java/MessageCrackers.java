
public class MessageCrackers {

    public enum MessageCrackerType{
        STRING("string");

        private String messageCrackerType;

        private MessageCrackerType(String messageCrackerType) {
            this.messageCrackerType = messageCrackerType;
        }

        @Override
        public String toString(){
            return messageCrackerType;
        }
    }

    public static class StringMessageCracker implements MessageCracker{

        @Override
        public Command getCommand(String message) {

            if(message != null && !message.isEmpty())
            {
                String [] tokens = message.split("\\s+");

                if(tokens != null && tokens.length > 0)
                {
                    String commandType = tokens[0];

                    if(commandType.equalsIgnoreCase("get"))
                    {
                        return new Command( CommandTypes.CommandType.GET, tokens[1], null);
                    }
                    else if(commandType.equalsIgnoreCase("put"))
                    {
                        return new Command( CommandTypes.CommandType.PUT, tokens[1], tokens[2]);
                    }
                    else if(commandType.equalsIgnoreCase("del"))
                    {
                        return new Command( CommandTypes.CommandType.DEL, tokens[1], null);
                    }
                    else if(commandType.equalsIgnoreCase("bye"))
                    {
                        return new Command( CommandTypes.CommandType.BYE, null, null);
                    }
                    else
                    {
                        return new Command( CommandTypes.CommandType.UNKNOWN,null,null);
                    }
                }
            }
            return null;
        }
    }
}
