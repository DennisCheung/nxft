--
-- ������ϵ�˱�
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_person_contacts;
create table  fxp.p_person_contacts (
-- +-----------------------------+--------------+-----------+
   fcontact_id                   varchar2(32)   not null,   -- ��ϵ��id
   fcontact_name                 varchar2(40)   not null,   -- ��ϵ������
   --
   fperson_id                    varchar2(32)   not null,   -- ����ID�� 
   fperson_relation_id           varchar2(32)   not null,   -- �ͻ������ϵID
   fperson_relation_name         varchar2(30)   not null,   -- �ͻ������ϵname
   fregion_id                    varchar2(32),              -- ��������ID�����а���ʡ���С������ֵ��������ĸ������룩
   fregion_name                  varchar2(80),              -- ������������
   faddress                      varchar2(200),             -- ��ϸ��ַ���ֵ�֮�����ϸ��ַ��    
   ffixPhone                     varchar2(40),              -- �̶��绰
   fmobile                       varchar2(40),              -- �ֻ�
   fis_emergency                 char(1)        not null,   -- �Ƿ������ϵ�� Y/N
   fordernum                     number(6,2)    not null,   -- �����
   fcontact_desc                varchar2(256),              -- ��ע
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
   constraint pk_p_person_contacts primary key (fcontact_id),
   constraint uk_p_person_contacts unique (fperson_id,fcontact_name)
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
-- �޸���ʷ��
--
