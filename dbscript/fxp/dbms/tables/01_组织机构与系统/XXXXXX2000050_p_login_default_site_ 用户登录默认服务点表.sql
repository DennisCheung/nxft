--
-- �û���¼Ĭ�Ϸ�����
--
-- v1.0 2016.11.16
-- author��wing
--
-- ˵����
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_login_default_site;
Create Table  fxp.p_login_default_site (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- ����Աid
   fsubsys_id                    varchar2(32)   not null,   -- Ӧ����ϵͳid ����
   forg_id                       varchar2(32)   not null,   -- ����id
   fsite_id                      varchar2(32)   not null,   -- �����id
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
   constraint pk_p_login_default_site primary key (fuser_id,fsubsys_id)
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
