--
-- �豸��
--
-- v1.0 2016.10.08
-- author��wing
--
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_device;
create table  fxp.p_device (
-- +-----------------------------+--------------+-----------+
   fdevice_id                    varchar2(32)   not null,   -- �豸id
   fdevice_type_id               varchar2(32)   not null,   -- �豸����ID
   fdevice_type_name             varchar2(50)   not null,   -- �豸��������
   fcompany_id                   varchar2(32)   not null,   -- �豸����_id
   fcompany_name                 varchar2(30)   not null,   -- �豸����_name
   fdevice_model_id              varchar2(32)   not null,   -- �豸�ͺ�ID
   fdevice_model_name            varchar2(50)   not null,   -- �豸�ͺ�����
   fmax_user                     number(3,0)    not null,   -- �豸����û�����Ĭ��Ϊ1   
   fdevice_sn                    varchar2(32)   not null,   -- �豸���к�
   fdevice_uuid                  varchar2(32),              -- �豸�ڲ�ID
   fproduction_date              date,                      -- ��������
   fpurchase_date                date,                      -- ��������
   fdevice_desc                  varchar2(256),             -- ��ע
   --
   -- ��������Ȧ
   --
   fcircle_id                    varchar2(32),              -- ����Ȧid   
   --
   -- ������
   --
   fcreate_date                  date           not null,   -- ����ʱ��
   fcreate_circle_id             varchar2(32)   not null,   -- ��������Ȧid
   fcreate_team_id               varchar2(32)   not null,   -- ����������id
   fcreate_team_name             varchar2(100)  not null,   -- ��������������
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_nickname              varchar2(40)   not null,   -- ��������Ա����
   --
   -- ʹ��
   --
   fis_used                      char(1) default 'N'  not null, -- �Ƿ�ʹ��
   fused_type                    varchar2(30),              -- ʹ������  ISSUE ����  CANCEL ����
   fused_date                    date,                      -- ʹ��ʱ��
   fused_user_id                 varchar2(32),              -- ʹ�ò���Աid
   fused_nickname                varchar2(40),              -- ʹ�ò���Ա����
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
   constraint pk_p_device primary key (fdevice_id),
   constraint uk_p_device_sn unique (fdevice_sn,fdevice_type_id,fcompany_id,fdevice_model_id)
);

--
-- �ⲿ��Լ��
--
--
-- ����
--
create index fxp.idx_p_device_uuid on fxp.p_device (fdevice_uuid);

