import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import yuangongList from '../pages/yuangong/list'
import yuangongDetail from '../pages/yuangong/detail'
import yuangongAdd from '../pages/yuangong/add'
import bumenxinxiList from '../pages/bumenxinxi/list'
import bumenxinxiDetail from '../pages/bumenxinxi/detail'
import bumenxinxiAdd from '../pages/bumenxinxi/add'
import gangweixinxiList from '../pages/gangweixinxi/list'
import gangweixinxiDetail from '../pages/gangweixinxi/detail'
import gangweixinxiAdd from '../pages/gangweixinxi/add'
import qichepinpaiList from '../pages/qichepinpai/list'
import qichepinpaiDetail from '../pages/qichepinpai/detail'
import qichepinpaiAdd from '../pages/qichepinpai/add'
import rexiaoqicheList from '../pages/rexiaoqiche/list'
import rexiaoqicheDetail from '../pages/rexiaoqiche/detail'
import rexiaoqicheAdd from '../pages/rexiaoqiche/add'
import dingdanxinxiList from '../pages/dingdanxinxi/list'
import dingdanxinxiDetail from '../pages/dingdanxinxi/detail'
import dingdanxinxiAdd from '../pages/dingdanxinxi/add'
import peijianfenleiList from '../pages/peijianfenlei/list'
import peijianfenleiDetail from '../pages/peijianfenlei/detail'
import peijianfenleiAdd from '../pages/peijianfenlei/add'
import qichepeijianList from '../pages/qichepeijian/list'
import qichepeijianDetail from '../pages/qichepeijian/detail'
import qichepeijianAdd from '../pages/qichepeijian/add'
import peijiandingdanList from '../pages/peijiandingdan/list'
import peijiandingdanDetail from '../pages/peijiandingdan/detail'
import peijiandingdanAdd from '../pages/peijiandingdan/add'
import shouhouxinxiList from '../pages/shouhouxinxi/list'
import shouhouxinxiDetail from '../pages/shouhouxinxi/detail'
import shouhouxinxiAdd from '../pages/shouhouxinxi/add'
import qianzaikehuList from '../pages/qianzaikehu/list'
import qianzaikehuDetail from '../pages/qianzaikehu/detail'
import qianzaikehuAdd from '../pages/qianzaikehu/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'yuangong',
					component: yuangongList
				},
				{
					path: 'yuangongDetail',
					component: yuangongDetail
				},
				{
					path: 'yuangongAdd',
					component: yuangongAdd
				},
				{
					path: 'bumenxinxi',
					component: bumenxinxiList
				},
				{
					path: 'bumenxinxiDetail',
					component: bumenxinxiDetail
				},
				{
					path: 'bumenxinxiAdd',
					component: bumenxinxiAdd
				},
				{
					path: 'gangweixinxi',
					component: gangweixinxiList
				},
				{
					path: 'gangweixinxiDetail',
					component: gangweixinxiDetail
				},
				{
					path: 'gangweixinxiAdd',
					component: gangweixinxiAdd
				},
				{
					path: 'qichepinpai',
					component: qichepinpaiList
				},
				{
					path: 'qichepinpaiDetail',
					component: qichepinpaiDetail
				},
				{
					path: 'qichepinpaiAdd',
					component: qichepinpaiAdd
				},
				{
					path: 'rexiaoqiche',
					component: rexiaoqicheList
				},
				{
					path: 'rexiaoqicheDetail',
					component: rexiaoqicheDetail
				},
				{
					path: 'rexiaoqicheAdd',
					component: rexiaoqicheAdd
				},
				{
					path: 'dingdanxinxi',
					component: dingdanxinxiList
				},
				{
					path: 'dingdanxinxiDetail',
					component: dingdanxinxiDetail
				},
				{
					path: 'dingdanxinxiAdd',
					component: dingdanxinxiAdd
				},
				{
					path: 'peijianfenlei',
					component: peijianfenleiList
				},
				{
					path: 'peijianfenleiDetail',
					component: peijianfenleiDetail
				},
				{
					path: 'peijianfenleiAdd',
					component: peijianfenleiAdd
				},
				{
					path: 'qichepeijian',
					component: qichepeijianList
				},
				{
					path: 'qichepeijianDetail',
					component: qichepeijianDetail
				},
				{
					path: 'qichepeijianAdd',
					component: qichepeijianAdd
				},
				{
					path: 'peijiandingdan',
					component: peijiandingdanList
				},
				{
					path: 'peijiandingdanDetail',
					component: peijiandingdanDetail
				},
				{
					path: 'peijiandingdanAdd',
					component: peijiandingdanAdd
				},
				{
					path: 'shouhouxinxi',
					component: shouhouxinxiList
				},
				{
					path: 'shouhouxinxiDetail',
					component: shouhouxinxiDetail
				},
				{
					path: 'shouhouxinxiAdd',
					component: shouhouxinxiAdd
				},
				{
					path: 'qianzaikehu',
					component: qianzaikehuList
				},
				{
					path: 'qianzaikehuDetail',
					component: qianzaikehuDetail
				},
				{
					path: 'qianzaikehuAdd',
					component: qianzaikehuAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
