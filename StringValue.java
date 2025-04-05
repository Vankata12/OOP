public class StringValue extends Value {
    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value != null ? value : "NULL";
    }

    @Override
    public DataType getType() {
        return DataType.STRING;
    }
    
    @Override
    public boolean isNull() {
        return value == null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof StringValue)) {
            return false;
        }
        StringValue other = (StringValue) obj;
        if (value == null) {
            return other.value == null;
        }
        return value.equals(other.value);
    }
} 