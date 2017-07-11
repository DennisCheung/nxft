--
-- �����
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_nation;
create table fxp.p_nation (
-- +-----------------------------+--------------+-----------+
   fnation_id                    varchar2(32)   not null,   -- ����ID
   fnation_code                  varchar2(8)    not null,   -- �������
   fnation_gbcode                varchar2(32),              -- �������
   fnation_name                  varchar2(40)   not null,   -- ��������
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fnation_desc                  varchar2(256),             -- ��ע
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date default sysdate not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date default sysdate not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date default sysdate not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_nation primary key (fnation_id),
   constraint uk_p_nation_code unique (fnation_code)
);

--
-- ͬ���
--

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('01', '01', '01', '����', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('02', '02', '02', '׳��', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('03', '03', '03', '����', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('04', '04', '04', '����', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('05', '05', '05', '����', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('06', '06', '06', 'ά�����', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('07', '07', '07', '����', 'Y', 7, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('08', '08', '08', '������', 'Y', 8, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('09', '09', '09', '�ɹ���', 'Y', 9, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('10', '10', '10', '����', 'Y', 10, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;


