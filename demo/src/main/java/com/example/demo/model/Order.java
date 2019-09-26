package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @Column(name = "number", nullable = false)
    private Integer number;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_id", nullable = false)
    private Food menufoodModel;

   /* @Basic
    @Column(name = "food_id",nullable = false)
    private int food_id;

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Food getMenufoodModel() {
        return menufoodModel;
    }

    public void setMenufoodModel(Food menufoodModel) {
        this.menufoodModel = menufoodModel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order that = (Order) o;
        return getId() == that.getId() &&
                Objects.equals(getNumber(), that.getNumber()) &&
                Objects.equals(getMenufoodModel(), that.getMenufoodModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getMenufoodModel());
    }
}
