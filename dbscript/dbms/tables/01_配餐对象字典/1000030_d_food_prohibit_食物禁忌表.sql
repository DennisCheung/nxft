--
-- ʳ����ɱ�
--
-- v1.0 2017.06.01
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table nxft.d_food_prohibit;
create table  nxft.d_food_prohibit (
-- +-----------------------------+--------------+-----------+
   ffood_prohibit_id             varchar2(32)   not null,   -- ʳ�����ID
   ffood_prohibit_code           varchar2(8)    not null,   -- ʳ����ɴ���
   ffood_prohibit_name           varchar2(40)   not null,   -- ʳ���������
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ����뱸ע 
   ffood_prohibit_desc           varchar2(256),             -- ��ע
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
   constraint pk_d_food_prohibit primary key (ffood_prohibit_id)
);

--
-- ͬ���
--
