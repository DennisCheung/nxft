--
-- ����ȯ���ѵķ��񹹳ɱ�
--
--
-- v1.0 2017.03.30
-- author��wing
--
-- ˵����
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_voucher_compose ;
Create Table  fxp.p_voucher_compose (
-- +-----------------------------+--------------+-----------+
   fcompose_id                   varchar2(32)   not null,   -- ����ID
   fvoucher_id                    varchar2(32)   not null,  -- ȯid
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
   constraint pk_p_voucher_compose primary key (fcompose_id),
   constraint uk_p_voucher_compose unique (fvoucher_id,fproduct_id)
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


