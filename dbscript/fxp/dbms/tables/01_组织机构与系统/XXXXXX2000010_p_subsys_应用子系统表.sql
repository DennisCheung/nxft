--
-- Ӧ����ϵͳ��
--
-- v1.0 2015.05.31
-- author��wing
--
-- �޸���ʷ��
--
-- drop table fxp.p_subsys;
create table  fxp.p_subsys (
-- +-----------------------------+--------------+-----------+
   fsubsys_id                    varchar2(32)   not null,   -- Ӧ����ϵͳid ����
   fsubsys_name                  varchar2(60)   not null,   -- Ӧ����ϵͳ����
   fsubsys_url                   varchar2(200)  not null,   -- Ӧ����ϵͳ��ҳ��Ե�ַ
   fis_open_pc                   char(1)        not null,   -- �Ƿ�ͨPC��Ӧ��  Y/N
   fis_open_wechat               char(1)        not null,   -- �Ƿ�ͨ΢�Ŷ�Ӧ�� Y/N
   fsubsys_desc                  varchar2(256),             -- ����
-- +-----------------------------+--------------+-----------+
   fordernum                     number(6,2)    not null,   -- �����
   fversion                      number(6)      not null,   -- �汾��
   --
   -- ������Ψһ��
   --
   constraint pk_p_subsys primary key (fsubsys_id),
   constraint uk_p_subsys unique (fsubsys_name)
   --
   -- Լ��
   --
);

--
-- ��Ȩ
--
grant all on fxp.p_subsys to sf,hbcs;
--
-- ����
--

--
-- �޸����
--

insert into p_subsys (FSUBSYS_ID, FSUBSYS_NAME, FSUBSYS_URL, FSUBSYS_DESC, FORDERNUM, FVERSION)
values ('SF', '�ط���ϵͳ', 'http://localhost:8080/v/sf', '', 1.00, 0);



commit;
