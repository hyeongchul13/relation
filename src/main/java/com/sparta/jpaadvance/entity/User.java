package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true) // orphanRemoval로 삭제 가능
    private List<Food> foodList = new ArrayList<>();

    public void addFoodList(Food food) {
        this.foodList.add(food); // 외래 키 설정
        food.setUser(this);
    }
}