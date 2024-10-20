package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussrexiaoqicheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussrexiaoqicheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussrexiaoqicheView;


/**
 * 热销汽车评论表
 *
 * @author 
 * @email 
 * @date 2023-03-16 09:55:00
 */
public interface DiscussrexiaoqicheService extends IService<DiscussrexiaoqicheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussrexiaoqicheVO> selectListVO(Wrapper<DiscussrexiaoqicheEntity> wrapper);
   	
   	DiscussrexiaoqicheVO selectVO(@Param("ew") Wrapper<DiscussrexiaoqicheEntity> wrapper);
   	
   	List<DiscussrexiaoqicheView> selectListView(Wrapper<DiscussrexiaoqicheEntity> wrapper);
   	
   	DiscussrexiaoqicheView selectView(@Param("ew") Wrapper<DiscussrexiaoqicheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussrexiaoqicheEntity> wrapper);
   	

}

