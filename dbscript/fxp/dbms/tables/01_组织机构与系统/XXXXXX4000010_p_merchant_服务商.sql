--
-- �����̣��൱�ڻ��������չ
--
-- v1.0 2015.07.20
-- author��wing
--
-- �������з����̣� P_ORG forg_type=MERCHANT��������չ  ��
-- �޸���ʷ��
--
--
--
--
-- Drop Table fxp.p_merchant;
Create Table  fxp.p_merchant (
-- +-----------------------------+--------------+-----------+
   fmerchant_id                  varchar2(32)   not null,   -- ������id
   fmerchant_name                varchar2(50)   not null,   -- ����������
   fmerchant_fullname            varchar2(100)  not null,   -- ������ȫ��
   fmerchant_info                varchar2(1000),            -- �����̼��
   fservice_class_id             varchar2(32)   not null,   -- ��ҵ����ID   
   fregion_id                    varchar2(32)   not null,   -- ��������ID
   fregion_name                  varchar2(80)   not null,   -- ������������    
   faddress                      varchar2(200),             -- ��ϸ��ַ 
   fmerchant_desc                varchar2(256),             -- ��ע 
   --
   -- ��ϵ��
   --
   fcontact_person               varchar2(30),              -- ��ϵ������
   fcontact_duty                 varchar2(30),              -- ��ϵ��ְλ
   fcontact_mobile               varchar2(30),              -- ��ϵ���ֻ�
   fcontact_email                varchar2(30),              -- ��ϵ������
-- +-----------------------------+--------------+-----------+
   --
   -- ��ͨ
   --
   fcreate_date                  date default sysdate not null, -- �������ڣ�¼��ʱ��������ڣ� 
   fcreate_user_id               varchar2(32)  not null,   -- ��������Աid
   fcreate_user_name             varchar2(50)  not null,   -- ��������Ա����
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
   constraint pk_p_merchant primary key (fmerchant_id)
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


--
-- �޸���䣺
--
