--
-- �˻�������ˮ��
--
-- v1.0 2017.05.06
-- author��wing
--
-- ˵����
-- 
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_account_list ;
Create Table  fxp.p_account_list (
-- +-----------------------------+--------------+-----------+
   flist_id		                   varchar2(32)   not null,   -- ������ˮ��
   --
   -- ������Ϣ
   --
   faccount_id                   varchar2(32)   not null,   -- �˻�id
   flist_type                    varchar2(30)   not null,   -- ��������id ����  ��ֵ  ����   ����
   flist_amount                  number(12,2)   not null,		-- ���׽��(�������� �����)
   flist_summary                 varchar2(50)   not null,   -- ����ժҪ
   forder_id                     varchar2(32),              -- ����id
   flist_desc                    varchar2(256),             -- ��ע 
-- +-----------------------------+--------------+-----------+
   --
   -- ������
   --
   fcreate_time                  date default sysdate not null, -- ����ʱ��
   fcreate_application_id        varchar2(32)  not null,   -- Ӧ��id
   fcreate_user_id               varchar2(32)  not null,   -- ��������Աid
   fcreate_user_name             varchar2(50)  not null,   -- ��������Ա����   
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
   constraint pk_p_account_list primary key (flist_id)
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
 create index fxp.idx_p_account_list_account on fxp.p_account_list(faccount_id);
 create index fxp.idx_p_account_list_time on fxp.p_account_list(fcreate_time);
