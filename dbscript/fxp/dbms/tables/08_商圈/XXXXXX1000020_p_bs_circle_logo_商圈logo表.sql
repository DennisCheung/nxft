--
-- ��Ȧlogo��
--
-- v1.0 2016.08.18
-- author��
--
-- �޸���ʷ��
--
-- drop table fxp.p_bs_circle_logo;
create table  fxp.p_bs_circle_logo (
-- +-----------------------------+--------------+-----------+
   fbusiness_circle_id           varchar2(32)   not null,   -- ��Ȧid
   flogo                         blob           not null,   -- ͷ��ͼƬ
   flogo_type                    varchar2(8)    not null,   -- ͷ��ͼƬ����
   flogo_size                    number(8)      not null,   -- ͷ���ֽڴ�С
   flogo_date                    date           not null,   -- ͷ������
-- +-----------------------------+--------------+-----------+
   fversion                      number(6)      not null,   -- �汾��
   --
   -- ������Ψһ��
   --
   constraint pk_p_bs_circle_logo primary key (fbusiness_circle_id)
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
