package commands;

import commands.request.CommandRequest;
import commands.request.RequestType;
import managers.commandManager.CommandManager;

import java.util.Map;

public class HelpCommand extends Command{

    public HelpCommand() {
        setTarget("help");
        setDescription("help : вывести справку по доступным командам");
    }

    @Override
    public CommandRequest execute(CommandManager commandManager, String arguments) {
        for (Map.Entry<String, Command> command : commandManager.getCommands().entrySet()) {
            System.out.println(command.getValue().getDescription());
        }

        CommandRequest commandRequest = new CommandRequest();
        commandRequest.setRequestType(RequestType.INTERNAL);
        return commandRequest;
    }
}
