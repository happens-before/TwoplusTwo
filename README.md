1.项目介绍：TwoplusTwo论坛是一个便于实验室互联网技术交流讨论的一个论坛平台。
2.功能：登陆，注册，修改头像，查看帖子，发表帖子和发表评论。
3.数据库设计：
    3.1.共有5个数据表：login_log，reply，tab，topic，user
4.开发环境与开发框架
    Windows10+IDEA+Git+SSM+Maven+jsp
5.结构
**--src
    --main
        --java**
            --com.xupt.edu
                --aop
                --controlller
                --intercepter
                --mapper
                --pojo
                --service
                --util
        **--resources**
            --mapper
            --applicationContext.xml
            --jdbc.properties
            --log4j.properties
            --mybatis-config.xml
        **--webapp**
            --static
                --js
                --img
                --css
            --WEB-INF
                --jsp
                --web.xml
                --main-servlet.xml
6.遇到的问题
    6.1.前端页面与后端控制怎样交互，流程是怎样的？
        6.1.1.客户端发送请求到DispacherServlet（分发器）
        6.1.2.由DispacherServlet控制器查询HanderMapping，找到处理请求的Controller
        6.1.3.Controller调用业务逻辑处理后，返回ModelAndView
        6.1.4.DispacherSerclet查询视图解析器，找到ModelAndView指定的视图
        6.1.5.视图负责将结果显示到客户端
    6.2.怎样实现负载均衡？
        6.2.1.nginx作反向代理将请求交给Tomcat
        location / {
                        proxy_pass http://tomcat_8080_8222;
                }
        6.2.2.nginx作图片服务器
        location /images/{
                        root /usr/local/;
                        autoindex on;
                }
        6.2.3.nginx作负载均衡
        upstream tomcat_8080_8222{
                server  127.0.0.1:8080 weight=2;
                server  127.0.0.1:8222 weight=1;
            }
        6.2.4.nginx实现动静分离
        location ~\.(css|js|png|jpg|html|txt)$ {
                  root /usr/local/tomcat-8080/webapps;
        }
        6.2.5.session分离，redis作缓存
        <Valve className="com.orangefunction.tomcat.redissessions.RedisSessionHandlerValve" />  
          <Manager className="com.orangefunction.tomcat.redissessions.RedisSessionManager"  
           host="127.0.0.1"  
           port="6379"  
           database="0"  
           maxInactiveInterval="60" /> 
    6.3.怎样实现“记住密码”功能？
         // 记住登录信息
            function rememberLogin(username, password, checked) {
                Cookies.set('loginStatus', {
                    username: username,
                    password: password,
                    remember: checked
                }, {expires: 30, path: ''})
            }
            // 若选择记住登录信息，则进入页面时设置登录信息
            function setLoginStatus() {
                var loginStatusText = Cookies.get('loginStatus')
                if (loginStatusText) {
                    var loginStatus
                    try {
                        loginStatus = JSON.parse(loginStatusText);
                        $('#username').val(loginStatus.username);
                        $('#passwd').val(loginStatus.password);
                        $("#remember").prop('checked',true);
                    } catch (__) {}
                }
            }
    6.4.怎样将项目部署到阿里云服务器？
        6.4.1.购买阿里云实例
        6.4.2.安装jdk  ---yum -y install java-1.8.0-openjdk.x86_64
        6.4.3.安装mysql  ---yum install mysql mysql-server mysql-devel -y
        6.4.4.安装tomcat   ---通过文件传输方式传输压缩包
        6.4.5.将项目war包放在webapp目录下，在浏览器运行。（出现路径访问问题）   
7.总结
    在项目中，利用HttpServletRequest获取页面信息，ModelAndView重定向页面及返回页面渲染信息实现前后端交互;
    使用nginx实现负载均衡，动静分离，采用redis作缓存解决session分离问题;利用cookie保存用户信息实现“记住密码”功能。
    通过此项目我熟悉了SpringMVC的流程，掌握了反向代理负载均衡的原理及实现。
    