package com.dao;

import com.entity.PeijiandingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeijiandingdanVO;
import com.entity.view.PeijiandingdanView;


/**
 * 配件订单
 * 
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface PeijiandingdanDao extends BaseMapper<PeijiandingdanEntity> {
	
	List<PeijiandingdanVO> selectListVO(@Param("ew") Wrapper<PeijiandingdanEntity> wrapper);
	
	PeijiandingdanVO selectVO(@Param("ew") Wrapper<PeijiandingdanEntity> wrapper);
	
	List<PeijiandingdanView> selectListView(@Param("ew") Wrapper<PeijiandingdanEntity> wrapper);

	List<PeijiandingdanView> selectListView(Pagination page,@Param("ew") Wrapper<PeijiandingdanEntity> wrapper);
	
	PeijiandingdanView selectView(@Param("ew") Wrapper<PeijiandingdanEntity> wrapper);
	

}
