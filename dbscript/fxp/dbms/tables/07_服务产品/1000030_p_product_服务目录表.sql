--
-- ����Ŀ¼��
--
-- v1.0 2017.03.08
-- author��wing
--
-- ˵��
--
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_product;
create table  fxp.p_product (
-- +-----------------------------+--------------+-----------+
   fproduct_id                   varchar2(32)   not null,   -- ����Ŀ¼ID
   fproduct_name                 varchar2(50)   not null,   -- ����Ŀ¼����
   fproduct_info                 varchar2(200),             -- ��Ʒ��Ϣ
   fproduct_class_id             varchar2(32)   not null,   -- �����Ʒ����ID
   fproduct_subclass_id          varchar2(32)   not null,   -- �����Ʒ�ӷ���ID
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
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
   constraint pk_p_product primary key (fproduct_id)
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
