--
-- �ڽ������ֵ��
--
-- v1.0 2017.03.15
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_religion;
create table  fxp.p_religion (
-- +-----------------------------+--------------+-----------+
   freligion_id                  varchar2(32)   not null,   -- �ڽ�����ID
   freligion_code                varchar2(8)    not null,   -- �ڽ���������
   freligion_name                varchar2(40)   not null,   -- �ڽ���������
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   freligion_desc                varchar2(256),             -- ��ע
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
   constraint pk_p_religion primary key (freligion_id),
   constraint uk_p_religion_code unique (freligion_code)
);

--
-- ͬ���
--
