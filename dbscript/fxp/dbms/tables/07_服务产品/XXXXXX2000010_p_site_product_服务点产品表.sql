--
-- ������Ʒ��
--
-- v1.0 2016.08.23
-- author��wing
--
-- ˵��
--
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_site_product;
create table  fxp.p_site_product (
-- +-----------------------------+--------------+-----------+
   fproduct_id                   varchar2(32)   not null,   -- �����ƷID
   fproduct_name                 varchar2(50)   not null,   -- �����Ʒ����
   fproduct_subclass_id          varchar2(32)   not null,   -- �����Ʒ�ӷ���ID
   fproduct_class_id             varchar2(32)   not null,   -- �����Ʒ����ID
   fproduct_info                 varchar2(200),             -- ��Ʒ��Ϣ   
   --   
   fproduct_price                number(8,2),               -- �۸�
   fupdate_price                 char(1)        not null,   -- �Ƿ������޸ļ۸�
   fproduct_unit                 varchar2(10)   not null,   -- ��λ
   --
   fsupplier_id                  varchar2(32)   not null,   -- �����ķ�����id
   fsite_id                      varchar2(32)   not null,   -- �����ķ����id
   fcreate_date                  date default sysdate not null, -- ����ʱ�� 
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fuse_coupon                   char(1)        not null,   -- �Ƿ����ȯ��
   fproduct_desc                 varchar2(256),             -- ��ע
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
   constraint pk_p_site_product primary key (fproduct_id)
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
create index fxp.idx_p_site_product_supp on fxp.p_site_product (fsite_id);

--
-- �޸����
--
