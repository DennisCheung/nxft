--
-- ��ϵͳ������
--
-- v1.0 2015.08.13
-- author��wing
--
-- ˵����
-- 1��ϵͳά�������� ƽ̨ϵͳά��������ϵͳά��
--
--
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_subsys_org;
Create Table  fxp.p_subsys_org (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- ����id
   fsubsys_id                    varchar2(32)   not null,   -- Ӧ����ϵͳid ����
   fdesc                         varchar2(256),             -- ��ע
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
   constraint pk_p_subsys_org primary key (forg_id,fsubsys_id)
);


--
-- ����
--


--
-- �޸���䣺
--
