package com.example.demo.repository;

import com.example.demo.Utils.OrderJson;
import com.example.demo.model.Food;
import com.example.demo.model.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class OrderFoodModelRepositoryImpl implements OrderFoodModelRepositoryCustom {
    @PersistenceContext
    private EntityManager managerFactory;
    private OrderFoodRepository orderFoodRepository;

    public OrderFoodModelRepositoryImpl(EntityManager managerFactory, OrderFoodRepository orderFoodRepository) {
        this.managerFactory = managerFactory;
        this.orderFoodRepository = orderFoodRepository;
    }


    @Override
    public Order findByFoodId(int id) {
        EntityManager entityManager = managerFactory;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<Order> orderQueryRoot = query.from(Order.class);

        List<Predicate> filterPredicate = new ArrayList<>();
        filterPredicate.add(cb.equal(orderQueryRoot.get("food_id"), id));
        query.select(cb.construct(Order.class)).where(cb.and(filterPredicate.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList().get(0);
    }

    @Override
    public void addOrder(OrderJson order, Food menufoodModel) {
        Order orderfoodModel = new Order();
        orderfoodModel.setNumber(order.getNumber());
        orderfoodModel.setMenufoodModel(menufoodModel);
        orderFoodRepository.save(orderfoodModel);
    }


    @Override
    public void updateOrder(Order orderfoodModel) {
        Order ofm = null;
        Optional<Order> op = orderFoodRepository.findById(orderfoodModel.getId());
        if (op.isPresent())
            ofm = op.get();
        ofm.setMenufoodModel(orderfoodModel.getMenufoodModel());
        ofm.setNumber(orderfoodModel.getNumber());
        orderFoodRepository.save(ofm);
    }

}
