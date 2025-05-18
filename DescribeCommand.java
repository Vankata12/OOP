
package commands;

import database.Database;
import database.Table;

public class DescribeCommand implements Command {
    private Database db;

    public DescribeCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Използване: describe <table name>");
            return;
        }
        Table table = db.getTable(args[0]);
        if (table == null) {
            System.out.println("Таблицата не съществува.");
            return;
        }
        for (int i = 0; i < table.getColumnNames().size(); i++) {
            System.out.println("- " + table.getColumnNames().get(i) + " (" + table.getColumnTypes().get(i).getSimpleName() + ")");
        }
    }
}
