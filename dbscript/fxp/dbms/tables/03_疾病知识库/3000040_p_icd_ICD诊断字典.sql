--
-- ICD����ֵ�
--
-- v1.0 2015.06.11
-- author��wing
--
-- �޸���ʷ��
-- ɾ����icd����ƥ�䲡��
--
--
-- drop table fxp.p_icd;
create table  fxp.p_icd (
-- +-----------------------------+--------------+-----------+
   fdiag_code                    varchar2(20)   not null,   -- ҽԺ��ϴ���
   fdiag_name                    varchar2(100)  not null,   -- �������
   fdiag_class                   varchar2(10)   not null,   -- ����ҽ������WM ��ҽ,TCM ��ҽ
   fdisease_class_id             varchar2(32)   not null,   -- ��������ID
   fdiag_level                   number(1)      not null,   -- ��ϼ��� 1 �½� 2 �� ���� K35-K38 3 С��  4 ��ϸ
   ftree_id                      varchar2(32)   not null,   -- Ŀ¼��ID
   fdiag_system                  varchar2(10)   not null,   -- ��ϴ��������ϵ��ICD10��ICPC��TCM
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fdiag_desc                    varchar2(256),             -- ��ע
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
   constraint pk_p_icd primary key (fdiag_code)
);

--
-- ͬ���
--
