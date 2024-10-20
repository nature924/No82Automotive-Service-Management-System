package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QichepeijianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QichepeijianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QichepeijianView;


/**
 * 汽车配件
 *
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface QichepeijianService extends IService<QichepeijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QichepeijianVO> selectListVO(Wrapper<QichepeijianEntity> wrapper);
   	
   	QichepeijianVO selectVO(@Param("ew") Wrapper<QichepeijianEntity> wrapper);
   	
   	List<QichepeijianView> selectListView(Wrapper<QichepeijianEntity> wrapper);
   	
   	QichepeijianView selectView(@Param("ew") Wrapper<QichepeijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QichepeijianEntity> wrapper);
   	

}

