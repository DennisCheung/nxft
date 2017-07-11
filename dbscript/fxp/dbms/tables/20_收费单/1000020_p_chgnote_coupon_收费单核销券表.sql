--
-- �շѵ�����ȯ��
--
-- v1.0 2016.11.03
-- author��wing
--
-- ˵����
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_chgnote_coupon ;
Create Table  fxp.p_chgnote_coupon (
-- +-----------------------------+--------------+-----------+
   fchgnote_id                   varchar2(32)   not null,   -- �շѵ�id   
   fcoupon_id                    varchar2(32)   not null,   -- ȯid
   fcoupon_no                    varchar2(30)   not null,   -- ȯ���
   --
   -- ȯ����
   --
   fcoupon_type_id               varchar2(32)   not null,   -- ȯ����id
   fcoupon_type_name             varchar2(40)   not null,   -- ȯ��������
   fcoupon_money                 number(10,2)   default 0 not null,    -- ȯ���
   fcoupon_unit                  varchar2(30),              -- ��λ
   fcoupon_desc                  varchar2(256),             -- ȯ��˵��
   --
   -- ���
   --
   fcoupon_amount                number(10,2)   default 0 not null,    -- ���
   --
   -- ����
   --
   fcreate_date                  date           not null,   -- ����ʱ��  
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
   constraint pk_p_chgnote_coupon primary key (fchgnote_id,fcoupon_id)
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
create index fxp.idx_p_chgnote_coupon_date on fxp.p_chgnote_coupon(fcreate_date);

