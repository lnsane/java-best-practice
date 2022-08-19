package com.spring.boot.map.struct.copy;

import com.spring.boot.map.struct.model.emuns.SexEnums;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@Mapper
public interface UserCopy2 {

    static UserCopy2 INSTANCE = Mappers.getMapper(UserCopy2.class);
//    @Mapping(target = "userAge",source = "age")
//    @Mapping(target = "userName",source = "userName",ignore = true)
//    @Mapping(target = "sexEnums", expression = "java(COMMENT_MAPPER.getDefault(user.getSexEnums()))")
//    UserDTO copy(User user);

    default SexEnums getDefault(){
        return SexEnums.MAN;
    }
}
