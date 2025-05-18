
package commands;

import database.Database;
import database.Table;
import datatypes.DataType;

public class PrintCommand implements Command {
    private Database db;

    public PrintCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Използване: print <table name>");
            return;
        }
        Table table = db.getTable(args[0]);
        if (table == null) {
            System.out.println("Таблицата не съществува.");
            return;
        }
        for (var row : table.getRows()) {
            for (DataType value : row) {
                System.out.print((value == null ? "NULL" : value.toString()) + "	");
            }
            System.out.println();
        }
    }
}
