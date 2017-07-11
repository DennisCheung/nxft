/**
 * Created by yw on 2017/5/18.
 */
'use strict';
angular.module('app')
    .config(['$stateProvider','$urlRouterProvider',function ($stateProvider, $urlRouterProvider) {
        $stateProvider
          /*--------------- 选择运营商 ----------------*/
          .state('login', {
            url: '/login',
            templateUrl: 'view/login.html',
            controller: 'loginCtrl',
            data: {
              css: [
                "../css/login.css"
                ]
            }
          })
          /*--------------- 选择运营商 ----------------*/
          .state('loginAB', {
            url: '/loginAB',
            templateUrl: 'view/login-AB.html',
            controller: 'loginABCtrl',
            data: {
              css: [
                "../css/loginAB.css"
                ]
            }
          })
            /*--------------- 选择助餐点 ----------------*/
            .state('loginZcd', {
                url: '/loginZcd',
                templateUrl: 'view/login-zcd.html',
                controller: 'loginZcdCtrl',
                data: {
                    css: [
                        "../css/loginZcd.css"
                    ]
                }
            })
            /*--------------- 概况助餐数据墙页面 ----------------*/
            .state('gaikuang', {
                url: '/gaikuang',
                templateUrl: 'view/gaikuang.html',
                controller: 'gaikuangCtrl',
                data:{
                    css:[
                        "../css/gaikuang.css"
                    ]
                }
            })
            /*--------------- 用户列表 ----------------*/
            .state('useList', {
                url: '/useList',
                templateUrl: 'view/use-list.html',
                controller: 'useListCtrl',
                data:{
                    css:[
                        "../css/useList.css"
                    ]
                }
            })
            /*--------------- 概况咨询列表 ----------------*/
            .state('gaikuangNewsList', {
                url: '/gaikuangNewsList',
                templateUrl: 'view/gaikuang-news-list.html',
                controller: 'gaikuangNewsListCtrl',
                data:{
                    css:[
                        "../css/gaikuangNewsList.css"
                    ]
                }
            })
            /*--------------- 概况咨询内容 ----------------*/
            .state('gaikuangNewsArticle', {
                url: '/gaikuangNewsArticle/:did',
                templateUrl: 'view/gaikuang-news-article.html',
                controller: 'gaikuangNewsArticleCtrl',
                data:{
                    css:[
                        "../css/gaikuangNewsArticle.css"
                    ]
                }
            })
            /*--------------- 点餐2 ----------------*/
            .state('order2', {
                url: '/order2/:active',
                templateUrl: 'view/order2.html',
                controller: 'order2Ctrl',
                data:{
                    css:[
                        "../css/order2.css"
                    ]
                }
            })
            /*--------------- 概况-内容页 ----------------*/
            .state('gaikuangContent', {
                url: '/gaikuangContent',
                templateUrl: 'view/gaikuang-content.html',
                controller: 'gaikuangContentCtrl',
                data:{
                    css:[
                        "../css/gaikuangContent.css"
                    ]
                }
            })
            /*--------------- 查询-助餐点 ----------------*/
            .state('selectZcd', {
                url: '/selectZcd',
                templateUrl: 'view/select-zcd.html',
                controller: 'selectZcdCtrl',
                data:{
                    css:[
                        "../libs/Jquery/skin/jedate.css",
                        "../css/selectZcd.css"
                    ]
                }
            })
            /*---------------去下单 ----------------*/
            .state('orderLogin', {
                url: '/orderLogin',
                templateUrl: 'view/order-login.html',
                controller: 'orderLoginCtrl',
                data:{
                    css:[
                        "../css/orderLogin.css"
                    ]
                }
            })
            /*---------------查询-个人明细 ----------------*/
            .state('selectGrmx', {
                url: '/selectGrmx?name&balance&govSum&ownSum&sTName',
                templateUrl: 'view/select-grmx.html',
                controller: 'selectGrmxCtrl',
                data:{
                    css:[
                        "../css/selectgrmx.css"
                    ]
                }
            })
            /*---------------查询首页 ----------------*/
            .state('selectIndex', {
                url: '/selectIndex',
                templateUrl: 'view/select-index.html',
                controller: 'selectIndexCtrl',
                data:{
                    css:[
                        "../css/selectIndex.css"
                    ]
                }
            })
            /*---------------查询首页 ----------------*/
            .state('guidance', {
                url: '/guidance',
                templateUrl: 'view/guidance.html',
                controller: 'guidanceCtrl',
                data:{
                    css:[
                        "../css/guidance.css"
                    ]
                }
            })
            /*---------------个人明细用户列表 ----------------*/
            .state('grmxList', {
                url: '/grmxList',
                templateUrl: 'view/grmx-list.html',
                controller: 'grmxListCtrl',
                data:{
                    css:[
                        "../css/grmsList.css"
                    ]
                }
            })/*---------------高血压指导 ----------------*/
            .state('gaoxueya', {
                url: '/gaoxueya/:id',
                templateUrl: 'zhidao/gaoxueya.html',
                controller: 'gaoxueyaCtrl',
                data:{
                    css:[
                        "zhidao/css/gaoxueya.css"
                    ]
                }
            })
            /*---------------助餐点介绍 ----------------*/
            .state('zhucan', {
                url: '/zhucan/:id',
                templateUrl: 'gaikuang/zhucan.html',
                controller: 'zhucanCtrl',
                data:{
                    css:[
                        "gaikuang/css/zhucan.css"
                    ]
                }
            })
            /*---------------客户列表 ----------------*/
            .state('useDetail', {
                url: '/useDetail',
                templateUrl: 'view/use-detail.html',
                controller: 'useDetailCtrl',
                data:{
                    css:[
                        "../css/useDetail.css"
                    ]
                }
            })
            /*--------------- 管理页 ----------------*/
            .state('manageLogin', {
                url: '/manageLogin',
                templateUrl: 'view/manageLogin.html',
                controller: 'manageLoginCtrl',
                data: {
                    css: [
                        "../css/manageLogin.css"
                    ]
                }
            })
            /*--------------- 管理功能 ----------------*/
            .state('manage', {
                url: '/manage',
                templateUrl: 'view/manage.html',
                controller: 'manageCtrl',
                data: {
                    css: [
                        "../css/manage.css"
                    ]
                }
            })
            /*--------------- 管理发放功能 ----------------*/
            .state('mDelivery', {
                url: '/mDelivery',
                templateUrl: 'view/m-delivery.html',
                controller: 'mDeliveryCtrl',
                data: {
                    css: [
                        "../libs/Jquery/skin/jedate.css",
                        "../css/mDelivery.css"
                    ]
                }
            })
            /*--------------- 管理送达功能 ----------------*/
            .state('mSend', {
                url: '/mSend',
                templateUrl: 'view/m-send.html',
                controller: 'mSendCtrl',
                data: {
                    css: [
                        "../libs/Jquery/skin/jedate.css",
                        "../css/mSend.css"
                    ]
                }
            })
        ;
        $urlRouterProvider.otherwise('loginAB');
    }]);