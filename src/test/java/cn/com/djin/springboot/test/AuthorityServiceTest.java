package cn.com.djin.springboot.test;

import cn.com.djin.springboot.entity.Authority;
import cn.com.djin.springboot.entity.InRoomInfo;
import cn.com.djin.springboot.entity.User;
import cn.com.djin.springboot.service.AuthorityService;
import cn.com.djin.springboot.service.InRoomInfoService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 *   入住信息业务层测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorityServiceTest {

    @Autowired
    private AuthorityService authorityService;

    //日志对象
    private static final Logger log = Logger.getLogger(AuthorityServiceTest.class);

    //测试登陆后的权限菜单查询
    @Test
    public void test01(){
        //新建模拟的登陆用户
        User user = new User();
        user.setRoleId(1);
        try {
            //执行查询
            List<Map<String, Object>> mapList = authorityService.findAuthoritiesByLogin(user);
            for (Map<String,Object> map:mapList) {
                log.info("一级权限id："+map.get("firstAId"));
                log.info("一级权限名字："+map.get("firstAName"));
                List<Authority> secAuthorities = (List<Authority>)map.get("secAuthorities");
                for (Authority secAuthoritie:secAuthorities) {
                    log.info(secAuthoritie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
