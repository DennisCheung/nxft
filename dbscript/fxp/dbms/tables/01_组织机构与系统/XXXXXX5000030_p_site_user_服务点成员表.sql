--
-- ������Ա��
--
-- v1.0 2016.08.12
-- author��wing
-- ˵����
--
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_site_user;
Create Table  fxp.p_site_user (
-- +-----------------------------+--------------+-----------+
   fsite_id                      varchar2(32)   not null,   -- �����id
   fuser_id                      varchar2(32)   not null,   -- �û�id
-- +-----------------------------+--------------+-----------+
   --
   -- ��ͨ
   --
   fcreate_date                   date default sysdate not null, -- �������ڣ�¼��ʱ��������ڣ� 
   fcreate_user_id                varchar2(32)  not null,    -- ��������Աid
   fcreate_user_name              varchar2(50)  not null,    -- ��������Ա����
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0       not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_site_user primary key (fsite_id,fuser_id)
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
