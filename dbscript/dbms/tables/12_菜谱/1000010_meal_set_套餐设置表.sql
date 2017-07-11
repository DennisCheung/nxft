--
-- �ײ����ñ�
--
-- v1.0 2017.04.29
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table nxft.meal_set;
Create Table  nxft.meal_set (
-- +-----------------------------+--------------+-----------+
   fmeal_id                      varchar2(32)   not null,   -- �ײ�id
   fmeal_code                    varchar2(30)   not null,   -- �ײ�CODE
   fmeal_name                    varchar2(40)   not null,   -- �ײ�����
   fmeal_content                 varchar2(60)   not null,   -- �ײ�����
   ftaboo_disease                varchar2(100),             -- ���ɼ��������ƶ��ŷָ�
   fpeppery_level                number(1),                 -- ����
   fmeal_price                   number(4,2)    not null,   -- ����
   fphoto_id                     varchar2(32),              -- ����ͼƬid
   fkitchen_circle_id            varchar2(32)   not null,   -- ����Ȧid
   fkitchen_team_id              varchar2(32)   not null,   -- ����teamid
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fmeal_desc                    varchar2(256),             -- ��ע   
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
   constraint pk_meal_set primary key (fmeal_id),
   constraint uk_meal_set unique (fkitchen_team_id,fmeal_code)
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
