--
-- ����ҽ�Ʊ���������ϵ
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_person_medical;
create table  fxp.p_person_medical (
-- +-----------------------------+--------------+-----------+
   fregister_id                  varchar2(32)   not null,   -- �Ǽ�id
   fperson_id                    varchar2(32)   not null,   -- ����ID��
   --
   fhospital_name                varchar2(60),              -- ҽ�ƻ�������
   fdoctor_name                  varchar2(40),              -- ҽ������
   fcontact_phone                varchar2(40),              -- ��ϵ�绰
   fmedical_item                 varchar2(80),              -- ��������/������Ŀ 
   fmedical_treatment_id         varchar2(32),              -- ҽ�ƴ���id
   fmedical_treatment_name       varchar2(30),              -- ҽ�ƴ�������
   --
   fordernum                     number(6,2)    not null,   -- �����
   fregister_desc                varchar2(256),             -- ��ע
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
   constraint pk_p_person_medical primary key (fregister_id)
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
create index idx_file_person_medical1 on fxp.file_person_medical(fperson_id);

--
-- �޸���ʷ��
--
