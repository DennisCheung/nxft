--
-- ������Ŀ��
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
-- drop table fxp.p_item;
create table  fxp.p_item (
-- +-----------------------------+--------------+-----------+
   fitem_id                      varchar2(32)   not null,   -- ������ĿID
   fitem_name                    varchar2(50)   not null,   -- ������Ŀ����
   fproduct_id                   varchar2(32)   not null,   -- ����Ŀ¼ID
   fitem_info                    varchar2(200),             -- ��Ŀ��Ϣ
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fitem_desc                    varchar2(256),             -- ��ע
   --   
   -- �۸�
   --   
   fitem_price                   number(8,2),               -- �۸�
   fupdate_price                 char(1)        not null,   -- �Ƿ������޸ļ۸�
   fitem_unit                    varchar2(20)   not null,   -- ��λ
   fcharge_mode                  varchar2(10)   not null,   -- �Ʒ�ģʽ  ������ ����  ���� ��
   --
   -- ����Ȧ
   --
   fcircle_id                    varchar2(32)   not null,   -- ��������Ȧid���ϼ��ߣ�    
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
   constraint pk_p_item primary key (fitem_id),
   constraint check_p_item_charge_mode  check (fcharge_mode IN ('����','����'))
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
