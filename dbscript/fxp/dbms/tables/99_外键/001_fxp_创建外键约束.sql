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

-- *********************************************  ������� **********************
-- 
--
-- �û�΢�Ű󶨱�
--
-- alter table hbcs.p_user_wechat
--  add constraint fk_p_user_wechat_user foreign key (fuser_id) references hbcs.p_user (fuser_id);

--
-- �û�ǩ����
--

alter table fxp.p_user_signature
  add constraint fk_p_user_signature foreign key (fuser_id) references fxp.p_user (fuser_id);

--
-- �û��ֻ��ű�
--

alter table fxp.p_user_mobile
  add constraint fk_p_user_mobile foreign key (fuser_id) references fxp.p_user (fuser_id);

--
-- �û������
--

alter table fxp.p_user_email
  add constraint fk_p_user_email foreign key (fuser_id) references fxp.p_user (fuser_id);




--
-- �������
--

alter table fxp.p_todo
  add constraint fk_p_todo_circle foreign key (fgrab_circle_id) references fxp.p_circle (fcircle_id);

alter table fxp.p_todo
  add constraint fk_p_todo_user foreign key (fgrab_user_id) references fxp.p_user (fuser_id);

alter table fxp.p_todo
  add constraint fk_p_todo_node foreign key (fnote_type_id,fnode_id) references fxp.p_note_node (fnote_type_id,fnode_id);
  
--
-- �����ű�
--

alter table fxp.p_todo_team
  add constraint fk_p_todo_team_team foreign key (fteam_id,fcircle_id) references fxp.p_team (fteam_id,fcircle_id);

--
-- ���ݻ��ڱ�
--

alter table fxp.p_note_node
  add constraint fk_p_note_node_type foreign key (fnote_type_id) references fxp.p_note_type (fnote_type_id);

--
-- ����tag��
--

alter table fxp.p_note_tag
  add constraint fk_p_note_tag_node foreign key (fnote_type_id,fnode_id) references fxp.p_note_node (fnote_type_id,fnode_id);
  
--
-- ȫ��Ʊ�ݺ�
-- 

alter table fxp.p_global_bill_num
  add constraint fk_p_global_bill_num foreign key (fbill_type_id) references fxp.p_bill_type (fbill_type_id);
  

--
-- �绰�������������ı�
--
alter table fxp.p_user_answer_num
  add constraint fk_p_user_answer_num foreign key (fuser_id) references fxp.p_user (fuser_id);


--
-- �û�΢�Ű󶨱�
--
alter table fxp.p_user_wechat
  add constraint fk_p_user_wechat_user foreign key (fuser_id) references fxp.p_user (fuser_id);
  

--
-- ΢����ҵ���û���
--
alter table fxp.p_qyh_user
  add constraint fk_p_qyh_user_user foreign key (fuser_id) references fxp.p_user (fuser_id);  


--
-- ����Ա�ͻ���Ϣ�ղؼ�
--
alter table  fxp.p_favorite_person
  add constraint fk_p_favorite_person_user foreign key (fuser_id) references fxp.p_user (fuser_id);
  
alter table  fxp.p_favorite_person
  add constraint fk_p_favorite_person_person foreign key (fperson_id) references fxp.p_person (fperson_id);  


--
-- ����Ա��ͥ��Ϣ�ղؼ�
--
alter table  fxp.p_favorite_family
  add constraint fk_p_favorite_family_user foreign key (fuser_id) references fxp.p_user (fuser_id);
  
alter table  fxp.p_favorite_family
  add constraint fk_p_favorite_family_person foreign key (ffamily_id) references fxp.p_family (ffamily_id); 

--
-- ����Ա��ͼ�ղؼ�
--
alter table  fxp.p_favorite_map
  add constraint fk_p_favorite_map_user foreign key (fuser_id) references fxp.p_user (fuser_id);

--
-- �ͻ�����
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
-- ��ͥ����
--
alter table fxp.p_family
  add constraint fk_p_family_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);


alter table fxp.p_family
  add constraint fk_p_family_region foreign key (fregion_id) references fxp.p_regionalism (fregion_id);


--
-- ��ͥ��ס�����
--
alter table fxp.p_family_living_condi
  add constraint fk_p_family_living_condi_fami foreign key (ffamily_id) references fxp.p_family (ffamily_id);

alter table fxp.p_family_living_condi
  add constraint fk_p_family_living_condi_condi foreign key (fliving_condi_id) references fxp.p_living_condi (fliving_condi_id);

--
-- ��ͥ�����
--
alter table fxp.p_family_contacts
  add constraint fk_p_family_contacts_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);
  
alter table fxp.p_family_contacts
  add constraint fk_p_family_contacts_rela foreign key (ffamily_relation_id) references fxp.p_person_relation (fperson_relation_id);  
  
--
-- ��ͥ�������
--
alter table fxp.p_family_society
  add constraint fk_p_family_society_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);

alter table fxp.p_family_society
  add constraint fk_p_family_society_rela foreign key (ffamily_relation_id) references fxp.p_family_relation (ffamily_relation_id);

--
-- ��ͥ��������
--
alter table fxp.p_family_life
  add constraint fk_p_family_life_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);

alter table fxp.p_family_life
  add constraint fk_p_family_life_item foreign key (flife_item_id) references fxp.p_life_item (flife_item_id);
 
--
-- ���񼲲���
--
alter table fxp.p_person_disease
  add constraint fk_p_person_disease_person foreign key (fperson_id) references fxp.p_person (fperson_id);
 
alter table fxp.p_person_disease
  add constraint fk_p_person_disease_disease foreign key (fdisease_id) references fxp.p_hbc_disease (fdisease_id);

--
-- ����ҽ�Ʊ���������ϵ
--
alter table fxp.p_person_medical
  add constraint fk_p_person_medical_person foreign key (fperson_id) references fxp.p_person (fperson_id);

--
-- �������Ա�
--
alter table fxp.p_person_language
  add constraint fk_p_person_language_person foreign key (fperson_id) references fxp.p_person (fperson_id);  

alter table fxp.p_person_language
  add constraint fk_p_person_language_language foreign key (flanguage_id) references fxp.p_language (flanguage_id);  
  
-- 
--
-- �豸�ͺű�
--
  alter table fxp.p_device_model
    add constraint fk_p_device_model_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);
    
  alter table fxp.p_device_model
    add constraint fk_p_device_model_type foreign key (fdevice_type_id) references fxp.p_device_type (fdevice_type_id);    

--
-- �豸��
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
-- �������豸��
--
  alter table fxp.p_device_call
    add constraint fk_p_device_call_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_device_call
    add constraint fk_p_device_call_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_device_call
    add constraint fk_p_device_call_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);  
 

--
-- �Ҹ��ֻ��豸��
--
  alter table fxp.p_device_wristband
    add constraint fk_p_device_wristband_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_device_wristband
    add constraint fk_p_device_wristband_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_device_wristband
    add constraint fk_p_device_wristband_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id); 

--
-- ��λ�豸����
--
  alter table fxp.p_device_teh
    add constraint fk_p_device_teh_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_device_teh
    add constraint fk_p_device_teh_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_device_teh
    add constraint fk_p_device_teh_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id); 


--
-- �����豸���ű�
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
-- �ֻ����ű�
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
-- ��λ�ֱ��ű�
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
-- ��ͥ�豸���ű�
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
-- ���������ű�
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
-- ��ͥ����ʶ���
--
  alter table fxp.p_family_call_identify
    add constraint fk_p_family_call_identify_fam foreign key (ffamily_id) references fxp.p_family (ffamily_id);
    
--
-- ��ͥ��ע��
--
  alter table fxp.p_family_follow
    add constraint fk_p_family_follow_family foreign key (ffamily_id) references fxp.p_family (ffamily_id);
    
  alter table fxp.p_family_follow
    add constraint fk_p_family_follow_user foreign key (fuser_id) references fxp.p_user (fuser_id);    

--
-- �û���Ϣ��
--
 alter table fxp.p_user_message
   add constraint fk_p_user_message_suser foreign key (fsend_user_id) references fxp.p_user (fuser_id);

 alter table fxp.p_user_message
   add constraint fk_p_user_message_ruser foreign key (freceive_user_id) references fxp.p_user (fuser_id);

alter table fxp.p_user_message
  add constraint fk_p_user_message_node foreign key (fnote_type_id,fnode_id) references fxp.p_note_node (fnote_type_id,fnode_id);

--
-- �û�����λ�ñ�
--
 alter table fxp.p_user_location
    add constraint fk_p_user_location_user foreign key (fuser_id) references fxp.p_user (fuser_id);

--
-- �ͻ�����λ�ñ�
--
 alter table fxp.p_person_location
    add constraint fk_p_person_location_person foreign key (fperson_id) references fxp.p_person (fperson_id);

--
-- �ͻ���ͨ�ķ����Ʒ��
--
  alter table fxp.p_person_service
    add constraint fk_p_person_service_person foreign key (fperson_id) references fxp.p_person (fperson_id);

  alter table fxp.p_person_service
    add constraint fk_p_person_service_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);
    
  alter table fxp.p_person_service
    add constraint fk_p_person_service_service foreign key (fservice_id) references fxp.p_service (fservice_id);    

--
-- �ͻ��豸���ձ�
--
  alter table fxp.p_dev_recycle_person
    add constraint fk_p_dev_recycle_person foreign key (fperson_id) references fxp.p_person (fperson_id);

--
-- ���֤���������û��İ󶨹�ϵ
--
  alter table fxp.p_dev_user_idcard
    add constraint fk_p_dev_user_idcard_user foreign key (fuser_id) references fxp.p_user (fuser_id);
    

--
-- ����豸����
--
  alter table fxp.p_device_hmo
    add constraint fk_p_device_hmo_company foreign key (fcompany_id) references fxp.p_device_company (fcompany_id);

  alter table fxp.p_device_hmo
    add constraint fk_p_device_hmo_model foreign key (fdevice_model_id) references fxp.p_device_model (fdevice_model_id);
    
  alter table fxp.p_device_hmo
    add constraint fk_p_device_hmo_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id); 
    

--
-- ����豸���ű�
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
-- �����ֵ��
--
  alter table fxp.p_disease
    add constraint fk_p_disease_class foreign key (fdisease_class_id) references fxp.p_disease_class (fdisease_class_id);

--
-- ������Ҫ֢״��
--
  alter table fxp.p_disease_symptom
    add constraint fk_p_disease_symptom_disease foreign key (fdisease_id) references fxp.p_disease (fdisease_id);

--
-- ��������ָ����
--
  alter table fxp.p_disease_guide
    add constraint fk_p_disease_guide_disease foreign key (fdisease_id) references fxp.p_disease (fdisease_id);
    
--
-- ���������������ű�
-- 
  alter table fxp.p_disease_sms
    add constraint fk_p_disease_sms_disease foreign key (fdisease_id) references fxp.p_disease (fdisease_id);   

--
-- �ϰ��
--
  alter table fxp.p_boss
    add constraint fk_p_boss_user foreign key (fadmin_user_id) references fxp.p_user (fuser_id);

--
-- ����Ȧ
--
  alter table fxp.p_circle
    add constraint fk_p_circle_boss foreign key (fboss_id) references fxp.p_boss (fboss_id);
    
--
-- �������
-- 
  alter table fxp.p_team
    add constraint fk_p_team_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id); 
    
  alter table fxp.p_team
    add constraint fk_p_team_app foreign key (fapplication_id) references fxp.p_application (fapplication_id);     
    
--
-- �������Ա��
--
  alter table fxp.p_team_member
    add constraint fk_p_team_member_user foreign key (fuser_id) references fxp.p_user (fuser_id); 

  alter table fxp.p_team_member
    add constraint fk_p_team_member_team foreign key (fteam_id,fcircle_id) references fxp.p_team (fteam_id,fcircle_id);


    
--
-- ������빤����
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
-- ������Ŀ��
--
 alter table fxp.p_item
    add constraint fk_p_item_product foreign key (fproduct_id) references fxp.p_product (fproduct_id); 

--
-- ������
--
 alter table fxp.p_order
    add constraint fk_p_order_goods foreign key (fgoods_id) references fxp.p_goods (fgoods_id);
    
 alter table fxp.p_order
    add constraint fk_p_order_sell foreign key (fsell_circle_id) references fxp.p_circle (fcircle_id);
    
--
-- ��Ʒ��
--
 alter table fxp.p_goods
    add constraint fk_p_goods_business foreign key (fbusiness_id) references fxp.p_business (fbusiness_id);

 alter table fxp.p_goods
    add constraint fk_p_goods_circle foreign key (fcircle_id) references fxp.p_circle (fcircle_id);

--
-- ��Ʒ���ɱ�
--
 alter table fxp.p_goods_compose
    add constraint fk_p_goods_compose_goods foreign key (fgoods_id) references fxp.p_goods (fgoods_id);
    
 alter table fxp.p_goods_compose
    add constraint fk_p_goods_compose_product foreign key (fproduct_id) references fxp.p_product (fproduct_id);

--
-- ҵ���Ӧ�ù�ϵ��
--
alter table fxp.p_bussiness_app
    add constraint fk_p_bussiness_app_bussiness foreign key (fbusiness_id) references fxp.p_business (fbusiness_id); 
    

--
-- ����Ա��ַ��Ϣ�ղؼ�
--
  alter table fxp.p_favorite_region
    add constraint fk_p_favorite_region_user foreign key (fuser_id) references fxp.p_user (fuser_id); 

--
-- �˻����û���ϵ��
--
  alter table fxp.p_account_user
    add constraint fk_p_account_user_user foreign key (fuser_id) references fxp.p_user (fuser_id);
 
  alter table fxp.p_account_user
    add constraint fk_p_account_user_account foreign key (faccount_id) references fxp.p_account (faccount_id);
    
--
-- ȯ��
--
  alter table fxp.p_coupon
    add constraint fk_p_coupon_account foreign key (faccount_id) references fxp.p_account (faccount_id);
    
--
-- ȯ���ѵķ��񹹳ɱ�
--
    
  alter table fxp.p_voucher_compose
    add constraint fk_p_voucher_compose_voucher foreign key (fvoucher_id) references fxp.p_voucher (fvoucher_id);    

--
-- ����ȦǩԼ��ϵ��
--
 alter table fxp.p_circle_sign
    add constraint fk_p_circle_sign_provider foreign key (fprovider_circle_id) references fxp.p_circle (fcircle_id);
    
 alter table fxp.p_circle_sign
    add constraint fk_p_circle_sign_customer foreign key (fcustomer_circle_id) references fxp.p_circle (fcircle_id);
    
 alter table fxp.p_circle_sign
    add constraint fk_p_circle_sign_bussiness foreign key (fbusiness_id) references fxp.p_business (fbusiness_id); 

--
-- ����Ա�����ղؼ�
--
  alter table fxp.p_favorite_link
    add constraint fk_p_favorite_link_user foreign key (fuser_id) references fxp.p_user (fuser_id); 

--
-- ����Ŀ¼��
--
  alter table fxp.p_product
    add constraint fk_p_product_class_class foreign key (fproduct_class_id) references fxp.p_product_class (fproduct_class_id);
    
  alter table fxp.p_product
    add constraint fk_p_product_subclass_subclass foreign key (fproduct_subclass_id) references fxp.p_product_subclass (fproduct_subclass_id);

--
-- �˻�������ˮ��
--
  alter table fxp.p_account_list
    add constraint fk_p_account_list_account foreign key (faccount_id) references fxp.p_account (faccount_id); 
 
--
-- �û���¼Ĭ�Ϲ������
-- 
 alter table fxp.p_login_default_team
    add constraint fk_p_login_default_team_team foreign key (fteam_id) references fxp.p_team (fteam_id);
    
 alter table fxp.p_login_default_team
    add constraint fk_p_login_default_team_user foreign key (fuser_id) references fxp.p_user (fuser_id);
    

       