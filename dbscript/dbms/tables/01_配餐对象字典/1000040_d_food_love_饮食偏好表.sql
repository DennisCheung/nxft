--
-- ��ʳƫ�ñ�
--
-- v1.0 2017.06.01
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table nxft.d_food_love;
create table  nxft.d_food_love (
-- +-----------------------------+--------------+-----------+
   ffood_love_id                 varchar2(32)   not null,   -- ��ʳƫ��ID
   ffood_love_code               varchar2(8)    not null,   -- ��ʳƫ�ô���
   ffood_love_name               varchar2(40)   not null,   -- ��ʳƫ������
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ����뱸ע 
   ffood_love_desc               varchar2(256),             -- ��ע
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
   constraint pk_d_food_love primary key (ffood_love_id)
);

--
-- ͬ���
--
