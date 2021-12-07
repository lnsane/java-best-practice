package com.best.spring.boot.web;

import cn.hutool.core.util.RandomUtil;
import com.wf.captcha.base.Captcha;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class SpecCaptcha2 extends Captcha {

    public SpecCaptcha2() {
    }

    public SpecCaptcha2(int width, int height) {
        this();
        setWidth(width);
        setHeight(height);
    }

    public SpecCaptcha2(int width, int height, int len) {
        this(width, height);
        setLen(len);
    }


    @Override
    public boolean out(OutputStream os) {
        return graphicsImage(textChar(), os);
    }

    private boolean graphicsImage(char[] strs, OutputStream out) {
        try {
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bi.getGraphics();
            // 填充背景
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, width, height);
//             抗锯齿
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 画干扰圆

            // 画干扰线
            // 画字符串

            FontMetrics fontMetrics = g2d.getFontMetrics();
            int fW = width / strs.length;  // 每一个字符所占的宽度
            int fSp = (fW - (int) fontMetrics.getStringBounds("W", g2d).getWidth()) / 2;  // 字符的左右边距

            int t1 = 0;
            int t2 = 0;
            int t3 = 0;
            int t4 = 0;
//            List colorList = new List();
//            Color color = new Color(216,14,36);
//            Color color2 = new Color(71,148,126);
//            Color color3 = new Color(122,130,127);
//            Color[] colors = new Color[] {
//                    color,color2
//            };
            for (int i = 0; i < strs.length; i++) {
                int i1 = RandomUtil.randomInt(2, 5);
                if (i1 == 2) {
                    g2d.setFont(Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getResourceAsStream("/" + "actionj.ttf"))).deriveFont(Font.PLAIN, 25));
                } else if (i1 == 3) {
                    g2d.setFont(Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getResourceAsStream("/" + "actionj.ttf"))).deriveFont(Font.BOLD, 25));
                } else if (i1 == 4) {
                    g2d.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 25));
                }
                g2d.setColor(color());
                int fY = height - ((height - (int) fontMetrics.getStringBounds(String.valueOf(strs[i]), g2d).getHeight()) >> 1);
                if (i == 0) {
                    // 文字的纵坐标
                    t1 = fSp + RandomUtil.randomInt(0, 10);
                    g2d.drawString(String.valueOf(strs[i]), t1 + RandomUtil.randomInt(0, 10), fY);
                } else if (i == 1) {
                    t2 = t1 + RandomUtil.randomInt(2, 6) + fW - 5;
                    g2d.drawString(String.valueOf(strs[i]), t2, fY);
                } else if (i == 2) {
                    t3 = t2 + RandomUtil.randomInt(2, 6) + fW - 8;
                    g2d.drawString(String.valueOf(strs[i]), t3, fY);
                } else if (i == 3) {
                    t4 = t3 + RandomUtil.randomInt(2, 6) + fW - 10;
                    g2d.drawString(String.valueOf(strs[i]), t4, fY);
                }
            }
            g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            drawBesselLine(1, new Color(0, 0, 0), g2d);
            g2d.dispose();
            ImageIO.write(bi, "png", out);
            out.flush();
            return true;
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public String toBase64() {
        return toBase64("data:image/png;base64,");
    }
}
