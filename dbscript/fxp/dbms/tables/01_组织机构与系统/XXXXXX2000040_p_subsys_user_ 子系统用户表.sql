--
-- ��ϵͳ�û���
--
-- v1.0 2015.05.31
-- author��wing
--
-- ˵����
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_subsys_user;
Create Table  fxp.p_subsys_user (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- ����id
   fdept_id                      varchar2(32)   not null,   -- ����id
   fsubsys_id                    varchar2(32)   not null,   -- Ӧ����ϵͳid ����
   fuser_id                      varchar2(32)   not null,   -- ����Աid
   fdesc                         varchar2(256),             -- ��ע
-- +-----------------------------+--------------+-----------+
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
   constraint pk_p_subsys_user primary key (forg_id,fdept_id,fsubsys_id,fuser_id)
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
-- �޸���䣺
--
