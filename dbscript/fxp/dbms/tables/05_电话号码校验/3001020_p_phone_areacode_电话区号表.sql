--
-- �绰���ű�
--
--
-- v1.0 2015.03.25
-- author��wing
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_phone_areacode ;
create table  fxp.p_phone_areacode (
-- +-----------------------------+--------------+-----------+
   farea_code                    varchar2(20)   not null,   -- ����
   fregion_id                    varchar2(32)   not null,   -- ��������ID
   farea_desc                    varchar2(256),             -- ��ע
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
   constraint pk_p_phone_areacode primary key (farea_code)
);

--
-- ͬ���
--
insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('020', '2951', '', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0660', '3036', '��β', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0662', '3046', '����', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0663', '3067', '����', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0668', '3011', 'ï��', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0750', '2995', '����', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0751', '2965', '�ع�', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0752', '3023', '����', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0753', '3028', '÷��', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0754', '4389', '��ͷ', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0755', '2974', '����', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0756', '2980', '�麣', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0757', '2990', '��ɽ', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0758', '4400', '����', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0759', '3002', 'տ��', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0760', '3061', '��ɽ', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0762', '3040', '��Դ', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0763', '3050', '��Զ', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0766', '3074', '�Ƹ�', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0768', '3062', '����', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0769', '3060', '��ݸ', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));



commit ;

