--
-- ��������Ա�ǼǱ�
--
-- v1.0 2015.08.13
-- author��wing
--
-- ˵����
-- 1���ǼǾ���
--
--
--
-- �޸���ʷ��b 
--
--
-- Drop Table fxp.p_org_admin;
Create Table  fxp.p_org_admin (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- ����id
   fuser_id                      varchar2(32)   not null,   -- �û�id
   fadmin_desc                   varchar2(256),             -- ��ע
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
   constraint pk_p_org_admin primary key (forg_id,fuser_id)
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
