package Week10.Command.src;
import java.util.Stack;

public class SmartRemote {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> commandHistory;
    private final int TOTAL_SLOTS = 7;

    public SmartRemote() {
        onCommands = new Command[TOTAL_SLOTS];
        offCommands = new Command[TOTAL_SLOTS];
        commandHistory = new Stack<>();

        Command noCommand = new NoCommand();
        for (int i = 0; i < TOTAL_SLOTS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot >= 0 && slot < TOTAL_SLOTS) {
            onCommands[slot] = onCommand;
            offCommands[slot] = offCommand;
            System.out.println("⚙️ Slot " + slot + " configured: " + onCommand.getDescription());
        }
    }

    public void pressOnButton(int slot) {
        if (slot >= 0 && slot < TOTAL_SLOTS) {
            System.out.println("\n🔘 Pressing ON button " + slot + "...");
            onCommands[slot].execute();
            commandHistory.push(onCommands[slot]);
        }
    }

    public void pressOffButton(int slot) {
        if (slot >= 0 && slot < TOTAL_SLOTS) {
            System.out.println("\n🔘 Pressing OFF button " + slot + "...");
            offCommands[slot].execute();
            commandHistory.push(offCommands[slot]);
        }
    }

    public void pressUndoButton() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            System.out.println("\n↩️ Undoing last command...");
            lastCommand.undo();
        } else {
            System.out.println("\n❌ No command to undo");
        }
    }

    public void showConfiguration() {
        System.out.println("\n📱 REMOTE CONFIGURATION:");
        System.out.println("=" + "=".repeat(40));
        for (int i = 0; i < TOTAL_SLOTS; i++) {
            System.out.println("Slot " + i + " ON : " + onCommands[i].getDescription());
            System.out.println("Slot " + i + " OFF: " + offCommands[i].getDescription());
            System.out.println("-".repeat(40));
        }
    }
}
