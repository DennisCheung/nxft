--
-- �û�ͷ���
--
-- v1.0 2015.11.09
-- author��yw
--
-- �޸���ʷ��
--
-- drop table fxp.p_user_photo;
create table  fxp.p_user_photo (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�id
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
   constraint pk_p_user_photo primary key (fuser_id)
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
