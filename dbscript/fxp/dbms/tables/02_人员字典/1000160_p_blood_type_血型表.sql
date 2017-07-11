--
-- Ѫ�ͱ�ABO Ѫ��,���� Rh Ѫ�� (1 RH����, 2 RH����, 9 RHѪ�Ͳ��� )
--
-- v1.0 2015.01.12
-- author��wing
-- 
--
-- drop table fxp.p_blood_type;
create table  fxp.p_blood_type (
-- +-----------------------------+--------------+-----------+
   fblood_type_id                varchar2(32)   not null,   -- Ѫ��ID
   fblood_type_code              varchar2(8)    not null,   -- Ѫ�ʹ���
   fblood_type_gbcode            varchar2(32),              -- ������� 1 A,2 B,3 O, 4 AB, 9 ����
   fblood_type_name              varchar2(40)   not null,   -- Ѫ������
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fblood_type_desc              varchar2(256),             -- ��ע
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
   constraint pk_p_blood_type primary key (fblood_type_id),
   constraint uk_p_blood_type_code unique (fblood_type_code)
);

--
-- �ⲿ��Լ��
--
--
-- ��Ȩ
--
grant select on p_blood_type to public;

--
-- �޸����
--

insert into p_blood_type (FBLOOD_TYPE_ID, FBLOOD_TYPE_CODE, FBLOOD_TYPE_GBCODE, FBLOOD_TYPE_NAME, FISAVAILABLE, FORDERNUM, FBLOOD_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', 'A', 'Y', 1.00, 'A', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_blood_type (FBLOOD_TYPE_ID, FBLOOD_TYPE_CODE, FBLOOD_TYPE_GBCODE, FBLOOD_TYPE_NAME, FISAVAILABLE, FORDERNUM, FBLOOD_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', 'B', 'Y', 2.00, 'B', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_blood_type (FBLOOD_TYPE_ID, FBLOOD_TYPE_CODE, FBLOOD_TYPE_GBCODE, FBLOOD_TYPE_NAME, FISAVAILABLE, FORDERNUM, FBLOOD_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', 'O', 'Y', 3.00, 'O', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_blood_type (FBLOOD_TYPE_ID, FBLOOD_TYPE_CODE, FBLOOD_TYPE_GBCODE, FBLOOD_TYPE_NAME, FISAVAILABLE, FORDERNUM, FBLOOD_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('04', '04', '04', 'AB', 'Y', 4.00, 'AB', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

commit;
