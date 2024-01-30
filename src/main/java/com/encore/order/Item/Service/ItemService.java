package com.encore.order.Item.Service;

import com.encore.order.Item.Domain.Item;
import com.encore.order.Item.Dto.ItemListRes;
import com.encore.order.Item.Dto.ItemSaveReq;
import com.encore.order.Item.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    public void save(ItemSaveReq itemSaveReq) {
        Item item = Item.builder()
                .name(itemSaveReq.getName())
                .price(itemSaveReq.getPrice())
                .stockQuantity(itemSaveReq.getStockQuantity())
                .build();
        itemRepository.save(item);
    }

    public List<ItemListRes> itemList() {
        List<Item> items = itemRepository.findAll();
        List<ItemListRes> itemListRes = new ArrayList<>();
        for (Item i : items){
            ItemListRes listRes = ItemListRes.builder()
                    .name(i.getName())
                    .price(i.getPrice())
                    .stockQuantity(i.getStockQuantity())
                    .build();
            itemListRes.add(listRes);
        }
        return itemListRes;
    }
}
