--
-- ������Ƭ��
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
-- v1.1
--   
-- drop table fxp.p_person_photo;
create table fxp.p_person_photo (
-- +-----------------------------+--------------+-----------+
   fperson_id                    varchar2(32)   not null,   -- �ͻ�id
   ffile_id                      varchar2(200)  not null,   -- �ļ�id
   ffile_name                    varchar2(100)  not null,   -- �ļ���
   ffile_type                    varchar2(10)   not null,   -- �ļ���ʽ��������JPG BMP PNG)
   fcreate_time                  date           not null,   -- ����ʱ��
   fcreate_desc                  varchar2(256),             -- ������ע
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
   constraint pk_p_person_photo primary key (fperson_id)
   --
   -- Լ��
   --
);


--
-- �ⲿ��Լ��
--

--
-- ��Ȩ
--


--
-- ����
--

 
