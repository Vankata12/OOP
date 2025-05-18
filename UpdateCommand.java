
package commands;

import database.Database;
import database.Table;
import datatypes.DataTypeFactory;

public class UpdateCommand implements Command {
    private Database db;

    public UpdateCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 5) {
            System.out.println("Използване: update <table> <col#> <old> <col#> <new>");
            return;
        }
        Table table = db.getTable(args[0]);
        int c1 = Integer.parseInt(args[1]);
        int c2 = Integer.parseInt(args[3]);

        for (var row : table.getRows()) {
            if (row.get(c1) != null && row.get(c1).toString().equals(args[2])) {
                row.set(c2, DataTypeFactory.create(table.getColumnTypes().get(c2).getSimpleName(), args[4]));
            }
        }
        System.out.println("Редовете са обновени.");
    }
}
