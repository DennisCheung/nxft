--
-- �û���ǰ������
--
-- v1.0 2016.09.01
-- author��wing
--
-- ˵��
--
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_user_cur_org;
create table  fxp.p_user_cur_org (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�ID
   fcur_org_id                   varchar2(32)   not null,   -- ��ǰ����id
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
   constraint pk_p_user_cur_org primary key (fuser_id)
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
