package com.spring.boot.map.struct.copy;

import com.spring.boot.map.struct.model.User;
import com.spring.boot.map.struct.model.UserDTO;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T23:09:14+0800",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.7 (Azul Systems, Inc.)"
)
@Component
public class UserCopyImpl implements UserCopy {

    @Override
    public UserDTO copy(User user, Integer integer) {
        if ( user == null && integer == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( user != null ) {
            userDTO.setAge( user.getAge() );
            userDTO.setUserName( user.getUserName() );
            userDTO.setIncome( user.getIncome() );
            userDTO.setSexEnums( getDefault( user.getSexEnums() ) );
        }
        userDTO.setUserAge( integer );

        return userDTO;
    }

    @Override
    public List<UserDTO> copy(List<User> user, Integer integer) {
        if ( user == null && integer == null ) {
            return null;
        }

        List<UserDTO> list = createVehicleDt2( user, integer, integer );

        return list;
    }

    @Override
    public List<UserDTO> copy2(List<User> user, Integer integer, Integer two) {
        if ( user == null && integer == null && two == null ) {
            return null;
        }

        List<UserDTO> list = createVehicleDt2( user, integer, two );

        return list;
    }
}
