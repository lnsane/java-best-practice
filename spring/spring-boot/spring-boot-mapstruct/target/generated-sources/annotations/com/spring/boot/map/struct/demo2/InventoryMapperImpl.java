package com.spring.boot.map.struct.demo2;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T23:09:15+0800",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.7 (Azul Systems, Inc.)"
)
@Component
public class InventoryMapperImpl implements InventoryMapper {

    @Override
    public InventoryDTO doToDto(InventoryDO inventoryDO) {
        if ( inventoryDO == null ) {
            return null;
        }

        InventoryDTO inventoryDTO = new InventoryDTO();

        if ( isNotEmpty( inventoryDO.getInch() ) ) {
            inventoryDTO.setCentimeters( inventoryDO.getInch() );
        }

        return inventoryDTO;
    }
}
