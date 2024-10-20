package com.dao;

import com.entity.DiscussqichepeijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussqichepeijianVO;
import com.entity.view.DiscussqichepeijianView;


/**
 * 汽车配件评论表
 * 
 * @author 
 * @email 
 * @date 2023-03-16 09:55:00
 */
public interface DiscussqichepeijianDao extends BaseMapper<DiscussqichepeijianEntity> {
	
	List<DiscussqichepeijianVO> selectListVO(@Param("ew") Wrapper<DiscussqichepeijianEntity> wrapper);
	
	DiscussqichepeijianVO selectVO(@Param("ew") Wrapper<DiscussqichepeijianEntity> wrapper);
	
	List<DiscussqichepeijianView> selectListView(@Param("ew") Wrapper<DiscussqichepeijianEntity> wrapper);

	List<DiscussqichepeijianView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussqichepeijianEntity> wrapper);
	
	DiscussqichepeijianView selectView(@Param("ew") Wrapper<DiscussqichepeijianEntity> wrapper);
	

}
