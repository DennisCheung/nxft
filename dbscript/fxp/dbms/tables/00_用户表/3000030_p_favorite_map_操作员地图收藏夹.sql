--
-- ����Ա��ͼ�ղؼ�
--
-- v1.0 2016.12.11
-- author��wing
--
-- ˵��
--
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_favorite_map;
create table  fxp.p_favorite_map (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�ID
   fmap_name                     varchar2(50)   not null,   -- ��ͼname
   flocation_city                varchar2(16),              -- ����
   flocation_address             varchar2(128),             -- ��ַ
   flocation_longitude           number(19,16),              -- ����
   flocation_latitude            number(19,16),              -- γ��
   fcreate_date                  date           not null,   -- ����ʱ��
   fisDefault                    char(1)        not null,   -- �Ƿ�Ĭ��
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
   constraint pk_p_favorite_map primary key (fuser_id,fmap_name)
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
