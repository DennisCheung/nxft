--
-- ��Ʒ���ɱ�
--
-- v1.0 2017.03.08
-- author��wing
--
-- ˵��
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_goods_compose;
create table  fxp.p_goods_compose (
-- +-----------------------------+--------------+-----------+
   fcompose_id                   varchar2(32)   not null,   -- ����ID
   fgoods_id                     varchar2(32)   not null,   -- ��ƷID
   fproduct_id                   varchar2(32)   not null,   -- ����Ŀ¼ID
   fpercent                      number(4,1)    not null,   -- ��ռ�ٷֱ�
   ffloating                     number(4,1)    not null,   -- �����ٷֱ� 
   fcompose_desc                 varchar2(256),             -- ��ע
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
   constraint pk_p_goods_compose primary key (fgoods_id,fproduct_id)
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
