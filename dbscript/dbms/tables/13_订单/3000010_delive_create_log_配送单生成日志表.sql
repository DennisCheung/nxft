--
-- ���͵�������־��
--
-- v1.0 2017.05.05
-- author��wing
--
-- ˵����
-- 1�� 
--
-- 
--
-- �޸���ʷ��
--
-- Drop Table nxft.delive_create_log;
Create Table  nxft.delive_create_log (
-- +-----------------------------+--------------+-----------+
   flog_id                       varchar2(32)   not null,   -- ��־id
   --
   -- ���ɿ���
   --
   fmeal_date                    date           not null,   -- �Ͳ�����
   fmeal_type_id                 varchar2(32)   not null,   -- �ͱ�ID
   fcreate_time                  date           not null,   -- ����ʱ��
   flog_desc                     varchar2(256),             -- ��ע      
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
   constraint pk_delive_create_log primary key (flog_id),
   constraint uk_delive_create_log unique (fmeal_date,fmeal_type_id)
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
--���� 
--


--
-- �޸���䣺
--

