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


import com.dao.PeijiandingdanDao;
import com.entity.PeijiandingdanEntity;
import com.service.PeijiandingdanService;
import com.entity.vo.PeijiandingdanVO;
import com.entity.view.PeijiandingdanView;

@Service("peijiandingdanService")
public class PeijiandingdanServiceImpl extends ServiceImpl<PeijiandingdanDao, PeijiandingdanEntity> implements PeijiandingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeijiandingdanEntity> page = this.selectPage(
                new Query<PeijiandingdanEntity>(params).getPage(),
                new EntityWrapper<PeijiandingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeijiandingdanEntity> wrapper) {
		  Page<PeijiandingdanView> page =new Query<PeijiandingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeijiandingdanVO> selectListVO(Wrapper<PeijiandingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeijiandingdanVO selectVO(Wrapper<PeijiandingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeijiandingdanView> selectListView(Wrapper<PeijiandingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeijiandingdanView selectView(Wrapper<PeijiandingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
