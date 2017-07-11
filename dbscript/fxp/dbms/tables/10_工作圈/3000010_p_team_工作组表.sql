--
-- �������
--
-- v1.0 2017.02.13
-- author��wing
--
-- 
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_team;
Create Table  fxp.p_team (
-- +-----------------------------+--------------+-----------+
   fteam_id                      varchar2(32)   not null,   -- ������id
   fteam_name                    varchar2(100)  not null,   -- ����������
   fapplication_id               varchar2(32)   not null,   -- Ӧ��id
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   fregion_id                    varchar2(32),              -- ��������ID
   fregion_name                  varchar2(80),              -- ������������
   faddress                      varchar2(200),             -- ��ϸ��ַ
   fcontact_person               varchar2(30),              -- ��ϵ��
   fcontact_mobile               varchar2(30),              -- ��ϵ�ֻ�
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fteam_desc                    varchar2(256),             -- ��ע 
-- +-----------------------------+--------------+-----------+
   --
   -- ������
   --
   fcreate_time                  date default sysdate not null, -- ����ʱ�� 
   fcreate_user_id               varchar2(32)  not null,   -- ��������Աid
   fcreate_user_name             varchar2(50)  not null,   -- ��������Ա����
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
   constraint pk_p_team primary key (fteam_id),
   constraint uk_p_team_circle unique (fteam_id,fcircle_id),
   constraint uk_p_team_name unique (fteam_name,fcircle_id)
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
