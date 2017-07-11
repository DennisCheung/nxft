--
-- ȯ��
--
-- v1.0 2016.08.30
-- author��wing
--
-- ˵����
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_coupon ;
Create Table  fxp.p_coupon (
-- +-----------------------------+--------------+-----------+
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
   -- ����
   --
   fduetime_begin                date           not null,   -- ��Ч������
   fduetime_end                  date           not null,   -- ��Ч��ֹ��
   fissue_desc                   varchar2(256),             -- ��ȯ��ע
   --
   --
   --
   fcoupon_from                  varchar2(30)   not null,   -- ��ȯ;��  GROUP ���巢ȯ  PERSON ���˷�ȯ
   --
   -- ���巢ȯ
   --
   factivity_id                  varchar2(32),              -- �id
   fcrowds_id                    varchar2(32),              -- ����id
   fissue_id                     varchar2(32),              -- ����id   
   --
   -- ������Ӫ��
   --   
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id   
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
   --
   -- ����
   --
   fis_used                      char(1) default 'N'  not null, -- �Ƿ񱻺���
   fused_date                    date,                      -- ����ʱ��
   fused_chgnote_id              varchar2(32),              -- �շѵ�id
   fused_org_id                  varchar2(32),              -- ����������id
   fused_site_id                 varchar2(32),              -- ���������id
   fused_user_id                 varchar2(32),              -- ��������Աid
   fused_nickname                varchar2(40),              -- ��������Ա���� 
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
   constraint pk_p_coupon primary key (fcoupon_id),
   constraint uk_p_coupon_no unique (fcoupon_no)
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
create index fxp.idx_p_coupon_used_date on fxp.p_coupon(fused_date);
create index fxp.idx_p_coupon_account on fxp.p_coupon(faccount_id);
create index fxp.idx_p_coupon_chgnote on fxp.p_coupon(fused_chgnote_id);

