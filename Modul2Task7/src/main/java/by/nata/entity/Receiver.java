package by.nata.entity;

import java.io.Serializable;
import java.util.Objects;

public class Receiver implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;

    public Receiver() {
    }

    public Receiver(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receiver)) return false;
        Receiver receiver = (Receiver) o;
        return getId() == receiver.getId() && Objects.equals(getName(), receiver.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}


