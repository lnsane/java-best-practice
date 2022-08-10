package com.spring.boot.map.struct.copy;

import com.spring.boot.map.struct.controller.Abs;
import com.spring.boot.map.struct.model.emuns.SexEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserParams extends Abs {
    private String userName;
    private Integer age;
    private Integer income;
    private SexEnums sexEnums;
}
