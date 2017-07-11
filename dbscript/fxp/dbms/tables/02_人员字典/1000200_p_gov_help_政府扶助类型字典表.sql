--
-- �������������ֵ��
--
-- v1.0 2017.06.01
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_gov_help;
create table  fxp.p_gov_help (
-- +-----------------------------+--------------+-----------+
   fgov_help_id                  varchar2(32)   not null,   -- ��������ID
   fgov_help_code                varchar2(8)    not null,   -- �������ʹ���
   fgov_help_name                varchar2(40)   not null,   -- ������������
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N 
   fgov_help_desc                varchar2(256),             -- ��ע
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
   constraint pk_p_gov_help primary key (fgov_help_id),
   constraint uk_p_gov_help_code unique (fgov_help_code)
);

--
-- ͬ���
--
