--
-- ���װ��ŵ���
--
-- v1.0 2017.04.29
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table nxft.meal_schenote;
Create Table  nxft.meal_schenote (
-- +-----------------------------+--------------+-----------+
   fschenote_id                  varchar2(32)   not null,   -- �Ű൥id
   fschenote_desc                varchar2(256),             -- �Ű൥��ע   
   --
   -- ��������
   --
   fkitchen_circle_id            varchar2(32)   not null,   -- ����Ȧid
   fkitchen_team_id              varchar2(32)   not null,   -- ����teamid
   --
   -- �Ű�
   --
   fbegin_date                   date           not null,   -- �Ű���ʼ����=��������ֹ���� + 1
   fend_date                     date           not null,   -- �Ű���ֹ����
   fperiod_model                 varchar2(20)   not null,   -- �Ű�����ģʽ WEEK �� MONTH ��
   --
   -- ������Ϣ
   --
   fcreate_time                  date           not null,   -- ����ʱ��
   fcreate_user_id               varchar2(32)   not null,   -- ��������id
   fcreate_nickname              varchar2(30)   not null,   -- ��������
   --
   -- ������Ϣ
   --   
   fis_published                 char(1)        not null,   -- �Ƿ��ѷ����� Y/N
   fpublish_time                 date,                      -- ����ʱ��
   fpublish_user_id              varchar2(32),              -- ��������id
   fpublish_nickname             varchar2(30),              -- ��������
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
   constraint pk_meal_schenote primary key (fschenote_id)
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
