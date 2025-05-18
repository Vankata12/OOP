
package commands;

import database.Database;
import database.Table;
import datatypes.DataType;
import datatypes.DataTypeFactory;

import java.util.ArrayList;
import java.util.List;

public class InsertCommand implements Command {
    private Database db;

    public InsertCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Използване: insert <table> <val1> ... <valN>");
            return;
        }
        Table table = db.getTable(args[0]);
        if (table == null) {
            System.out.println("Няма такава таблица.");
            return;
        }

        List<DataType> row = new ArrayList<>();
        List<Class<? extends DataType>> types = table.getColumnTypes();

        for (int i = 0; i < types.size(); i++) {
            if (i + 1 >= args.length || args[i + 1].equals("NULL")) {
                row.add(null);
            } else {
                row.add(DataTypeFactory.create(types.get(i).getSimpleName(), args[i + 1]));
            }
        }
        table.addRow(row);
        System.out.println("Редът е добавен.");
    }
}
