import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Number {
    private int value;
    private List<Coordinates> coordinates;

    public Number(int value) {
        this.value = value;
        this.coordinates = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public void setCoordinates(int start, int end, int row) {
        for (int i = start; i <= end; i++) {
            coordinates.add(new Coordinates(i,row));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value && Objects.equals(coordinates, number.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, coordinates);
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                ", coordinates=" + coordinates +
                '}';
    }
}
