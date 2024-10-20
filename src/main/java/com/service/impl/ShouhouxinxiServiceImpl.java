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


import com.dao.ShouhouxinxiDao;
import com.entity.ShouhouxinxiEntity;
import com.service.ShouhouxinxiService;
import com.entity.vo.ShouhouxinxiVO;
import com.entity.view.ShouhouxinxiView;

@Service("shouhouxinxiService")
public class ShouhouxinxiServiceImpl extends ServiceImpl<ShouhouxinxiDao, ShouhouxinxiEntity> implements ShouhouxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShouhouxinxiEntity> page = this.selectPage(
                new Query<ShouhouxinxiEntity>(params).getPage(),
                new EntityWrapper<ShouhouxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShouhouxinxiEntity> wrapper) {
		  Page<ShouhouxinxiView> page =new Query<ShouhouxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShouhouxinxiVO> selectListVO(Wrapper<ShouhouxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShouhouxinxiVO selectVO(Wrapper<ShouhouxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShouhouxinxiView> selectListView(Wrapper<ShouhouxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShouhouxinxiView selectView(Wrapper<ShouhouxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
