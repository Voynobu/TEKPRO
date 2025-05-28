package Week10.Command.src;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SMART HOME COMMAND PATTERN DEMO ===\n");

        // ========== SETUP DEVICES (RECEIVERS) ==========
        System.out.println(">>> SETTING UP SMART HOME DEVICES <<<");
        Light livingRoomLight = new Light("Living Room");
        Light bedroomLight = new Light("Bedroom");
        AirConditioner bedroomAC = new AirConditioner("Bedroom");
        MusicSystem livingRoomMusic = new MusicSystem("Living Room");

        System.out.println("🏠 Smart home devices initialized\n");

        // ========== CREATE COMMANDS ==========
        System.out.println(">>> CREATING COMMANDS <<<");
        // Living room commands
        Command livingLightOn = new LightOnCommand(livingRoomLight);
        Command livingLightOff = new LightOffCommand(livingRoomLight);
        Command livingLightDim = new LightDimCommand(livingRoomLight, 20);

        // Bedroom commands
        Command bedroomLightOn = new LightOnCommand(bedroomLight);
        Command bedroomLightOff = new LightOffCommand(bedroomLight);
        Command acOn = new ACOnCommand(bedroomAC);
        Command acOff = new ACOffCommand(bedroomAC);

        // Music commands
        Command playJazz = new MusicPlayCommand(livingRoomMusic, "Smooth Jazz Playlist");
        Command musicOff = new LightOffCommand(livingRoomLight); // Wrong assignment intentionally

        System.out.println("✅ Commands created\n");

        // ========== SETUP REMOTE CONTROL (INVOKER) ==========
        System.out.println(">>> CONFIGURING SMART REMOTE <<<");
        SmartRemote remote = new SmartRemote();

        // Configure remote slots
        remote.setCommand(0, livingLightOn, livingLightOff);
        remote.setCommand(1, bedroomLightOn, bedroomLightOff);
        remote.setCommand(2, acOn, acOff);
        remote.setCommand(3, playJazz, new NoCommand());
        remote.setCommand(4, livingLightDim, new NoCommand());

        // ========== CREATE MACRO COMMANDS ==========
        System.out.println("\n>>> CREATING MACRO COMMANDS <<<");
        List<Command> movieNightCommands = Arrays.asList(
                livingLightDim,
                new MusicPlayCommand(livingRoomMusic, "Movie Soundtrack"),
                acOn
        );
        Command movieNightMacro = new MacroCommand(movieNightCommands, "Movie Night Mode");

        List<Command> sleepModeCommands = Arrays.asList(
                new LightOffCommand(livingRoomLight),
                new LightOffCommand(bedroomLight),
                new ACOnCommand(bedroomAC)
        );
        Command sleepModeMacro = new MacroCommand(sleepModeCommands, "Sleep Mode");

        remote.setCommand(5, movieNightMacro, new NoCommand());
        remote.setCommand(6, sleepModeMacro, new NoCommand());

        remote.showConfiguration();

        // ========== TESTING REMOTE CONTROL ==========
        System.out.println("\n>>> TESTING REMOTE CONTROL <<<");

        // Basic commands
        remote.pressOnButton(0);  // Living room light on
        remote.pressOnButton(1);  // Bedroom light on
        remote.pressOnButton(2);  // AC on

        // Undo last command
        remote.pressUndoButton(); // Undo AC on

        // More commands
        remote.pressOnButton(3);  // Play music
        remote.pressOnButton(4);  // Dim living room light

        // Test macro commands
        remote.pressOnButton(5);  // Movie night macro
        remote.pressUndoButton(); // Undo movie night macro

        remote.pressOnButton(6);  // Sleep mode macro

        // Test no command
        remote.pressOffButton(3); // No off command for music

        System.out.println("\n=== DEMO COMPLETED ===");
    }
}