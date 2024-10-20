<template>
<div>
	<div :style='{"padding":"0px 7%","boxShadow":"0 0px 0px #ccc","margin":"0px 0","borderColor":"#eee","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","borderWidth":"1px 0 1px","width":"100%","lineHeight":"60px","borderStyle":"solid","height":"60px"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'Ξ'" :style='{"width":"100%","margin":"0 auto","fontSize":"16px","lineHeight":"60px","justifyContent":"center","display":"flex"}'>
			<el-breadcrumb-item>首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index">{{item.name}}</el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	
	<div class="list-preview" :style='{"padding":"0","margin":"0px auto","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative"}'>
		
	
    <el-form :inline="true" :model="formSearch" class="list-form-pv" :style='{"padding":"30px 20px 30px","margin":"20px 7% 0","borderColor":"#00adb5","alignItems":"center","borderRadius":"0px","flexWrap":"wrap","background":"none","borderWidth":"0px 0 0px 0","display":"flex","width":"100%","borderStyle":"dashed","height":"auto"}'>
      <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>订单编号</div>
        <el-input v-model="formSearch.dingdanbianhao" placeholder="订单编号" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>汽车名称</div>
        <el-input v-model="formSearch.qichemingcheng" placeholder="汽车名称" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>汽车品牌</div>
        <el-input v-model="formSearch.qichepinpai" placeholder="汽车品牌" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>用户账号</div>
        <el-input v-model="formSearch.yonghuzhanghao" placeholder="用户账号" clearable></el-input>
      </el-form-item>
	  <el-button v-if=" true " :style='{"cursor":"pointer","padding":"0px 10px","boxShadow":"0px 0px 0px #ccc","margin":"0px 10px 0 0","borderColor":"#0087a7","color":"#333","minWidth":"90px","outline":"none","borderRadius":"30px","background":"linear-gradient(30deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%)","borderWidth":"0px 1px 2px","width":"auto","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' type="primary" @click="getList(1, curFenlei)"><i v-if="true" :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}' class="el-icon-search"></i>查询</el-button>
	  <el-button v-if="isAuth('dingdanxinxi','新增')" :style='{"cursor":"pointer","padding":"0px 10px","boxShadow":"0px 0px 0px #f8a412","margin":"0px 10px 0 0","borderColor":"#72bb3d","color":"#333","minWidth":"90px","outline":"none","borderRadius":"30px","background":"linear-gradient(30deg, rgba(206,255,170,1) 0%, rgba(114,187,61,1) 28%, rgba(206,255,170,1) 68%, rgba(114,187,61,1) 100%)","borderWidth":"0px 1px 2px","width":"auto","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' type="primary" @click="add('/index/dingdanxinxiAdd')"><i v-if="true" :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}' class="el-icon-circle-plus-outline"></i>添加</el-button>
    </el-form>

	<div class="list" :style='{"padding":"0px 0 20px","margin":"20px 7% 0px","background":"none","flex":"1","width":"100%","minWidth":"750px","order":"2"}'>
		<!-- 样式一 -->
		
		<!-- 样式二 -->
		<div class="list2 index-pv1" :style='{"padding":"0 0px","margin":"20px 0 0","borderRadius":"0px","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
			<div :style='{"border":"0px solid #eee","cursor":"pointer","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 20px","display":"flex","justifyContent":"space-between","borderRadius":"0px","flexWrap":"wrap","background":"none","width":"49.5%","fontSize":"0","position":"relative","height":"320px"}' v-for="(item, index) in dataList" :key="index" @click="toDetail(item)" class="list-item animation-box">
				<img :style='{"cursor":"pointer","padding":"10px","boxShadow":"0px 6px 6px -6px #80afba","borderColor":"#0087a7 #bdeaf4 #0087a7 #bdeaf4","margin":"0px 0 0","objectFit":"cover","display":"inline-block","borderRadius":"20px","borderWidth":"1px 2px 2px 1px","background":"none","width":"48%","borderStyle":"dotted","height":"100%"}' v-if="item.qichetupian && item.qichetupian.substr(0,4)=='http'" :src="item.qichetupian" class="image" />
				<img :style='{"cursor":"pointer","padding":"10px","boxShadow":"0px 6px 6px -6px #80afba","borderColor":"#0087a7 #bdeaf4 #0087a7 #bdeaf4","margin":"0px 0 0","objectFit":"cover","display":"inline-block","borderRadius":"20px","borderWidth":"1px 2px 2px 1px","background":"none","width":"48%","borderStyle":"dotted","height":"100%"}' v-else :src="baseUrl + (item.qichetupian?item.qichetupian.split(',')[0]:'')" class="image" />
				<div class="item-info" :style='{"padding":"10px 0px","boxShadow":"0px 12px 12px -12px #80afba","alignSelf":"center","borderColor":"#bdeaf4 #0087a7 #bdeaf4 #0087a7","margin":"0px 0 0","display":"flex","justifyContent":"center","overflow":"hidden","borderRadius":"10px","flexWrap":"wrap","borderWidth":"1px 1px 3px 4px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"50%","borderStyle":"solid","height":"280px"}'>
					<div :style='{"padding":"0 6px","borderColor":"#9dcde9","margin":"0 10px 0 0","color":"#333","alignItems":"center","textAlign":"center","display":"flex","justifyContent":"center","overflow":"hidden","background":"none","borderWidth":"0 0 0px","width":"32px","lineHeight":"16px","fontSize":"14px","borderStyle":"dotted"}' class="name ">{{item.qichemingcheng}}</div>
					<div v-if="item.price" :style='{"padding":"10px","lineHeight":"24px","fontSize":"14px","color":"#f00","textAlign":"center","display":"none"}' class="price"><span :style='{"fontSize":"12px"}'>￥</span>{{item.price}}</div>
				</div>
			</div>
		</div>
	</div>

	
	<el-pagination
	  background
	  class="pagination"
	  :pager-count="7"
	  :page-size="pageSize"
	  :page-sizes="pageSizes"
	  prev-text="<"
	  next-text=">"
	  :hide-on-single-page="true"
	  :layout='["total","prev","pager","next","sizes","jumper"].join()'
	  :total="total"
	  :style='{"padding":"0px 7%","margin":"20px auto","whiteSpace":"nowrap","color":"#333","textAlign":"center","width":"auto","fontWeight":"500","order":"99"}'
	  @current-change="curChange"
	  @prev-click="prevClick"
	  @next-click="nextClick"
	></el-pagination>

  </div>
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
	    layouts: '',
		swiperIndex: -1,
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '订单信息'
          }
        ],
        formSearch: {
          dingdanbianhao: '',
          qichemingcheng: '',
          qichepinpai: '',
          yonghuzhanghao: '',
        },
        fenlei: [],
        dataList: [],
        total: 1,
        pageSize: 12,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        curFenlei: '全部',
        isPlain: false,
        indexQueryCondition: '',
        timeRange: []
      }
    },
    created() {
      this.indexQueryCondition = this.$route.query.indexQueryCondition ? this.$route.query.indexQueryCondition : '';
      this.baseUrl = this.$config.baseUrl;
      this.getFenlei();
      this.getList(1, '全部');
    },
    //方法集合
    methods: {
      add(path) {
        this.$router.push({path: path});
      },
      getFenlei() {
      },
      getList(page, fenlei, ref = '') {
        let params = {page, limit: this.pageSize};
        let searchWhere = {};
        if (this.formSearch.dingdanbianhao != '') searchWhere.dingdanbianhao = '%' + this.formSearch.dingdanbianhao + '%';
        if (this.formSearch.qichemingcheng != '') searchWhere.qichemingcheng = '%' + this.formSearch.qichemingcheng + '%';
        if (this.formSearch.qichepinpai != '') searchWhere.qichepinpai = '%' + this.formSearch.qichepinpai + '%';
        if (this.formSearch.yonghuzhanghao != '') searchWhere.yonghuzhanghao = '%' + this.formSearch.yonghuzhanghao + '%';
        this.$http.get('dingdanxinxi/list', {params: Object.assign(params, searchWhere)}).then(res => {
          if (res.data.code == 0) {
            this.dataList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = res.data.data.pageSize;
            this.totalPage = res.data.data.totalPage;
			
			this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
          }
        });
      },
      curChange(page) {
        this.getList(page);
      },
      prevClick(page) {
        this.getList(page);
      },
      nextClick(page) {
        this.getList(page);
      },
      toDetail(item) {
        this.$router.push({path: '/index/dingdanxinxiDetail', query: {detailObj: JSON.stringify(item)}});
      },
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.list-preview .list-form-pv .el-input {
		width: auto;
	}

	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #333;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner a {
		color: #333;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner {
		color: #333;
		display: inline-block;
	}
	
	.category-1 .item {
		cursor: pointer;
		border: 0px solid #ffd800;
		padding: 0 10px;
		margin: 0 0px 20px 0;
		color: #333;
		font-size: 15px;
		border-color: #33b4d2;
		line-height: 44px;
		border-radius: 20px 0 20px 0px;
		box-shadow: 0px 0px 0px #ceb44a;
		background: linear-gradient(320deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%);
		width: auto;
		border-width: 0 0 4px;
		border-style: outset;
		text-align: center;
		min-width: 110px;
		height: 44px;
	}
	
	.category-1 .item:hover {
		cursor: pointer;
		border-radius: 20px 0 20px 0px;
		box-shadow: 0px 6px 8px -2px #448290;
		margin: 0 0px 20px 0;
		color: #000;
		background: linear-gradient(230deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%);
		width: auto;
		font-size: 14px;
		border-color: #0087a7;
		line-height: 44px;
		text-align: center;
	}
	
	.category-1 .item.active {
		cursor: pointer;
		margin: 0 0px 20px 0;
		color: #000;
		font-size: 14px;
		border-color: #0087a7;
		line-height: 44px;
		border-radius: 20px 0 20px 0px;
		box-shadow: 0px 6px 8px -2px #448290;
		background: linear-gradient(230deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%);
		width: auto;
		border-width: 0 0 4px;
		border-style: outset;
		text-align: center;
	}
	
	.category-2 .item {
		cursor: pointer;
		border-radius: 4px;
		box-shadow: 0;
		margin: 0 0 10px 0;
		color: #fff;
		background: linear-gradient(135deg, rgba(17,112,210,1) 0%, rgba(8,179,68,1) 100%);
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item:hover {
		cursor: pointer;
		border: 1px solid #1170d2;
		border-radius: 4px;
		box-shadow: 0;
		margin: 0 0 10px 0;
		color: #fff;
		background: linear-gradient(135deg, rgba(8,179,68,1) 0%, rgba(17,112,210,1) 100%);
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item.active {
		cursor: pointer;
		border: 1px solid #1170d2;
		border-radius: 4px;
		box-shadow: 0;
		margin: 0 0 10px 0;
		color: #fff;
		background: linear-gradient(135deg, rgba(8,179,68,1) 0%, rgba(17,112,210,1) 100%);
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.list-form-pv .el-input /deep/ .el-input__inner {
		border: 1px solid #eee;
		border-radius: 30px;
		padding: 0 10px;
		box-shadow: inset 0px 0px 0px 0px rgba(48,134,185,.2);
		margin: 0px;
		outline: none;
		color: #333;
		background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list-form-pv .el-select /deep/ .el-input__inner {
		border: 1px solid #eee;
		border-radius: 30px;
		padding: 0 10px;
		box-shadow: inset 0px 0px 0px 0px rgba(48,134,185,.2);
		margin: 0px;
		outline: none;
		color: #666;
		background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list-form-pv .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #eee;
		border-radius: 30px;
		padding: 0 30px;
		box-shadow: inset 0px 0px 0px 0px rgba(48,134,185,.2);
		margin: 0px;
		outline: none;
		color: #666;
		background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list .index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.list .index-pv1 .animation-box:hover {
		transform: translate3d(0px, -10px, 0px);
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
		z-index: 1;
	}
	
	.list .index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.list .index-pv1 .animation-box img:hover {
		filter: brightness(1) ;
		transform: rotate(0deg)  scale(1);
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: all 0.3s ease-in-out 0s;
	}
	
	.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f4f4f5;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #0087a7;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #0087a7;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}
	
	.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
</style>
