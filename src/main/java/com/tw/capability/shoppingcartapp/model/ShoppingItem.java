package com.tw.capability.shoppingcartapp.model;

import lombok.*;

import javax.persistence.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "shoppingitem")
public class ShoppingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;

}
