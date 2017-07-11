--
-- ���񼲲���
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_person_disease;
create table  fxp.p_person_disease (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- ����id
   fdisease_id                   varchar2(32)   not null,   -- ����id
   fdisease_name                 varchar2(40)   not null,   -- ��������
   --
   fperson_id                    varchar2(32)   not null,   -- ����ID��
   fordernum                     number(6,2)    not null,   -- �����
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
   constraint pk_p_person_disease primary key (fpk_id),
   constraint uk_p_person_disease unique (fperson_id,fdisease_id)
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
create index idx_p_person_disease1 on fxp.p_person_disease(fperson_id);

--
-- �޸���ʷ��
--
