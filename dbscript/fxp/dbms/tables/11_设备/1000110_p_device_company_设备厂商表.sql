--
-- �豸���̱�
--
-- v1.0 2016.10.08
-- author��wing
-- 
--
-- �޸���ʷ��
-- 
--
--  
-- drop table fxp.p_device_company;
create table  fxp.p_device_company (
-- +-----------------------------+--------------+-----------+
   fcompany_id                   varchar2(32)   not null,   -- �豸����_id
   fcompany_code                 varchar2(30)   not null,   -- �豸����_code 
   fcompany_name                 varchar2(30)   not null,   -- �豸��˾
   fcompany_desc                 varchar2(256),             -- ��ע   
   --
   -- ������
   --
   fcreate_date                  date           not null,   -- ����ʱ��  
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_nickname              varchar2(40)   not null,   -- ��������Ա����
   --
   -- ע��
   --
   fis_cancel                    char(1) default 'N'  not null, -- �Ƿ�ע��
   fcancel_reason                varchar2(100),             -- ע��ԭ��
   fcancel_date                  date,                      -- ע������ʱ��
   fcancel_user_id               varchar2(32),              -- ע������Աid
   fcancel_nickname              varchar2(40),              -- ע������Ա����  
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
   constraint pk_p_device_company primary key (fcompany_id),
   constraint uk_p_device_company unique (fcompany_code)
);

--
-- �ⲿ��Լ��
--
--
-- ��Ȩ
--
