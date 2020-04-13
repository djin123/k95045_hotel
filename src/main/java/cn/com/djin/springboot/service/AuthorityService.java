package cn.com.djin.springboot.service;

import cn.com.djin.springboot.entity.Authority;
import cn.com.djin.springboot.entity.User;

import java.util.List;
import java.util.Map;

/**
 *   权限业务层接口
 */
public interface AuthorityService extends BaseService<Authority> {

    /**
     *   根据角色id查询角色拥有的权限
     * @param roleId  角色id
     * @return   权限的集合
     * @throws Exception
     */
    List<Authority> findAuthoritiesByRoleId(Integer roleId) throws Exception;

    /**
     *   根据用户登陆之后查询其拥有的权限菜单
     * @param user
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> findAuthoritiesByLogin(User user) throws Exception;


}
