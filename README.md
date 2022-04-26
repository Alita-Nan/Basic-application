# Ether Nan 的基础设施

#### 介绍

本项目是在完成本校课程中提炼出来的基础框架。异常的干净（也就是简陋的意思）

#### 如何拉取？

~~如果有梯子的话，那么可以在CMD中执行以下指令~~
~~`git config --global http.proxy 127.0.0.1:xxxx`~~
~~其中，xxxx是你的梯子的端口。~~

~~但是这样设置有个*缺点*，当你没运行梯子时git是无法正常工作的。所以你可以按照下面的命令取消上述的全局设置~~
~~`git config --global --unset http.proxy`~~

`git config --global http.https://github.com.proxy http://127.0.0.1:port`

上面的命令表示一切与github关联的git操作都会走代理

#### ~~设置局部仓库的代理~~

~~你可以用以下指令来指定某个项目的git代理（注意：该文件夹下必须有git文件）~~
~~`git config --local http.proxy 127.0.0.1:xxxx`~~
~~其中，xxxx是你的梯子的端口。~~

#### 软件架构

本项目采用多模块的架构。源自本学期的管理信息系统。 core模块--搭载了各类外部依赖及其配置类。 lab模块--包含core模块（使用maven引入）。该模块负责业务代码。
web模块--包含上述两个模块（使用maven引入）。该模块下有springboot的启动类，并负责处理web请求（即controller所在的模块）

PS： 除了一些常见的外部依赖，我还引入了一个国产的工具包-- hutool。 该项目配置了Dockerfile，你可以根据自己的需求修改Dockerfile。
该项目也配置了一个docker-compose.yml。你可以参照其中的内容稍作修改后部署到服务器上（该文件只包括了mysql的部署，并不包含其他数据库）

#### 使用提示：

用idea打开后你会发现一些模块下根本看不到软件包。

这个时候切勿手动创建 

1. 右键要添加软件包的模块 
2. 点击创建目录
3. 点击弹出的窗口的输入框的下方会有“Maven源目录",点击这段文字下方的
"src/main/java"....

