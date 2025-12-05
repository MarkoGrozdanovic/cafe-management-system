package com.cafe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inventoryID;
    private String itemName;
    private int quantity;
    private  String unit;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private Set<InventoryUsage> inventoryUsages = new HashSet<>();
}
