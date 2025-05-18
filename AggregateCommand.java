
package commands;

import database.Database;
import database.Table;
import datatypes.DataType;

import java.util.ArrayList;
import java.util.List;

public class AggregateCommand implements Command {
    private Database db;

    public AggregateCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 5) {
            System.out.println("Използване: aggregate <table> <col#> <value> <targetCol> <operation>");
            return;
        }

        Table table = db.getTable(args[0]);
        int condCol = Integer.parseInt(args[1]);
        int targetCol = Integer.parseInt(args[3]);
        String op = args[4];
        List<Double> values = new ArrayList<>();

        for (var row : table.getRows()) {
            DataType cell = row.get(condCol);
            if (cell != null && cell.getValue() != null &&
                cell.getValue().toString().equals(args[2])) {
                DataType target = row.get(targetCol);
                if (target != null && target.getValue() instanceof Number) {
                    values.add(((Number) target.getValue()).doubleValue());
                }
            }
        }

        switch (op.toLowerCase()) {
            case "sum": System.out.println(values.stream().mapToDouble(d -> d).sum()); break;
            case "product": System.out.println(values.stream().reduce(1.0, (a, b) -> a * b)); break;
            case "maximum": System.out.println(values.stream().mapToDouble(d -> d).max().orElse(Double.NaN)); break;
            case "minimum": System.out.println(values.stream().mapToDouble(d -> d).min().orElse(Double.NaN)); break;
            default: System.out.println("Невалидна операция");
        }
    }
}
