--
-- ��ͥ�����޸���־��
--
-- v1.0 2015.02.14
-- author��wing
--
-- �޸���ʷ��
--
-- v1.1
--   
-- drop table fxp.p_family_uplog;
create table  fxp.p_family_uplog (
-- +-----------------------------+--------------+-----------+
   fuplog_id                     varchar2(32)   not null,   -- ��־ID
   ffamily_id                    varchar2(32)   not null,   -- ��ͥID�� 
   --
   -- ������
   --
   fsdatetime                    date           not null,   -- ϵͳ����(��ʱ��)
   fup_user_id                   varchar2(32)   not null,   -- ���²���Աid
   fup_user_name                 varchar2(30)   not null,   -- ���²���Ա����
   --
   -- ���ݱ仯
   --   
   fcolumn_id                    varchar2(40)  not null,    -- ����id
   fcolumn_name                  varchar2(40)  not null,    -- ��������
   foldvalue_id                  varchar2(32),              -- ԭֵid
   fnewvalue_id                  varchar2(32),              -- ��ֵid
   foldvalue_name                varchar2(200),             -- ԭֵ����
   fnewvalue_name                varchar2(200),             -- ��ֵ����   
   fup_desc                      varchar2(256),             -- ��������.
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0      not null,
   --
   -- ������Ψһ��
   --
   constraint pk_p_family_uplog primary key (fuplog_id)
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
 create index fxp.idx_p_family_uplog1 on fxp.p_family_uplog(ffamily_id);
 create index fxp.idx_p_family_uplog2 on fxp.p_family_uplog(fsdatetime);
--
-- �޸����
--
