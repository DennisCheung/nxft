--
-- ����Ȧ����ǩԼ
--
-- v1.0 2017.04.29
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table nxft.d_circle_kitchen;
create table  nxft.d_circle_kitchen (
-- +-----------------------------+--------------+-----------+
   fsign_id                      varchar2(32)   not null,   -- ǩԼid
   fcircle_id                    varchar2(32)   not null,   -- �����Ĺ���Ȧid
   fkitchen_circle_id            varchar2(32)   not null,   -- ����Ȧid
   fkitchen_team_id              varchar2(32)   not null,   -- ����teamid
   fdelive_fee                   number(4,2)    not null,   -- ���ͷ�
   fkitchen_desc                 varchar2(256),             -- ��ע
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
   constraint pk_d_circle_kitchen primary key (fsign_id),
   constraint uk_d_circle_kitchen unique (fcircle_id,fkitchen_team_id)
);

--
-- ͬ���
--

--
-- ����
--
