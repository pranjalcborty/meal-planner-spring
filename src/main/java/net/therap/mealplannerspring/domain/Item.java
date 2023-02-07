package net.therap.mealplannerspring.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", unique = true, nullable = false)
    private long id;

    @Column(name = "item_name")
    @Size(min = 1)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
