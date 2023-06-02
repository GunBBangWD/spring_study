package com.blue.bluearchive.shop.repository;

import com.blue.bluearchive.shop.dto.ItemSearchDto;
import com.blue.bluearchive.shop.dto.MainItemDto;
import com.blue.bluearchive.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {
    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainitemPage(ItemSearchDto itemSearchDto,Pageable pageable);

//    @Query("SELECT i FROM Item i WHERE i.itemUseability = :itemUseability")
//    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, @Param("itemUseability") ItemUseability itemUseability, Pageable pageable);

}
