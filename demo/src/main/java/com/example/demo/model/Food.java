package com.example.demo.model;


import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "food")
public class Food {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "price", nullable = false, length = 7)
    private int price;

    @Column(name = "type", nullable = false, length = 10)
    private int type;

    @Column(name = "create_time", nullable = false)
    private Instant create_time;

    public Food(String name, int price, int type, Instant timeSet) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.create_time = timeSet;
    }

    public Food() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Instant getTimeSet() {
        return create_time;
    }

    public void setTimeSet(Instant timeSet) {
        this.create_time = timeSet;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Food)) return false;
//        Food that = (Food) o;
//        return getId() == that.getId() &&
//                Objects.equals(getName(), that.getName()) &&
//                Objects.equals(getPrice(), that.getPrice()) &&
//                Objects.equals(getType(), that.getType()) &&
//                Objects.equals(getTimeSet(), that.getTimeSet()) &&
//                Objects.equals(getOrderfoodModel(), that.getOrderfoodModel());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getName(), getPrice(), getType(), getTimeSet(), getOrderfoodModel());
//    }
}
