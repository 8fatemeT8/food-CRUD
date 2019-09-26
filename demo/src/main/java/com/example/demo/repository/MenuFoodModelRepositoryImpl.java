package com.example.demo.repository;

import com.example.demo.Utils.FoodSearchJson;
import com.example.demo.model.Food;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class MenuFoodModelRepositoryImpl implements FoodModelRepositoryCustom {
    @PersistenceContext
    private EntityManager managerFactory;
    private FoodRepository menuFoodRepository;

    public MenuFoodModelRepositoryImpl(EntityManager managerFactory, FoodRepository menuFoodRepository) {
        this.managerFactory = managerFactory;
        this.menuFoodRepository = menuFoodRepository;
    }

    public List<Food> searchByContainNameAndPrice(FoodSearchJson foodSearchJson) {
        EntityManager entityManager = managerFactory;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Food> query = cb.createQuery(Food.class);
        Root<Food> menuQueryRoot = query.from(Food.class);
        List<Predicate> predicateList = new ArrayList<>();
        if (foodSearchJson.getType() != 0)
            predicateList.add(cb.equal(menuQueryRoot.get("type"), foodSearchJson.getType()));
        if (foodSearchJson.getName() != null)
            predicateList.add(cb.like(cb.lower(menuQueryRoot.get("name")), "%" + foodSearchJson.getName().toLowerCase() + "%"));
        if (foodSearchJson.getToPrice() != 0 && foodSearchJson.getFromPrice() != 0)
            predicateList.add(cb.between(menuQueryRoot.get("price"), foodSearchJson.getFromPrice(), foodSearchJson.getToPrice()));
        else if (foodSearchJson.getToPrice() != 0)
            predicateList.add(cb.lessThanOrEqualTo(menuQueryRoot.get("price"), foodSearchJson.getToPrice()));
        else if (foodSearchJson.getFromPrice() != 0)
            predicateList.add(cb.greaterThanOrEqualTo(menuQueryRoot.get("price"), foodSearchJson.getFromPrice()));
        if (foodSearchJson.getToDate() != null && foodSearchJson.getFromDate() != null) {
            predicateList.add(cb.between(menuQueryRoot.get("create_time"), foodSearchJson.getFromDate(), foodSearchJson.getToDate()));
        } else if (foodSearchJson.getFromDate() != null) {
            predicateList.add(cb.greaterThanOrEqualTo(menuQueryRoot.get("create_time"), foodSearchJson.getFromDate()));
        } else if (foodSearchJson.getToDate() != null) {
            predicateList.add(cb.lessThanOrEqualTo(menuQueryRoot.get("create_time"), foodSearchJson.getToDate()));
        }
        query.select(menuQueryRoot);
        if (predicateList.size() != 0)
            query.where(cb.and(predicateList.toArray(new Predicate[predicateList.size()])));
        TypedQuery<Food> typedQuery = entityManager.createQuery(query);
        if (foodSearchJson.getPage() != 0)
            typedQuery.setFirstResult(foodSearchJson.getPage()).setMaxResults(foodSearchJson.getPage() + 3);
        return typedQuery.getResultList();
    }


    @Override
    public List<Food> findByName(String name) {
        EntityManager entityManager = managerFactory;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(Food.class);
        Root<Food> menuFoodRoot = query.from(Food.class);
        return entityManager.createQuery(query.select(menuFoodRoot).where(cb.like(menuFoodRoot.get("name"), name))).getResultList();
    }
}
