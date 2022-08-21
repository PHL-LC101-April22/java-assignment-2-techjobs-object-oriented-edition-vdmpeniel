package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    int id;
    private static int nextId = 0;
    String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
    @Override
    public boolean equals(Object o) {
        return (this == o)? true
                :(o == null || !(o instanceof PositionType))? false
                :((PositionType) o).getId() == id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
