--
-- ��Ʒ������Ŀ��
--
-- v1.0 2017.03.08
-- author��wing
--
-- ˵��
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_goods_item;
create table  fxp.p_goods_item (
-- +-----------------------------+--------------+-----------+
   fgoods_id                     varchar2(32)   not null,   -- ��ƷID
   fitem_id                      varchar2(32)   not null,   -- �����ƷID
   fquantity                     number(6,0)    not null,   -- ����
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
   constraint pk_p_goods_item primary key (fgoods_id,fitem_id)
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
