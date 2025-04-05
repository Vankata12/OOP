public class IntegerValue extends Value {
    private Integer value;

    public IntegerValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value != null ? value.toString() : "NULL";
    }

    @Override
    public DataType getType() {
        return DataType.INTEGER;
    }
    
    @Override
    public boolean isNull() {
        return value == null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IntegerValue)) {
            return false;
        }
        IntegerValue other = (IntegerValue) obj;
        if (value == null) {
            return other.value == null;
        }
        return value.equals(other.value);
    }
} 