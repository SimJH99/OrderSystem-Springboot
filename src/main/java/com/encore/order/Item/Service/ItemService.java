package com.encore.order.Item.Service;

import com.encore.order.Item.Domain.Item;
import com.encore.order.Item.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findById(Long id){
        Item item = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return item;
    }
}
