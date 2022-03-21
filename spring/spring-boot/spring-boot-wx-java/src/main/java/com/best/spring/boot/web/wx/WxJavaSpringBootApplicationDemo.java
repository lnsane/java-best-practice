package com.best.spring.boot.web.wx;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.impl.WxMpOAuth2ServiceImpl;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.api.impl.WxOpenInMemoryConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenOAuth2ServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class WxJavaSpringBootApplicationDemo {

    public static void main(String[] args) {
        SpringApplication.run(WxJavaSpringBootApplicationDemo.class,args);
    }
    @PostConstruct
    public void test() throws WxErrorException {
        WxOpenOAuth2ServiceImpl service = new WxOpenOAuth2ServiceImpl("wxa851660f7209fdd4", "4dc3a041f100e222116cd6d4e8503d3b");
        service.setWxOpenConfigStorage(new WxOpenInMemoryConfigStorage());
        WxOAuth2AccessToken accessToken = service.getAccessToken("051UqIkl2NXqm84uBHol23lTwX1UqIkG");
        WxOAuth2UserInfo userInfo = service.getUserInfo(accessToken, null);
        log.info("{}",userInfo);
//        WxOpenServiceDemo  wxOAuth2AccessToken = new WxOpenServiceDemo("wxa851660f7209fdd4","4dc3a041f100e222116cd6d4e8503d3b");
//        WxOAuth2AccessToken accessToken = wxOAuth2AccessToken.getAccessToken("031ncf000BvG1N1EeY000RfntJ0ncf0x");
//        WxOAuth2AccessToken wxOAuth2AccessToken = wxOpenServiceDemo.getWxOpenComponentService().oauth2getAccessToken("wxa851660f7209fdd4", "031ncf000BvG1N1EeY000RfntJ0ncf0x");
    }
}
