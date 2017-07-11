--
-- �����˻���
--
-- v1.0 2016.09.19
-- author��wing
--
-- ˵����
-- 
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_fund ;
Create Table  fxp.p_fund (
-- +-----------------------------+--------------+-----------+
   ffund_id                      varchar2(32)   not null,   -- �����˻�id
   ffund_no                      varchar2(30)   not null,   -- �����˺�
   ffund_user_id                 varchar2(32)   not null,   -- ������id
   ffund_company_id              varchar2(32)   not null,   -- ����˾id
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id
   pamount                       number(9,2)    not null,   -- �˻����
   --
   -- ʹ��
   --
   fis_used                      char(1) default 'N'  not null, -- �Ƿ�ʹ��
   fused_date                    date,                      -- ʹ�û���ʱ��
   fused_user_id                 varchar2(32),              -- ʹ�ò���Աid   
   fused_user_name               varchar2(30),              -- ʹ�ò���Ա����
   fused_desc                    varchar2(256),             -- ʹ�ñ�ע        
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
   constraint pk_p_fund primary key (ffund_id),
   constraint uk_p_fund_no unique (ffund_no)
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


