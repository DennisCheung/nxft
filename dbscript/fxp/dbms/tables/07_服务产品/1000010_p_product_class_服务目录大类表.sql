--
-- ��������
--
-- v1.0 2015.08.04
-- author��wing
--
-- ˵��
-- 1���������ϼ����������Ʒ�ڶ࣬���ṩ����ĳ����ڶ࣬�ƶ�ͳһ�Ĳ�ƷĿ¼�ǳ����ѡ�
-- 2�������Ʒ���������������ࡢ�����ӷ���
-- 3��ͨ���ƶ�����ϵͳͨ�õķ����Ʒ���࣬�������Ϸ������߲��;���Ĳ�Ʒ��Ʒ�󶨣�ֱ�Ӻͷ����Ʒ�ӷ���󶨡�
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_product_class;
create table  fxp.p_product_class (
-- +-----------------------------+--------------+-----------+
   fproduct_class_id             varchar2(32)   not null,   -- �������ID
   fproduct_class_code           varchar2(8)    not null,   -- ����������
   fproduct_class_name           varchar2(40)   not null,   -- �����������
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fproduct_class_desc           varchar2(256),             -- ��ע
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
   constraint pk_p_product_class primary key (fproduct_class_id),
   constraint uk_p_product_class unique (fproduct_class_code)
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
