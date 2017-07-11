--
-- ���������޸���־��
--
-- v1.0 2015.02.14
-- author��wing
--
-- �޸���ʷ��
--
-- v1.1
--   
-- drop table fxp.p_person_uplog;
create table  fxp.p_person_uplog (
-- +-----------------------------+--------------+-----------+
   fuplog_id                     varchar2(32)   not null,   -- ��־ID
   fperson_id                    varchar2(32)   not null,   -- ����ID�� 
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
   constraint pk_p_person_uplog primary key (fuplog_id)
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
 create index fxp.idx_file_person_uplog1 on fxp.file_person_uplog(fperson_id);
 create index fxp.idx_file_person_uplog2 on fxp.file_person_uplog(fsdatetime);
--
-- �޸����
--
