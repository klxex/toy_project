package com.hwan.yaksa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int count;
    private String image;


}
