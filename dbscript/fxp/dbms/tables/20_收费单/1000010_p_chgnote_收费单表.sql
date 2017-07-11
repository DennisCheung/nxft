--
-- �շѵ���
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
-- Drop Table fxp.p_chgnote ;
Create Table  fxp.p_chgnote (
-- +-----------------------------+--------------+-----------+
   fchgnote_id                   varchar2(32)   not null,   -- �շѵ�id
   fchgnote_no                   varchar2(30)   not null,   -- �շѵ���
   fchgnote_type                 varchar2(32)   not null,   -- �շѵ����� ����  ORG ����  PERSON ����
   --
   -- ������
   --
   fcreate_subsys_id             varchar2(32)   not null,   -- Ӧ����ϵͳid ����
   fcreate_date                  date           not null,   -- ����ʱ��
   fcreate_org_id                varchar2(32)   not null,   -- ��������id
   fcreate_site_id               varchar2(32)   not null,   -- ���������id
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_nickname              varchar2(30)   not null,   -- ��������Ա����
   --
   -- �ͻ���Ϣ
   --
   fperson_id                    varchar2(32),              -- �ͻ�ID�� 
   fperson_code                  varchar2(32),              -- �ͻ����
   fperson_name                  varchar2(50),              -- �ͻ�����
   --
   -- ������Ӫ��
   --   
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id
-- +-----------------------------+--------------+-----------+    
   --
   -- �˷ѿ���
   --
   frefund_origin                varchar2(32),              -- �˷�ԭ��id
   frefund_reverse               varchar2(32),              -- �˷Ѹ���id
   frefund_id                    varchar2(32),              -- �˷�����id
   --
   -- ���
   --
   fsum_total                    number(10, 2)  not null,   -- �ܽ�=�Ƽ۽�
   fsum_discounted               number(10, 2)  not null,   -- �ۿ۽��(�Żݽ��)
   fsum_payment                  number(10, 2)  not null,   -- �����Ը���� = �ܽ�� - �ۿ۽��   
   fsum_own                      number(10, 2)  not null,   -- �Էѽ��
   fsum_coupon                   number(10, 2)  not null,   -- ȯ�Ľ��
   --
   -- �ɿ��
   --
   fcsreport_id                  varchar2(32)   default 'NONE' -- �ɿ��ID(δ�ɿ�д��'NONE')
                                                not null,
   fcsreport_date                date           not null,      -- �ɿ�����(δ�ɿ�д��10�������)
   --
   fchgnote_desc                 varchar2(256),                -- ��ע   
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
   constraint pk_p_chgnote primary key (fchgnote_id),
   constraint uk_p_chgnote_no unique (fchgnote_no)
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
create index fxp.idx_p_chgnote_date     on fxp.p_chgnote(fcreate_date);
create index fxp.idx_p_chgnote_person   on fxp.p_chgnote(fperson_id);
create index fxp.idx_p_chgnote_csreport on fxp.p_chgnote(fcsreport_id);
create index fxp.idx_p_chgnote_csredate on fxp.p_chgnote(fcsreport_date);