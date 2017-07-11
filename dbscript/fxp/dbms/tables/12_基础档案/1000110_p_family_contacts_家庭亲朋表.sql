--
-- ��ͥ�����
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_family_contacts;
create table  fxp.p_family_contacts (
-- +-----------------------------+--------------+-----------+
   fcontact_id                   varchar2(32)   not null,   -- ��ϵ��id
   fcontact_name                 varchar2(40)   not null,   -- ��ϵ������
   --
   ffamily_id                    varchar2(32)   not null,   -- ��ͥID�� 
   ffamily_relation_id           varchar2(32)   not null,   -- ��ͥ����ϵID
   ffamily_relation_name         varchar2(30)   not null,   -- ��ͥ����ϵname
   -- fregion_id                 varchar2(32),              -- ��������ID�����а���ʡ���С������ֵ��������ĸ������룩
   -- fregion_name               varchar2(80),              -- ������������
   faddress                      varchar2(200),             -- ��ϸ��ַ���ֵ�֮�����ϸ��ַ�� 
   fcontact_phone                varchar2(40),              -- ��ϵ�绰
   fmobile                       varchar2(40),              -- �ֻ�
   fuser_id                      varchar2(32),              -- �û�id
   fis_emergency                 char(1)        not null,   -- �Ƿ������ϵ�� Y/N
   -- fordernum                  number(6,2)    not null,   -- �����
   fcontact_desc                 varchar2(256),             -- ��ע
   fcreate_date                  date           not null,   -- ����ʱ��
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
   constraint pk_p_family_contacts primary key (fcontact_id),
   constraint uk_p_family_contacts unique (ffamily_id,fcontact_name)
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
create index idx_p_family_contacts_user on fxp.p_family_contacts(fuser_id);

--
-- �޸���ʷ��
--
