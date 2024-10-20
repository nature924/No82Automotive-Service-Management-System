package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeijiandingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeijiandingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeijiandingdanView;


/**
 * 配件订单
 *
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface PeijiandingdanService extends IService<PeijiandingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeijiandingdanVO> selectListVO(Wrapper<PeijiandingdanEntity> wrapper);
   	
   	PeijiandingdanVO selectVO(@Param("ew") Wrapper<PeijiandingdanEntity> wrapper);
   	
   	List<PeijiandingdanView> selectListView(Wrapper<PeijiandingdanEntity> wrapper);
   	
   	PeijiandingdanView selectView(@Param("ew") Wrapper<PeijiandingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeijiandingdanEntity> wrapper);
   	

}

