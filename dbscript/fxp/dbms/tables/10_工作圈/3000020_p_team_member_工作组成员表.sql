--
-- �������Ա��
--
-- v1.0 2017.02.13
-- author��wing
--
-- 
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_team_member;
Create Table  fxp.p_team_member (
-- +-----------------------------+--------------+-----------+
   fmember_id                    varchar2(32)   not null,   -- ��Աid
   fteam_id                      varchar2(32)   not null,   -- ������id
   fuser_id                      varchar2(32)   not null,   -- �û�id
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   fmember_desc                  varchar2(256),             -- ��ע 
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
   constraint pk_p_team_member primary key (fmember_id),
   constraint uk_p_team_member_user unique (fteam_id,fuser_id)
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
