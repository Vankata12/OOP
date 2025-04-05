public interface IValue {
    String toString();
    DataType getType();
    boolean equals(Object obj);
    boolean isNull();
} 