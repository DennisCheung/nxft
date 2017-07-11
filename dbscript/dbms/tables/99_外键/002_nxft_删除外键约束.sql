--
-- 创建外部键约束
--
-- 其它用户到本用户（DP）的外部键不在本文件中定义
--
-- v1. 2015.06.03

--
-- 书写规范:
--
-- 1. 以外部键所在表集中脚本
-- 2. 按表名顺序排序
-- 3. 两个表之间保留两个空行
--

-- 查询外键语法
/*
 select a.constraint_name, a.table_name, b.constraint_name 
 from user_constraints a, user_constraints b
 where a.constraint_type = 'R' 
 and b.constraint_type = 'P' 
 and a.r_constraint_name = b.constraint_name ;
*/
--
-- *********************************************  删除外键 **********************
--
--
-- 用户微信绑定表
--
-- alter table hbcs.p_user_wechat
--  drop constraint fk_p_user_wechat_user ;

--
-- 配餐对象表
--
  alter table nxft.nxft_subject
   drop constraint fk_nxft_subject_person ;

  alter table nxft.nxft_subject
   drop constraint fk_nxft_subject_type ;
   
  alter table nxft.nxft_subject
   drop constraint fk_nxft_subject_circle ;   
   
   
--
-- 工作圈厨房签约
--
  alter table nxft.d_circle_kitchen
   drop constraint fk_d_circle_kitchen_circle ; 
   
  alter table nxft.d_circle_kitchen
   drop constraint fk_d_circle_kitchen_kitchen ; 
   
 alter table nxft.d_circle_kitchen
   drop constraint fk_d_circle_kitchen_kteam ;   
      
--
-- 菜谱设置表
--
  alter table nxft.meal_set
   drop constraint fk_meal_set_kitchen ; 
   
  alter table nxft.meal_set
   drop constraint fk_meal_set_kteam ;   

--
-- 菜谱安排单表
--
  alter table nxft.meal_schenote
   drop constraint fk_meal_schenote_kitchen ;
   
  alter table nxft.meal_schenote
   drop constraint fk_meal_schenote_kteam ;    
   
--
-- 每天菜谱表
--
  alter table nxft.meal_scheday
   drop constraint fk_meal_scheday_kitchen ;
   
  alter table nxft.meal_scheday
   drop constraint fk_meal_scheday_kteam;   

  alter table nxft.meal_scheday
   drop constraint fk_meal_scheday_schenote ;

  alter table nxft.meal_scheday
   drop constraint fk_meal_scheday_meal ; 
   
--
-- 配餐订单表
--
  alter table nxft.nxft_order
   drop constraint fk_nxft_order_subject ;

  alter table nxft.nxft_order
   drop constraint fk_nxft_order_kitchen ;
   
  alter table nxft.nxft_order
   drop constraint fk_nxft_order_kteam ;   
   
  alter table nxft.nxft_order
   drop constraint fk_nxft_order_circle ;   

  alter table nxft.nxft_order
   drop constraint fk_nxft_order_meal ; 

--
-- 配送单表
--   
 alter table nxft.delive_note
   drop constraint fk_delive_note_kitchen ;
   
 alter table nxft.delive_note
   drop constraint fk_delive_note_kteam ;    
   
  alter table nxft.delive_note
   drop constraint fk_delive_note_circle ;
   
--
-- 配送单明细表
--
  alter table nxft.delive_detail
   drop constraint fk_delive_detail_note ;
   
  alter table nxft.delive_detail
   drop constraint fk_delive_detail_meal ;

--
-- 配餐对象补贴标准设置
--
  alter table nxft.d_subject_assistance
   drop constraint fk_d_subject_assistance_circle;
   
  alter table nxft.d_subject_assistance
   drop constraint fk_d_subject_assistance_type;
 
  alter table nxft.d_subject_assistance
   drop constraint fk_d_subject_assistance_meal;
 
--
-- 配餐服务资源表
--
  alter table nxft.sis_service_resource
   drop constraint fk_sis_service_resource_circle ;
   
 --
-- 配送单生成日志表
--

 alter table nxft.delive_create_log
   drop constraint fk_delive_create_log_meal ;

--
-- 套餐禁忌疾病表
--
 alter table nxft.meal_disease
   drop constraint fk_meal_disease_meal ;
   
 alter table nxft.meal_disease
   drop constraint fk_meal_disease_disease ;
   
--
-- 配餐对象疾病表
--
 alter table nxft.nxft_subject_disease
   drop constraint fk_nxft_subject_disease_sub ;
   
 alter table nxft.nxft_subject_disease
   drop constraint fk_nxft_subject_disease_dis ;

--
-- 配餐对象居住情况表
--
 alter table nxft.nxft_subject_living_condi
   drop constraint fk_nxft_subject_living_sub ;
   
 alter table nxft.nxft_subject_living_condi
   drop constraint fk_nxft_subject_living_living ;
   
--
-- 配餐对象食物禁忌表
--
 alter table nxft.nxft_subject_food_prohibit
   drop constraint fk_nxft_subject_food_sub ;
   
 alter table nxft.nxft_subject_food_prohibit
   drop constraint fk_nxft_subject_food_prohibit ;

--
-- 暖心饭堂对象短信日志
--
 alter table nxft.nxft_subject_sms_log
   drop constraint fk_nxft_subject_sms_log_sub ;  