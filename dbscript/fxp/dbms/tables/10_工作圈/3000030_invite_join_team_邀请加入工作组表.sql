--
-- ������빤����
--
--
-- v1.0 2017.02.27
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.invite_join_team;
Create Table  fxp.invite_join_team (
-- +-----------------------------+--------------+-----------+
   finvite_id                    varchar2(32)   not null,   -- ����id
   fteam_id                      varchar2(32)   not null,   -- ������id
   fuser_id                      varchar2(32)   not null,   -- �û�id
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   finvite_desc                  varchar2(256),             -- ���뱸ע 
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
   constraint pk_invite_join_team primary key (finvite_id),
   constraint uk_invite_join_team_user unique (fteam_id,fuser_id)
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
