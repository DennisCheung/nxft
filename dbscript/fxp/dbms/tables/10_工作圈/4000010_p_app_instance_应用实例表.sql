--
-- Ӧ��ʵ��
--
-- v1.0 2017.02.13
-- author��wing
--
-- 
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_app_instance;
Create Table  fxp.p_app_instance (
-- +-----------------------------+--------------+-----------+
   finstance_id                  varchar2(32)   not null,   -- Ӧ��ʵ��id
   finstance_name                varchar2(60)   not null,   -- Ӧ��ʵ������
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   fapplication_id               varchar2(32)   not null,   -- Ӧ��id
   fteam_id                      varchar2(32)   not null,   -- ������id
   finstance_desc                varchar2(256),             -- ��ע 
-- +-----------------------------+--------------+-----------+
   --
   -- ������
   --
   fcreate_time                  date default sysdate not null, -- ����ʱ�� 
   fcreate_user_id               varchar2(32)  not null,   -- ��������Աid
   fcreate_user_name             varchar2(50)  not null,   -- ��������Ա����
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
   constraint pk_p_app_instance primary key (finstance_id),
   constraint uk_p_app_instance unique (fcircle_id,fapplication_id,fteam_id)
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
-- �޸���䣺
--
