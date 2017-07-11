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
-- 配餐对象表
--
  alter table nxft.nxft_subject
   add constraint fk_nxft_subject_person foreign key (fperson_id) references fxp.p_person (fperson_id);

  alter table nxft.nxft_subject
   add constraint fk_nxft_subject_type foreign key (fsubject_type_id) references nxft.d_subject_type (fsubject_type_id);
   
  alter table nxft.nxft_subject
   add constraint fk_nxft_subject_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);   
   
--
-- 工作圈厨房签约
--
  alter table nxft.d_circle_kitchen
   add constraint fk_d_circle_kitchen_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id); 
   
  alter table nxft.d_circle_kitchen
   add constraint fk_d_circle_kitchen_kitchen foreign key (fkitchen_circle_id) references fxp.p_circle (fcircle_id);
   
  alter table nxft.d_circle_kitchen
   add constraint fk_d_circle_kitchen_kteam foreign key (fkitchen_team_id) references fxp.p_team (fteam_id);     
      
--
-- 菜谱设置表
--
  alter table nxft.meal_set
   add constraint fk_meal_set_kitchen foreign key (fkitchen_circle_id) references fxp.p_circle (fcircle_id); 
   
  alter table nxft.meal_set
   add constraint fk_meal_set_kteam foreign key (fkitchen_team_id) references fxp.p_team (fteam_id);    

--
-- 菜谱安排单表
--
  alter table nxft.meal_schenote
   add constraint fk_meal_schenote_kitchen foreign key (fkitchen_circle_id) references fxp.p_circle (fcircle_id);
   
  alter table nxft.meal_schenote
   add constraint fk_meal_schenote_kteam foreign key (fkitchen_team_id) references fxp.p_team (fteam_id); 
      
--
-- 每天菜谱表
--
  alter table nxft.meal_scheday
   add constraint fk_meal_scheday_kitchen foreign key (fkitchen_circle_id) references fxp.p_circle (fcircle_id);
   
  alter table nxft.meal_scheday
   add constraint fk_meal_scheday_kteam foreign key (fkitchen_team_id) references fxp.p_team (fteam_id);  

  alter table nxft.meal_scheday
   add constraint fk_meal_scheday_schenote foreign key (fschenote_id) references nxft.meal_schenote (fschenote_id);

  alter table nxft.meal_scheday
   add constraint fk_meal_scheday_meal foreign key (fmeal_id) references nxft.meal_set (fmeal_id); 
   
--
-- 配餐订单表
--
  alter table nxft.nxft_order
   add constraint fk_nxft_order_subject foreign key (fsubject_id) references nxft.nxft_subject (fsubject_id);

  alter table nxft.nxft_order
   add constraint fk_nxft_order_kitchen foreign key (fkitchen_circle_id) references fxp.p_circle (fcircle_id);
   
  alter table nxft.nxft_order
   add constraint fk_nxft_order_kteam foreign key (fkitchen_team_id) references fxp.p_team (fteam_id);    
   
  alter table nxft.nxft_order
   add constraint fk_nxft_order_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);   

  alter table nxft.nxft_order
   add constraint fk_nxft_order_meal foreign key (fmeal_id) references nxft.meal_set (fmeal_id); 

--
-- 配送单表
--   
 alter table nxft.delive_note
   add constraint fk_delive_note_kitchen foreign key (fkitchen_circle_id) references fxp.p_circle (fcircle_id);
   
 alter table nxft.delive_note
   add constraint fk_delive_note_kteam foreign key (fkitchen_team_id) references fxp.p_team (fteam_id);   
   
  alter table nxft.delive_note
   add constraint fk_delive_note_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);
   
--
-- 配送单明细表
--
  alter table nxft.delive_detail
   add constraint fk_delive_detail_note foreign key (fdelive_note_id) references nxft.delive_note (fdelive_note_id);
   
  alter table nxft.delive_detail
   add constraint fk_delive_detail_meal foreign key (fmeal_id) references nxft.meal_set (fmeal_id);
      
--
-- 配餐对象补贴标准设置
--
  alter table nxft.d_subject_assistance
   add constraint fk_d_subject_assistance_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);
   
  alter table nxft.d_subject_assistance
   add constraint fk_d_subject_assistance_type foreign key (fsubject_type_id) references nxft.d_subject_type (fsubject_type_id);
 
  alter table nxft.d_subject_assistance
   add constraint fk_d_subject_assistance_meal foreign key (fmeal_type_id) references nxft.d_meal_type (fmeal_type_id);

--
-- 配餐服务资源表
--
  alter table nxft.sis_service_resource
   add constraint fk_sis_service_resource_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);
   
 --
-- 配送单生成日志表
--
 alter table nxft.delive_create_log
   add constraint fk_delive_create_log_meal foreign key (fmeal_type_id) references nxft.d_meal_type (fmeal_type_id);   

--
-- 套餐禁忌疾病表
--
 alter table nxft.meal_disease
   add constraint fk_meal_disease_meal foreign key (fmeal_id) references nxft.meal_set (fmeal_id);
   
 alter table nxft.meal_disease
   add constraint fk_meal_disease_disease foreign key (fdisease_id) references fxp.p_hbc_disease (fdisease_id);
   
--
-- 配餐对象疾病表
--
 alter table nxft.nxft_subject_disease
   add constraint fk_nxft_subject_disease_sub foreign key (fsubject_id) references nxft.nxft_subject (fsubject_id);
   
 alter table nxft.nxft_subject_disease
   add constraint fk_nxft_subject_disease_dis foreign key (fdisease_id) references fxp.p_hbc_disease (fdisease_id); 

--
-- 配餐对象居住情况表
--
 alter table nxft.nxft_subject_living_condi
   add constraint fk_nxft_subject_living_sub foreign key (fsubject_id) references nxft.nxft_subject (fsubject_id);
   
 alter table nxft.nxft_subject_living_condi
   add constraint fk_nxft_subject_living_living foreign key (fliving_condi_id) references fxp.p_living_condi (fliving_condi_id);
   
--
-- 配餐对象食物禁忌表
--
 alter table nxft.nxft_subject_food_prohibit
   add constraint fk_nxft_subject_food_sub foreign key (fsubject_id) references nxft.nxft_subject (fsubject_id);
   
 alter table nxft.nxft_subject_food_prohibit
   add constraint fk_nxft_subject_food_prohibit foreign key (ffood_prohibit_id) references nxft.d_food_prohibit (ffood_prohibit_id);

--
-- 暖心饭堂对象短信日志
--
 alter table nxft.nxft_subject_sms_log
   add constraint fk_nxft_subject_sms_log_sub foreign key (fsubject_id) references nxft.nxft_subject (fsubject_id);        