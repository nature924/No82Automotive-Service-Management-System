package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QichepeijianEntity;
import com.entity.view.QichepeijianView;

import com.service.QichepeijianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 汽车配件
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
@RestController
@RequestMapping("/qichepeijian")
public class QichepeijianController {
    @Autowired
    private QichepeijianService qichepeijianService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QichepeijianEntity qichepeijian,
		HttpServletRequest request){
        EntityWrapper<QichepeijianEntity> ew = new EntityWrapper<QichepeijianEntity>();

		PageUtils page = qichepeijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qichepeijian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QichepeijianEntity qichepeijian, 
		HttpServletRequest request){
        EntityWrapper<QichepeijianEntity> ew = new EntityWrapper<QichepeijianEntity>();

		PageUtils page = qichepeijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qichepeijian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QichepeijianEntity qichepeijian){
       	EntityWrapper<QichepeijianEntity> ew = new EntityWrapper<QichepeijianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qichepeijian, "qichepeijian")); 
        return R.ok().put("data", qichepeijianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QichepeijianEntity qichepeijian){
        EntityWrapper< QichepeijianEntity> ew = new EntityWrapper< QichepeijianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qichepeijian, "qichepeijian")); 
		QichepeijianView qichepeijianView =  qichepeijianService.selectView(ew);
		return R.ok("查询汽车配件成功").put("data", qichepeijianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QichepeijianEntity qichepeijian = qichepeijianService.selectById(id);
        return R.ok().put("data", qichepeijian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QichepeijianEntity qichepeijian = qichepeijianService.selectById(id);
        return R.ok().put("data", qichepeijian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QichepeijianEntity qichepeijian, HttpServletRequest request){
    	qichepeijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qichepeijian);
        qichepeijianService.insert(qichepeijian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QichepeijianEntity qichepeijian, HttpServletRequest request){
    	qichepeijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qichepeijian);
        qichepeijianService.insert(qichepeijian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QichepeijianEntity qichepeijian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qichepeijian);
        qichepeijianService.updateById(qichepeijian);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qichepeijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<QichepeijianEntity> wrapper = new EntityWrapper<QichepeijianEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = qichepeijianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
