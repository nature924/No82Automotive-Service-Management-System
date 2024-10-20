package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussqichepeijianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussqichepeijianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussqichepeijianView;


/**
 * 汽车配件评论表
 *
 * @author 
 * @email 
 * @date 2023-03-16 09:55:00
 */
public interface DiscussqichepeijianService extends IService<DiscussqichepeijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussqichepeijianVO> selectListVO(Wrapper<DiscussqichepeijianEntity> wrapper);
   	
   	DiscussqichepeijianVO selectVO(@Param("ew") Wrapper<DiscussqichepeijianEntity> wrapper);
   	
   	List<DiscussqichepeijianView> selectListView(Wrapper<DiscussqichepeijianEntity> wrapper);
   	
   	DiscussqichepeijianView selectView(@Param("ew") Wrapper<DiscussqichepeijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussqichepeijianEntity> wrapper);
   	

}

