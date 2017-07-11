--
-- �ͻ�������
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
-- V1.1 2015.05.19 del by wing   fmanageunit_name    �������id��ȡ���������
-- V1.2 2015.06.02 del by wing   fpassword    �û����룬�Ƶ�p_user�� 
-- V1.2 2015.06.02 add by wing   fuser_id    �û����룬���û�id 
-- V1.3 2015.06.25 add by wing   ���������� ���ᡢ��ϵ����������ϵ�绰 �Ƶ�person��
-- V1.4 2015.07.29 del by wing   ɾ��user_id �û��Ϳͻ�Ϊ�󶨹�ϵ
-- V1.5 2016.09.10 add by wing   ������Ӫ��id  foperator_id
-- V1.6 2016.10.10 add by wing   ���ñ�����Ϊ�ͻ��������Ƶ�fxp��
--
--   
-- drop table fxp.p_person;
create table  fxp.p_person (
-- +-----------------------------+--------------+-----------+
   fperson_id                    varchar2(32)   not null,   -- ����ID�� 
   fperson_code                  varchar2(32)   not null,   -- �����ţ����񽨵�ʱ�ı�š�
   fuser_id                      varchar2(32),              -- �û�id
   --
   -- ���˻�����Ϣ
   -- 
   fperson_name                  varchar2(50)   not null,   --  ��������
   fidtype_id                    varchar2(32),              --  ֤�����id ->p_id_typ
   fidtype_name                  varchar2(30),              --  ֤���������     ΢��Ĭ�϶������֤
   fid_no                        varchar2(30),              --  ֤����ţ����֤��
   fsex_id                       varchar2(32),              --  �Ա�id    1�� 2Ů 3δ֪
   fsex_name                     varchar2(30),              --  �Ա�����
   fbirth_date                   date,                      --  ��������, ����ͨ���������ڼ��������
   --
   -- ��ͥ
   -- 
   ffamily_id                    varchar2(32)   not null,   --  ��ͥid
   fhouse_relation_id            varchar2(32)   not null,   --  �뻧����ϵID
   fhouse_relation_name          varchar2(30)   not null,   --  �뻧����ϵ����   
   --
   -- ��չ��Ϣ
   --
   fis_native                    char(1),                   -- �Ƿ񱾵ػ��������У�Y/N
   fregister_addr                varchar2(50),              -- ������ַ
   fnation_id                    varchar2(32),              -- ����id��->�����ֵ��, Ĭ�Ϻ���
   fnation_name                  varchar2(30),              -- ��������
   fmarriage_id                  varchar2(32),              -- ����״��id��->�����ֵ��
   fmarriage_name                varchar2(30),              -- ����״������
   fedu_degree_id                varchar2(32),              -- �Ļ��̶�id��->�����ֵ��
   fedu_degree_name              varchar2(30),              -- �Ļ��̶�����
   foccupation_id                varchar2(32),              -- ְҵid��->�����ֵ��
   foccupation_name              varchar2(30),              -- ְҵ����  
   flanguage_name                varchar2(30),              -- ��ѡ���ճ���ͨ�������ģ��ö��ŷָ�
   fphoto_id                     varchar2(32),              -- ��Ƭid
   feconomy_state_id             varchar2(32),              -- ����״��id
   feconomy_state_name           varchar2(30),              -- ����״������
   --
   -- ��ϵ��Ϣ
   --
   -- fperson_email              varchar2(30),              --  ����������
   fperson_mobile                varchar2(30),              --  �����ֻ�
   fworkunit_name                varchar2(50),              --  ������λ����
   -- fcontact_name              varchar2(50),              --  [V1.3] ��ϵ������
   -- fcontact_phone             varchar2(30),              --  [V1.3] ��ϵ�绰   
   -- 
   -- ҽ�ƴ���
   --
   fmedinsu_meth_id               varchar2(32),             -- ҽ�Ʊ��շ�ʽid
   fmedinsu_meth_name             varchar2(30),             -- ҽ�Ʊ��շ�ʽ  ����
   --
   -- ����״��
   --
   fhealth_state_id               varchar2(32),             -- ����״��id
   fhealth_state_name             varchar2(30),             -- ����״������
   fperson_disease                varchar2(50),             -- �������������ƶ��ŷָ�
   fperson_desc                   varchar2(256),            -- ���˱�ע     
   --
   -- ��������
   --
   fcustomer_type_id              varchar2(32),             -- �ͻ�����id
   fcustomer_type_name            varchar2(30),             -- �ͻ�������������
   --
   -- ��������Ȧ
   --   
   fcircle_id                     varchar2(32)   not null,   -- ����Ȧid
   flast_service_date             date default sysdate not null,  -- ����������
   --
   -- ��ͨ
   --
   fregist_way                    varchar2(20)   not null,   -- *ע�᷽ʽ   SELF  ����  CM  ����  SEAT ��ϯ
   fcreate_date                   date default sysdate not null, -- ע�����ڣ�¼��ʱ��������ڣ� 
   fcreate_user_id                varchar2(32),              -- ע�����Աid
   fcreate_user_name              varchar2(30),              -- ע�����Ա����
   --
   -- ע��
   --
   fis_cancel                    char(1) default 'N'  not null, -- �Ƿ�ע��
   -- ע������
   fcancel_reason                varchar2(60),              -- ע��ԭ��
   fcancel_date                  date,                      -- ע������ʱ��
   fcancel_user_id               varchar2(32),              -- ע������Աid   
   fcancel_user_name             varchar2(30),              -- ע������Ա����   
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date default sysdate not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date default sysdate not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date default sysdate not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_person primary key (fperson_id),
   constraint uk_p_person_code unique (fperson_code),
-- constraint uk_p_person_user unique (fuser_id),
   constraint uk_p_person_idno unique (fid_no),
   constraint uk_p_person_mobile unique (fperson_mobile)
   --
   -- Լ��
   --
);

--
-- ͬ���
--

--
-- ��Ȩ
--

--
-- ����
--
 create index fxp.idx_p_person_name on fxp.p_person(fperson_name);
-- create index fxp.idx_p_person_mobile on fxp.p_person(fperson_mobile);
 create index fxp.idx_p_person_create_date on fxp.p_person(fcreate_date); 
--
-- �޸����
--

