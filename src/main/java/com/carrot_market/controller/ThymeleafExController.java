package com.carrot_market.controller;

import com.carrot_market.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafExController {
    @GetMapping(value = "/ex02")
    public String thymeleafExample02(Model model){
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("test item detail");
        itemDto.setItemNm("test item name");
        itemDto.setPrice(15000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeleafEx";
    }

    @GetMapping(value = "/ex03")
    public String thymeleafExample03(Model model){
        List<ItemDto> itemDtoList = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("test item detail" + i);
            itemDto.setItemNm("test item name"+ i);
            itemDto.setPrice(10000 + i * 1000);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx03";
    }

    @GetMapping(value = "/ex04")
    public String thymeleafExample04(Model model){
        List<ItemDto> itemDtoList = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("test item detail" + i);
            itemDto.setItemNm("test item name"+ i);
            itemDto.setPrice(10000 + i * 1000);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx04";
    }

    @GetMapping(value = "/ex05")
    public String thymeleafExample05(Model model){
        return "thymeleafEx/thymeleafEx05";
    }
}
