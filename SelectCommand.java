
package commands;

import database.Database;
import database.Table;
import datatypes.DataType;

import java.util.List;
import java.util.Scanner;

public class SelectCommand implements Command {
    private final Database db;
    private static final int PAGE_SIZE = 10;

    public SelectCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 3) {
            System.out.println("Използване: select <column#> <value> <table>");
            return;
        }

        int col = Integer.parseInt(args[0]);
        String val = args[1];
        Table table = db.getTable(args[2]);
        List<List<DataType>> rows = table.getRows().stream()
            .filter(r -> r.get(col) != null && r.get(col).toString().equals(val))
            .toList();

        if (rows.isEmpty()) {
            System.out.println("Няма намерени редове.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int page = 0;
        while (true) {
            int start = page * PAGE_SIZE;
            int end = Math.min(start + PAGE_SIZE, rows.size());
            System.out.println("-- Страница " + (page + 1) + " --");
            for (int i = start; i < end; i++) {
                List<DataType> row = rows.get(i);
                for (DataType d : row) {
                    System.out.print((d == null ? "NULL" : d.toString()) + "\t");
                }
                System.out.println();
            }
            System.out.println("[next] [prev] [exit]");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("next") && end < rows.size()) page++;
            else if (input.equals("prev") && page > 0) page--;
            else if (input.equals("exit")) break;
        }
    }
}
