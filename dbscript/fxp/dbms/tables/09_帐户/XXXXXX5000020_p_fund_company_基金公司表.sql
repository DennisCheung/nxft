--
-- ����˾��
--
-- v1.0 2016.09.19
-- author��wing
--
-- ˵����
-- 1������Ӫ�̴����������й���Դ�ʽ�
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_fund_company ;
Create Table  fxp.p_fund_company (
-- +-----------------------------+--------------+-----------+
   ffund_company_id              varchar2(32)   not null,   -- ����˾id
   ffund_company_name            varchar2(50)   not null,   -- ����˾����
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id
   fcompany_desc                 varchar2(256),             -- ��ע
   --
   -- ��ϵ��
   --
   fcontact_person               varchar2(30),              -- ��ϵ������
   fcontact_mobile               varchar2(30),              -- ��ϵ���ֻ�
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
   fversion                      number(6)                  -- �汾��
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
   constraint pk_p_fund_company primary key (ffund_company_id)
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


