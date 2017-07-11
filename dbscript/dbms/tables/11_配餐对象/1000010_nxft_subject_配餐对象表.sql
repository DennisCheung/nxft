--
-- ��Ͷ����
--
-- v1.0 2017.05.01
-- author��wing
--
-- �޸���ʷ��
-- 
--
--
-- Drop Table nxft.nxft_subject;
Create Table  nxft.nxft_subject (
-- +-----------------------------+--------------+-----------+
   fsubject_id                   varchar2(32)   not null,   -- ����id
   --
   -- ���������Ϣ
   --
   fperson_id                    varchar2(32)   not null,   -- �ͻ�ID
   fsubject_name                 varchar2(80)   not null,   -- ����
   fsex_id                       varchar2(32)   not null,   -- �Ա�id     fxp.p_sex �ֵ�
   fsex_name                     varchar2(30)   not null,   -- �Ա�name
   fidtype_id                    varchar2(32)   not null,   -- ֤�����id
   fidtype_name                  varchar2(30)   not null,   -- ֤���������
   fidcardno                     varchar2(20)   not null,   -- ���֤��
   fbirth_date                   date           not null,   -- ��������
   fcontact_phone                varchar2(30),              -- ��ϵ�绰
   fregion_id                    varchar2(32)   not null,   -- ��������ID
   fregion_name                  varchar2(80)   not null,   -- ������������
   faddress                      varchar2(200)  not null,   -- ��ϸ��ַ
   fis_native                    char(1),                   -- �Ƿ񱾵ػ���������Y/N
   fliving_condi_name            varchar2(60),              -- ��ס�������ѡ���ö��ŷָ�
   --
   -- �ͻ�����
   --
   fcircle_id                    varchar2(32)   not null,   -- �ͻ������Ĺ���Ȧid   
   --
   -- ������չ��Ϣ
   --
   frelation_name                varchar2(40),              -- ��ϵ������
   ffamily_relation_id           varchar2(32),              -- ��ϵ�˹�ϵID
   ffamily_relation_name         varchar2(30),              -- ��ϵ�˹�ϵname   
   frelation_phone               varchar2(40),              -- ��ϵ�˵绰
   fis_gov_help                  char(1) default 'N'    not null, -- �Ƿ�����������������
   fgov_help_id                  varchar2(32),              -- ������������id
   fgov_help_name                varchar2(30),              -- ��������������������
   fsubject_disease              varchar2(100),             -- �����������������ƶ��ŷָ�
   fhave_food_allergy            char(1) default 'N'    not null, -- �Ƿ���ʳ�����
   ffood_allergy                 varchar2(200),             -- ʳ�����
   fsubject_food_prohibit        varchar2(100),             -- ����ʳ����ɣ����ƶ��ŷָ�
   fsubject_food_love_id         varchar2(32),              -- ������ʳƫ��id
   fsubject_food_love_name       varchar2(30),              -- ������ʳƫ��name
   fis_meal_help                 char(1) default 'N'    not null, -- �����Ƿ�Э��
   fsubject_type_id              varchar2(32)   not null,   -- ��������id
   fsubject_type_name            varchar2(30)   not null,   -- ����������������
   flunch_box_no                 varchar2(20),              -- ���б��
   fsubject_desc                 varchar2(256),             -- ����ע
   --
   -- �����Ϣ
   --
   fdelive_type                  varchar2(30)   not null,   -- ���ͷ�ʽ  ���͵� SITE  ����  HOME
   fdelive_site_id               varchar2(32)   not null,   -- ���͵ص�id
   fdelive_site_name             varchar2(40)   not null,   -- ���͵ص�����
   foverdraft                    number(8,2)    not null,   -- ���͸֧���
   --
   -- ��������Ϣ
   --
   fcreate_time                  date           not null,   -- ����ʱ��
   fcreate_circle_id             varchar2(32)   not null,   -- ��������Ȧid
   fcreate_team_id               varchar2(32)   not null,   -- ����������id
   fcreate_user_id               varchar2(32)   not null,   -- ��������id
   fcreate_nickname              varchar2(30)   not null,   -- ��������
   --
   -- ע��
   --
   fis_cancel                    char(1) default 'N'  not null, -- �Ƿ�ע��
   fcancel_reason                varchar2(60),              -- ע��ԭ��
   fcancel_date                  date,                      -- ע������ʱ��
   fcancel_user_id               varchar2(32),              -- ע������Աid   
   fcancel_user_name             varchar2(30),              -- ע������Ա����
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_nxft_subject primary key (fsubject_id)
   --
   -- Լ��
   --
);

--
-- ����
--


--
-- �޸����
--
