--
-- �����Ʒ�ӷ����
--
-- v1.0 2015.08.04
-- author��wing
--
-- ˵��
-- 1�������Ʒ��������
-- 2�����ߺͷ����Ʒ�ӷ���ҹ�
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_product_subclass;
create table  fxp.p_product_subclass (
-- +-----------------------------+--------------+-----------+
   fproduct_subclass_id          varchar2(32)   not null,   -- �����Ʒ�ӷ���ID
   fproduct_subclass_code        varchar2(8)    not null,   -- �����Ʒ�ӷ������
   fproduct_subclass_name        varchar2(40)   not null,   -- �����Ʒ�ӷ�������
   fproduct_class_id             varchar2(32)   not null,   -- �����Ʒ����ID
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fproduct_subclass_desc        varchar2(256),             -- ��ע
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
   constraint pk_p_product_subclass primary key (fproduct_subclass_id),
   constraint uk_p_product_subclass unique (fproduct_subclass_code)
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
