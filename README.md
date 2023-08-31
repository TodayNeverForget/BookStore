# BookStore


## 主要技术栈

```
java、js、jstl、EL、mysql数据库、阿druid工具、tomcat、
Servlet、idea、css、html、cookie、kaptcha、Filter、
listener
```

## 主要功能

- 用户登陆
- 用户注册
- 书册管理（增删改查）
- 书删信息分布显示
- 分布显示跳转标签

## 功能实现细节

```
通过Filter对访问admin目录下的资源作权限校验；
通过cookie实现用户名cookie有效时间内访问login
界面username自动填充；使用google-kaptcha生成随机
验证码解决表单重复提交问题。

```

## 相关思想

```
项目基于MVC三层模型实现，主要有DAO层、
Service层、Web层以及Web层与jsp页面联动，层次清晰，逻辑分明，
易拓展，易维护；
面向对象编程；
信息分布显示、分布查询；

```