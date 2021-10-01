package com.hwan.yaksa.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private String name;
    private String description;
    private String image;
    private int count;
    private int price;

    @Builder
    public ItemDTO(String name,String description,String image,int count,int price){
        this.name=name;
        this.description=description;
        this.image=image;
        this.count=count;
        this.price=price;
    }
}
