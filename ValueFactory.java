public class ValueFactory {
    public static IValue createValue(DataType type, String valueStr) {
        if (valueStr == null || valueStr.equals("NULL")) {
            return createNullValue(type);
        }
        
        switch (type) {
            case INTEGER:
                try {
                    return new IntegerValue(Integer.parseInt(valueStr));
                } catch (NumberFormatException e) {
                    System.err.println("Невалидна стойност за цяло число: " + valueStr);
                    return new IntegerValue(null);
                }
            case DOUBLE:
                try {
                    return new DoubleValue(Double.parseDouble(valueStr));
                } catch (NumberFormatException e) {
                    System.err.println("Невалидна стойност за дробно число: " + valueStr);
                    return new DoubleValue(null);
                }
            case STRING:
                // Ако низът е в кавички, премахваме ги
                if (valueStr.startsWith("\"") && valueStr.endsWith("\"")) {
                    valueStr = valueStr.substring(1, valueStr.length() - 1);
                }
                return new StringValue(valueStr);
        }
        
        return null;
    }
    
    public static IValue createNullValue(DataType type) {
        switch (type) {
            case INTEGER:
                return new IntegerValue(null);
            case DOUBLE:
                return new DoubleValue(null);
            case STRING:
                return new StringValue(null);
        }
        return null;
    }
} 