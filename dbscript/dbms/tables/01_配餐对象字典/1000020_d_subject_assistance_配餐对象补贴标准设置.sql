--
-- ��Ͷ�������׼����
--
-- v1.0 2017.03.27
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table nxft.d_subject_assistance;
create table  nxft.d_subject_assistance (
-- +-----------------------------+--------------+-----------+
   fassistance_id                varchar2(32)   not null,   -- ����id
   fcircle_id                    varchar2(32)   not null,   -- �ͻ������Ĺ���Ȧid
   fsubject_type_id              varchar2(32)   not null,   -- ��������ID
   fmeal_type_id                 varchar2(32)   not null,   -- �ͱ�����id
   fassistance_model             varchar2(30)   not null,   -- ����ģʽ RADIO ����  FEE ���
   fassistance_ratio             number(3,2),               -- ��������
   fassistance_fee               number(6,2),               -- �������
   fassistance_desc              varchar2(256),             -- ��ע
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
   constraint pk_d_subject_assistance primary key (fassistance_id),
   constraint uk_d_subject_assistance unique (fcircle_id,fsubject_type_id,fmeal_type_id)
);

--
-- ͬ���
--

--
-- ����
--
