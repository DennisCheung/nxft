--
-- ȯ���ͱ�
--
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
-- Drop Table fxp.p_coupon_type ;
Create Table  fxp.p_coupon_type (
-- +-----------------------------+--------------+-----------+
   fcoupon_type_id               varchar2(32)   not null,   -- ȯ����id
   fcoupon_type_name             varchar2(40)   not null,   -- ȯ��������
   fcoupon_class                 varchar2(30)   not null,   -- ȯ����  ����   ��Ŀȯ  ��ʱȯ  ����ȯ  
   fcoupon_money                 number(10,2)   default 0 not null,    -- ȯ���
   fcoupon_unit                  varchar2(30),              -- ��λ
   fcoupon_desc                  varchar2(256),             -- ȯ��˵��
   -- fis_limit_product          char(1) default 'N'  not null, -- ʹ���Ƿ����Ʒ����Ʒ  
   -- fis_limit_site             char(1) default 'N'  not null, -- ʹ���Ƿ����Ʒ����
   --
   -- ������Ӫ��
   --
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id   
   --
   -- ����
   --
   fcreate_date                  date           not null,   -- ����ʱ��  
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_nickname              varchar2(30)   not null,   -- ��������Ա����      
   --
   -- ȡ��
   --
   fis_cancel                    char(1) default 'N'  not null, -- �Ƿ�ע��
   fcancel_reason                varchar2(100),             -- ע��ԭ��
   fcancel_date                  date,                      -- ע��ʱ��
   fcancel_user_id               varchar2(32),              -- ע������Աid
   fcancel_nickname              varchar2(40),              -- ע������Ա����   
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
   constraint pk_p_coupon_type primary key (fcoupon_type_id),
   constraint ck_p_coupon_type_class   check (fcoupon_class in ('��Ŀȯ','��ʱȯ','����ȯ'))
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
