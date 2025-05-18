
package commands;

public class HelpCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Налични команди:");
        for (CommandName name : CommandName.values()) {
            System.out.println("- " + name.name().toLowerCase());
        }
    }
}
