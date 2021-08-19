FROM adoptopenjdk:11-jre-hotspot
WORKDIR application
COPY ./target/spring-boot-prometheus-1.0-SNAPSHOT.jar application.jar
# JVM_XMS and JVM_XMX configs deprecated for removal in halov1.4.4
ENV JVM_XMS="256m" \
    JVM_XMX="256m" \
    JVM_OPTS="-Xmx256m -Xms256m" \
    TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime \
    && echo $TZ > /etc/timezone

ENTRYPOINT java -Xms${JVM_XMS} -Xmx${JVM_XMX} -jar /application/application.jar

################################

#FROM adoptopenjdk:11-jre-hotspot
#MAINTAINER johnniang <johnniang@fastmail.com>
#WORKDIR application
#
#
## JVM_XMS and JVM_XMX configs deprecated for removal in halov1.4.4
#ENV JVM_XMS="256m" \
#    JVM_XMX="256m" \
#    JVM_OPTS="-Xmx256m -Xms256m" \
#    TZ=Asia/Shanghai
#
#RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime \
#    && echo $TZ > /etc/timezone
#
#ENTRYPOINT java -Xms${JVM_XMS} -Xmx${JVM_XMX} ${JVM_OPTS} -Djava.security.egd=file:/dev/./urandom org.springframework.boot.loader.JarLauncher