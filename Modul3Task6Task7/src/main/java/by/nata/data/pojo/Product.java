package by.nata.data.pojo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1446113961751144015L;

    @Id
    @GeneratedValue(generator = "hilo_generator")
    @GenericGenerator(name = "hilo_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "hilo_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "10"),
                    @Parameter(name = "optimizer", value = "hilo")
            })
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;

    public Product() {
    }

    public Product(Long productId, String name, String model) {
        this.productId = productId;
        this.name = name;
        this.model = model;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Product)) return false;
        Product product = (Product) object;
        return Objects.equals(getProductId(), product.getProductId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getModel(), product.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getName(), getModel());
    }
}
