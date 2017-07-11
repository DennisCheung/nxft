--
-- ����ȯ��
--
-- v1.0 2017.03.20
-- author��wing
--
-- ˵����
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_voucher ;
Create Table  fxp.p_voucher (
-- +-----------------------------+--------------+-----------+
   fvoucher_id                   varchar2(32)   not null,   -- ȯid
   fvoucher_name                 varchar2(100)  not null,   -- ȯ����
   fvoucher_balance              number(10,2)   default 0 not null,    -- �����
   fduetime_begin                date           not null,   -- ��Ч������
   fduetime_end                  date           not null,   -- ��Ч��ֹ��
   fvoucher_desc                 varchar2(256),             -- ȯ��ע   
   --
   -- ������Ϣ
   --
   forder_id                     varchar2(32)   not null,   -- ����ID   
   fgoods_id                     varchar2(32)   not null,   -- ��Ʒid
   fgoods_name                   varchar2(100)  not null,   -- ��Ʒ����
   fgoods_price                  number(10,2)   not null,   -- ��Ʒ����
   fgoods_unit                   varchar2(30)   not null,   -- ��λ
   fsell_circle_id               varchar2(32)   not null,   -- ��������Ȧid   
   --
   -- �˻�
   --
   faccount_id                   varchar2(32)   not null,   -- �˻�id   
   --
   -- ����
   --
   fcreate_date                  date           not null,   -- ����ʱ��  
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_nickname              varchar2(30)   not null,   -- ��������Ա����
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
   constraint pk_p_voucher primary key (fvoucher_id)
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
create index fxp.idx_p_voucher_account on fxp.p_voucher(faccount_id);

