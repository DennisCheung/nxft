--
-- ��ͥ��������
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
-- V1.1 add  by hgr 2015.04.20     fSITE_id            varchar2(32),              -- [V1.1]������̻�id 
-- V1.1 add  by hgr 2015.04.20     fSITE_name          varchar2(100),             -- [V1.1]������̻�name
--
--
-- Drop Table fxp.p_family_life;
create table  fxp.p_family_life (
-- +-----------------------------+--------------+-----------+
   flife_id                      varchar2(32)   not null,   -- ����id
   fcontact_name                 varchar2(100)  not null,   -- ��ϵ������, ���̼ҵ�����
   --
   ffamily_id                    varchar2(32)   not null,   -- ��ͥID�� 
   flife_item_id                 varchar2(32)   not null,   -- ������Ҫ������ĿID
   flife_item_name               varchar2(60)   not null,   -- ������Ҫ������Ŀ����
   faddress                      varchar2(100),             -- ��ϸ��ַ
   fcontact_phone                varchar2(40),              -- ��ϵ�绰
   -- fsite_id                   varchar2(32),              -- [V1.1]������̻�id
   -- fsite_name                 varchar2(100),             -- [V1.1]������̻�name
   -- fordernum                  number(6,2)    not null,   -- �����
   fcontact_desc                 varchar2(256),             -- ��ע
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
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
   constraint pk_p_family_life primary key (flife_id)
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
create index idx_file_family_life1 on fxp.file_family_life(ffamily_id);


--
-- �޸���ʷ��
--
