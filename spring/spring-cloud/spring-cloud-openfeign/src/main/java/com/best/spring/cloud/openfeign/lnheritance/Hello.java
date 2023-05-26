package com.best.spring.cloud.openfeign.lnheritance;

import com.best.spring.cloud.openfeign.bean.Data;
import com.best.spring.cloud.openfeign.bean.User;
import com.best.spring.cloud.openfeign.bean.Username;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author lnsane
 */
public interface Hello {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    Data<List<User<Username>>> hello();

}
