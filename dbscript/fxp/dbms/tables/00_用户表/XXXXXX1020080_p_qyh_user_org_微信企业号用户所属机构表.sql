--
-- ΢����ҵ���û�����������
--
-- v1.0 2016.08.12
-- author��wing
--
-- ˵��
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_qyh_user_org;
create table  fxp.p_qyh_user_org (
-- +-----------------------------+--------------+-----------+
   fqyh_user_id                  varchar2(64)   not null,   -- ΢����ҵ��user id
   forg_id                       varchar2(32)   not null,   -- ����ID     
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
   constraint pk_p_qyh_user_org primary key (fqyh_user_id,forg_id)
   --
   -- Լ��
   --
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

--
-- �޸����
--
