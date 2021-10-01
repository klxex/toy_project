package com.hwan.yaksa.service;

import com.hwan.yaksa.domain.Item;
import com.hwan.yaksa.dto.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemService {
    public List<Item> searchItems(String keywords);
    public void insertItem(ItemDTO itemDTO);
    public List<Item> findAllItem();
}
