redis整合springboot实战 1、springboot结合redis实战

    1、引入bean redisTemplate的使用，类型于：monogoTemplate、jdbcTemplate数据库连接工具


    2、配置步骤:
        1)引入pom依赖，
        <dependency>
             <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>


        2）编写redisTemplate类，设置redisConnectFactory


        3）引入配置文件
2、通过springboot redisTemplate实现分布式锁 
3、通过springboot redisTemplate实现排行榜 
4、通过springboot redisTemplate实现秒杀功能 
5、通过springboot redisTemplate实现布隆过滤器 
6、通过springboot redisTemplate整合lua脚本
