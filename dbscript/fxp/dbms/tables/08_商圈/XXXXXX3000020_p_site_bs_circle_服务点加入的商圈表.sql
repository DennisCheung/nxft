--
-- �����������Ȧ
--
-- v1.0 2016.08.09
-- author��wing
--
-- ��������Ӫ��֮��Ĺ�ϵ
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_site_bs_circle;
Create Table  fxp.p_site_bs_circle (
-- +-----------------------------+--------------+-----------+
   fsupplier_id                  varchar2(32)   not null,   -- ������id
   fsite_id                      varchar2(32)   not null,   -- �����id
   fbusiness_circle_id           varchar2(32)   not null,   -- ��Ȧid
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id
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
   constraint pk_p_site_bs_circle primary key (fsite_id,fbusiness_circle_id)
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
