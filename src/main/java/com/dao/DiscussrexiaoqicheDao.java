package com.dao;

import com.entity.DiscussrexiaoqicheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussrexiaoqicheVO;
import com.entity.view.DiscussrexiaoqicheView;


/**
 * 热销汽车评论表
 * 
 * @author 
 * @email 
 * @date 2023-03-16 09:55:00
 */
public interface DiscussrexiaoqicheDao extends BaseMapper<DiscussrexiaoqicheEntity> {
	
	List<DiscussrexiaoqicheVO> selectListVO(@Param("ew") Wrapper<DiscussrexiaoqicheEntity> wrapper);
	
	DiscussrexiaoqicheVO selectVO(@Param("ew") Wrapper<DiscussrexiaoqicheEntity> wrapper);
	
	List<DiscussrexiaoqicheView> selectListView(@Param("ew") Wrapper<DiscussrexiaoqicheEntity> wrapper);

	List<DiscussrexiaoqicheView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussrexiaoqicheEntity> wrapper);
	
	DiscussrexiaoqicheView selectView(@Param("ew") Wrapper<DiscussrexiaoqicheEntity> wrapper);
	

}
