package fix.test.task.model;

import java.util.Objects;

public class HorsePosition {
    private int number;
    private int letter;


    public HorsePosition(int number, int letter) {
        this.number = number;
        this.letter = letter;

    }

    public int getLetter() {
        return letter;
    }

    public void setLetter(int letter) {
        this.letter = letter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorsePosition position = (HorsePosition) o;
        return  number == position.number && letter == position.letter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, letter);
    }
}
