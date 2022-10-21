
public class CommandTypes {

    public enum CommandType{
        GET("get"), PUT("put"), DEL("del"), BYE("bye"), UNKNOWN("unknown");

        private String commandName;
        private CommandType(String commandName) {
            this.commandName = commandName;
        }

        @Override
        public String toString(){
            return commandName;
        }
    }
}
