--
-- ���������ֵ��
--
-- v1.0 2015.06.11
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_disease_class;
create table  fxp.p_disease_class (
-- +-----------------------------+--------------+-----------+
   fdisease_class_id             varchar2(32)   not null,   -- ��������ID
   fdisease_class_code           varchar2(8)    not null,   -- �����������
   fdisease_class_name           varchar2(60)   not null,   -- ������������
   fdisease_class_desc           varchar2(256),             -- ������ע
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
   constraint pk_p_disease_class primary key (fdisease_class_id),
   constraint uk_p_disease_class_code unique (fdisease_class_code)
);

--
-- ͬ���
--
