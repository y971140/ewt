# ewt

本项目使用 Spring Boot 搭建, 用于加深对 Spring Boot 与 Shiro 的学习, 项目特色是支持 restful 风格权限控制, 支持对同一 URL, 不同 HTTP Mehtod 的权限控制, 适用于更多的场景.

预览地址: http://ewt.186g.cn

接口文档: http://ewt.186g.cn/swagger-ui.html

默认管理员账号: `admin`, 密码: `123456`.

普通用户账号: `user`, 密码: `123456`.

> 为了不影响其他人的浏览体验, 请尽量不要进行删除类的敏感操作. `admin` 为超级管理员, 自动拥有全部权限.

## 系统特色

- 支持根据同 URL, 不同 HTTP Method 来校验权限, 更支持 restful 场景.
- 集成 OAuth2 登录, 且提供了接口易于拓展开发.
- 全局异常处理. 根据请求方式区分返回 json 数据还是错误页面.
- Logback MDC 支持, 将当前登录人和操作者 IP 加入日志中.
- JSR-303 数据校验

## 运行环境

- JDK 1.8
- MySQL 5.7
- Redis

## 快速开始

### 下载项目

```
git clone https://github.com/y971140/ewt.git
```

### 导入项目

使用自己的 IDE 导入, Eclipse 和 Intellij IDEA 均可.

### 导入数据库

创建数据库, 字符集选择 `utf8`, 排序规则选择 `utf8_general_ci`.

然后导入 `shiro_action.sql` 到数据库中.

### 配置文件

打开 `application.yml修改 `MySQL` 和 `Redis` 连接信息.

```
redis:
    host: 127.0.0.1
    port: 6379
cache:
    type: redis
    redis:
      time-to-live: 6000

 datasource:
    url: jdbc:mysql://127.0.0.1:3306/shiro_action?useSSL=false&characterEncoding=UTF8&&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
    username: root
    password: root
```

### 启动项目

在完成了上述步骤后，找到 ShiroActionApplication 启动类, 启动即可.

启动后访问地址为：[http://localhost:8080](http://localhost:8080/) , 用户名：admin, 密码：123456.

## 系统预览

[![img](https://camo.githubusercontent.com/c780f4d6bd3bb539cb327808568e93c356602fce/68747470733a2f2f63646e2e6a756e362e6e65742f3230313930353239323330335f3231312e706e67)](https://camo.githubusercontent.com/c780f4d6bd3bb539cb327808568e93c356602fce/68747470733a2f2f63646e2e6a756e362e6e65742f3230313930353239323330335f3231312e706e67)

[![img](https://camo.githubusercontent.com/7f9a54417637da52f00db6e2cd7c94158de0eb67/68747470733a2f2f63646e2e6a756e362e6e65742f3230313930363330323135395f3332362e706e67)](https://camo.githubusercontent.com/7f9a54417637da52f00db6e2cd7c94158de0eb67/68747470733a2f2f63646e2e6a756e362e6e65742f3230313930363330323135395f3332362e706e67)

[![img](https://camo.githubusercontent.com/07022197b147df1a6913ec87020156657547bb5d/68747470733a2f2f63646e2e6a756e362e6e65742f323031392f30362f33302f356431386330613835623338612e706e67)](https://camo.githubusercontent.com/07022197b147df1a6913ec87020156657547bb5d/68747470733a2f2f63646e2e6a756e362e6e65742f323031392f30362f33302f356431386330613835623338612e706e67)

[![img](https://camo.githubusercontent.com/1b18d943cdf333fd04b9114d9c546f3049743312/68747470733a2f2f63646e2e6a756e362e6e65742f323031392f30362f33302f356431386330613834393238352e706e67)](https://camo.githubusercontent.com/1b18d943cdf333fd04b9114d9c546f3049743312/68747470733a2f2f63646e2e6a756e362e6e65742f323031392f30362f33302f356431386330613834393238352e706e67)

[![img](https://camo.githubusercontent.com/0feade10a7bf3855dce3537999552e58df36c809/68747470733a2f2f63646e2e6a756e362e6e65742f323031392f30362f33302f356431386331653039643331342e706e67)](https://camo.githubusercontent.com/0feade10a7bf3855dce3537999552e58df36c809/68747470733a2f2f63646e2e6a756e362e6e65742f323031392f30362f33302f356431386331653039643331342e706e67)

[![img](https://camo.githubusercontent.com/f62adc402032981059de9d49cdd20d03b46f28c8/68747470733a2f2f63646e2e6a756e362e6e65742f323031392f30362f33302f356431386331616432373538302e706e67)](https://camo.githubusercontent.com/f62adc402032981059de9d49cdd20d03b46f28c8/68747470733a2f2f63646e2e6a756e362e6e65742f323031392f30362f33302f356431386331616432373538302e706e67)

[![img](https://camo.githubusercontent.com/f4c698b4bea0036fce302ff89e7a10a7000f3e16/68747470733a2f2f63646e2e6a756e362e6e65742f323031392f30362f33302f356431386331616432396430352e706e67)](https://camo.githubusercontent.com/f4c698b4bea0036fce302ff89e7a10a7000f3e16/68747470733a2f2f63646e2e6a756e362e6e65742f323031392f30362f33302f356431386331616432396430352e706e67)

### 技术选型

#### 前端

- 前端框架: [Layui](https://www.layui.com/)
- 后台模板: [Z-Admin](https://github.com/y971140/ewt/)

#### 后端

- SpringBoot 2.0.6.RELEASE
- Shiro 1.4.0
- MyBatis Plus  3.1.2
- Druid 1.1.10
- PageHelper 1.2.9
- Shiro-Redis 3.2.3

#### 其他工具类

- OAuth2 认证工具类: [JustAuth](https://gitee.com/yadong.zhang/JustAuth)
- Hutool : https://hutool.cn/

### 反馈交流

QQ 群号: [49299654]

[<img src="https://github.com/y971140/ewt/blob/master/src/main/resources/static/images/20200515171749.png" alt="QQ群：49299654" style="zoom: 33%;" />]
