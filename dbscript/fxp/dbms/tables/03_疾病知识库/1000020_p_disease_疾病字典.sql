--
-- �����ֵ��
--
-- v1.0 2015.06.11
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_disease;
create table  fxp.p_disease (
-- +-----------------------------+--------------+-----------+
   fdisease_id                   varchar2(32)   not null,   -- ����ID
   fdisease_code                 varchar2(20)   not null,   -- ��������
   fdisease_name                 varchar2(100)  not null,   -- ��������
   fdisease_class_id             varchar2(32)   not null,   -- ��������ID
   fdisease_class_name           varchar2(60)   not null,   -- ��������NAME
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ�����
   fisdisease                    char(1)        not null,   -- �Ƿ����伲�� Y/N���ɹ����뼲��ʱѡ��
   fis_hg_use                    char(1)        not null,   -- ����ָ���Ƿ����
   fis_sf_use                    char(1)        not null,   -- �ط��Ƿ����
   fis_hmo_use                   char(1)        not null,   -- ��������Ƿ����   
   fdisease_desc                 varchar2(256),             -- ��ע
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
   constraint pk_p_disease primary key (fdisease_id),
   constraint uk_p_disease_code unique (fdisease_code)
);

--
-- ͬ���
--

