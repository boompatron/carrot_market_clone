package com.carrot_market.dto;

import com.carrot_market.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import com.carrot_market.entity.Item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ItemFormDto {
    private Long id;

    @NotBlank(message = "Item Name is necessary")
    private String itemNm;

    @NotNull(message = "price is necessary")
    private Integer price;

    @NotBlank(message = "Name is necessary")
    private String itemDetail;

    @NotNull(message = "stock is necessary")
    private Integer stockNumber;

    private ItemSellStatus itemSellStatus;
    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();
    private List<Long> itemImgIds = new ArrayList<>();
    private static ModelMapper modelMapper = new ModelMapper();

    public Item createItem(){
        return modelMapper.map(this, Item.class);
    }
    public static ItemFormDto of(Item item){
        return modelMapper.map(item, ItemFormDto.class);
    }
}
