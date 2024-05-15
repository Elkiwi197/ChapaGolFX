package common;

import javafx.scene.control.SpinnerValueFactory;
import java.util.Set;

public class SpinnerValoresExcluidos extends SpinnerValueFactory.IntegerSpinnerValueFactory {
    private Set<Integer> dorsalesRepetidos;

    public SpinnerValoresExcluidos(int min, int max, int initialValue, Set<Integer> excludedValues) {
        super(min, max, initialValue);
        this.dorsalesRepetidos = excludedValues;
        this.setValue(initialValue); // Initialize with the initial value, ensuring it is not excluded
    }

    @Override
    public void decrement(int steps) {
        if (steps < 0) {
            increment(-steps);
            return;
        }
        int newValue = getValue();
        do {
            newValue -= 1;
            if (newValue < getMin()) {
                newValue = getMax();
            }
        } while (dorsalesRepetidos.contains(newValue));
        setValue(newValue);
    }

    @Override
    public void increment(int steps) {
        if (steps < 0) {
            decrement(-steps);
            return;
        }
        int newValue = getValue();
        do {
            newValue += 1;
            if (newValue > getMax()) {
                newValue = getMin();
            }
        } while (dorsalesRepetidos.contains(newValue));
        setValue(newValue);
    }
}
