package Week10.Command.src;
import java.util.ArrayList;
import java.util.List;


class MacroCommand implements Command {
    private List<Command> commands;
    private String description;

    public MacroCommand(List<Command> commands, String description) {
        this.commands = new ArrayList<>(commands);
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.println("🏠 Executing macro: " + description);
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        System.out.println("↩️ Undoing macro: " + description);
        // Undo in reverse order
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }

    @Override
    public String getDescription() {
        return "Macro: " + description;
    }
}
