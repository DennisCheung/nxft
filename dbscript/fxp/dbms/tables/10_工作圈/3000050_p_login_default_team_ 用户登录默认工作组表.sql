--
-- �û���¼Ĭ�Ϲ������
--
-- v1.0 2017.06.06
-- author��wing
--
-- ˵����
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_login_default_team;
Create Table  fxp.p_login_default_team (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- ����id
   fuser_id                      varchar2(32)   not null,   -- ����Աid
   fapplication_id               varchar2(32)   not null,   -- Ӧ��id
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   fteam_id                      varchar2(32)   not null,   -- ������id
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
   constraint pk_p_login_default_team primary key (fpk_id),
   constraint uk_p_login_default_team unique (fuser_id,fapplication_id)
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
