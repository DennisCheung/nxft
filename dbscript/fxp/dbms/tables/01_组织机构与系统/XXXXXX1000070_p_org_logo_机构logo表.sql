--
-- ����logo��
--
-- v1.0 2016.08.18
-- author��
--
-- �޸���ʷ��
--
-- drop table fxp.p_org_logo;
create table  fxp.p_org_logo (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- ����id
   flogo                         blob           not null,   -- ͷ��ͼƬ
   flogo_type                    varchar2(8)    not null,   -- ͷ��ͼƬ����
   flogo_size                    number(8)      not null,   -- ͷ���ֽڴ�С
   flogo_date                    date           not null,   -- ͷ������
-- +-----------------------------+--------------+-----------+
   fversion                      number(6)      not null,   -- �汾��
   --
   -- ������Ψһ��
   --
   constraint pk_p_org_logo primary key (forg_id)
   --
   -- Լ��
   --
);

--
-- ��Ȩ
--

--
-- ����
--

--
-- �޸����
--
