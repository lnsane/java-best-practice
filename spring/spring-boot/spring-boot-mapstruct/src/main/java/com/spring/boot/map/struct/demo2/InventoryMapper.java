package com.spring.boot.map.struct.demo2;

import com.spring.boot.map.struct.copy.FaceCopy;
import com.spring.boot.map.struct.model.User;
import org.mapstruct.Condition;
import org.mapstruct.Context;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Locale;

@Mapper(componentModel = "spring")
//        uses = {BooleanStrategy.class},
//        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
//        typeConversionPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(FaceCopy.class)
public interface InventoryMapper {
    FaceCopy INSTANCE = Mappers.getMapper( FaceCopy.class );
    /**
     * DO 转 DTO
     *
     * @param inventoryDO
     * @return
     */
    @Mappings({
            @Mapping(target = "centimeters", source = "inch",qualifiedByName= {"EnglishToGerman"}),
            @Mapping(target = ".", source = "hello")
    })
    InventoryDTO doToDto(InventoryDO inventoryDO, @Context Locale locale);

    default InventoryDTO translateInventoryDO(InventoryDO inventoryDO, @Context Locale locale) {
        // manually implemented logic to translate the OwnerManual with the given Locale
        System.out.println(locale);
        return new InventoryDTO();
    }
    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
