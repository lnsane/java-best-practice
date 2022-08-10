package com.spring.boot.map.struct.copy;

import com.spring.boot.map.struct.Pg;
import com.spring.boot.map.struct.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public abstract class FaceCopy {
    UserCopy2 COMMENT_MAPPER = Mappers.getMapper(UserCopy2.class);

    @Autowired
    private Pg pg;

    @Mapping(target = "userName", expression = "java(sdsa())")
    public abstract User supdateUser(User user);

    public String sdsa(){
        return pg.pig();
    }
}