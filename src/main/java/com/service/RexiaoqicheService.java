package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RexiaoqicheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RexiaoqicheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RexiaoqicheView;


/**
 * 热销汽车
 *
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface RexiaoqicheService extends IService<RexiaoqicheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RexiaoqicheVO> selectListVO(Wrapper<RexiaoqicheEntity> wrapper);
   	
   	RexiaoqicheVO selectVO(@Param("ew") Wrapper<RexiaoqicheEntity> wrapper);
   	
   	List<RexiaoqicheView> selectListView(Wrapper<RexiaoqicheEntity> wrapper);
   	
   	RexiaoqicheView selectView(@Param("ew") Wrapper<RexiaoqicheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RexiaoqicheEntity> wrapper);
   	

}

