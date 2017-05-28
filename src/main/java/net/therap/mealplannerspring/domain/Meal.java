package net.therap.mealplannerspring.domain;

import net.therap.mealplannerspring.enums.Day;
import net.therap.mealplannerspring.enums.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "meal_item",
            joinColumns = {@JoinColumn(name = "meal_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<Item> items;

    @Enumerated(EnumType.STRING)
    @Column
    private Day day;

    @Enumerated(EnumType.STRING)
    @Column
    private Type type;

    public Meal() {
        this.items = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
