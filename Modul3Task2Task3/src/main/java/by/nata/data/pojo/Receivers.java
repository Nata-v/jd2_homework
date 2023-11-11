package by.nata.data.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

    @Entity
    @Table(name = "receivers")
    public class Receivers implements Serializable {
        private static final long serialVersionUID = -39974500559651337L;
        @Id

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        public Receivers() {
        }

        public Receivers(Long id, String name) {
            this.id = id;
            this.name = name;

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Receivers{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Receivers)) return false;
            Receivers receivers = (Receivers) o;
            return Objects.equals(getId(), receivers.getId()) && Objects.equals(getName(), receivers.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }



