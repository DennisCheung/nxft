--
-- ����Ȧ
--
-- v1.0 2017.02.13
-- author��wing
--
-- 
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_circle;
Create Table  fxp.p_circle (
-- +-----------------------------+--------------+-----------+
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   fcircle_name                  varchar2(100)  not null,   -- ����Ȧ����
   fcircle_short_name            varchar2(100)  not null,   -- ����Ȧ���
   flogo_id                      varchar2(32),              -- LOGO id
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fboss_id                      varchar2(32)   not null,   -- �ϰ�id
   fcircle_desc                  varchar2(256),             -- ��ע 
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
   constraint pk_p_circle primary key (fcircle_id)
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
