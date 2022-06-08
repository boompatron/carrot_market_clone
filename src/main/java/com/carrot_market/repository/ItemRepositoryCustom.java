package com.carrot_market.repository;

import com.carrot_market.dto.ItemSearchDto;
import com.carrot_market.dto.MainItemDto;
import com.carrot_market.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {
    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
