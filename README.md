# restkeeper
# 餐饮项目
   本项目分为四个大的模块
   1. restkeeper_common模块：这个模块是其他的模块可能都会用到的一些功能
   2. restkeeper-gateway模块：网关模块
   3. restkeeper_service模块：业务层模块，这个模块使最重要的。里面有分为operator子模块和operator_api模块。
   operator模块里面放的是service实现类和mapper文件夹里面的dao接口
   operator_api模块里面放的是entity文件夹里面的实体类，service接口
   4. restkeeper_web模块：表现层模块，里面就是controller类和swaggler的配置类
   
   
# require one
1. 父工程的依赖是所有的子模块都会依赖到的
模块之间的相互依赖：项目的common模块，是整个项目的公共模块，主要是一些配置文件，工具类
业务模块分为三个子模块：service_common子模块，service_api模块，service_operator模块
service_common子模块是业务层的基础模块，里面引入了同级的common模块，还有主要的一些依赖
包括dubbo，mysql之类的。
2. @RestController注解的作用：全局拦截的作用。比如表现层返回的数据以统一的格式进行返回
   还有统一的异常处理
