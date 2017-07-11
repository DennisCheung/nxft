--
-- ��Ͷ����ס�����
--
-- v1.0 2017.06.01
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table nxft.nxft_subject_living_condi;
create table  nxft.nxft_subject_living_condi (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- ����id
   fliving_condi_id              varchar2(32)   not null,   -- ��ס���ID
   fliving_condi_name            varchar2(40)   not null,   -- ��ס�������
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ����뱸ע 
   --
   fsubject_id                   varchar2(32)   not null,   -- ����id
   fliving_condi_desc            varchar2(256),             -- ��ע
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
   constraint pk_nxft_subject_living_condi primary key (fpk_id),
   constraint uk_nxft_subject_living_condi unique (fsubject_id,fliving_condi_id)
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
