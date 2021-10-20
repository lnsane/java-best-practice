package com.test.netty.demo;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.util.Arrays;

public class Out2 extends ChannelOutboundHandlerAdapter {
    private static final Log log = LogFactory.get();


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        String s = "1";
        char[] chars = s.toCharArray();
        String s1 = Arrays.toString(chars);
        log.info("out2");
        ChannelHandlerContext read = ctx.read();
        ByteBuf buffer = read.alloc().buffer();
        byte[] req2 = new byte[buffer.readableBytes()];
        String body2 = new String(req2, "UTF-8");
        ctx.writeAndFlush(msg, promise);
    }
}
