--
-- �ͻ���ͨ�ķ���Ŀ¼��
--
-- v1.0 2016.11.10
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_person_service;
create table  fxp.p_person_service (
-- +-----------------------------+--------------+-----------+
   fperson_id                    varchar2(32)   not null,   -- �ͻ�ID
   fservice_id                   varchar2(32)   not null,   -- ����id
   fservice_name                 varchar2(50)   not null,   -- ��������
   fservice_begin                date           not null,   -- ����ʼʱ��
   fservice_end                  date           not null,   -- �������ʱ��
   --
   -- ������Ӫ��
   --
   foperator_id                  varchar2(32),              -- ��Ӫ��id      
   --
   -- ����
   --
   fcreate_date                  date           not null,   -- ����ʱ��
   fcreate_org_id                varchar2(32)   not null,   -- ��������id
   fcreate_site_id               varchar2(32)   not null,   -- ���������id
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_nickname              varchar2(40)   not null,   -- ��������Ա����
   fcreate_desc                  varchar2(256),             -- ������ע 
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
   constraint pk_p_person_service primary key (fperson_id,fservice_id)
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
create index fxp.idx_p_person_service_operator on fxp.p_person_service (foperator_id);

--
-- �޸���ʷ��
--
