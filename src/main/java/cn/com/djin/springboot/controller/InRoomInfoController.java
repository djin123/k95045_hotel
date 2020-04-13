package cn.com.djin.springboot.controller;

import cn.com.djin.springboot.entity.InRoomInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   入住信息的控制器
 *    实现数据交互控制器
 */
@Controller
@RequestMapping("/inRoomInfo")
public class InRoomInfoController extends BaseController<InRoomInfo>{
}
