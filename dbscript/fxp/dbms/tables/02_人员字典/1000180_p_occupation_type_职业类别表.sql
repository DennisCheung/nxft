--
-- ְҵ����
--
-- v1.0 2017.03.15
-- author��wing
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_occupation_type;
create table  fxp.p_occupation_type (
-- +-----------------------------+--------------+-----------+
   foccupation_type_id           varchar2(32)   not null,   -- ְҵ���ID
   foccupation_type_code         varchar2(30)   not null,   -- ְҵ������
   foccupation_type_name         varchar2(40)   not null,   -- ְҵ�������
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   foccupation_type_desc         varchar2(256),             -- ��ע
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
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
   constraint pk_p_occupation_type primary key (foccupation_type_id),
   constraint uk_p_occupation_type_code unique (foccupation_type_code)
);

--
-- ͬ���
--
