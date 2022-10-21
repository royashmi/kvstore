
public class Command {

    private CommandTypes.CommandType commandType;
    private String key;
    private String value;

    public Command( CommandTypes.CommandType commandType, String key, String value )
    {
        this.commandType = commandType;
        this.key = key;
        this.value = value;
    }

    public CommandTypes.CommandType getCommandType() {
        return commandType;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
