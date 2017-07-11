--
-- ������ȯ���ͱ�
--
--
-- v1.0 2016.08.30
-- author��wing
--
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_crowds_coupon ;
Create Table  fxp.p_crowds_coupon (
-- +-----------------------------+--------------+-----------+
   fissue_id                     varchar2(32)   not null,   -- ����id
   --
   -- ȯ����
   --
   fcoupon_type_id               varchar2(32)   not null,   -- ȯ����id
   fcoupon_type_name             varchar2(40)   not null,   -- ȯ��������
   fcoupon_money                 number(10,2)   default 0 not null,    -- ȯ���
   fcoupon_unit                  varchar2(30),              -- ��λ
   fcoupon_desc                  varchar2(256),             -- ȯ��˵��
   --
   -- ��������Ч��
   --
   fperiod_begin                 date           not null,   -- ��Ч������
   fperiod_end                   date           not null,   -- ��Ч��ֹ��
   famount                       number(6,0)    not null,   -- ��������
   fissue_desc                   varchar2(256),             -- ��ȯ��ע
   --
   -- ��Ⱥ
   --
   fcrowds_id                    varchar2(32)   not null,   -- ����id   
   --
   -- �����
   --
   factivity_id                  varchar2(32)   not null,   -- �id
   --
   -- ������Ӫ��
   --   
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id   
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
   constraint pk_p_crowds_coupon primary key (fissue_id),
   constraint uk_p_crowds_coupon unique (factivity_id,fcrowds_id,fcoupon_type_id)
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
create index fxp.idx_p_crowds_coupon_crowds on fxp.p_crowds_coupon(fcrowds_id);

