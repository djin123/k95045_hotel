package cn.com.djin.springboot.service.impl;

import cn.com.djin.springboot.entity.Rooms;
import cn.com.djin.springboot.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *   房间业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class RoomServiceImpl extends BaseServiceImpl<Rooms> implements RoomService {
}
