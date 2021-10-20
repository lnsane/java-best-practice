package com.test.netty.echo;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.ByteBuffer;

public class EchoClient {
    private static final Log log = LogFactory.get();

    public static void main(String[] args) {
        String host = "localhost";
        int port = 80;
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ClientHandler());
                }
            });
            ChannelFuture f = b.connect(host, port).sync(); // (5)
            Channel channel = f.channel();
            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            String hello = "hello";
            writeBuffer.put(hello.getBytes());
            writeBuffer.flip();
            writeBuffer.rewind();

            // 转为ByteBuf
            ByteBuf buf = Unpooled.copiedBuffer(writeBuffer);

            // 写消息到管道
            channel.writeAndFlush(buf);
            // 清理缓冲区
            writeBuffer.clear();
            log.info("client start");
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
