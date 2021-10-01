package com.hwan.yaksa.service;

import com.hwan.yaksa.domain.Item;
import com.hwan.yaksa.dto.ItemDTO;
import com.hwan.yaksa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public List<Item> searchItems(String keywords){
        itemRepository.findByNameContaining(keywords);
        return null;
    }

    public void insertItem(ItemDTO itemDTO){
        Item item = Item.builder()
                .name(itemDTO.getName())
                .image(itemDTO.getImage())
                .price(itemDTO.getPrice())
                .count(itemDTO.getCount())
                .description(itemDTO.getDescription())
                .build();

        itemRepository.save(item);
    }

    public List<Item> findAllItem(){
        return itemRepository.findAll();
    }

}
