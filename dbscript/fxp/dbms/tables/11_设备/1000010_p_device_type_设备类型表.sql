--
-- �豸���ͱ�
--
-- v1.0 2016.09.10
-- author��wing
-- 
--
-- �޸���ʷ��
-- 
--
--  
-- drop table fxp.p_device_type;
create table  fxp.p_device_type (
-- +-----------------------------+--------------+-----------+
   fdevice_type_id               varchar2(32)   not null,   -- �豸����_id   ����  WRISTBAND �ֻ�  CALL ������ TEH ��λ�ֱ�
   fdevice_type_name             varchar2(50)   not null,   -- �豸��������
   fdevice_type_desc             varchar2(256),             -- ��ע   
   --
   -- ������
   --
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
   constraint pk_p_device_type primary key (fdevice_type_id)
);

--
-- �ⲿ��Լ��
--
--
-- ��Ȩ
--
