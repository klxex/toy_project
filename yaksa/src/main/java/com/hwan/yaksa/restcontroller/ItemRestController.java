package com.hwan.yaksa.restcontroller;


import com.hwan.yaksa.domain.Item;
import com.hwan.yaksa.dto.ItemDTO;
import com.hwan.yaksa.service.ItemService;
import com.hwan.yaksa.service.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Map;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemRestController {
    private final ItemService itemService;

    @GetMapping("/items")
    public List<ItemDTO> searchItem(@RequestParam(value="query",required=false) String query){
        List<Item> items;
        List<ItemDTO> itemDTOs = new LinkedList<>();
        if(query==null){
            items=itemService.findAllItem();
        }
        else{
            items=itemService.searchItems(query);
        }

        for(Item item:items){
            ItemDTO itemDTO=ItemDTO.builder()
                    .name(item.getName())
                    .image(item.getImage())
                    .count(item.getCount())
                    .description(item.getDescription())
                    .price(item.getPrice())
                    .build();
            itemDTOs.add(itemDTO);
        }

        return itemDTOs;
    }

    @PostMapping("/items")
    public ItemDTO addItem(
            @RequestParam(value="name",required = false) String name,
            @RequestParam(value="description",required = false) String description,
            @RequestParam(value="image",required = false) String image,
            @RequestParam(value="count",required = false) int count,
            @RequestParam(value="price",required = false) int price){

        ItemDTO itemDTO=ItemDTO.builder()
                .name(name)
                .description(description)
                .image(image)
                .count(count)
                .price(price)
                .build();

        itemService.insertItem(itemDTO);
        return itemDTO;
    }


}
