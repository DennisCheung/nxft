--
-- �������ϸ��
--
--
-- v1.0 2016.08.30
-- author��wing
--
-- ˵����1����Լ��һ���ͻ���һ�λ��ֻ�ܲμ�һ����Ⱥ
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_crowds_list ;
Create Table  fxp.p_crowds_list (
-- +-----------------------------+--------------+-----------+
   fcrowds_id                    varchar2(32)   not null,   -- ����id
   --
   -- �˻���Ϣ
   --
   fperson_id                    varchar2(32)   not null,   -- �ͻ�ID
   fperson_no                    varchar2(30)   not null,   -- �ͻ����   
   fperson_name                  varchar2(50)   not null,   -- ��������
   fsex_name                     varchar2(30),              -- �Ա�����
   fbirth_date                   date,                      -- ��������, ����ͨ���������ڼ������
   fperson_mobile                varchar2(30),              -- �����ֻ�
   fid_no                        varchar2(30),              -- ֤����ţ����֤��
   --
   -- �˺�
   --
   faccount_id                   varchar2(32)   not null,   -- �˻�id
   --
   -- �
   --  
   factivity_id                  varchar2(32)   not null,   -- �id
   --
   -- ������Ӫ��
   --
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id
   flist_desc                    varchar2(256),             -- ��ע
   --
   -- ����
   --
   fcreate_date                  date           not null,   -- ����ʱ��  
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
   constraint pk_p_crowds_list primary key (faccount_id,factivity_id)
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


