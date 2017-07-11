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
-- 用户签名表
--

alter table fxp.p_user_signature
  drop constraint fk_p_user_signature ;


--
-- 用户手机号表
--

alter table fxp.p_user_mobile
  drop constraint fk_p_user_mobile ;

--
-- 用户邮箱表
--

alter table fxp.p_user_email
  drop constraint fk_p_user_email ;




--
-- 任务项表
--

alter table fxp.p_todo
  drop constraint fk_p_todo_circle ;

alter table fxp.p_todo
  drop constraint fk_p_todo_user ;

alter table fxp.p_todo
  drop constraint fk_p_todo_node ;
  
--
-- 任务部门表
--

alter table fxp.p_todo_team
  drop constraint fk_p_todo_team_team ;

--
-- 单据环节表
--

alter table fxp.p_note_node
  drop constraint fk_p_note_node_type ;

--
-- 单据tag表
--

alter table fxp.p_note_tag
  drop constraint fk_p_note_tag_node ;
  
--
-- 全局票据号
-- 

alter table fxp.p_global_bill_num
  drop constraint fk_p_global_bill_num ;
  

--
-- 电话请求分配呼叫中心表
--
alter table fxp.p_user_answer_num
  drop constraint fk_p_user_answer_num ;


--
-- 用户微信绑定表
--
alter table fxp.p_user_wechat
  drop constraint fk_p_user_wechat_user ;
  

--
-- 微信企业号用户表
--
alter table fxp.p_qyh_user
  drop constraint fk_p_qyh_user_user ;  


--
-- 操作员客户信息收藏夹
--
alter table  fxp.p_favorite_person
  drop constraint fk_p_favorite_person_user ;
  
alter table  fxp.p_favorite_person
  drop constraint fk_p_favorite_person_person ;  


--
-- 操作员家庭信息收藏夹
--
alter table  fxp.p_favorite_family
  drop constraint fk_p_favorite_family_user ;
  
alter table  fxp.p_favorite_family
  drop constraint fk_p_favorite_family_person ; 

--
-- 操作员地图收藏夹
--
alter table  fxp.p_favorite_map
  drop constraint fk_p_favorite_map_user ;

--
-- 客户档案
--
alter table fxp.p_person
  drop constraint fk_p_person_family ;

alter table fxp.p_person
  drop constraint fk_p_person_idtype ;
  
alter table fxp.p_person
  drop constraint fk_p_person_sex ;  

alter table fxp.p_person
  drop constraint fk_p_person_house ; 

alter table fxp.p_person
  drop constraint fk_p_person_nation ;
  
alter table fxp.p_person
  drop constraint fk_p_person_marriage ;  
 
alter table fxp.p_person
  drop constraint fk_p_person_edu_degre ;  

alter table fxp.p_person
  drop constraint fk_p_person_occupation ; 

alter table fxp.p_person
  drop constraint fk_p_person_economy ;

alter table fxp.p_person
  drop constraint fk_p_person_medinsu ;

alter table fxp.p_person
  drop constraint fk_p_person_health ;
  
alter table fxp.p_person
  drop constraint fk_p_person_customer ;  

alter table fxp.p_person
  drop constraint fk_p_person_user ;  

alter table fxp.p_person
  drop constraint fk_p_person_circle ;

--
-- 家庭档案
--
alter table fxp.p_family
  drop constraint fk_p_family_circle ;


alter table fxp.p_family
  drop constraint fk_p_family_region ;


--
-- 家庭居住情况表
--
alter table fxp.p_family_living_condi
  drop constraint fk_p_family_living_condi_fami ;

alter table fxp.p_family_living_condi
  drop constraint fk_p_family_living_condi_condi ;

--
-- 家庭亲朋表
--
alter table fxp.p_family_contacts
  drop constraint fk_p_family_contacts_family ;
  
alter table fxp.p_family_contacts
  drop constraint fk_p_family_contacts_rela ;  
  
--
-- 家庭社会区表
--
alter table fxp.p_family_society
  drop constraint fk_p_family_society_family ;

alter table fxp.p_family_society
  drop constraint fk_p_family_society_rela ;

--
-- 家庭生活区表
--
alter table fxp.p_family_life
  drop constraint fk_p_family_life_family ;

alter table fxp.p_family_life
  drop constraint fk_p_family_life_item ;
 
--
-- 居民疾病表
--
alter table fxp.p_person_disease
  drop constraint fk_p_person_disease_person ;
 
alter table fxp.p_person_disease
  drop constraint fk_p_person_disease_disease ;

--
-- 居民医疗保健服务体系
--
alter table fxp.p_person_medical
  drop constraint fk_p_person_medical_person ;

--
-- 居民语言表
--
alter table fxp.p_person_language
  drop constraint fk_p_person_language_person ;  

alter table fxp.p_person_language
  drop constraint fk_p_person_language_language ;  
  
-- 
--
-- 设备型号表
--
  alter table fxp.p_device_model
    drop constraint fk_p_device_model_company ;
    
  alter table fxp.p_device_model
    drop constraint fk_p_device_model_type ;    

--
-- 设备表
--
  alter table fxp.p_device
    drop constraint fk_p_device_company ;

  alter table fxp.p_device
    drop constraint fk_p_device_model ;
    
  alter table fxp.p_device
    drop constraint fk_p_device_type ;
    
  alter table fxp.p_device
    drop constraint fk_p_device_circle ;    
    

--
-- 呼叫器设备表
--
  alter table fxp.p_device_call
    drop constraint fk_p_device_call_company ;

  alter table fxp.p_device_call
    drop constraint fk_p_device_call_model ;
    
  alter table fxp.p_device_call
    drop constraint fk_p_device_call_circle ;  
 

--
-- 幸福手环设备表
--
  alter table fxp.p_device_wristband
    drop constraint fk_p_device_wristband_company ;

  alter table fxp.p_device_wristband
    drop constraint fk_p_device_wristband_model ;
    
  alter table fxp.p_device_wristband
    drop constraint fk_p_device_wristband_circle ; 

--
-- 定位设备入库表
--
  alter table fxp.p_device_teh
    drop constraint fk_p_device_teh_company ;

  alter table fxp.p_device_teh
    drop constraint fk_p_device_teh_model ;
    
  alter table fxp.p_device_teh
    drop constraint fk_p_device_teh_circle ; 


--
-- 个人设备发放表
--
  alter table fxp.p_dev_issue_person
    drop constraint fk_p_dev_issue_person_com ;

  alter table fxp.p_dev_issue_person
    drop constraint fk_p_dev_issue_person_model ;
    
  alter table fxp.p_dev_issue_person
    drop constraint fk_p_dev_issue_person_type ;
    
  alter table fxp.p_dev_issue_person
    drop constraint fk_p_dev_issue_person_circle ;

  alter table fxp.p_dev_issue_person
    drop constraint fk_p_dev_issue_person_person ;
    
  alter table fxp.p_dev_issue_person
    drop constraint fk_p_dev_issue_person_device ;    


--
-- 手环发放表
--
  alter table fxp.p_dev_issue_wristband
    drop constraint fk_p_dev_issue_wristband_com ;

  alter table fxp.p_dev_issue_wristband
    drop constraint fk_p_dev_issue_wristband_mod ;
  
  alter table fxp.p_dev_issue_wristband
    drop constraint fk_p_dev_issue_wristband_cir ;

  alter table fxp.p_dev_issue_wristband
    drop constraint fk_p_dev_issue_wristband_per ;
    
  alter table fxp.p_dev_issue_wristband
    drop constraint fk_p_dev_issue_wristband_dev ;

--
-- 定位手表发放表
--
  alter table fxp.p_dev_issue_teh
    drop constraint fk_p_dev_issue_teh_com ;

  alter table fxp.p_dev_issue_teh
    drop constraint fk_p_dev_issue_teh_mod ;
  
  alter table fxp.p_dev_issue_teh
    drop constraint fk_p_dev_issue_teh_cir ;

  alter table fxp.p_dev_issue_teh
    drop constraint fk_p_dev_issue_teh_per ;
    
  alter table fxp.p_dev_issue_teh
    drop constraint fk_p_dev_issue_teh_dev ;



--
-- 家庭设备发放表
--
  alter table fxp.p_dev_issue_call
    drop constraint fk_p_dev_issue_call_com ;

  alter table fxp.p_dev_issue_call
    drop constraint fk_p_dev_issue_call_model ;
    
  alter table fxp.p_dev_issue_call
    drop constraint fk_p_dev_issue_call_circle ;

  alter table fxp.p_dev_issue_call
    drop constraint fk_p_dev_issue_call_family ;

  alter table fxp.p_dev_issue_call
    drop constraint fk_p_dev_issue_call_device ;

--
-- 呼叫器发放表
--
  alter table fxp.p_dev_issue_family
    drop constraint fk_p_dev_issue_family_com ;

  alter table fxp.p_dev_issue_family
    drop constraint fk_p_dev_issue_family_model ;
    
  alter table fxp.p_dev_issue_family
    drop constraint fk_p_dev_issue_family_type ;
    
  alter table fxp.p_dev_issue_family
    drop constraint fk_p_dev_issue_family_circle ;

  alter table fxp.p_dev_issue_family
    drop constraint fk_p_dev_issue_family_family ;

  alter table fxp.p_dev_issue_family
    drop constraint fk_p_dev_issue_family_device ;


--
-- 家庭来电识别表
--
  alter table fxp.p_family_call_identify
    drop constraint fk_p_family_call_identify_fam ;
    
--
-- 家庭关注者
--
  alter table fxp.p_family_follow
    drop constraint fk_p_family_follow_family ;
    
  alter table fxp.p_family_follow
    drop constraint fk_p_family_follow_user ;    

--
-- 用户消息表
--
 alter table fxp.p_user_message
   drop constraint fk_p_user_message_suser ;

 alter table fxp.p_user_message
   drop constraint fk_p_user_message_ruser ;

alter table fxp.p_user_message
  drop constraint fk_p_user_message_node ;

--
-- 用户最新位置表
--
 alter table fxp.p_user_location
    drop constraint fk_p_user_location_user ;

--
-- 客户最新位置表
--
 alter table fxp.p_person_location
    drop constraint fk_p_person_location_person ;

--
-- 客户开通的服务产品表
--
  alter table fxp.p_person_service
    drop constraint fk_p_person_service_person ;

  alter table fxp.p_person_service
    drop constraint fk_p_person_service_circle ;
    
  alter table fxp.p_person_service
    drop constraint fk_p_person_service_service ;    

--
-- 客户设备回收表
--
  alter table fxp.p_dev_recycle_person
    drop constraint fk_p_dev_recycle_person ;

--
-- 身份证读卡器与用户的绑定关系
--
  alter table fxp.p_dev_user_idcard
    drop constraint fk_p_dev_user_idcard_user ;
    

--
-- 监测设备入库表
--
  alter table fxp.p_device_hmo
    drop constraint fk_p_device_hmo_company ;

  alter table fxp.p_device_hmo
    drop constraint fk_p_device_hmo_model ;
    
  alter table fxp.p_device_hmo
    drop constraint fk_p_device_hmo_circle ; 
    

--
-- 监测设备发放表
--
  alter table fxp.p_dev_issue_hmo
    drop constraint fk_p_dev_issue_hmo_com ;

  alter table fxp.p_dev_issue_hmo
    drop constraint fk_p_dev_issue_hmo_mod ;
  
  alter table fxp.p_dev_issue_hmo
    drop constraint fk_p_dev_issue_hmo_cir ;

  alter table fxp.p_dev_issue_hmo
    drop constraint fk_p_dev_issue_hmo_per ;
    
  alter table fxp.p_dev_issue_hmo
    drop constraint fk_p_dev_issue_hmo_dev ;

--
-- 疾病字典表
--
  alter table fxp.p_disease
    drop constraint fk_p_disease_class ;

--
-- 疾病主要症状表
--
  alter table fxp.p_disease_symptom
    drop constraint fk_p_disease_symptom_disease ;

--
-- 疾病健康指导表
--
  alter table fxp.p_disease_guide
    drop constraint fk_p_disease_guide_disease ;
    
--
-- 疾病健康处方短信表
-- 
  alter table fxp.p_disease_sms
    drop constraint fk_p_disease_sms_disease ;   

--
-- 老板表
--
  alter table fxp.p_boss
    drop constraint fk_p_boss_user ;

--
-- 工作圈
--
  alter table fxp.p_circle
    drop constraint fk_p_circle_boss ;
    
    
--
-- 工作组表
-- 
  alter table fxp.p_team
    drop constraint fk_p_team_circle ; 
    
  alter table fxp.p_team
    drop constraint fk_p_team_app ;     
    
--
-- 工作组成员表
--
  alter table fxp.p_team_member
    drop constraint fk_p_team_member_user ; 

  alter table fxp.p_team_member
    drop constraint fk_p_team_member_team ;

--
-- 邀请加入工作组
--
  alter table fxp.invite_join_team
    drop constraint fk_invite_join_team_user ; 

  alter table fxp.invite_join_team
    drop constraint fk_invite_join_team_team ;    
 
 alter table fxp.invite_join_team
    drop constraint fk_invite_join_team_team1 ; 
    
 alter table fxp.invite_join_team
    drop constraint fk_invite_join_team_circle ;
    
--
-- 服务项目表
--
 alter table fxp.p_item
    drop constraint fk_p_item_product ; 

--
-- 订单表
--
 alter table fxp.p_order
    drop constraint fk_p_order_goods ;
    
 alter table fxp.p_order
    drop constraint fk_p_order_sell ;
    
--
-- 商品表
--
 alter table fxp.p_goods
    drop constraint fk_p_goods_business ;

 alter table fxp.p_goods
    drop constraint fk_p_goods_circle ;

--
-- 商品构成表
--
 alter table fxp.p_goods_compose
    drop constraint fk_p_goods_compose_goods ;
    
 alter table fxp.p_goods_compose
    drop constraint fk_p_goods_compose_product ;

--
-- 业务和应用关系表
--
alter table fxp.p_bussiness_app
    drop constraint fk_p_bussiness_app_bussiness ; 
    
--
-- 操作员地址信息收藏夹
--
  alter table fxp.p_favorite_region
    drop constraint fk_p_favorite_region_user ; 

--
-- 账户和用户关系表
--
  alter table fxp.p_account_user
    drop constraint fk_p_account_user_user ;
 
  alter table fxp.p_account_user
    drop constraint fk_p_account_user_account ;
    
--
-- 券表
--
  alter table fxp.p_coupon
    drop constraint fk_p_coupon_account ;
    
--
-- 券消费的服务构成表
--
  alter table fxp.p_voucher_compose
    drop constraint fk_p_voucher_compose_voucher ;

--
-- 工作圈签约关系表
--
 alter table fxp.p_circle_sign
    drop constraint fk_p_circle_sign_provider ;
    
 alter table fxp.p_circle_sign
    drop constraint fk_p_circle_sign_customer ;
    
 alter table fxp.p_circle_sign
    drop constraint fk_p_circle_sign_bussiness ; 
    
--
-- 操作员链接收藏夹
--
  alter table fxp.p_favorite_link
    drop constraint fk_p_favorite_link_user ;  


--
-- 服务目录表
--
  alter table fxp.p_product
    drop constraint fk_p_product_class_class ;
    
  alter table fxp.p_product
    drop constraint fk_p_product_subclass_subclass ;

--
-- 账户交易流水表
--
  alter table fxp.p_account_list
    drop constraint fk_p_account_list_account ;  
    
--
-- 用户登录默认工作组表
-- 
 alter table fxp.p_login_default_team
    drop constraint fk_p_login_default_team_team ;
    
 alter table fxp.p_login_default_team
    drop constraint fk_p_login_default_team_user ;
    
