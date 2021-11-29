package com.best.spring.boot.mq.aop.t.service.lmpl;

import com.best.spring.boot.mq.aop.t.model.Order;
import com.best.spring.boot.mq.aop.t.service.Azom;
import com.best.spring.boot.mq.aop.t.service.DownloadService;
import com.best.spring.boot.mq.aop.t.service.PutService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lnsane
 */
@Service
public class AzomImpl implements Azom {
    @Autowired
    private PutService putService;
    @Autowired
    private DownloadService downloadService;
    /**
     * 1 -> 未上架  2 - > 调用上传亚马逊创建文档完毕
     * 3 -> 上传完毕 4 -> 调用下载亚马逊报告摘要完毕
     * 5 -> 上架成功 6 - > 异常
     */
    @Override
    public void put(Order order, Channel channel, Message message) {

        if (order.getState().equals(1)) {
            putService.putOne(order, channel, message);
            putService.putTwo(order, channel, message);
        } else if (order.getState().equals(2)) {
            putService.putTwo(order, channel, message);
        }
    }

    @Override
    public void download(Order order, Channel channel, Message message) {
        if (order.getState().equals(3)) {
            downloadService.downloadOne(order, channel, message);
            downloadService.downloadTwo(order, channel, message);
        } else if (order.getState().equals(4)) {
            downloadService.downloadTwo(order, channel, message);
        }
    }
}
