--
-- ������
--
-- v1.0 2016.08.12
-- author��wing
-- ˵����
--
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_site;
Create Table  fxp.p_site (
-- +-----------------------------+--------------+-----------+
   fsite_id                      varchar2(32)   not null,   -- �����id
   fsite_name                    varchar2(100)  not null,   -- ���������
   fsite_info                    varchar2(500),             -- �������
   forg_id                       varchar2(32)   not null,   -- �����Ļ���id
   fservice_scope_desc           varchar2(500),             -- ����Χ   
   fregion_id                    varchar2(32),              -- ��������ID
   fregion_name                  varchar2(80),              -- ������������
   faddress                      varchar2(200),             -- ��ϸ��ַ
   -- fservice_radius            number(6,2)    not null,   -- ����뾶
   -- flatitude                  number(9,6),               -- γ��ֵ
   -- flongitude                 number(9,6),               -- ����ֵ
   fadmin_user_id                varchar2(32)   not null,   -- �����곤
   fcontact_mobile               varchar2(30)   not null,   -- ��ϵ�ֻ�
   fsite_desc                    varchar2(256),             -- ����㱸ע    
-- +-----------------------------+--------------+-----------+
   --
   -- ��ͨ
   --
   fcreate_date                   date default sysdate not null, -- �������ڣ�¼��ʱ��������ڣ� 
   fcreate_user_id                varchar2(32)  not null,    -- ��������Աid
   fcreate_user_name              varchar2(50)  not null,    -- ��������Ա����
   --
   -- ע��
   --
   fis_cancel                    char(1) default 'N'  not null, -- �Ƿ�ע��
   fcancel_reason                varchar2(300),              -- ע��ԭ��
   fcancel_date                  date,                      -- ע������ʱ��
   fcancel_user_id               varchar2(32),              -- ע������Աid   
   fcancel_user_name             varchar2(30),              -- ע������Ա����   
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0       not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_site primary key (fsite_id),
   constraint uk_p_site_org unique (forg_id,fsite_id)
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


-- ���ݸ���

