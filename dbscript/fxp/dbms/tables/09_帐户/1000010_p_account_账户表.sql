--
-- �˻���
--
-- v1.0 2016.08.30
-- author��wing
--
-- ˵����
-- 
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_account ;
Create Table  fxp.p_account (
-- +-----------------------------+--------------+-----------+
   --
   -- �˻���Ϣ
   --
   faccount_id                   varchar2(32)   not null,   -- �˻�id
   faccount_name                 varchar2(50)   not null,   -- �˻���
   fbalance_cash                 number(12,2)   default 0 not null,      -- �����˻����
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
   constraint pk_p_account primary key (faccount_id)
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


