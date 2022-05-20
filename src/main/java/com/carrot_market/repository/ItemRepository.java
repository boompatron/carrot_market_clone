package com.carrot_market.repository;

import com.carrot_market.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


// <Entity type class, Primary Key type>
public interface ItemRepository extends JpaRepository<Item, Long> {
    // find + (Entity name) + By + (Variable name)
    // List<Item> findByItemNm(String itemNm);
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
    List<Item> findByPriceLessThan(Integer price);
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    // JPQL query, from (Entity class name), and gonna select from Item
    // with @Param could transfer itemDetail variable
    // like %:(variable name)% -> @Param("variable name")
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemNm(@Param("itemDetail") String itemDetail);
}
