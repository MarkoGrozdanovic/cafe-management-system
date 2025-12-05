package com.cafe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long menuItemID;
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    @NotBlank
    private int price;
    @NotBlank
    private boolean isAvailable;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    private Set<InventoryUsage> inventoryUsages = new HashSet<>();
}
