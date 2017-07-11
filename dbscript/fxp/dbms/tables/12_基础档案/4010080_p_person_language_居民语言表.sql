--
-- �������Ա�
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_person_language;
create table  fxp.p_person_language (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- ����id
   flanguage_id                  varchar2(32)   not null,   -- ����id
   flanguage_name                varchar2(40)   not null,   -- ��������
   --
   fperson_id                    varchar2(32)   not null,   -- ����ID��
   fordernum                     number(6,2)    not null,   -- �����
   flanguage_desc                varchar2(256),             -- ��ע
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
   constraint pk_p_person_language primary key (fpk_id),
   constraint uk_p_person_language unique (fperson_id,flanguage_id)
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
create index idx_file_person_language1 on fxp.file_person_language(fperson_id);

--
-- �޸���ʷ��
--
