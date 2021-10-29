# Ether Nan 的基础设施

#### 介绍

本项目是在完成本校课程中提炼出来的基础框架。异常的干净（也就是简陋的意思）

#### 软件架构

本项目采用多模块的架构。源自本学期的管理信息系统。 core模块--搭载了各类外部依赖及其配置类。 lab模块--包含core模块（使用maven引入）。该模块负责业务代码。
web模块--包含上述两个模块（使用maven引入）。该模块下有springboot的启动类，并负责处理web请求（即controller所在的模块）

PS： 除了一些常见的外部依赖，我还引入了一个国产的工具包-- hutool。 该项目配置了Dockerfile，你可以根据自己的需求修改Dockerfile。
该项目也配置了一个docker-compose.yml。你可以参照其中的内容稍作修改后部署到服务器上（该文件只包括了mysql的部署，并不包含其他数据库）


