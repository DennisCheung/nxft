--
-- ����ƽ̨��չ�ķ���
--
-- v1.0 2016.01.30
-- author��wing
--
-- �޸���ʷ��
-- 
--  
-- drop table fxp.p_service;
create table  fxp.p_service (
-- +-----------------------------+--------------+-----------+
   fservice_id                   varchar2(32)   not null,   -- ����_id
   fservice_code                 varchar2(30)   not null,   -- ����_code
   fservice_name                 varchar2(50)   not null,   -- ��������
   ffamily_or_person             varchar2(30)   not null,   -- ��ͥ OR ����  ����  FAMILY  PERSON
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fservice_desc                 varchar2(256),             -- ��ע   
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
   constraint pk_p_service primary key (fservice_id),
   constraint uk_p_service unique (fservice_code)
);

--
-- �ⲿ��Լ��
--
--
-- ��Ȩ
--
