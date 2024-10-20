package com.dao;

import com.entity.PeijianfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeijianfenleiVO;
import com.entity.view.PeijianfenleiView;


/**
 * 配件分类
 * 
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface PeijianfenleiDao extends BaseMapper<PeijianfenleiEntity> {
	
	List<PeijianfenleiVO> selectListVO(@Param("ew") Wrapper<PeijianfenleiEntity> wrapper);
	
	PeijianfenleiVO selectVO(@Param("ew") Wrapper<PeijianfenleiEntity> wrapper);
	
	List<PeijianfenleiView> selectListView(@Param("ew") Wrapper<PeijianfenleiEntity> wrapper);

	List<PeijianfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<PeijianfenleiEntity> wrapper);
	
	PeijianfenleiView selectView(@Param("ew") Wrapper<PeijianfenleiEntity> wrapper);
	

}
