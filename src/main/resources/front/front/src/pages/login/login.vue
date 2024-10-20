<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","width":"100%","alignItems":"flex-start","background":"url(http://codegen.caihongy.cn/20230210/56b31276ba0b49338bdd2a61c6f51fb1.jpg) no-repeat center bottom / 100% auto","justifyContent":"flex-end","display":"flex"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"0px 80px 180px","boxShadow":"0px 0px 0px #9cd8da,inset 0px 0px 0px 0px #e0f8e8","margin":"120px auto 120px","borderColor":"#0087a7","display":"flex","justifyContent":"center","borderRadius":"20px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230210/169100e4b2164361a254efa3eae9f5a8.jpg) no-repeat left bottom / 100% auto,#fffdfc","borderWidth":"8px","width":"880px","position":"relative","borderStyle":"outset","height":"auto"}' :rules="rules">
			<div v-if="false" :style='{"width":"100%","margin":"0 0 10px 0","fontSize":"24px","color":"#3086b9","textAlign":"center","fontWeight":"500"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"margin":"30px 0 30px","borderColor":"#eee","color":"#333","textAlign":"center","borderWidth":"0px","background":"none","width":"100%","fontSize":"20px","lineHeight":"50px","borderStyle":"solid","fontWeight":"500"}'>汽车服务管理系统登录</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 auto 10px"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"40px","fontSize":"14px","color":"#ffa100"}'>账号：</div>
				<input :style='{"border":"0px solid #eacb96","padding":"0 10px","boxShadow":"0px 0px 0px #a0d8db","borderColor":"#eee","color":"#999","borderRadius":"20px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","borderWidth":"1px","width":"100%","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="loginForm.username" placeholder="请输入账户">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 auto 10px"}' prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"40px","fontSize":"14px","color":"#ffa100"}'>密码：</div>
				<input :style='{"border":"0px solid #eacb96","padding":"0 10px","boxShadow":"0px 0px 0px #a0d8db","borderColor":"#eee","color":"#999","borderRadius":"20px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","borderWidth":"1px","width":"100%","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="loginForm.password" placeholder="请输入密码" type="password">
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"100%","margin":"20px auto"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"margin":"20px auto","flexWrap":"wrap","textAlign":"left","left":"80px","bottom":"100px","display":"flex","width":"100%","position":"absolute","justifyContent":"center"}'>
				<el-button v-if="loginType==1" :style='{"border":"1px solid #0086a6","cursor":"pointer","padding":"0","boxShadow":"0px 0px 0px #9cdde0","margin":"0 10px 20px 0","color":"#0086a6","display":"inline-block","minWidth":"100px","outline":"none","borderRadius":"4px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"auto","fontSize":"14px","height":"40px"}' @click="submitForm('loginForm')">登录</el-button>
				<el-button v-if="loginType==1" :style='{"border":"1px solid #eee","cursor":"pointer","padding":"0","boxShadow":"0px 0px 0px #ccc","margin":"0 0px","color":"#888","display":"inline-block","minWidth":"100px","outline":"none","borderRadius":"4px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"auto","fontSize":"14px","height":"40px"}' @click="resetForm('loginForm')">重置</el-button>
                <el-upload v-if="loginType==2" :action="baseUrl + 'file/upload'" :show-file-list="false" :on-success="faceLogin">
                    <el-button :style='{"border":"1px solid #0086a6","cursor":"pointer","padding":"0","boxShadow":"0px 0px 0px #9cdde0","margin":"0 10px 20px 0","color":"#0086a6","display":"inline-block","minWidth":"100px","outline":"none","borderRadius":"4px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"auto","fontSize":"14px","height":"40px"}'>人脸识别登录</el-button>
                </el-upload>
			</el-form-item>
			<div :style='{"width":"100%","margin":"20px auto","alignItems":"center","flexWrap":"wrap","background":"none","display":"flex"}'>
			<router-link :style='{"cursor":"pointer","border":"1px solid #0087a7","padding":"0","margin":"0 15px 0 0","color":"#0086a6","borderRadius":"4px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","fontSize":"14px","textDecoration":"none","lineHeight":"40px","minWidth":"100px"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">注册{{item.roleName.replace('注册','')}}</router-link>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>

export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["新增","查看","修改","删除","审核"],"menu":"员工","menuJump":"列表","tableName":"yuangong"}],"menu":"员工管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["新增","查看","修改","删除"],"menu":"部门信息","menuJump":"列表","tableName":"bumenxinxi"}],"menu":"部门信息管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["新增","查看","修改","删除"],"menu":"岗位信息","menuJump":"列表","tableName":"gangweixinxi"}],"menu":"岗位信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"汽车品牌","menuJump":"列表","tableName":"qichepinpai"}],"menu":"汽车品牌管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改","删除","查看评论"],"menu":"热销汽车","menuJump":"列表","tableName":"rexiaoqiche"}],"menu":"热销汽车管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改","删除","汽车销售业绩","销售品牌统计","日销售额统计","首页总数","首页统计"],"menu":"订单信息","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息管理"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["新增","查看","修改","删除"],"menu":"配件分类","menuJump":"列表","tableName":"peijianfenlei"}],"menu":"配件分类管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改","删除","查看评论"],"menu":"汽车配件","menuJump":"列表","tableName":"qichepeijian"}],"menu":"汽车配件管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除"],"menu":"配件订单","menuJump":"列表","tableName":"peijiandingdan"}],"menu":"配件订单管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","修改","删除"],"menu":"售后信息","menuJump":"列表","tableName":"shouhouxinxi"}],"menu":"售后信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除"],"menu":"潜在客户","menuJump":"列表","tableName":"qianzaikehu"}],"menu":"潜在客户管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"汽车资讯","tableName":"news"},{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","查看评论","立即购买"],"menu":"热销汽车列表","menuJump":"列表","tableName":"rexiaoqiche"}],"menu":"热销汽车模块"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["立即购买","查看评论","查看"],"menu":"汽车配件列表","menuJump":"列表","tableName":"qichepeijian"}],"menu":"汽车配件模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","删除","支付"],"menu":"订单信息","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["支付","删除","查看"],"menu":"配件订单","menuJump":"列表","tableName":"peijiandingdan"}],"menu":"配件订单管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看"],"menu":"售后信息","menuJump":"列表","tableName":"shouhouxinxi"}],"menu":"售后信息管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","查看评论","立即购买"],"menu":"热销汽车列表","menuJump":"列表","tableName":"rexiaoqiche"}],"menu":"热销汽车模块"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["立即购买","查看评论","查看"],"menu":"汽车配件列表","menuJump":"列表","tableName":"qichepeijian"}],"menu":"汽车配件模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["新增","查看","修改","删除","查看评论"],"menu":"热销汽车","menuJump":"列表","tableName":"rexiaoqiche"}],"menu":"热销汽车管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","汽车销售业绩","销售品牌统计","日销售额统计","首页总数","首页统计","售后管理"],"menu":"订单信息","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["新增","查看","修改","删除","查看评论"],"menu":"汽车配件","menuJump":"列表","tableName":"qichepeijian"}],"menu":"汽车配件管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看"],"menu":"配件订单","menuJump":"列表","tableName":"peijiandingdan"}],"menu":"配件订单管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","删除","修改"],"menu":"售后信息","menuJump":"列表","tableName":"shouhouxinxi"}],"menu":"售后信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"潜在客户","menuJump":"列表","tableName":"qianzaikehu"}],"menu":"潜在客户管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看"],"menu":"汽车资讯","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","查看评论","立即购买"],"menu":"热销汽车列表","menuJump":"列表","tableName":"rexiaoqiche"}],"menu":"热销汽车模块"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["立即购买","查看评论","查看"],"menu":"汽车配件列表","menuJump":"列表","tableName":"qichepeijian"}],"menu":"汽车配件模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"员工","tableName":"yuangong"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: '请输入账户', trigger: 'blur' }
				],
				password: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}]
		}
	},
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='是') {
                this.roles.push(this.roleMenus[item]);
            }
        }
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("请选择登录用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                this.$router.push('/index/center');
                this.$message({
                  message: '登录成功',
                  type: 'success',
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20230210/56b31276ba0b49338bdd2a61c6f51fb1.jpg) no-repeat center bottom / 100% auto;
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border: 0px solid #eacb96;
			border-radius: 20px;
			padding: 0 10px;
			box-shadow: 0px 0px 0px #a0d8db;
			color: #999;
			background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
			width: 100%;
			font-size: 14px;
			border-color: #eee;
			border-width: 1px;
			border-style: solid;
			height: 40px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border: 0px solid #eacb96;
			padding: 0 10px;
			color: #999;
			display: inline-block;
			vertical-align: middle;
			font-size: 14px;
			border-color: #eee;
			border-radius: 20px;
			box-shadow: 0px 0px 0px #a0d8db;
			outline: none;
			background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
			width: calc(100% - 100px);
			border-width: 1px;
			border-style: solid;
			height: 40px;
		}
		
		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: #0086a6;
			border-color: #0086a6;
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #0086a6;
			font-size: 14px;
		}
	}
</style>
