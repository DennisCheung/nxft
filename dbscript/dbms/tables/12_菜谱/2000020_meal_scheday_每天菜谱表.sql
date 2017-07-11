--
-- ÿ����ױ�
--
-- v1.0 2017.04.29
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table nxft.meal_scheday;
Create Table  nxft.meal_scheday (
-- +-----------------------------+--------------+-----------+
   fschedule_id                  varchar2(32)   not null,   -- ����id
   --
   -- ��������
   --
   fkitchen_circle_id            varchar2(32)   not null,   -- ����Ȧid
   fkitchen_team_id              varchar2(32)   not null,   -- ����teamid
   --
   -- �Ű�
   --
   fschenote_id                  varchar2(32)   not null,   -- �Ű൥id
   fmeal_date                    date           not null,   -- �Ͳ�����
   fweek                         number(1)      not null,   -- �ܼ�
   fmeal_type_id                 varchar2(32)   not null,   -- �ͱ�ID
   fmeal_type_name               varchar2(40)   not null,   -- �ͱ�����
   fmeal_id                      varchar2(32)   not null,   -- �ײ�id
   fmeal_code                    varchar2(30)   not null,   -- �ײ�CODE
   fmeal_name                    varchar2(40)   not null,   -- �ײ�����
   fmeal_content                 varchar2(60)   not null,   -- �ײ�����
   fmeal_price                   number(4,2)    not null,   -- ����
   fschedule_desc                varchar2(256),             -- ��ע
   --
   -- ����
   --
   fis_published                 char(1)        not null,   -- �Ƿ��ѷ����� Y/N
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
   constraint pk_meal_scheday primary key (fschedule_id),
   constraint uk_meal_scheday unique (fmeal_date,fmeal_type_id,fmeal_id)
   --
   -- Լ��
   --
);

--
-- ����
--

--
-- �޸����
--
