<template>
<div>
	<div :style='{"padding":"0px 7%","boxShadow":"0 0px 0px #ccc","margin":"0px 0","borderColor":"#eee","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","borderWidth":"1px 0 1px","width":"100%","lineHeight":"60px","borderStyle":"solid","height":"60px"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'Ξ'" :style='{"width":"100%","margin":"0 auto","fontSize":"16px","lineHeight":"60px","justifyContent":"center","display":"flex"}'>
			<el-breadcrumb-item>首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index">{{item.name}}</el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	
	<div class="detail-preview" :style='{"padding":"0px 0 40px","margin":"0px auto","alignItems":"flex-start","flexWrap":"wrap","display":"flex","width":"100%","position":"relative","justifyContent":"space-between"}'>
		<div class="attr" :style='{"minHeight":"660px","padding":"0px","margin":"0","borderColor":"#b2e2fe","flexWrap":"wrap","background":"none","borderWidth":"0px","display":"flex","width":"100%","position":"relative","borderStyle":"dotted","justifyContent":"space-between"}'>
			<el-carousel :style='{"width":"41%","margin":"40px 7% 0 0","float":"left","height":"560px","order":"2"}' trigger="click" indicator-position="inside" arrow="never" type="default" direction="horizontal" height="560px" autoplay="true" interval="3000" loop="true">
				<el-carousel-item :style='{"borderRadius":"0","width":"100%","height":"100%"}' v-for="item in detailBanner" :key="item.id">
					<el-image :style='{"padding":"20px","borderColor":"#bcdbdf","objectFit":"cover","borderRadius":"20px","borderWidth":"4px 1px 4px 3px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"100%","borderStyle":"outset","height":"100%"}' v-if="item.substr(0,4)=='http'" :src="item" fit="cover" class="image"></el-image>
					<el-image :style='{"padding":"20px","borderColor":"#bcdbdf","objectFit":"cover","borderRadius":"20px","borderWidth":"4px 1px 4px 3px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"100%","borderStyle":"outset","height":"100%"}' v-else :src="baseUrl + item" fit="cover" class="image"></el-image>
				</el-carousel-item>
			</el-carousel>
	
			
			<div class="info" :style='{"minHeight":"560px","padding":"0px 20px 20px","margin":"40px 0 0 7%","borderColor":"#bcdbdf","borderRadius":"20px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","borderWidth":"4px 3px 4px 1px","width":"41%","borderStyle":"outset","height":"auto","order":"1"}'>
				<div class="item" :style='{"padding":"0px 20px 0 0px","boxShadow":"inset 0px 0px 0px 0px #93c8e7","margin":"10px 0px 10px","borderColor":"#b6e2fd","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230209/f86be17c39ec4de6afd148570ce1b67c.png) repeat-x right top / auto 100%,#0087a7","borderWidth":"0px 0","display":"flex","borderStyle":"dotted","justifyContent":"space-between","height":"40px"}'>
					<div :style='{"padding":"0 60px 0 20px","fontSize":"18px","lineHeight":"40px","color":"#fff","background":"url(http://codegen.caihongy.cn/20230209/9022d8ae645b41e0b62870c6884b4057.png) no-repeat right top / auto 100%,#0087a7","display":"inline-block"}'>
                    </div>
				</div>

				<div class="item" :style='{"padding":"0px 10px","boxShadow":"inset 0px 0px 0px 0px #ddd","margin":"0 20px 0px","borderColor":"#9dcde9","borderRadius":"0px","background":"none","borderWidth":"0px 0px 0px","display":"flex","borderStyle":"dotted"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#0087a7","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"130px"}'>配件分类</div>
					<div  :style='{"width":"100%","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.peijianfenlei}}</div>
				</div>
				<div class="btn" :style='{"padding":"10px 0","flexWrap":"wrap","background":"none","display":"flex"}'>
				</div>
			</div>
			
		</div>
		
		
		<el-tabs class="detail" :style='{"boxShadow":"0px 0px 0px #ddd,inset 0px 0px 0px 0px #e0f8e8","padding":"10px","margin":"60px 7% 0 7%","borderColor":"#b2e2fe","float":"right","minHeight":"440px","borderRadius":"0px","background":"rgba(255,255,255,.3)","borderWidth":"0px","flex":"1","width":"49%","borderStyle":"dotted","order":"10"}' v-model="activeName" type="border-card">
		</el-tabs>
	</div>
</div>
</template>

<script>
  import CountDown from '@/components/CountDown';
  export default {
    //数据集合
    data() {
      return {
        tablename: 'peijianfenlei',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '详情信息'
          }
        ],
        title: '',
        detailBanner: [],
        endTime: 0,
        detail: {},
        activeName: 'first',
        total: 1,
        pageSize: 5,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        rules: {
          content: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ]
        },
        buynumber: 1,
      }
    },
    created() {
        this.init();
    },
    //方法集合
    methods: {
        init() {
          this.baseUrl = this.$config.baseUrl;
          if(this.$route.query.detailObj) {
            this.detail = JSON.parse(this.$route.query.detailObj);
          }
          this.$http.get(this.tablename + '/detail/'  + this.detail.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
              this.$forceUpdate();
            }
          });


        },
      curChange(page) {
        this.getDiscussList(page);
      },
      prevClick(page) {
        this.getDiscussList(page);
      },
      nextClick(page) {
        this.getDiscussList(page);
      },
      // 下载
      download(file){
        if(!file) {
            this.$message({
              type: 'error',
              message: '文件不存在',
              duration: 1500,
            });
            return;
        }
        window.open(this.baseUrl+file)
      },


    },
    components: {
      CountDown
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.detail-preview {
	
	  .attr {
	    .el-carousel /deep/ .el-carousel__indicator button {
	      width: 0;
	      height: 0;
	      display: none;
	    }
	
	    .el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
	      border-color: none;
	    }
	  }
	
	  .detail {
	    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
	      margin-bottom: 0;
	    }
	
	    & .add .el-textarea {
	      width: auto;
	    }
	  }
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: #3086b9;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: #3086b9;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0 0 43px 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.7;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 1;
		height: 12px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #ddd;
		border-radius: 0px;
		box-shadow: inset 0px 0px 0px 0px #dcedf8;
		top: 1px;
		left: 1px;
		background: none;
		width: 40px;
		justify-content: center;
		border-width: 0 1px 0 0;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease i {
		color: #333;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #ddd;
		right: 1px;
		border-radius: 0;
		box-shadow: inset 0px 0px 0px 0px #dcedf8;
		top: 1px;
		background: none;
		width: 40px;
		justify-content: center;
		border-width: 0 0 0 1px;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__increase i {
		color: #333;
		font-size: 14px;
	}
	
	.attr .el-input-number /deep/ .el-input .el-input__inner {
		padding: 0 40px;
		color: #666;
		display: inline-block;
		font-size: 14px;
		border-color: #ddd;
		line-height: 40px;
		border-radius: 0px;
		outline: none;
		background: none;
		width: 100%;
		border-width: 1px;
		border-style: solid;
		text-align: center;
		height: 40px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
		border-radius: 0px;
		padding: 0 20px;
		margin: 0;
		background: #fff;
		display: flex;
		width: 100%;
		border-color: #e4e7ed;
		border-width: 0;
		border-style: solid;
		text-align: center;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
		padding: 0 15px;
		margin: 0px 10px 10px 0;
		color: #333;
		font-weight: 500;
		display: inline-block;
		font-size: 14px;
		border-color: #83c1e6;
		line-height: 44px;
		border-radius: 20px 0 20px 0px;
		background: linear-gradient(320deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%);
		width: auto;
		border-width: 0px 0px ;
		position: relative;
		border-style: dotted;
		list-style: none;
		text-align: center;
		min-width: 110px;
		height: 44px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
		border-radius: 20px 0 20px 0px;
		padding: 0 15px;
		box-shadow: 0px 6px 8px -2px #448290;
		margin: 0px 10px 10px 0;
		color: #000;
		background: linear-gradient(230deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%);
		width: auto;
		border-color: #ddf2fe;
		line-height: 44px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
		border: 0;
		padding: 0 15px;
		margin: 0px 10px 10px 0;
		color: #000;
		border-color: #ddf2fe;
		line-height: 44px;
		border-radius: 20px 0 20px 0px;
		box-shadow: 0px 6px 8px -2px #448290;
		background: linear-gradient(230deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%);
		width: auto;
		border-width: 0;
		border-style: dotted;
		text-align: center;
		min-width: 110px;
		height: 44px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
		padding: 15px;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		width: 80px;
		font-size: 14px;
		line-height: 40px;
		text-align: right;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
		padding: 4px 12px;
		color: #333;
		font-size: 14px;
		border-color: #ddd;
		min-height: 150px;
		line-height: 32px;
		border-radius: 20px;
		box-shadow: 0 0 0px rgba(64, 158, 255, .5);
		outline: none;
		background: none;
		flex: 1;
		width: auto;
		border-width: 1px;
		border-style: solid;
		min-width: 500px;
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
