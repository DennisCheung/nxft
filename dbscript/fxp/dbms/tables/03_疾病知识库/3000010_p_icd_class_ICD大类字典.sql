--
-- ICD�����ֵ��
--
-- v1.0 2015.06.11
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_icd_class;
create table  fxp.p_icd_class (
-- +-----------------------------+--------------+-----------+
   ficd_class_id                 varchar2(32)   not null,   -- ICD����ID
   ficd_class_code               varchar2(8)    not null,   -- ICD��������
   ficd_class_name               varchar2(60)   not null,   -- ICD���������
   ficd_class_desc               varchar2(256),             -- ICD��ע
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
   constraint pk_p_icd_class primary key (ficd_class_id),
   constraint uk_p_icd_class_code unique (ficd_class_code)
);

--
-- ͬ���
--
