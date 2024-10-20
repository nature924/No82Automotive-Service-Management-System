<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","width":"100%","alignItems":"flex-start","background":"url(http://codegen.caihongy.cn/20230210/56b31276ba0b49338bdd2a61c6f51fb1.jpg) no-repeat center bottom / 100% auto","justifyContent":"flex-end","display":"flex"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"padding":"0px 80px 180px","boxShadow":"0px 0px 0px #9cd8da,inset 0px 0px 0px 0px #e0f8e8","margin":"40px auto 60px","borderColor":"#0086a6","borderRadius":"20px","background":"url(http://codegen.caihongy.cn/20230210/169100e4b2164361a254efa3eae9f5a8.jpg) no-repeat left bottom / 100% auto,#fffdfc","borderWidth":"8px","width":"880px","minWidth":"800px","position":"relative","borderStyle":"outset","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"width":"100%","margin":"0 0 4px 0","fontSize":"20px","color":"#3086b9","textAlign":"center","fontWeight":"500"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"20px 0 40px","borderColor":"#c4deee","color":"#333","textAlign":"center","borderWidth":"0px","background":"none","width":"100%","fontSize":"20px","lineHeight":"50px","borderStyle":"dotted dashed","fontWeight":"500"}'>汽车服务管理系统注册</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yonghu'" prop="yonghuzhanghao">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>用户账号：</div>
				<el-input v-model="registerForm.yonghuzhanghao"  placeholder="请输入用户账号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yonghu'" prop="yonghuxingming">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>用户姓名：</div>
				<el-input v-model="registerForm.yonghuxingming"  placeholder="请输入用户姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yonghu'" prop="touxiang">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yonghutouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingbie">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yonghuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yonghu'" prop="lianxifangshi">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>联系方式：</div>
				<el-input v-model="registerForm.lianxifangshi"  placeholder="请输入联系方式" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yuangong'" prop="yuangonggonghao">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>员工工号：</div>
				<el-input v-model="registerForm.yuangonggonghao"  placeholder="请输入员工工号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yuangong'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yuangong'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yuangong'" prop="yuangongxingming">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>员工姓名：</div>
				<el-input v-model="registerForm.yuangongxingming"  placeholder="请输入员工姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yuangong'" prop="touxiang">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yuangongtouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yuangong'" prop="xingbie">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yuangongxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yuangong'" prop="bumenmingcheng">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>部门名称：</div>
                <el-select v-model="registerForm.bumenmingcheng" placeholder="请选择部门名称" >
                  <el-option
                      v-for="(item,index) in yuangongbumenmingchengOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yuangong'" prop="gangweimingcheng">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>岗位名称：</div>
                <el-select v-model="registerForm.gangweimingcheng" placeholder="请选择岗位名称" disabled>
                  <el-option
                      v-for="(item,index) in yuangonggangweimingchengOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yuangong'" prop="lianxifangshi">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>联系方式：</div>
				<el-input v-model="registerForm.lianxifangshi"  placeholder="请输入联系方式" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='yuangong'" prop="yuangongzhuangtai">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>员工状态：</div>
                <el-select v-model="registerForm.yuangongzhuangtai" placeholder="请选择员工状态" >
                  <el-option
                      v-for="(item,index) in yuangongyuangongzhuangtaiOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-button :style='{"border":"1px solid #0086a6","cursor":"pointer","padding":"0px","boxShadow":"0px 0px 0px #9cdde0","margin":"20px 0 10px","color":"#0086a6","display":"inline-block","minWidth":"100px","outline":"none","borderRadius":"4px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"auto","fontSize":"16px","height":"40px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"1px solid #0086a6","cursor":"pointer","padding":"0px","boxShadow":"0px 0px 0px #ccc","margin":"20px 0 0","color":"#0086a6","bottom":"110px","display":"inline-block","minWidth":"100px","outline":"none","borderRadius":"4px","left":"80px","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"auto","fontSize":"16px","position":"absolute","height":"40px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","border":"1px solid #eee","padding":"0px 10px","margin":"20px 0 0","color":"#333","bottom":"110px","display":"inline-block","textDecoration":"none","borderRadius":"4px","left":"calc(10% + 120px)","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"auto","lineHeight":"40px","fontSize":"14px","position":"absolute"}' to="/login">已有账户登录</router-link>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {
                xingbie: '',
                xingbie: '',
                bumenmingcheng: '',
                gangweimingcheng: '',
                yuangongzhuangtai: '',
            },
			rules: {},
            yonghuxingbieOptions: [],
            yuangongxingbieOptions: [],
            yuangongbumenmingchengOptions: [],
            yuangonggangweimingchengOptions: [],
            yuangongyuangongzhuangtaiOptions: [],
		}
    },
	mounted() {
	},
    created() {
      this.pageFlag = this.$route.query.pageFlag;
      this.tableName = this.$route.query.role;
      if ('yonghu' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
        this.yonghuxingbieOptions = "男,女".split(',');
      if ('yonghu' == this.tableName) {
        this.rules.lianxifangshi = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
      if ('yuangong' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
        this.yuangongxingbieOptions = "男,女".split(',');
        this.$http({
          url: `option/bumenxinxi/bumenmingcheng`,
          method: "get",
          params: {}
        }).then(({ data }) => {
          if (data && data.code === 0) {
              this.yuangongbumenmingchengOptions = data.data;
          }
        });
        this.$http({
          url: `option/gangweixinxi/gangweimingcheng`,
          method: "get",
          params: {}
        }).then(({ data }) => {
          if (data && data.code === 0) {
              this.yuangonggangweimingchengOptions = data.data;
          }
        });
      if ('yuangong' == this.tableName) {
        this.rules.lianxifangshi = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
        this.yuangongyuangongzhuangtaiOptions = "在职,离职".split(',');
    },
    //方法集合
    methods: {
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      yonghutouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      yuangongtouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
              if(`yonghu` == this.tableName && this.registerForm.yonghuzhanghao.length<3){
                this.$message.error('用户账号长度不能小于3');
                return
              }
              if(`yonghu` == this.tableName && this.registerForm.yonghuzhanghao.length>10){
                this.$message.error('用户账号长度不能大于10');
                return
              }
               if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
              if(`yonghu` == this.tableName && this.registerForm.mima.length<3){
                this.$message.error('密码长度不能小于3');
                return
              }
              if(`yonghu` == this.tableName && this.registerForm.mima.length>10){
                this.$message.error('密码长度不能大于10');
                return
              }
              if(`yuangong` == this.tableName && this.registerForm.yuangonggonghao.length<3){
                this.$message.error('员工工号长度不能小于3');
                return
              }
              if(`yuangong` == this.tableName && this.registerForm.yuangonggonghao.length>10){
                this.$message.error('员工工号长度不能大于10');
                return
              }
               if(`yuangong` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
              if(`yuangong` == this.tableName && this.registerForm.mima.length<3){
                this.$message.error('密码长度不能小于3');
                return
              }
              if(`yuangong` == this.tableName && this.registerForm.mima.length>10){
                this.$message.error('密码长度不能大于10');
                return
              }
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
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

		.el-date-editor.el-input {
			width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 20px;
						padding: 0 10px;
						box-shadow: 0px 0px 0px #a0d8db;
						outline: none;
						color: #333;
						background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
						width: 100%;
						font-size: 14px;
						border-color: #eee;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 0px solid #eacb96;
						padding: 0 10px;
						color: #333;
						font-size: 14px;
						border-color: #eee;
						border-radius: 20px;
						box-shadow: 0px 0px 0px #a0d8db;
						outline: none;
						background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
						width: 100%;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 20px;
						padding: 0 10px 0 30px;
						box-shadow: 0px 0px 0px #a0d8db;
						outline: none;
						color: #333;
						background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
						width: 100%;
						font-size: 14px;
						border-color: #eee;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 20px;
						padding: 0 10px 0 30px;
						box-shadow: 0px 0px 0px #a0d8db;
						outline: none;
						color: #333;
						background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
						width: 100%;
						font-size: 14px;
						border-color: #eee;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  color: #999;
		  		  background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  color: #999;
		  		  background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  color: #999;
		  		  background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
</style>
