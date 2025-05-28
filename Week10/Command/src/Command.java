// Command interface - Kontrak untuk semua commands
package Week10.Command.src;

interface Command {
    void execute();
    void undo();
    String getDescription();
}
