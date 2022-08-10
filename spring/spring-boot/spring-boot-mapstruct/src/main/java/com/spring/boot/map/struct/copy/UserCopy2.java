package com.spring.boot.map.struct.copy;

import com.spring.boot.map.struct.model.User;
import com.spring.boot.map.struct.model.UserDTO;
import com.spring.boot.map.struct.model.emuns.SexEnums;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@Mapper(componentModel = "spring")
public interface UserCopy2 {

    UserCopy2 COMMENT_MAPPER = Mappers.getMapper(UserCopy2.class);

    @Mapping(target = "userAge",source = "age")
//    @Mapping(target = "userName",source = "userName",ignore = true)
    @Mapping(target = "sexEnums", expression = "java(COMMENT_MAPPER.getDefault(user.getSexEnums()))")
    UserDTO copy(User user);

    default SexEnums getDefault(SexEnums sexEnums){
        return sexEnums;
    }
}
