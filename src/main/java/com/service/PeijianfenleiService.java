package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeijianfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeijianfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeijianfenleiView;


/**
 * 配件分类
 *
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface PeijianfenleiService extends IService<PeijianfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeijianfenleiVO> selectListVO(Wrapper<PeijianfenleiEntity> wrapper);
   	
   	PeijianfenleiVO selectVO(@Param("ew") Wrapper<PeijianfenleiEntity> wrapper);
   	
   	List<PeijianfenleiView> selectListView(Wrapper<PeijianfenleiEntity> wrapper);
   	
   	PeijianfenleiView selectView(@Param("ew") Wrapper<PeijianfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeijianfenleiEntity> wrapper);
   	

}

