# 一个spring boot skywalking 的快速demo

### 简单使用的步骤

VM options

```shell
-javaagent:${path}/apache-skywalking-apm-bin-es7/agent/skywalking-agent.jar
```

Environment variables

```shell
SW_AGENT_NAME=demo
SW_AGENT_COLLECTOR_BACKEND_SERVICES=127.0.0.1:11800
```