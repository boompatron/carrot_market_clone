package com.carrot_market.repository;

import com.carrot_market.constant.ItemSellStatus;
import com.carrot_market.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("Item save Test")
    public void createItemTest(){
        Item item = new Item();
        item.setItemNm("test item");
        item.setItemDetail("test item detail");
        item.setPrice(15000);
        item.setStockNumber(100);
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setUpdateTime(LocalDateTime.now());
        item.setRegTime(LocalDateTime.now());
        Item savedItem = itemRepository.save(item);
        System.out.println(savedItem.toString());
    }

    public void createItemList(){
        for(int i = 1; i <= 10; i++){
            Item item = new Item();
            item.setItemNm("test item " + i);
            item.setItemDetail("test item detail " + i);
            item.setPrice(10000 + i * 1000);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            item.setStockNumber(100);
            Item saveItem = itemRepository.save(item);
        }
    }
    @Test
    @DisplayName("Item Name search Test")
    public void findByItemNmTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemNm("test item 1");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("Item Name and Detail search test")
    public void findByItemNmOrItemDetailTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("test item 1", "test item detail 1");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("less than test")
    public void findByPriceLessThanTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByPriceLessThan(14000);
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("less than + order test")
    public void findByPriceLessThanOrderByPriceDescTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(16000);
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }
}