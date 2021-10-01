package com.hwan.yaksa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item extends TimeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String image;
    private int count;
    private int price;

    @Builder
    public Item(String name, String description, String image, int count, int price, String image_dir) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.count = count;
        this.price = price;
        this.image_dir = image_dir;
    }

    private String image_dir;




}
