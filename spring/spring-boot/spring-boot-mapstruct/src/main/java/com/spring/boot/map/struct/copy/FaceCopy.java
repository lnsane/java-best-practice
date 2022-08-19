package com.spring.boot.map.struct.copy;

import com.spring.boot.map.struct.Pg;
import com.spring.boot.map.struct.demo2.BooleanStrategy;
import com.spring.boot.map.struct.model.User;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper( builder = @Builder( disableBuilder = true ),
        uses = {BooleanStrategy.class},
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public abstract class FaceCopy {

    @Autowired
    private Pg pg;

    @Mapping(target = "userName", expression = "java(sdsa())")
    public abstract User supdateUser(User user);

    public String sdsa(){
        return pg.pig();
    }

    public String pgs(Integer integer){
        System.out.println(integer);
        return "";
    }
}