# spring boot 和 dubbo 以及 sentinel 限流demo

## 为什么要使用

在日常开发中使用dubbo来进行微服务之间的调用是非常常见的，而且高并发下，要保证服务的高可用， 那么必然要有限流和降级的策略工具 sentinel

## sentinel的基本使用

### 在 Windows 下

```shell

java -jar sentinel-dashboard-1.8.2.jar

```

### 在 linux 下

```shell
java -jar -Djava.net.preferIPv4Stack=true -Dcsp.sentinel.api.port=8719 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=dubbo-provider-demo -jar sentinel-dashboard-1.8.2.jar
```

### 客户端的使用

在VM Options

```shell
-Djava.net.preferIPv4Stack=true -Dcsp.sentinel.api.port=8719 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=comsumer-service
```

pom xml 上的使用

```xml
  <!-- Sentinel adapter and transport -->

<dependency>
    <groupId>com.alibaba.csp</groupId>
    <artifactId>sentinel-transport-simple-http</artifactId>
    <version>1.8.2</version>
</dependency>
<dependency>
<groupId>com.alibaba.csp</groupId>
<artifactId>sentinel-apache-dubbo-adapter</artifactId>
<version>1.8.2</version>
</dependency>
        <!-- https://mvnrepository.com/artifact/com.alibaba.csp/sentinel-parameter-flow-control -->
<dependency>
<groupId>com.alibaba.csp</groupId>
<artifactId>sentinel-parameter-flow-control</artifactId>
<version>1.8.2</version>
</dependency>
        <!-- https://mvnrepository.com/artifact/com.alibaba.csp/sentinel-annotation-aspectj -->
<dependency>
<groupId>com.alibaba.csp</groupId>
<artifactId>sentinel-annotation-aspectj</artifactId>
<version>1.8.2</version>
</dependency>
```