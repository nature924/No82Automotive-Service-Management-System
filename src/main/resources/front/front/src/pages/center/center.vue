<template>
<div class="center-preview" :style='{"width":"100%","padding":"40px 7% 40px","margin":"0px auto","position":"relative","background":"none"}'>
	<div class="title" :style='{"padding":"30px 0 30px","margin":"20px auto 20px","borderColor":"#9dcde9","color":"#000","textAlign":"center","borderRadius":"20px 0 20px 0px","background":"linear-gradient(320deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%)","borderWidth":"0px","width":"100%","fontSize":"32px","lineHeight":"30px","borderStyle":"dotted","fontWeight":"500"}'>{{ title }}</div>

    <el-tabs tab-position="left" :style='{"padding":"0px","margin":"40px auto","flexWrap":"wrap","background":"none","display":"block","width":"100%","justifyContent":"space-between"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="120px">
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yonghu'" label="用户账号" prop="yonghuzhanghao">
            <el-input v-model="sessionForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yonghu'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yonghu'" label="用户姓名" prop="yonghuxingming">
            <el-input v-model="sessionForm.yonghuxingming" placeholder="用户姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yonghu'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="yonghutouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px solid #eee","cursor":"pointer","minHeight":"100px","color":"#999","borderRadius":"20px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"200px","fontSize":"32px","lineHeight":"100px","height":"auto"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yonghu'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yonghu'" label="联系方式" prop="lianxifangshi">
            <el-input v-model="sessionForm.lianxifangshi" placeholder="联系方式" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yuangong'" label="员工工号" prop="yuangonggonghao">
            <el-input v-model="sessionForm.yuangonggonghao" placeholder="员工工号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yuangong'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yuangong'" label="员工姓名" prop="yuangongxingming">
            <el-input v-model="sessionForm.yuangongxingming" placeholder="员工姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yuangong'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="yuangongtouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px solid #eee","cursor":"pointer","minHeight":"100px","color":"#999","borderRadius":"20px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif)","width":"200px","fontSize":"32px","lineHeight":"100px","height":"auto"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yuangong'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yuangong'" label="部门名称">
            <el-select v-model="sessionForm.bumenmingcheng" placeholder="请选择部门名称" >
              <el-option v-for="(item, index) in dynamicProp.bumenmingcheng" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yuangong'" label="岗位名称">
            <el-select v-model="sessionForm.gangweimingcheng" placeholder="请选择岗位名称" disabled>
              <el-option v-for="(item, index) in dynamicProp.gangweimingcheng" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yuangong'" label="联系方式" prop="lianxifangshi">
            <el-input v-model="sessionForm.lianxifangshi" placeholder="联系方式" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #eee","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 10px","borderRadius":"0px","background":"none"}' v-if="userTableName=='yuangong'" label="员工状态">
            <el-select v-model="sessionForm.yuangongzhuangtai" placeholder="请选择员工状态" >
              <el-option v-for="(item, index) in dynamicProp.yuangongzhuangtai" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"50px 0 20px 0px","alignItems":"center","textAlign":"center","display":"flex","width":"100%","justifyContent":"center"}'>
            <el-button :style='{"cursor":"pointer","padding":"0px 20px","margin":"0 20px 0 0","borderColor":"#0087a7","color":"#555","minWidth":"130px","outline":"none","borderRadius":"20px","background":"linear-gradient(30deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%)","borderWidth":"0px 1px 2px","width":"auto","lineHeight":"40px","fontSize":"14px","borderStyle":"solid","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"cursor":"pointer","padding":"0px 20px","margin":"0 10px","borderColor":"#aaa","color":"#888","minWidth":"130px","outline":"none","borderRadius":"20px","background":"linear-gradient(30deg, rgba(238,238,238,1) 0%, rgba(204,204,204,1) 28%, rgba(238,238,238,1) 68%, rgba(204,204,204,1) 100%)","borderWidth":"0px 1px 2px","width":"auto","lineHeight":"40px","fontSize":"14px","borderStyle":"solid","height":"40px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
		
        <el-dialog title="用户充值" :visible.sync="dialogFormVisibleMoney" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="充值金额" label-width="120px">
              <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleMoney = false">取 消</el-button>
            <el-button type="primary" @click="chongzhi">确认充值</el-button>
          </div>
        </el-dialog>
        <el-dialog title="会员购买" :visible.sync="dialogFormVisibleVip" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="会员卡" label-width="120px">
              <el-input readonly autocomplete="off" value="￥199/年"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleVip = false">取 消</el-button>
            <el-button type="primary" @click="chongzhivip">确认支付</el-button>
          </div>
        </el-dialog>
      </el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>
</div>
</template>

<script>
  import config from '@/config/config'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
        disabled: false,
        dialogFormVisibleMoney: false,
        dialogFormVisibleVip: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('Token')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {}
      }
    },
    created() {
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'yonghuzhanghao', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'yonghuxingming', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxifangshi', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'yuangonggonghao', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'yuangongxingming', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'bumenmingcheng', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'gangweimingcheng', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxifangshi', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'yuangongzhuangtai', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'sfsh', null);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.sessionForm, 'shhf', null);
      }

      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
			if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'lianxifangshi', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
      if ('yuangong' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
			if ('yuangong' == this.userTableName) {
        this.$set(this.rules, 'lianxifangshi', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }

      this.init();
      this.getSession();
    },
    //方法集合
    methods: {
      init() {
        if ('yonghu' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
        if ('yuangong' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
        if ('yuangong' == this.userTableName) {
          this.$http.get('option/bumenxinxi/bumenmingcheng', {emulateJSON: true}).then(res => {
            if (res.data.code == 0) {
              this.dynamicProp.bumenmingcheng = res.data.data;
            }
          });
        }
        if ('yuangong' == this.userTableName) {
          this.$http.get('option/gangweixinxi/gangweimingcheng', {emulateJSON: true}).then(res => {
            if (res.data.code == 0) {
              this.dynamicProp.gangweimingcheng = res.data.data;
            }
          });
        }
        if ('yuangong' == this.userTableName) {
          this.dynamicProp.yuangongzhuangtai = '在职,离职'.split(',');
        }
      },
      getSession() {
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm = res.data.data;
            localStorage.setItem('userid', res.data.data.id);
            if(res.data.data.vip) {
                localStorage.setItem('vip', res.data.data.vip);
            }
            if(res.data.data.touxiang) {
                localStorage.setItem('headportrait', res.data.data.touxiang);
            } else if(res.data.data.headportrait) {
                localStorage.setItem('headportrait', res.data.data.headportrait);
            }
          }
        });
      },
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  message: '更新成功',
                  type: 'success',
                  duration: 1500
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      yonghutouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('yonghu' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      yuangongtouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('yuangong' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: '请输入充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: '请输入正确的充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择充值方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        this.sessionForm.money = parseInt(this.sessionForm.money) + parseInt(this.chongzhiForm.money);
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '充值成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      chongzhivip() {
        this.chongzhiForm.money == 199;
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择支付方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if(this.sessionForm.vip == '是') {
          this.$message({
            message: '您已是我们的尊贵会员。',
            type: 'success',
            duration: 1500
          });
          return;
        }
        
        this.sessionForm.vip = "是"
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '会员购买成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                localStorage.setItem('vip', this.sessionForm.vip);
                this.dialogFormVisibleVip = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '我的收藏':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
        }

        this.title = event.target.outerText;
      },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	border-radius: 0;
	padding: 0px;
	box-shadow: 0px 0px 0px #eee;
	margin: 0px 0 0 7%;
	background: #fff;
	width: 200px;
	border-color: #b3ddf6;
	border-width: 0px;
	position: relative;
	border-style: groove;
	float: right;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	margin: 0 10px 20px 0;
  	color: #333;
  	white-space: nowrap;
  	font-weight: 500;
  	font-size: 14px;
  	border-color: #b3ddf6;
  	line-height: 44px;
  	text-overflow: ellipsis;
  	border-radius: 20px 0 20px 0px;
  	box-shadow: 0px 0px 0px #eee;
  	overflow: hidden;
  	background: linear-gradient(320deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%);
  	border-width: 0 0 0px;
  	position: relative;
  	border-style: groove;
  	text-align: center;
  	min-width: 90%;
  	height: 44px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	border-radius: 20px 0 20px 0px;
  	padding: 0 10px;
  	box-shadow: 0px 6px 8px -2px #448290;
  	margin: 0 10px 20px 0;
  	color: #000;
  	background: linear-gradient(230deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%);
  	font-weight: 500;
  	font-size: 15px;
  	line-height: 44px;
  	position: relative;
  	text-align: center;
  	height: 44px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	padding: 0 10px;
  	margin: 0 10px 20px 0;
  	color: #000;
  	font-weight: 500;
  	font-size: 15px;
  	border-color: #90c7e8;
  	line-height: 44px;
  	border-radius: 20px 0 20px 0px;
  	box-shadow: 0px 6px 8px -2px #448290;
  	background: linear-gradient(230deg, rgba(172,240,255,1) 0%, rgba(46,185,218,1) 28%, rgba(160,237,255,1) 68%, rgba(46,185,218,1) 100%);
  	border-width: 0 0 0px;
  	position: relative;
  	border-style: groove;
  	text-align: center;
  	min-width: 90%;
  	height: 44px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	border-radius: 20px;
  	padding: 20px 20px 240px;
  	background: url(http://codegen.caihongy.cn/20230210/56b31276ba0b49338bdd2a61c6f51fb1.jpg) no-repeat right bottom / 180% auto,#fffdfc;
  	width: 100%;
  	border-color: #bcdbdf;
  	border-width: 4px 3px 4px 1px;
  	border-style: outset;
  	float: left;
  	height: auto;
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 120px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 120px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border-radius: 20px;
  	padding: 0 12px;
  	outline: none;
  	color: #666;
  	background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
  	width: 400px;
  	font-size: 14px;
  	border-color: #eee;
  	border-width: 1px;
  	border-style: solid;
  	height: 40px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border-radius: 20px;
  	padding: 0 12px;
  	outline: none;
  	color: #666;
  	background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
  	width: 400px;
  	font-size: 14px;
  	border-color: #eee;
  	border-width: 1px;
  	border-style: solid;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
  	border-radius: 20px;
  	padding: 0 10px 0 30px;
  	outline: none;
  	color: #666;
  	background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
  	width: 320px;
  	font-size: 14px;
  	border-color: #eee;
  	border-width: 1px;
  	border-style: solid;
  	height: 40px;
  }
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
  	border: 1px solid #eee;
  	cursor: pointer;
  	border-radius: 20px;
  	color: #999;
  	background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
  	width: 200px;
  	font-size: 32px;
  	min-height: 100px;
  	line-height: 100px;
  	text-align: center;
  	height: auto;
  }
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	padding: 0 12px;
  	margin: 0 8px 0 0;
  	color: #666;
  	display: inline-block;
  	font-size: 14px;
  	border-color: #eee;
  	border-radius: 20px;
  	outline: none;
  	background: url(http://codegen.caihongy.cn/20230210/7d53b0e6bd6b44dc87a1dcd33f7af58f.gif);
  	width: 200px;
  	border-width: 1px;
  	border-style: solid;
  	height: 40px;
  }
</style>
