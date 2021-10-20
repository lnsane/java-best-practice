package com.test.netty.demo;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.CharsetUtil;

public class Out1 extends ChannelOutboundHandlerAdapter {
    private static final Log log = LogFactory.get();


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        log.info("out1");
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        String body = new String(req, "UTF-8");
        body = body + "123";
        ByteBuf resp = Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(Unpooled.copiedBuffer(body + "->MyChannelServerOutHandler", CharsetUtil.UTF_8), promise);
    }
}
