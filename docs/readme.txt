目录规划:
Src_config:放的是配置文件
Src_common:放的是公共的代码,一些工具类
Src_users:模块的代码,一个模块一个源码包,src_system;src_rbac:src_orders
Src_head:前台的Controller(Servlet);广大网民看到的页面
Src_back:后台的Controller(Servlet);后台管理员看到页面

所有的jsp都放到/WEB-INF/jsp目录
Back:存储后台管理员访问需要的jsp(无所谓,白板都行)
Head:存储广大网民看到的jsp;(一定炫炫炫)

如果是横向切分:jsp一个人,controller一个人,service以下一个人
如果是纵向切分:需要操作jsp的目录,controller目录,Service目录

URL规划:
所有后台管理员登陆后才能访问的页面都放到/back
所有前台用户(广大网民)登陆后才能访问的页面都放到/head
是为了做管理员登陆的拦截器验证(过滤器)