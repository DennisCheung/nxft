--
-- ������
--
-- v1.0 2015.10.02
-- author��wing
--
-- ˵����
-- 
--
--
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_org;
Create Table  fxp.p_org (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- ����id
   forg_name                     varchar2(50)   not null,   -- ��������
   forg_digital_number           number(10)     not null,   -- �������ֱ��  ͨ��Ʊ�ݺ�����
   fdomain_name                  varchar2(50),              -- ������Ψһ
   fadmin_user_id                varchar2(32)   not null,   -- ����������Ա�û�
   forg_desc                     varchar2(256),             -- ��ע
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
   constraint pk_p_org primary key (forg_id),
   constraint uk_p_org_num unique (forg_digital_number)
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


