# Spring Cloud Alibaba 系列教程 (Java宇宙最详细）

![](https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/fd2e763fae4440dabaed113a1c16da44~tplv-k3u1fbpfcp-watermark.image)

> 白菜Java自习室 涵盖核心知识

> [Spring Cloud Alibaba 实战（一）准备篇](https://juejin.cn/post/6926390930790580237)<br>
> [Spring Cloud Alibaba 实战（二）Nacos篇](https://juejin.cn/post/6926437744671457294)<br>
> [Spring Cloud Alibaba 实战（三）Sentinel篇](https://juejin.cn/post/6926797306431799304)<br>
> [Spring Cloud Alibaba 实战（四）Oauth2篇](https://juejin.cn/post/6927169846836723725)<br>
> [Spring Cloud Alibaba 实战（五）Zuul篇](https://juejin.cn/post/6930531222074425357)<br>
> [Spring Cloud Alibaba 实战（六）RocketMQ篇](https://juejin.cn/post/6930869079217717256)<br>
> [Spring Cloud Alibaba 实战（七）Seata篇](https://juejin.cn/post/6931274851894345735)<br>

> 项目 GitHub 地址：[https://github.com/D2C-Cai/herring](https://github.com/D2C-Cai/herring)<br>

# 1. Spring Cloud Alibaba 简介

> Spring Cloud Alibaba 致力于提供微服务开发的一站式解决方案。此项目包含开发分布式应用微服务的必需组件，方便开发者通过 Spring Cloud 编程模型轻松使用这些组件来开发分布式应用服务。

依托 Spring Cloud Alibaba，您只需要添加一些注解和少量配置，就可以将 Spring Cloud 应用接入阿里微服务解决方案，通过阿里中间件来迅速搭建分布式应用系统。

## 1.1. 主要功能

* **服务限流降级**：默认支持 WebServlet、WebFlux, OpenFeign、RestTemplate、Spring Cloud Gateway, Zuul, Dubbo 和 RocketMQ 限流降级功能的接入，可以在运行时通过控制台实时修改限流降级规则，还支持查看限流降级 Metrics 监控。
* **服务注册与发现**：适配 Spring Cloud 服务注册与发现标准，默认集成了 Ribbon 的支持。
* **分布式配置管理**：支持分布式系统中的外部化配置，配置更改时自动刷新。
* **消息驱动能力**：基于 Spring Cloud Stream 为微服务应用构建消息驱动能力。
* **分布式事务**：使用 @GlobalTransactional 注解， 高效并且对业务零侵入地解决分布式事务问题。
* **阿里云对象存储**：阿里云提供的海量、安全、低成本、高可靠的云存储服务。支持在任何应用、任何时间、任何地点存储和访问任意类型的数据。
* **分布式任务调度**：提供秒级、精准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。同时提供分布式的任务执行模型，如网格任务。网格任务支持海量子任务均匀分配到所有 Worker（schedulerx-client）上执行。
* **阿里云短信服务**：覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速搭建客户触达通道。

## 1.2. 主要组件

* **Sentinel**：把流量作为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。
* **Nacos**：一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。
* **RocketMQ**：一款开源的分布式消息系统，基于高可用分布式集群技术，提供低延时的、高可靠的消息发布与订阅服务。
* **Dubbo**：Apache Dubbo™ 是一款高性能 Java RPC 框架。
* **Seata**：阿里巴巴开源产品，一个易于使用的高性能微服务分布式事务解决方案。
* **Alibaba Cloud OSS**: 阿里云对象存储服务（Object Storage Service，简称 OSS），是阿里云提供的海量、安全、低成本、高可靠的云存储服务。您可以在任何应用、任何时间、任何地点存储和访问任意类型的数据。
* **Alibaba Cloud SchedulerX**: 阿里中间件团队开发的一款分布式任务调度产品，提供秒级、精准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。
* **Alibaba Cloud SMS**: 覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速搭建客户触达通道。

## 1.3. 版本管理规范

项目的版本号格式为 x.x.x 的形式，其中 x 的数值类型为数字，从 0 开始取值，且不限于 0~9 这个范围。项目处于孵化器阶段时，第一位版本号固定使用 0，即版本号为 0.x.x 的格式。

由于 Spring Boot 1 和 Spring Boot 2 在 Actuator 模块的接口和注解有很大的变更，且 spring-cloud-commons 从 1.x.x 版本升级到 2.0.0 版本也有较大的变更，因此我们采取跟 SpringBoot 版本号一致的版本:

* 1.5.x 版本适用于 Spring Boot 1.5.x
* 2.0.x 版本适用于 Spring Boot 2.0.x
* 2.1.x 版本适用于 Spring Boot 2.1.x
* 2.2.x 版本适用于 Spring Boot 2.2.x

# 2. 主要内容

Spring Cloud Alibaba 实战系列教程目前一共会分为以下几个部分，教大家如何使用docker部署服务，实战应用分布式套件：

|  组件   | 功能  |
|  ----  | ----  |
| Nacos | 动态服务发现、配置管理 |
| Sentinel | 流量控制、熔断降级、系统负载保护 | 
| Seata | 高性能微服务分布式事务 | 
| RocketMQ | 高可用分布式消息系统 | 
| Zuul+Oauth2 | 分布式网关鉴权系统 | 
| SkyWalking | 分布式链路追踪与监控系统 | 

# 3. 准备工作

> 本系列教程专门开篇来介绍准备工作，来减少大家在实战过程中的疑惑。以实战为主，基本原理为辅，具体深入原理分析将会另外开篇，敬请期待。

## 3.1. 极速安装 Docker 环境

* **安装 Docker**

Docker 的 安装资源文件 存放在Amazon S3，会间歇性连接失败。所以安装Docker的时候，会比较慢。
你可以通过执行下面的命令，高速安装Docker。适用于Ubuntu，Debian，Centos等大部分Linux，会3小时同步一次Docker官方资源。

```
curl -sSL https://get.daocloud.io/docker | sh
```
* **安装 Docker Compose**

Docker Compose 存放在Git Hub，不太稳定。你可以也通过执行下面的命令，高速安装Docker Compose。你可以通过修改URL中的版本，可以自定义您的需要的版本。

```
curl -L https://get.daocloud.io/docker/compose/releases/download/1.28.2/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
```
```
chmod +x /usr/local/bin/docker-compose
```

* **配置 Docker 镜像站**

配置 Docker 镜像站*。该脚本可以将 --registry-mirror 加入到你的 Docker 配置文件 /etc/docker/daemon.json 中。适用于 Ubuntu14.04、Debian、CentOS6 、CentOS7、Fedora、Arch Linux、openSUSE Leap 42.1，其他版本可能有细微不同。

```
curl -sSL https://get.daocloud.io/daotools/set_mirror.sh | sh -s http://f1361db2.m.daocloud.io
```

## 3.2. 建立一个初始项目

首先，起一个自己的项目名字，这里教程统一叫做：**herring（鲱鱼）**

> herring-xxx 之所以在中间件的项目上包一层，是因为很多企业级开发需要自己的二次封装。项目的建法仁者见仁，智者见智，读者不必过于纠结，按照自己的习惯建立即可。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/ed3fe139ec55408fabb4fc49d1f78eb3~tplv-k3u1fbpfcp-watermark.image)

|  主项目   | 第一层  | 第二层  | 项目说明 |
|  ----  | ----  | ----  | ----  |
| herring | herring-alibaba | herring-nacos | 动态服务发现、配置管理 |
|  |  | herring-sentinel | 流量控制、熔断降级、系统负载保护 |
|  |  | herring-seata | 高性能微服务分布式事务 | 
|  |  | herring-rocketmq | 高可用分布式消息系统 | 
|  | herring-common | herring-feign | 声明式的 web service 客户端 |
|  |  | herring-mysql | 数据库选择 mysql |
|  |  | herring-redis | 分布式缓存选择 redis |
|  |  | herring-tools | 常用工具包 jwt, lombok 等 | 
|  | herring-services | herring-base | 服务基础客户端 nacos, sentinel, skywalking 的客户端 |
|  |  | herring-base-tx | 服务事务相关客户端 seata, rocketmq 的客户端|
|  |  | herring-product | 自建实验微服务（你可以自己随便建） |
|  |  | herring-member | 自建实验微服务（你可以自己随便建） |
|  |  | herring-orders | 自建实验微服务（你可以自己随便建） |
|  | herring-security | herring-oauth2 | oauth2.0 安全认证服务 |
|  |  | herring-gateway | zuul 分布式网关服务 |
|  | herring-skywalking |  | 分布式链路追踪与监控系统 | 

* **选择项目框架的版本约定：**

|  主项目   | 第一层  |
|  ----  | ----  | 
| spring-boot | 2.2.3.RELEASE |
| spring-cloud | Hoxton.SR5 |
| spring-cloud-alibaba | 2.2.3.RELEASE |


* **父级项目版本的约定POM：**

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.jackey</groupId>
    <artifactId>herring</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <java.version>1.8</java.version>
        <spring-cloud-alibaba.version>2.2.3.RELEASE</spring-cloud-alibaba.version>
        <spring-cloud.version>Hoxton.SR5</spring-cloud.version>
        <spring-boot.version>2.2.3.RELEASE</spring-boot.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${spring-cloud-alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

## 3.3. 使用 Docker 快速安装 MySQL 5.7

拉取 MySQL 5.7 版本的镜像

```
docker pull daocloud.io/library/mysql:5.7.4
```

启动 MySQL 5.7 镜像的容器，**注意设置初始密码 和 映射数据存档目录**

```
docker run --name mysql_5.7 -v /docker/mysql/data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=(你的root密码) -d daocloud.io/library/mysql:5.7.4
```

## 3.3. 使用 Docker 快速安装 Redis 3.2

拉取 Redis 3.2 版本的镜像

```
docker pull daocloud.io/library/redis:3.2.8
```

启动 Redis 3.2 镜像的容器，**注意设置持久化参数 和 映射数据存档目录**

```
docker run --name redis_3.2 -v /docker/redis/data:/data -p 6379:6379 -d daocloud.io/library/redis:3.2.8 redis-server --appendonly yes
```
