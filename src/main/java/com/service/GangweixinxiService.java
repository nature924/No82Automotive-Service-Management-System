package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GangweixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GangweixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GangweixinxiView;


/**
 * 岗位信息
 *
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface GangweixinxiService extends IService<GangweixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GangweixinxiVO> selectListVO(Wrapper<GangweixinxiEntity> wrapper);
   	
   	GangweixinxiVO selectVO(@Param("ew") Wrapper<GangweixinxiEntity> wrapper);
   	
   	List<GangweixinxiView> selectListView(Wrapper<GangweixinxiEntity> wrapper);
   	
   	GangweixinxiView selectView(@Param("ew") Wrapper<GangweixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GangweixinxiEntity> wrapper);
   	

}

