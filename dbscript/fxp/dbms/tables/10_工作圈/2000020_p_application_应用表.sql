--
-- Ӧ�ñ�
--
-- v1.0 2017.02.13
-- author��wing
--
-- 
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_application;
Create Table  fxp.p_application (
-- +-----------------------------+--------------+-----------+
   fapplication_id               varchar2(32)   not null,   -- Ӧ��id
   fapplication_name             varchar2(60)   not null,   -- Ӧ������
   fapplication_main_url         varchar2(300)  not null,   -- Ӧ����url
   fapplication_admin_url        varchar2(300)  not null,   -- Ӧ��ά��url
   fapplication_desc             varchar2(256),             -- ��ע 
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
   constraint pk_p_application primary key (fapplication_id)
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
