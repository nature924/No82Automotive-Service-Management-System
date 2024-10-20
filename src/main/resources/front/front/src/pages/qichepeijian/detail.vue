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
                    {{detail.peijianmingcheng}}
                    </div>
					<div @click="storeup(1)" v-show="!isStoreup" :style='{"cursor":"pointer","padding":"6px 0px 0px","borderRadius":"20px","background":"none"}'><i v-if="true" :style='{"color":"#333","fontSize":"15px"}' class="el-icon-star-off"></i><span :style='{"color":"#333","fontSize":"14px"}'>点我收藏</span></div>
					<div @click="storeup(-1)" v-show="isStoreup" :style='{"cursor":"pointer","padding":"6px 0px 0px","borderRadius":"20px","background":"none"}'><i v-if="true" :style='{"color":"#333","fontSize":"15px"}' class="el-icon-star-on"></i><span :style='{"color":"#333","fontSize":"14px"}'>取消收藏</span></div>
				</div>

				<div class="item" :style='{"padding":"0px 10px","boxShadow":"inset 0px 0px 0px 0px #ddd","margin":"0 20px 0px","borderColor":"#9dcde9","borderRadius":"0px","background":"none","borderWidth":"0px 0px 0px","display":"flex","borderStyle":"dotted"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#0087a7","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"130px"}'>配件编号</div>
					<div  :style='{"width":"100%","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.peijianbianhao}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","boxShadow":"inset 0px 0px 0px 0px #ddd","margin":"0 20px 0px","borderColor":"#9dcde9","borderRadius":"0px","background":"none","borderWidth":"0px 0px 0px","display":"flex","borderStyle":"dotted"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#0087a7","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"130px"}'>配件分类</div>
					<div  :style='{"width":"100%","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.peijianfenlei}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","boxShadow":"inset 0px 0px 0px 0px #ddd","margin":"0 20px 0px","borderColor":"#9dcde9","borderRadius":"0px","background":"none","borderWidth":"0px 0px 0px","display":"flex","borderStyle":"dotted"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#0087a7","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"130px"}'>型号</div>
					<div  :style='{"width":"100%","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.xinghao}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","boxShadow":"inset 0px 0px 0px 0px #ddd","margin":"0 20px 0px","borderColor":"#9dcde9","borderRadius":"0px","background":"none","borderWidth":"0px 0px 0px","display":"flex","borderStyle":"dotted"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#0087a7","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"130px"}'>适用品牌</div>
					<div  :style='{"width":"100%","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.shiyongpinpai}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","boxShadow":"inset 0px 0px 0px 0px #ddd","margin":"0 20px 0px","borderColor":"#9dcde9","borderRadius":"0px","background":"none","borderWidth":"0px 0px 0px","display":"flex","borderStyle":"dotted"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#0087a7","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"130px"}'>适用车系</div>
					<div  :style='{"width":"100%","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.shiyongchexi}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","boxShadow":"inset 0px 0px 0px 0px #ddd","margin":"0 20px 0px","borderColor":"#9dcde9","borderRadius":"0px","background":"none","borderWidth":"0px 0px 0px","display":"flex","borderStyle":"dotted"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#0087a7","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"130px"}'>配件价格</div>
					<div  :style='{"width":"100%","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.peijianjiage}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","boxShadow":"inset 0px 0px 0px 0px #ddd","margin":"0 20px 0px","borderColor":"#9dcde9","borderRadius":"0px","background":"none","borderWidth":"0px 0px 0px","display":"flex","borderStyle":"dotted"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#0087a7","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"130px"}'>数量</div>
					<div  :style='{"width":"100%","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.shuliang}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","boxShadow":"inset 0px 0px 0px 0px #ddd","margin":"0 20px 0px","borderColor":"#9dcde9","borderRadius":"0px","background":"none","borderWidth":"0px 0px 0px","display":"flex","borderStyle":"dotted"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#0087a7","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"130px"}'>配件说明</div>
					<div  :style='{"width":"100%","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.peijianshuoming}}</div>
				</div>
				<div class="btn" :style='{"padding":"10px 0","flexWrap":"wrap","background":"none","display":"flex"}'>
					<el-button :style='{"border":"0px solid #ffc800","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#333","borderRadius":"0px","background":"#e3f3fa","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="isAuth('qichepeijian','立即购买')" @click="onAcross('peijiandingdan','','','')" type="warning">立即购买</el-button>
				</div>
			</div>
			
		</div>
		
		
		<el-tabs class="detail" :style='{"boxShadow":"0px 0px 0px #ddd,inset 0px 0px 0px 0px #e0f8e8","padding":"10px","margin":"60px 7% 0 7%","borderColor":"#b2e2fe","float":"right","minHeight":"440px","borderRadius":"0px","background":"rgba(255,255,255,.3)","borderWidth":"0px","flex":"1","width":"49%","borderStyle":"dotted","order":"10"}' v-model="activeName" type="border-card">
			<el-tab-pane label="配件详情" name="first">
				<div v-html="detail.peijianxiangqing"></div>
			</el-tab-pane>
			<el-tab-pane label="评论" name="second">
				<el-form class="add comment" :style='{"padding":"15px","margin":"0 0 20px"}' :model="form" :rules="rules" ref="form">
					<el-form-item class="item" :style='{"border":"0px solid #e6e6e6","width":"100%","borderRadius":"0px","background":"none","display":"flex","height":"auto"}' label="评论" prop="content">
						<el-input type="textarea" :rows="5" v-model="form.content" placeholder="请输入内容"></el-input>
					</el-form-item>
					<el-form-item class="btn" :style='{"width":"100%","padding":"0 0 0 20px","margin":"10px 0 0","textAlign":"center","height":"auto"}'>
						<el-button :style='{"border":"0","cursor":"pointer","padding":"0","boxShadow":"0px 6px 6px -3px #80afba","margin":"0 20px 0 0","borderColor":"#0087a7","color":"#333","outline":"none","borderRadius":"20px","background":"linear-gradient(30deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%)","borderWidth":"0px 1px 2px","width":"120px","lineHeight":"40px","fontSize":"14px","borderStyle":"solid","height":"40px"}' type="primary" @click="submitForm('form')">立即提交</el-button>
						<el-button :style='{"border":"0px solid #bbb","cursor":"pointer","padding":"0","boxShadow":"0px 6px 6px -3px #999","margin":"0 20px 0 0","borderColor":"#aaa","color":"#888","outline":"none","borderRadius":"20px","background":"linear-gradient(30deg, rgba(238,238,238,1) 0%, rgba(204,204,204,1) 28%, rgba(238,238,238,1) 68%, rgba(204,204,204,1) 100%)","borderWidth":"0px 1px 2px","width":"120px","lineHeight":"40px","fontSize":"14px","borderStyle":"solid","height":"40px"}' @click="resetForm('form')">重置</el-button>
					</el-form-item>
				</el-form>
				
				<div v-if="infoList.length" :style='{"boxShadow":"0 0px 0px 0 rgba(0, 0, 0, .1)","padding":"15px","borderColor":"#0087a7","borderRadius":"20px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","borderWidth":"1px 2px 3px 4px","borderStyle":"outset"}' class="comment">
					<div :style='{"padding":"0px 0","margin":"0 0 10px","borderColor":"#b4ebc8","alignItems":"center","borderWidth":"0 0 0px 0","width":"100%","borderStyle":"solid","height":"auto"}' v-for="item in infoList" :key="item.id">
						<div class="user" :style='{"padding":"4px","alignItems":"center","borderRadius":"4px","background":"none","display":"flex","width":"100%","height":"auto"}'>
							<el-image v-if="item.avatarurl" :style='{"width":"32px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"32px"}' :size="50" :src="baseUrl + item.avatarurl"></el-image>
							<el-image v-if="!item.avatarurl" :style='{"width":"32px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"32px"}' :size="50" :src="require('@/assets/touxiang.png')"></el-image>
							<div :style='{"color":"#333","fontSize":"16px"}' class="name">{{item.nickname}}</div>
						</div>
						<div :style='{"padding":"8px","boxShadow":"0px 26px 26px -30px #999","margin":"8px 0px 0px","borderColor":"#9dcde9","color":"#666","borderRadius":"20px","background":"#fff","borderWidth":"1px","lineHeight":"24px","fontSize":"14px","textIndent":"2em","borderStyle":"dotted"}' class="content-block-ask">
							{{item.content}}
						</div>
						<div :style='{"padding":"8px","boxShadow":"0px 26px 26px -30px #999","margin":"8px 0px 0px","borderColor":"#9dcde9","color":"#666","borderRadius":"20px","background":"#fff","borderWidth":"1px","lineHeight":"24px","fontSize":"14px","textIndent":"2em","borderStyle":"dotted"}' class="content-block-reply" v-if="item.reply">
							回复：{{item.reply}}
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
			</el-tab-pane>
			
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
        tablename: 'qichepeijian',
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
        form: {
          content: '',
          userid: localStorage.getItem('userid'),
          nickname: localStorage.getItem('username'),
          avatarurl: '',
        },
        infoList: [],
        total: 1,
        pageSize: 5,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        rules: {
          content: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ]
        },
        storeupParams: {
          name: '',
          picture: '',
          refid: 0,
          tablename: 'qichepeijian',
          userid: localStorage.getItem('userid')
        },
        isStoreup: false,
        storeupInfo: {},
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
          if(this.$route.query.storeupObj) {
            this.detail.id = JSON.parse(this.$route.query.storeupObj).refid;
          }
          this.$http.get(this.tablename + '/detail/'  + this.detail.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
              this.title = this.detail.peijianmingcheng;
              this.detailBanner = this.detail.tupian ? this.detail.tupian.split(",") : [];
              this.$forceUpdate();
            }
          });

          this.getDiscussList(1);
          this.getStoreupStatus();

        },
      onAcross(acrossTable,crossOptAudit,statusColumnName,tips,statusColumnValue){
        localStorage.setItem('crossTable',`qichepeijian`);
        localStorage.setItem('crossObj', JSON.stringify(this.detail));
        localStorage.setItem('statusColumnName',statusColumnName);
        localStorage.setItem('statusColumnValue',statusColumnValue);
        localStorage.setItem('tips',tips);
        if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
            var obj = JSON.parse(localStorage.getItem('crossObj'));
            for (var o in obj){
                if(o==statusColumnName && obj[o]==statusColumnValue){
                    this.$message({
                        type: 'success',
                        message: tips,
                        duration: 1500
                    });
                    return
                }
            }
        }
        this.$router.push({path: '/index/' + acrossTable + 'Add', query: {type: 'cross'}});
      },
      storeup(type) {
        if (type == 1 && !this.isStoreup) {
          this.storeupParams.name = this.title;
          this.storeupParams.picture = this.detailBanner[0];
          this.storeupParams.refid = this.detail.id;
          this.storeupParams.type = type;
          this.$http.post('storeup/add', this.storeupParams).then(res => {
            if (res.data.code == 0) {
              this.isStoreup = true;
              this.$message({
                type: 'success',
                message: '收藏成功!',
                duration: 1500,
              });
            }
          });
        }
        if (type == -1 && this.isStoreup) {
          this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'qichepeijian', userid: localStorage.getItem('userid')}}).then(res => {
            if (res.data.code == 0 && res.data.data.list.length > 0) {
              this.isStoreup = true;
              this.storeupInfo = res.data.data.list[0];
              let delIds = new Array();
              delIds.push(this.storeupInfo.id);
              this.$http.post('storeup/delete', delIds).then(res => {
                if (res.data.code == 0) {
                  this.isStoreup = false;
                  this.$message({
                    type: 'success',
                    message: '取消成功!',
                    duration: 1500,
                  });
                }
              });
            }
          });
        }
      },
      getStoreupStatus(){
        if(localStorage.getItem("Token")) {
            this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'qichepeijian', userid: localStorage.getItem('userid')}}).then(res => {
              if (res.data.code == 0 && res.data.data.list.length > 0) {
                this.isStoreup = true;
                this.storeupInfo = res.data.data.list[0];
              }
            });
        }
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
      getDiscussList(page) {
        this.$http.get('discussqichepeijian/list', {params: {page, limit: this.pageSize, refid: this.detail.id}}).then(res => {
          if (res.data.code == 0) {
            this.infoList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = res.data.data.pageSize;this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
            this.totalPage = res.data.data.totalPage;
          }
        });
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.form.refid = this.detail.id;
            this.form.avatarurl = localStorage.getItem('headportrait')?localStorage.getItem('headportrait'):'';
            this.$http.post('discussqichepeijian/add', this.form).then(res => {
              if (res.data.code == 0) {
                this.form.content = '';
                this.getDiscussList(1);
                this.$message({
                  type: 'success',
                  message: '评论成功!',
                  duration: 1500,
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
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
