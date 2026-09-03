public class SortValue<T extends Comparable<T>> implements Comparable<SortValue<T>> {
    private T value;

    public SortValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getSize() {
        if (value instanceof Number) {
            return Math.max(1, ((Number) value).intValue());
        } else if (value instanceof String str) {
            if (str.isEmpty()) return 1;
            
            char firstChar = Character.toUpperCase(str.charAt(0));
            if (firstChar >= 'A' && firstChar <= 'Z') {
                return (firstChar - 'A') + 1;
            }
            return Math.max(1, str.length());
        } else if (value != null) {
            return Math.max(1, value.toString().length());
        }
        return 1;
    }

    @Override
    public int compareTo(SortValue<T> other) {
        return this.value.compareTo(other.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}