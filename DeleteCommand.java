
package commands;

import database.Database;
import database.Table;

public class DeleteCommand implements Command {
    private Database db;

    public DeleteCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 3) {
            System.out.println("Използване: delete <table> <col#> <value>");
            return;
        }
        Table table = db.getTable(args[0]);
        int col = Integer.parseInt(args[1]);
        String val = args[2];
        table.getRows().removeIf(row -> row.get(col) != null && row.get(col).toString().equals(val));
        System.out.println("Изтрити съвпадащи редове.");
    }
}
