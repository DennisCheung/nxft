--
-- ����Ȧlogo��
--
--
-- v1.0 2017.02.24
-- author��
--
-- �޸���ʷ��
--
-- drop table fxp.p_circle_logo;
create table  fxp.p_circle_logo (
-- +-----------------------------+--------------+-----------+
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   ffile_id                      varchar2(200)  not null,   -- �ļ�id
   ffile_name                    varchar2(100)  not null,   -- �ļ���
   ffile_type                    varchar2(10)   not null,   -- �ļ���ʽ��������JPG BMP PNG)
   fcreate_time                  date           not null,   -- ����ʱ��
   fcreate_desc                  varchar2(256),             -- ������ע
-- +-----------------------------+--------------+-----------+
   fversion                      number(6)      not null,   -- �汾��
   --
   -- ������Ψһ��
   --
   constraint pk_p_circle_logo primary key (fcircle_id)
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
