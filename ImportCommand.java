
package commands;

import database.Database;
import database.FileHandler;
import database.Table;

import java.io.IOException;

public class ImportCommand implements Command {
    private Database db;

    public ImportCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Използване: import <file>");
            return;
        }
        try {
            Table t = FileHandler.importTable(args[0]);
            if (db.getTableNames().contains(t.getName())) {
                System.out.println("Грешка: Таблица вече съществува.");
                return;
            }
            db.addTable(t);
            FileHandler.saveDatabase(db);
            System.out.println("Таблицата е импортирана успешно.");
        } catch (IOException e) {
            System.out.println("Грешка при импортиране: " + e.getMessage());
        }
    }
}
