package com.spring.boot.map.struct.copy;

import com.spring.boot.map.struct.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T23:09:15+0800",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.7 (Azul Systems, Inc.)"
)
@Component
public class FaceCopyImpl extends FaceCopy {

    @Override
    public User supdateUser(User user) {

        User user1 = new User();

        if ( user != null ) {
            user1.setAge( user.getAge() );
            user1.setIncome( user.getIncome() );
            user1.setSexEnums( user.getSexEnums() );
        }
        user1.setUserName( sdsa() );

        return user1;
    }
}
