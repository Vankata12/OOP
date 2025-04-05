public class DoubleValue extends Value {
    private Double value;

    public DoubleValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value != null ? value.toString() : "NULL";
    }

    @Override
    public DataType getType() {
        return DataType.DOUBLE;
    }
    
    @Override
    public boolean isNull() {
        return value == null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DoubleValue)) {
            return false;
        }
        DoubleValue other = (DoubleValue) obj;
        if (value == null) {
            return other.value == null;
        }
        return value.equals(other.value);
    }
} 