package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.RexiaoqicheDao;
import com.entity.RexiaoqicheEntity;
import com.service.RexiaoqicheService;
import com.entity.vo.RexiaoqicheVO;
import com.entity.view.RexiaoqicheView;

@Service("rexiaoqicheService")
public class RexiaoqicheServiceImpl extends ServiceImpl<RexiaoqicheDao, RexiaoqicheEntity> implements RexiaoqicheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RexiaoqicheEntity> page = this.selectPage(
                new Query<RexiaoqicheEntity>(params).getPage(),
                new EntityWrapper<RexiaoqicheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RexiaoqicheEntity> wrapper) {
		  Page<RexiaoqicheView> page =new Query<RexiaoqicheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RexiaoqicheVO> selectListVO(Wrapper<RexiaoqicheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RexiaoqicheVO selectVO(Wrapper<RexiaoqicheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RexiaoqicheView> selectListView(Wrapper<RexiaoqicheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RexiaoqicheView selectView(Wrapper<RexiaoqicheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
