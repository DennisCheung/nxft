--
-- �����Ŷӱ�
--
-- v1.0 2015.11.04
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_todo_team;
Create Table  fxp.p_todo_team (
-- +-----------------------------+--------------+-----------+
   --
   -- ���䲿����Ϣ
   --
   ftodo_id                      varchar2(32)   not null,   -- ����id
   fcreate_time                  date           not null,   -- ����ʱ��
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   fteam_id                      varchar2(32)   not null,   -- ������id
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
   constraint pk_p_todo_team primary key (ftodo_id,fcircle_id,fteam_id)
);


--
--����
--

--
-- �޸���䣺
--
