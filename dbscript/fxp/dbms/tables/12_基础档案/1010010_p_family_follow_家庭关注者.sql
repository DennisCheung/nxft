--
-- ��ͥ��ע��
--
-- v1.0 2016.10.08
-- author��wing
--
-- ˵��
-- 
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_family_follow;
create table  fxp.p_family_follow (
-- +-----------------------------+--------------+-----------+
   ffamily_id                    varchar2(32)   not null,   -- ��ͥid
   fuser_id                      varchar2(32)   not null,   -- �û�ID
   fcreate_date                  date           not null,   -- ����ʱ��   
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
   constraint pk_p_family_follow primary key (ffamily_id,fuser_id)
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
