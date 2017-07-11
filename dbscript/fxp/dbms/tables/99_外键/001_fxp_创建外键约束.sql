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

-- *********************************************  创建外键 **********************
-- 
--
-- 用户微信绑定表
--
-- alter table hbcs.p_user_wechat
--  add constraint fk_p_user_wechat_user foreign key (fuser_id) references hbcs.p_user (fuser_id);

--
-- 用户签名表
--

alter table fxp.p_user_signature
  add constraint fk_p_user_signature foreign key (fuser_id) references fxp.p_user (fuser_id);

--
-- 用户手机号表
--

alter table fxp.p_user_mobile
  add constraint fk_p_user_mobile foreign key (fuser_id) references fxp.p_user (fuser_id);

--
-- 用户邮箱表
--

alter table fxp.p_user_email
  add constraint fk_p_user_email foreign key (fuser_id) references fxp.p_user (fuser_id);




--
-- 任务项表
--

alter table fxp.p_todo
  add constraint fk_p_todo_circle foreign key (fgrab_circle_id) references fxp.p_circle (fcircle_id);

alter table fxp.p_todo
  add constraint fk_p_todo_user foreign key (fgrab_user_id) references fxp.p_user (fuser_id);

alter table fxp.p_todo
  add constraint fk_p_todo_node foreign key (fnote_type_id,fnode_id) references fxp.p_note_node (fnote_type_id,fnode_id);
  
--
-- 任务部门表
--

alter table fxp.p_todo_team
  add constraint fk_p_todo_team_team foreign key (fteam_id,fcircle_id) references fxp.p_team (fteam_id,fcircle_id);

--
-- 单据环节表
--

alter table fxp.p_note_node
  add constraint fk_p_note_node_type foreign key (fnote_type_id) references fxp.p_note_type (fnote_type_id);

--
-- 单据tag表
--

alter table fxp.p_note_tag
  add constraint fk_p_note_tag_node foreign key (fnote_type_id,fnode_id) references fxp.p_note_node (fnote_type_id,fnode_id);
  
--
-- 全局票据号
-- 

alter table fxp.p_global_bill_num
  add constraint fk_p_global_bill_num foreign key (fbill_type_id) references fxp.p_bill_type (fbill_type_id);
  

--
-- 电话请求分配呼叫中心表
--
alter table fxp.p_user_answer_num
  add constraint fk_p_user_answer_num foreign key (fuser_id) references fxp.p_user (fuser_id);


--
-- 用户微信绑定表
--
alter table fxp.p_user_wechat
  add constraint fk_p_user_wechat_user foreign key (fuser_id) references fxp.p_user (fuser_id);
  

--
-- 微信企业号用户表
--
alter table fxp.p_qyh_user
  add constraint fk_p_qyh_user_user foreign key (fuser_id) references fxp.p_user (fuser_id);  


--
-- 操作员客户信息收藏夹
--
alter table  fxp.p_favorite_person
  add constraint fk_p_favorite_person_user foreign key (fuser_id) references fxp.p_user (fuser_id);
  
alter table  fxp.p_favorite_person
  add constraint fk_p_favorite_person_person foreign key (fperson_id) references fxp.p_person (fperson_id);  


--
-- 操作员家庭信息收藏夹
--
alter table  fxp.p_favorite_family
  add constraint fk_p_favorite_family_user foreign key (fuser_id) references fxp.p_user (fuser_id);
  
alter table  fxp.p_favorite_family
  add constraint fk_p_favorite_family_person foreign key (ffamily_id) references fxp.p_family (ffamily_id); 

--
-- 操作员地图收藏夹
--
alter table  fxp.p_favorite_map
  add constraint fk_p_favorite_map_user foreign key (fuser_id) references fxp.p_user (fuser_id);

--
-- 客户档案
--
alter table fxp.p_person
  add constraint fk_p_person_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);

alter table fxp.p_person
  add constraint fk_p_person_idtype foreign key (fidtype_id) references fxp.p_id_type (fidtype_id);
  
alter table fxp.p_person
  add constraint fk_p_person_sex foreign key (fsex_id) references fxp.p_sex (fsex_id);  

alter table fxp.p_person
  add constraint fk_p_person_house foreign key (fhouse_relation_id) references fxp.p_house_relation (fhouse_relation_id); 

alter table fxp.p_person
  add constraint fk_p_person_nation foreign key (fnation_id) references fxp.p_nation (fnation_id);
  
alter table fxp.p_person
  add constraint fk_p_person_marriage foreign key (fmarriage_id) references fxp.p_marriage (fmarriage_id);  
 
alter table fxp.p_person
  add constraint fk_p_person_edu_degre foreign key (fedu_degree_id) references fxp.p_edu_degree (fedu_degree_id);  

alter table fxp.p_person
  add constraint fk_p_person_occupation foreign key (foccupation_id) references fxp.p_occupation (foccupation_id);  

alter table fxp.p_person
  add constraint fk_p_person_economy foreign key (feconomy_state_id) references fxp.p_economy_state (feconomy_state_id);  

alter table fxp.p_person
  add constraint fk_p_person_medinsu foreign key (fmedinsu_meth_id) references fxp.p_medinsu_meth (fmedinsu_meth_id);

alter table fxp.p_person
  add constraint fk_p_person_health foreign key (fhealth_state_id) references fxp.p_health_state (fhealth_state_id);
  
alter table fxp.p_person
  add constraint fk_p_person_customer foreign key (fcustomer_type_id) references fxp.p_customer_type (fcustomer_type_id);  

alter table fxp.p_person
  add constraint fk_p_person_user foreign key (fuser_id) references fxp.p_user (fuser_id);  

alter table fxp.p_person
  add constraint fk_p_person_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id); 

--
-- 家庭档案
--
alter table fxp.p_family
  add constraint fk_p_family_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);


alter table fxp.p_family
  add constraint fk_p_family_region foreign key (fregion_id) references fxp.p_regionalism (fregion_id);


--
-- 家庭居住情况表
--
alter table fxp.p_family_living_condi
  add constraint fk_p_family_living_condi_fami foreign key (ffamily_id) references fxp.p_family (ffamily_id);

alter table fxp.p_family_living_condi
  add constraint fk_p_family_living_condi_condi foreign key (fliving_condi_id) references fxp.p_living_condi (fliving_condi_id);

--
-- 家庭亲朋表
--
alter table fxp.p_family_contacts
  add constraint fk_p_family_contacts_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);
  
alter table fxp.p_family_contacts
  add constraint fk_p_family_contacts_rela foreign key (ffamily_relation_id) references fxp.p_person_relation (fperson_relation_id);  
  
--
-- 家庭社会区表
--
alter table fxp.p_family_society
  add constraint fk_p_family_society_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);

alter table fxp.p_family_society
  add constraint fk_p_family_society_rela foreign key (ffamily_relation_id) references fxp.p_family_relation (ffamily_relation_id);

--
-- 家庭生活区表
--
alter table fxp.p_family_life
  add constraint fk_p_family_life_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);

alter table fxp.p_family_life
  add constraint fk_p_family_life_item foreign key (flife_item_id) references fxp.p_life_item (flife_item_id);
 
--
-- 居民疾病表
--
alter table fxp.p_person_disease
  add constraint fk_p_person_disease_person foreign key (fperson_id) references fxp.p_person (fperson_id);
 
alter table fxp.p_person_disease
  add constraint fk_p_person_disease_disease foreign key (fdisease_id) references fxp.p_hbc_disease (fdisease_id);

--
-- 居民医疗保健服务体系
--
alter table fxp.p_person_medical
  add constraint fk_p_person_medical_person foreign key (fperson_id) references fxp.p_person (fperson_id);

--
-- 居民语言表
--
alter table fxp.p_person_language
  add constraint fk_p_person_language_person foreign key (fperson_id) references fxp.p_person (fperson_id);  

alter table fxp.p_person_language
  add constraint fk_p_person_language_language foreign key (flanguage_id) references fxp.p_language (flanguage_id);  
  
-- 
--
-- 设备型号表
--
  alter table fxp.p_device_model
    add constraint fk_p_device_model_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);
    
  alter table fxp.p_device_model
    add constraint fk_p_device_model_type foreign key (fdevice_type_id) references fxp.p_device_type (fdevice_type_id);    

--
-- 设备表
--
  alter table fxp.p_device
    add constraint fk_p_device_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_device
    add constraint fk_p_device_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_device
    add constraint fk_p_device_type foreign key (fdevice_type_id) references fxp.p_device_type (fdevice_type_id);
    
  alter table fxp.p_device
    add constraint fk_p_device_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);    
    

--
-- 呼叫器设备表
--
  alter table fxp.p_device_call
    add constraint fk_p_device_call_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_device_call
    add constraint fk_p_device_call_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_device_call
    add constraint fk_p_device_call_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);  
 

--
-- 幸福手环设备表
--
  alter table fxp.p_device_wristband
    add constraint fk_p_device_wristband_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_device_wristband
    add constraint fk_p_device_wristband_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_device_wristband
    add constraint fk_p_device_wristband_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id); 

--
-- 定位设备入库表
--
  alter table fxp.p_device_teh
    add constraint fk_p_device_teh_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_device_teh
    add constraint fk_p_device_teh_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_device_teh
    add constraint fk_p_device_teh_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id); 


--
-- 个人设备发放表
--
  alter table fxp.p_dev_issue_person
    add constraint fk_p_dev_issue_person_com foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_dev_issue_person
    add constraint fk_p_dev_issue_person_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_dev_issue_person
    add constraint fk_p_dev_issue_person_type foreign key (fdevice_type_id) references fxp.p_device_type (fdevice_type_id);
    
  alter table fxp.p_dev_issue_person
    add constraint fk_p_dev_issue_person_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);

  alter table fxp.p_dev_issue_person
    add constraint fk_p_dev_issue_person_person foreign key (fperson_id) references fxp.p_person (fperson_id);
    
  alter table fxp.p_dev_issue_person
    add constraint fk_p_dev_issue_person_device foreign key (fdevice_id) references fxp.p_device (fdevice_id);    


--
-- 手环发放表
--
  alter table fxp.p_dev_issue_wristband
    add constraint fk_p_dev_issue_wristband_com foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_dev_issue_wristband
    add constraint fk_p_dev_issue_wristband_mod foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
  
  alter table fxp.p_dev_issue_wristband
    add constraint fk_p_dev_issue_wristband_cir foreign key (fcircle_id) references fxp.p_circle (fcircle_id);

  alter table fxp.p_dev_issue_wristband
    add constraint fk_p_dev_issue_wristband_per foreign key (fperson_id) references fxp.p_person (fperson_id);
    
  alter table fxp.p_dev_issue_wristband
    add constraint fk_p_dev_issue_wristband_dev foreign key (fdevice_id) references fxp.p_device (fdevice_id);

--
-- 定位手表发放表
--
  alter table fxp.p_dev_issue_teh
    add constraint fk_p_dev_issue_teh_com foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_dev_issue_teh
    add constraint fk_p_dev_issue_teh_mod foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
  
  alter table fxp.p_dev_issue_teh
    add constraint fk_p_dev_issue_teh_cir foreign key (fcircle_id) references fxp.p_circle (fcircle_id);

  alter table fxp.p_dev_issue_teh
    add constraint fk_p_dev_issue_teh_per foreign key (fperson_id) references fxp.p_person (fperson_id);
    
  alter table fxp.p_dev_issue_teh
    add constraint fk_p_dev_issue_teh_dev foreign key (fdevice_id) references fxp.p_device (fdevice_id);



--
-- 家庭设备发放表
--
  alter table fxp.p_dev_issue_call
    add constraint fk_p_dev_issue_call_com foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_dev_issue_call
    add constraint fk_p_dev_issue_call_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_dev_issue_call
    add constraint fk_p_dev_issue_call_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);

  alter table fxp.p_dev_issue_call
    add constraint fk_p_dev_issue_call_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);

  alter table fxp.p_dev_issue_call
    add constraint fk_p_dev_issue_call_device foreign key (fdevice_id) references fxp.p_device (fdevice_id);

--
-- 呼叫器发放表
--
  alter table fxp.p_dev_issue_family
    add constraint fk_p_dev_issue_family_com foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_dev_issue_family
    add constraint fk_p_dev_issue_family_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_dev_issue_family
    add constraint fk_p_dev_issue_family_type foreign key (fdevice_type_id) references fxp.p_device_type (fdevice_type_id);
    
  alter table fxp.p_dev_issue_family
    add constraint fk_p_dev_issue_family_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);

  alter table fxp.p_dev_issue_family
    add constraint fk_p_dev_issue_family_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);

  alter table fxp.p_dev_issue_family
    add constraint fk_p_dev_issue_family_device foreign key (fdevice_id) references fxp.p_device (fdevice_id);


--
-- 家庭来电识别表
--
  alter table fxp.p_family_call_identify
    add constraint fk_p_family_call_identify_fam foreign key (ffamily_id) references fxp.p_family (ffamily_id);
    
--
-- 家庭关注者
--
  alter table fxp.p_family_follow
    add constraint fk_p_family_follow_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);
    
  alter table fxp.p_family_follow
    add constraint fk_p_family_follow_user foreign key (fuser_id) references fxp.p_user (fuser_id);    

--
-- 用户消息表
--
 alter table fxp.p_user_message
   add constraint fk_p_user_message_suser foreign key (fsend_user_id) references fxp.p_user (fuser_id);

 alter table fxp.p_user_message
   add constraint fk_p_user_message_ruser foreign key (freceive_user_id) references fxp.p_user (fuser_id);

alter table fxp.p_user_message
  add constraint fk_p_user_message_node foreign key (fnote_type_id,fnode_id) references fxp.p_note_node (fnote_type_id,fnode_id);

--
-- 用户最新位置表
--
 alter table fxp.p_user_location
    add constraint fk_p_user_location_user foreign key (fuser_id) references fxp.p_user (fuser_id);

--
-- 客户最新位置表
--
 alter table fxp.p_person_location
    add constraint fk_p_person_location_person foreign key (fperson_id) references fxp.p_person (fperson_id);

--
-- 客户开通的服务产品表
--
  alter table fxp.p_person_service
    add constraint fk_p_person_service_person foreign key (fperson_id) references fxp.p_person (fperson_id);

  alter table fxp.p_person_service
    add constraint fk_p_person_service_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);
    
  alter table fxp.p_person_service
    add constraint fk_p_person_service_service foreign key (fservice_id) references fxp.p_service (fservice_id);    

--
-- 客户设备回收表
--
  alter table fxp.p_dev_recycle_person
    add constraint fk_p_dev_recycle_person foreign key (fperson_id) references fxp.p_person (fperson_id);

--
-- 身份证读卡器与用户的绑定关系
--
  alter table fxp.p_dev_user_idcard
    add constraint fk_p_dev_user_idcard_user foreign key (fuser_id) references fxp.p_user (fuser_id);
    

--
-- 监测设备入库表
--
  alter table fxp.p_device_hmo
    add constraint fk_p_device_hmo_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_device_hmo
    add constraint fk_p_device_hmo_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_device_hmo
    add constraint fk_p_device_hmo_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id); 
    

--
-- 监测设备发放表
--
  alter table fxp.p_dev_issue_hmo
    add constraint fk_p_dev_issue_hmo_com foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_dev_issue_hmo
    add constraint fk_p_dev_issue_hmo_mod foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
  
  alter table fxp.p_dev_issue_hmo
    add constraint fk_p_dev_issue_hmo_cir foreign key (fcircle_id) references fxp.p_circle (fcircle_id);

  alter table fxp.p_dev_issue_hmo
    add constraint fk_p_dev_issue_hmo_per foreign key (fperson_id) references fxp.p_person (fperson_id);
    
  alter table fxp.p_dev_issue_hmo
    add constraint fk_p_dev_issue_hmo_dev foreign key (fdevice_id) references fxp.p_device (fdevice_id);

--
-- 疾病字典表
--
  alter table fxp.p_disease
    add constraint fk_p_disease_class foreign key (fdisease_class_id) references fxp.p_disease_class (fdisease_class_id);

--
-- 疾病主要症状表
--
  alter table fxp.p_disease_symptom
    add constraint fk_p_disease_symptom_disease foreign key (fdisease_id) references fxp.p_disease (fdisease_id);

--
-- 疾病健康指导表
--
  alter table fxp.p_disease_guide
    add constraint fk_p_disease_guide_disease foreign key (fdisease_id) references fxp.p_disease (fdisease_id);
    
--
-- 疾病健康处方短信表
-- 
  alter table fxp.p_disease_sms
    add constraint fk_p_disease_sms_disease foreign key (fdisease_id) references fxp.p_disease (fdisease_id);   

--
-- 老板表
--
  alter table fxp.p_boss
    add constraint fk_p_boss_user foreign key (fadmin_user_id) references fxp.p_user (fuser_id);

--
-- 工作圈
--
  alter table fxp.p_circle
    add constraint fk_p_circle_boss foreign key (fboss_id) references fxp.p_boss (fboss_id);
    
--
-- 工作组表
-- 
  alter table fxp.p_team
    add constraint fk_p_team_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id); 
    
  alter table fxp.p_team
    add constraint fk_p_team_app foreign key (fapplication_id) references fxp.p_application (fapplication_id);     
    
--
-- 工作组成员表
--
  alter table fxp.p_team_member
    add constraint fk_p_team_member_user foreign key (fuser_id) references fxp.p_user (fuser_id); 

  alter table fxp.p_team_member
    add constraint fk_p_team_member_team foreign key (fteam_id,fcircle_id) references fxp.p_team (fteam_id,fcircle_id);


    
--
-- 邀请加入工作组
--
  alter table fxp.invite_join_team
    add constraint fk_invite_join_team_user foreign key (fuser_id) references fxp.p_user (fuser_id); 

  alter table fxp.invite_join_team
    add constraint fk_invite_join_team_team foreign key (fteam_id,fcircle_id) references fxp.p_team (fteam_id,fcircle_id); 
    
 alter table fxp.invite_join_team
    add constraint fk_invite_join_team_team1 foreign key (fteam_id) references fxp.p_team (fteam_id); 
    
 alter table fxp.invite_join_team
    add constraint fk_invite_join_team_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);           

--
-- 服务项目表
--
 alter table fxp.p_item
    add constraint fk_p_item_product foreign key (fproduct_id) references fxp.p_product (fproduct_id); 

--
-- 订单表
--
 alter table fxp.p_order
    add constraint fk_p_order_goods foreign key (fgoods_id) references fxp.p_goods (fgoods_id);
    
 alter table fxp.p_order
    add constraint fk_p_order_sell foreign key (fsell_circle_id) references fxp.p_circle (fcircle_id);
    
--
-- 商品表
--
 alter table fxp.p_goods
    add constraint fk_p_goods_business foreign key (fbusiness_id) references fxp.p_business (fbusiness_id);

 alter table fxp.p_goods
    add constraint fk_p_goods_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);

--
-- 商品构成表
--
 alter table fxp.p_goods_compose
    add constraint fk_p_goods_compose_goods foreign key (fgoods_id) references fxp.p_goods (fgoods_id);
    
 alter table fxp.p_goods_compose
    add constraint fk_p_goods_compose_product foreign key (fproduct_id) references fxp.p_product (fproduct_id);

--
-- 业务和应用关系表
--
alter table fxp.p_bussiness_app
    add constraint fk_p_bussiness_app_bussiness foreign key (fbusiness_id) references fxp.p_business (fbusiness_id); 
    

--
-- 操作员地址信息收藏夹
--
  alter table fxp.p_favorite_region
    add constraint fk_p_favorite_region_user foreign key (fuser_id) references fxp.p_user (fuser_id); 

--
-- 账户和用户关系表
--
  alter table fxp.p_account_user
    add constraint fk_p_account_user_user foreign key (fuser_id) references fxp.p_user (fuser_id);
 
  alter table fxp.p_account_user
    add constraint fk_p_account_user_account foreign key (faccount_id) references fxp.p_account (faccount_id);
    
--
-- 券表
--
  alter table fxp.p_coupon
    add constraint fk_p_coupon_account foreign key (faccount_id) references fxp.p_account (faccount_id);
    
--
-- 券消费的服务构成表
--
    
  alter table fxp.p_voucher_compose
    add constraint fk_p_voucher_compose_voucher foreign key (fvoucher_id) references fxp.p_voucher (fvoucher_id);    

--
-- 工作圈签约关系表
--
 alter table fxp.p_circle_sign
    add constraint fk_p_circle_sign_provider foreign key (fprovider_circle_id) references fxp.p_circle (fcircle_id);
    
 alter table fxp.p_circle_sign
    add constraint fk_p_circle_sign_customer foreign key (fcustomer_circle_id) references fxp.p_circle (fcircle_id);
    
 alter table fxp.p_circle_sign
    add constraint fk_p_circle_sign_bussiness foreign key (fbusiness_id) references fxp.p_business (fbusiness_id); 

--
-- 操作员链接收藏夹
--
  alter table fxp.p_favorite_link
    add constraint fk_p_favorite_link_user foreign key (fuser_id) references fxp.p_user (fuser_id); 

--
-- 服务目录表
--
  alter table fxp.p_product
    add constraint fk_p_product_class_class foreign key (fproduct_class_id) references fxp.p_product_class (fproduct_class_id);
    
  alter table fxp.p_product
    add constraint fk_p_product_subclass_subclass foreign key (fproduct_subclass_id) references fxp.p_product_subclass (fproduct_subclass_id);

--
-- 账户交易流水表
--
  alter table fxp.p_account_list
    add constraint fk_p_account_list_account foreign key (faccount_id) references fxp.p_account (faccount_id); 
 
--
-- 用户登录默认工作组表
-- 
 alter table fxp.p_login_default_team
    add constraint fk_p_login_default_team_team foreign key (fteam_id) references fxp.p_team (fteam_id);
    
 alter table fxp.p_login_default_team
    add constraint fk_p_login_default_team_user foreign key (fuser_id) references fxp.p_user (fuser_id);
    

       