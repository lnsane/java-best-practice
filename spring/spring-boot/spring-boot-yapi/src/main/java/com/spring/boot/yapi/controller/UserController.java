package com.spring.boot.yapi.controller;

import com.spring.boot.yapi.model.params.OrderParams;
import com.spring.boot.yapi.model.vo.OrderVO;
import org.springframework.web.bind.annotation.*;

/**
 * 订单接口sdsadasdasd
 * samkdjaskd
 * asjdhkajshdk
 * asjdhaskjdh
 * asjfhkashf
 */
@RestController
public class UserController {


    /**
     * 获取订单接口asdasd
     * <p>asdkjahsd</p>
     * dfhdskjhg
     * asdjkashfkdsjaf
     * @folder Mock字符串
     * @open
     * @undone
     * @param id 订单id
     * @mock sahdjakshd
     * @param ids 订单2
     * @mock ashdajkshdaaaaaa
     * @return 返回订单相应参数
     */
    @GetMapping(value = "paths")
    public OrderVO hellos(@RequestParam(value = "id",defaultValue = "1111") String id,@RequestParam("ids") String ids){
        return OrderVO.builder().build();
    }

    /**
     * 保存订单asdasd
     * @param orderParams 保存订单参数
     */
    @PostMapping("saves")
    public void save(@RequestBody OrderParams orderParams) {
    }
}
