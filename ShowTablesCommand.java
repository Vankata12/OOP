
package commands;

import database.Database;

public class ShowTablesCommand implements Command {
    private Database db;

    public ShowTablesCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Таблици в базата данни:");
        for (String name : db.getTableNames()) {
            System.out.println("- " + name);
        }
    }
}
