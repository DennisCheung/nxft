--
-- ����Ա��ַ��Ϣ�ղؼ�
--
-- v1.0 2017.03.23
-- author��wing
--
-- ˵��
--
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_favorite_region;
create table  fxp.p_favorite_region (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�ID
   fregion_id                    varchar2(32)   not null,   -- ��������ID
   fregion_name                  varchar2(80)   not null,   -- ������������   
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
   constraint pk_p_favorite_region primary key (fuser_id)
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
