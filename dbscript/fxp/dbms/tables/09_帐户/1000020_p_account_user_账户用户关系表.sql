--
-- �˻����û���ϵ��
--
-- v1.0 2017.03.20
-- author��wing
--
-- ˵����
-- 
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_account_user ;
Create Table  fxp.p_account_user (
-- +-----------------------------+--------------+-----------+
   faccount_id                   varchar2(32)   not null,   -- �˻�id
   fuser_id                      varchar2(32)   not null,   -- �û�id
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
   constraint pk_p_account_user primary key (faccount_id),
   constraint uk_p_account_user unique (fuser_id)
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


