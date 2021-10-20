# 一个spring cloud nacos 的快速demo

在 nacos 2.2.6版本 因为ribbon 的httpclient的版本低引发的错误

解决方法
https://blog.csdn.net/weixin_44415928/article/details/114817994

```xml

<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5</version>
</dependency>
```