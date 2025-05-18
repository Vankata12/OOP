
package commands;

import database.Database;
import database.Table;

public class CountCommand implements Command {
    private Database db;

    public CountCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 3) {
            System.out.println("Използване: count <table> <col#> <value>");
            return;
        }
        Table table = db.getTable(args[0]);
        int col = Integer.parseInt(args[1]);
        long count = table.getRows().stream()
            .filter(row -> {
                if (args[2].equals("NULL")) {
                    return row.get(col) == null;
                } else {
                    return row.get(col) != null && row.get(col).toString().equals(args[2]);
                }
            }).count();
        System.out.println("Брой: " + count);
    }
}
