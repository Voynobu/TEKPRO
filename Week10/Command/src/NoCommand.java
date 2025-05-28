package Week10.Command.src;
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("❌ No command assigned to this button");
    }

    @Override
    public void undo() {
        System.out.println("❌ No command to undo");
    }

    @Override
    public String getDescription() {
        return "No Command";
    }
}