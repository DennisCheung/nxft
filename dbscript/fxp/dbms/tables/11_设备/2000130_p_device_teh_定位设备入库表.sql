--
-- ��λ�豸����
--
-- v1.0 2016.11.07
-- author��alex
--
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_device_teh;
create table  fxp.p_device_teh (
-- +-----------------------------+--------------+-----------+
   fdevice_id                    varchar2(32)   not null,   -- �豸id
   fcompany_id                   varchar2(32)   not null,   -- �豸����_id
   fcompany_name                 varchar2(30)   not null,   -- �豸����_name
   fdevice_model_id              varchar2(32)   not null,   -- �豸�ͺ�ID
   fdevice_model_name            varchar2(50)   not null,   -- �豸�ͺ�����
   fdevice_sn                    varchar2(32)   not null,   -- �豸���кţ����ݰ��ð�װ���ϵĶ�ά�룬������֤�豸�ӿڣ�/api/device/validate��ʱ�õ� 
   fdevice_imei                  varchar2(32)   not null,   -- �豸�ڲ�ID�����ݰ��ó���֤�豸�ӿ���������ӿڣ��������Ϊ�豸ID������
   fproduction_date              date,                      -- ��������
   fpurchase_date                date,                      -- ��������
   fdevice_desc                  varchar2(256),             -- ��ע
   --
   -- ������Ӫ��
   --
   fcircle_id                   varchar2(32),               -- ����Ȧid   
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
   constraint pk_p_device_teh primary key (fdevice_id),
   constraint uk_p_device_teh unique (fdevice_sn,fcompany_id,fdevice_model_id)
);

--
-- �ⲿ��Լ��
--
--
-- ����
--
create index fxp.p_device_teh_imei on fxp.p_device_teh(fdevice_imei);

