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

import com.entity.RexiaoqicheEntity;
import com.entity.view.RexiaoqicheView;

import com.service.RexiaoqicheService;
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
 * 热销汽车
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
@RestController
@RequestMapping("/rexiaoqiche")
public class RexiaoqicheController {
    @Autowired
    private RexiaoqicheService rexiaoqicheService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RexiaoqicheEntity rexiaoqiche,
		HttpServletRequest request){
        EntityWrapper<RexiaoqicheEntity> ew = new EntityWrapper<RexiaoqicheEntity>();

		PageUtils page = rexiaoqicheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rexiaoqiche), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RexiaoqicheEntity rexiaoqiche, 
		HttpServletRequest request){
        EntityWrapper<RexiaoqicheEntity> ew = new EntityWrapper<RexiaoqicheEntity>();

		PageUtils page = rexiaoqicheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rexiaoqiche), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RexiaoqicheEntity rexiaoqiche){
       	EntityWrapper<RexiaoqicheEntity> ew = new EntityWrapper<RexiaoqicheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( rexiaoqiche, "rexiaoqiche")); 
        return R.ok().put("data", rexiaoqicheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RexiaoqicheEntity rexiaoqiche){
        EntityWrapper< RexiaoqicheEntity> ew = new EntityWrapper< RexiaoqicheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( rexiaoqiche, "rexiaoqiche")); 
		RexiaoqicheView rexiaoqicheView =  rexiaoqicheService.selectView(ew);
		return R.ok("查询热销汽车成功").put("data", rexiaoqicheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RexiaoqicheEntity rexiaoqiche = rexiaoqicheService.selectById(id);
		rexiaoqiche.setClicknum(rexiaoqiche.getClicknum()+1);
		rexiaoqiche.setClicktime(new Date());
		rexiaoqicheService.updateById(rexiaoqiche);
        return R.ok().put("data", rexiaoqiche);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RexiaoqicheEntity rexiaoqiche = rexiaoqicheService.selectById(id);
		rexiaoqiche.setClicknum(rexiaoqiche.getClicknum()+1);
		rexiaoqiche.setClicktime(new Date());
		rexiaoqicheService.updateById(rexiaoqiche);
        return R.ok().put("data", rexiaoqiche);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RexiaoqicheEntity rexiaoqiche, HttpServletRequest request){
    	rexiaoqiche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rexiaoqiche);
        rexiaoqicheService.insert(rexiaoqiche);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RexiaoqicheEntity rexiaoqiche, HttpServletRequest request){
    	rexiaoqiche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rexiaoqiche);
        rexiaoqicheService.insert(rexiaoqiche);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RexiaoqicheEntity rexiaoqiche, HttpServletRequest request){
        //ValidatorUtils.validateEntity(rexiaoqiche);
        rexiaoqicheService.updateById(rexiaoqiche);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        rexiaoqicheService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<RexiaoqicheEntity> wrapper = new EntityWrapper<RexiaoqicheEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = rexiaoqicheService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,RexiaoqicheEntity rexiaoqiche, HttpServletRequest request,String pre){
        EntityWrapper<RexiaoqicheEntity> ew = new EntityWrapper<RexiaoqicheEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = rexiaoqicheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rexiaoqiche), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,RexiaoqicheEntity rexiaoqiche, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "qichepinpai";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "rexiaoqiche").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<RexiaoqicheEntity> rexiaoqicheList = new ArrayList<RexiaoqicheEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                rexiaoqicheList.addAll(rexiaoqicheService.selectList(new EntityWrapper<RexiaoqicheEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<RexiaoqicheEntity> ew = new EntityWrapper<RexiaoqicheEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = rexiaoqicheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rexiaoqiche), params), params));
        List<RexiaoqicheEntity> pageList = (List<RexiaoqicheEntity>)page.getList();
        if(rexiaoqicheList.size()<limit) {
            int toAddNum = (limit-rexiaoqicheList.size())<=pageList.size()?(limit-rexiaoqicheList.size()):pageList.size();
            for(RexiaoqicheEntity o1 : pageList) {
                boolean addFlag = true;
                for(RexiaoqicheEntity o2 : rexiaoqicheList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    rexiaoqicheList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(rexiaoqicheList.size()>limit) {
            rexiaoqicheList = rexiaoqicheList.subList(0, limit);
        }
        page.setList(rexiaoqicheList);
        return R.ok().put("data", page);
    }







}
