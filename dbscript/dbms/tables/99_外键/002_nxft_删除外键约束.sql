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
-- ��Ͷ����
--
  alter table nxft.nxft_subject
   drop constraint fk_nxft_subject_person ;

  alter table nxft.nxft_subject
   drop constraint fk_nxft_subject_type ;
   
  alter table nxft.nxft_subject
   drop constraint fk_nxft_subject_circle ;   
   
   
--
-- ����Ȧ����ǩԼ
--
  alter table nxft.d_circle_kitchen
   drop constraint fk_d_circle_kitchen_circle ; 
   
  alter table nxft.d_circle_kitchen
   drop constraint fk_d_circle_kitchen_kitchen ; 
   
 alter table nxft.d_circle_kitchen
   drop constraint fk_d_circle_kitchen_kteam ;   
      
--
-- �������ñ�
--
  alter table nxft.meal_set
   drop constraint fk_meal_set_kitchen ; 
   
  alter table nxft.meal_set
   drop constraint fk_meal_set_kteam ;   

--
-- ���װ��ŵ���
--
  alter table nxft.meal_schenote
   drop constraint fk_meal_schenote_kitchen ;
   
  alter table nxft.meal_schenote
   drop constraint fk_meal_schenote_kteam ;    
   
--
-- ÿ����ױ�
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
-- ��Ͷ�����
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
-- ���͵���
--   
 alter table nxft.delive_note
   drop constraint fk_delive_note_kitchen ;
   
 alter table nxft.delive_note
   drop constraint fk_delive_note_kteam ;    
   
  alter table nxft.delive_note
   drop constraint fk_delive_note_circle ;
   
--
-- ���͵���ϸ��
--
  alter table nxft.delive_detail
   drop constraint fk_delive_detail_note ;
   
  alter table nxft.delive_detail
   drop constraint fk_delive_detail_meal ;

--
-- ��Ͷ�������׼����
--
  alter table nxft.d_subject_assistance
   drop constraint fk_d_subject_assistance_circle;
   
  alter table nxft.d_subject_assistance
   drop constraint fk_d_subject_assistance_type;
 
  alter table nxft.d_subject_assistance
   drop constraint fk_d_subject_assistance_meal;
 
--
-- ��ͷ�����Դ��
--
  alter table nxft.sis_service_resource
   drop constraint fk_sis_service_resource_circle ;
   
 --
-- ���͵�������־��
--

 alter table nxft.delive_create_log
   drop constraint fk_delive_create_log_meal ;

--
-- �ײͽ��ɼ�����
--
 alter table nxft.meal_disease
   drop constraint fk_meal_disease_meal ;
   
 alter table nxft.meal_disease
   drop constraint fk_meal_disease_disease ;
   
--
-- ��Ͷ��󼲲���
--
 alter table nxft.nxft_subject_disease
   drop constraint fk_nxft_subject_disease_sub ;
   
 alter table nxft.nxft_subject_disease
   drop constraint fk_nxft_subject_disease_dis ;

--
-- ��Ͷ����ס�����
--
 alter table nxft.nxft_subject_living_condi
   drop constraint fk_nxft_subject_living_sub ;
   
 alter table nxft.nxft_subject_living_condi
   drop constraint fk_nxft_subject_living_living ;
   
--
-- ��Ͷ���ʳ����ɱ�
--
 alter table nxft.nxft_subject_food_prohibit
   drop constraint fk_nxft_subject_food_sub ;
   
 alter table nxft.nxft_subject_food_prohibit
   drop constraint fk_nxft_subject_food_prohibit ;

--
-- ů�ķ��ö��������־
--
 alter table nxft.nxft_subject_sms_log
   drop constraint fk_nxft_subject_sms_log_sub ;  