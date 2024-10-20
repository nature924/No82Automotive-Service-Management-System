package com.dao;

import com.entity.RexiaoqicheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RexiaoqicheVO;
import com.entity.view.RexiaoqicheView;


/**
 * 热销汽车
 * 
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface RexiaoqicheDao extends BaseMapper<RexiaoqicheEntity> {
	
	List<RexiaoqicheVO> selectListVO(@Param("ew") Wrapper<RexiaoqicheEntity> wrapper);
	
	RexiaoqicheVO selectVO(@Param("ew") Wrapper<RexiaoqicheEntity> wrapper);
	
	List<RexiaoqicheView> selectListView(@Param("ew") Wrapper<RexiaoqicheEntity> wrapper);

	List<RexiaoqicheView> selectListView(Pagination page,@Param("ew") Wrapper<RexiaoqicheEntity> wrapper);
	
	RexiaoqicheView selectView(@Param("ew") Wrapper<RexiaoqicheEntity> wrapper);
	

}
