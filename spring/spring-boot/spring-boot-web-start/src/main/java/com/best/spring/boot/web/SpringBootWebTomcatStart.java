package com.best.spring.boot.web;

import cn.hutool.core.io.FileUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.testng.annotations.Test;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootWebTomcatStart {

    @Autowired
    private TopServiceImpl2 TopServiceImpl2;

    @Value("${project.version:}")
    private String value;
    @Value("${server.port}")
    public static void main(String[] args) {
//        SpringApplication.run(SpringBootWebTomcatStart.class, args);
        new SpringApplicationBuilder()
                .sources(SpringBootWebTomcatStart.class)
                .run(args);
    }

    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            Base64.Encoder encoder = Base64.getEncoder();
            imageString = encoder.encodeToString(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    @Autowired
    private Tb tb;
    @PostConstruct
    public void testss(){
        TopService build = TopServiceImpl2.build("12");
        build.change();
        System.out.println(tb.getS());

        System.out.println(value);
    }



    @Test
    public void code() throws IOException {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
//验证码的属性
        Properties properties = new Properties();
//边框
        properties.put("kaptcha.border", "yes");
//边框为绿色
//            properties.put("kaptcha.border.color", "green");
//图片宽度
        properties.put("kaptcha.image.width", "94");
//高度
        properties.put("kaptcha.image.height", "26");
//字符数量
        properties.put("kaptcha.textproducer.char.length", "4");
//字体大小
        properties.put("kaptcha.textproducer.font.size", "30");
//字符间隔
        properties.put("kaptcha.textproducer.char.space", "1");
//噪声颜色
        properties.put("kaptcha.noise.color", "black");
//粘贴到浏览器，可以查看浏览器中的显示效果
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        String codeText = defaultKaptcha.createText();
        System.out.println(codeText);
        BufferedImage bi = defaultKaptcha.createImage(codeText);
        String png = encodeToString(bi, "png");
        System.out.println(png);
    }

    @Test
    public void code2() throws IOException, FontFormatException {
//        for (int i = 0; i < 3000000; i++) {
//            SpecCaptcha2 specCaptcha = new SpecCaptcha2(91, 30, 4);
//            if (!FileUtil.exist("D:\\ptyhon\\images\\" + specCaptcha.text().toString() + ".png")) {
//                FileOutputStream outputStream = new FileOutputStream(new File("D:\\ptyhon\\images\\" + specCaptcha.text().toString() + ".png"));
//                specCaptcha.out(outputStream);
//            }
//        }
        for (int i = 0; i < 130000; i++) {
            SpecCaptcha2 specCaptcha = new SpecCaptcha2(91, 30, 4);
            if (!FileUtil.exist("D:\\ptyhon\\images\\" + specCaptcha.text() + ".png")) {
                FileOutputStream outputStream = new FileOutputStream(new File("D:\\ptyhon\\testImages\\" + specCaptcha.text() + ".png"));
                specCaptcha.out(outputStream);
            }
        }
    }
}

