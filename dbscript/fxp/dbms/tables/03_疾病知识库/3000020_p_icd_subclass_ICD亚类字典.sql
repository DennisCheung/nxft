--
-- ICD�����ֵ��
--
-- v1.0 2016.02.16
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_icd_subclass;
create table  fxp.p_icd_subclass (
-- +-----------------------------+--------------+-----------+
   ficd_subclass_id              varchar2(32)   not null,   -- ICD����ID
   ficd_subclass_name            varchar2(80)   not null,   -- ICD��������
   ficd_class_id                 varchar2(32)   not null,   -- ICD����ID
   ficd_subclass_desc            varchar2(256),             -- ��ע
   frefer_disease_id             varchar2(32),              -- ���ռ���ID
   frefer_disease_code           varchar2(20),              -- ���ռ���CODE
   frefer_disease_name           varchar2(100),             -- ���ռ���NAME   
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
   constraint pk_p_icd_subclass primary key (ficd_subclass_id)
);

--
-- ͬ���
--

