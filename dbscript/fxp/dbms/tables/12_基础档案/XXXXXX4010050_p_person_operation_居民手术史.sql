--
-- ��������ʷ
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_person_operation;
create table  fxp.p_person_operation (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- ����id
   foperation_name               varchar2(40)   not null,   -- ��������
   fhospital_name                varchar2(40),              -- ҽԺ����
   foperation_time               varchar2(50),              -- ʱ��˵��
   --
   fperson_id                    varchar2(32)   not null,   -- ����ID��
   fordernum                     number(6,2)    not null,   -- �����
   foperation_desc               varchar2(256),             -- ��ע
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
   constraint pk_p_person_operation primary key (fpk_id)
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
create index idx_p_person_operation1 on fxp.p_person_operation(fperson_id);

--
-- �޸���ʷ��
--
