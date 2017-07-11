/**
 * Created by yw on 2017/5/18.
 */
'use strict';
angular.module('app', ['ui.router','ngAnimate', 'ngCookies',"uiRouterStyles"])
    .directive('visible', function() {
        return {
            restrict: 'A',
            link: function(scope, element, attributes) {
                scope.$watch(attributes.visible, function(value){
                    element.css('visibility', value ? 'visible' : 'hidden');
                });
            }
        };
    }).filter('cut', function() {
        return function(value,length) {
            if (!value) return '';
            if(length){
                if(value.length>Number(length)){
                    return value.substr(0,Number(length))+"...";
                }else{
                    return value;
                }
            }else{
                return value+"...";
            }

        }
    }).filter('week', function() {
        return function(value) {
            if (!value) return '';
            var d=new Date(value);
            var weekday=new Array();
            weekday[0]="星期天";
            weekday[1]="星期一";
            weekday[2]="星期二";
            weekday[3]="星期三";
            weekday[4]="星期四";
            weekday[5]="星期五";
            weekday[6]="星期六";
            var n = weekday[d.getUTCDay()];
            return n;
        }
    });