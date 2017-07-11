--
-- ������Ҫ֢״��
--
-- v1.0 2015.11.17
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_disease_symptom;
create table  fxp.p_disease_symptom (
-- +-----------------------------+--------------+-----------+
   fsymptom_id                   varchar2(32)   not null,   -- ����ID
   --
   -- ֢״
   --
   fdisease_id                   varchar2(32)   not null,   -- ����ID
   fsymptom_code                 varchar2(30)   not null,   -- ֢״CODE
   fsymptom_name                 varchar2(80)   not null,   -- ֢״����
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ�����
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fsymptom_desc                 varchar2(256),             -- ��ע
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
   constraint pk_p_disease_symptom primary key (fsymptom_id),
   constraint uk_p_disease_symptom unique (fdisease_id,fsymptom_code)
);

--
-- ͬ���
--

--
-- ����
--
