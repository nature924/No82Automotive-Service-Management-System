package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShouhouxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShouhouxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShouhouxinxiView;


/**
 * 售后信息
 *
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface ShouhouxinxiService extends IService<ShouhouxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShouhouxinxiVO> selectListVO(Wrapper<ShouhouxinxiEntity> wrapper);
   	
   	ShouhouxinxiVO selectVO(@Param("ew") Wrapper<ShouhouxinxiEntity> wrapper);
   	
   	List<ShouhouxinxiView> selectListView(Wrapper<ShouhouxinxiEntity> wrapper);
   	
   	ShouhouxinxiView selectView(@Param("ew") Wrapper<ShouhouxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShouhouxinxiEntity> wrapper);
   	

}

