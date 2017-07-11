--
-- �����ⲿ��Լ��
--
-- �����û������û���DP�����ⲿ�����ڱ��ļ��ж���
--
-- v1. 2015.06.03

--
-- ��д�淶:
--
-- 1. ���ⲿ�����ڱ��нű�
-- 2. ������˳������
-- 3. ������֮�䱣����������
--

-- ��ѯ����﷨
/*
 select a.constraint_name, a.table_name, b.constraint_name 
 from user_constraints a, user_constraints b
 where a.constraint_type = 'R' 
 and b.constraint_type = 'P' 
 and a.r_constraint_name = b.constraint_name ;
*/
--
-- *********************************************  ɾ����� **********************
--
--
-- �û�΢�Ű󶨱�
--
-- alter table hbcs.p_user_wechat
--  drop constraint fk_p_user_wechat_user ;

--
-- �û�ǩ����
--

alter table fxp.p_user_signature
  drop constraint fk_p_user_signature ;


--
-- �û��ֻ��ű�
--

alter table fxp.p_user_mobile
  drop constraint fk_p_user_mobile ;

--
-- �û������
--

alter table fxp.p_user_email
  drop constraint fk_p_user_email ;




--
-- �������
--

alter table fxp.p_todo
  drop constraint fk_p_todo_circle ;

alter table fxp.p_todo
  drop constraint fk_p_todo_user ;

alter table fxp.p_todo
  drop constraint fk_p_todo_node ;
  
--
-- �����ű�
--

alter table fxp.p_todo_team
  drop constraint fk_p_todo_team_team ;

--
-- ���ݻ��ڱ�
--

alter table fxp.p_note_node
  drop constraint fk_p_note_node_type ;

--
-- ����tag��
--

alter table fxp.p_note_tag
  drop constraint fk_p_note_tag_node ;
  
--
-- ȫ��Ʊ�ݺ�
-- 

alter table fxp.p_global_bill_num
  drop constraint fk_p_global_bill_num ;
  

--
-- �绰�������������ı�
--
alter table fxp.p_user_answer_num
  drop constraint fk_p_user_answer_num ;


--
-- �û�΢�Ű󶨱�
--
alter table fxp.p_user_wechat
  drop constraint fk_p_user_wechat_user ;
  

--
-- ΢����ҵ���û���
--
alter table fxp.p_qyh_user
  drop constraint fk_p_qyh_user_user ;  


--
-- ����Ա�ͻ���Ϣ�ղؼ�
--
alter table  fxp.p_favorite_person
  drop constraint fk_p_favorite_person_user ;
  
alter table  fxp.p_favorite_person
  drop constraint fk_p_favorite_person_person ;  


--
-- ����Ա��ͥ��Ϣ�ղؼ�
--
alter table  fxp.p_favorite_family
  drop constraint fk_p_favorite_family_user ;
  
alter table  fxp.p_favorite_family
  drop constraint fk_p_favorite_family_person ; 

--
-- ����Ա��ͼ�ղؼ�
--
alter table  fxp.p_favorite_map
  drop constraint fk_p_favorite_map_user ;

--
-- �ͻ�����
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
-- ��ͥ����
--
alter table fxp.p_family
  drop constraint fk_p_family_circle ;


alter table fxp.p_family
  drop constraint fk_p_family_region ;


--
-- ��ͥ��ס�����
--
alter table fxp.p_family_living_condi
  drop constraint fk_p_family_living_condi_fami ;

alter table fxp.p_family_living_condi
  drop constraint fk_p_family_living_condi_condi ;

--
-- ��ͥ�����
--
alter table fxp.p_family_contacts
  drop constraint fk_p_family_contacts_family ;
  
alter table fxp.p_family_contacts
  drop constraint fk_p_family_contacts_rela ;  
  
--
-- ��ͥ�������
--
alter table fxp.p_family_society
  drop constraint fk_p_family_society_family ;

alter table fxp.p_family_society
  drop constraint fk_p_family_society_rela ;

--
-- ��ͥ��������
--
alter table fxp.p_family_life
  drop constraint fk_p_family_life_family ;

alter table fxp.p_family_life
  drop constraint fk_p_family_life_item ;
 
--
-- ���񼲲���
--
alter table fxp.p_person_disease
  drop constraint fk_p_person_disease_person ;
 
alter table fxp.p_person_disease
  drop constraint fk_p_person_disease_disease ;

--
-- ����ҽ�Ʊ���������ϵ
--
alter table fxp.p_person_medical
  drop constraint fk_p_person_medical_person ;

--
-- �������Ա�
--
alter table fxp.p_person_language
  drop constraint fk_p_person_language_person ;  

alter table fxp.p_person_language
  drop constraint fk_p_person_language_language ;  
  
-- 
--
-- �豸�ͺű�
--
  alter table fxp.p_device_model
    drop constraint fk_p_device_model_company ;
    
  alter table fxp.p_device_model
    drop constraint fk_p_device_model_type ;    

--
-- �豸��
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
-- �������豸��
--
  alter table fxp.p_device_call
    drop constraint fk_p_device_call_company ;

  alter table fxp.p_device_call
    drop constraint fk_p_device_call_model ;
    
  alter table fxp.p_device_call
    drop constraint fk_p_device_call_circle ;  
 

--
-- �Ҹ��ֻ��豸��
--
  alter table fxp.p_device_wristband
    drop constraint fk_p_device_wristband_company ;

  alter table fxp.p_device_wristband
    drop constraint fk_p_device_wristband_model ;
    
  alter table fxp.p_device_wristband
    drop constraint fk_p_device_wristband_circle ; 

--
-- ��λ�豸����
--
  alter table fxp.p_device_teh
    drop constraint fk_p_device_teh_company ;

  alter table fxp.p_device_teh
    drop constraint fk_p_device_teh_model ;
    
  alter table fxp.p_device_teh
    drop constraint fk_p_device_teh_circle ; 


--
-- �����豸���ű�
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
-- �ֻ����ű�
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
-- ��λ�ֱ��ű�
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
-- ��ͥ�豸���ű�
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
-- ���������ű�
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
-- ��ͥ����ʶ���
--
  alter table fxp.p_family_call_identify
    drop constraint fk_p_family_call_identify_fam ;
    
--
-- ��ͥ��ע��
--
  alter table fxp.p_family_follow
    drop constraint fk_p_family_follow_family ;
    
  alter table fxp.p_family_follow
    drop constraint fk_p_family_follow_user ;    

--
-- �û���Ϣ��
--
 alter table fxp.p_user_message
   drop constraint fk_p_user_message_suser ;

 alter table fxp.p_user_message
   drop constraint fk_p_user_message_ruser ;

alter table fxp.p_user_message
  drop constraint fk_p_user_message_node ;

--
-- �û�����λ�ñ�
--
 alter table fxp.p_user_location
    drop constraint fk_p_user_location_user ;

--
-- �ͻ�����λ�ñ�
--
 alter table fxp.p_person_location
    drop constraint fk_p_person_location_person ;

--
-- �ͻ���ͨ�ķ����Ʒ��
--
  alter table fxp.p_person_service
    drop constraint fk_p_person_service_person ;

  alter table fxp.p_person_service
    drop constraint fk_p_person_service_circle ;
    
  alter table fxp.p_person_service
    drop constraint fk_p_person_service_service ;    

--
-- �ͻ��豸���ձ�
--
  alter table fxp.p_dev_recycle_person
    drop constraint fk_p_dev_recycle_person ;

--
-- ���֤���������û��İ󶨹�ϵ
--
  alter table fxp.p_dev_user_idcard
    drop constraint fk_p_dev_user_idcard_user ;
    

--
-- ����豸����
--
  alter table fxp.p_device_hmo
    drop constraint fk_p_device_hmo_company ;

  alter table fxp.p_device_hmo
    drop constraint fk_p_device_hmo_model ;
    
  alter table fxp.p_device_hmo
    drop constraint fk_p_device_hmo_circle ; 
    

--
-- ����豸���ű�
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
-- �����ֵ��
--
  alter table fxp.p_disease
    drop constraint fk_p_disease_class ;

--
-- ������Ҫ֢״��
--
  alter table fxp.p_disease_symptom
    drop constraint fk_p_disease_symptom_disease ;

--
-- ��������ָ����
--
  alter table fxp.p_disease_guide
    drop constraint fk_p_disease_guide_disease ;
    
--
-- ���������������ű�
-- 
  alter table fxp.p_disease_sms
    drop constraint fk_p_disease_sms_disease ;   

--
-- �ϰ��
--
  alter table fxp.p_boss
    drop constraint fk_p_boss_user ;

--
-- ����Ȧ
--
  alter table fxp.p_circle
    drop constraint fk_p_circle_boss ;
    
    
--
-- �������
-- 
  alter table fxp.p_team
    drop constraint fk_p_team_circle ; 
    
  alter table fxp.p_team
    drop constraint fk_p_team_app ;     
    
--
-- �������Ա��
--
  alter table fxp.p_team_member
    drop constraint fk_p_team_member_user ; 

  alter table fxp.p_team_member
    drop constraint fk_p_team_member_team ;

--
-- ������빤����
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
-- ������Ŀ��
--
 alter table fxp.p_item
    drop constraint fk_p_item_product ; 

--
-- ������
--
 alter table fxp.p_order
    drop constraint fk_p_order_goods ;
    
 alter table fxp.p_order
    drop constraint fk_p_order_sell ;
    
--
-- ��Ʒ��
--
 alter table fxp.p_goods
    drop constraint fk_p_goods_business ;

 alter table fxp.p_goods
    drop constraint fk_p_goods_circle ;

--
-- ��Ʒ���ɱ�
--
 alter table fxp.p_goods_compose
    drop constraint fk_p_goods_compose_goods ;
    
 alter table fxp.p_goods_compose
    drop constraint fk_p_goods_compose_product ;

--
-- ҵ���Ӧ�ù�ϵ��
--
alter table fxp.p_bussiness_app
    drop constraint fk_p_bussiness_app_bussiness ; 
    
--
-- ����Ա��ַ��Ϣ�ղؼ�
--
  alter table fxp.p_favorite_region
    drop constraint fk_p_favorite_region_user ; 

--
-- �˻����û���ϵ��
--
  alter table fxp.p_account_user
    drop constraint fk_p_account_user_user ;
 
  alter table fxp.p_account_user
    drop constraint fk_p_account_user_account ;
    
--
-- ȯ��
--
  alter table fxp.p_coupon
    drop constraint fk_p_coupon_account ;
    
--
-- ȯ���ѵķ��񹹳ɱ�
--
  alter table fxp.p_voucher_compose
    drop constraint fk_p_voucher_compose_voucher ;

--
-- ����ȦǩԼ��ϵ��
--
 alter table fxp.p_circle_sign
    drop constraint fk_p_circle_sign_provider ;
    
 alter table fxp.p_circle_sign
    drop constraint fk_p_circle_sign_customer ;
    
 alter table fxp.p_circle_sign
    drop constraint fk_p_circle_sign_bussiness ; 
    
--
-- ����Ա�����ղؼ�
--
  alter table fxp.p_favorite_link
    drop constraint fk_p_favorite_link_user ;  


--
-- ����Ŀ¼��
--
  alter table fxp.p_product
    drop constraint fk_p_product_class_class ;
    
  alter table fxp.p_product
    drop constraint fk_p_product_subclass_subclass ;

--
-- �˻�������ˮ��
--
  alter table fxp.p_account_list
    drop constraint fk_p_account_list_account ;  
    
--
-- �û���¼Ĭ�Ϲ������
-- 
 alter table fxp.p_login_default_team
    drop constraint fk_p_login_default_team_team ;
    
 alter table fxp.p_login_default_team
    drop constraint fk_p_login_default_team_user ;
    
