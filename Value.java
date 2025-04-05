public abstract class Value implements IValue {
    @Override
    public abstract String toString();
    
    @Override
    public abstract DataType getType();
    
    @Override
    public abstract boolean equals(Object obj);
    
    @Override
    public abstract boolean isNull();
} 