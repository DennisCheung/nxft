--
-- �ײͽ��ɼ�����
--
-- v1.0 2017.05.10
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table nxft.meal_disease;
create table  nxft.meal_disease (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- ����id
   fdisease_id                   varchar2(32)   not null,   -- ����id
   fdisease_name                 varchar2(40)   not null,   -- ��������
   --
   fmeal_id                      varchar2(32)   not null,   -- �ײ�id
   fdisease_desc                 varchar2(256),             -- ��ע
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
   constraint pk_meal_disease primary key (fpk_id),
   constraint uk_meal_disease unique (fmeal_id,fdisease_id)
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
-- �޸���ʷ��
--
