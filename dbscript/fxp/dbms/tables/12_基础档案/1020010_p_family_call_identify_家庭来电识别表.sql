--
-- ��ͥ����ʶ���
--
-- v1.0 2016.10.09
-- author��wing
--
-- ˵��
--
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_family_call_identify;
create table  fxp.p_family_call_identify (
-- +-----------------------------+--------------+-----------+
   fphone_number                 varchar2(30)   not null,   -- �绰����
   ffamily_id                    varchar2(32)   not null,   -- ��ͥid
   fis_default                   char(1) default 'Y'  not null, -- �Ƿ�Ĭ��
   fcreate_date                  date           not null,   -- ����ʱ��
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
   constraint pk_p_family_call_identify primary key (fphone_number,ffamily_id)
   --
   -- Լ��
   --
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

--
-- �޸����
--
