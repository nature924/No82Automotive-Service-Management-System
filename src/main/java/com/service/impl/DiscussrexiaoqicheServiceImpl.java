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


import com.dao.DiscussrexiaoqicheDao;
import com.entity.DiscussrexiaoqicheEntity;
import com.service.DiscussrexiaoqicheService;
import com.entity.vo.DiscussrexiaoqicheVO;
import com.entity.view.DiscussrexiaoqicheView;

@Service("discussrexiaoqicheService")
public class DiscussrexiaoqicheServiceImpl extends ServiceImpl<DiscussrexiaoqicheDao, DiscussrexiaoqicheEntity> implements DiscussrexiaoqicheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussrexiaoqicheEntity> page = this.selectPage(
                new Query<DiscussrexiaoqicheEntity>(params).getPage(),
                new EntityWrapper<DiscussrexiaoqicheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussrexiaoqicheEntity> wrapper) {
		  Page<DiscussrexiaoqicheView> page =new Query<DiscussrexiaoqicheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussrexiaoqicheVO> selectListVO(Wrapper<DiscussrexiaoqicheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussrexiaoqicheVO selectVO(Wrapper<DiscussrexiaoqicheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussrexiaoqicheView> selectListView(Wrapper<DiscussrexiaoqicheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussrexiaoqicheView selectView(Wrapper<DiscussrexiaoqicheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
