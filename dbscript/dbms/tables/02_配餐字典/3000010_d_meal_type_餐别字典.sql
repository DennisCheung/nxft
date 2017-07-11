--
-- �ͱ��ֵ�
--
-- v1.0 2017.03.27
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table nxft.d_meal_type;
create table  nxft.d_meal_type (
-- +-----------------------------+--------------+-----------+
   fmeal_type_id                 varchar2(32)   not null,   -- �ͱ�����id
   fmeal_type_name               varchar2(40)   not null,   -- �ͱ���������
   --
   -- �µ�ʱ�����
   --
   fmeal_time                    varchar2(4)    not null,   -- �Ͳ�ʱ��  24YYMM
   forder_before                 number(2)      not null,   -- �µ���ǰСʱ�� 
   forder_rule_desc              varchar2(256),             -- ��������  ����  ����8��00ǰ���ɵ�������               
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fmeal_type_desc               varchar2(256),             -- ��ע
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
   constraint pk_d_meal_type primary key (fmeal_type_id)
);

--
-- ͬ���
--

--
-- ����
--
