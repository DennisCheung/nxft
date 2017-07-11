--
-- ��Ͷ��󼲲���
--
-- v1.0 2017.05.10
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table nxft.nxft_subject_disease;
create table  nxft.nxft_subject_disease (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- ����id
   fdisease_id                   varchar2(32)   not null,   -- ����id
   fdisease_name                 varchar2(40)   not null,   -- ��������
   --
   fsubject_id                   varchar2(32)   not null,   -- ����id
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
   constraint pk_nxft_subject_disease primary key (fpk_id),
   constraint uk_nxft_subject_disease unique (fsubject_id,fdisease_id)
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
