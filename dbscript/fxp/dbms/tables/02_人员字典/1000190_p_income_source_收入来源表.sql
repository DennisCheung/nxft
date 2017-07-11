--
-- ������Դ��
--
-- v1.0 2017.03.15
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_income_source;
create table  fxp.p_income_source (
-- +-----------------------------+--------------+-----------+
   fincome_source_id             varchar2(32)   not null,   -- ������ԴID
   fincome_source_code           varchar2(8)    not null,   -- ������Դ����
   fincome_source_name           varchar2(40)   not null,   -- ������Դ����
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fincome_source_desc           varchar2(256),             -- ��ע
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
   constraint pk_p_income_source primary key (fincome_source_id),
   constraint uk_p_income_source_code unique (fincome_source_code)
);

--
-- ͬ���
--
