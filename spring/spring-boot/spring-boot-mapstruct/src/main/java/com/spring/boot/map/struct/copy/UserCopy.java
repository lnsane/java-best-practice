package com.spring.boot.map.struct.copy;

import com.spring.boot.map.struct.model.User;
import com.spring.boot.map.struct.model.UserDTO;
import com.spring.boot.map.struct.model.emuns.SexEnums;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@Mapper(componentModel = "spring")
public interface UserCopy {

    UserCopy2 COMMENT_MAPPER = Mappers.getMapper(UserCopy2.class);

    @Mapping(target = "userAge",source = "integer")
//    @Mapping(target = "userName",source = "userName",ignore = true)
//    @Mapping(target = "sexEnums", expression = "java(COMMENT_MAPPER.getDefault(user.getSexEnums()))")
    UserDTO copy(User user,Integer integer);
    List<UserDTO> copy(List<User> user, Integer integer);
    List<UserDTO> copy2(List<User> user, Integer integer,Integer two);
    default SexEnums getDefault(SexEnums sexEnums){
        return sexEnums;
    }

//    @ObjectFactory
//    default List<UserDTO> createVehicleDto(List<User> user, Integer integer) {
//        // your creation logic
//        List<UserDTO> userDTOS = new ArrayList<>();
//        return userDTOS;
//    }

    @ObjectFactory
    default List<UserDTO> createVehicleDt2(List<User> user, Integer integer,Integer two) {
        // your creation logic
        List<UserDTO> userDTOS = new ArrayList<>();
        return userDTOS;
    }
}
