# Tlias Web Management

基于 Spring Boot 3 的 Tlias 智能学习辅助系统后端项目，提供登录鉴权、部门管理、员工管理、班级管理、学员管理、统计报表、文件上传和日志查询等接口。

## 技术栈

- Java 17
- Spring Boot 3.2.5
- Spring Web
- Spring AOP
- MyBatis Spring Boot Starter 3.0.3
- MySQL 8.x
- PageHelper 1.4.7
- JWT `io.jsonwebtoken:jjwt:0.9.1`
- Lombok
- 阿里云 OSS SDK 3.18.4

## 项目结构

```text
src/main/java/com/scut
├── anno          // 自定义注解
├── aop           // AOP 日志切面
├── config        // Spring 配置
├── controller    // 接口层
├── filter        // JWT 过滤器
├── mapper        // MyBatis Mapper
├── pojo          // 实体类和统一返回对象
├── service       // 业务接口
├── service/impl  // 业务实现
└── utils         // JWT、OSS、ThreadLocal 等工具类
```

## 运行环境

- JDK 17
- Maven 3.9+
- MySQL 8.x

## 数据库初始化

数据库脚本已经整理到 [sql](./sql) 目录中，包含以下表的建表语句和示例数据：

- `dept`
- `emp`
- `emp_expr`
- `clazz`
- `student`
- `operate_log`
- `emp_login_log`
- `emp_log`

推荐初始化步骤：

1. 创建数据库 `tlias`
2. 按 [sql/README.md](./sql/README.md) 中的顺序执行脚本
3. 确认 `application.yml` 中的数据源配置与本机 MySQL 一致

如果你使用 Navicat、DataGrip 或命令行导入，执行顺序建议保持一致，避免示例数据因为关联关系导入失败。

## 配置说明

当前项目实际配置文件是 [src/main/resources/application.yml](./src/main/resources/application.yml)。

仓库另外提供了一个示例配置文件：
- [src/main/resources/application-example.yml](./src/main/resources/application-example.yml)

如果你是在本机直接运行，而不是通过 Docker 网络运行，请特别检查数据源地址。当前项目里的 `application.yml` 使用的是：

```yml
spring:
  datasource:
    url: jdbc:mysql://mysql:3306/tlias
    username: root
    password: 123
```

如果你的 MySQL 是本机安装，通常需要改成类似：

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/tlias?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: root
    password: 你的密码
```

## OSS 环境变量

文件上传功能依赖阿里云 OSS，访问凭证不是从 `application.yml` 读取，而是从系统环境变量读取。

需要配置：

```bash
OSS_ACCESS_KEY_ID=your-access-key-id
OSS_ACCESS_KEY_SECRET=your-access-key-secret
```

Windows PowerShell 示例：

```powershell
$env:OSS_ACCESS_KEY_ID="your-access-key-id"
$env:OSS_ACCESS_KEY_SECRET="your-access-key-secret"
```

## 启动方式

### 1. 使用 Maven 直接启动

```bash
mvn spring-boot:run
```

### 2. 打包后运行

```bash
mvn clean package -DskipTests
java -jar target/tlias-web-mangement-0.0.1-SNAPSHOT.jar
```

应用启动类：
- [TliasWebManagementApplication.java](./src/main/java/com/scut/TliasWebManagementApplication.java)

## 登录与鉴权

登录接口：
- `POST /login`

项目通过 [TokenFilter.java](./src/main/java/com/scut/filter/TokenFilter.java) 对请求做 JWT 校验。

当前逻辑：
- `/login` 放行
- 其他接口默认要求请求头中携带 `token`
- token 校验通过后，会把当前登录用户 ID 写入 `ThreadLocal`

示例请求头：

```http
token: your-jwt-token
```

## 默认测试账号

示例数据导入后，可以优先使用以下账号测试：

- 用户名：`shinaian`
- 密码：`123456`

如果该账号被你本地数据覆盖，也可以在 [sql/emp.sql](./sql/emp.sql) 中查看其它示例员工账号。

## 主要接口模块

### 1. 登录
- `POST /login`

### 2. 部门管理
- `GET /depts`
- `GET /depts/{id}`
- `POST /depts`
- `PUT /depts`
- `DELETE /depts/{id}`

### 3. 员工管理
- `GET /emps`
- `GET /emps/{id}`
- `GET /emps/list`
- `POST /emps`
- `PUT /emps`
- `DELETE /emps?ids=1&ids=2`

### 4. 班级管理
- `GET /clazzs`
- `GET /clazzs/list`
- `GET /clazzs/{id}`
- `POST /clazzs`
- `PUT /clazzs`
- `DELETE /clazzs/{id}`

### 5. 学员管理
- `GET /students`
- `GET /students/{id}`
- `POST /students`
- `PUT /students`
- `DELETE /students/{ids}`
- `PUT /students/violation/{id}/{score}`

### 6. 报表统计
- `GET /report/empJobData`
- `GET /report/empGenderData`
- `GET /report/studentCountData`
- `GET /report/studentDegreeData`

### 7. 日志查询
- `GET /log/page`

### 8. 文件上传
- `POST /upload`

上传接口说明：
- 请求类型：`multipart/form-data`
- 文件字段名：`file`

## 常见问题

### 1. 前端能打开，但接口请求失败

优先检查：
- 后端是否成功启动
- `application.yml` 中的 MySQL 地址、用户名、密码是否正确
- 前端代理是否指向当前后端端口

### 2. 登录后请求返回 401

优先检查：
- 请求头是否携带 `token`
- token 是否已经过期
- `TokenFilter` 是否已启用

### 3. 头像上传失败

优先检查：
- OSS 环境变量是否配置
- Bucket、Endpoint、Region 是否和实际 OSS 一致
- 当前网络环境是否能访问 OSS

## 配套前端

本项目配套的前端仓库需要与本后端接口路径保持一致，前后端联调时请确保：
- 前端代理转发到当前后端服务
- 数据库脚本已导入
- OSS 配置可用
