--
-- ��Ͷ���ʳ����ɱ�
--
-- v1.0 2017.06.01
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table nxft.nxft_subject_food_prohibit;
create table  nxft.nxft_subject_food_prohibit (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- ����id
   ffood_prohibit_id             varchar2(32)   not null,   -- ʳ�����id
   ffood_prohibit_name           varchar2(40)   not null,   -- ʳ���������
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ����뱸ע 
   --
   fsubject_id                   varchar2(32)   not null,   -- ����id
   ffood_prohibit_desc           varchar2(256),             -- ��ע
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
   constraint pk_nxft_subject_food_prohibit primary key (fpk_id),
   constraint uk_nxft_subject_food_prohibit unique (fsubject_id,ffood_prohibit_id)
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
