--
-- �û�ǩ����
--
-- v1.0 2015.11.09
-- author��wing
--
-- �޸���ʷ��
--
-- drop table fxp.p_user_signature;
create table  fxp.p_user_signature (
-- +-----------------------------+--------------+-----------+
   fsignature_id                 varchar2(32)   not null,   -- ǩ��id
   fuser_id                      varchar2(32)   not null,   -- �û�id
   fsignature_content            varchar2(500)  not null,   -- ǩ������
   fsignature_date               date           not null,   -- ǩ��ʱ��
-- +-----------------------------+--------------+-----------+
   fversion                      number(6)      not null,   -- �汾��
   --
   -- ������Ψһ��
   --
   constraint pk_p_user_signature primary key (fsignature_id)
   --
   -- Լ��
   --
);

--
-- ��Ȩ
--

--
-- ����
--

--
-- �޸����
--
