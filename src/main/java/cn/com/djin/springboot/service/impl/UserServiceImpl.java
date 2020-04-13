package cn.com.djin.springboot.service.impl;

import cn.com.djin.springboot.entity.Authority;
import cn.com.djin.springboot.entity.Roles;
import cn.com.djin.springboot.entity.User;
import cn.com.djin.springboot.service.UserService;
import cn.com.djin.springboot.utils.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 *   用户业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    //重写根据条件分页查询
    @Override
    public Map<String, Object> findPageByPramas(Integer page, Integer limit, User user) throws Exception {
        //获取分页查询的map集合数据
        Map<String, Object> map = super.findPageByPramas(page, limit, user);
        //得到分页发用户数据
        List<User> list = (List<User>) map.get("data");
        //3.通过循环将每一个角色拥有的一级权限数据查询出来
        for (int i=0;i<list.size();i++){
            //3.1.获取每一次循环的用户对象
            User u = list.get(i);
            //3.2.根据角色id查询其角色拥有的一级权限数据
            List<Authority> firstAuthorities = authorityMapper.selectAuthoritiesByRoleIdAndParent(u.getRoleId(),0);
            //3.3.将一级权限循环得到权限名称字符串
            StringBuffer firstANames = new StringBuffer();
            for (int j=0;j<firstAuthorities.size();j++){
                //得到角色的一级权限名称
                firstANames.append(firstAuthorities.get(j).getAuthorityName()+",");
            }
            //4.将字符串设置到用户对象中
            u.setFirstANames(firstANames.toString().substring(0,firstANames.length()-1));
        }
        return map;
    }

    /*//重写用户添加
    @Override
    public String save(User user) throws Exception {
        //对密码进行MD5加密
        user.setPwd(MD5.md5crypt(user.getPwd()));
        return super.save(user);
    }*/
}
