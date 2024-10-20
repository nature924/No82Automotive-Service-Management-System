export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["新增","查看","修改","删除","审核"],"menu":"员工","menuJump":"列表","tableName":"yuangong"}],"menu":"员工管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["新增","查看","修改","删除"],"menu":"部门信息","menuJump":"列表","tableName":"bumenxinxi"}],"menu":"部门信息管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["新增","查看","修改","删除"],"menu":"岗位信息","menuJump":"列表","tableName":"gangweixinxi"}],"menu":"岗位信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"汽车品牌","menuJump":"列表","tableName":"qichepinpai"}],"menu":"汽车品牌管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改","删除","查看评论"],"menu":"热销汽车","menuJump":"列表","tableName":"rexiaoqiche"}],"menu":"热销汽车管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改","删除","汽车销售业绩","销售品牌统计","日销售额统计","首页总数","首页统计"],"menu":"订单信息","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息管理"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["新增","查看","修改","删除"],"menu":"配件分类","menuJump":"列表","tableName":"peijianfenlei"}],"menu":"配件分类管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改","删除","查看评论"],"menu":"汽车配件","menuJump":"列表","tableName":"qichepeijian"}],"menu":"汽车配件管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除"],"menu":"配件订单","menuJump":"列表","tableName":"peijiandingdan"}],"menu":"配件订单管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","修改","删除"],"menu":"售后信息","menuJump":"列表","tableName":"shouhouxinxi"}],"menu":"售后信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除"],"menu":"潜在客户","menuJump":"列表","tableName":"qianzaikehu"}],"menu":"潜在客户管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"汽车资讯","tableName":"news"},{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","查看评论","立即购买"],"menu":"热销汽车列表","menuJump":"列表","tableName":"rexiaoqiche"}],"menu":"热销汽车模块"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["立即购买","查看评论","查看"],"menu":"汽车配件列表","menuJump":"列表","tableName":"qichepeijian"}],"menu":"汽车配件模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","删除","支付"],"menu":"订单信息","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["支付","删除","查看"],"menu":"配件订单","menuJump":"列表","tableName":"peijiandingdan"}],"menu":"配件订单管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看"],"menu":"售后信息","menuJump":"列表","tableName":"shouhouxinxi"}],"menu":"售后信息管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","查看评论","立即购买"],"menu":"热销汽车列表","menuJump":"列表","tableName":"rexiaoqiche"}],"menu":"热销汽车模块"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["立即购买","查看评论","查看"],"menu":"汽车配件列表","menuJump":"列表","tableName":"qichepeijian"}],"menu":"汽车配件模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["新增","查看","修改","删除","查看评论"],"menu":"热销汽车","menuJump":"列表","tableName":"rexiaoqiche"}],"menu":"热销汽车管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","汽车销售业绩","销售品牌统计","日销售额统计","首页总数","首页统计","售后管理"],"menu":"订单信息","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["新增","查看","修改","删除","查看评论"],"menu":"汽车配件","menuJump":"列表","tableName":"qichepeijian"}],"menu":"汽车配件管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看"],"menu":"配件订单","menuJump":"列表","tableName":"peijiandingdan"}],"menu":"配件订单管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","删除","修改"],"menu":"售后信息","menuJump":"列表","tableName":"shouhouxinxi"}],"menu":"售后信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"潜在客户","menuJump":"列表","tableName":"qianzaikehu"}],"menu":"潜在客户管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看"],"menu":"汽车资讯","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","查看评论","立即购买"],"menu":"热销汽车列表","menuJump":"列表","tableName":"rexiaoqiche"}],"menu":"热销汽车模块"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["立即购买","查看评论","查看"],"menu":"汽车配件列表","menuJump":"列表","tableName":"qichepeijian"}],"menu":"汽车配件模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"员工","tableName":"yuangong"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
