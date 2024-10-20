package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QianzaikehuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QianzaikehuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QianzaikehuView;


/**
 * 潜在客户
 *
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface QianzaikehuService extends IService<QianzaikehuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QianzaikehuVO> selectListVO(Wrapper<QianzaikehuEntity> wrapper);
   	
   	QianzaikehuVO selectVO(@Param("ew") Wrapper<QianzaikehuEntity> wrapper);
   	
   	List<QianzaikehuView> selectListView(Wrapper<QianzaikehuEntity> wrapper);
   	
   	QianzaikehuView selectView(@Param("ew") Wrapper<QianzaikehuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QianzaikehuEntity> wrapper);
   	

}

