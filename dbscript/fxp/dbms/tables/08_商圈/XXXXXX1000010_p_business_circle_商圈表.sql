--
-- ��Ȧ
--
-- v1.0 2016.08.27
-- author��wing
--
-- 
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_business_circle;
Create Table  fxp.p_business_circle (
-- +-----------------------------+--------------+-----------+
   fbusiness_circle_id           varchar2(32)   not null,   -- ��Ȧid
   fbusiness_circle_name         varchar2(60)   not null,   -- ��Ȧ����
   fbusiness_circle_info         varchar2(300),             -- ��Ȧ���
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id
   fcall_center_id               varchar2(32)   not null,   -- ��������id  ->fxp.p_site.fsite_id
   fcircle_desc                  varchar2(256),             -- ��ע 
-- +-----------------------------+--------------+-----------+
   --
   -- ��ͨ
   --
   fcreate_date                  date default sysdate not null, -- �������ڣ�¼��ʱ��������ڣ� 
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
   constraint pk_p_business_circle primary key (fbusiness_circle_id)
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
