--
-- ����㾭Ӫ��Χ��
--
-- v1.0 2016.08.04
-- author��wing
--
-- ˵��
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_site_scope;
create table  fxp.p_site_scope (
-- +-----------------------------+--------------+-----------+
   fsupplier_id                  varchar2(32)   not null,   -- �����ķ�����id
   fsite_id                      varchar2(32)   not null,   -- �����id
   fproduct_subclass_id          varchar2(32)   not null,   -- �����Ʒ�ӷ���ID
   fproduct_class_id             varchar2(32)   not null,   -- �����Ʒ����ID
   fdesc                         varchar2(256),             -- ��ע
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
   constraint pk_p_site_scope primary key (fsite_id,fproduct_subclass_id)
   --
   -- Լ��
   --
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
-- �޸����
--
