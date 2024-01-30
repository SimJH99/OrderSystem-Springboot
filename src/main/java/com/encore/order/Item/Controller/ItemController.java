package com.encore.order.Item.Controller;

import com.encore.order.Item.Dto.ItemListRes;
import com.encore.order.Item.Dto.ItemSaveReq;
import com.encore.order.Item.Service.ItemService;
import com.encore.order.Member.Dto.MemberSaveReq;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //상품 등록
    @PostMapping("/item/create")
    public String itemSave(@RequestBody ItemSaveReq itemSaveReq){
        itemService.save(itemSaveReq);
        return "save complete";
    }

    //상품 목록 조회
    @GetMapping("/item/list")
    public List<ItemListRes> itemList(){
        return itemService.itemList();
    }
}
