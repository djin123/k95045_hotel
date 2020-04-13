package cn.com.djin.springboot.service.impl;

import cn.com.djin.springboot.entity.Vip;
import cn.com.djin.springboot.service.VipService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *   会员业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class VipServiceImpl extends BaseServiceImpl<Vip> implements VipService {

}
