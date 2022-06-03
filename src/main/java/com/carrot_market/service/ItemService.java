package com.carrot_market.service;

import com.carrot_market.dto.ItemFormDto;
import com.carrot_market.entity.Item;
import com.carrot_market.entity.ItemImg;
import com.carrot_market.repository.ItemImgRepository;
import com.carrot_market.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemImgService itemImgService;
    private final ItemImgRepository itemImgRepository;

    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception{
        // register item
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        // register img
        for(int i = 0; i < itemImgFileList.size(); i++){
            ItemImg  itemImg = new ItemImg();
            itemImg.setItem(item);
            if(i == 0)
                itemImg.setRepimgYn("Y");
            else
                itemImg.setRepimgYn("N");
            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
        }

        return item.getId();
    }

}
