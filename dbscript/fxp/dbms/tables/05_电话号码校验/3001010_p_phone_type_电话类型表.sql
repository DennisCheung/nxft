--
-- �绰���ͱ�
-- �ñ��¼Ϊ������1,2,3,4 ���������޸ĵ绰У��ģ�顣
--
--
-- v1.0 2015.03.25
-- author��wing
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_phone_type ;
create table  fxp.p_phone_type (
-- +-----------------------------+--------------+-----------+
   fphone_type_id                varchar2(32)   not null,   -- �绰����id
   fphone_type_code              varchar2(8)    not null,   -- �绰���ʹ���
   fphone_type_name              varchar2(40)   not null,   -- �绰��������
   fphone_type_desc              varchar2(256),             -- ��ע
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
                                 default 0       not null,
   flogcby                       varchar2(32)
                                 default 'admin' not null,   -- ������
   flogcdate                     date
                                 default sysdate
                                 not null,   -- ����ʱ��
   flogluby                      varchar2(32)
                                 default 'admin'
                                 not null,   -- ����޸���
   flogludate                    date
                                 default sysdate
                                 not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)
                                 default 'admin'
                                 not null,   -- ��������
   flogladate                    date
                                 default sysdate
                                 not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_phone_type primary key (fphone_type_id),
   constraint uk_p_phone_type_code unique (fphone_type_code)
);

--
-- ͬ���
--

insert into fxp.p_phone_type (FPHONE_TYPE_ID, FPHONE_TYPE_CODE, FPHONE_TYPE_NAME, FPHONE_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1', '1', '�̻�', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into fxp.p_phone_type (FPHONE_TYPE_ID, FPHONE_TYPE_CODE, FPHONE_TYPE_NAME, FPHONE_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('2', '2', '�ֻ�', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into fxp.p_phone_type (FPHONE_TYPE_ID, FPHONE_TYPE_CODE, FPHONE_TYPE_NAME, FPHONE_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('3', '3', '400�绰', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into fxp.p_phone_type (FPHONE_TYPE_ID, FPHONE_TYPE_CODE, FPHONE_TYPE_NAME, FPHONE_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('4', '4', '�ط��绰', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

commit;