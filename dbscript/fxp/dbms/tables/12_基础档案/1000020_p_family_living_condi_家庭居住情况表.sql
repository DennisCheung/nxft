--
-- ��ͥ��ס�����
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_family_living_condi;
create table  fxp.p_family_living_condi (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- ����id
   fliving_condi_id              varchar2(32)   not null,   -- ��ס���ID
   fliving_condi_name            varchar2(40)   not null,   -- ��ס�������
   --
   ffamily_id                    varchar2(32)   not null,   -- ��ͥid
   fordernum                     number(6,2)    not null,   -- �����
   fliving_condi_desc            varchar2(256),             -- ��ע
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
                                 default 0       not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_family_living_condi primary key (fpk_id),
   constraint uk_p_family_living_condi unique (ffamily_id,fliving_condi_id)
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
create index idx_file_family_living_condi1 on fxp.file_family_living_condi(ffamily_id);

--
-- �޸���ʷ��
--
