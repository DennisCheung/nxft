--
-- ��Ͷ��������ֵ�����
--
-- v1.0 2017.03.27
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table nxft.d_subject_type;
create table  nxft.d_subject_type (
-- +-----------------------------+--------------+-----------+
   fsubject_type_id              varchar2(32)   not null,   -- ��������id
   fsubject_type_code            varchar2(30)   not null,   -- ��������CODE
   fsubject_type_name            varchar2(40)   not null,   -- ������������
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fsubject_type_desc            varchar2(256),             -- ��ע
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
   constraint pk_d_subject_type primary key (fsubject_type_id),
   constraint uk_d_subject_type_code unique (fsubject_type_code)
);

--
-- ͬ���
--

--
-- ����
--
