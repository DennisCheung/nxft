--
-- ��ȯ���
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
-- Drop Table fxp.p_coupon_activity ;
Create Table  fxp.p_coupon_activity (
-- +-----------------------------+--------------+-----------+
   factivity_id                  varchar2(32)   not null,   -- �id
   factivity_name                varchar2(100)  not null,   -- �����
   factivity_desc                varchar2(256),             -- ��ע
   --
   -- ��ȯ
   --
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id   
   --
   -- ����
   --
   fcreate_date                  date           not null,   -- ����ʱ��
   fcreate_org_id                varchar2(32)   not null,   -- ��������id
   fcreate_site_id               varchar2(32)   not null,   -- ���������id  
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_nickname              varchar2(30)   not null,   -- ��������Ա����
   --
   -- ��ȯ
   --
   fis_issued                    char(1)        not null,   -- �Ƿ��ѷ���
   fissue_date                   date,                      -- ����ʱ��
   fissue_user_id                varchar2(32),              -- ���Ų���Աid
   fissue_nickname               varchar2(30),              -- ���Ų���Ա����         
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
   constraint pk_p_coupon_activity primary key (factivity_id)
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
create index fxp.idx_p_coupon_activity_cdate on fxp.p_coupon_activity(fcreate_date);
create index fxp.idx_p_coupon_activity_operator on fxp.p_coupon_activity(foperator_id);

