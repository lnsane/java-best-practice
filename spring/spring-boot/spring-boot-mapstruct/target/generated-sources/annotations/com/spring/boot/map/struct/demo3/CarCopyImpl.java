package com.spring.boot.map.struct.demo3;

import com.spring.boot.map.struct.MoneyUtils;
import java.time.format.DateTimeFormatter;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T23:09:15+0800",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.7 (Azul Systems, Inc.)"
)
@Component
public class CarCopyImpl implements CarCopy {

    @Autowired
    private MoneyUtils moneyUtils;
    private final DateTimeFormatter dateTimeFormatter_HH_mm_ss_02126457984 = DateTimeFormatter.ofPattern( "HH:mm:ss" );
    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    @Override
    public CarDto copy(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setMoney( moneyUtils.convent( car.getMoney() ) );
        carDto.setName( car.getName() );
        if ( car.getLocalDateTime() != null ) {
            carDto.setCreateTime( dateTimeFormatter_HH_mm_ss_02126457984.format( car.getLocalDateTime() ) );
        }
        if ( car.getLocalDate() != null ) {
            carDto.setCreateDateTime( dateTimeFormatter_yyyy_MM_dd_0159776256.format( car.getLocalDate() ) );
        }

        return carDto;
    }
}
