--
-- ����Ա��ͥ��Ϣ�ղؼ�
--
-- v1.0 2016.09.11
-- author��wing
--
-- ˵��
--
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_favorite_family;
create table  fxp.p_favorite_family (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�ID
   ffamily_id                    varchar2(32)   not null,   -- ��ͥid
   ffamily_member                varchar2(100),             -- ��ͥ��Ա
   fcreate_date                  date           not null,   -- ����ʱ��
   ffavorite_desc                varchar2(256),             -- ��ע
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
   constraint pk_p_favorite_family primary key (fuser_id,ffamily_id)
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
