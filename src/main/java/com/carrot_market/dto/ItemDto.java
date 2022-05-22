package com.carrot_market.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
// You shouldn't return entity class itself
// so you need to Data Transfer Object 'DTO' class
// cause you dont need to reveal the structure of the DB
// and request's and response's object is not always identical with Entity Object
// When transfering data, you need to generate Dto classes
public class ItemDto {
    private Long id;
    private String itemNm;
    private Integer price;
    private String itemDetail;
    private String sellStatcCd;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;
}
